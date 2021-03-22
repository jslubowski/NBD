object Task6 {
  def main(): Unit = {
    println("\n\n======== Zadanie 6 ========")

    val tuple = (1, "Ogórek", 5.5)
    println("Wypisywanie trójwartościowej krotki za pomocą funkcji")
    printTuple(tuple)

  }
  def printTuple(input: (Int, String, Double)): Unit = {
    val (id, name, price) = input
    println(id)
    println(name)
    println(price)
  }
}
