package com.johngodoi.scala.datastructure

import com.johngodoi.scala.datastructures.{FuncQueue, FuncQueueEmpty, FuncQueueNonEmpty}
import org.scalatest.{FlatSpec, Matchers}

class FuncQueueUnitTest extends FlatSpec with Matchers {

  "Create empty queue" should "have anything" in {
    val empty = FuncQueueEmpty()
    empty.isEmpty shouldBe(true)
    empty.size should be(0)
    empty.remove() should be (FuncQueueEmpty(), None)
  }

  "Create empty queue and insert one element and remove it" should "have anything" in {
    val empty = FuncQueueEmpty[Int]()
    val stack = empty.put(1)
    stack should be (FuncQueueNonEmpty(List(1)))
    stack.isEmpty should be(false)
    stack.asInstanceOf[FuncQueueNonEmpty[Int]].size should be(1)
    stack.remove() should be(FuncQueueEmpty[Int](), Some(1))
  }

  "Create empty queue and insert two elements and remove one" should "have last inserted" in {
    var stack:FuncQueue[Int] = FuncQueueEmpty[Int]()
    stack = stack.put(1)
    stack = stack.put(2)
    stack should be (FuncQueueNonEmpty(List(2,1)))
    stack.isEmpty should be(false)
    stack.asInstanceOf[FuncQueueNonEmpty[Int]].size should be(2)
    stack.remove() should be(FuncQueueNonEmpty[Int](List(2)), Some(1))
  }

}
