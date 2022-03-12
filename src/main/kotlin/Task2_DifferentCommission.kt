import Cards.*

const val CARD_MAX_LIMIT_FOR_TRANSFER_DAY = 150_000
const val CARD_MAX_LIMIT_FOR_TRANSFER_MONTH = 600_000
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_AT_ONCE = 15_000
const val VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH = 40_000
const val MIN_COMMISSION = 35
const val TRANSACTION_COMMISSION_VISA_MIR = 0.0075
const val TRANSACTION_COMMISSION_MASTERCARD = 0.006

enum class Cards {
    VISA, MASTERCARD, MAESTRO, VK_PAY, MIR
}

fun main() {
    var amountTransferPerMonth = 0
    do {
        val amountTransferCurrent = inputTransferAmount()
        amountTransferPerMonth += amountTransferCurrent
        if (amountTransferCurrent > CARD_MAX_LIMIT_FOR_TRANSFER_DAY) {
            println("Превышение дневного лимита")
            break
        }
        if (amountTransferPerMonth > CARD_MAX_LIMIT_FOR_TRANSFER_MONTH) {
            println("Превышение месячного лимита")
            break
        }
        println("Сумма перевода в текущем месяце: $amountTransferPerMonth")
        val commission = calculateCommission(
            MASTERCARD,
            amountTransferPerMonth = transferRubToCoins(amountTransferPerMonth),
            amountTransferCurrent = transferRubToCoins(amountTransferCurrent)
        )

        toPrintInRubAndCoins(transferRubToCoins(amountTransferCurrent), commission)

    } while (amountTransferPerMonth < CARD_MAX_LIMIT_FOR_TRANSFER_MONTH || amountTransferPerMonth < VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH)
}

fun inputTransferAmount(): Int {
    var input = 0
    while (true) {
        try {
            print("Введите сумму перевода: ")
            input = readLine()?.toInt() ?: return input
            break
        } catch (e: Exception) {
            println("Неверное число, попробуйте еще раз")
        }
    }
    return input
}

fun transferRubToCoins(amountRUB: Int): Int {
    return amountRUB * 100
}

fun toPrintInRubAndCoins(amountTransfer: Int, commission: Int) {
    val sumRub = (commission + amountTransfer) / 100
    val sumCoins = (commission + amountTransfer) - (sumRub * 100)
    val commRub = commission / 100
    val commCoins = commission - commRub * 100
    return println(
        "Комиссия за перевод составила: $commRub руб и $commCoins копеек или $commission копеек\n" +
                "Сумма перевода, включая комиссию составляет: $sumRub рублей и $sumCoins копеек"
    )

}

fun calculateCommission(cardType: Cards = VK_PAY, amountTransferPerMonth: Int = 0, amountTransferCurrent: Int): Int {
    return when (cardType) {
        VISA, MIR -> {
            val commission = (amountTransferCurrent * TRANSACTION_COMMISSION_VISA_MIR).toInt()
            return if (commission < transferRubToCoins(MIN_COMMISSION)) transferRubToCoins(MIN_COMMISSION)
            else commission
        }
        MASTERCARD, MAESTRO -> {
            if (amountTransferPerMonth <= transferRubToCoins(75_000)) 0
            else ((amountTransferCurrent * TRANSACTION_COMMISSION_MASTERCARD) + (transferRubToCoins(20))).toInt()
        }
        VK_PAY -> if (amountTransferCurrent > transferRubToCoins(VK_PAY_MAX_LIMIT_FOR_TRANSFER_AT_ONCE))
            error("Превышен дневной  лимиит переводов со счета VK Pay")
            else if (amountTransferPerMonth > transferRubToCoins(VK_PAY_MAX_LIMIT_FOR_TRANSFER_MONTH))
            error("Превышен месячный лимит переводов со счёта VK Pay")
            else 0
    }

}

