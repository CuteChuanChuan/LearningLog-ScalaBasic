package lectutes.lecturesChapter3

abstract class ObjectOrientedExerciseExpandingCollection[+A] extends App {
  def head: A
  def tail: ObjectOrientedExerciseExpandingCollection[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): ObjectOrientedExerciseExpandingCollection[B]
  def printElements: String

  override def toString: String = "[" + printElements + "]"

  def map[B](
      transformer: MyTransformer[A, B]
  ): ObjectOrientedExerciseExpandingCollection[B]

  def flatMap[B](
      transformer: MyTransformer[A, ObjectOrientedExerciseExpandingCollection[
        B
      ]]
  ): ObjectOrientedExerciseExpandingCollection[B]

  def filter(
      predicate: MyPredicate[A]
  ): ObjectOrientedExerciseExpandingCollection[A]

  def ++[B >: A](
      list: ObjectOrientedExerciseExpandingCollection[B]
  ): ObjectOrientedExerciseExpandingCollection[B]
}

object EmptyListGenericExercise
    extends ObjectOrientedExerciseExpandingCollection[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: ObjectOrientedExerciseExpandingCollection[Nothing] =
    throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](
      element: B
  ): ObjectOrientedExerciseExpandingCollection[B] =
    new ConsListGenericExercise(element, EmptyListGenericExercise)
  def printElements: String = ""

  def map[B](
      transformer: MyTransformer[Nothing, B]
  ): ObjectOrientedExerciseExpandingCollection[B] = EmptyListGenericExercise

  def flatMap[B](
      transformer: MyTransformer[
        Nothing,
        ObjectOrientedExerciseExpandingCollection[
          B
        ]
      ]
  ): ObjectOrientedExerciseExpandingCollection[B] = EmptyListGenericExercise

  def filter(
      predicate: MyPredicate[Nothing]
  ): ObjectOrientedExerciseExpandingCollection[Nothing] =
    EmptyListGenericExercise
  def ++[B >: Nothing](
      list: ObjectOrientedExerciseExpandingCollection[B]
  ): ObjectOrientedExerciseExpandingCollection[B] = list
}

class ConsListGenericExercise[+A](
    h: A,
    t: ObjectOrientedExerciseExpandingCollection[A]
) extends ObjectOrientedExerciseExpandingCollection[A] {
  def head: A                                            = h
  def tail: ObjectOrientedExerciseExpandingCollection[A] = t
  def isEmpty: Boolean                                   = false
  def add[B >: A](element: B): ObjectOrientedExerciseExpandingCollection[B] =
    new ConsListGenericExercise(element, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  def map[B](
      transformer: MyTransformer[A, B]
  ): ObjectOrientedExerciseExpandingCollection[B] = {
    new ConsListGenericExercise(transformer.transform(h), t.map(transformer))
  }

  def flatMap[B](
      transformer: MyTransformer[
        A,
        ObjectOrientedExerciseExpandingCollection[
          B
        ]
      ]
  ): ObjectOrientedExerciseExpandingCollection[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  def filter(
      predicate: MyPredicate[A]
  ): ObjectOrientedExerciseExpandingCollection[A] =
    if (predicate.test(h)) new ConsListGenericExercise(h, t.filter(predicate))
    else t.filter(predicate)
  def ++[B >: A](
      list: ObjectOrientedExerciseExpandingCollection[B]
  ): ObjectOrientedExerciseExpandingCollection[B] =
    new ConsListGenericExercise(h, t ++ list)
}

trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(element: A): B
}

object LinkedListGenericTest extends App {
  val listOfInt: ObjectOrientedExerciseExpandingCollection[Int] =
    new ConsListGenericExercise(
      1,
      new ConsListGenericExercise(
        2,
        new ConsListGenericExercise(3, EmptyListGenericExercise)
      )
    )
  val anotherListOfInt: ObjectOrientedExerciseExpandingCollection[Int] =
    new ConsListGenericExercise(
      4,
      new ConsListGenericExercise(
        5,
        new ConsListGenericExercise(6, EmptyListGenericExercise)
      )
    )
  println(listOfInt.printElements)
  println(listOfInt.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }))
  println(listOfInt.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }))
  println((listOfInt ++ anotherListOfInt).toString)
  println(
    listOfInt.flatMap(
      new MyTransformer[Int, ObjectOrientedExerciseExpandingCollection[Int]] {
        override def transform(
            element: Int
        ): ObjectOrientedExerciseExpandingCollection[Int] =
          new ConsListGenericExercise[Int](
            element,
            new ConsListGenericExercise[Int](
              element + 1,
              EmptyListGenericExercise
            )
          )
      }
    )
  )
}
