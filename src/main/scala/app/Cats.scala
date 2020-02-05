package app

import models.Cat
//import printable.Printable
//import printable.PrintableInstances._
//import printable.PrintableSyntax._
import show.ShowInstances._
import equal.EqualInstances._
import cats.instances.option._
import cats.syntax.show._
import cats.syntax.eq._

object Cats extends App {
  val garfield = Cat("Garfield", 38, "orange and black")
  val heathcliff = Cat("Heathcliff", 33, "orange and black")

  println(garfield.show)
  println(heathcliff.show)

  val isSameCat = yesOrNo(garfield === heathcliff)
  println(s"Are these cats the same?... $isSameCat")

  val isHimself = yesOrNo(garfield === garfield)
  println(s"Is Garfield himself?... $isHimself")

  val isDifferentOption = yesOrNo(Option(garfield) =!= Option.empty[Cat])
  println(s"Are these options different?... $isDifferentOption")

  def yesOrNo(question: Boolean): String = if (question) "yea" else "nah"
}
