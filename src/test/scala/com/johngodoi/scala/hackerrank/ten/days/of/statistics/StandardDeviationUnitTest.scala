package com.johngodoi.scala.hackerrank.ten.days.of.statistics

import org.scalatest.{FlatSpec, Matchers}

class StandardDeviationUnitTest extends FlatSpec with Matchers {

  "Given values" should "calculate standard deviation" in {
    StandardDeviation.calculateStandardDeviation(Array(10,40,30,50,20)) should be (14.1 +- 0.1)
  }

}
