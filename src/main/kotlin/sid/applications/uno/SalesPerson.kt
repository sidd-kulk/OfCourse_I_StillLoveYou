package sid.applications.uno

open class Financier(val name: String, val quota: Double)

class SalesPerson(
    private val registrationId: Long,
    name: String,
    quota: Double = 1_00_000.0) :
      Financier(name, quota),
      Comparable<Long> {

    constructor(financier: Financier):  this(32344433, financier.name, financier.quota)

    fun isQuotaMet(prescribedQuota: Long): Boolean {
        return prescribedQuota <= quota
    }

    override fun compareTo(other: Long): Int {
        return registrationId.compareTo(other)
    }
}

// Separate
class Lineance(var degree: LongArray)

fun talk(){
    val l = Lineance(LongArray(3))
    l.degree = LongArray(33)
}