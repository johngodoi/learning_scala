package com.johngodoi.scala.datastructure

import com.johngodoi.scala.datastructures.{FuncStack, FuncStackEmpty, FuncStackNonEmpty}
import org.scalatest.{FlatSpec, Matchers}


class StackUnitTest extends FlatSpec with Matchers {

  "Create an empty Stack" should "doesn't fill with anything" in {
    val stack = FuncStackEmpty()
    stack.isEmpty should be(true)
  }

  "Insert in an empty Stack" should "fill a stack with one element" in {
    var stack:FuncStack[Int] = FuncStackEmpty[Int]()
    stack.isEmpty should be(true)
    stack = stack.push(1)
    stack should be (FuncStackNonEmpty[Int](FuncStackEmpty[Int](), 1, 1))
    stack.isEmpty should be(false)
    stack.asInstanceOf[FuncStackNonEmpty[Int]].size should be(1)
    stack.asInstanceOf[FuncStackNonEmpty[Int]].element should be(1)
  }

  "Insert in two element into an empty Stack" should "fill a stack with two element" in {
    var stack:FuncStack[Int] = FuncStackEmpty[Int]()
    stack = stack.push(1)
    stack = stack.push(23)
    stack should be (FuncStackNonEmpty[Int](FuncStackNonEmpty[Int](FuncStackEmpty[Int](), 1, 1), 23, 2))
    stack.isEmpty should be(false)
    stack.asInstanceOf[FuncStackNonEmpty[Int]].size should be(2)
    stack.asInstanceOf[FuncStackNonEmpty[Int]].element should be(23)
  }

  "Remove an element from a Stack with two elements" should "fill a stack with two element" in {
    val stack:FuncStack[Int] = FuncStackNonEmpty[Int](FuncStackNonEmpty[Int](FuncStackEmpty[Int](), 1, 1), 23, 2)
    val (previous, element) = stack.pop()
    (previous, element) should be((FuncStackNonEmpty[Int](FuncStackEmpty[Int](), 1, 1),Some(23)))
    previous.isEmpty should be(false)
    previous.asInstanceOf[FuncStackNonEmpty[Int]].size should be(1)
    previous.asInstanceOf[FuncStackNonEmpty[Int]].element should be(1)
  }

}
