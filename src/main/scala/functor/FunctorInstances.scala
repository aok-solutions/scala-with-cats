package functor

import cats.Functor
import models.{ Branch, Leaf, Tree }

object FunctorInstances {
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](tree: Tree[A])(f: A ⇒ B): Tree[B] = tree match {
      case Branch(left, right) ⇒ Branch(map(left)(f), map(right)(f))
      case Leaf(value) ⇒ Leaf(f(value))
    }
  }
}
