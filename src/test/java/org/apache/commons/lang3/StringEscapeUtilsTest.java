package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;

public class StringEscapeUtilsTest {


    @Test
    void testEscapeXml() {
        // Test with null input
        assertNull(StringEscapeUtils.escapeXml(null));

        // Test with empty input
        assertEquals("", StringEscapeUtils.escapeXml(""));

        // Test with no special characters
        assertEquals("abc", StringEscapeUtils.escapeXml("abc"));

        // Test with special characters
        assertEquals("&lt;abc&gt;", StringEscapeUtils.escapeXml("<abc>"));
        assertEquals("&quot;abc&quot;", StringEscapeUtils.escapeXml("\"abc\""));
        assertEquals("&amp;abc&amp;", StringEscapeUtils.escapeXml("&abc&"));
    }

    @Test
    void escapeXml11_noSpecialCharacters() {
        String input = "Hello, World!";
        String expected = "Hello, World!";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }

    @Test
    void escapeXml11_ampersandCharacter() {
        String input = "AT&T";
        String expected = "AT&amp;T";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }

    @Test
    void escapeXml11_lessThanCharacter() {
        String input = "<tag>";
        String expected = "&lt;tag&gt;";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }

    @Test
    void escapeXml11_greaterThanCharacter() {
        String input = "3 > 2";
        String expected = "3 &gt; 2";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }

    @Test
    void escapeXml11_quotationMarkCharacter() {
        String input = "She said, \"Hello!\"";
        String expected = "She said, &quot;Hello!&quot;";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }

    @Test
    void escapeXml11_singleQuoteCharacter() {
        String input = "It's mine";
        String expected = "It&apos;s mine";
        String result = StringEscapeUtils.escapeXml11(input);
        assertEquals(expected, result);
    }




    private StringEscapeUtils stringEscapeUtils;



    @Test
    void testEscapeJson_NullInput() {
        assertNull(stringEscapeUtils.escapeJson(null));
    }

    @Test
    void testEscapeJson_NoSpecialCharacters() {
        assertEquals("Hello World", stringEscapeUtils.escapeJson("Hello World"));
    }

    @Test
    void testEscapeJson_EmptyString() {
        assertEquals("", stringEscapeUtils.escapeJson(""));
    }



    @Test
    void testEscapeJson_LargeInput() {
        String input = "";
        for (int i = 0; i < 100000; i++) {
            input += "a";
        }
        assertEquals(input, stringEscapeUtils.escapeJson(input));
    }




    @Test
    void testTranslateCsvEscaper() {
        // Test cases here
    }

    @Test
    void testTranslateCsvUnescaper() {
        // Test cases here
    }

    @Test
    void testTranslateEscapeJava() {
        // Test cases here
    }

    @Test
    void testTranslateEscapeHtml() {
        // Test cases here
    }

    @Test
    void testTranslateEscapeXml10() {
        // Test cases here
    }

    @Test
    void testTranslateEscapeXml11() {
        // Test cases here
    }

    @Test
    void testTranslateEscapeCsv() {
        // Test cases here
    }

    @Test
    void testTranslateUnescapeJava() {
        // Test cases here
    }

    @Test
    void testTranslateUnescapeHtml() {
        // Test cases here
    }

    @Test
    void testTranslateUnescapeXml() {
        // Test cases here
    }

    @Test
    void testTranslateUnescapeCsv() {
        // Test cases here
    }

    @Test
    public void testUnescapeHtml4_NullInput_ReturnsNull() {
        String input = null;
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertNull(result);
    }

    @Test
    public void testUnescapeHtml4_EmptyInput_ReturnsEmptyString() {
        String input = "";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("", result);
    }

    @Test
    public void testUnescapeHtml4_NoEscapedCharacters_ReturnsSameString() {
        String input = "Hello, world!";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("Hello, world!", result);
    }

    @Test
    public void testUnescapeHtml4_EscapedCharacters_ReturnsUnescapedString() {
        String input = "&lt;div&gt;Hello, &quot;world&quot;!&lt;/div&gt;";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("<div>Hello, \"world\"!</div>", result);
    }

    @Test
    public void testUnescapeHtml4_EscapedCharactersWithNumericEntities_ReturnsUnescapedString() {
        String input = "&lt;div&gt;Hello, &#34;world&#34;!&lt;/div&gt;";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("<div>Hello, \"world\"!</div>", result);
    }


    @Test
    public void testUnescapeHtml4_DecimalEntities_ReturnsUnescapedString() {
        String input = "&lt;div&gt;Hello, &#34;world&#34;!&lt;/div&gt;";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("<div>Hello, \"world\"!</div>", result);
    }

