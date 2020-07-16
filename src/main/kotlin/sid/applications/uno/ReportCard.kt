package sid.applications.uno

data class ReportCard(private val subject: Subject, private val marks: Int, private val outOf: Byte = 100)

enum class Subject {
    MATH, SCIENCE, LANGUAGE, SOCIAL
}

fun main(){
    val card = ReportCard(Subject.MATH, 77)
    val anotherCard = ReportCard(Subject.SCIENCE, 76)
    val yetAnotherCard = ReportCard(Subject.SCIENCE, 76)

    println(card == anotherCard)
    println(anotherCard == yetAnotherCard)
    println(anotherCard.equals(yetAnotherCard))
}
