package lectutes.lecturesChapter3

object OOBasis extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet(name = "Ray")
  person.greet_2()
}


// parameter of class is not filed -> cannot be accessed by a dot operator
// class parameter vs. class field
// unless add val or var before keyword

// constructor
class Person(name: String, val age: Int = 0) {
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }
  
  def greet_2(): Unit = println(s"Hi, I am $name")
}
