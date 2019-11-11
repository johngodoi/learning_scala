package com.johngodoi.scala.design.patterns.builder

case class Pizza(topping: String, dough: String, cheese:String)

object PizzaBuilder {
  def builder = new PizzaBuilder()
}

class PizzaBuilder(var pizza: Pizza=Pizza("", "", "")) {

  def withTopping(topping:String): PizzaBuilder ={
    this.pizza = pizza.copy(topping = topping)
    this
  }

  def withDough(dough: String): PizzaBuilder = {
    this.pizza = pizza.copy(dough = dough)
    this
  }

  def withCheese(cheese: String): PizzaBuilder = {
    this.pizza = pizza.copy(cheese = cheese)
    this
  }

  def build= pizza

}

object Main extends App {
  val pizza: Pizza = PizzaBuilder.builder
                    .withCheese("Cheddar")
                    .withDough("dough")
                    .withTopping("Peperoni")
                    .build
}