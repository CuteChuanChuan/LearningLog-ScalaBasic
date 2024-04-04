package lectutes.lecturesChapter3

object CaseClasses extends App {
  case class Person(name: String, age: Int)
  // 1. class parameters are fields => if there is no case keyword, the println will fail
  val jim = new Person(name = "Jim", age = 23)
  println(jim.age)
  // 2. sensible toString for debugging
  println(jim.toString)
  println(jim)
  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person(name = "Jim", age = 23)
  println(jim == jim2)
  // 4. handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)
  // 5. companion objects
  val thePerson = Person
  val mary = Person(name = "Mary", age = 23)
  // 6. serializable => akka
  // 7. have extractor patterns => pattern matching
  
  // like case classes except for the companion object part
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
