def sum(list: List[Int]):Int = list match {
  case Nil => 0
  case head::tail => head+sum(tail)
}

sum(List(1,2,3,4))