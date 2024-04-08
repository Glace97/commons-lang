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

public class ReflectionToStringBuilderTest {
    @Test
    @DisplayName("Should return an empty array")
    void shouldReturnEmptyArray() {
        String[] excludeFieldNames = builder.getExcludeFieldNames();
        assertNotNull(excludeFieldNames);
        assertEquals(0, excludeFieldNames.length);
    }
    
    @Test
    @DisplayName("Should return a copy of excludeFieldNames")
    void shouldReturnCopyOfExcludeFieldNames() {
        String[] excludeFieldNames = builder.getExcludeFieldNames();
        assertNotNull(excludeFieldNames);
        assertNotSame(builder.excludeFieldNames, excludeFieldNames);
        assertArrayEquals(builder.excludeFieldNames, excludeFieldNames);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
    
        private ReflectionToStringBuilder builder;
    
        @BeforeEach
        void setUp() {
            builder = new ReflectionToStringBuilder(new Object());
        }
    
        @Test
        void testSetUpToClass_withNullClass_shouldNotThrowException() {
            assertDoesNotThrow(() -> builder.setUpToClass(null));
        }
    
        @Test
        void testSetUpToClass_withValidClass_shouldSetUpToClass() {
            Class<?> clazz = Object.class;
            builder.setUpToClass(clazz);
            assertEquals(clazz, builder.getUpToClass());
        }
    
        @Test
        void testSetUpToClass_withInvalidClass_shouldThrowException() {
            assertThrows(IllegalArgumentException.class, () -> builder.setUpToClass(String.class));
        }
    
        @Test
        void testSetUpToClass_withSubclassObject_shouldNotThrowException() {
            Object object = new SubclassObject();
            assertDoesNotThrow(() -> builder.setUpToClass(Object.class));
        }
    
        @Test
        void testSetUpToClass_withSuperclassObject_shouldThrowException() {
            Object object = new SuperclassObject();
            assertThrows(IllegalArgumentException.class, () -> builder.setUpToClass(SubclassObject.class));
        }
    
        @Test
        void testSetUpToClass_withNullObject_shouldThrowException() {
            builder = new ReflectionToStringBuilder(null);
            assertThrows(IllegalArgumentException.class, () -> builder.setUpToClass(Object.class));
        }
    
        @Test
        void testSetUpToClass_withNullObjectAndNullClass_shouldNotThrowException() {
            builder = new ReflectionToStringBuilder(null);
            assertDoesNotThrow(() -> builder.setUpToClass(null));
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
    
        private ReflectionToStringBuilder builder;
    
        @Test
        void testSetIncludeFieldNames_Null() {
            builder.setIncludeFieldNames(null);
            assertNull(builder.includeFieldNames);
        }
    
        @Test
        void testSetIncludeFieldNames_EmptyArray() {
            builder.setIncludeFieldNames();
            assertNull(builder.includeFieldNames);
        }
    
        @Test
        void testSetIncludeFieldNames_SingleFieldName() {
            String fieldName = "fieldName";
            builder.setIncludeFieldNames(fieldName);
            assertNotNull(builder.includeFieldNames);
            assertEquals(1, builder.includeFieldNames.length);
            assertEquals(fieldName, builder.includeFieldNames[0]);
        }
    
        @Test
        void testSetIncludeFieldNames_MultipleFieldNames() {
            String[] fieldNames = {"fieldName1", "fieldName2", "fieldName3"};
            builder.setIncludeFieldNames(fieldNames);
            assertNotNull(builder.includeFieldNames);
            assertEquals(fieldNames.length, builder.includeFieldNames.length);
            assertArrayEquals(fieldNames, builder.includeFieldNames);
        }
    
        @Test
        void testSetIncludeFieldNames_DuplicateFieldNames() {
            String[] fieldNames = {"fieldName1", "fieldName2", "fieldName1"};
            builder.setIncludeFieldNames(fieldNames);
            assertNotNull(builder.includeFieldNames);
            assertEquals(2, builder.includeFieldNames.length);
            assertArrayEquals(new String[]{"fieldName1", "fieldName2"}, builder.includeFieldNames);
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collection;
    
    class ReflectionToStringBuilderTest {
    
        @Nested
        @DisplayName("toStringExclude method")
        class ToStringExcludeMethod {
    
            private Object object;
    
            @BeforeEach
            void setUp() {
                object = new Object();
            }
    
            @Test
            @DisplayName("returns correct string when excludeFieldNames is null")
            void testToStringExcludeWithNullExcludeFieldNames() {
                String result = ReflectionToStringBuilder.toStringExclude(object, (String[]) null);
                assertNotNull(result);
                assertEquals(object.toString(), result);
            }
    
            @Test
            @DisplayName("returns correct string when excludeFieldNames is empty")
            void testToStringExcludeWithEmptyExcludeFieldNames() {
                String result = ReflectionToStringBuilder.toStringExclude(object, new String[0]);
                assertNotNull(result);
                assertEquals(object.toString(), result);
            }
    
            @Test
            @DisplayName("returns correct string when excludeFieldNames contains valid field names")
            void testToStringExcludeWithValidExcludeFieldNames() {
                String[] excludeFieldNames = {"field1", "field2"};
                String result = ReflectionToStringBuilder.toStringExclude(object, excludeFieldNames);
                assertNotNull(result);
                assertNotEquals(object.toString(), result);
                assertFalse(result.contains(excludeFieldNames[0]));
                assertFalse(result.contains(excludeFieldNames[1]));
            }
    
            @Test
            @DisplayName("returns correct string when excludeFieldNames contains null values")
            void testToStringExcludeWithNullValuesInExcludeFieldNames() {
                String[] excludeFieldNames = {null};
                String result = ReflectionToStringBuilder.toStringExclude(object, excludeFieldNames);
                assertNotNull(result);
                assertEquals(object.toString(), result);
            }
    
            @Test
            @DisplayName("returns correct string when excludeFieldNames contains duplicate values")
            void testToStringExcludeWithDuplicateValuesInExcludeFieldNames() {
                String[] excludeFieldNames = {"field1", "field1"};
                String result = ReflectionToStringBuilder.toStringExclude(object, excludeFieldNames);
                assertNotNull(result);
                assertNotEquals(object.toString(), result);
                assertFalse(result.contains(excludeFieldNames[0]));
            }
    
        }
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    class ReflectionToStringBuilderTest {
    
        @Test
        void testToStringInclude_withNullObject_shouldReturnEmptyString() {
            String result = ReflectionToStringBuilder.toStringInclude(null, "field1", "field2");
            assertEquals("", result);
        }
    
        @Test
        void testToStringInclude_withNoIncludeFieldNames_shouldReturnDefaultToString() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, null);
            String expected = obj.toString();
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withEmptyIncludeFieldNames_shouldReturnDefaultToString() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj);
            String expected = obj.toString();
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNames_shouldIncludeOnlySpecifiedFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndNullValuesExcluded_shouldExcludeNullFields() {
            TestObject obj = new TestObject(null, "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndNullValuesIncluded_shouldIncludeNullFields() {
            TestObject obj = new TestObject(null, "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=null]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndStaticFieldsExcluded_shouldExcludeStaticFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
        
        @Test
        void testToStringInclude_withIncludeFieldNamesAndStaticFieldsIncluded_shouldIncludeStaticFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndTransientFieldsExcluded_shouldExcludeTransientFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndTransientFieldsIncluded_shouldIncludeTransientFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndExcludeFieldNames_shouldExcludeExcludedFields() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    
        @Test
        void testToStringInclude_withIncludeFieldNamesAndUpToClass_shouldIncludeFieldsUpToSpecifiedClass() {
            TestObject obj = new TestObject("value1", "value2");
            String result = ReflectionToStringBuilder.toStringInclude(obj, "field1");
            String expected = "TestObject[field1=value1]";
            assertEquals(expected, result);
        }
    }
    @Test
    @DisplayName("Test accept method with inner class field")
    void testAcceptWithInnerClassField() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("appendStatics");
        assertFalse(ReflectionToStringBuilder.accept(field));
    }
    
    @Test
    @DisplayName("Test accept method with transient field and appendTransients set to false")
    void testAcceptWithTransientFieldAndAppendTransientsFalse() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("appendTransients");
        assertFalse(ReflectionToStringBuilder.accept(field));
    }
    
    @Test
    @DisplayName("Test accept method with static field and appendStatics set to false")
    void testAcceptWithStaticFieldAndAppendStaticsFalse() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("excludeNullValues");
        assertFalse(ReflectionToStringBuilder.accept(field));
    }
    
    @Test
    @DisplayName("Test accept method with excluded field name")
    void testAcceptWithExcludedFieldName() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("upToClass");
        assertFalse(ReflectionToStringBuilder.accept(field));
    }
    
    @Test
    @DisplayName("Test accept method with included field name")
    void testAcceptWithIncludedFieldName() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("excludeFieldNames");
        assertTrue(ReflectionToStringBuilder.accept(field));
    }
    
