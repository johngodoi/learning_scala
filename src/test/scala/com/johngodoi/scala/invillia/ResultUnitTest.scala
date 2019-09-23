package com.johngodoi.scala.invillia

import org.scalatest.{FlatSpec, Matchers}

class ResultUnitTest extends FlatSpec with Matchers{

  "this" should "do something" in {

    val str = Result.getEmailThreads(Array("sv@outlook.com, gfdpdyf@gmail.com, n",
      "wl@hackerrank.com, tk@outlook.com, m",
      "gfdpdyf@gmail.com, sv@outlook.com, t.xg---n",
      "sv@outlook.com, gfdpdyf@gmail.com, i---t.xg---n",
      "tk@outlook.com, wl@hackerrank.com, o---m",
      "tk@outlook.com, wl@hackerrank.com, w---o---m",
      "tk@outlook.com, wl@hackerrank.com, nv---w---o---m",
      "sv@outlook.com, gfdpdyf@gmail.com, cyhf---i---t.xg---n")).map(_.mkString(" ")).mkString("\n")
    str should be(
        """1 1
          |2 1
          |1 2
          |1 3
          |2 2
          |2 3
          |2 4
          |1 4
        """.stripMargin)

  }

}
