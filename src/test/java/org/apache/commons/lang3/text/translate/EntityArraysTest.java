package org.apache.commons.lang3.text.translate;

import static org.apache.commons.lang3.text.translate.EntityArrays.APOS_UNESCAPE;
import static org.apache.commons.lang3.text.translate.EntityArrays.JAVA_CTRL_CHARS_ESCAPE;
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


import org.apache.commons.text.StringEscapeUtils;
import org.junit.jupiter.api.*;

public class EntityArraysTest {

    private EntityArrays entityArrays;

    @BeforeEach
    public void setup() {
        entityArrays = new EntityArrays();
    }



    @Test
    public void testISO8859_1_ESCAPE() {
        String[][] expectedEscape = {
                {"\u00A0", "&nbsp;"},
                {"\u00A1", "&iexcl;"},
                {"\u00A2", "&cent;"},
                {"\u00A3", "&pound;"},
                {"\u00A4", "&curren;"},
                {"\u00A5", "&yen;"},
                {"\u00A6", "&brvbar;"},
                {"\u00A7", "&sect;"},
                {"\u00A8", "&uml;"},
                {"\u00A9", "&copy;"},
                {"\u00AA", "&ordf;"},
                {"\u00AB", "&laquo;"},
                {"\u00AC", "&not;"},
                {"\u00AD", "&shy;"},
                {"\u00AE", "&reg;"},
                {"\u00AF", "&macr;"},
                {"\u00B0", "&deg;"},
                {"\u00B1", "&plusmn;"},
                {"\u00B2", "&sup2;"},
                {"\u00B3", "&sup3;"},
                {"\u00B4", "&acute;"},
                {"\u00B5", "&micro;"},
                {"\u00B6", "&para;"},
                {"\u00B7", "&middot;"},
                {"\u00B8", "&cedil;"},
                {"\u00B9", "&sup1;"},
                {"\u00BA", "&ordm;"},
                {"\u00BB", "&raquo;"},
                {"\u00BC", "&frac14;"},
                {"\u00BD", "&frac12;"},
                {"\u00BE", "&frac34;"},
                {"\u00BF", "&iquest;"},
                {"\u00C0", "&Agrave;"},
                {"\u00C1", "&Aacute;"},
                {"\u00C2", "&Acirc;"},
                {"\u00C3", "&Atilde;"},
                {"\u00C4", "&Auml;"},
                {"\u00C5", "&Aring;"},
                {"\u00C6", "&AElig;"},
                {"\u00C7", "&Ccedil;"},
                {"\u00C8", "&Egrave;"},
                {"\u00C9", "&Eacute;"},
                {"\u00CA", "&Ecirc;"},
                {"\u00CB", "&Euml;"},
                {"\u00CC", "&Igrave;"},
                {"\u00CD", "&Iacute;"},
                {"\u00CE", "&Icirc;"},
                {"\u00CF", "&Iuml;"},
                {"\u00D0", "&ETH;"},
                {"\u00D1", "&Ntilde;"},
                {"\u00D2", "&Ograve;"},
                {"\u00D3", "&Oacute;"},
                {"\u00D4", "&Ocirc;"},
                {"\u00D5", "&Otilde;"},
                {"\u00D6", "&Ouml;"},
                {"\u00D7", "&times;"},
                {"\u00D8", "&Oslash;"},
                {"\u00D9", "&Ugrave;"},
                {"\u00DA", "&Uacute;"},
                {"\u00DB", "&Ucirc;"},
                {"\u00DC", "&Uuml;"},
                {"\u00DD", "&Yacute;"},
                {"\u00DE", "&THORN;"},
                {"\u00DF", "&szlig;"},
                {"\u00E0", "&agrave;"},
                {"\u00E1", "&aacute;"},
                {"\u00E2", "&acirc;"},
                {"\u00E3", "&atilde;"},
                {"\u00E4", "&auml;"},
                {"\u00E5", "&aring;"},
                {"\u00E6", "&aelig;"},
                {"\u00E7", "&ccedil;"},
                {"\u00E8", "&egrave;"},
                {"\u00E9", "&eacute;"},
                {"\u00EA", "&ecirc;"},
                {"\u00EB", "&euml;"},
                {"\u00EC", "&igrave;"},
                {"\u00ED", "&iacute;"},
                {"\u00EE", "&icirc;"},
                {"\u00EF", "&iuml;"},
                {"\u00F0", "&eth;"},
                {"\u00F1", "&ntilde;"},
                {"\u00F2", "&ograve;"},
                {"\u00F3", "&oacute;"},
                {"\u00F4", "&ocirc;"},
                {"\u00F5", "&otilde;"},
                {"\u00F6", "&ouml;"},
                {"\u00F7", "&divide;"},
                {"\u00F8", "&oslash;"},
                {"\u00F9", "&ugrave;"},
                {"\u00FA", "&uacute;"},
                {"\u00FB", "&ucirc;"},
                {"\u00FC", "&uuml;"},
                {"\u00FD", "&yacute;"},
                {"\u00FE", "&thorn;"},
                {"\u00FF", "&yuml;"}
        };

        String[][] actualEscape = entityArrays.ISO8859_1_ESCAPE();

        assertEquals(expectedEscape.length, actualEscape.length);

        for (int i = 0; i < expectedEscape.length; i++) {
            assertEquals(expectedEscape[i][0], actualEscape[i][0]);
            assertEquals(expectedEscape[i][1], actualEscape[i][1]);
        }
    }

