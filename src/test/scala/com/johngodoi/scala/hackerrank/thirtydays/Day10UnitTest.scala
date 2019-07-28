package com.johngodoi.scala.hackerrank.thirtydays

import org.scalatest.{FlatSpec, Matchers}

class Day10UnitTest extends FlatSpec with Matchers {
  "Given decimal" should "calculate max sequence of ones" in {
    Day10.maxSequenceOfOnesOfBinary(5) shouldBe 1
    Day10.maxSequenceOfOnesOfBinary(6) shouldBe 2
    Day10.maxSequenceOfOnesOfBinary(13) shouldBe 2
    Day10.maxSequenceOfOnesOfBinary(439) shouldBe 3
    Day10.maxSequenceOfOnesOfBinary(65535) shouldBe 16
  }
}
