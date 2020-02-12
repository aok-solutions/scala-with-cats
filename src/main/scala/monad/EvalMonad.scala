package monad

import cats.Eval

object EvalMonad {
  def foldRightEval[A, B](as: List[A], acc: Eval[B])(f: (A, Eval[B]) ⇒ Eval[B]): Eval[B] =
    as match {
      case head :: tail ⇒ Eval.defer(f(head, foldRightEval(tail, acc)(f)))
      case Nil ⇒ acc
    }

  def foldRight[A, B](as: List[A], acc: B)(f: (A, B) ⇒ B): B =
    foldRightEval(as, Eval.now(acc))((a, b) ⇒ b.map(f(a, _))).value
}
