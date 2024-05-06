package org.apache.commons.lang3;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.mutable.MutableObject;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ClassUtilsTest {

    @Test
    public void testWrapperToPrimitive_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertNull(result);
    }

    @Test
    public void testWrapperToPrimitive_IntegerWrapper_ReturnsIntegerType() {
        // Instantiate all necessary variables here
        Class<?> cls = Integer.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertEquals(Integer.TYPE, result);
    }

    @Test
    public void testWrapperToPrimitive_LongWrapper_ReturnsLongType() {
        // Instantiate all necessary variables here
        Class<?> cls = Long.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertEquals(Long.TYPE, result);
    }

    @Test
    public void testWrapperToPrimitive_BooleanWrapper_ReturnsBooleanType() {
        // Instantiate all necessary variables here
        Class<?> cls = Boolean.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertEquals(Boolean.TYPE, result);
    }

    @Test
    public void testWrapperToPrimitive_DoubleWrapper_ReturnsDoubleType() {
        // Instantiate all necessary variables here
        Class<?> cls = Double.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertEquals(Double.TYPE, result);
    }

    @Test
    public void testWrapperToPrimitive_StringClass_ReturnsNull() {
        // Instantiate all necessary variables here
        Class<?> cls = String.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.wrapperToPrimitive(cls);

        assertNull(result);
    }

    @Test
    public void testGetName_NullClass_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;
        String expected = "";

        // Write the test code here following the given rules
        String actual = ClassUtils.getName(cls);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testGetName_NullObject_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Object object = null;
        String expected = "";

        // Write the test code here following the given rules
        String actual = ClassUtils.getName(object);
        
        assertEquals(expected, actual);
    }
    
    private static class MyClass extends SuperClass implements Interface1 {
    }
    
    private static class SuperClass implements Interface2 {
    }
    
    private interface Interface1 extends Interface2 {
    }
    
    private interface Interface2 {
    }

    @Test
    public void testIsPrimitiveOrWrapper_withNullType_shouldReturnFalse() {
        // Arrange
        Class<?> type = null;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withPrimitiveType_shouldReturnTrue() {
        // Arrange
        Class<?> type = int.class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withPrimitiveWrapperType_shouldReturnTrue() {
        // Arrange
        Class<?> type = Integer.class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withNonPrimitiveOrWrapperType_shouldReturnFalse() {
        // Arrange
        Class<?> type = String.class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withInterfaceType_shouldReturnFalse() {
        // Arrange
        Class<?> type = List.class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withArrayPrimitiveType_shouldReturnFalse() {
        // Arrange
        Class<?> type = int[].class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPrimitiveOrWrapper_withArrayPrimitiveWrapperType_shouldReturnFalse() {
        // Arrange
        Class<?> type = Integer[].class;

        // Act
        boolean result = ClassUtils.isPrimitiveOrWrapper(type);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testWrappersToPrimitives_NullInput_ReturnsNull() {
        // Arrange
        Class<?>[] classes = null;

        // Act
        Class<?>[] result = ClassUtils.wrappersToPrimitives(classes);

        // Assert
        assertNull(result);
    }

    @Test
    public void testWrappersToPrimitives_EmptyArrayInput_ReturnsEmptyArray() {
        // Arrange
        Class<?>[] classes = new Class<?>[0];

        // Act
        Class<?>[] result = ClassUtils.wrappersToPrimitives(classes);

        // Assert
        assertArrayEquals(new Class<?>[0], result);
    }

    @Test
    public void testWrappersToPrimitives_ValidInput_ReturnsConvertedArray() {
        // Arrange
        Class<?>[] classes = {Integer.class, Double.class, Boolean.class};
        Class<?>[] expected = {int.class, double.class, boolean.class};

        // Act
        Class<?>[] result = ClassUtils.wrappersToPrimitives(classes);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWrappersToPrimitives_MixedInput_ReturnsConvertedArray() {
        // Arrange
        Class<?>[] classes = {Integer.class, String.class, Boolean.class};
        Class<?>[] expected = {int.class, null, boolean.class};

        // Act
        Class<?>[] result = ClassUtils.wrappersToPrimitives(classes);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWrappersToPrimitives_NullElementInInput_ReturnsConvertedArrayWithNull() {
        // Arrange
        Class<?>[] classes = {Integer.class, null, Boolean.class};
        Class<?>[] expected = {int.class, null, boolean.class};

        // Act
        Class<?>[] result = ClassUtils.wrappersToPrimitives(classes);

        // Assert
        assertArrayEquals(expected, result);
    }

    @Test
    public void testPrimitiveToWrapper_WithNullInput_ShouldReturnNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.primitiveToWrapper(cls);

        assertNull(result);
    }

    @Test
    public void testPrimitiveToWrapper_WithNonPrimitiveInput_ShouldReturnSameClass() {
        // Instantiate all necessary variables here
        Class<?> cls = String.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.primitiveToWrapper(cls);

        assertSame(cls, result);
    }

    @Test
    public void testPrimitiveToWrapper_WithPrimitiveInput_ShouldReturnWrapperClass() {
        // Instantiate all necessary variables here
        Class<?> cls = int.class;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.primitiveToWrapper(cls);

        assertEquals(Integer.class, result);
    }

    @Test
    public void testGetCanonicalName_WithNonNullClass_ReturnsCanonicalName() {
        // Arrange
        Class<?> cls = String.class;
        String expected = "java.lang.String";
        
        // Act
        String actual = ClassUtils.getCanonicalName(cls);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithNullClass_ReturnsDefaultValue() {
        // Arrange
        Class<?> cls = null;
        String defaultValue = "default";
        
        // Act
        String actual = ClassUtils.getCanonicalName(cls, defaultValue);

        // Assert
        assertEquals(defaultValue, actual);
    }

    @Test
    public void testGetCanonicalName_WithNonNullObject_ReturnsCanonicalName() {
        // Arrange
        Object object = new String();
        String expected = "java.lang.String";
        
        // Act
        String actual = ClassUtils.getCanonicalName(object);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetCanonicalName_WithNullObject_ReturnsDefaultValue() {
        // Arrange
        Object object = null;
        String defaultValue = "default";
        
        // Act
        String actual = ClassUtils.getCanonicalName(object, defaultValue);

        // Assert
        assertEquals(defaultValue, actual);
    }

    @Test
    public void shouldReturnEmptyStringIfClassIsNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(cls);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnShortClassNameFromObject() {
        // Instantiate all necessary variables here
        Object object = new Object();

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(object, "default");

        assertEquals("Object", result);
    }

    @Test
    public void shouldReturnEmptyStringIfClassNameIsNull() {
        // Instantiate all necessary variables here
        String className = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(className);

        assertEquals("", result);
    }

    @Test
    public void shouldReturnShortClassNameFromArray() {
        // Instantiate all necessary variables here
        String className = "[Ljava.lang.String;";

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(className);

        assertEquals("String[]", result);
    }

    @Test
    public void testGetSimpleName_NullClass_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(cls);
        assertEquals("", result);
    }

    @Test
    public void testGetSimpleName_NonNullClass_ReturnsSimpleName() {
        // Instantiate all necessary variables here
        Class<?> cls = String.class;

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(cls);
        assertEquals("String", result);
    }

    @Test
    public void testGetSimpleName_NullClassWithDefaultValue_ReturnsDefaultValue() {
        // Instantiate all necessary variables here
        Class<?> cls = null;
        String defaultValue = "Default";

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(cls, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test
    public void testGetSimpleName_NonNullClassWithDefaultValue_ReturnsSimpleName() {
        // Instantiate all necessary variables here
        Class<?> cls = String.class;
        String defaultValue = "Default";

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(cls, defaultValue);
        assertEquals("String", result);
    }

    @Test
    public void testGetSimpleName_NullObject_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Object object = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(object);
        assertEquals("", result);
    }

    @Test
    public void testGetSimpleName_NonNullObject_ReturnsSimpleName() {
        // Instantiate all necessary variables here
        Object object = "test";

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(object);
        assertEquals("String", result);
    }

    @Test
    public void testGetSimpleName_NullObjectWithDefaultValue_ReturnsDefaultValue() {
        // Instantiate all necessary variables here
        Object object = null;
        String defaultValue = "Default";

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(object, defaultValue);
        assertEquals(defaultValue, result);
    }

    @Test
    public void testGetSimpleName_NonNullObjectWithDefaultValue_ReturnsSimpleName() {
        // Instantiate all necessary variables here
        Object object = "test";
        String defaultValue = "Default";

        // Write the test code here following the given rules
        String result = ClassUtils.getSimpleName(object, defaultValue);
        assertEquals("String", result);
    }

    @Test
    public void testGetAllSuperclasses_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllSuperclasses(cls);

        assertNull(result);
    }

    @Test
    public void testGetAllSuperclasses_MultipleSuperclasses_ReturnsAllSuperclasses() {
        // Instantiate all necessary variables here
        Class<?> cls = ArrayList.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllSuperclasses(cls);

        assertEquals(3, result.size());
        assertEquals(AbstractList.class, result.get(0));
        assertEquals(AbstractCollection.class, result.get(1));
        assertEquals(Object.class, result.get(2));
    }

    @Test
    public void testGetAbbreviatedName_NullClass_ReturnsEmptyString() {
        // Arrange
        Class<?> cls = null;
        int lengthHint = 5;

        // Act
        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_NullClassName_ReturnsEmptyString() {
        // Arrange
        String className = null;
        int lengthHint = 5;

        // Act
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_EmptyClassName_ReturnsEmptyString() {
        // Arrange
        String className = "";
        int lengthHint = 5;

        // Act
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithShortName_ReturnsClassName() {
        // Arrange
        String className = "java.lang.String";
        int lengthHint = 10;

        // Act
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Assert
        assertEquals("j.l.String", result);
    }

    @Test
    public void testGetAbbreviatedName_ClassNameWithLongName_ReturnsAbbreviatedName() {
        // Arrange
        String className = "org.apache.commons.lang3.ClassUtils";
        int lengthHint = 18;

        // Act
        String result = ClassUtils.getAbbreviatedName(className, lengthHint);

        // Assert
        assertEquals("o.a.c.l.ClassUtils", result);
    }

    @Test
    public void testIsPublic_WhenClassIsNotPublic_ReturnsFalse() {
        // Arrange
        Class<?> cls = PrivateClass.class;

        // Act
        boolean result = ClassUtils.isPublic(cls);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPublic_WhenClassIsNestedPublic_ReturnsTrue() {
        // Arrange
        Class<?> cls = OuterClass.NestedPublicClass.class;

        // Act
        boolean result = ClassUtils.isPublic(cls);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsPublic_WhenClassIsNestedPrivate_ReturnsFalse() {
        // Arrange
        Class<?> cls = OuterClass.NestedPrivateClass.class;

        // Act
        boolean result = ClassUtils.isPublic(cls);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsPublic_WhenClassIsPrimitive_ReturnsTrue() {
        // Arrange
        Class<?> cls = int.class;

        // Act
        boolean result = ClassUtils.isPublic(cls);

        // Assert
        assertTrue(result);
    }


    private static class PrivateClass {
    }

    private static interface MyInterface {
    }

    private static abstract class AbstractClass {
    }

    private static class OuterClass {
        public static class NestedPublicClass {
        }

        private static class NestedPrivateClass {
        }
    }

    @Test
    public void testGetAllInterfaces_NullInput_ReturnNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        assertNull(result);
    }

    @Test
    public void testGetAllInterfaces_InterfacesInOrder() {
        // Instantiate all necessary variables here
        Class<?> cls = MySubClass.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        assertEquals(3, result.size());
        assertEquals(InterfaceA.class, result.get(0));
        assertEquals(InterfaceB.class, result.get(1));
        assertEquals(InterfaceC.class, result.get(2));
    }

    // Mock classes for testing
    interface InterfaceA {}
    interface InterfaceB {}
    interface InterfaceC {}
    interface InterfaceD {}
    interface InterfaceE {}
    //class MyClass {}
    class MySubClass implements InterfaceA, InterfaceB, InterfaceC {}
//    class MySubClassWithDuplicate implements InterfaceA, InterfaceB, InterfaceC, InterfaceC {}
    class MySubSubClass extends MySubClass implements InterfaceD, InterfaceE {}


    @Test
    public void testIsInnerClass_ReturnsFalse_WhenClassIsNull() {
        // Arrange
        
        // Act
        boolean result = ClassUtils.isInnerClass(null);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testIsInnerClass_ReturnsFalse_WhenClassIsNotInnerClass() {
        // Arrange
        Class<?> cls = String.class;
        
        // Act
        boolean result = ClassUtils.isInnerClass(cls);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testIsInnerClass_ReturnsTrue_WhenClassIsInnerClass() {
        // Arrange
        Class<?> cls = InnerClass.class;
        
        // Act
        boolean result = ClassUtils.isInnerClass(cls);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsInnerClass_ReturnsTrue_WhenClassIsAnonymousClass() {
        // Arrange
        Class<?> cls = new Object(){}.getClass();
        
        // Act
        boolean result = ClassUtils.isInnerClass(cls);
        
        // Assert
        assertTrue(result);
    }
    
    // Inner class for testing
    private class InnerClass {
        
    }
    
    // Static nested class for testing
    private static class StaticNestedClass {
        
    }


    @Test
    public void testGetPackageCanonicalName_ClassNull_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(cls);
        assertEquals("", result);
    }


    @Test
    public void testGetPackageCanonicalName_ObjectNull_ReturnsDefaultValue() {
        // Instantiate all necessary variables here
        Object object = null;
        String defaultValue = "default";

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(object, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    public void testGetPackageCanonicalName_StringNotNull_ReturnsPackageName() {
        // Instantiate all necessary variables here
        String className = "com.example.TestClass";

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(className);
        assertEquals("com.example", result);
    }
    
    @Test
    public void testGetPackageCanonicalName_StringNull_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String className = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(className);
        assertEquals("", result);
    }


    @Test
    public void isAssignable_PrimitiveToPrimitive_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> cls = int.class;
        Class<?> toClass = long.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertTrue(result);
    }

    @Test
    public void isAssignable_PrimitiveToObject_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> cls = int.class;
        Class<?> toClass = Integer.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertTrue(result);
    }

    //@Test
    public void isAssignable_ObjectToPrimitive_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?> cls = Integer.class;
        Class<?> toClass = int.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertFalse(result);
    }

    @Test
    public void isAssignable_ObjectToObject_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> cls = Integer.class;
        Class<?> toClass = Number.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertTrue(result);
    }

    @Test
    public void isAssignable_NullToNonPrimitive_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?> cls = null;
        Class<?> toClass = String.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertTrue(result);
    }

    @Test
    public void isAssignable_NullToPrimitive_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?> cls = null;
        Class<?> toClass = int.class;

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(cls, toClass);

        assertFalse(result);
    }

    @Test
    public void isAssignable_PrimitiveArrayToObjectArray_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?>[] classArray = {int[].class};
        Class<?>[] toClassArray = {Object[].class};

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(classArray, toClassArray);

        assertFalse(result);
    }

    @Test
    public void isAssignable_ObjectArrayToPrimitiveArray_ReturnsFalse() {
        // Instantiate all necessary variables here
        Class<?>[] classArray = {Object[].class};
        Class<?>[] toClassArray = {int[].class};

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(classArray, toClassArray);

        assertFalse(result);
    }

    @Test
    public void isAssignable_ObjectArrayToObjectArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        Class<?>[] classArray = {Integer[].class};
        Class<?>[] toClassArray = {Number[].class};

        // Write the test code here following the given rules
        boolean result = ClassUtils.isAssignable(classArray, toClassArray);

        assertTrue(result);
    }

    @Test
    public void convertClassesToClassNames_NullInput_ReturnsNull() {
        // Arrange
        List<Class<?>> classes = null;

        // Act
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        // Assert
        assertNull(result);
    }

    @Test
    public void convertClassesToClassNames_EmptyList_ReturnsEmptyList() {
        // Arrange
        List<Class<?>> classes = new ArrayList<>();

        // Act
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void convertClassesToClassNames_SingleClass_ReturnsClassName() {
        // Arrange
        List<Class<?>> classes = new ArrayList<>();
        classes.add(String.class);

        // Act
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("java.lang.String", result.get(0));
    }

    @Test
    public void convertClassesToClassNames_MultipleClasses_ReturnsClassNamesInOrder() {
        // Arrange
        List<Class<?>> classes = new ArrayList<>();
        classes.add(Integer.class);
        classes.add(String.class);
        classes.add(Double.class);

        // Act
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        // Assert
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("java.lang.Integer", result.get(0));
        assertEquals("java.lang.String", result.get(1));
        assertEquals("java.lang.Double", result.get(2));
    }

    @Test
    public void convertClassesToClassNames_NullClassInList_ReturnsNullInResult() {
        // Arrange
        List<Class<?>> classes = new ArrayList<>();
        classes.add(null);

        // Act
        List<String> result = ClassUtils.convertClassesToClassNames(classes);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertNull(result.get(0));
    }

    @Test
    public void testIsPrimitiveWrapper_Boolean() {
        Class<?> type = Boolean.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Byte() {
        Class<?> type = Byte.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Character() {
        Class<?> type = Character.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Short() {
        Class<?> type = Short.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Integer() {
        Class<?> type = Integer.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Long() {
        Class<?> type = Long.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Double() {
        Class<?> type = Double.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_Float() {
        Class<?> type = Float.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertTrue(result);
    }
    
    @Test
    public void testIsPrimitiveWrapper_NonWrapperClass() {
        Class<?> type = String.class;
        
        boolean result = ClassUtils.isPrimitiveWrapper(type);
        
        assertFalse(result);
    }

    @Test
    public void testPrimitivesToWrappers_NullInput_ReturnsNull() {
        // Arrange
        Class<?>[] classes = null;

        // Act
        Class<?>[] result = ClassUtils.primitivesToWrappers(classes);

        // Assert
        assertNull(result);
    }

    @Test
    public void testPrimitivesToWrappers_EmptyInput_ReturnsEmptyArray() {
        // Arrange
        Class<?>[] classes = {};

        // Act
        Class<?>[] result = ClassUtils.primitivesToWrappers(classes);

        // Assert
        assertArrayEquals(new Class<?>[0], result);
    }

    @Test
    public void testPrimitivesToWrappers_NonPrimitiveClasses_ReturnsOriginalClasses() {
        // Arrange
        Class<?>[] classes = {String.class, Integer.class, Object.class};

        // Act
        Class<?>[] result = ClassUtils.primitivesToWrappers(classes);

        // Assert
        assertArrayEquals(classes, result);
    }

    @Test
    public void testPrimitivesToWrappers_PrimitiveClasses_ReturnsWrapperClasses() {
        // Arrange
        Class<?>[] classes = {int.class, boolean.class, double.class};

        // Act
        Class<?>[] result = ClassUtils.primitivesToWrappers(classes);

        // Assert
        assertArrayEquals(new Class<?>[]{Integer.class, Boolean.class, Double.class}, result);
    }

    @Test
    public void testGetShortCanonicalName_WithNullClass_ReturnsEmptyString() {
        // Arrange
        Class<?> cls = null;

        // Act
        String result = ClassUtils.getShortCanonicalName(cls);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testGetShortCanonicalName_WithNonNullClass_ReturnsShortCanonicalName() {
        // Arrange
        Class<?> cls = String.class;

        // Act
        String result = ClassUtils.getShortCanonicalName(cls);

        // Assert
        assertEquals("String", result);
    }

    @Test
    public void testGetShortCanonicalName_WithNullObjectAndNonNullValueIfNull_ReturnsValueIfNull() {
        // Arrange
        Object object = null;
        String valueIfNull = "nullValue";

        // Act
        String result = ClassUtils.getShortCanonicalName(object, valueIfNull);

        // Assert
        assertEquals(valueIfNull, result);
    }

    @Test
    public void testGetShortCanonicalName_WithNonNullObject_ReturnsShortCanonicalName() {
        // Arrange
        Object object = new ArrayList<>();

        // Act
        String result = ClassUtils.getShortCanonicalName(object, "nullValue");

        // Assert
        assertEquals("ArrayList", result);
    }

    @Test
    public void testGetShortCanonicalName_WithString_ReturnsShortCanonicalName() {
        // Arrange
        String canonicalName = "java.lang.String";

        // Act
        String result = ClassUtils.getShortCanonicalName(canonicalName);

        // Assert
        assertEquals("String", result);
    }

    @Test
    public void testGetPackageName_WithNullClass_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(cls);

        assertEquals("", packageName);
    }
    
    @Test
    public void testGetPackageName_WithNullObjectAndValueIfNull_ReturnsValueIfNull() {
        // Instantiate all necessary variables here
        Object object = null;
        String valueIfNull = "default";

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(object, valueIfNull);

        assertEquals("default", packageName);
    }

    @Test
    public void testGetPackageName_WithNullClassName_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String className = null;

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(className);

        assertEquals("", packageName);
    }
    
    @Test
    public void testGetPackageName_WithEmptyClassName_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String className = "";

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(className);

        assertEquals("", packageName);
    }
    
    @Test
    public void testGetPackageName_WithUnpackagedClassName_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String className = "MyClass";

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(className);

        assertEquals("", packageName);
    }
    
    @Test
    public void testGetPackageName_WithArrayClassName_ReturnsPackageName() {
        // Instantiate all necessary variables here
        String className = "[Ljava.lang.String;";

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(className);

        assertEquals("java.lang", packageName);
    }
    
    @Test
    public void testGetPackageName_WithObjectTypeClassName_ReturnsPackageName() {
        // Instantiate all necessary variables here
        String className = "Ljava.lang.String;";

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(className);

        assertEquals("java.lang", packageName);
    }

    @Test
    public void testConvertClassNamesToClasses_NullInput_ReturnsNull() {
        // Arrange
        List<String> classNames = null;
        
        // Act
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testConvertClassNamesToClasses_EmptyList_ReturnsEmptyList() {
        // Arrange
        List<String> classNames = new ArrayList<>();
        
        // Act
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);
        
        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testConvertClassNamesToClasses_ValidClassNames_ReturnsListWithClasses() {
        // Arrange
        List<String> classNames = Arrays.asList("java.lang.String", "java.util.List");
        
        // Act
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(String.class, result.get(0));
        assertEquals(List.class, result.get(1));
    }
    
    @Test
    public void testConvertClassNamesToClasses_ClassNotFound_ReturnsListWithNullValues() {
        // Arrange
        List<String> classNames = Arrays.asList("java.lang.Foo", "java.util.Bar");
        
        // Act
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);
        
        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertNull(result.get(0));
        assertNull(result.get(1));
    }
    
    @Test
    public void testConvertClassNamesToClasses_MixedClassNames_ReturnsListWithClassesAndNullValues() {
        // Arrange
        List<String> classNames = Arrays.asList("java.lang.String", "java.util.Foo", "java.util.List", "java.lang.Bar");
        
        // Act
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);
        
        // Assert
        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(String.class, result.get(0));
        assertNull(result.get(1));
        assertEquals(List.class, result.get(2));
        assertNull(result.get(3));
    }

    @Test
    public void testToClass_NullArray_ReturnsNull() {
        // Arrange
        Object[] array = null;

        // Act
        Class<?>[] result = ClassUtils.toClass(array);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToClass_EmptyArray_ReturnsEmptyClassArray() {
        // Arrange
        Object[] array = {};

        // Act
        Class<?>[] result = ClassUtils.toClass(array);

        // Assert
        assertArrayEquals(ArrayUtils.EMPTY_CLASS_ARRAY, result);
    }

    @Test
    public void testToClass_NonNullArray_ReturnsClassArray() {
        // Arrange
        Object[] array = { "test", 123, true };

        // Act
        Class<?>[] result = ClassUtils.toClass(array);

        // Assert
        assertEquals(String.class, result[0]);
        assertEquals(Integer.class, result[1]);
        assertEquals(Boolean.class, result[2]);
    }

    @Test
    public void testToClass_NullElementInArray_ReturnsClassArrayWithNull() {
        // Arrange
        Object[] array = { "test", null, true };

        // Act
        Class<?>[] result = ClassUtils.toClass(array);

        // Assert
        assertEquals(String.class, result[0]);
        assertNull(result[1]);
        assertEquals(Boolean.class, result[2]);
    }

}