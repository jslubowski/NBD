import scala.annotation.tailrec

object Task3 {
  def main(): Unit = {
    println("\n\n======== Zadanie 3 ========")
    val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek",
      "Piątek", "Sobota", "Niedziela")

    println("Iteracja przy użyciu rekurencji ogonowej")
    println(tailRecursionIteration(daysOfWeek, ""))

  }
  @tailrec
  def tailRecursionIteration(list: List[String], accumulator: String): String = list match {
    case Nil => accumulator
    case head :: tail => tailRecursionIteration(tail, accumulator.concat(head).concat(", "))
  }
}
