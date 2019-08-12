package com.johngodoi.scala.hackerrank.thirtydays

import com.johngodoi.scala.hackerrank.thirdparty.TomLous.Solution

object Day2 extends Solution {

    // Complete the solve function below.
    def solve(meal_cost: Double, tip_percent: Int, tax_percent: Int) {
      val pip = meal_cost*(tip_percent/100.0)
      val pax = meal_cost*(tax_percent/100.0)

      Math.round(meal_cost+pip+pax)
    }

    def main(args: Array[String]) {
      val stdin = scala.io.StdIn

      val meal_cost = stdin.readLine.trim.toDouble

      val tip_percent = stdin.readLine.trim.toInt

      val tax_percent = stdin.readLine.trim.toInt

      println(solve(meal_cost, tip_percent, tax_percent))
    }
  }

