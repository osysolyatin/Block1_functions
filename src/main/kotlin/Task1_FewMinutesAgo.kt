const val SECONDS_IN_MINUTE = 60
const val SECONDS_IN_HOUR = 3600
const val SECONDS_IN_DAY = 86400
const val SECONDS_IN_2_DAYS = 172800
const val SECONDS_IN_3_DAYS = 259200

fun main() {

    val agoTime = 7200
    println(agoToText(agoTime))
}
fun convertMinutesAndHoursIntoText(agoTime: Int, text: Array<String>): String {
    val num100 = agoTime % 100
    val num10 = num100 % 10
    return if (num100 in 5..20) text[2]
    else return when (num10) {
        1 -> text[0]
        in 2..4 -> text[1]
        else -> text[2]
    }
}
fun agoToText(agoTime: Int): String {
    return when (agoTime) {
        in 0..SECONDS_IN_MINUTE -> "был(а) только что"
        in SECONDS_IN_MINUTE + 1..SECONDS_IN_HOUR -> {
            val agoTimeConvert = agoTime / SECONDS_IN_MINUTE
            return "был(а) в сети $agoTimeConvert ${
                convertMinutesAndHoursIntoText(
                    agoTimeConvert,
                    arrayOf("минуту", "минуты", "минут")
                )
            } назад"
        }
        in SECONDS_IN_HOUR + 1..SECONDS_IN_DAY -> {
            val agoTimeConvert = agoTime / SECONDS_IN_HOUR
            return "был(а) в сети $agoTimeConvert ${
                convertMinutesAndHoursIntoText(
                    agoTimeConvert,
                    arrayOf("час", "часа", "часов")
                )
            } назад"
        }
        in SECONDS_IN_DAY + 1..SECONDS_IN_2_DAYS -> "был(а) в сети сегодня" //от суток до двух
        in SECONDS_IN_2_DAYS + 1..SECONDS_IN_3_DAYS -> "был(а) в сети вчера" // от двух суток до трёх
        else -> "был(а) в сети давно"
    }
}

