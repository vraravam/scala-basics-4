import play.api.libs.json._

val input = Json.obj(
  "a" -> 10,
  "b" -> true,
  "d" -> "urn:world",
  "d1" -> "world",
  "c" -> JsNull,
  "e" -> Json.obj(
    "f" -> 20,
    "g" -> false,
    "h" -> "hello",
    "i" -> Json.arr("urn:pune", "this", "is", "")
  ),
  "j" -> Json.arr(
    Json.obj("k" -> "urn:tw", "l" -> "munich"),
    Json.obj("k" -> "autoscout", "l" -> "urn:germany")
  ),
  "m" -> 90,
  "n" -> "urn:ignore"
)

val reqdOutput = Json.obj(
  "a" -> 100,
  "b" -> false,
  "d" -> "Hello, world",
  "d1" -> "world",
  "c" -> "error",
  "e" -> Json.obj(
    "f" -> 400,
    "g" -> true,
    "h" -> "hello",
    "i" -> Json.arr("Hello, pune", "this", "is", "empty")
  ),
  "j" -> Json.arr(
    Json.obj("k" -> "Hello, tw",
      "l" -> "munich"),
    Json.obj(
      "k" -> "autoscout",
      "l" -> "Hello, germany")),
  "m" -> 90,
  "n" -> "urn:ignore"
)

object X {
  private object Urn {
    def unapply(str: String): Option[(String, String)] = str.split(":") match {
      case Array(prefix, suffix) => Option((prefix, suffix))
      case _ => None
    }
  }

  def transform(json: JsValue): JsValue = json match {
    case JsNumber(x) => JsNumber(x * x)
    case JsBoolean(x) => JsBoolean(!x)
    case JsNull => JsString("error")
    case JsString("") => JsString("empty")
    case JsString(Urn("urn", suffix)) => JsString(s"Hello, $suffix")
    case JsArray(values) => JsArray(values.map(transform))
    case JsObject(pairs) => JsObject(pairs.map(transformPair))
    case x => x
  }

  def transformPair(pair: (String, JsValue)) = pair match {
    case (k@("m" | "n"), v) => (k, v)
    case (k, v) => (k, transform(v))
  }
}

val output = X.transform(input)
Json.prettyPrint(output)
output == reqdOutput
