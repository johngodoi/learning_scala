package com.johngodoi.scala.bizus

import org.scalatest.{FlatSpec, Matchers}

class PlayWithList extends FlatSpec with Matchers {

  "Everyday I'm appending and prepending" should "do what I want" in {
    val initial = List(1, 2, 3)
    initial:+4 should contain theSameElementsAs List(1,2,3,4)
    4 :: initial should contain theSameElementsAs List(4,1,2,3)
  }

  "I want head and tail, then I want last and the rest" should "do what I want" in {
    val initial = List(1,2,3,4)
    initial.head should be(1)
    initial.tail should contain theSameElementsAs List(2,3,4)
    initial.last should be(4)
    initial.take(initial.length-1) should contain theSameElementsAs List(1,2,3)
  }

}
