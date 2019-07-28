package com.johngodoi.scala.hackerrank.thirtydays

object Day5 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt
    for(i <- 1 to 10){
      println(s"$n x $i = ${n*i}")
    }
  }
}
