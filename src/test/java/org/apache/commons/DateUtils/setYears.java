import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setYearsTest {

    @Test
    void testSetYears() {
        // Test with positive amount
        Date date1 = new Date(119, 0, 1); // January 1, 2019
        Date expected1 = new Date(119 + 5, 0, 1); // January 1, 2024
        assertEquals(expected1, DateUtils.setYears(date1, 5));

        // Test with negative amount
        Date date2 = new Date(120, 0, 1); // January 1, 2020
        Date expected2 = new Date(120 - 3, 0, 1); // January 1, 2017
        assertEquals(expected2, DateUtils.setYears(date2, -3));

        // Test with zero amount
        Date date3 = new Date(121, 0, 1); // January 1, 2021
        Date expected3 = new Date(121, 0, 1); // January 1, 2021
        assertEquals(expected3, DateUtils.setYears(date3, 0));
    }
}