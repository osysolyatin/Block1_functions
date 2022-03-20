import org.junit.Test

import org.junit.Assert.*

class Task2DifferentCommissionKtTest {

    @Test
    fun calculateCommission_mastercard_zero() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = transferRubToCoins(70_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_mastercard_notZero() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(2600,result)
    }

    @Test
    fun calculateCommission_maestro_zero() {
        // arrange
        val cardType : Cards = Cards.MAESTRO
        val amountTransferPerMonthTest = transferRubToCoins(70_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_maestro_notZero() {
        // arrange
        val cardType : Cards = Cards.MAESTRO
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(2600,result)
    }

    @Test
    fun calculateCommission_visa() {
        // arrange
        val cardType : Cards = Cards.VISA
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(5_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(3750,result)
    }
    @Test
    fun calculateCommission_visa_minCommission() {
        // arrange
        val cardType : Cards = Cards.VISA
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(3500,result)
    }

    @Test
    fun calculateCommission_mir() {
        // arrange
        val cardType : Cards = Cards.MIR
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(5_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(3750,result)
    }
    @Test
    fun calculateCommission_mir_minCommission() {
        // arrange
        val cardType : Cards = Cards.MIR
        val amountTransferPerMonthTest = transferRubToCoins(76_000)
        val amountTransferCurrentTest = transferRubToCoins(1_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(3500,result)
    }


    @Test
    fun calculateCommission_vkPay() {
        // arrange
        val cardType : Cards = Cards.VK_PAY
        val amountTransferPerMonthTest = transferRubToCoins(30_000)
        val amountTransferCurrentTest = transferRubToCoins(10_000)

        // act
        val result = calculateCommission (cardType,amountTransferPerMonthTest,amountTransferCurrentTest)

        // assert
        assertEquals(0,result)
    }

}