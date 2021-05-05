object Task1 {
  def main(args: Array[String]): Unit = {
    val daysOfWeek = List[String] ("poNieDziałek", "aaaa", "wtorek", "śRODA",
    "Czwartek", "111111", "Piątek", "sobOtA", "niedziela")

    println("Pattern matching dla dni tygodnia - ignorowane duże litery")
    daysOfWeek.foreach(day => {
      println(s"$day: ${matchDaysOfWeek(day)}")
    })
  }

  def matchDaysOfWeek(day: String): String = day.toLowerCase() match {
    case "poniedziałek" | "wtorek" | "środa" | "czwartek" | "piątek" => "Praca"
    case "sobota" | "niedziela" => "Weekend"
    case _ => "Nie ma takiego dnia"
  }
}
