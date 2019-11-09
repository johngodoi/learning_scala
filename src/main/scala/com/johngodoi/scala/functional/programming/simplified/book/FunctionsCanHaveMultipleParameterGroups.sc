def sumM(a: Int)(b: Int)(c: Int):Int = a+b+c
def sum(a:Int, b:Int, c:Int):Int = a+b+c

sum(1,2,3) == sumM(1)(2)(3)

def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit ={
  while(testCondition) {
    codeBlock
  }
}

var i=0
whilst(i<5){
  println(i)
  i += 1
}

def ifBothTrue(test1: => Boolean)
              (test2: => Boolean)
              (codeBlock: => Unit):Unit ={
  if(test1 && test2) codeBlock
}

val text = "blabla"
val text2 = "fooooo"
ifBothTrue(text.length>5)(text2.contains("foo")){
  println(text+text2)
}


implicit val john = "john"
def hello(implicit name: String)= println(s"hello $name")

hello

def helloDefault(name:String = "default") = println(s"hello $name")
helloDefault()