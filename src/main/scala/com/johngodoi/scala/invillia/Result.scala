package com.johngodoi.scala.invillia

object Result {

  /*
   * Complete the 'getEmailThreads' function below.
   *
   * The function is expected to return a 2D_INTEGER_ARRAY.
   * The function accepts STRING_ARRAY emails as parameter.
   */

  def getEmailThreads(emails: Array[String]): Array[Array[Int]] = {
    val bodies = emails.map(email => email.split(",")(2))
    val (responses, starters) = bodies.partition(body => body.contains("---"))

    var threads = starters.map(starter => Array(starter))
    val groupedByStarter = responses
      .map(response => response.split("---"))
      .groupBy(responseBody => responseBody.last)
    val result = groupedByStarter.map(pair => (pair._1, (Array(pair._1)::pair._2.toList).toArray)).toList
    val result2 = for(i <- 1 to result.size) yield (i,(1 to result(i-1)._2.size).toArray)
    val finalResult = result2.map(p => p._2).toArray
    return finalResult
  }

}
