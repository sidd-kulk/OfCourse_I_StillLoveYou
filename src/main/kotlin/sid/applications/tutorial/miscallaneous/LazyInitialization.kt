package sid.applications.tutorial.miscallaneous

import sid.applications.tutorial.models.ComplexNumber
import kotlin.math.exp

fun lateInit(){ // avoids nullable types
    lateinit var lateComer: ComplexNumber
    expensiveOperation()
//    println(lateComer)  // compiler error
    lateComer = ComplexNumber(expensiveOperation(), expensiveOperation())
    println(lateComer)
    lateComer = ComplexNumber(expensiveOperation(), expensiveOperation()) // duplicate intialization possible®
    println(lateComer)

}

fun lazyInit(){
    val lazyInit: Double by lazy { expensiveOperation() } // function scoped method, hence values not persisted across method calls
    val secondLazy: String by lazy { lazyInit.plus(11).toString() }

    println("An Inexpensive operation") // executes inline since eager evaluation

    // Methods not called till variables are used here
    if(lazyInit > 13) {
        println(secondLazy) // It also initializes `lazyInt` because of the dependency
        println(lazyInit)
    }
}

fun expensiveOperation(): Double {
    println("expensive operation starts")
    Thread.sleep(1000)
    println("expensive operation stops")
    return Math.random()*25
}

fun main(){
//    lazyInit()
    lateInit()
}