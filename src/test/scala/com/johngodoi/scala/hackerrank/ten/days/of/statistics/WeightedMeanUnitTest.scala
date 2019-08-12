package com.johngodoi.scala.hackerrank.ten.days.of.statistics

import org.scalatest.{FlatSpec, Matchers}

class WeightedMeanUnitTest extends FlatSpec with Matchers {

  "Given values and weights" should "calculate weighted mean" in {
    WeightedMean.calculateWeightedMean(5, Array(10,40,30,50,20), Array(1,2,3,4,5)) should be(32)
  }

}
