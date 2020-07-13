package sid.applications.extensions

fun <T, K> Collection<T>.uniqueBy(selector: (T) -> K): Collection<T> {
    val thisList = this

    val returnList = mutableListOf<T>()

    if (thisList.isEmpty()) {
        return returnList
    }

    val mapForUniqueness = mutableMapOf<K, Int>()

    for (a in thisList) {
        val key = selector(a)
        val count = mapForUniqueness.getOrElse(key){ 0 }
        if(count == 0) {
            returnList.add(a)
        }

        mapForUniqueness[key] = count + 1
    }

    return returnList
}