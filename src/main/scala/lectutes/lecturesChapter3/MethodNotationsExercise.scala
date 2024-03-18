package lectutes.lecturesChapter3

import scala.language.postfixOps

object MethodNotationsExercise extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def +(nickName: String) : Person =
      new Person(name = s"${name} ($nickName)", favoriteMovie = favoriteMovie, age = age)
    
    def unary_+ : Person = new Person(name = name, favoriteMovie = favoriteMovie, age = age + 1)
    
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = this learns "Scala"
    
    def apply(times: Int): String = s"$name watches $favoriteMovie $times times."
      
  }
  
  val mary: Person = new Person(name = "mary", favoriteMovie = "Movie1", age = 18)
  val maryWithNickName = mary.+(nickName = "Nick")
  println(maryWithNickName.name)
  
  val maryIncrement = +mary
  println(maryIncrement.age)
  
  println(mary.learns(subject = "Scala"))
  println(mary.learnsScala)
  println(mary learnsScala)
  
  println(mary(2))
}
