package sid.applications.uno

abstract class Financier(val name: String, val quota: Double) {
    abstract fun isQuotaMet(prescribedQuota: Long): Boolean
}

class SalesPerson(
    internal val registrationId: Long,
    name: String,
    quota: Double = 1_00_000.0) :
      Financier(name, quota),
      Comparable<Long> {

    constructor(financier: Financier):  this(32344433, financier.name, financier.quota)

    override fun isQuotaMet(prescribedQuota: Long): Boolean {
        return prescribedQuota <= quota
    }

    override fun compareTo(other: Long): Int {
        return registrationId.compareTo(other)
    }
}

fun main() {
    val financier: Financier = SalesPerson(34334, "Togo")
    financier.name
    financier.quota
    financier.isQuotaMet(343)
    if(financier is SalesPerson) {
        financier.registrationId  // Smart cast
    }
}