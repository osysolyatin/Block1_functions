const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3600
const val SECONDS_IN_DAY = 86400
const val SECONDS_IN_2_DAYS = 172800
const val SECONDS_IN_3_DAYS = 259200

fun main() {

    val agoTime = 79200
    println(agoToText(agoTime))
}

fun transferMinutesAndHoursIntoText(agoTime: Int, text: String): String {
    val parameter = when (text) {
        "минут" -> agoTime / SECONDS_IN_MINUTE
        "час" -> agoTime / SECONDS_IN_HOUR
        else -> error("Неподдерживаемый формат времени")
    }
    return when (parameter % 100) {
        1, 21, 31, 41, 51 -> if (text == "минут") "$parameter минуту" else "$parameter час"
        in 2..4, in 22..24 -> if (text == "минут") "$parameter минуты" else "$parameter часа"
        else -> if (text == "минут") "$parameter минут" else "$parameter часов"
    }
}

fun minutesToText(agoTime: Int): String {
    val minutes = (agoTime / SECONDS_IN_MINUTE)
    return when (minutes % 100) {
        1, 21, 31, 41, 51 -> "$minutes минуту"
        in 2..4, in 22..24 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun hoursToText(agoTime: Int): String {
    val hours = (agoTime / SECONDS_IN_HOUR)
    return when (hours % 100) {
        1, 21, 31, 41, 51 -> "$hours час"
        in 2..4, in 22..24 -> "$hours часа"
        else -> "$hours часов"
    }
}

fun agoToText(agoTime: Int): String {
    return when (agoTime) {
        in 0..SECONDS_IN_MINUTE -> "был(а) только что"
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> "был(а) в сети ${transferMinutesAndHoursIntoText(agoTime,"минут")} назад"
        in SECONDS_IN_HOUR + 1..SECONDS_IN_DAY -> "был(а) в сети ${transferMinutesAndHoursIntoText(agoTime,"час")} назад"
        in SECONDS_IN_DAY + 1..SECONDS_IN_2_DAYS -> "был(а) в сети сегодня" //от суток до двух
        in SECONDS_IN_2_DAYS + 1..SECONDS_IN_3_DAYS -> "был(а) в сети вчера" // от двух суток до трёх
        else -> "был(а) в сети давно"
    }
}

