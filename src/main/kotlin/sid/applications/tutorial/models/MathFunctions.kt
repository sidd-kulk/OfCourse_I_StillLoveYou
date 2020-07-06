package sid.applications.tutorial.models

fun smallestNumber(vararg numbers: Double): Double {
    return numbers.min()!!
}

fun largestNumber(vararg numbers: Double): Double {
    return numbers.max()!!
}

fun divide(a: Double, b: Double): Double? {
    return if(b == 0.0) null else a/b
}

fun abs(number: Double): Double {
    return kotlin.math.abs(number)
}

data class ComplexNumber (val a: Double, val b: Double) {
    override fun toString(): String {
        return "$a + i$b"
    }

    fun add(complexNumber: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.a + complexNumber.a, this.b + complexNumber.b)
    }

    companion  object  {
        fun add(vararg complexNumbers: ComplexNumber): ComplexNumber {
            TODO("NOT IMPLEMENTED YET")
        }
    }
}