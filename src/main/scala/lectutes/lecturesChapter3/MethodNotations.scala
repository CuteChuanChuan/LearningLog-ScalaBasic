package lectutes.lecturesChapter3

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    
    // add space between ! and : otherwise compiler will regard : as part of method name
    def unary_! : String = s"$name, WOW~"
    
    def isAlive: Boolean = true
    
    // apply needs parenthesis
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }
  
  val mary = new Person(name = "Mary", favoriteMovie = "Inception")
  println(mary.likes(movie = "Inception"))
  println(mary likes "Inception") //infix notation or operator (syntactic sugar)
  
  val tom = new Person(name = "Tom", favoriteMovie = "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))
  
  // All operators are methods
  println(1 * 3)
  println(1.*(3))
  
  // prefix notation
  // unary_ prefix only works with - + ~ !
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  println(!mary)
  println(mary.unary_!)
  
  // functions do not receive any parameters -> postfix notation
  println(mary.isAlive)
  println(mary isAlive)
  
  // apply
  println(mary.apply())
  println(mary())
}
