package com.johngodoi.scala.hackerrank.thirtydays

import org.scalatest.{FlatSpec, Matchers}

class Day2UnitTest extends FlatSpec with Matchers {
  "Given input" should "calculate total cost" in {

    Day2.runMain("12.00\n20\n8") == "3"
  }
}
