package lectures

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) n
    else n * factorial(n - 1)
  
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(x = n, accumulator = 1)
  }

  def tailRecConcatString(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else tailRecConcatString(aString, n - 1, accumulator + aString)
  }

  // println(anotherFactorial(n = 5000))
  println(tailRecConcatString(aString = "Io", n = 3, accumulator = ""))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(t = n / 2, isStillPrime = true)
  }

  println(isPrime(n = 20))
  println(isPrime(n = 29))

  def fibonacci(n: Int): Int = {
    def fibonacciTailrec(t: Int, last: Int, nextToLast: Int): Int = {
      if (t > n) last
      else fibonacciTailrec(t + 1, last + nextToLast, last)
    }
    if (n <= 2) 1
    else fibonacciTailrec(3, 1, 1)
  }
  println(fibonacci(8))
}
