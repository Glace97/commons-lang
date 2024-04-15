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

public class CharSetTest {
    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet("a-z", "0-9");
    }

    @Test
    void contains_Common_ReturnsTrueForCommonPatterns() {
        // Add test cases for the common patterns you want to cover
    }

    @Test
    void contains_CustomSet_ReturnsTrueForCharactersInSet() {
        CharSet customSet = new CharSet("abcd");
        assertTrue(customSet.contains('a'));
        assertTrue(customSet.contains('b'));
        assertTrue(customSet.contains('c'));
        assertTrue(customSet.contains('d'));
        assertFalse(customSet.contains('e'));
        assertFalse(customSet.contains('1'));
    }
    // Your Java code here


    @Test
    void testEquals_sameObject() {
        CharSet charSet = new CharSet();
        Assertions.assertEquals(charSet, charSet);
    }


    @Test
    void testEquals_notEqualCharSets() {
        CharSet charSet = new CharSet("a", "b", "c");
        CharSet other = new CharSet();
        Assertions.assertNotEquals(charSet, other);
    }

    @Test
    void testEquals_nullObject() {
        CharSet charSet = new CharSet();
        Assertions.assertNotEquals(charSet, null);
    }

    @Test
    void testEquals_differentObjectType() {
        CharSet charSet = new CharSet();
        Assertions.assertNotEquals(charSet, "not a CharSet object");
    }


    @Test
    void testGetInstance_NullInput() {
        CharSet charSet = CharSet.getInstance(null);
        assertNull(charSet);
    }


}