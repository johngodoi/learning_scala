package com.johngodoi.scala.datastructures

trait FuncQueue[A] {
  def size:Int
  def isEmpty: Boolean
  def put(element: A): FuncQueue[A]
  def remove(): (FuncQueue[A], Option[A])
}

case class FuncQueueEmpty[A]() extends FuncQueue[A]{
  override def size = 0
  override def isEmpty: Boolean = true
  override def put(element: A): FuncQueue[A] = FuncQueueNonEmpty[A](List(element))
  override def remove(): (FuncQueue[A], Option[A]) = (this, None)
}

case class FuncQueueNonEmpty[A](queue:List[A]) extends FuncQueue[A]{
  override def size = queue.length
  override def isEmpty: Boolean = false
  override def put(element: A): FuncQueue[A] = FuncQueueNonEmpty(element::queue)
  override def remove(): (FuncQueue[A], Option[A]) = queue.take(queue.length-1) match {
    case x::xs => (FuncQueueNonEmpty(x::xs), Some(queue.last))
    case Nil => (FuncQueueEmpty(), Some(queue.last))
  }
}



