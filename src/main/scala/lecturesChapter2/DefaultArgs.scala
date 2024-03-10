package lecturesChapter2

object DefaultArgs extends App {
  def tractFactorial(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else tractFactorial(n - 1, n * accumulator)
  }
  
  println(tractFactorial(10, 2))
  println(tractFactorial(10))
}
