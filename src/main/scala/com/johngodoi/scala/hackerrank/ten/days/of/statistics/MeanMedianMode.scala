package com.johngodoi.scala.hackerrank.ten.days.of.statistics
object MeanMedianMode {

  /**
    * input
    * 10
    * 64630 11735 14216 99233 14470 4978 73429 38120 51135 67060
    * output
    * 43900,6
    * 44627,5
    * 4978
    *
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val qtt = scala.io.StdIn.readInt()
    var array = Array[Int]()
    val numbers = scala.io.StdIn.readLine().split(" ")
    for(i <- 0 until qtt ){
      array = numbers(i).toInt +: array
    }
    val mean = array.sum.toDouble / array.length.toDouble
    println(f"$mean%1.1f")
    val aSorted = array.sorted
    if ((array.length % 2) != 0)
      println(aSorted(array.length/2))
    else {
      val median = (aSorted(array.length / 2).toDouble + aSorted((array.length / 2) - 1).toDouble) / 2
      println(f"$median%1.1f")
    }
    val countElements = array.map(el => (el,1)).groupBy(pair => pair._1).map(pair => (pair._1,pair._2.map(p => p._2).sum))
    val maxCount = countElements.values.max
    println(countElements.filter(pair => pair._2>=maxCount).min._1)
  }
}

