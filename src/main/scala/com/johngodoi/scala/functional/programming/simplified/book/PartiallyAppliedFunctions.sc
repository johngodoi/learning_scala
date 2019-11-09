def plus(a: Int)(b: Int) = a+b
def plus2 =  plus(2)(_)

plus(1)(4)
plus2(3)

def wrap(prefix: String)(html: String)(suffix: String)=
  prefix+html+suffix


val hello = "Hello World"
wrap("<div>")(hello)("</div>")

val wrapWithPre = wrap("<pre>")(_:String)("</pre>")

wrapWithPre(wrap("<div>")(hello)("</div>"))

//Creating curried function from regular functions

def add(x:Int, y:Int) = x + y

add(1, 4)

val addFunction = add _

addFunction(5, 6)

val addCurried = (add _).curried

addCurried(9)(10)

val addCurriedTwo = addCurried(2)
addCurriedTwo(3)

//Partially-applied functions without multiple parameter groups

def wrapWithTag(prefix: String, html: String, suffix: String)= prefix+html+suffix
val wrapWithDivTag = wrapWithTag("<div>", _:String, "</div>")

wrapWithDivTag("john")