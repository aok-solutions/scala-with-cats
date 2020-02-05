package show

import cats.Show
import models.Cat

object ShowInstances {
  implicit val showCat: Show[Cat] = Show.show(cat ⇒ s"${cat.name} is a ${cat.age} year-old ${cat.color} cat")
}
