package scala.meta.contrib

import scala.language.higherKinds
import scala.meta.Tree

trait TreeExtensions {
  implicit class XtensionTreeOps[A <: Tree](a: A) {
    @inline
    def ancestors: Seq[Tree] =
      TreeOps.ancestors(a)

    @inline
    def descendants: Seq[Tree] =
      TreeOps.descendants(a)

    @inline
    def foreach(f: Tree => Unit): Unit =
      TreeOps.foreach(a)(f)

    @inline
    def collectFirst[B](pf: PartialFunction[Tree, B]): Option[B] =
      TreeOps.collectFirst(a)(pf)

    @inline
    def find(f: Tree => Boolean): Option[Tree] =
      TreeOps.find(a)(f)

    @inline
    def forall(f: Tree => Boolean): Boolean =
      TreeOps.forall(a)(f)

    @inline
    def exists(f: Tree => Boolean): Boolean =
      TreeOps.exists(a)(f)

    @inline
    def contains[F[_ <: Tree]](toFind: Tree)(implicit conv: Tree => F[Tree],
                                             eqEv: Equal[F[Tree]]): Boolean =
      TreeOps.contains(a)(toFind)
  }
}

object TreeExtensions extends TreeExtensions
