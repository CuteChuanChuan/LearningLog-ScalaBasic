package lectutes.lecturesChapter3

object AbstractDataTypes extends App {
  // abstract -> leave blank and let subclasses to do specification
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }
  
  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("EatEat")
  }
  
  // traits: ultimate abstract data types
  // unlike abstract classes, traits can be inherited along classes
  trait Carnivore {
    def eat(animal: Animal): Unit
    def preferredMeal: String = "Meat"
  }
  
  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    
    override def eat: Unit = "momomomomo"
    
    override def eat(animal: Animal): Unit = println(s"I eat ${animal.creatureType}")
  }
  
  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(animal = dog)
  
  // trait vs. abstract classes
  // abstract classes can have both abstract and non-abstract types, but so can traits
  // 1. traits cannot have constructors (like __init__ in Python), but in Scala 3 this is now possible
  // 2. only can extend 1 class but multiple traits -> ways to inherit multiple classes in Scala
  // 3. choose traits if it describes a type of behavior (a choice actually); abstract classes: a type of thing
}
