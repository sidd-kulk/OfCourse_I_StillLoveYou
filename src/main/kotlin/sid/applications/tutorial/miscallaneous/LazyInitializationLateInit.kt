package sid.applications.tutorial.miscallaneous

import sid.applications.tutorial.models.ComplexNumber

val initValue: Double by lazy { expensiveOperation("initValue") }

fun lateInit(){ // avoids nullable types
    lateinit var lateComer: ComplexNumber
    expensiveOperation()
//    println(lateComer)  // compiler error
    lateComer = ComplexNumber(expensiveOperation("lateComer"), expensiveOperation("lateComer"))
    println(lateComer)
    lateComer = ComplexNumber(expensiveOperation(), expensiveOperation()) // duplicate intialization possible®
    println(lateComer)

}

fun lazyInit(){
    val lazyInit: Double by lazy { expensiveOperation("lazyInit") } // function scoped method, hence values not persisted across method calls
    val secondLazy: String by lazy { lazyInit.plus(11).toString() }

    println("An Inexpensive operation") // executes inline since eager evaluation

    // Methods not called till variables are used here
    if(lazyInit > 13) {
        println(secondLazy) // It also initializes `lazyInt` because of the dependency
        println(lazyInit)
    }
}

fun expensiveOperation(identifier: String = "Default"): Double {
    println("expensive operation starts for $identifier")
    Thread.sleep(1000)
    println("expensive operation stops for $identifier")
    return Math.random() * 25
}

fun main(){
//    lazyInit()
    lateInit()
}