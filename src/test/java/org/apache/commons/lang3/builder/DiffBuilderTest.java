package org.apache.commons.lang3.builder;

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

public class DiffBuilderTest {
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    
    class DiffBuilderTest {
    
        @Test
        void testGetLeft() {
            // Test when left and right objects are the same
            String sameObject = "same";
            DiffBuilder<String> diffBuilder1 = new DiffBuilder.Builder<String>()
                    .setLeft(sameObject)
                    .setRight(sameObject)
                    .build();
            Assertions.assertEquals(sameObject, diffBuilder1.getLeft());
    
            // Test when left and right objects are different
            String differentObject = "different";
            DiffBuilder<String> diffBuilder2 = new DiffBuilder.Builder<String>()
                    .setLeft(differentObject)
                    .setRight("other")
                    .build();
            Assertions.assertEquals(differentObject, diffBuilder2.getLeft());
        }
    }
    @Test
    void setToStringFormat_withValidFormat_shouldSetToStringFormat() {
        String format = "Field %s differs from %s";
        diffBuilder.setToStringFormat(format);
        assertEquals(format, diffBuilder.toStringFormat);
    }
    
    @Test
    void setToStringFormat_withNullFormat_shouldSetDefaultToStringFormat() {
        diffBuilder.setToStringFormat(null);
        assertEquals(DiffBuilder.TO_STRING_FORMAT, diffBuilder.toStringFormat);
    }
    
    @Test
    void setToStringFormat_withEmptyFormat_shouldSetDefaultToStringFormat() {
        diffBuilder.setToStringFormat("");
        assertEquals(DiffBuilder.TO_STRING_FORMAT, diffBuilder.toStringFormat);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class DiffBuilderTest {
    
        @Test
        void testSetTestObjectsEquals() {
            // Test when testObjectsEquals is true
            DiffBuilder<Integer> builder = new DiffBuilder.Builder<Integer>()
                    .setLeft(5)
                    .setRight(5)
                    .setTestObjectsEquals(true)
                    .build();
            assertTrue(builder.equals);
            
            // Test when testObjectsEquals is false
            builder = new DiffBuilder.Builder<Integer>()
                    .setLeft(5)
                    .setRight(5)
                    .setTestObjectsEquals(false)
                    .build();
            assertFalse(builder.equals);
        }
        
        @Test
        void testGetLeft() {
            Integer left = 5;
            DiffBuilder<Integer> builder = new DiffBuilder.Builder<Integer>()
                    .setLeft(left)
                    .setRight(10)
                    .build();
            assertEquals(left, builder.getLeft());
        }
        
        @Test
        void testGetRight() {
            Integer right = 10;
            DiffBuilder<Integer> builder = new DiffBuilder.Builder<Integer>()
                    .setLeft(5)
                    .setRight(right)
                    .build();
            assertEquals(right, builder.getRight());
        }
    }
    @Test
    void testAppend_boolean() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", true, true);
        assertSame(diffBuilder, result);
    
        result = diffBuilder.append("fieldName", true, false);
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_booleanArray() {
        boolean[] lhs = {true, false};
        boolean[] rhs = {true, false};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, lhs);
        assertSame(diffBuilder, result);
    
        result = diffBuilder.append("fieldName", lhs, rhs);
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_byte() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", (byte) 1, (byte) 1);
        assertSame(diffBuilder, result);
    
        result = diffBuilder.append("fieldName", (byte) 1, (byte) 2);
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_byteArray() {
        byte[] lhs = {1, 2};
        byte[] rhs = {1, 2};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, lhs);
        assertSame(diffBuilder, result);
    
        result = diffBuilder.append("fieldName", lhs, rhs);
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_objectsEqual() {
        Object obj = new Object();
        DiffBuilder<String> result = diffBuilder.append("fieldName", obj, obj);
        assertSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_objectsNotEqual() {
        DiffBuilder<String> result = diffBuilder.append("fieldName", "left", "right");
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_objectsArrayEqual() {
        Object[] lhs = {"left", "right"};
        Object[] rhs = {"left", "right"};
        DiffBuilder<String> result = diffBuilder.append("fieldName", lhs, lhs);
        assertSame(diffBuilder, result);
    
        result = diffBuilder.append("fieldName", lhs, rhs);
        assertNotSame(diffBuilder, result);
    }
    
    @Test
    void testAppend_diffResult() {
        DiffResult<String> diffResult = new DiffResult<>(Arrays.asList(
                new Diff<>("fieldName1", "left1", "right1"),
                new Diff<>("fieldName2", "left2", "right2")
        ));
    
        DiffBuilder<String> result = diffBuilder.append("fieldName", diffResult);
        assertNotSame(diffBuilder, result);
    }
    @Test
    public void testSetLeft() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>().build();
    
        // Set the left object
        diffBuilder.setLeft("left");
    
        // Assert that the left object is set correctly
        Assertions.assertEquals("left", diffBuilder.getLeft());
    }
    
    @Test
    public void testSetRight() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>().build();
    
        // Set the right object
        diffBuilder.setRight("right");
    
        // Assert that the right object is set correctly
        Assertions.assertEquals("right", diffBuilder.getRight());
    }
    
    @Test
    public void testSetStyle() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>().build();
    
        // Set the style
        diffBuilder.setStyle(ToStringStyle.JSON_STYLE);
    
        // Assert that the style is set correctly
        Assertions.assertEquals(ToStringStyle.JSON_STYLE, diffBuilder.getStyle());
    }
    
