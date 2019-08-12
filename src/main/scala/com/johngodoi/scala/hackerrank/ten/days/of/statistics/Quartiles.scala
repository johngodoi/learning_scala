package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object Quartiles {

  def main(args: Array[String]):Unit = {
    val n = scala.io.StdIn.readInt()
    val values = scala.io.StdIn.readLine().split(" ").map(_.toDouble)

    val (q1: Double, q2: Double, q3: Double) = calculateQuartiles(values)
    println(f"$q1%1.0f")
    println(f"$q2%1.0f")
    println(f"$q3%1.0f")
  }

  def calculateQuartiles(values: Array[Double]) = {
    val sortedValues = values.sorted
    val q2 = calculateMean(sortedValues)
    val middle = sortedValues.length / 2
    val q1 = calculateMean(sortedValues.take(middle))
    val q3 = calculateMean(sortedValues.takeRight(middle))
    (q1, q2, q3)
  }

  def calculateMean(sortedValues: Array[Double]) = {
    val middle = sortedValues.length / 2
    if(sortedValues.length % 2 == 0 ) {
      (sortedValues(middle)+sortedValues(middle-1))/2
    } else {
      sortedValues(middle)
    }
  }
}
