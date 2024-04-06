package lectutes.lecturesChapter3

object Enum {
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE
    
    def openDocument(): Unit =
      if (this == READ) println("Opening document")
      else println("reading not allowed")
  }
  
  enum PermissionWithBits(bits: Int) {
    case READ extends PermissionWithBits(4)
    case WRITE extends PermissionWithBits(2)
    case EXECUTE extends PermissionWithBits(1)
    case NONE extends PermissionWithBits(0)
  }
  
  object PermissionWithBits {
    def fromBits(bit: Int): PermissionWithBits = PermissionWithBits.NONE
  }
  
  val somePermissions: Permissions = Permissions.READ
  val somePermissionsValues: Int = somePermissions.ordinal
  val allPermissionsValues = PermissionWithBits.values // array of all possible values of the enum
  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsValues)
    println(allPermissionsValues)
  }
}
