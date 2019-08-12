package com.johngodoi.scala.hackerrank.ten.days.of.statistics

import org.scalatest.{FlatSpec, Matchers}

class InterQuartileRangeUnitTest extends FlatSpec with Matchers {

  "Given values" should "calculate inter-quartile" in {
    InterQuartileRange
      .generateMultiple(
        Array(6,12,8,10,20,16),
        Array(5,4,3,2,1,5)
      ) should contain theSameElementsAs Array(6,6,6,6,6,8,8,8,10,10,12,12,12,12,16,16,16,16,16,20)
    InterQuartileRange.calculateInterQuartile(Array(6,12,8,10,20,16), Array(5,4,3,2,1,5)) should be (9.0)
  }

}
