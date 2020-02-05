package equal

import cats.Eq
import models.Cat

object EqualInstances {
  implicit val equalCat: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) ⇒
    cat1.name == cat2.name &&
      cat1.age == cat2.age &&
      cat1.color == cat2.color
  }
}
