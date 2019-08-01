package com.johngodoi.scala.hackerrank.thirtydays

object Day11 {


  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    println(maxSumHourGlass(arr))
  }

  def maxSumHourGlass(arr: Array[Array[Int]]): Int = {
    var sumHourGlasses = scala.collection.immutable.List[Int]()
    val limitX = arr.length - 2
    val limitY = arr(0).length - 2
    for (j <- 0 until limitY) {
      for (i <- 0 until limitX) {
        sumHourGlasses = sumHourGlass(arr, j, i)::sumHourGlasses
      }
    }
    sumHourGlasses.max
  }

  def sumHourGlass(arr: Array[Array[Int]], initialY: Int, initialX: Int) = {
    (arr(initialY)(initialX))+
      (arr(initialY)(initialX+1))+
      (arr(initialY)(initialX+2))+
      (arr(initialY+1)(initialX+1))+
      (arr(initialY+2)(initialX))+
      (arr(initialY+2)(initialX+1))+
      (arr(initialY+2)(initialX+2))
  }

  def iterate2DArray(arr: Array[Array[Int]]) = {
    val limitX = arr.length - 2
    val limitY = arr(0).length - 2
    for (j <- 0 until limitY) {
      for (i <- 0 until limitX) {
        printHourGlass(arr, j, i)
      }
    }
  }

  def printHourGlass(arr: Array[Array[Int]], initialY: Int, initialX: Int) = {
    print(arr(initialY)(initialX))
    print(arr(initialY)(initialX+1))
    println(arr(initialY)(initialX+2))
    print(" ")
    print(arr(initialY+1)(initialX+1))
    println(" ")
    print(arr(initialY+2)(initialX))
    print(arr(initialY+2)(initialX+1))
    println(arr(initialY+2)(initialX+2))
  }
}

