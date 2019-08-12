package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object BasicProbability {

  def main(args: Array[String]): Unit = {
    val sumPossibleResults = (1 to 6).toArray.flatMap(v => (1 to 6).toArray.map(v2 => (v, v2))).map(p => p._1+p._2)
    val lessThan9 = sumPossibleResults.filter(_ <= 9)
    println(lessThan9.length+"/"+sumPossibleResults.length)
  }

}
