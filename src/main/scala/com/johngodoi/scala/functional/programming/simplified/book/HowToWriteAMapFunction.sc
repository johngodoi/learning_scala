def filter[A](f: A => Boolean, list: Seq[A]): Seq[A] = {
  for {
    x <- list if f(x)
  } yield x
}

val isEven: Int => Boolean = _%2==0
def isOdd(e: Int): Boolean = e%2!=0
filter(isEven, List(0,1,2,3,4,5,6,7,8,9))
filter(isOdd, List(0,1,2,3,4,5,6,7,8,9))