package com.johngodoi.scala.invillia

import org.scalatest.{FlatSpec, Matchers}

class Result2UnitTest extends FlatSpec with Matchers{

  "this" should "do something" in {

    Result2.minNum(2,Array(1,2,3)) should be(2)
    Result2.minNum(4,Array(1,3,4,7)) should be(3)
  }

}
