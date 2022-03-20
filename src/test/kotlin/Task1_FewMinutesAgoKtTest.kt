import org.junit.Test

import org.junit.Assert.*

class Task1FewMinutesAgoKtTest {

    @Test
    fun convertMinutesAndHoursIntoText_minutes_22() {
        // arrange
        val agoTimeTest = 22

        //act

        val result = convertMinutesAndHoursIntoText(agoTimeTest, arrayOf("минуту", "минуты", "минут"))

        // assert

        assertEquals("минуты", result)
    }

    @Test
    fun convertMinutesAndHoursIntoText_minutes_5() {
        // arrange
        val agoTimeTest = 5

        //act

        val result = convertMinutesAndHoursIntoText(agoTimeTest, arrayOf("минуту", "минуты", "минут"))

        // assert

        assertEquals("минут", result)
    }

    @Test
    fun convertMinutesAndHoursIntoText_minutes_21() {
        // arrange
        val agoTimeTest = 21

        //act

        val result = convertMinutesAndHoursIntoText(agoTimeTest, arrayOf("минуту", "минуты", "минут"))

        // assert

        assertEquals("минуту", result)
    }

}