    @Test
    public void testISO8859_1_UNESCAPE() {
        String[][] expectedUnescape = {
                {"&nbsp;", "\u00A0"},
                {"&iexcl;", "\u00A1"},
                {"&cent;", "\u00A2"},
                {"&pound;", "\u00A3"},
                {"&curren;", "\u00A4"},
                {"&yen;", "\u00A5"},
                {"&brvbar;", "\u00A6"},
                {"&sect;", "\u00A7"},
                {"&uml;", "\u00A8"},
                {"&copy;", "\u00A9"},
                {"&ordf;", "\u00AA"},
                {"&laquo;", "\u00AB"},
                {"&not;", "\u00AC"},
                {"&shy;", "\u00AD"},
                {"&reg;", "\u00AE"},
                {"&macr;", "\u00AF"},
                {"&deg;", "\u00B0"},
                {"&plusmn;", "\u00B1"},
                {"&sup2;", "\u00B2"},
                {"&sup3;", "\u00B3"},
                {"&acute;", "\u00B4"},
                {"&micro;", "\u00B5"},
                {"&para;", "\u00B6"},
                {"&middot;", "\u00B7"},
                {"&cedil;", "\u00B8"},
                {"&sup1;", "\u00B9"},
                {"&ordm;", "\u00BA"},
                {"&raquo;", "\u00BB"},
                {"&frac14;", "\u00BC"},
                {"&frac12;", "\u00BD"},
                {"&frac34;", "\u00BE"},
                {"&iquest;", "\u00BF"},
                {"&Agrave;", "\u00C0"},
                {"&Aacute;", "\u00C1"},
                {"&Acirc;", "\u00C2"},
                {"&Atilde;", "\u00C3"},
                {"&Auml;", "\u00C4"},
                {"&Aring;", "\u00C5"},
                {"&AElig;", "\u00C6"},
                {"&Ccedil;", "\u00C7"},
                {"&Egrave;", "\u00C8"},
                {"&Eacute;", "\u00C9"},
                {"&Ecirc;", "\u00CA"},
                {"&Euml;", "\u00CB"},
                {"&Igrave;", "\u00CC"},
                {"&Iacute;", "\u00CD"},
                {"&Icirc;", "\u00CE"},
                {"&Iuml;", "\u00CF"},
                {"&ETH;", "\u00D0"},
                {"&Ntilde;", "\u00D1"},
                {"&Ograve;", "\u00D2"},
                {"&Oacute;", "\u00D3"},
                {"&Ocirc;", "\u00D4"},
                {"&Otilde;", "\u00D5"},
                {"&Ouml;", "\u00D6"},
                {"&times;", "\u00D7"},
                {"&Oslash;", "\u00D8"},
                {"&Ugrave;", "\u00D9"},
                {"&Uacute;", "\u00DA"},
                {"&Ucirc;", "\u00DB"},
                {"&Uuml;", "\u00DC"},
                {"&Yacute;", "\u00DD"},
                {"&THORN;", "\u00DE"},
                {"&szlig;", "\u00DF"},
                {"&agrave;", "\u00E0"},
                {"&aacute;", "\u00E1"},
                {"&acirc;", "\u00E2"},
                {"&atilde;", "\u00E3"},
                {"&auml;", "\u00E4"},
                {"&aring;", "\u00E5"},
                {"&aelig;", "\u00E6"},
                {"&ccedil;", "\u00E7"},
                {"&egrave;", "\u00E8"},
                {"&eacute;", "\u00E9"},
                {"&ecirc;", "\u00EA"},
                {"&euml;", "\u00EB"},
                {"&igrave;", "\u00EC"},
                {"&iacute;", "\u00ED"},
                {"&icirc;", "\u00EE"},
                {"&iuml;", "\u00EF"},
                {"&eth;", "\u00F0"},
                {"&ntilde;", "\u00F1"},
                {"&ograve;", "\u00F2"},
                {"&oacute;", "\u00F3"},
                {"&ocirc;", "\u00F4"},
                {"&otilde;", "\u00F5"},
                {"&ouml;", "\u00F6"},
                {"&divide;", "\u00F7"},
                {"&oslash;", "\u00F8"},
                {"&ugrave;", "\u00F9"},
                {"&uacute;", "\u00FA"},
                {"&ucirc;", "\u00FB"},
                {"&uuml;", "\u00FC"},
                {"&yacute;", "\u00FD"},
                {"&thorn;", "\u00FE"},
                {"&yuml;", "\u00FF"}
        };

        String[][] actualUnescape = entityArrays.ISO8859_1_UNESCAPE();

        assertEquals(expectedUnescape.length, actualUnescape.length);

        for (int i = 0; i < expectedUnescape.length; i++) {
            assertEquals(expectedUnescape[i][0], actualUnescape[i][0]);
            assertEquals(expectedUnescape[i][1], actualUnescape[i][1]);
        }
    }

