package com.johngodoi.scala.hackerrank.thirtydays
import java.io._


object Day9 {

  // Complete the factorial function below.
  def factorial(n: Int): Int = {
    if(n==0) 1 else factorial(n-1)*n
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = stdin.readLine.trim.toInt

    val result = factorial(n)

    printWriter.println(result)

    printWriter.close()
  }
}
