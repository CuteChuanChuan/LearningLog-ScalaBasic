package lectutes.lecturesChapter3

object InheritanceAndTraits extends App {
  // single class inheritance
  class Animal {
    def eat: Unit = println("mmmmmm")
  }
  class Cat extends Animal
  
  val cat = new Cat
  cat.eat
  
  
  // constructor
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  
  class Adult(name: String, age: Int, idCard: String) extends Person(name)
  
  // overriding
  class Dog extends Animal {
    override def eat = println("crunch")
  }
  val dog = new Dog
  dog.eat
}