    @Test
    public void testBasicEscape() {
        String[][] basicEscape = EntityArrays.BASIC_ESCAPE();
        for (String[] escape : basicEscape) {
            String original = escape[0];
            String expected = escape[1];
            String result = StringEscapeUtils.escapeHtml4(original);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testBasicUnescape() {
        String[][] basicUnescape = EntityArrays.BASIC_UNESCAPE();
        for (String[] unescape : basicUnescape) {
            String original = unescape[0];
            String expected = unescape[1];
            String result = StringEscapeUtils.unescapeHtml4(original);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testJavaCtrlCharsEscape2() {
        String[][] javaCtrlCharsEscape = JAVA_CTRL_CHARS_ESCAPE();
        for (String[] escape : javaCtrlCharsEscape) {
            String original = escape[0];
            String expected = escape[1];
            String result = StringEscapeUtils.escapeJava(original);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testJavaCtrlCharsUnescape3() {
        String[][] javaCtrlCharsUnescape = EntityArrays.JAVA_CTRL_CHARS_UNESCAPE();
        for (String[] unescape : javaCtrlCharsUnescape) {
            String original = unescape[0];
            String expected = unescape[1];
            String result = StringEscapeUtils.unescapeJava(original);
            assertEquals(expected, result);
        }
    }

    @Test
    public void testHtml40ExtendedUnescapeWithInvalidUnescapedChars() {
        String[][] html40ExtendedUnescape = entityArrays.HTML40_EXTENDED_UNESCAPE();

        // Test with invalid unescaped characters
        String[] invalidUnescapedChars = {"\u1111", "\u2222", "\u3333"};
        for (String unescaped : invalidUnescapedChars) {
            String escaped = unescaped;
            String result = StringEscapeUtils.unescapeHtml4(escaped);
            assertEquals(unescaped, result);
        }
    }

    @Test
    public void testHtml40ExtendedUnescapeWithEmptyString() {
        String[][] html40ExtendedUnescape = entityArrays.HTML40_EXTENDED_UNESCAPE();

        // Test with empty string
        String escaped = "";
        String unescaped = "";
        String result = StringEscapeUtils.unescapeHtml4(escaped);
        assertEquals(unescaped, result);
    }

    @Test
    public void testHtml40ExtendedUnescapeWithNullString() {
        String[][] html40ExtendedUnescape = entityArrays.HTML40_EXTENDED_UNESCAPE();

        // Test with null string
        String escaped = null;
        String unescaped = null;
        String result = StringEscapeUtils.unescapeHtml4(escaped);
        assertEquals(unescaped, result);
    }

    @Test
    public void testHtml40ExtendedUnescapeWithMixedEscapedAndUnescapedChars() {
        String[][] html40ExtendedUnescape = entityArrays.HTML40_EXTENDED_UNESCAPE();

        // Test with mixed escaped and unescaped characters
        String[] mixedChars = {"&Agrave;", "&iexcl;", "hello", "&pound;"};
        for (String escaped : mixedChars) {
            String unescaped = StringEscapeUtils.unescapeHtml4(escaped);
            String result = StringEscapeUtils.unescapeHtml4(unescaped);
            assertEquals(unescaped, result);
        }
    }


    @Test
    public void testUnescapeNonBreakingSpace() {
        String escaped = "&nbsp;";
        String expected = "\u00A0";
        String unescaped = StringEscapeUtils.unescapeHtml4(escaped);
        Assertions.assertEquals(expected, unescaped);
    }

    @Test
    public void testUnescapeInvertedExclamationMark() {
        String escaped = "&iexcl;";
        String expected = "\u00A1";
        String unescaped = StringEscapeUtils.unescapeHtml4(escaped);
        Assertions.assertEquals(expected, unescaped);
    }

    @Test
    public void testUnescapeUnknownEscapeSequence() {
        String escaped = "&unknown;";
        String expected = "&unknown;";
        String unescaped = StringEscapeUtils.unescapeHtml4(escaped);
        Assertions.assertEquals(expected, unescaped);
    }

    @Test
    public void testUnescapeNull() {
        String escaped = null;
        String expected = null;
        String unescaped = StringEscapeUtils.unescapeHtml4(escaped);
        Assertions.assertEquals(expected, unescaped);
    }

    @Test
    public void testUnescapeBackspaceCharacter() {
        String escaped = "\\b";
        String unescaped = "\b";

        String result = StringEscapeUtils.unescapeJava(escaped);

        Assertions.assertEquals(unescaped, result);
    }

    @Test
    public void testUnescapeNewLineCharacter() {
        String escaped = "\\n";
        String unescaped = "\n";

        String result = StringEscapeUtils.unescapeJava(escaped);

        Assertions.assertEquals(unescaped, result);
    }

    @Test
    public void testUnescapeTabCharacter() {
        String escaped = "\\t";
        String unescaped = "\t";

        String result = StringEscapeUtils.unescapeJava(escaped);

        Assertions.assertEquals(unescaped, result);
    }

    @Test
    public void testUnescapeFormFeedCharacter() {
        String escaped = "\\f";
        String unescaped = "\f";

        String result = StringEscapeUtils.unescapeJava(escaped);

        Assertions.assertEquals(unescaped, result);
    }

    @Test
    public void testUnescapeCarriageReturnCharacter() {
        String escaped = "\\r";
        String unescaped = "\r";

        String result = StringEscapeUtils.unescapeJava(escaped);

        Assertions.assertEquals(unescaped, result);
    }


}