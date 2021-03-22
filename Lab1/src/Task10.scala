object Task10 {

  def main(): Unit = {
    println("\n\n======== Zadanie 10 ========")
    val numberList = List[Int](
      -10, 10, -5, -6, 7, 9, 1000, 2, 0, -1, 1, -20, 12, 11, -11
    )

    println("Filtrowanie wartości bezwzględnych liczb rzeczywistych w przedziale <-5, 12>")
    println("Oryginalna kolekcja")
    numberList.foreach(n => print(s"$n, "))

    val filteredList = numberList
      .filter(n => n >= -5 && n <= 12)
      .map(n => n.abs)

    println("Nowa kolekcja po filtrowaniu")
    filteredList.foreach(n => print(s"$n, "))
  }
}
