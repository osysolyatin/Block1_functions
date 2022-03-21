import Cards.*

const val CARD_MAX_LIMIT_FOR_TRANSFER_DAY = 150_000 * 100
const val CARD_MAX_LIMIT_FOR_TRANSFER_MONTH = 600_000 * 100
const val CARD_MIN_LIMIT_WITHOUT_COMMISSION = 300 * 100
const val CARD_MAX_LIMIT_WITHOUT_COMMISSION = 75_000 * 100
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_AT_ONCE = 15_000 * 100
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH = 40_000 * 100
const val MIN_COMMISSION = 35 * 100
const val TRANSACTION_COMMISSION_VISA_MIR = 0.0075
const val TRANSACTION_COMMISSION_MASTERCARD = 0.006
const val TRANSACTION_COMMISSION_FIX_MASTERCARD = 20 * 100

enum class Cards {
    VISA, MASTERCARD, MAESTRO, VK_PAY, MIR
}

fun main() {
    var amountTransferPerMonth = 0
    val amountTransferCurrent = 0
    val card = VISA

    while (checkLimits(amountTransferCurrent, amountTransferPerMonth, card)) {
        val amountTransferCurrent = convertRubToCoins (inputTransferAmount())
        amountTransferPerMonth += amountTransferCurrent

        if (checkLimits(amountTransferCurrent, amountTransferPerMonth,card)) {
            println("Сумма перевода в текущем месяце: ${amountTransferPerMonth / 100} рублей")
            val commission = calculateCommission(
                amountTransferPerMonth,
                amountTransferCurrent,
                card
            )
            printInRubAndCoins(amountTransferCurrent, commission)
        } else break
    }

}

fun inputTransferAmount(): Int {
    var input =0
    while (true) {
        try {
            print("Введите сумму перевода в рублях: ")
            input = readLine()?.toInt() ?: return input
            break
        } catch (e: Exception) {
            println("Неверное число, попробуйте еще раз")
        }
    }
    return input
}

fun convertRubToCoins(amountRUB: Int): Int {
    return amountRUB * 100
}

fun checkLimits (amountTransferCurrentCheck: Int, amountTransferPerMonthCheck: Int, cardType: Cards = MASTERCARD) : Boolean {
    when (cardType) {
        MASTERCARD, MAESTRO, VISA, MIR -> {
            return if (amountTransferPerMonthCheck > CARD_MAX_LIMIT_FOR_TRANSFER_MONTH) {
                println("Превышение месячного лимита")
                false
            } else if (amountTransferCurrentCheck > CARD_MAX_LIMIT_FOR_TRANSFER_DAY) {
                println("Превышение дневного лимита")
                false
            } else true
        }
        VK_PAY -> {
            return if (amountTransferCurrentCheck > VK_PAY_MAX_LIMIT_FOR_TRANSFER_AT_ONCE) {
                println("Превышен дневной  лимиит переводов со счета VK Pay")
                false
            } else if (amountTransferPerMonthCheck > VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH) {
                println("Превышен месячный лимит переводов со счёта VK Pay")
                false
            } else true
        }
    }
}

fun printInRubAndCoins(amountTransfer: Int, commission: Int) {
    val sumRub = (commission + amountTransfer) / 100
    val sumCoins = (commission + amountTransfer) - (sumRub * 100)
    val commRub = commission / 100
    val commCoins = commission - commRub * 100
    println(
        "Комиссия за перевод составила: $commRub руб и $commCoins копеек или $commission копеек\n" +
                "Сумма перевода, включая комиссию составляет: $sumRub рублей и $sumCoins копеек"
    )

}

fun calculateCommission(amountTransferPerMonth: Int, amountTransferCurrent: Int, cardType: Cards = VK_PAY): Int {
    return when (cardType) {
        VISA, MIR -> {
            val commission = (amountTransferCurrent * TRANSACTION_COMMISSION_VISA_MIR).toInt()
            return if (commission < MIN_COMMISSION) MIN_COMMISSION
            else commission
        }
        MASTERCARD, MAESTRO -> {
            if (amountTransferPerMonth in CARD_MIN_LIMIT_WITHOUT_COMMISSION..CARD_MAX_LIMIT_WITHOUT_COMMISSION) 0
            else ((amountTransferCurrent * TRANSACTION_COMMISSION_MASTERCARD) + TRANSACTION_COMMISSION_FIX_MASTERCARD).toInt()
        }
        VK_PAY -> 0
    }

}

