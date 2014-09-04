import scala.collection.mutable

//def square(a:Int) = a * a
//def square = {a:Int => a * a}
def square = {a:Int => a * a}


def input = 1 to 10

def map(seq: Seq[Int], f: Int => Int) = {
  val it = seq.iterator
  val result = mutable.Buffer.empty[Int]

  while (it.hasNext) {
    result += f(it.next())
  }
  result.toList
}

val xs = map(input, square)


def map2(seq: Seq[Int], f: Int => Int): Seq[Int] = {
  val it = seq.iterator

  var result = Seq.empty[Int]

  while (it.hasNext) {
    result = result :+ f(it.next())
  }
  result
}
val ys = map2(input, square)


def map3(seq: Seq[Int], f: Int => Int) : Seq[Int] = {
  if (seq.isEmpty)
    seq
  else
    f(seq.head) +: map3(seq.tail, f)
}

val zs = map3(input, square)


def inject(seq: Seq[Int], f: Int => Int, acc: Seq[Int] = Seq.empty[Int]): Seq[Int] = {
  if (seq.isEmpty)
    acc
  else
    inject(seq.tail, f, acc :+ f(seq.head))
}

val zs2 = inject(input, square)
