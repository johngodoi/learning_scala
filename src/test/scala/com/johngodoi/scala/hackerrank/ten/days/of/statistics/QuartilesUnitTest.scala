package com.johngodoi.scala.hackerrank.ten.days.of.statistics

import org.scalatest.{FlatSpec, Matchers}

class QuartilesUnitTest extends FlatSpec with Matchers {

  "Given values" should "calculate quartiles" in {
    Quartiles.calculateMean(Array(3,7,8,5,12,14,21,13,18)) should be (12)
    Quartiles.calculateQuartiles(Array(3,7,8,5,12,14,21,13,18)) should be ((6,12,16))
    Quartiles.calculateQuartiles(Array(4,17,7,14,18,12,3,16,10,4,4,12)) should be ((4,11,15))
  }

}
