object Task2 {
  def main(args: Array[String]): Unit = {
    val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek",
      "Piątek", "Sobota", "Niedziela")

    println("Iteracja przy użyciu rekurencji")
    println(recursionIteration(daysOfWeek))

    println()
    println("Iteracja przy użyciu rekurencji od końca")
    println(backwardRecursionIteration(daysOfWeek))

    def recursionIteration(list: List[String]): String = {
      def getPrev(list: List[String], index: Int): String = {
        if (index == 0) {
          list(index).concat(", ")
        }
        else getPrev(list, index - 1) + list(index).concat(", ")
      }
      getPrev(list, list.length - 1)
    }

    def backwardRecursionIteration(list: List[String]): String = {
      def getNext(list: List[String], index: Int): String = {
        if (index == list.length - 1) {
          list(index).concat(", ")
        } else getNext(list, index + 1) + list(index).concat(", ")
      }

      getNext(list, 0)
    }
  }
}
