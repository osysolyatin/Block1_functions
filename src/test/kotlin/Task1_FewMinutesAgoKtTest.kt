import org.junit.Test

import org.junit.Assert.*

class Task1FewMinutesAgoKtTest {

    @Test
    fun plural_22() {
        // arrange
        val agoTimeTest = 22

        //act

        val result = plural(agoTimeTest, "минуту", "минуты", "минут")

        // assert

        assertEquals("минуты", result)
    }

    @Test
    fun plural_5() {
        // arrange
        val agoTimeTest = 5

        //act

        val result = plural(agoTimeTest, "минуту", "минуты", "минут")

        // assert

        assertEquals("минут", result)
    }

    @Test
    fun plural_59() {
        // arrange
        val agoTimeTest = 59

        //act

        val result = plural(agoTimeTest, "минуту", "минуты", "минут")

        // assert

        assertEquals("минут", result)
    }

    @Test
    fun plural_21() {
        // arrange
        val agoTimeTest = 21

        //act

        val result = plural(agoTimeTest, "минуту", "минуты", "минут")

        // assert

        assertEquals("минуту", result)
    }

}