package lectutes.lecturesChapter3

object Generics extends App {
  class MyList[+SpecificType] {
    def add[B >: SpecificType](element: B): MyList[B] = ???
  }

  val listOfInt    = new MyList[Int]
  val listOfString = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. covariance
  class CovarianceList[+A]
  val animal: Animal                     = new Cat
  val animalList: CovarianceList[Animal] = new CovarianceList[Cat]
  // animalList.add(new Dog) ?? -> a list of animals

  // 2. invariance
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded tpyes
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car)
}
