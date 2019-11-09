class PersonOO(var name: String)

var p = new PersonOO("Jonathan Stuart Leibowitz")
println(p)
p.name = "Jon Stewart"
println(p)

case class PersonFP(name: String)
val fp = PersonFP("Jonathan Stuart Leibowitz")
val fp2 = fp.copy(name = "Jon Stewart")

println(fp)
println(fp2)

