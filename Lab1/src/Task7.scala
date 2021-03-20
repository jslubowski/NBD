object Task7 {
  def main(args: Array[String]): Unit = {
    val products = Map(
      "Jabłko" -> 4.0,
      "Ziemniak" -> 2.0,
      "Ser" -> 5.0,
      "Chleb" -> 5.0,
      "Oliwa" -> 20.0,
      "Komputer" -> 2099.99
    )

    println("Wypisanie wartości z mapy za pomocą Option")
    println(s"Komputer: ${show(products.get("Komputer"))}")
    println(s"Jogurt: ${show(products.get("Jogurt"))}")
  }

  def show(item: Option[Double]) = item match {
    case Some(value) => value
    case None => "Brak w mapie"
  }
}
