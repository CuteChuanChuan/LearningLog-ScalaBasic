package lectutes.lecturesChapter3

object AnonymousClass extends App {
  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahahaha")

  }
  println(funnyAnimal.getClass)
}