    @Test
    public void testUnescapeHtml4_HexadecimalEntities_ReturnsUnescapedString() {
        String input = "&lt;div&gt;Hello, &#x22;world&#x22;!&lt;/div&gt;";
        String result = stringEscapeUtils.unescapeHtml4(input);
        Assertions.assertEquals("<div>Hello, \"world\"!</div>", result);
    }

    // Test empty string
    @Test
    void testUnescapeHtml3() {
        StringEscapeUtils utils = new StringEscapeUtils();
        assertEquals("", utils.unescapeHtml3(""));
    }

    // Test string with no escaped characters
    @Test
    void testUnescapeHtml3_noEscapedCharacters() {
        StringEscapeUtils utils = new StringEscapeUtils();
        assertEquals("abc", utils.unescapeHtml3("abc"));
    }


    // Test string with multiple escaped characters
    @Test
    void testUnescapeHtml3_multipleEscapedCharacters() {
        StringEscapeUtils utils = new StringEscapeUtils();
        assertEquals("<a>", utils.unescapeHtml3("&lt;a&gt;"));
        assertEquals("\"Hello, World!\"", utils.unescapeHtml3("&quot;Hello, World!&quot;"));
        assertEquals("&copy;", utils.unescapeHtml3("&amp;copy;"));
    }



    @Test
    void testUnescapeJson() {
        // Test cases for unescaping JSON
        assertEquals("Hello, World!", StringEscapeUtils.unescapeJson("Hello, World!"));
        assertEquals("\"Hello, World!\"", StringEscapeUtils.unescapeJson("\\\"Hello, World!\\\""));
        assertEquals("\\Hello\\", StringEscapeUtils.unescapeJson("\\\\Hello\\\\"));
        assertEquals("\\\"", StringEscapeUtils.unescapeJson("\\\\\\\""));
    }

    @Test
    @DisplayName("Should escape special characters")
    void shouldEscapeSpecialCharacters() {
        assertEquals("He didn\\'t say, \\\"Stop!\\\"", stringEscapeUtils.escapeEcmaScript("He didn't say, \"Stop!\""));
    }

    @Test
    @DisplayName("Should escape backslash")
    void shouldEscapeBackslash() {
        assertEquals("\\\\", stringEscapeUtils.escapeEcmaScript("\\"));
    }

    @Test
    @DisplayName("Should escape forward slash")
    void shouldEscapeForwardSlash() {
        assertEquals("\\/", stringEscapeUtils.escapeEcmaScript("/"));
    }


    @Test
    @DisplayName("Should escape control characters")
    void shouldEscapeControlCharacters() {
        assertEquals("\\u0000", stringEscapeUtils.escapeEcmaScript("\u0000"));
    }

    @Test
    @DisplayName("Should escape characters above 0x7f")
    void shouldEscapeCharactersAbove0x7f() {
        assertEquals("\\u0080", stringEscapeUtils.escapeEcmaScript("\u0080"));
    }


    @Test
    void testUnescapeJava() {
        StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();

        // Test empty string input
        String empty = "";
        assertEquals(empty, stringEscapeUtils.unescapeJava(empty));

        // Test string with no escaped characters
        String noEscapes = "Hello World";
        assertEquals(noEscapes, stringEscapeUtils.unescapeJava(noEscapes));

        // Test string with escaped characters
        String escaped = "\\\"Hello\\\", World!";
        assertEquals("\"Hello\", World!", stringEscapeUtils.unescapeJava(escaped));

        // Test string with unicode escape sequence
        String unicodeEscape = "\\u0048\\u0065\\u006c\\u006c\\u006f";
        assertEquals("Hello", stringEscapeUtils.unescapeJava(unicodeEscape));

        // Test string with escaped backslash
        String escapedBackslash = "\\\\Hello\\\\";
        assertEquals("\\Hello\\", stringEscapeUtils.unescapeJava(escapedBackslash));
    }

    @Test
    void testEscapeCsv_NullInput_ReturnsNull() {
        String result = stringEscapeUtils.escapeCsv(null);
        assertNull(result);
    }

    @Test
    void testEscapeCsv_NoSpecialCharacters_ReturnsInputString() {
        String input = "Hello World";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals(input, result);
    }

