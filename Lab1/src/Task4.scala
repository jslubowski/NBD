object Task4 {
  def main(): Unit = {
    println("\n\n======== Zadanie 4 ========")
    val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek",
      "Piątek", "Sobota", "Niedziela")

    println("Iteracja po liscie uzywajac metody foldLeft")
    val daysConcatenated = daysOfWeek.foldLeft("")((a,b) => {
      a.concat(b).concat(", ")
    })
    println(daysConcatenated)

    println("Iteracja po liscie uzywajac metody foldRight")
    val daysConcatenatedFromRight = daysOfWeek.foldRight("")((a, b) => {
      a.concat(", ").concat(b)
    })
    println(daysConcatenatedFromRight)

    println("Iteracja po liscie uzywajac metody foldLeft - wylacznie dni zaczynajece sie na P")
    val onlyP = daysOfWeek.foldLeft("")((a, b) => {
      if (b.take(1) == "P") a.concat(b).concat(", ")
      else a.concat("")
    })
    println(onlyP)
  }
}
