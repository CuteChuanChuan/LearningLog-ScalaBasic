package lecturesChapter2

object ValuesVariablesTypes extends App {
    // val is immutable and type of it is optional
    val x: Int = 42
    println(x)

    val aString: String = "hello"
    val aBoolean: Boolean = false
    val aChar: Char = 'a'
    val anInt: Int = x
    val aShort: Short = 4612
    val aLong: Long = 43211345L
    val aFloat: Float = 3.12f
    val aDouble: Double = 3.12

    var aVariable: Int = 4
    aVariable = 4
}
