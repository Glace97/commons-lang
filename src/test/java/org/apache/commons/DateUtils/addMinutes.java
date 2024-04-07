import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class addMinutesTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Nested
    @DisplayName("Positive Tests")
    class PositiveTests {
    
        @Test
        @DisplayName("Test adding positive minutes")
        void testAddPositiveMinutes() {
            Date date = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0).getTime();
            int minutesToAdd = 30;
            
            Date result = dateUtils.addMinutes(date, minutesToAdd);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(30, calendar.get(Calendar.MINUTE));
        }
        
        @Test
        @DisplayName("Test adding zero minutes")
        void testAddZeroMinutes() {
            Date date = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0).getTime();
            int minutesToAdd = 0;
            
            Date result = dateUtils.addMinutes(date, minutesToAdd);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            
            assertEquals(12, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
        }
        
        @Test
        @DisplayName("Test adding negative minutes")
        void testAddNegativeMinutes() {
            Date date = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0).getTime();
            int minutesToAdd = -30;
            
            Date result = dateUtils.addMinutes(date, minutesToAdd);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            
            assertEquals(11, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(30, calendar.get(Calendar.MINUTE));
        }
        
        @Test
        @DisplayName("Test adding minutes to midnight")
        void testAddMinutesToMidnight() {
            Date date = new GregorianCalendar(2022, Calendar.JANUARY, 1, 0, 0).getTime();
            int minutesToAdd = 30;
            
            Date result = dateUtils.addMinutes(date, minutesToAdd);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            
            assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(30, calendar.get(Calendar.MINUTE));
        }
        
        @Test
        @DisplayName("Test adding minutes to end of day")
        void testAddMinutesToEndOfDay() {
            Date date = new GregorianCalendar(2022, Calendar.JANUARY, 1, 23, 30).getTime();
            int minutesToAdd = 30;
            
            Date result = dateUtils.addMinutes(date, minutesToAdd);
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(result);
            
            assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
            assertEquals(0, calendar.get(Calendar.MINUTE));
        }
        
    }
    
    @Nested
    @DisplayName("Negative Tests")
    class NegativeTests {
        
        @Test
        @DisplayName("Test adding minutes to null date")
        void testAddMinutesToNullDate() {
            assertThrows(NullPointerException.class, () -> {
                dateUtils.addMinutes(null, 30);
            });
        }
        
    }
    
}