package monoid

object MonoidInstances {
  implicit val andMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = true
    def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val orMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = false
    def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit val eitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = false
    def combine(x: Boolean, y: Boolean): Boolean = (x && !y) || (y && !x)
  }

  implicit val exclusiveNorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def empty: Boolean = true
    def combine(x: Boolean, y: Boolean): Boolean = (!x || y) && (x || !y)
  }
}
