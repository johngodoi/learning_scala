package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object StandardDeviation {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()
    val values = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    val standardDeviation: Double = calculateStandardDeviation(values)
    println(f"$standardDeviation%1.1f")
  }

  def calculateStandardDeviation(values: Array[Double]) = {
    val mean = values.sum / values.length
    val sumSquaredDifferences = values.map(v => v - mean).map(v => v * v).sum
    val standardDeviation = scala.math.sqrt(sumSquaredDifferences / values.length)
    standardDeviation
  }
}
