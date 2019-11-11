package com.johngodoi.scala.design.patterns.builder


/**
  * @see https://medium.com/@maximilianofelice/builder-pattern-in-scala-with-phantom-types-3e29a167e863
  * @param message
  */
class FoodBuildingException(message: String) extends Exception

case class Food(ingredients: Seq[String])
//case class Chef() {
//
//  def hasDoughCheeseAndToppings(ingredients: Seq[String]): Boolean = ???
//
//  val ingredients: Seq[String] = ???
//
//  def build: Food =
//  if (hasDoughCheeseAndToppings(ingredients)) Food(ingredients)
//  else throw new FoodBuildingException("You tried to build a pizza without enough ingredients")
//}

class Chef[Pizza <: Chef.Pizza](ingredients: Seq[String] = Seq()) {
  import Chef.Pizza._

  def addCheese(cheeseType: String): Chef[Pizza with Cheese] = new Chef(ingredients :+ cheeseType)

  def addTopping(toppingType: String): Chef[Pizza with Topping] = new Chef(ingredients :+ toppingType)

  def addDough: Chef[Pizza with Dough] = new Chef(ingredients :+ "dough")

  def build(implicit ev: Pizza =:= FullPizza): Food = Food(ingredients)
}

object Chef {

  sealed trait Pizza
  object Pizza {
    sealed trait EmptyPizza extends Pizza
    sealed trait Cheese extends Pizza
    sealed trait Topping extends Pizza
    sealed trait Dough extends Pizza

    type FullPizza = EmptyPizza with Cheese with Topping with Dough
  }
}

//scala> new Chef[Chef.Pizza.EmptyPizza]().addDough.build
//<console>:18: error: Cannot prove that Chef.Pizza.EmptyPizza with Chef.Pizza.Dough =:= Chef.Pizza.FullPizza.

//scala>

object Main extends App {
  new Chef[Chef.Pizza.EmptyPizza]()
    .addCheese("mozzarella")
    .addDough
    .addTopping("olives")
    .build
}
//  res1: Food = Food(List(mozzarella, dough, olives))
