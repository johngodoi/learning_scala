package com.johngodoi.scala.design.patterns.builder

/**
  * @see https://gist.github.com/kencoba/1874015
  */
abstract class Product

abstract class KPizzaBuilder {
  var dough: String
  var sauce: String
  var topping: String

  def withDough(dough: String): KPizzaBuilder
  def withSauce(sauce: String): KPizzaBuilder
  def withTopping(topping: String): KPizzaBuilder

  def build: Product
}

class KPizza(builder: KPizzaBuilder) extends Product {
  val dough: String = builder.dough
  val sauce: String = builder.sauce
  val topping: String = builder.topping

  override def toString: String = {
    "Dough:" + dough + " Topping:" + topping + " Sauce:" + sauce
  }
}

class Cook extends KPizzaBuilder {
  var dough: String = ""
  var sauce: String = ""
  var topping: String = ""

  override def withDough(dough: String): KPizzaBuilder = {
    this.dough = dough
    this
  }

  override def withSauce(sauce: String): KPizzaBuilder = {
    this.sauce = sauce
    this
  }

  override def withTopping(topping: String): KPizzaBuilder = {
    this.topping = topping
    this
  }

  override def build: Product = new KPizza(this)
}


object PizzaBuilderExample {
  def main(args: Array[String]) = {
    val hawaiianCook = new Cook().withDough("cross").withTopping("ham+pineapple").withSauce("mild")
    val hawaiianPizza = hawaiianCook.build
    println("Hawaiian Pizza:" + hawaiianPizza)
  }
}
