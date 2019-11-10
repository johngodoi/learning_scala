import com.jcraft.jsch.{JSch, Session}
import java.io.PrintStream

trait SSHInstruction {
  def execute(commander: PrintStream):Boolean
}

case class LSInstruction() extends SSHInstruction{
  override def execute(commander: PrintStream) = {
    commander.println("ls")
    true
  }
}

class SshClient(url: String, port: Int, user: String, encryptionKey: String) {

  var session:Session=_

  def getSshConnection() = {
    val jsch = new JSch
    jsch.addIdentity(encryptionKey)
    session = jsch.getSession(user, url, 22)
    session.setConfig("StrictHostKeyChecking", "no")
    session.connect
  }

  def close = {
    session.disconnect()
  }

  def execute(instruction:SSHInstruction) = {
    val channel = session.openChannel("shell")
    val inputstream_for_the_channel = channel.getOutputStream
    val commander = new PrintStream(inputstream_for_the_channel, true)

    channel.setOutputStream(System.out, true)

    channel.connect
    instruction.execute(commander)
    commander.close()
    do Thread.sleep(1000) while ( {
      !channel.isEOF
    })
    channel.disconnect()
  }

}

val sshClient = new SshClient("host", 22, "user", "encryption-key")

sshClient.execute((commander: PrintStream) => {
  commander.println("pwd")
  true
})
sshClient.execute(new LSInstruction)