object Task5 {
  def main(args: Array[String]): Unit = {

    val products = Map(
      "Jabłko" -> 4.0,
      "Ziemniak" -> 2.0,
      "Ser" -> 5.0,
      "Chleb" -> 5.0,
      "Oliwa" -> 20.0,
      "Komputer" -> 2099.99
    )
    println("Mapa produktów: \n" + products.toString())

    val reducePrice: ((String, AnyVal)) => (String, AnyVal) = {
      case (key, value) =>
        val newValue = value.asInstanceOf[Double] * 0.9
        key -> newValue
    }

    val reducedProducts = products.map(reducePrice)
    println("Mapa produktów po obniżce: \n" + reducedProducts.toString())
  }
}