    @Test
    @DisplayName("Test accept method with field annotated with ToStringExclude")
    void testAcceptWithToStringExcludeAnnotation() throws NoSuchFieldException {
        Field field = ReflectionToStringBuilder.class.getDeclaredField("includeFieldNames");
        assertFalse(ReflectionToStringBuilder.accept(field));
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
      
      private ReflectionToStringBuilder builder;
      
      @Test
      void testGetIncludeFieldNamesNoFields() {
        builder = new ReflectionToStringBuilder(new Object());
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(0, includeFieldNames.length);
      }
      
      @Test
      void testGetIncludeFieldNamesWithFields() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(2, includeFieldNames.length);
        assertTrue(Arrays.asList(includeFieldNames).contains("field1"));
        assertTrue(Arrays.asList(includeFieldNames).contains("field2"));
      }
      
      @Test
      void testGetIncludeFieldNamesEmptyArray() {
        builder = new ReflectionToStringBuilder(new Object());
        builder.includeFieldNames = new String[0];
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(0, includeFieldNames.length);
      }
      
      @Test
      void testGetIncludeFieldNamesNullArray() {
        builder = new ReflectionToStringBuilder(new Object());
        builder.includeFieldNames = null;
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(0, includeFieldNames.length);
      }
      
      @Test
      void testGetIncludeFieldNamesClonedArray() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[] {"field1", "field2"};
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        includeFieldNames[0] = "modified";
        
