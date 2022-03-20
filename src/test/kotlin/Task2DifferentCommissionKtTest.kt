import org.junit.Test

import org.junit.Assert.*

class Task2DifferentCommissionKtTest {

    @Test
    fun checkLimits_mastercard_true() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(70_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = checkLimits(amountTransferCurrentTest, amountTransferPerMonthTest,cardType)

        // assert
        assertEquals(true,true)
    }

    @Test
    fun checkLimits_mastercard_false() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(151_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = checkLimits(amountTransferCurrentTest, amountTransferPerMonthTest,cardType)

        // assert
        assertEquals(false,false)
    }

    @Test
    fun checkLimits_vkPay_true() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(30_000)
        val amountTransferCurrentTest = convertRubToCoins(10_000)

        // act
        val result = checkLimits(amountTransferCurrentTest, amountTransferPerMonthTest,cardType)

        // assert
        assertEquals(true,true)
    }

    @Test
    fun checkLimits_vkPay_false() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(41_000)
        val amountTransferCurrentTest = convertRubToCoins(16_000)

        // act
        val result = checkLimits(amountTransferCurrentTest, amountTransferPerMonthTest,cardType)

        // assert
        assertEquals(false,false)
    }

    @Test
    fun calculateCommission_mastercard_zero() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(70_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_mastercard_notZero() {
        // arrange
        val cardType : Cards = Cards.MASTERCARD
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(2600,result)
    }

    @Test
    fun calculateCommission_maestro_zero() {
        // arrange
        val cardType : Cards = Cards.MAESTRO
        val amountTransferPerMonthTest = convertRubToCoins(70_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(0, result)
    }
    @Test
    fun calculateCommission_maestro_notZero() {
        // arrange
        val cardType : Cards = Cards.MAESTRO
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(2600,result)
    }

    @Test
    fun calculateCommission_visa() {
        // arrange
        val cardType : Cards = Cards.VISA
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(5_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(3750,result)
    }
    @Test
    fun calculateCommission_visa_minCommission() {
        // arrange
        val cardType : Cards = Cards.VISA
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(3500,result)
    }

    @Test
    fun calculateCommission_mir() {
        // arrange
        val cardType : Cards = Cards.MIR
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(5_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(3750,result)
    }
    @Test
    fun calculateCommission_mir_minCommission() {
        // arrange
        val cardType : Cards = Cards.MIR
        val amountTransferPerMonthTest = convertRubToCoins(76_000)
        val amountTransferCurrentTest = convertRubToCoins(1_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(3500,result)
    }


    @Test
    fun calculateCommission_vkPay() {
        // arrange
        val cardType : Cards = Cards.VK_PAY
        val amountTransferPerMonthTest = convertRubToCoins(30_000)
        val amountTransferCurrentTest = convertRubToCoins(10_000)

        // act
        val result = calculateCommission (amountTransferPerMonthTest,amountTransferCurrentTest, cardType)

        // assert
        assertEquals(0,result)
    }

}