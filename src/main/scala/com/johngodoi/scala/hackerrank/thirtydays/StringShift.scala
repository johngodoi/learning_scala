package com.johngodoi.scala.hackerrank
import java.io._

import scala.io._


object Result {

  /*
   * Complete the 'getShiftedString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER leftShifts
   *  3. INTEGER rightShifts
   */

  def getShiftedString(s: String, leftShifts: Int, rightShifts: Int): String = {
    var result = s
    val leftRotations = leftShifts % s.length
    val rightRotations = rightShifts % s.length
    if(leftRotations<rightRotations) {
      for (i <- 0 until rightRotations - leftRotations)
        result = rightShift(result)
    } else {
      for(i <- 0 until leftRotations - rightRotations)
        result = leftShift(result)
    }
    result
  }

  private def leftShift(stream: String) = {
    stream.tail+stream.head
  }

  private def rightShift(stream: String) = {
    val last = stream.last
    val substring =  stream.substring(0, stream.length-1)
    last+substring
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val leftShifts = StdIn.readLine.trim.toInt

    val rightShifts = StdIn.readLine.trim.toInt

    val result = Result.getShiftedString(s, leftShifts, rightShifts)

    printWriter.println(result)

    printWriter.close()
  }
}
