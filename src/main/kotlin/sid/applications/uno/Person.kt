package sid.applications.uno

class Person(name: String, phone: Int) {
    val name: String

    init {
        this.name = name
    }
}

// Same as
class Insaan(name: String, phone: Int) {
    val name = name
}

// Same as
class OnePeople constructor(val name: String, phone: Int)

// Same as
class Human(val name: String, phone: Int)


fun main(args: Array<String>) {
    // All are equal
    val p = Person("John", 332232322)
    val i = Insaan("Michael", 576363334)
    val o = OnePeople("Jaadu", 838394898)
    val h = Human("Rahul", 934332232)

    println(p.name)
    println(i.name)
    println(o.name)
    println(h.name)
}