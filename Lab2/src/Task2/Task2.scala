package Task2

object Task2 {
  def main(args: Array[String]): Unit = {
    val konto1 = new KontoBankowe()
    val konto2 = new KontoBankowe(10000)

    println(s"Stan konta na koncie 1: ${konto1.stanKonta()}")
    println(s"Stan konta na koncie 2: ${konto2.stanKonta()}")

    konto2.wyplata(1000)
    println(s"Wypłata 1000 z konta 2: ${konto2.stanKonta()}")

    println(s"Wypłata 1000 z konta 1:")
    konto1.wyplata(1000)

    konto1.wplata(15000)
    println(s"Wpłata 15000 na konto 1: ${konto1.stanKonta()}")
  }
}
