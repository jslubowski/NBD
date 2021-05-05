package Task2

class KontoBankowe(private var _stanKonta: Int) {

  def this() {
    this(0)
  }

  def stanKonta(): Int = {
    _stanKonta
  }

  def wplata(kwota: Int): Unit = {
    _stanKonta += kwota
    println(s"Obecny stan konta ${stanKonta()}")
  }

  def wyplata(kwota: Int): Unit = {
    if(_stanKonta - kwota > 0) {
      _stanKonta -= kwota
      println(s"Obecny stan konta ${stanKonta()}")
    } else println("Stan konta jest zbyt niski")
  }

}
