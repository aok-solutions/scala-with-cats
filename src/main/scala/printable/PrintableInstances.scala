package printable

import models.{ Box, Cat }

object PrintableInstances {
  implicit val printableString: Printable[String] = new Printable[String] {
    def format(value: String): String = "\"" + value + "\""
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    def format(value: Int): String = value.toString
  }

  implicit val printableBoolean: Printable[Boolean] = new Printable[Boolean] {
    def format(value: Boolean): String = if (value) "yes" else "no"
  }

  implicit val printableCat: Printable[Cat] = new Printable[Cat] {
    def format(cat: Cat): String = s"${cat.name} is a ${cat.age} year-old ${cat.color} cat"
  }

  implicit def printableBox[A](implicit p: Printable[A]): Printable[Box[A]] = p.contramap[Box[A]](_.value)
//    new Printable[Box[A]] {
//      def format(box: Box[A]): String = p.format(box.value)
//    }
}
