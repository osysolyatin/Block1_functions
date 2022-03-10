const val CARD_MAX_LIMIT_FOR_TRANSFER_DAY = 150_000U
const val CARD_MAX_LIMIT_FOR_TRANSFER_MONTH = 600_000U
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_AT_ONCE = 15_000U
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH = 40_000U
const val MIN_COMMISSION = 35U
const val TRANSACTION_COMMISSION = 0.075
const val TRANSMISSION_COMMISSION_MASTERCARD = 0.06

fun main() {
    var amountTransferPerMonth = 0U
    var amountTransferCurrent = inputTransferAmount()
    amountTransferPerMonth+=amountTransferCurrent
    println("Сумма перевода в месяц: $amountTransferPerMonth")
    calculateCommission ("MASTERCARD", transferRubToCoins(amountTransferPerMonth), transferRubToCoins(amountTransferCurrent))
}

fun inputTransferAmount () :UInt {
    var input = 0U
    while (true) {
        try {
            print("Введите сумму перевода: ")
            input = readLine()?.toUInt() ?: return input
            break
        } catch (e: Exception) {
            println("Неверное число, попробуйте еще раз")
        }
    }
    return input
}

fun transferRubToCoins (amountRUB : UInt) : UInt {
    return amountRUB * 100U
}

fun toPrintInRubAndCoins (amountCoins : UInt)  {
    val RUB = amountCoins / 100U
    return println("Сумма перевода, включая комиссию составляет: $RUB рублей и ${RUB%100U} копеек")
}

fun calculateCommission (cardType:String = "VK_PAY", amountTransferPerMonth : UInt = 0U, amountTransferCurrent : UInt) :UInt {
    var commission = 0U
    when (cardType) {
        "VK_PAY" -> commission = 0U
        "Mastercard" -> {
            commission = if (amountTransferPerMonth <= 75_000U) 0U
            else (amountTransferCurrent * TRANSMISSION_COMMISSION_MASTERCARD.toUInt()) + (20U * 100U)
        }
    }


    return 0U
}