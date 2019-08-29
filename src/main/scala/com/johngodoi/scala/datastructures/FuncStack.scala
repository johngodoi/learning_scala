package com.johngodoi.scala.datastructures

trait FuncStack[F] {
  def isEmpty:Boolean
  def push(element:F):FuncStack[F]
  def pop(): (FuncStack[F], Option[F])
}

case class FuncStackEmpty[F]() extends FuncStack[F]{
  override def isEmpty:Boolean = true
  override def push(element: F): FuncStack[F] = FuncStackNonEmpty(this, element, 1)
  override def pop(): (FuncStack[F], Option[F]) = (this, None)
}

case class FuncStackNonEmpty[F](previous: FuncStack[F], element:F, size:Int) extends FuncStack[F] {
  override def isEmpty: Boolean = false
  override def push(element: F): FuncStack[F] = FuncStackNonEmpty(this, element, size+1)
  override def pop(): (FuncStack[F], Option[F]) = (previous, Some(element))
}
