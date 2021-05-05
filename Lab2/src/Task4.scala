object Task4 {
  def main(args: Array[String]): Unit = {

    def increment(value: Int): Int = value + 1
    val value = 11

    println("Wywołanie funkcji inkrementacji w funkcji, która wywołuje ją trzykrotnie")
    println(s"Oryginalna wartość: $value")
    println(s"Zmieniona wartość: ${operateOnInteger(value, increment)}")
  }

  def operateOnInteger(value: Int, callback: (Int) => Int): Int = {
    var returnValue = callback(value)
    returnValue = callback(returnValue)
    returnValue = callback(returnValue)
    returnValue
  }
}
