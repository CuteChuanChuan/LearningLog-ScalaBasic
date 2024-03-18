package lectutes.lecturesChapter3

// Scala object = Singleton instance
object ScalaObjects {
  //static-level functionality
  object Person {
    val numEyes: Int = 2
    def canFly: Boolean = false
    
    // factory method
    def from(mother: Person, father: Person): Person = new Person(name = "Bobbie")
  }
  // instance-level functionality
  class Person(name: String) {
  
  }
  // companions = write class and object in same file and same names
}
