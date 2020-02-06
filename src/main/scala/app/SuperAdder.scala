package app

import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import monoid.MonoidInstances.orderMonoid

object SuperAdder extends App {
//  def add(items: List[Int]): Int = items.reduce((x, y) ⇒ Monoid[Int].combine(x, y))
//  def add(items: List[Option[Int]]): Option[Int] = items.reduce((x, y) ⇒ Monoid[Option[Int]].combine(x, y))
  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)((x, y) ⇒ monoid.combine(x, y))
}
