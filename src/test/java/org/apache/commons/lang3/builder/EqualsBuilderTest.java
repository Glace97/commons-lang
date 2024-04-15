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

    @Test
    void testIsRegistered_whenObjectsAreNotEqual_shouldReturnFalse() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertFalse(EqualsBuilder.isRegistered(obj1, obj2));
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

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithIvars_ShouldReturnFalse() {
        ClassC lhs = new ClassC();
        ClassD rhs = new ClassD();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithTransientIvarsAndTestTransientsIsFalse_ShouldReturnFalse() {
        equalsBuilder.setTestTransients(false);
        ClassE lhs = new ClassE();
        ClassF rhs = new ClassF();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
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

    @Test
    void reflectionAppend_ObjectsAreOfRelatedClassesWithNonBypassReflectionClasses_ShouldReturnFalse() {
        equalsBuilder.setBypassReflectionClasses(Arrays.asList(ClassA.class, ClassB.class));
        ClassC lhs = new ClassC();
        ClassD rhs = new ClassD();

        EqualsBuilder result = equalsBuilder.reflectionAppend(lhs, rhs);

        assertFalse(result.isEquals());
    }

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


}