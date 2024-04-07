import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class isWhitespaceTest {
	
	private StringUtils stringUtils;
	
	@BeforeEach
	void setup() {
		stringUtils = new StringUtils();
	}
	
	@Nested
	@DisplayName("Positive Cases")
	class PositiveCases {
		
		@Test
		@DisplayName("Empty String should return true")
		void testIsWhitespaceWithEmptyString() {
			assertTrue(stringUtils.isWhitespace(""));
		}
		
		@Test
		@DisplayName("String with only spaces should return true")
		void testIsWhitespaceWithSpaces() {
			assertTrue(stringUtils.isWhitespace("  "));
		}
		
		@Test
		@DisplayName("String with only tabs should return true")
		void testIsWhitespaceWithTabs() {
			assertTrue(stringUtils.isWhitespace("\t\t"));
		}
		
		@Test
		@DisplayName("String with only linefeed should return true")
		void testIsWhitespaceWithLinefeed() {
			assertTrue(stringUtils.isWhitespace("\n\n"));
		}
		
		@Test
		@DisplayName("String with only carriage return should return true")
		void testIsWhitespaceWithCarriageReturn() {
			assertTrue(stringUtils.isWhitespace("\r\r"));
		}
		
		@Test
		@DisplayName("String with all whitespace characters should return true")
		void testIsWhitespaceWithAllWhitespaceCharacters() {
			assertTrue(stringUtils.isWhitespace(" \t\n\r"));
		}
	}
	
	@Nested
	@DisplayName("Negative Cases")
	class NegativeCases {
		
		@Test
		@DisplayName("String with non-whitespace characters should return false")
		void testIsWhitespaceWithNonWhitespaceCharacters() {
			assertFalse(stringUtils.isWhitespace("abc"));
		}
		
		@Test
		@DisplayName("String with alphanumeric characters should return false")
		void testIsWhitespaceWithAlphanumericCharacters() {
			assertFalse(stringUtils.isWhitespace("ab2c"));
		}
		
		@Test
		@DisplayName("String with special characters should return false")
		void testIsWhitespaceWithSpecialCharacters() {
			assertFalse(stringUtils.isWhitespace("ab-c"));
		}
	}
	
	@Nested
	@DisplayName("Edge Cases")
	class EdgeCases {
		
		@Test
		@DisplayName("Null String should return false")
		void testIsWhitespaceWithNullString() {
			assertFalse(stringUtils.isWhitespace(null));
		}
		
		@Test
		@DisplayName("String with leading and trailing spaces should return false")
		void testIsWhitespaceWithLeadingAndTrailingSpaces() {
			assertFalse(stringUtils.isWhitespace(" abc "));
		}
	}
}