package app

import models.Cat
import show.ShowInstances._
import cats.syntax.show._

object ShowCats extends App {
  val cat = Cat("Garfield", 12, "Orange")
//  println(showCat.show(cat))
  println(cat.show)
}
