package com.johngodoi.scala.hackerrank.thirtydays


object Day8 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn
    val n = stdin.readLine.trim.toInt
    var phoneBook = Map[String,String]()

    for(i <- 0 until n){
      var input = stdin.readLine.trim.split(" ")
      phoneBook = phoneBook + (input(0) -> input(1))
    }

    var query = stdin.readLine
    while(query!=null){
      if(phoneBook contains query)
        println(s"$query=${phoneBook(query)}")
      else println("Not found")
      query=stdin.readLine
    }
  }
}
