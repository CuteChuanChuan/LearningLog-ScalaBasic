package lectures

object Functions extends App {
    def greetFunction(name: String, age: Int): String = {
        "Hi, my name is " + name + " and I am " + age + " years old."
    }

    def factorialFunction(n: Int): Int = {
        if (n == 0) 1
        else n * factorialFunction(n - 1)
    }

    def fibonacciFunction(n: Int): Int = {
        if (n == 1 | n == 2) 1
        else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)
    }

    def isPrime(n: Int): Boolean = {
        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t - 1)
        }
        isPrimeUntil(t = n / 2)
    }

    println(greetFunction(name = "Ray", age = 12))
    println(factorialFunction(n = 3))
    println(fibonacciFunction(7))
    println(isPrime(27))
}
