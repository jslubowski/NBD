object Task1 {
  def main(): Unit = {
    println("\n\n======== Zadanie 1 ========")
    val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek",
      "Piątek", "Sobota", "Niedziela")


    println("Pętla for")
    println(forLoopIteration(daysOfWeek))

    println()
    println("Pętla for - dnia zaczynające się na P")
    println(forLoopStartingWithP(daysOfWeek))

    println()
    println("Pętla while")
    println(whileLoopIteration(daysOfWeek))

  }

  def forLoopIteration(list: List[String]): String = {
    var result = ""
    for (i <- list.indices) {
      result += list(i)
      if (i != list.length - 1) result += ", "
    }
    result
  }

  def forLoopStartingWithP(list: List[String]): String = {
    var result = ""
    for (i <- list.indices) {
      if (list(i).take(1) == "P") result += list(i).concat(", ")
    }
    result
  }

  def whileLoopIteration(list: List[String]): String = {
    var i = 0
    var result = ""
    while(i < list.length - 1) {
      result += list(i).concat(", ")
      i += 1
    }
    result += list(i)
    result
  }
}
