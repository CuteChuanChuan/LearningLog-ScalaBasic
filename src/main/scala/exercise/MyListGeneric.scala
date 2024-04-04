package exercise

abstract class MyListGeneric[+A] {
  def head: A
  def tail: MyListGeneric[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyListGeneric[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object EmptyListGeneric extends MyListGeneric[Nothing] {
  def head: Nothing                = throw new NoSuchElementException
  def tail: MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean             = true
  def add[B >: Nothing](element: B): MyListGeneric[B] =
    new ConsGeneric(element, EmptyListGeneric)
  def printElements: String = ""
}

class ConsGeneric[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A                                   = h
  def tail: MyListGeneric[A]                    = t
  def isEmpty: Boolean                          = false
  def add[B >: A](element: B): MyListGeneric[B] = new ConsGeneric(element, this)
  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }
}

object GenericListTest extends App {
  val listInt: MyListGeneric[Int] = new ConsGeneric[Int](
    1,
    new ConsGeneric[Int](2, new ConsGeneric[Int](3, EmptyListGeneric))
  )
  println(listInt.toString)
  val listStr: MyListGeneric[String] = new ConsGeneric[String](
    "first",
    new ConsGeneric[String](
      "second",
      new ConsGeneric[String]("three", EmptyListGeneric)
    )
  )
  println(listStr.toString)
}
