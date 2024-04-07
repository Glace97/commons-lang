import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class addWeeksTest {

  private DateUtils dateUtils;

  @BeforeEach
  void setUp() {
    dateUtils = new DateUtils();
  }

  @Test
  void testAddWeeksPositive() {
    Date date = createDate(2022, Calendar.JANUARY, 1);
    Date expected = createDate(2022, Calendar.JANUARY, 8);
    Date result = dateUtils.addWeeks(date, 1);
    assertNotNull(result);
    assertEquals(expected, result);
  }

  @Test
  void testAddWeeksNegative() {
    Date date = createDate(2022, Calendar.JANUARY, 8);
    Date expected = createDate(2022, Calendar.JANUARY, 1);
    Date result = dateUtils.addWeeks(date, -1);
    assertNotNull(result);
    assertEquals(expected, result);
  }

  @Test
  void testAddWeeksZero() {
    Date date = createDate(2022, Calendar.JANUARY, 1);
    Date expected = createDate(2022, Calendar.JANUARY, 1);
    Date result = dateUtils.addWeeks(date, 0);
    assertNotNull(result);
    assertEquals(expected, result);
  }

  @Test
  void testAddWeeksNull() {
    assertThrows(NullPointerException.class, () -> dateUtils.addWeeks(null, 1));
  }

  private Date createDate(int year, int month, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day);
    return calendar.getTime();
  }
}