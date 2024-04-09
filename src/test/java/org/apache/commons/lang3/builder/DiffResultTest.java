package org.apache.commons.lang3.builder;

import static org.easymock.EasyMock.mock;
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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

public class DiffResultTest {

    
//
//
//    @Test
//    @DisplayName("should return the left object")
//    void shouldReturnLeftObject() {
//        assertEquals("lhs", diffResult.getLeft());
//    }
//
//
//    @Test
//    @DisplayName("should return the style used by the toString() method")
//    void shouldReturnStyleUsedByToStringMethod() {
//        // Arrange
//        ToStringStyle style = mock(ToStringStyle.class);
//        diffResult.style = style;
//
//        // Act
//        ToStringStyle result = diffResult.getToStringStyle();
//
//        // Assert
//        assertEquals(style, result);
//    }
//    @Test
//    @DisplayName("Test getDiffs returns correct list")
//    public void testGetDiffs() {
//        List<Diff<?>> diffs = diffResult.getDiffs();
//        assertEquals(3, diffs.size());
//        assertEquals("field1", diffs.get(0).getField());
//        assertEquals("field2", diffs.get(1).getField());
//        assertEquals("field3", diffs.get(2).getField());
//    }
//
//    @Test
//    @DisplayName("Test getDiffs returns unmodifiable list")
//    public void testGetDiffsUnmodifiable() {
//        List<Diff<?>> diffs = diffResult.getDiffs();
//        assertThrows(UnsupportedOperationException.class, () -> diffs.add(new Diff<>("field4", "value3", "value4")));
//    }
//
//    @Test
//    @DisplayName("Test getDiffs with empty list")
//    public void testGetDiffsEmpty() {
//        diffResult = new DiffResult("object1", "object2", new ArrayList<>(), null, null);
//        List<Diff<?>> diffs = diffResult.getDiffs();
//        assertTrue(diffs.isEmpty());
//    }
//    @Test
//    void testGetNumberOfDiffs() {
//        int expected = 2;
//        int actual = diffResult.getNumberOfDiffs();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetNumberOfDiffs_emptyDiffList() {
//        diffResult = new DiffResult("object1", "object2", new ArrayList<>(), ToStringStyle.DEFAULT_STYLE, "%s differs from %s");
//        int expected = 0;
//        int actual = diffResult.getNumberOfDiffs();
//        assertEquals(expected, actual);
//    }
//    @Test
//    @DisplayName("Test iterator returns correct elements")
//    void testIterator() {
//        Iterator<Diff<?>> iterator = diffResult.iterator();
//
//        assertSame(diff1, iterator.next());
//        assertSame(diff2, iterator.next());
//        assertSame(diff3, iterator.next());
//        assertFalse(iterator.hasNext());
//    }
//
//    @Test
//    @DisplayName("Test iterator is empty when diffList is empty")
//    void testIteratorEmptyList() {
//        diffResult = new DiffResult(null, null, Collections.emptyList(), null, StringUtils.EMPTY);
//        Iterator<Diff<?>> iterator = diffResult.iterator();
//
//        assertFalse(iterator.hasNext());
//    }
//    @Test
//    void testToStringNoDifferences() {
//        DiffResult diffResult = new DiffResult("John", "John", new ArrayList<>(), style, toStringFormat);
//        assertEquals("", diffResult.toString());
//    }
//
//    @Test
//    void testToStringSingleDifference() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, style, toStringFormat);
//        assertEquals("John differs from Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringMultipleDifferences() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        diffList.add(new Diff<>("age", 32, 26));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, style, toStringFormat);
//        assertEquals("John differs from Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringStyle() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, ToStringStyle.JSON_STYLE, toStringFormat);
//        assertEquals("John differs from Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringFormat() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, style, "Object %s is different from object %s");
//        assertEquals("Object John is different from object Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringWithNullStyle() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, null, toStringFormat);
//        assertEquals("John differs from Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringWithNullFormat() {
//        List<Diff<?>> diffList = new ArrayList<>();
//        diffList.add(new Diff<>("name", "John", "Joe"));
//        DiffResult diffResult = new DiffResult("John", "Joe", diffList, style, null);
//        assertEquals("John differs from Joe", diffResult.toString());
//    }
//
//    @Test
//    void testToStringWithEmptyDiffList() {
//        DiffResult diffResult = new DiffResult("John", "John", new ArrayList<>(), style, toStringFormat);
//        assertEquals("", diffResult.toString());
//    }
//    @Test
//    void testGetRight() {
//        assertEquals(10, diffResult.getRight());
//    }
//
//    @Test
//    void testGetRightWithNullDiffList() {
//        diffResult = new DiffResult<>(5, 10, null, null, null);
//        assertEquals(10, diffResult.getRight());
//    }
//
//    @Test
//    void testGetRightWithEmptyDiffList() {
//        diffResult = new DiffResult<>(5, 10, Collections.emptyList(), null, null);
//        assertEquals(10, diffResult.getRight());
//    }

}