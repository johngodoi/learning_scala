package com.johngodoi.scala.hackerrank.thirtydays


object Day3 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val N = stdin.readLine.trim.toInt
    if(N%2!=0) println("Weird")
    else if(N%2==0 && N>1 && N<6) println("Not Weird")
    else if(N%2==0 && N>5 && N<21) println("Weird")
    else if(N%2==0 && N>20) println("Not Weird")
  }

}
