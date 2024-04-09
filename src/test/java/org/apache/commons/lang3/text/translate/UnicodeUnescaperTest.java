package org.apache.commons.lang3.text.translate;

import org.apache.commons.text.translate.UnicodeUnescaper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

public class UnicodeUnescaperTest {

    @Test
    public void testTranslate_basicCase() throws IOException {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        int consumed = unescaper.translate("\\u0041", 0, writer);
        assertEquals(6, consumed); // consumed 6 characters including '\\u0041'
        assertEquals("A", writer.toString()); // translated correctly
    }

    @Test
    public void testTranslate_multipleU() throws IOException {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        int consumed = unescaper.translate("\\uu0041", 0, writer);
        assertEquals(7, consumed); // consumed 7 characters including '\\uu0041'
        assertEquals("A", writer.toString()); // translated correctly
    }

    @Test
    public void testTranslate_withPlus() throws IOException {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        int consumed = unescaper.translate("\\u+0041", 0, writer);
        assertEquals(7, consumed); // consumed 7 characters including '\\u+0041'
        assertEquals("A", writer.toString()); // translated correctly
    }

    @Test
    public void testTranslate_incompleteInput() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate("\\u004", 0, writer));
    }

    @Test
    public void testTranslate_invalidHexDigits() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate("\\u00G1", 0, writer));
    }

    @Test
    public void testTranslate_lessThan4HexDigits() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate("\\u004", 0, writer));
    }

    @Test
    public void testTranslate_endOfCharSequence() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        assertThrows(IllegalArgumentException.class, () -> unescaper.translate("\\u0041", 1, writer));
    }
}
