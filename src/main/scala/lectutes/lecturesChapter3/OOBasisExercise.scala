package lectutes.lecturesChapter3

import java.io.Writer

object OOBasisExercise extends App {
  val author = new Writer(firstName = "Charles", lastname = "Dickens", year = 1812)
  val novel = new Novel(name = "Great Expectations", yearReleased = 1861, author = author)
  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(authorProvided = author))
  println(novel.isWrittenBy(authorProvided = new Writer(firstName = "Charles", lastname = "Dickenss", year = 2024)))
  val novelNew = novel.copy(newYearReleased = 2025)
  println(novelNew.authorAge)
  
  val counter = new Counter(n = 0)
  counter.inc.printCounter()
  counter.inc.inc.inc.printCounter()
  counter.inc(n = 20).inc.inc.printCounter()
  
}

class Writer(firstName: String, lastname: String, val year: Int) {
  def fullName: String = s"$firstName $lastname"
  
}

class Novel(name: String, yearReleased: Int, author: Writer) {
  def authorAge: Int = yearReleased - author.year
  
  def isWrittenBy(authorProvided: Writer): Boolean = authorProvided == author
  
  def copy(newYearReleased: Int): Novel = new Novel(name, newYearReleased, author)
}

class Counter(val n: Int = 0) {
  private def count: Int = n
  
  def inc: Counter = {
    println("incrementing")
    new Counter(count + 1)
  }
  
  def dec: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }
  
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }
  
  def printCounter(): Unit = println(count)
}