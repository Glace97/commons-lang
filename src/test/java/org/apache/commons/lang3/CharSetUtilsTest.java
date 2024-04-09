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

public class CharSetUtilsTest {
    @Test
    @DisplayName("should return null if the input string is null")
    void testKeepMethodWithNullString() {
        String result = CharSetUtils.keep(null, "abc");
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return an empty string if the input string is empty")
    void testKeepMethodWithEmptyString() {
        String result = CharSetUtils.keep("", "abc");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("should return an empty string if the set of characters to keep is null")
    void testKeepMethodWithNullSet() {
        String result = CharSetUtils.keep("hello", null);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("should return an empty string if the set of characters to keep is empty")
    void testKeepMethodWithEmptySet() {
        String result = CharSetUtils.keep("hello", new String[]{});
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("should keep only characters present in the set of characters")
    void testKeepMethodWithValidInput() {
        String result = CharSetUtils.keep("hello", "hl");
        assertEquals("hll", result);
    }
    
    @Test
    @DisplayName("should keep only characters present in the set of characters")
    void testKeepMethodWithValidInput2() {
        String result = CharSetUtils.keep("hello", "le");
        assertEquals("ell", result);
    }

//    @Test
//   @DisplayName("should return null when input string is null")
//    public void testDeleteNullString() {
//        assertNull(charSetUtils.delete(null, "a"));
//    }
//
//    @Test
//    @DisplayName("should return empty string when input string is empty")
//    public void testDeleteEmptyString() {
//        assertEquals("", charSetUtils.delete("", "a"));
//    }
//
//    @Test
//    @DisplayName("should return null when set of characters to delete is null")
//    public void testDeleteNullSet() {
//        assertNull(charSetUtils.delete("hello", null));
//    }
//
//    @Test
//    @DisplayName("should return input string when set of characters to delete is empty")
//    public void testDeleteEmptySet() {
//        assertEquals("hello", charSetUtils.delete("hello", new String[]{}));
//    }
//
//    @Test
//    @DisplayName("should delete characters from input string")
//    public void testDeleteCharacters() {
//        assertEquals("eo", charSetUtils.delete("hello", "hl"));
//        assertEquals("ho", charSetUtils.delete("hello", "le"));
//    }
//    @Test
//    void testCount_NullStringInput_ReturnsZero() {
//        int count = charSetUtils.count(null, "a", "b", "c");
//        assertEquals(0, count);
//    }
//
//    @Test
//    void testCount_EmptyStringInput_ReturnsZero() {
//        int count = charSetUtils.count("", "a", "b", "c");
//        assertEquals(0, count);
//    }
//
//    @Test
//    void testCount_NullSetInput_ReturnsZero() {
//        int count = charSetUtils.count("hello", (String[])null);
//        assertEquals(0, count);
//    }
//
//    @Test
//    void testCount_EmptySetInput_ReturnsZero() {
//        int count = charSetUtils.count("hello", "");
//        assertEquals(0, count);
//    }
//
//    @Test
//    void testCount_ValidInputs_ReturnsCorrectCount() {
//        int count = charSetUtils.count("hello", "k-p");
//        assertEquals(3, count);
//    }
//
//    @Test
//    void testCount_ValidInputs_ReturnsCorrectCount2() {
//        int count = charSetUtils.count("hello", "a-e");
//        assertEquals(1, count);
//    }
    @Test
    void testContainsAny_NullString_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny(null, "a", "b", "c");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_EmptyString_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("", "a", "b", "c");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_NullSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("hello", null);
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_EmptySet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("hello", "");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_SetWithMatchingCharacters_ReturnsTrue() {
        boolean result = CharSetUtils.containsAny("hello", "k-p");
        Assertions.assertTrue(result);
    }

    @Test
    void testContainsAny_SetWithoutMatchingCharacters_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("hello", "a-d");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_SpecialCharactersInSet_ReturnsTrue() {
        boolean result = CharSetUtils.containsAny("hello", "!", "@", "#", "$", "%");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_MixedCaseCharactersInSet_ReturnsTrue() {
        boolean result = CharSetUtils.containsAny("hello", "A-Z");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_NumbersInSet_ReturnsTrue() {
        boolean result = CharSetUtils.containsAny("hello123", "0-9");
        Assertions.assertTrue(result);
    }

    @Test
    void testContainsAny_EmptyStringAndSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("", "");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_NullStringAndSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny(null, "");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_NullStringAndNullSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny(null, null);
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_EmptyStringAndNullSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("", null);
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_NullStringAndNonEmptySet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny(null, "a", "b", "c");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_EmptyStringAndNonEmptySet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("", "a", "b", "c");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_StringWithSpaceAndSet_ReturnsTrue() {
        boolean result = CharSetUtils.containsAny("hello world", " ");
        Assertions.assertTrue(result);
    }

    @Test
    void testContainsAny_StringWithSpaceAndEmptySet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("hello world", "");
        Assertions.assertFalse(result);
    }

    @Test
    void testContainsAny_StringWithSpaceAndNullSet_ReturnsFalse() {
        boolean result = CharSetUtils.containsAny("hello world", null);
        Assertions.assertFalse(result);
    }
    @Test
    @DisplayName("Test squeeze with null string and null set")
    void testSqueezeWithNullStringAndNullSet() {
        String result = CharSetUtils.squeeze(null, null);
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Test squeeze with empty string and null set")
    void testSqueezeWithEmptyStringAndNullSet() {
        String result = CharSetUtils.squeeze("", null);
        Assertions.assertEquals("", result);
    }

    @Test
    @DisplayName("Test squeeze with null string and empty set")
    void testSqueezeWithNullStringAndEmptySet() {
        String result = CharSetUtils.squeeze(null, "");
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Test squeeze with empty string and empty set")
    void testSqueezeWithEmptyStringAndEmptySet() {
        String result = CharSetUtils.squeeze("", "");
        Assertions.assertEquals("", result);
    }

    @Test
    @DisplayName("Test squeeze with null string and non-empty set")
    void testSqueezeWithNullStringAndNonEmptySet() {
        String result = CharSetUtils.squeeze(null, "a-e");
        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Test squeeze with empty string and non-empty set")
    void testSqueezeWithEmptyStringAndNonEmptySet() {
        String result = CharSetUtils.squeeze("", "a-e");
        Assertions.assertEquals("", result);
    }

    @Test
    @DisplayName("Test squeeze with non-empty string and null set")
    void testSqueezeWithNonEmptyStringAndNullSet() {
        String result = CharSetUtils.squeeze("hello", null);
        Assertions.assertEquals("hello", result);
    }

    @Test
    @DisplayName("Test squeeze with non-empty string and empty set")
    void testSqueezeWithNonEmptyStringAndEmptySet() {
        String result = CharSetUtils.squeeze("hello", "");
        Assertions.assertEquals("hello", result);
    }

    @Test
    @DisplayName("Test squeeze with non-empty string and valid set")
    void testSqueezeWithNonEmptyStringAndValidSet() {
        String result = CharSetUtils.squeeze("hello", "k-p");
        Assertions.assertEquals("helo", result);
    }

    @Test
    @DisplayName("Test squeeze with non-empty string and invalid set")
    void testSqueezeWithNonEmptyStringAndInvalidSet() {
        String result = CharSetUtils.squeeze("hello", "a-e");
        Assertions.assertEquals("hello", result);
    }

    @Test
    @DisplayName("Test squeeze with repeated characters in set")
    void testSqueezeWithRepeatedCharactersInSet() {
        String result = CharSetUtils.squeeze("hello", "ee");
        Assertions.assertEquals("helo", result);
    }

}