package printable

trait Printable[A] {
  self: Printable[A] ⇒

  def format(value: A): String
  def contramap[B](f: B ⇒ A): Printable[B] = new Printable[B] {
    def format(value: B): String = self.format(f(value))
  }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String = p.format(value)
  def print[A](value: A)(implicit p: Printable[A]): Unit = println(format(value))
}
