package com.johngodoi.scala.hackerrank.thirtydays

import org.scalatest.{FlatSpec, Matchers}

class Day11UnitTest extends FlatSpec with Matchers {
  "Given Matrix" should "find max sum of hour glasses" in {
    val matrix = Array(Array(1,1,1,0,0,0),
      Array(0,1,0,0,0,0),
      Array(1,1,1,0,0,0),
      Array(0,0,2,4,4,0),
      Array(0,0,0,2,0,0),
      Array(0,0,1,2,4,0))
    Day11.maxSumHourGlass(matrix) should be(19)
  }

}
