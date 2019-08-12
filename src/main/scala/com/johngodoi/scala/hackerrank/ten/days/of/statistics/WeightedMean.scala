package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object WeightedMean {

  def main(args: Array[String]) {
    val n = scala.io.StdIn.readInt()
    val values = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    val weights = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    println(f"${calculateWeightedMean(n, values, weights)}%1.1f")
  }

  def calculateWeightedMean(n: Int, values: Array[Double], weights: Array[Double]) = {
    var multWeighted = 0d
    for (i <- 0 until n) {
      multWeighted = multWeighted + values(i) * weights(i)
    }
    multWeighted / (weights.sum)
  }
}