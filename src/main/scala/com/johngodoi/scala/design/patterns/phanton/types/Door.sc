/**
  * @see https://medium.com/@maximilianofelice/builder-pattern-in-scala-with-phantom-types-3e29a167e863
  */

trait DoorState
case class Open() extends DoorState
case class Closed() extends DoorState
case class Door(state: DoorState) {
  def open = state match {
    case _: Open => throw new DoorStateException("You cannot open a door thats already open")
    case _ => Door(Open())
  }
  def close = state match {
    case _: Closed => throw new DoorStateException("You cannot close a door thats already closed")
    case _ => Door(Closed())
  }
}

class DoorStateException(message: String) extends Exception





sealed trait SDoorState
sealed trait SOpen extends SDoorState
sealed trait SClosed extends SDoorState

case class SDoor[State <: SDoorState](){
  def open(implicit ev: State =:= SClosed) = SDoor[SOpen]()
  def close(implicit ev: State =:= SOpen) = SDoor[SClosed]()
}
//scala> Door[Open]().open
//<console>:17: error: Cannot prove that Open =:= Closed.

class Context
implicit val context: Context = ???
def methodThatRequiresContext(str: String)(implicit context: Context) = ???

methodThatRequiresContext("foo")