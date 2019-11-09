def timer[A](blockOfCode: => A) = {
  val startTime = System.nanoTime()
  val result = blockOfCode
  val stopTime = System.nanoTime()
  val delta = stopTime - startTime
  (result, delta/1000000d)
}

timer {
  Thread.sleep(1000)
  1
}