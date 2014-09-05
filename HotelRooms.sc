case class Rate(weekday: Int, weekend: Int) {
  def calculate(noOfWeekDays: Int, noOfWeekends: Int) = noOfWeekDays * weekday + noOfWeekends * weekend
}

case class Hotel(name: String, rating: Int, regularRate: Rate, rewardsRate: Rate) {
  def calculateTotal(isRewardsCustomer: Boolean, weekdays: Int, weekendDays: Int): Int = {
    if (isRewardsCustomer)
      rewardsRate.calculate(weekdays, weekendDays)
    else
      regularRate.calculate(weekdays, weekendDays)
  }

  override def toString = name
}

val lakewood = Hotel("lakewood", 3, Rate(110, 90), Rate(80, 80))
val bridgewood = Hotel("bridgewood", 4, Rate(160, 60), Rate(110, 50))
val ridgewood = Hotel("ridgewood", 5, Rate(220, 150), Rate(100, 40))


var hotels = Seq(lakewood, bridgewood, ridgewood)

def calculate(isRewardsCustomer: Boolean, weekdays: Int, weekendDays: Int) {
  val hotelsWithRate: Seq[(Hotel, Int)] = hotels.map(hotel => (hotel, hotel.calculateTotal(isRewardsCustomer, weekdays, weekendDays)))
  println(hotelsWithRate.minBy { case (hotel, rate) => (rate, -hotel.rating)})
}

calculate(isRewardsCustomer = false, weekdays = 3, weekendDays = 0)

calculate(isRewardsCustomer = false, weekdays = 1, weekendDays = 2)

calculate(isRewardsCustomer = true, weekdays = 2, weekendDays = 1)