    @Test
    void testEscapeCsv_ContainsComma_ReturnsQuotedString() {
        String input = "Hello, World";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"" + input + "\"", result);
    }

    @Test
    void testEscapeCsv_ContainsDoubleQuote_ReturnsQuotedStringWithEscapedDoubleQuote() {
        String input = "Hello \"World\"";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"Hello \"\"World\"\"\"", result);
    }

    @Test
    void testEscapeCsv_ContainsNewline_ReturnsQuotedString() {
        String input = "Hello\nWorld";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"" + input + "\"", result);
    }

    @Test
    void testEscapeCsv_ContainsCarriageReturn_ReturnsQuotedString() {
        String input = "Hello\rWorld";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"" + input + "\"", result);
    }

    @Test
    void testEscapeCsv_ContainsCommaAndDoubleQuote_ReturnsQuotedStringWithEscapedDoubleQuote() {
        String input = "Hello, \"World\"";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"Hello, \"\"World\"\"\"", result);
    }

    @Test
    void testEscapeCsv_ContainsCommaAndNewline_ReturnsQuotedString() {
        String input = "Hello,\nWorld";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"" + input + "\"", result);
    }

    @Test
    void testEscapeCsv_ContainsCommaAndCarriageReturn_ReturnsQuotedString() {
        String input = "Hello,\rWorld";
        String result = stringEscapeUtils.escapeCsv(input);
        assertEquals("\"" + input + "\"", result);
    }

    @Test
    @DisplayName("should escape double quotes")
    void testEscapeDoubleQuotes() {
        String input = "\"Hello World\"";
        String expected = "\\\"Hello World\\\"";
        assertEquals(expected, StringEscapeUtils.escapeJava(input));
    }

    @Test
    @DisplayName("should escape backslashes")
    void testEscapeBackslashes() {
        String input = "C:\\Program Files";
        String expected = "C:\\\\Program Files";
        assertEquals(expected, StringEscapeUtils.escapeJava(input));
    }

    @Test
    @DisplayName("should escape control characters")
    void testEscapeControlCharacters() {
        String input = "Hello\nWorld";
        String expected = "Hello\\nWorld";
        assertEquals(expected, StringEscapeUtils.escapeJava(input));
    }

    @Test
    @DisplayName("should unescape double quotes")
    void testUnescapeDoubleQuotes() {
        String input = "\\\"Hello World\\\"";
        String expected = "\"Hello World\"";
        assertEquals(expected, StringEscapeUtils.unescapeJava(input));
    }

    @Test
    @DisplayName("should unescape backslashes")
    void testUnescapeBackslashes() {
        String input = "C:\\\\Program Files";
        String expected = "C:\\Program Files";
        assertEquals(expected, StringEscapeUtils.unescapeJava(input));
    }

    @Test
    @DisplayName("should unescape control characters")
    void testUnescapeControlCharacters() {
        String input = "Hello\\nWorld";
        String expected = "Hello\nWorld";
        assertEquals(expected, StringEscapeUtils.unescapeJava(input));
    }

    @Test
    public void testEscapeHtml4() {
        String input = "He didn't say, \"Stop!\"";
        String expected = "He didn't say, &quot;Stop!&quot;";
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEscapeHtml4_NullInput() {
        String input = null;
        String expected = null;
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEscapeHtml4_EmptyInput() {
        String input = "";
        String expected = "";
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEscapeHtml4_NoSpecialCharacters() {
        String input = "Hello World";
        String expected = "Hello World";
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEscapeHtml4_SpecialCharacters() {
        String input = "<p>Hello, World!</p>";
        String expected = "&lt;p&gt;Hello, World!&lt;/p&gt;";
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testEscapeHtml4_MixedSpecialCharacters() {
        String input = "He didn't say, \"Stop!\" <p>Hello, World!</p>";
        String expected = "He didn't say, &quot;Stop!&quot; &lt;p&gt;Hello, World!&lt;/p&gt;";
        String result = stringEscapeUtils.escapeHtml4(input);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescapeXml with null input")
    void testUnescapeXmlWithNullInput() {
        String input = null;
        String expected = null;
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unescapeXml with empty input")
    void testUnescapeXmlWithEmptyInput() {
        String input = "";
        String expected = "";
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unescapeXml with no escaped characters")
    void testUnescapeXmlWithNoEscapedCharacters() {
        String input = "hello world";
        String expected = "hello world";
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unescapeXml with escaped characters")
    void testUnescapeXmlWithEscapedCharacters() {
        String input = "&lt;hello&gt;";
        String expected = "<hello>";
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unescapeXml with multiple escaped characters")
    void testUnescapeXmlWithMultipleEscapedCharacters() {
        String input = "&lt;hello&gt;&amp;world&amp;";
        String expected = "<hello>&world&";
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test unescapeXml with invalid escaped characters")
    void testUnescapeXmlWithInvalidEscapedCharacters() {
        String input = "&lt;hello&gt;&invalid;&amp;world";
        String expected = "<hello>&invalid;&world";
        String actual = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, actual);
    }

}