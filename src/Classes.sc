case class Address(line1: String, var pin: Int)

case class Person(name: String, address: Address)

val vijay = Person("vijay", Address("l1", 23))

val rakshita = vijay.copy()

rakshita.address.pin

vijay.address.pin

vijay.address.pin = 123

rakshita.address.pin

vijay.address.pin


val vijay2 = vijay.copy()

vijay == vijay2
vijay eq vijay2

vijay.hashCode()
vijay2.hashCode()

