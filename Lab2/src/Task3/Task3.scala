package Task3

object Task3 {
  def main(args: Array[String]): Unit = {
    val listaOsob = List[Osoba](
      new Osoba("Tomasz", "Abacki"),
      new Osoba("Tomasz", "Babacki"),
      new Osoba("Agata", "Abacka"),
      new Osoba("Sean", "Connery"),
      new Osoba("Piotr", "Cabacki")
    )

    listaOsob.foreach(osoba => println(powitanie(osoba)))
  }

  def powitanie(osoba: Osoba): String = osoba.imie match {
    case "Tomasz" => s"Witaj Tomku ${osoba.nazwisko}"
    case "Agata" => s"Dzień dobry, Agato ${osoba.nazwisko}"
    case "Sean" => s"Top of the morning Sean ${osoba.nazwisko}"
    case _ => s"Hello ${osoba.imie} ${osoba.nazwisko}"
  }

  // case class
}
