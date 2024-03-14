package lectutes.lecturesChapter2

object StringOps extends App {
  val aString: String = "Scala Python"
  println(aString.charAt(2))
  println(aString.substring(0, 2))
  println(aString.split(" ").toList)
  println(aString.startsWith("S"))
  println(aString.replace(" ", " - "))
  println(aString.toLowerCase)
  println(aString.toLowerCase())
  println(aString.length())
  
  val aNumberInString: String = "45"
  println(aNumberInString.toInt)
  println("a" +: aNumberInString :+ "z") // prepending & appending
  println(aString.reverse)
  println(aString.take(n = 5))
  
  val name: String = "David"
  val age: Int = 12
  val greetings: String = s"I am $name, and $age years old."
  val greetings_1: String = s"I am $name, and ${age + 1} years old."
  println(greetings)
  println(greetings_1)
  
  val height: Float = 1.2f
  val greetings_2: String = f"I am $name%s, and ${age + 1} years old and I am $height%2.2f cm."
  println(greetings_2)
  
  println(raw"This is a \n newline")
  
  val escaped: String = "This is a \n newline"
  println(raw"$escaped")
  
}
