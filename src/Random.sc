

//var t = 1
//def x = { println(t); t = t+1; t }
//
//x
//t
//
//def sum(a: Int)(b: Int)(c: Int) = a + b + c
//
//sum(10)(20)



//def using(fileName: => String)(block: String => Unit) = {
//  io.Source.fromFile(fileName).getLines().toList.map(line => block(line))
//}
//
//using("/Users/vijay/.zshrc")({ r =>
//  println(r)
//})
//Map({1 -> "b"}, 2 -> "b")
def x = { util.Random.nextInt(25) }

val xs = (1 to 10).map(_ => x).toList

xs.filter(3 < _)
