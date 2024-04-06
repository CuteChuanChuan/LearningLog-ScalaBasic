package lectutes.lecturesChapter3

object Exceptions extends App {
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  
  try {
    getInt(withExceptions = true)
  } catch {
    case e: RuntimeException => println("Runtime exception")
  } finally {
    println("Finally")
  }
  
  private class MyException extends Exception
  private val exception = new MyException
  throw  exception
}
