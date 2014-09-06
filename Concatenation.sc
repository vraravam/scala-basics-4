// Concatenate 2 strings , if one is null, dont use it in the returned value

def concat1(s1: String, s2: String) =
  if (s1 == null) s2
  else if (s2 == null) s1
  else s1 + s2


concat1(null, null)
concat1(null, "a")
concat1("a", null)
concat1("a", "b")


def concat2(s1: Option[String], s2: Option[String]): Option[String] =
  if (s1 == None) s2
  else if (s2 == None) s1
  else Some(s1.get + s2.get)

concat2(None, None)
concat2(None, Some("a"))
concat2(Some("a"), None)
concat2(Some("a"), Some("b"))

def concat3(s1: Option[String], s2: Option[String]): Option[String] = (s1, s2) match {
  case (None, _) => s2
  case (_, None) => s1
  case (Some(v1), Some(v2)) => Some(v1 + v2)
}

concat3(None, None)
concat3(None, Some("a"))
concat3(Some("a"), None)
concat3(Some("a"), Some("b"))


//def concat4(s: String*) =
//  s.toString().concat("asd")
//
//concat4("a", "b", "c", "d")
