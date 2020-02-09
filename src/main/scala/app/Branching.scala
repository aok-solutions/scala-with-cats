package app

import cats.implicits._
import functor.FunctorInstances.treeFunctor
import models.Tree
import models.Tree.{ branch, leaf }


object Branching extends App {
  val tree: Tree[Int] = branch(branch(leaf(20), leaf(10)), leaf(40))
  println(tree.toString)
  println("...multiplied by 3 is")
  println(tree.map(_ * 3).toString)
}
