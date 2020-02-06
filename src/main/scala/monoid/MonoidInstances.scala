package monoid

object MonoidInstances {
  //  ---------------- Boolean Monoids ----------------
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

  //  ---------------- Set Monoids/Semigroups ----------------
  implicit def unionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty
    def combine(x: Set[A], y: Set[A]): Set[A] = x union y
  }

  implicit def intersectionSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
  }

  implicit def symmetricDifferenceMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty
    def combine(x: Set[A], y: Set[A]): Set[A] = x.diff(y) union y.diff(x)
  }
}
