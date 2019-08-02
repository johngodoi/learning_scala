package com.johngodoi.scala.hackerrank.thirtydays

import com.johngodoi.scala.hackerrank.Result
import org.scalatest.{FlatSpec, Matchers}

class StringShiftUnitTest extends FlatSpec with Matchers{

  "this " should "do something" in {
    Result.getShiftedString("abcd",1,2) should be ("dabc")
  }
}
