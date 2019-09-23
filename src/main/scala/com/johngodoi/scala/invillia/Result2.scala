package com.johngodoi.scala.invillia

object Result2 {

  /*
   * Complete the 'minNum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER threshold
   *  2. INTEGER_ARRAY happy
   */

  def checkNext(threshold: Int, happy: Array[Int], position: Int, initial: Int, solved:scala.collection.immutable.List[Int]): scala.collection.immutable.List[Int] = {
    if(position>=happy.length)
      return solved
    if(threshold<=(Math.abs(initial-happy(position))))
      return position::solved
    if(position == 0){
      val i1 = checkNext(threshold,happy, position+1, happy(position), position::solved)
      val i2 = checkNext(threshold,happy, position+2, happy(position), position::solved)
      var solutions = scala.collection.immutable.List[scala.collection.immutable.List[Int]]()
      solutions = if(Math.abs(initial-happy(i1.head))>=threshold) i1::solutions else solutions
      solutions = if(Math.abs(initial-happy(i2.head))>=threshold) i2::solutions else solutions
      if(solutions.isEmpty)
        return (0 until happy.length).toList
      solutions.minBy(i => i.length)
    } else {
      val i1 = checkNext(threshold, happy, position + 1, initial, position::solved)
      val i2 = checkNext(threshold, happy, position + 2, initial, position::solved)
      var solutions = scala.collection.immutable.List[scala.collection.immutable.List[Int]]()
      solutions = if(Math.abs(initial-happy(i1.head))>=threshold) i1::solutions else solutions
      solutions = if(Math.abs(initial-happy(i2.head))>=threshold) i2::solutions else solutions
      if(solutions.isEmpty)
        return (0 until happy.length).toList
      solutions.minBy(i => i.length)
    }
  }

  def minNum(threshold: Int, happy: Array[Int]): Int = {
    val minR = checkNext(threshold, happy, 0, 0, scala.collection.immutable.List[Int]())
    minR.length
  }

}
