package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object InterQuartileRange {
  def main(args:Array[String]):Unit = {
    val n = scala.io.StdIn.readInt()
    val values = scala.io.StdIn.readLine().split(" ").map(_.toDouble)
    val frequencies = scala.io.StdIn.readLine().split(" ").map(_.toDouble)

    println(f"${calculateInterQuartile(values, frequencies)}%1.1f")
  }

  def calculateInterQuartile(values: Array[Double], frequencies: Array[Double]):Double = {
    val s = generateMultiple(values, frequencies)
    val (q1,q2,q3) = calculateQuartiles(s)
    q3-q1
  }


  def calculateQuartiles(values: Array[Double]): (Double, Double, Double) = {
    val sortedValues = values.sorted
    val q2 = calculateMean(sortedValues)
    val q1 = calculateMean(sortedValues.take(sortedValues.length/2))
    val q3 = calculateMean(sortedValues.takeRight(sortedValues.length/2))
    (q1,q2,q3)
  }

  def calculateMean(sortedValues: Array[Double]) = if(sortedValues.length %2 == 0) {
    (sortedValues(sortedValues.length/2) +
    sortedValues(sortedValues.length/2 - 1))/2
  } else sortedValues(sortedValues.length/2)

  def generateMultiple(values: Array[Double], frequencies: Array[Double]) = {
    var s = Array[Double]()
    for (i <- 0 until values.length) {
      s = (List.fill(frequencies(i).toInt)(values(i))).toArray ++ s
    }
    s
  }
}
