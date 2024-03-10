package lecturesChapter2

object CallByNameVsCallByVaule extends App {
  def callByValue(x: Long): Unit = {
    println("by value " + x)
    println("by value " + x)
  }
  
  def callByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }
  
  callByValue(System.nanoTime())
  callByName(System.nanoTime())
}
