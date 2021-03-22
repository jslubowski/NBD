import scala.annotation.tailrec

object Task8 {
  def main(): Unit = {
    println("\n\n======== Zadanie 8 ========")
    val numberList: List[Int] = List(
      0, 1, 0, 2, 0, 3, 4, 0, 0, 0, 0, 5, 6, 0, 7, 8, 9, 0
    )

    println("Usuwanie wartości != 0 za pomocą rekurencji")
    println("Oryginalna kolekcja: ")
    numberList.foreach(n => print(s"$n "))
    println("Zmodyfikowana kolekcja: ")
    removeZeroValues(numberList, List[Int]()).foreach(n => print(s"$n "))
  }

  @tailrec
  def removeZeroValues(numberList: List[Int], accumulator: List[Int]): List[Int] = numberList match {
    case Nil => accumulator.reverse
    case head :: tail =>
      if (head != 0) {
        removeZeroValues(tail, head :: accumulator)
      } else removeZeroValues(tail, accumulator)
  }
}
