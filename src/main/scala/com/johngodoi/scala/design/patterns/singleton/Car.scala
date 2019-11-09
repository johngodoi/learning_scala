package com.johngodoi.scala.design.patterns.singleton

//companion
class Car(color:String) {
  override def toString: String = s"Car of color: $color with:" + Car.parts.mkString(", ")
}

//singleton
object Car {
  def printCar(car: Car) = println(car)
  private val parts = List("engine", "wheels", "tires", "windows", "steering wheel")
}

object Main extends App {
  Car.printCar(new Car("yellow"))
}
