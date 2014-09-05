

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
def x = {
  util.Random.nextInt(25)
}
val xs = (1 to 10).map(_ => x).toList
xs.filter(3 < _)
//def map2(seq: Seq[Int], f: Int => Int): Seq[Int] = {

def last(input: Seq[Int]): Int = {
  input.last
}

last(List(1, 1, 2, 3, 5, 8))

def penultimate(input: Seq[Int]): Int = {
  input.tail.last
}
penultimate(List(1, 1, 2, 3, 5, 8))

def nth(index: Int, input: Seq[Int]): Int = {
  input.slice(index - 1, index).head
}
nth(1, List(100, 10, 2, 3, 5, 8))

def isPalindrome(input: Seq[Int]): Boolean = {
  input == input.reverse
}
isPalindrome(List(1, 2, 3, 3, 2, 1))

def flatten(input: List[Any]): List[Int] = {
  input.flatten
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))