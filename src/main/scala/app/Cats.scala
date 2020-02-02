package app

import models.Cat
import printable.Printable
import printable.PrintableInstances._

object Cats extends App {
  val cat = Cat("Garfield", 12, "Orange")
  Printable.print(cat)
}
