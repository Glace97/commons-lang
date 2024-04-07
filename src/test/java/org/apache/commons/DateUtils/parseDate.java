import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class parseDateTest {

	@Test
	void testParseDate_ValidInput() throws ParseException {
		String dateStr = "2022-01-01";
		Date expected = new Date(122, 0, 1);
		Date actual = DateUtils.parseDate(dateStr, "yyyy-MM-dd");
		assertEquals(expected, actual);
	}

	@Test
	void testParseDate_InvalidInput() {
		String dateStr = "2022/01/01";
		assertThrows(ParseException.class, () -> {
			DateUtils.parseDate(dateStr, "yyyy-MM-dd");
		});
	}

	@Test
	void testParseDate_Leniency() throws ParseException {
		String dateStr = "2022-01-32";
		Date expected = new Date(122, 0, 31);
		Date actual = DateUtils.parseDate(dateStr, "yyyy-MM-dd");
		assertEquals(expected, actual);
	}

	@Test
	void testParseDate_CustomLocale() throws ParseException {
		String dateStr = "01 Jan 2022";
		Date expected = new Date(122, 0, 1);
		Date actual = DateUtils.parseDate(dateStr, Locale.ENGLISH, "dd MMM yyyy");
		assertEquals(expected, actual);
	}

	@Test
	void testParseDate_MultiplePatterns() throws ParseException {
		String dateStr = "01-01-2022";
		Date expected = new Date(122, 0, 1);
		Date actual = DateUtils.parseDate(dateStr, "dd-MM-yyyy", "yyyy-MM-dd");
		assertEquals(expected, actual);
	}

	@Test
	void testParseDate_NullInput() {
		assertThrows(NullPointerException.class, () -> {
			DateUtils.parseDate(null, "yyyy-MM-dd");
		});
	}

	@Test
	void testParseDate_NullPatterns() {
		String dateStr = "2022-01-01";
		assertThrows(NullPointerException.class, () -> {
			DateUtils.parseDate(dateStr, (String[]) null);
		});
	}

	@Test
	void testParseDate_EmptyPatterns() {
		String dateStr = "2022-01-01";
		assertThrows(IllegalArgumentException.class, () -> {
			DateUtils.parseDate(dateStr);
		});
	}

}
Note: This test suite covers the valid input, invalid input, leniency, custom locale, multiple patterns, null input, null patterns, and empty patterns cases.