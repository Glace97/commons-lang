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

public class ReflectionDiffBuilderTest {
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    public class ReflectionDiffBuilderTest {
    
        @Test
        public void testGetExcludeFieldNames() {
            // Test cases here
        }
        
        @Test
        public void testSetExcludeFieldNames() {
            // Test cases here
        }
        
        @Test
        public void testBuild() {
            // Test cases here
        }
        
        @Test
        public void testSetDiffBuilder() {
            // Test cases here
        }
    
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestSuite;
    
    class ReflectionDiffBuilderTestSuite {
    
        @Test
        void testSetExcludeFieldNamesWithNull() {
            ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
            builder.setExcludeFieldNames(null);
            ReflectionDiffBuilder<String> diffBuilder = builder.build();
            assertNotNull(diffBuilder);
            assertEquals(0, diffBuilder.getExcludeFieldNames().length);
        }
    
        @Test
        void testSetExcludeFieldNamesWithEmptyArray() {
            ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
            builder.setExcludeFieldNames(new String[0]);
            ReflectionDiffBuilder<String> diffBuilder = builder.build();
            assertNotNull(diffBuilder);
            assertEquals(0, diffBuilder.getExcludeFieldNames().length);
        }
    
        @Test
        void testSetExcludeFieldNamesWithFieldsToExclude() {
            ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
            builder.setExcludeFieldNames("password", "lastModificationDate");
            ReflectionDiffBuilder<String> diffBuilder = builder.build();
            assertNotNull(diffBuilder);
            String[] excludeFieldNames = diffBuilder.getExcludeFieldNames();
            assertEquals(2, excludeFieldNames.length);
            assertEquals("password", excludeFieldNames[0]);
            assertEquals("lastModificationDate", excludeFieldNames[1]);
        }
    }
    import org.junit.jupiter.api.Test;
    
    class ReflectionDiffBuilderTest {
    
        @Test
        void testSetDiffBuilder() {
            // Test logic here
        }
    
        @Test
        void testSetExcludeFieldNames() {
            // Test logic here
        }
    
        @Test
        void testSetExcludeFieldNames_emptyArray() {
            // Test logic here
        }
    
        @Test
        void testSetExcludeFieldNames_nullArray() {
            // Test logic here
        }
    
        @Test
        void testSetExcludeFieldNames_singleElementArray() {
            // Test logic here
        }
    
        @Test
        void testSetExcludeFieldNames_multipleElementArray() {
            // Test logic here
        }
    
        @Test
        void testConstructor() {
            // Test logic here
        }
    
        @Test
        void testConstructor_withExcludeFieldNames() {
            // Test logic here
        }
    
        @Test
        void testSetDiffBuilder_withMock() {
            // Test logic here
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    public class ReflectionDiffBuilderTest {
    
        @Test
        void shouldReturnEmptyArrayWhenPassedNull() {
            String[] excludeFieldNames = null;
            String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
            assertEquals(0, result.length);
        }
    
        @Test
        void shouldReturnEmptyArrayWhenPassedEmptyArray() {
            String[] excludeFieldNames = new String[0];
            String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
            assertEquals(0, result.length);
        }
    
        @Test
        void shouldReturnSortedArrayWithoutNullValues() {
            String[] excludeFieldNames = {"field2", "field1", null, "field3"};
            String[] result = ReflectionDiffBuilder.toExcludeFieldNames(excludeFieldNames);
            assertEquals(3, result.length);
            assertEquals("field1", result[0]);
            assertEquals("field2", result[1]);
            assertEquals("field3", result[2]);
        }
    
        @Test
        void shouldSetExcludeFieldNamesToEmptyArrayWhenPassedNull() {
            ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
            builder.setExcludeFieldNames(null);
            ReflectionDiffBuilder<String> reflectionDiffBuilder = builder.build();
            String[] excludeFieldNames = reflectionDiffBuilder.getExcludeFieldNames();
            assertEquals(0, excludeFieldNames.length);
        }
    
        @Test
        void shouldSetExcludeFieldNamesToPassedArray() {
            ReflectionDiffBuilder.Builder<String> builder = new ReflectionDiffBuilder.Builder<>();
            String[] excludeFieldNames = {"field1", "field2"};
            builder.setExcludeFieldNames(excludeFieldNames);
            ReflectionDiffBuilder<String> reflectionDiffBuilder = builder.build();
            String[] result = reflectionDiffBuilder.getExcludeFieldNames();
            assertArrayEquals(excludeFieldNames, result);
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class ReflectionDiffBuilderTest {
    
        @Test
        void testBuild_SameObjects_ReturnsDiffResultWithNoDifferences() {
            // test code here
        }
    
        @Test
        void testBuild_DifferentObjects_ReturnsDiffResultWithDifferences() {
            // test code here
        }
    
        @Test
        void testSetExcludeFieldNames_ExcludeFields_ReturnsDiffResultWithoutExcludedFields() {
            // test code here
        }
    
        @Test
        void testAppendFields_ClassWithFields_ReturnsDiffResultWithAllFieldsAppended() {
            // test code here
        }
    }
    // Only @Test test functions:
    
    @Test
    void testBuild() {
        ReflectionDiffBuilder<Object> reflectionDiffBuilder = builder.setDiffBuilder(diffBuilder)
                .setExcludeFieldNames(excludeFieldNames)
                .build();
    
        assertNotNull(reflectionDiffBuilder);
        assertEquals(diffBuilder, reflectionDiffBuilder.getDiffBuilder());
        assertArrayEquals(excludeFieldNames, reflectionDiffBuilder.getExcludeFieldNames());
    }
    
    @Test
    void testSetDiffBuilder() {
        ReflectionDiffBuilder<Object> reflectionDiffBuilder = builder.setDiffBuilder(diffBuilder).build();
    
        assertNotNull(reflectionDiffBuilder);
        assertEquals(diffBuilder, reflectionDiffBuilder.getDiffBuilder());
    }
    
    @Test
    void testSetExcludeFieldNames() {
        ReflectionDiffBuilder<Object> reflectionDiffBuilder = builder.setExcludeFieldNames(excludeFieldNames).build();
    
        assertNotNull(reflectionDiffBuilder);
        assertArrayEquals(excludeFieldNames, reflectionDiffBuilder.getExcludeFieldNames());
    }

}