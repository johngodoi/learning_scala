package com.johngodoi.scala.hackerrank.thirtydays


object Day6 {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    var list = List[String]()
    var n = scala.io.StdIn.readInt()
    for(i <- 0 until n){
      list = list:+scala.io.StdIn.readLine()
    }
    for(str <- list){

      for(i <- 0 until str.length()){
        if(i%2==0)
          print(str.charAt(i))
      }
      print(" ")
      for(i <- 0 until str.length()){
        if(i%2==1)
          print(str.charAt(i))
      }
      println()
    }
  }
}
