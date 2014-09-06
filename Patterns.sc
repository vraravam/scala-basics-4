class A {
  def inner = 123
}

val Dd = "foo bar"

def m(a: Any) = a match {
  case 12 => 123
  case x@"xyz" => s"Hello: '$x' with length of ${x.length}"
  case `Dd` => "Came here with the constant!"
  case x: Int => x * 100
  case x => s"Couldnt understand: '$x'"
}

m(234)
m(12)
m("xyz")
m("asd")
m(Dd)


case class Person(name: String, age: Int)

val p = Person("vijay", 39)

val Person(n, a) = p
