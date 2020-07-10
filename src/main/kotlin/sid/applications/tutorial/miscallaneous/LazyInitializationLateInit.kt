package sid.applications.tutorial.miscallaneous

import sid.applications.tutorial.models.ComplexNumber
import java.io.File
import java.util.*

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

fun lateInitializations(){ // Measuring memory usage
    val lazyString: List<String> by lazy { readFileAsLinesUsingUseLines("/usr/local/Cellar/ansible/2.9.10/libexec/lib/python3.8/site-packages/netaddr/eui/oui.txt") }

    val init = Runtime.getRuntime().freeMemory()
    lazyString[12]
    lazyString[12]
    val last = Runtime.getRuntime().freeMemory()
    println("${(init - last)/ 1e+6}  Mb")
}

fun readFileAsLinesUsingUseLines(fileName: String): List<String>  = File(fileName).useLines { it.toList() } + File(fileName).useLines { it.toList() } + File(fileName).useLines { it.toList() }


fun main(){
//    lazyInit()
//    lateInit()
    lateInitializations()
}


