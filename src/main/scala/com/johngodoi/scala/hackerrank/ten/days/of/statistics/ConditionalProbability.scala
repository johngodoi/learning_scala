package com.johngodoi.scala.hackerrank.ten.days.of.statistics

object ConditionalProbability {
  def main(args: Array[String]): Unit = {
    //Suppose a family has 2 children, one of which is a boy. What is the probability that both children are boys?
    //0 = girl, 1=boy
    val combinationsIncludingAtLeastOneBoy = (0 to 1)
      .flatMap(c => (0 to 1).map(c2 => (c, c2))) // children combinations
      .filter(c => c._1 == 1 || c._2 == 1)//combinations including at least one boy
    val combinationsOfTwoBoys = combinationsIncludingAtLeastOneBoy.filter(c => c._1 == 1 && c._2 == 1)
    println(combinationsOfTwoBoys.length+"/"+combinationsIncludingAtLeastOneBoy.length)
  }
}