        assertNotEquals(includeFieldNames[0], builder.getIncludeFieldNames()[0]);
      }
      
      @Test
      void testGetIncludeFieldNamesImmutable() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[] {"field1", "field2"};
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        includeFieldNames[0] = "modified";
        
        assertNotEquals(includeFieldNames[0], builder.getIncludeFieldNames()[0]);
      }
      
      @Test
      void testGetIncludeFieldNamesSameOrder() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[] {"field2", "field1"};
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(2, includeFieldNames.length);
        assertEquals("field2", includeFieldNames[0]);
        assertEquals("field1", includeFieldNames[1]);
      }
      
      @Test
      void testGetIncludeFieldNamesDifferentOrder() {
        MyClass myClass = new MyClass();
        builder = new ReflectionToStringBuilder(myClass);
        builder.includeFieldNames = new String[] {"field1", "field2"};
        
        String[] includeFieldNames = builder.getIncludeFieldNames();
        
        assertEquals(2, includeFieldNames.length);
        assertEquals("field1", includeFieldNames[0]);
        assertEquals("field2", includeFieldNames[1]);
      }
      
      class MyClass {
        private String field1;
        private int field2;
      }
    }
    @Test
    void isAppendTransients_ShouldReturnFalseByDefault() {
        assertFalse(builder.isAppendTransients());
    }
    
    @Test
    void isAppendTransients_ShouldReturnTrueWhenSetToTrue() {
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }
    
    @Test
    void isAppendTransients_ShouldReturnFalseWhenSetToFalse() {
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }
    
    @Test
    void isAppendTransients_ShouldReturnFalseWhenSetToTrueAndThenFalse() {
        builder.setAppendTransients(true);
        builder.setAppendTransients(false);
        assertFalse(builder.isAppendTransients());
    }
    
    @Test
    void isAppendTransients_ShouldReturnTrueWhenSetToFalseAndThenTrue() {
        builder.setAppendTransients(false);
        builder.setAppendTransients(true);
        assertTrue(builder.isAppendTransients());
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
    
        private ReflectionToStringBuilder reflectionToStringBuilder;
    
        @Test
        void setExcludeFieldNames_shouldSetExcludeFieldNamesToNull_whenNullPassed() {
            // Arrange
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
    
            // Act
            reflectionToStringBuilder.setExcludeFieldNames(null);
    
            // Assert
            Assertions.assertNull(reflectionToStringBuilder.excludeFieldNames);
        }
    
        @Test
        void setExcludeFieldNames_shouldSetExcludeFieldNamesToEmptyArray_whenEmptyArrayPassed() {
            // Arrange
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
    
            // Act
            reflectionToStringBuilder.setExcludeFieldNames(new String[0]);
    
            // Assert
            Assertions.assertArrayEquals(new String[0], reflectionToStringBuilder.excludeFieldNames);
        }
    
        @Test
        void setExcludeFieldNames_shouldSetExcludeFieldNamesToSortedArray_whenArrayPassed() {
            // Arrange
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
    
            // Act
            reflectionToStringBuilder.setExcludeFieldNames("field1", "field2", "field3");
    
            // Assert
            Assertions.assertArrayEquals(new String[] { "field1", "field2", "field3" }, reflectionToStringBuilder.excludeFieldNames);
        }
    
        @Test
        void setExcludeFieldNames_shouldSortExcludeFieldNamesArray_whenArrayPassed() {
            // Arrange
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
    
            // Act
            reflectionToStringBuilder.setExcludeFieldNames("field3", "field1", "field2");
    
            // Assert
            Assertions.assertArrayEquals(new String[] { "field1", "field2", "field3" }, reflectionToStringBuilder.excludeFieldNames);
        }
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
    
        @Test
        void testIsExcludeNullValuesDefault() {
            ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
            assertFalse(builder.isExcludeNullValues());
        }
    
        @Test
        void testSetExcludeNullValuesMultipleTimes() {
            ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
            builder.setExcludeNullValues(true);
            assertTrue(builder.isExcludeNullValues());
            builder.setExcludeNullValues(false);
            assertFalse(builder.isExcludeNullValues());
        }
    }
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    import org.mockito.Mock;
    import org.mockito.MockitoAnnotations;
    
    import java.lang.reflect.AccessibleObject;
    import java.lang.reflect.Field;
    import java.lang.reflect.Modifier;
    import java.util.Arrays;
    import java.util.Comparator;
    import java.util.Objects;
    
    import static org.junit.jupiter.api.Assertions.*;
    import static org.mockito.Mockito.*;
    
    class ReflectionToStringBuilderTest {
    
        private ReflectionToStringBuilder reflectionToStringBuilder;
    
        @BeforeEach
        void setUp() {
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for an array")
        void testAppendFieldsInArray() {
            Object[] array = new Object[] {1, 2, 3};
            reflectionToStringBuilder.reflectionAppendArray(array.getClass(), array);
    
            // Assert that all fields in the array are correctly appended
            assertEquals("1, 2, 3", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with fields")
        void testAppendFieldsInClass() {
            // Create a mock class with fields
            class TestClass {
                private int field1;
                private String field2;
                public boolean field3;
            }
    
            TestClass testClass = new TestClass();
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that all fields in the class are correctly appended
            assertEquals("field1=0, field2=null, field3=false", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with excluded fields")
        void testAppendFieldsInClassWithExcludedFields() {
            // Create a mock class with fields
            class TestClass {
                private int field1;
                private String field2;
                public boolean field3;
            }
    
            TestClass testClass = new TestClass();
            reflectionToStringBuilder.setExcludeFieldNames(new String[] {"field2"});
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that excluded fields are not appended
            assertEquals("field1=0, field3=false", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with included fields")
        void testAppendFieldsInClassWithIncludedFields() {
            // Create a mock class with fields
            class TestClass {
                private int field1;
                private String field2;
                public boolean field3;
            }
    
            TestClass testClass = new TestClass();
            reflectionToStringBuilder.setIncludeFieldNames(new String[] {"field2"});
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that only included fields are appended
            assertEquals("field2=null", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with null values")
        void testAppendFieldsInClassWithNullValues() {
            // Create a mock class with fields
            class TestClass {
                private Integer field1;
                private String field2;
            }
    
            TestClass testClass = new TestClass();
            reflectionToStringBuilder.setExcludeNullValues(false);
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that fields with null values are appended
            assertEquals("field1=null, field2=null", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class up to a specific class")
        void testAppendFieldsInClassUpToSpecificClass() {
            // Create a mock class with fields
            class ParentClass {
                private int parentField;
            }
    
            class ChildClass extends ParentClass {
                private int childField;
            }
    
            ChildClass childClass = new ChildClass();
            reflectionToStringBuilder.setUpToClass(ParentClass.class);
            reflectionToStringBuilder.reflectionAppendClass(childClass.getClass(), childClass);
    
            // Assert that fields in the child class are not appended
            assertEquals("parentField=0", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with accessible fields")
        void testAppendFieldsInClassWithAccessibleFields() throws NoSuchFieldException {
            // Create a mock class with fields
            class TestClass {
                private int field;
            }
    
            TestClass testClass = new TestClass();
            Field field = testClass.getClass().getDeclaredField("field");
            AccessibleObject.setAccessible(new Field[] {field}, true);
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that accessible fields are correctly appended
            assertEquals("field=0", reflectionToStringBuilder.toString());
        }
    
        @Test
        @DisplayName("Test appendFieldsIn for a class with inaccessible fields")
        void testAppendFieldsInClassWithInaccessibleFields() throws NoSuchFieldException {
            // Create a mock class with fields
            class TestClass {
                private int field;
            }
    
            TestClass testClass = new TestClass();
            Field field = testClass.getClass().getDeclaredField("field");
            AccessibleObject.setAccessible(new Field[] {field}, false);
            reflectionToStringBuilder.reflectionAppendClass(testClass.getClass(), testClass);
    
            // Assert that inaccessible fields are not appended
            assertEquals("", reflectionToStringBuilder.toString());
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTestSuite {
        
        private ReflectionToStringBuilder reflectionToStringBuilder;
        
        @BeforeAll
        void setUp() {
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValue() {
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertNull(upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueAfterSetting() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(Object.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsNullAfterResetting() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.resetUpToClass();
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertNull(upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsNullAfterSettingToNull() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(null);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertNull(upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForSubclass() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(ReflectionToStringBuilder.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(ReflectionToStringBuilder.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForSuperclass() {
            reflectionToStringBuilder.setUpToClass(ReflectionToStringBuilder.class);
            reflectionToStringBuilder.setUpToClass(Object.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(Object.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForInterface() {
            reflectionToStringBuilder.setUpToClass(ReflectionToStringBuilder.class);
            reflectionToStringBuilder.setUpToClass(AccessibleObject.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(AccessibleObject.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(String[].class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(String[].class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(int[].class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(int[].class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClass() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(ReflectionToStringBuilder.NestedClass.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(ReflectionToStringBuilder.NestedClass.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClass() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object() {}.getClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object() {}.getClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClass() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(LocalClass.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(LocalClass.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClass() {
            Runnable lambda = () -> {};
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(lambda.getClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(lambda.getClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClass() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(TestEnum.class);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(TestEnum.class, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForInterfaceArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Class<?>[] {ClassUtils.class, ArrayUtils.class});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Class<?>[] {ClassUtils.class, ArrayUtils.class}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {{1}, {2, 3}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {{1}, {2, 3}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][][] {{{1}}, {{2, 3}}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][][] {{{1}}, {{2, 3}}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNonNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {new Object(), new Object()});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {new Object(), new Object()}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[] {0});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[] {0}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[] {0, 0});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[] {0, 0}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNonNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[] {1, 2});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[] {1, 2}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClassWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new ReflectionToStringBuilder.NestedClass(null));
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new ReflectionToStringBuilder.NestedClass(null), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClassWithNonNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new ReflectionToStringBuilder.NestedClass(new Object()));
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new ReflectionToStringBuilder.NestedClass(new Object()), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClassWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object() {public void foo() {}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object() {public void foo() {}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClassWithNonNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object() {public void foo() {}}.getClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object() {public void foo() {}}.getClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClassWithNullValue() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new LocalClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new LocalClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClassWithNonNullValue() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new LocalClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new LocalClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClassWithNullValue() {
            Runnable lambda = new Runnable() {
                @Override
                public void run() {}
            };
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(lambda.getClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(lambda.getClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClassWithNonNullValue() {
            Runnable lambda = () -> {};
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(lambda.getClass());
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(lambda.getClass(), upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClassWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(TestEnum.NULL);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(TestEnum.NULL, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClassWithNonNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(TestEnum.VALUE);
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(TestEnum.VALUE, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForInterfaceArrayWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Class<?>[] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Class<?>[] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForInterfaceArrayWithNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Class<?>[] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Class<?>[] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForInterfaceArrayWithNonNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Class<?>[] {ClassUtils.class, ArrayUtils.class});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Class<?>[] {ClassUtils.class, ArrayUtils.class}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayWithNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayWithNonNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {{1}, {2, 3}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {{1}, {2, 3}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayArrayWithNullValue() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][][] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][][] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayArrayWithNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][][] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][][] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayArrayArrayWithNonNullValues() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][][] {{{1}}, {{2, 3}}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][][] {{{1}}, {{2, 3}}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNullValueInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[][] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[][] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[][] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[][] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForArrayWithNonNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[][] {new Object[] {1}, new Object[] {2, 3}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[][] {new Object[] {1}, new Object[] {2, 3}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNullValueInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForPrimitiveArrayWithNonNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new int[][] {{1}, {2, 3}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new int[][] {{1}, {2, 3}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClassWithNullValueInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new ReflectionToStringBuilder.NestedClass[] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new ReflectionToStringBuilder.NestedClass[] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClassWithNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new ReflectionToStringBuilder.NestedClass[] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new ReflectionToStringBuilder.NestedClass[] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForNestedClassWithNonNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new ReflectionToStringBuilder.NestedClass[] {new ReflectionToStringBuilder.NestedClass(null)});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new ReflectionToStringBuilder.NestedClass[] {new ReflectionToStringBuilder.NestedClass(null)}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClassWithNullValueInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {new Object[] {null}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {new Object[] {null}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClassWithNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {new Object[] {null, null}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {new Object[] {null, null}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForAnonymousClassWithNonNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Object[] {new Object[] {new Object()}, new Object[] {new Object(), new Object()}});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Object[] {new Object[] {new Object()}, new Object[] {new Object(), new Object()}}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClassWithNullValueInNestedArray() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new LocalClass[] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new LocalClass[] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClassWithNullValuesInNestedArray() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new LocalClass[] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new LocalClass[] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLocalClassWithNonNullValuesInNestedArray() {
            class LocalClass {}
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new LocalClass[] {new LocalClass()});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new LocalClass[] {new LocalClass()}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClassWithNullValueInNestedArray() {
            Runnable lambda = new Runnable() {
                @Override
                public void run() {}
            };
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Runnable[] {lambda});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Runnable[] {lambda}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClassWithNullValuesInNestedArray() {
            Runnable lambda = new Runnable() {
                @Override
                public void run() {}
            };
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Runnable[] {lambda, lambda});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Runnable[] {lambda, lambda}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForLambdaClassWithNonNullValuesInNestedArray() {
            Runnable lambda = () -> {};
            
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new Runnable[] {lambda});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new Runnable[] {lambda}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClassWithNullValueInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new TestEnum[] {null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new TestEnum[] {null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClassWithNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new TestEnum[] {null, null});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new TestEnum[] {null, null}, upToClass);
        }
        
        @Test
        void testGetUpToClassReturnsCorrectValueForEnumClassWithNonNullValuesInNestedArray() {
            reflectionToStringBuilder.setUpToClass(Object.class);
            reflectionToStringBuilder.setUpToClass(new TestEnum[] {TestEnum.VALUE});
            Class<?> upToClass = reflectionToStringBuilder.getUpToClass();
            assertEquals(new TestEnum[] {TestEnum.VALUE}, upToClass);
        }
        
        private enum TestEnum {
            NULL, VALUE
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTest {
    
        @Test
        void shouldSetExcludeNullValuesToTrue() {
            ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
            builder.setExcludeNullValues(true);
            assertTrue(builder.excludeNullValues);
        }
        
        @Test
        void shouldSetExcludeNullValuesToFalse() {
            ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
            builder.setExcludeNullValues(false);
            assertFalse(builder.excludeNullValues);
        }
    }
    @Test
    @DisplayName("Should return empty array when collection is null")
    void shouldReturnEmptyArrayWhenCollectionIsNull() {
        // Arrange
        Collection<String> collection = null;
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);
        
        // Assert
        assertArrayEquals(new String[0], result);
    }
    
    @Test
    @DisplayName("Should return empty array when collection is empty")
    void shouldReturnEmptyArrayWhenCollectionIsEmpty() {
        // Arrange
        Collection<String> collection = new ArrayList<>();
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);
        
        // Assert
        assertArrayEquals(new String[0], result);
    }
    
    @Test
    @DisplayName("Should return array with non-null elements when collection has non-null elements")
    void shouldReturnArrayWithNonNullElementsWhenCollectionHasNonNullElements() {
        // Arrange
        Collection<String> collection = Arrays.asList("a", "b", "c");
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);
        
        // Assert
        assertArrayEquals(new String[] {"a", "b", "c"}, result);
    }
    
    @Test
    @DisplayName("Should return array with non-null elements when collection has null elements")
    void shouldReturnArrayWithNonNullElementsWhenCollectionHasNullElements() {
        // Arrange
        Collection<String> collection = Arrays.asList("a", null, "c");
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(collection);
        
        // Assert
        assertArrayEquals(new String[] {"a", "c"}, result);
    }
    
    @Test
    @DisplayName("Should return empty array when array is null")
    void shouldReturnEmptyArrayWhenArrayIsNull() {
        // Arrange
        Object[] array = null;
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);
        
        // Assert
        assertArrayEquals(new String[0], result);
    }
    
    @Test
    @DisplayName("Should return empty array when array is empty")
    void shouldReturnEmptyArrayWhenArrayIsEmpty() {
        // Arrange
        Object[] array = new Object[0];
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);
        
        // Assert
        assertArrayEquals(new String[0], result);
    }
    
    @Test
    @DisplayName("Should return array with non-null elements when array has non-null elements")
    void shouldReturnArrayWithNonNullElementsWhenArrayHasNonNullElements() {
        // Arrange
        Object[] array = new Object[] {"a", "b", "c"};
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);
        
        // Assert
        assertArrayEquals(new String[] {"a", "b", "c"}, result);
    }
    
    @Test
    @DisplayName("Should return array with non-null elements when array has null elements")
    void shouldReturnArrayWithNonNullElementsWhenArrayHasNullElements() {
        // Arrange
        Object[] array = new Object[] {"a", null, "c"};
        
        // Act
        String[] result = ReflectionToStringBuilder.toNoNullStringArray(array);
        
        // Assert
        assertArrayEquals(new String[] {"a", "c"}, result);
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    class ReflectionToStringBuilderTest {
    
        @Test
        void shouldReturnFalseByDefault() {
            assertFalse(builder.isAppendStatics());
        }
    
        @Test
        void shouldReturnTrueAfterSettingToTrue() {
            builder.setAppendStatics(true);
            assertTrue(builder.isAppendStatics());
        }
    
        @Test
        void shouldReturnFalseAfterSettingToFalse() {
            builder.setAppendStatics(true);
            builder.setAppendStatics(false);
            assertFalse(builder.isAppendStatics());
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    class ReflectionToStringBuilderTestSuite {
    
        private ReflectionToStringBuilder builder;
    
        @BeforeEach
        void setUp() {
            builder = new ReflectionToStringBuilder(new Object());
        }
    
        @Test
        void setAppendStatics_shouldSetAppendStaticsToTrue() {
            builder.setAppendStatics(true);
            assertTrue(builder.appendStatics);
        }
    
        @Test
        void setAppendStatics_shouldSetAppendStaticsToFalse() {
            builder.setAppendStatics(false);
            assertFalse(builder.appendStatics);
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    import java.lang.reflect.Field;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ReflectionToStringBuilderTest {
    
        private ReflectionToStringBuilder reflectionToStringBuilder;
    
        @BeforeEach
        void setUp() {
            reflectionToStringBuilder = new ReflectionToStringBuilder(new Object());
        }
    
        @Test
        void testGetValue() throws IllegalAccessException {
            Field[] fields = ReflectionToStringBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = reflectionToStringBuilder.getValue(field);
                Assertions.assertNotNull(value);
            }
        }
    
        @Test
        void testGetValue_NullField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("upToClass");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertNull(value);
        }
    
        @Test
        void testGetValue_StaticField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("appendStatics");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertTrue((boolean) value);
        }
    
        @Test
        void testGetValue_TransientField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("appendTransients");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertFalse((boolean) value);
        }
    
        @Test
        void testGetValue_ExcludeNullValuesField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("excludeNullValues");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertFalse((boolean) value);
        }
    
        @Test
        void testGetValue_ExcludeFieldNamesField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("excludeFieldNames");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertNull(value);
        }
    
        @Test
        void testGetValue_IncludeFieldNamesField() throws IllegalAccessException {
            Field field = ReflectionToStringBuilder.class.getDeclaredField("includeFieldNames");
            field.setAccessible(true);
            Object value = reflectionToStringBuilder.getValue(field);
            Assertions.assertNull(value);
        }
    }
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    
    class ReflectionToStringBuilderTest {
    
        private static class TestClass {
            private int privateField;
            public int publicField;
            private static int staticField;
            private transient int transientField;
            private String[] arrayField;
            private Object nullField;
    
            @Override
            public String toString() {
                return ReflectionToStringBuilder.toString(this);
            }
        }
    
        @Test
        void testToString() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2, " +
                    "arrayField=[a, b, c], " +
                    "nullField=null" +
                    "]";
    
            Assertions.assertEquals(expected, testObject.toString());
        }
    
        @Test
        void testToStringWithStyle() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2, " +
                    "arrayField=[a, b, c]" +
                    "]";
    
            String actual = ReflectionToStringBuilder.toString(testObject,
                    ToStringStyle.DEFAULT_STYLE
                            .setFieldSeparator(", ")
                            .setNullText("")
                            .setUseClassName(false)
                            .setUseIdentityHashCode(false)
                            .setArrayStart("[")
                            .setArrayEnd("]")
                            .setArraySeparator(", "));
    
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void testToStringWithOutputTransients() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2, " +
                    "transientField=3, " +
                    "arrayField=[a, b, c], " +
                    "nullField=null" +
                    "]";
    
            String actual = ReflectionToStringBuilder.toString(testObject,
                    ToStringStyle.DEFAULT_STYLE,
                    true);
    
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void testToStringWithOutputStatics() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2, " +
                    "transientField=3, " +
                    "arrayField=[a, b, c], " +
                    "nullField=null" +
                    "]";
    
            String actual = ReflectionToStringBuilder.toString(testObject,
                    ToStringStyle.DEFAULT_STYLE,
                    false,
                    true);
    
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void testToStringWithExcludeNullValues() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2, " +
                    "arrayField=[a, b, c]" +
                    "]";
    
            String actual = ReflectionToStringBuilder.toString(testObject,
                    ToStringStyle.DEFAULT_STYLE,
                    false,
                    false,
                    true);
    
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void testToStringWithReflectUpToClass() {
            TestClass testObject = new TestClass();
            testObject.privateField = 1;
            testObject.publicField = 2;
            testObject.transientField = 3;
            testObject.arrayField = new String[]{"a", "b", "c"};
            testObject.nullField = null;
    
            String expected = "TestClass@<hashCode>[" +
                    "privateField=1, " +
                    "publicField=2" +
                    "]";
    
            String actual = ReflectionToStringBuilder.toString(testObject,
                    ToStringStyle.DEFAULT_STYLE,
                    false,
                    false,
                    false,
                    Object.class);
    
            Assertions.assertEquals(expected, actual);
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class ReflectionToStringBuilderTest {
    
        @Test
        void reflectionAppendArray_shouldAppendArrayToToString() {
            // test code here
        }
    
        @Test
        void reflectionAppendArray_shouldAppendEmptyArrayToToString() {
            // test code here
        }
    
        @Test
        void reflectionAppendArray_shouldAppendNullArrayToToString() {
            // test code here
        }
    
        @Test
        void reflectionAppendArray_shouldAppendSingleValueArrayToToString() {
            // test code here
        }
    }
    @Test
    void setAppendTransients_True() {
        builder.setAppendTransients(true);
        assertTrue(builder.appendTransients);
    }
    
    @Test
    void setAppendTransients_False() {
        builder.setAppendTransients(false);
        assertFalse(builder.appendTransients);
    }
    
    @Test
    void setAppendTransients_DefaultValue() {
        assertFalse(builder.appendTransients);
    }

}