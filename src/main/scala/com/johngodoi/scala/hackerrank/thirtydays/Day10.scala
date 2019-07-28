package com.johngodoi.scala.hackerrank.thirtydays

object Day10 {

  def calculateRemainderOf2Power(n:Int,power:Int):Int={
    var remainder = (n%math.pow(2,power)).toInt
    remainder
  }

  def convertDecToBin(n:Int):String = {
    var value = n
    var bin = ""
    for(i <- 20 to 0 by -1){
      var remainder = calculateRemainderOf2Power(value,i)
      var diff = calculateDifference(value, i)
      if(value>=0 && diff>=0){
        value = diff
        bin = bin + "1"
      } else {
        bin = bin + "0"
      }
    }
    //println(bin)
    bin
  }

  private def calculateDifference(value: Int, i: Int) = {
    value - math.pow(2, i).toInt
  }

  def countSequenceOfOnes(bin:String):scala.collection.immutable.List[Int] = {
    var digits = bin.toList
    var firstOne = false
    var countFollowedOnes = 0
    var counts = scala.collection.immutable.List[Int]()
    for(digit <- digits){
      // println(digit)
      if(digit=='1' && !firstOne){
        //println(s"first $digit")
        firstOne = true
        countFollowedOnes = countFollowedOnes+1
      } else if(digit == '1' && firstOne){
        //println(s"other $digit")
        countFollowedOnes = countFollowedOnes+1
      } else {
        //println(s"zero")
        firstOne = false
        counts = countFollowedOnes::counts
        countFollowedOnes = 0
      }
    }
    if(countFollowedOnes>0)
      counts = countFollowedOnes::counts
    counts
  }

  def maxSequenceOfOnesOfBinary(n: Int):Int = {
    countSequenceOfOnes(convertDecToBin(n)).max
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt
    println(maxSequenceOfOnesOfBinary(n))
  }
}
