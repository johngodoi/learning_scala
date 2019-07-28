package com.johngodoi.scala.hackerrank.thirtydays


object Day7 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    for (i <- n-1 to 0 by -1) {
      print(arr(i))
      if(i > 0) print(" ")
    }
  }
}
