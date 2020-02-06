package app

import cats.Monoid
import cats.instances.int._
import cats.instances.option._

object SuperAdder extends App {
//  def add(items: List[Int]): Int = items.reduce((x, y) ⇒ Monoid[Int].combine(x, y))
  def add(items: List[Option[Int]]): Option[Int] = items.reduce((x, y) ⇒ Monoid[Option[Int]].combine(x, y))
}
