package Task5

object Task5 {
  def main(args: Array[String]): Unit = {
    val student = new Osoba("Student", "Studencki") with Student
    val pracownik = new Osoba("Pracownik", "Pracowity") with Pracownik
    pracownik.pensja = 2000

    val nauczyciel = new Osoba("Nauczyciel", "Nauczajacy") with Nauczyciel
    nauczyciel.pensja = 3000

    println(student.podatek)
    println(pracownik.obliczPodatek())
    println(nauczyciel.obliczPodatek())


    // osoba with student with pracownik i na odwrot

  }
}
