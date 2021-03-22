object Task9 {
  def main(): Unit = {
    println("\n\n======== Zadanie 9 ========")
    val numberList: List[Int] = List(
      0, 98701, -4560, 2, 0, 3, -10, 4, 112345345, 5, 6, 35, 7, 8898, 9, 0, 100,
    )

    println("Inkrementacja kolekcji za pomocą funkcji map()")
    println("Oryginalna kolekcja: ")
    numberList.foreach(n => print(s"$n, "))

    println("Nowa kolekcja po funkcji map()")

    val incrementedCollection = numberList.map(element => element + 1)
    incrementedCollection.foreach(n => print(s"$n, "))
  }
}
