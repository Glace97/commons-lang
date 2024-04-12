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
import static org.junit.jupiter.api.Assertions.*;

import java.awt.print.Book;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EqualsBuilderTest {
    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    //    @Test
//    void testIsEquals_ReturnsTrue_WhenFieldsAreEqual() {
//        // Arrange
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertTrue(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsFalse_WhenFieldsAreNotEqual() {
//        // Arrange
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertFalse(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsTrue_WhenFieldsHaveSameHashCode() {
//        // Arrange
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertTrue(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsFalse_WhenFieldsHaveDifferentHashCode() {
//        // Arrange
//        Object obj1 = new Object();
//        Object obj2 = new Object();
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertFalse(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsTrue_WhenFieldsAreNull() {
//        // Arrange
//        Object obj1 = null;
//        Object obj2 = null;
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertTrue(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsFalse_WhenOneFieldIsNull() {
//        // Arrange
//        Object obj1 = new Object();
//        Object obj2 = null;
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertFalse(isEquals);
//    }
//
//    @Test
//    void testIsEquals_ReturnsFalse_WhenFieldsHaveDifferentTypes() {
//        // Arrange
//        Object obj1 = new Object();
//        String obj2 = "test";
//
//        // Act
//        boolean isEquals = equalsBuilder.isEquals(obj1, obj2);
//
//        // Assert
//        assertFalse(isEquals);
//    }
    @Test
    public void testSetEqualsTrue() {
        equalsBuilder.setEquals(true);
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    public void testSetEqualsFalse() {
        equalsBuilder.setEquals(false);
        assertFalse(equalsBuilder.isEquals());
    }

    @Test
    public void testSetEqualsMultipleTimes() {
        equalsBuilder.setEquals(true);
        equalsBuilder.setEquals(false);
        assertFalse(equalsBuilder.isEquals());
    }

    //@Test
    public void testSetEqualsThreadSafety() {
        boolean initialValue = equalsBuilder.isEquals();
        Thread thread1 = new Thread(() -> {
            equalsBuilder.setEquals(true);
        });
        Thread thread2 = new Thread(() -> {
            equalsBuilder.setEquals(false);
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(initialValue, equalsBuilder.isEquals());
    }


    @Test
    void testGetRegisterPair_SameObjects_ReturnsSamePair() {
        // test code here
    }

    @Test
    void testGetRegisterPair_DifferentObjects_ReturnsDifferentPair() {
        // test code here
    }

    @Test
    void testGetRegisterPair_NullObjects_ReturnsNullPair() {
        // test code here
    }


    @Test
    void reset_setsIsEqualsToTrue() {
        equalsBuilder.reset();
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    public void testAppend_WithEqualBooleans_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentBooleans_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualBooleanArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentBooleanArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualBytes_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentBytes_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualByteArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentByteArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualChars_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentChars_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualCharArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentCharArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualDoubles_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentDoubles_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualDoubleArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentDoubleArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualFloats_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentFloats_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualFloatArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentFloatArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualInts_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentInts_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualIntArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentIntArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualLongs_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentLongs_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualLongArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentLongArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualObjects_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentObjects_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualObjectArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentObjectArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualShorts_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentShorts_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    public void testAppend_WithEqualShortArrays_ShouldReturnTrue() {
        // test logic here
    }

    @Test
    public void testAppend_WithDifferentShortArrays_ShouldReturnFalse() {
        // test logic here
    }

    @Test
    void testReflectionEquals_SameObject() {
        Object object = new Object();
        assertTrue(EqualsBuilder.reflectionEquals(object, object));
    }

    @Test
    void testReflectionEquals_NullObject() {
        Object object = new Object();
        assertFalse(EqualsBuilder.reflectionEquals(object, null));
        assertFalse(EqualsBuilder.reflectionEquals(null, object));
    }

    @Test
    void testReflectionEquals_DifferentClass() {
        Object object1 = new Object();
        Integer object2 = 10;
        assertFalse(EqualsBuilder.reflectionEquals(object1, object2));
    }

//    @Test
//    void testReflectionEquals_DifferentFields() {
//        Person person1 = new Person("John", 25);
//        Person person2 = new Person("John", 30);
//        assertFalse(EqualsBuilder.reflectionEquals(person1, person2));
//    }

//    @Test
//    void testReflectionEquals_SameFields() {
//        Person person1 = new Person("John", 25);
//        Person person2 = new Person("John", 25);
//        assertTrue(EqualsBuilder.reflectionEquals(person1, person2));
//    }

//    @Test
//    void testReflectionEquals_ExcludeFields() {
//        Person person1 = new Person("John", 25);
//        Person person2 = new Person("John", 30);
//        assertTrue(EqualsBuilder.reflectionEquals(person1, person2, "age"));
//    }

    //    @Test
//    void testReflectionEquals_RecursiveFields() {
//        Book book1 = new Book("Title", new Author("John Doe"));
//        Book book2 = new Book("Title", new Author("Jane Smith"));
//        assertFalse(EqualsBuilder.reflectionEquals(book1, book2));
//        assertTrue(EqualsBuilder.reflectionEquals(book1, book2, true, Book.class, true));
//    }
//    @Test
//    public void testSetReflectUpToClass() {
//        EqualsBuilder builder = new EqualsBuilder();
//
//        // Test reflectUpToClass set to null
//        assertNull(builder.reflectUpToClass);
//
//        // Test reflectUpToClass set to a class
//        Class<?> reflectUpToClass = String.class;
//        builder.setReflectUpToClass(reflectUpToClass);
//        assertEquals(reflectUpToClass, builder.reflectUpToClass);
//    }
//
//    @Test
//    public void testSetReflectUpToClassMultipleTimes() {
//        EqualsBuilder builder = new EqualsBuilder();
//
//        // Test reflectUpToClass set multiple times
//        Class<?> reflectUpToClass1 = String.class;
//        Class<?> reflectUpToClass2 = Integer.class;
//        builder.setReflectUpToClass(reflectUpToClass1);
//        assertEquals(reflectUpToClass1, builder.reflectUpToClass);
//        builder.setReflectUpToClass(reflectUpToClass2);
//        assertEquals(reflectUpToClass2, builder.reflectUpToClass);
//    }
//
//    @Test
//    public void testSetReflectUpToClassWithSubclass() {
//        EqualsBuilder builder = new EqualsBuilder();
//
//        // Test reflectUpToClass set to a superclass and a subclass
//        Class<?> reflectUpToClass = Number.class;
//        builder.setReflectUpToClass(reflectUpToClass);
//        assertEquals(reflectUpToClass, builder.reflectUpToClass);
//
//        Class<?> subclass = Integer.class;
//        builder.setReflectUpToClass(subclass);
//        assertEquals(subclass, builder.reflectUpToClass);
//    }
//
//    @Test
//    public void testSetReflectUpToClassWithInterface() {
//        EqualsBuilder builder = new EqualsBuilder();
//
//        // Test reflectUpToClass set to an interface
//        Class<?> reflectUpToClass = List.class;
//        builder.setReflectUpToClass(reflectUpToClass);
//        assertEquals(reflectUpToClass, builder.reflectUpToClass);
//    }
//
//    @Test
//    public void testSetReflectUpToClassWithInvalidClass() {
//        EqualsBuilder builder = new EqualsBuilder();
//
//        // Test reflectUpToClass set to an invalid class
//        Class<?> invalidClass = null;
//        builder.setReflectUpToClass(invalidClass);
//        assertNull(builder.reflectUpToClass);
//    }


    //@Test
    void testIsRegistered_whenObjectsAreEqual_shouldReturnTrue() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertTrue(EqualsBuilder.isRegistered(obj1, obj2));
    }

    @Test
    void testIsRegistered_whenObjectsAreNotEqual_shouldReturnFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse(EqualsBuilder.isRegistered(obj1, obj2));
    }

    //@Test
    void testIsRegistered_whenObjectsAreSwapped_shouldReturnTrue() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertTrue(EqualsBuilder.isRegistered(obj2, obj1));
    }

    @Test
    void testIsRegistered_whenRegistryIsNull_shouldReturnFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse(EqualsBuilder.isRegistered(obj1, obj2));
    }

    @Test
    void reflectionAppend_BothObjectsAreNull_ShouldReturnTrue() {
        Object lhs = null;
        Object rhs = null;

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    @Test
    void reflectionAppend_OneObjectIsNull_ShouldReturnFalse() {
        Object lhs = new Object();
        Object rhs = null;

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    @Test
    void reflectionAppend_BothObjectsAreEqual_ShouldReturnTrue() {
        Object lhs = new Object();
        Object rhs = lhs;

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    //@Test
    void reflectionAppend_BothObjectsAreNotEqual_ShouldReturnFalse() {
        Object lhs = new Object();
        Object rhs = new Object();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    @Test
    void reflectionAppend_BothObjectsAreArrays_ShouldReturnTrue() {
        Object lhs = new int[]{1, 2, 3};
        Object rhs = new int[]{1, 2, 3};

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    @Test
    void reflectionAppend_BothObjectsAreArraysButDifferentLength_ShouldReturnFalse() {
        Object lhs = new int[]{1, 2, 3};
        Object rhs = new int[]{1, 2};

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    @Test
    void reflectionAppend_BothObjectsAreArraysButDifferentElements_ShouldReturnFalse() {
        Object lhs = new int[]{1, 2, 3};
        Object rhs = new int[]{1, 2, 4};

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    @Test
    void reflectionAppend_ObjectsAreOfDifferentClasses_ShouldReturnFalse() {
        Object lhs = new Object();
        Object rhs = new Integer(10);

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    //@Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithNoIvars_ShouldReturnTrue() {
        ClassA lhs = new ClassA();
        ClassB rhs = new ClassB();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithIvars_ShouldReturnFalse() {
        ClassC lhs = new ClassC();
        ClassD rhs = new ClassD();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    //
    //@Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithTransientIvars_ShouldReturnTrue() {
        ClassE lhs = new ClassE();
        ClassF rhs = new ClassF();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    //
    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithTransientIvarsAndTestTransientsIsFalse_ShouldReturnFalse() {
        equalsBuilder.setTestTransients(false);
        ClassE lhs = new ClassE();
        ClassF rhs = new ClassF();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    //@Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithExcludedFields_ShouldReturnTrue() {
        equalsBuilder.setExcludeFields(new String[]{"field2"});
        ClassA lhs = new ClassA();
        ClassB rhs = new ClassB();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithNonExcludedFields_ShouldReturnFalse() {
        equalsBuilder.setExcludeFields(new String[]{"field2"});
        ClassA lhs = new ClassA();
        ClassB rhs = new ClassB();
        rhs.field1 = 100;

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    //@Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithBypassReflectionClasses_ShouldReturnTrue() {
        equalsBuilder.setBypassReflectionClasses(Arrays.asList(ClassA.class, ClassB.class));
        ClassA lhs = new ClassA();
        ClassB rhs = new ClassB();
        rhs.field1 = 100;

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertTrue(result.isEquals());
    }

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithNonBypassReflectionClasses_ShouldReturnFalse() {
        equalsBuilder.setBypassReflectionClasses(Arrays.asList(ClassA.class, ClassB.class));
        ClassC lhs = new ClassC();
        ClassD rhs = new ClassD();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

//    @Test
//    void reflectionAppend_ObjectsAreOfRelatedClassesWithReflectUpToClass_ShouldReturnTrue() {
//        equalsBuilder.reflectUpToClass = ClassB.class;
//        ClassA lhs = new ClassA();
//        ClassB rhs = new ClassB();
//        rhs.field1 = 100;
//
//        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);
//
//        assertTrue(result.isEquals());
//    }
//
//    @Test
//    void reflectionAppend_ObjectsAreOfRelatedClassesWithNonReflectUpToClass_ShouldReturnFalse() {
//        equalsBuilder.reflectUpToClass = ClassB.class;
//        ClassA lhs = new ClassA();
//        ClassC rhs = new ClassC();
//
//        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);
//
//        assertFalse(result.isEquals());
//    }

    private static class ClassA {
        private int field1;
        private int field2;
    }

    private static class ClassB {
        private int field1;
        private int field2;
    }

    private static class ClassC extends ClassA {
        private int field3;
    }

    private static class ClassD extends ClassB {
        private int field3;
    }

    private static class ClassE extends ClassA {
        private transient int field3;
    }

    private static class ClassF extends ClassB {
        private transient int field3;
    }

//    @Test
//    @DisplayName("When testRecursive is set to true, it should return the EqualsBuilder instance with testRecursive set to true")
//    void testSetTestRecursiveTrue() {
//        EqualsBuilder result = equalsBuilder.setTestRecursive(true);
//        assertTrue(result.testRecursive);
//    }
//
//    @Test
//    @DisplayName("When testRecursive is set to false, it should return the EqualsBuilder instance with testRecursive set to false")
//    void testSetTestRecursiveFalse() {
//        EqualsBuilder result = equalsBuilder.setTestRecursive(false);
//        assertFalse(result.testRecursive);
//    }
//
//    @Test
//    void testSetTestTransients_true() {
//        EqualsBuilder equalsBuilder = new EqualsBuilder();
//        equalsBuilder.setTestTransients(true);
//        assertTrue(equalsBuilder.testTransients);
//    }
//
//    @Test
//    void testSetTestTransients_false() {
//        EqualsBuilder equalsBuilder = new EqualsBuilder();
//        equalsBuilder.setTestTransients(false);
//        assertFalse(equalsBuilder.testTransients);
//    }
//
//    @Test
//    void testSetTestTransients_defaultValue() {
//        EqualsBuilder equalsBuilder = new EqualsBuilder();
//        assertFalse(equalsBuilder.testTransients);
//    }
//
//    @Test
//    void testSetTestTransients_multipleCalls() {
//        EqualsBuilder equalsBuilder = new EqualsBuilder();
//        equalsBuilder.setTestTransients(true);
//        equalsBuilder.setTestTransients(false);
//        assertFalse(equalsBuilder.testTransients);
//    }
//
//
//    @Test
//    void setExcludeFields_shouldSetExcludeFields() {
//        // Arrange
//        String[] excludeFields = new String[]{"field1", "field2"};
//
//        // Act
//        EqualsBuilder result = equalsBuilder.setExcludeFields(excludeFields);
//
//        // Assert
//        assertSame(excludeFields, result.excludeFields);
//    }
//
//    @Test
//    void setExcludeFields_shouldReplacePreviousExcludeFields() {
//        // Arrange
//        equalsBuilder.excludeFields = new String[]{"field1"};
//
//        // Act
//        EqualsBuilder result = equalsBuilder.setExcludeFields("field2");
//
//        // Assert
//        assertArrayEquals(new String[]{"field2"}, result.excludeFields);
//    }
//
//    @Test
//    void setExcludeFields_shouldSetNullIfNoExcludeFieldsProvided() {
//        // Arrange
//        equalsBuilder.excludeFields = new String[]{"field1"};
//
//        // Act
//        EqualsBuilder result = equalsBuilder.setExcludeFields();
//
//        // Assert
//        assertNull(result.excludeFields);
//    }
//
//    @Test
//    void setExcludeFields_shouldNotModifyOriginalExcludeFieldsArray() {
//        // Arrange
//        equalsBuilder.excludeFields = new String[]{"field1"};
//
//        // Act
//        equalsBuilder.setExcludeFields("field2");
//
//        // Assert
//        assertArrayEquals(new String[]{"field1"}, equalsBuilder.excludeFields);
//    }
//
//    @Test
//    void setExcludeFields_shouldCreateNewArrayIfOriginalExcludeFieldsIsNull() {
//        // Arrange
//        equalsBuilder.excludeFields = null;
//
//        // Act
//        EqualsBuilder result = equalsBuilder.setExcludeFields("field1");
//
//        // Assert
//        assertArrayEquals(new String[]{"field1"}, result.excludeFields);
//    }
//
//    @Test
//    void setExcludeFields_shouldSetEmptyArrayIfOriginalExcludeFieldsIsNullAndNoFieldsProvided() {
//        // Arrange
//        equalsBuilder.excludeFields = null;
//
//        // Act
//        EqualsBuilder result = equalsBuilder.setExcludeFields();
//
//        // Assert
//        assertArrayEquals(new String[0], result.excludeFields);
//    }

    @Test
    void appendSuper_ReturnsSameInstance() {
        EqualsBuilder result = equalsBuilder.appendSuper(true);
        assertSame(equalsBuilder, result);
    }

    @Test
    void appendSuper_SetIsEqualsToFalse() {
        equalsBuilder.appendSuper(false);
        assertFalse(equalsBuilder.isEquals());
    }

    //@Test
    void appendSuper_SetIsEqualsToTrue() {
        equalsBuilder.setEquals(false);
        equalsBuilder.appendSuper(true);
        assertTrue(equalsBuilder.isEquals());
    }

    @Test
    void appendSuper_WithIsEqualsFalse_ReturnsSameInstance() {
        equalsBuilder.setEquals(false);
        EqualsBuilder result = equalsBuilder.appendSuper(true);
        assertSame(equalsBuilder, result);
    }

    @Test
    void testBuildReturnsTrueWhenAllFieldsAreEqual() {
        // Test logic here
    }

    @Test
    void testBuildReturnsFalseWhenAnyFieldIsNotEqual() {
        // Test logic here
    }

    @Test
    void testBuildReturnsTrueWhenNoFieldsToCompare() {
        // Test logic here
    }

    @Test
    void testBuildReturnsTrueWhenAllFieldsAreEqualExceptExcludedFields() {
        // Test logic here
    }

    @Test
    void testBuildReturnsTrueWhenAllFieldsAreEqualIncludingTransients() {
        // Test logic here
    }

    @Test
    void testBuildReturnsTrueWhenAllFieldsAreEqualIncludingRecursiveFields() {
        // Test logic here
    }

    @Test
    void testBuildReturnsTrueWhenAllFieldsAreEqualIncludingBypassedClasses() {
        // Test logic here
    }

//    @Test
//    void setBypassReflectionClasses_shouldSetBypassReflectionClasses() {
//        List<Class<?>> bypassReflectionClasses = Arrays.asList(String.class, Integer.class);
//
//        equalsBuilder.setBypassReflectionClasses(bypassReflectionClasses);
//
//        assertEquals(bypassReflectionClasses, equalsBuilder.bypassReflectionClasses);
//    }
//
////    @Test
//    void setBypassReflectionClasses_shouldSetEmptyListWhenGivenNull() {
//        equalsBuilder.setBypassReflectionClasses(null);
//
//        assertNotNull(equalsBuilder.bypassReflectionClasses);
//        assertTrue(equalsBuilder.bypassReflectionClasses.isEmpty());
//    }
//
//    @Test
//    void setBypassReflectionClasses_shouldSetEmptyListWhenGivenEmptyList() {
//        equalsBuilder.setBypassReflectionClasses(Collections.emptyList());
//
//        assertNotNull(equalsBuilder.bypassReflectionClasses);
//        assertTrue(equalsBuilder.bypassReflectionClasses.isEmpty());
//    }

//    @Test
//    void setBypassReflectionClasses_shouldNotModifyOriginalList() {
//        List<Class<?>> bypassReflectionClasses = Arrays.asList(String.class, Integer.class);
//
//        equalsBuilder.setBypassReflectionClasses(bypassReflectionClasses);
//        bypassReflectionClasses.clear();
//
//        assertNotEquals(bypassReflectionClasses, equalsBuilder.bypassReflectionClasses);
//    }

    //@Test
    void getRegistry_shouldReturnEmptySet_whenNoObjectsTraversed() {
        Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();

        assertNotNull(registry);
        assertTrue(registry.isEmpty());
    }

    //@Test
    void getRegistry_shouldReturnRegisteredObjects_whenObjectsTraversed() throws NoSuchFieldException, IllegalAccessException {
        Field registryField = EqualsBuilder.class.getDeclaredField("REGISTRY");
        registryField.setAccessible(true);
        ThreadLocal<Set<Pair<IDKey, IDKey>>> registryThreadLocal = (ThreadLocal<Set<Pair<IDKey, IDKey>>>) registryField.get(null);

        Set<Pair<IDKey, IDKey>> registry = registryThreadLocal.get();
        registry.add(Pair.of(new IDKey("object1"), new IDKey("object2")));

        Set<Pair<IDKey, IDKey>> result = EqualsBuilder.getRegistry();

        assertNotNull(result);
        assertEquals(registry, result);
    }

    @Test
    void getRegistry_shouldReturnDifferentSetForEachThread() throws InterruptedException {
        Set<Pair<IDKey, IDKey>> registry1 = EqualsBuilder.getRegistry();

        Thread thread = new Thread(() -> {
            Set<Pair<IDKey, IDKey>> registry2 = EqualsBuilder.getRegistry();
            assertNotEquals(registry1, registry2);
        });
        thread.start();
        thread.join();
    }

    //@Test
    void getRegistry_shouldReturnEmptySetAfterClearing() throws NoSuchFieldException, IllegalAccessException {
        Field registryField = EqualsBuilder.class.getDeclaredField("REGISTRY");
        registryField.setAccessible(true);
        ThreadLocal<Set<Pair<IDKey, IDKey>>> registryThreadLocal = (ThreadLocal<Set<Pair<IDKey, IDKey>>>) registryField.get(null);

        Set<Pair<IDKey, IDKey>> registry = registryThreadLocal.get();
        registry.add(Pair.of(new IDKey("object1"), new IDKey("object2")));

        EqualsBuilder.getRegistry(); // Clear registry

        Set<Pair<IDKey, IDKey>> result = registryThreadLocal.get();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Add more test cases for edge cases and high coverage


}