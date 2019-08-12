package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object MoreDice {
  def main(args: Array[String]): Unit = {
    val possibleTossResults = (1 to 6).toArray.flatMap(v1 => (1 to 6).toArray.map(v2 => (v1, v2)))
    val differentResultSumLike6 = possibleTossResults.filter(p => p._1 != p._2 && (p._1 + p._2 == 6))
    println(differentResultSumLike6.length+"/"+possibleTossResults.length)
  }
}
