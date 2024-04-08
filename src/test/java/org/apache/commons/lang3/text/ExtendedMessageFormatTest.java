package org.apache.commons.lang3.text;

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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ExtendedMessageFormatTest {
    @Test
    public void testHashCode_equalObjects() {
        format1 = new ExtendedMessageFormat("Pattern");
        format2 = new ExtendedMessageFormat("Pattern");
        assertEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_notEqualObjects() {
        format1 = new ExtendedMessageFormat("Pattern1");
        format2 = new ExtendedMessageFormat("Pattern2");
        assertNotEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithLocale() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format2 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        assertEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_notEqualObjectsWithLocale() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format2 = new ExtendedMessageFormat("Pattern", Locale.FRENCH);
        assertNotEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithRegistry() {
        format1 = new ExtendedMessageFormat("Pattern", null);
        format2 = new ExtendedMessageFormat("Pattern", null);
        assertEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_notEqualObjectsWithRegistry() {
        format1 = new ExtendedMessageFormat("Pattern", null);
        format2 = new ExtendedMessageFormat("Pattern", Map.of("key", new FormatFactory()));
        assertNotEquals(format1.hashCode(), format2.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithPatternAndLocale() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format2 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format3 = new ExtendedMessageFormat("Pattern", Locale.FRENCH);
        assertEquals(format1.hashCode(), format2.hashCode());
        assertNotEquals(format1.hashCode(), format3.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithPatternAndRegistry() {
        format1 = new ExtendedMessageFormat("Pattern", null);
        format2 = new ExtendedMessageFormat("Pattern", null);
        format3 = new ExtendedMessageFormat("Pattern", Map.of("key", new FormatFactory()));
        assertEquals(format1.hashCode(), format2.hashCode());
        assertNotEquals(format1.hashCode(), format3.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithLocaleAndRegistry() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format2 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH);
        format3 = new ExtendedMessageFormat("Pattern", Locale.FRENCH);
        assertEquals(format1.hashCode(), format2.hashCode());
        assertNotEquals(format1.hashCode(), format3.hashCode());
    }
    
    @Test
    public void testHashCode_equalObjectsWithPatternLocaleAndRegistry() {
        format1 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH, null);
        format2 = new ExtendedMessageFormat("Pattern", Locale.ENGLISH, null);
        format3 = new ExtendedMessageFormat("Pattern", Locale.FRENCH, null);
        assertEquals(format1.hashCode(), format2.hashCode());
        assertNotEquals(format1.hashCode(), format3.hashCode());
    }
    @Test
    void setFormat_ThrowsUnsupportedOperationException() {
        extendedMessageFormat = new ExtendedMessageFormat("Test");
        assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormat(0, null));
    }
    
    @Test
    void setFormat_ThrowsUnsupportedOperationExceptionForAllFormatElementIndexes() {
        extendedMessageFormat = new ExtendedMessageFormat("Test");
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormat(finalI, null));
        }
    }
    @Test
    void applyPattern_WithValidPattern_ShouldApplyPatternSuccessfully() {
        extendedMessageFormat.applyPattern("{0,date} {1,number}");
        assertEquals("{0,date} {1,number}", extendedMessageFormat.toPattern);
    }
    
    @Test
    void applyPattern_WithNullPattern_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> extendedMessageFormat.applyPattern(null));
    }
    
    @Test
    void applyPattern_WithEmptyPattern_ShouldApplyPatternSuccessfully() {
        extendedMessageFormat.applyPattern("");
        assertEquals("", extendedMessageFormat.toPattern);
    }
    
    @Test
    void applyPattern_WithInvalidPattern_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> extendedMessageFormat.applyPattern("invalid pattern"));
    }
    
    @Test
    void applyPattern_WithCustomRegistry_ShouldApplyPatternSuccessfully() {
        extendedMessageFormat.applyPattern("{0,date} {1,number}");
        assertEquals("{0,date} {1,number}", extendedMessageFormat.toPattern);
    }
    
    @Test
    void applyPattern_WithCustomRegistryAndInvalidPattern_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> extendedMessageFormat.applyPattern("invalid pattern"));
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ExtendedMessageFormatTestSuite {
    
      private ExtendedMessageFormat format;
    
      @Test
      void testEquals_sameInstance_returnsTrue() {
        format = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(format));
      }
    
      @Test
      void testEquals_null_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals(null));
      }
    
      @Test
      void testEquals_differentClass_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        assertFalse(format.equals("pattern"));
      }
    
      @Test
      void testEquals_equalObjects_returnsTrue() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("pattern");
        assertTrue(format.equals(otherFormat));
      }
    
      @Test
      void testEquals_differentToPattern_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("differentPattern");
        assertFalse(format.equals(otherFormat));
      }
    
      @Test
      void testEquals_differentRegistry_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("pattern");
        otherFormat.registry = null;
        assertFalse(format.equals(otherFormat));
      }
    
      @Test
      void testEquals_differentHashCode_returnsFalse() {
        format = new ExtendedMessageFormat("pattern");
        ExtendedMessageFormat otherFormat = new ExtendedMessageFormat("pattern");
        otherFormat.HASH_SEED = 0;
        assertFalse(format.equals(otherFormat));
      }
    }
    @Test
    void testSetFormats() {
        Format[] newFormats = new Format[2];
        newFormats[0] = new SimpleDateFormat("yyyy-MM-dd");
        newFormats[1] = new DecimalFormat("#,###");
        
        assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormats(newFormats));
    }
    import org.junit.jupiter.api.Test;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @Test
    void setFormatsByArgumentIndex_shouldThrowUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> extendedMessageFormat.setFormatsByArgumentIndex(new Format[0]));
    }
    
    @Test
    void setFormatsByArgumentIndex_shouldNotModifyExistingFormats() {
        Format[] formats = new Format[1];
        formats[0] = new MessageFormat("");
        extendedMessageFormat.setFormatsByArgumentIndex(formats);
    
        assertEquals(formats[0], extendedMessageFormat.getFormatsByArgumentIndex()[0]);
    }
    
    @Test
    void setFormatsByArgumentIndex_shouldSetNewFormats() {
        Format[] formats = new Format[1];
        formats[0] = new MessageFormat("");
        extendedMessageFormat.setFormatsByArgumentIndex(formats);
    
        Format[] newFormats = new Format[1];
        newFormats[0] = new MessageFormat("New format");
        extendedMessageFormat.setFormatsByArgumentIndex(newFormats);
    
        assertEquals(newFormats[0], extendedMessageFormat.getFormatsByArgumentIndex()[0]);
    }
    import org.junit.jupiter.api.Test;
    
    class ExtendedMessageFormatTest {
    
        @Test
        void setFormatByArgumentIndex_shouldThrowUnsupportedOperationException() {
            // Test code here
        }
    }
    @Test
    void testToPatternReturnsCorrectPattern() {
        String pattern = "This is a test pattern";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsEmptyStringForEmptyPattern() {
        String pattern = "";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsNullForNullPattern() {
        extendedMessageFormat.applyPattern(null);
        assertNull(extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsPatternWithSpecialCharacters() {
        String pattern = "This is a test pattern with special characters: {0}, {1}, {2}";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsPatternWithQuotedText() {
        String pattern = "This is a test pattern with quoted text: 'quoted text'";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsPatternWithEscapedQuotes() {
        String pattern = "This is a test pattern with escaped quotes: ''";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsPatternWithMultipleFormats() {
        String pattern = "This is a test pattern with multiple formats: {0,number}, {1,date}, {2,time}";
        extendedMessageFormat.applyPattern(pattern);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }
    
    @Test
    void testToPatternReturnsPatternWithLocale() {
        String pattern = "This is a test pattern with locale";
        Locale locale = Locale.US;
        extendedMessageFormat = new ExtendedMessageFormat(pattern, locale, null);
        assertEquals(pattern, extendedMessageFormat.toPattern());
    }

}