object Task6 {
  def main(args: Array[String]): Unit = {

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