    @Test
    public void testSetTestObjectsEquals() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>().build();
    
        // Set the testObjectsEquals flag
        diffBuilder.setTestObjectsEquals(false);
    
        // Assert that the testObjectsEquals flag is set correctly
        Assertions.assertFalse(diffBuilder.getTestObjectsEquals());
    }
    
    @Test
    public void testSetToStringFormat() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>().build();
    
        // Set the toStringFormat
        diffBuilder.setToStringFormat("%s and %s differ");
    
        // Assert that the toStringFormat is set correctly
        Assertions.assertEquals("%s and %s differ", diffBuilder.getToStringFormat());
    }
    
    @Test
    public void testBuild() {
        // Create a DiffBuilder object
        DiffBuilder<String> diffBuilder = new DiffBuilder.Builder<String>()
                .setLeft("left")
                .setRight("right")
                .setStyle(ToStringStyle.JSON_STYLE)
                .setTestObjectsEquals(false)
                .setToStringFormat("%s and %s differ")
                .build();
    
        // Assert that the object is built correctly
        Assertions.assertEquals("left", diffBuilder.getLeft());
        Assertions.assertEquals("right", diffBuilder.getRight());
        Assertions.assertEquals(ToStringStyle.JSON_STYLE, diffBuilder.getStyle());
        Assertions.assertFalse(diffBuilder.getTestObjectsEquals());
        Assertions.assertEquals("%s and %s differ", diffBuilder.getToStringFormat());
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import org.junit.jupiter.api.Test;
    
    class DiffBuilderTestSuite {
    
        @Test
        void testSetLeft() {
            // Test case 1: left object is null
            DiffBuilder<String> diffBuilder1 = new DiffBuilder<>();
            diffBuilder1.setLeft(null);
            assertEquals(null, diffBuilder1.getLeft());
    
            // Test case 2: left object is not null
            DiffBuilder<String> diffBuilder2 = new DiffBuilder<>();
            diffBuilder2.setLeft("left");
            assertEquals("left", diffBuilder2.getLeft());
        }
    }
    @Test
    void testBuild() {
        DiffBuilder<Integer> result = diffBuilder.build();
        assertNotNull(result);
        assertEquals(10, result.getLeft());
        assertEquals(15, result.getRight());
    }
    
    @Test
    void testSetLeft() {
        DiffBuilder<Integer> result = diffBuilder.setLeft(20);
        assertNotNull(result);
        assertEquals(20, result.getLeft());
        assertEquals(15, result.getRight());
    }
    
    @Test
    void testSetRight() {
        DiffBuilder<Integer> result = diffBuilder.setRight(25);
        assertNotNull(result);
        assertEquals(10, result.getLeft());
        assertEquals(25, result.getRight());
    }
    
    @Test
    void testSetStyle() {
        DiffBuilder<Integer> result = diffBuilder.setStyle(null);
        assertNotNull(result);
        assertEquals(10, result.getLeft());
        assertEquals(15, result.getRight());
    }
    
    @Test
    void testSetTestObjectsEquals() {
        DiffBuilder<Integer> result = diffBuilder.setTestObjectsEquals(false);
        assertNotNull(result);
        assertEquals(10, result.getLeft());
        assertEquals(15, result.getRight());
    }
    
    @Test
    void testSetToStringFormat() {
        DiffBuilder<Integer> result = diffBuilder.setToStringFormat("%s is not equal to %s");
        assertNotNull(result);
        assertEquals(10, result.getLeft());
        assertEquals(15, result.getRight());
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestSuite;
    import static org.junit.jupiter.api.Assertions.*;
    
    public class DiffBuilderTestSuite {
    
        @Test
        void testSetLeft() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setLeft("left");
            assertEquals("left", builder.getLeft());
        }
    
        @Test
        void testSetRight() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setRight("right");
            assertEquals("right", builder.getRight());
        }
    
        @Test
        void testSetStyle() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setStyle(ToStringStyle.JSON_STYLE);
            assertEquals(ToStringStyle.JSON_STYLE, builder.getStyle());
        }
    
        @Test
        void testSetTestObjectsEquals() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setTestObjectsEquals(false);
            assertFalse(builder.getTestObjectsEquals());
        }
    
        @Test
        void testSetToStringFormat() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setToStringFormat("%s is not equal to %s");
            assertEquals("%s is not equal to %s", builder.getToStringFormat());
        }
    
        @Test
        void testBuild() {
            DiffBuilder<String> builder = DiffBuilder.builder();
            builder.setLeft("left");
            builder.setRight("right");
            DiffBuilder<String> diffBuilder = builder.build();
            assertNotNull(diffBuilder);
            assertEquals("left", diffBuilder.getLeft());
            assertEquals("right", diffBuilder.getRight());
        }
    }
    // Your Java code here
    
    @Test
    @DisplayName("should return the right object")
    void shouldReturnRightObject() {
        String right = diffBuilder.getRight();
        
        assertEquals("right", right);
    }
    
    @Test
    @DisplayName("should return the same right object")
    void shouldReturnSameRightObject() {
        String right = diffBuilder.getRight();
        
        assertSame("right", right);
    }
    @Test
    void setRight_ShouldSetRightObject() {
        // Arrange
        String expectedRight = "right";
    
        // Act
        DiffBuilder<String> result = diffBuilder.setRight(expectedRight);
    
        // Assert
        assertEquals(expectedRight, result.getRight());
    }
    
    @Test
    void setRight_ShouldReturnSameInstance() {
        // Arrange
        String right = "right";
    
        // Act
        DiffBuilder<String> result = diffBuilder.setRight(right);
    
        // Assert
        assertSame(diffBuilder, result);
    }
    
    @Test
    void setRight_ShouldOverridePreviousRightObject() {
        // Arrange
        String previousRight = "previous";
        String newRight = "new";
    
        // Act
        diffBuilder.setRight(previousRight);
        diffBuilder.setRight(newRight);
    
        // Assert
        assertEquals(newRight, diffBuilder.getRight());
    }
    
    @Test
    void setRight_ShouldNotAffectLeftObject() {
        // Arrange
        String left = "left";
        String right = "right";
    
        // Act
        diffBuilder.setLeft(left);
        diffBuilder.setRight(right);
    
        // Assert
        assertEquals(left, diffBuilder.getLeft());
    }

}