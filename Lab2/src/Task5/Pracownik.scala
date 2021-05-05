package Task5

trait Pracownik extends Osoba {
  var pensja: Double = 0

  override val podatek: Double = 0.2

  def obliczPodatek(): Double = pensja * podatek

  override def podatekFun: Double = 0.2 * pensja
}
