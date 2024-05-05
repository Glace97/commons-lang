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
    
//    @Test
//    public void testGetName_Class_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Class<?> cls = ClassUtilsTest.class;
//        String expected = "ClassUtilsTest";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(cls);
//
//        assertEquals(expected, actual);
//    }
    
//    @Test
//    public void testGetName_ClassWithNullDefault_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Class<?> cls = ClassUtilsTest.class;
//        String valueIfNull = null;
//        String expected = "ClassUtilsTest";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(cls, valueIfNull);
//
//        assertEquals(expected, actual);
//    }
    
//    @Test
//    public void testGetName_ClassWithNonNullDefault_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Class<?> cls = ClassUtilsTest.class;
//        String valueIfNull = "Default";
//        String expected = "ClassUtilsTest";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(cls, valueIfNull);
//
//        assertEquals(expected, actual);
//    }
    
    @Test
    public void testGetName_NullObject_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Object object = null;
        String expected = "";

        // Write the test code here following the given rules
        String actual = ClassUtils.getName(object);
        
        assertEquals(expected, actual);
    }
    
//    @Test
//    public void testGetName_Object_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Object object = new ClassUtils();
//        String expected = "ClassUtils";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(object);
//
//        assertEquals(expected, actual);
//    }
    
//    @Test
//    public void testGetName_ObjectWithNullDefault_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Object object = new ClassUtils();
//        String valueIfNull = null;
//        String expected = "ClassUtils";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(object, valueIfNull);
//
//        assertEquals(expected, actual);
//    }
    
//    @Test
//    public void testGetName_ObjectWithNonNullDefault_ReturnsClassName() {
//        // Instantiate all necessary variables here
//        Object object = new ClassUtils();
//        String valueIfNull = "Default";
//        String expected = "ClassUtils";
//
//        // Write the test code here following the given rules
//        String actual = ClassUtils.getName(object, valueIfNull);
//
//        assertEquals(expected, actual);
//    }

























//    @Test
//    public void testHasNext_WhenNextValueIsNull_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        classUtils.next = new MutableObject<>(null);
//
//        // Write the test code here following the given rules
//        boolean result = classUtils.hasNext();
//
//        assertFalse(result);
//    }
//
//    @Test
//    public void testHasNext_WhenNextValueIsNotNull_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        classUtils.next = new MutableObject<>(new Object());
//
//        // Write the test code here following the given rules
//        boolean result = classUtils.hasNext();
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testHasNext_WhenInterfacesHasNext_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        classUtils.interfaces = mock(Iterator.class);
//        when(classUtils.interfaces.hasNext()).thenReturn(true);
//
//        // Write the test code here following the given rules
//        boolean result = classUtils.hasNext();
//
//        assertTrue(result);
//    }

//    @Test
//    public void testHasNext_WhenInterfacesDoesNotHaveNextAndWrappedHasNext_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        classUtils.interfaces = mock(Iterator.class);
//        when(classUtils.interfaces.hasNext()).thenReturn(false);
//        classUtils.wrapped = mock(Iterator.class);
//        when(classUtils.wrapped.hasNext()).thenReturn(true);
//
//        // Write the test code here following the given rules
//        boolean result = classUtils.hasNext();
//
//        assertTrue(result);
//    }

//    @Test
//    public void testHasNext_WhenInterfacesAndWrappedDoNotHaveNext_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        classUtils.interfaces = mock(Iterator.class);
//        when(classUtils.interfaces.hasNext()).thenReturn(false);
//        classUtils.wrapped = mock(Iterator.class);
//        when(classUtils.wrapped.hasNext()).thenReturn(false);
//
//        // Write the test code here following the given rules
//        boolean result = classUtils.hasNext();
//
//        assertFalse(result);
//    }



















//    @Test
//    public void hierarchy_IncludeInterfaces_ReturnsClassHierarchyWithInterfaces() {
//        // Instantiate all necessary variables here
//        Class<?> type = MyClass.class;
//        ClassUtils.Interfaces interfacesBehavior = ClassUtils.Interfaces.INCLUDE;
//
//        // Create mock classes for the class hierarchy
//        Class<?> superclass = mock(Class.class);
//        Class<?> interface1 = mock(Class.class);
//        Class<?> interface2 = mock(Class.class);
//
//        // Configure the mock classes
//        when(superclass.getSuperclass()).thenReturn(null);
//        when(superclass.getInterfaces()).thenReturn(new Class<?>[] { interface1 });
//        when(interface1.getInterfaces()).thenReturn(new Class<?>[] { interface2 });
//        when(interface2.getInterfaces()).thenReturn(new Class<?>[] {});
//
//        // Create the expected class hierarchy
//        List<Class<?>> expectedHierarchy = Arrays.asList(type, superclass, interface1, interface2);
//
//        // Write the test code here following the given rules
//        Iterable<Class<?>> result = ClassUtils.hierarchy(type, interfacesBehavior);
//
//        // Assert the result
//        List<Class<?>> actualHierarchy = new ArrayList<>();
//        for (Class<?> clazz : result) {
//            actualHierarchy.add(clazz);
//        }
//        assertIterableEquals(expectedHierarchy, actualHierarchy);
//    }

//    @Test
//    public void hierarchy_ExcludeInterfaces_ReturnsClassHierarchyWithoutInterfaces() {
//        // Instantiate all necessary variables here
//        Class<?> type = MyClass.class;
//        ClassUtils.Interfaces interfacesBehavior = ClassUtils.Interfaces.EXCLUDE;
//
//        // Create mock classes for the class hierarchy
//        Class<?> superclass = mock(Class.class);
//
//        // Configure the mock classes
//        when(superclass.getSuperclass()).thenReturn(null);
//
//        // Create the expected class hierarchy
//        List<Class<?>> expectedHierarchy = Arrays.asList(type, superclass);
//
//        // Write the test code here following the given rules
//        Iterable<Class<?>> result = ClassUtils.hierarchy(type, interfacesBehavior);
//
//        // Assert the result
//        List<Class<?>> actualHierarchy = new ArrayList<>();
//        for (Class<?> clazz : result) {
//            actualHierarchy.add(clazz);
//        }
//        assertIterableEquals(expectedHierarchy, actualHierarchy);
//    }
    
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





//    @Test
//    public void testGetPublicMethod() throws NoSuchMethodException {
//        // Instantiate all necessary variables here
//        Class<?> cls = ClassUtils.class;
//        String methodName = "getPublicMethod";
//        Class<?>[] parameterTypes = new Class[]{Class.class, String.class, Class[].class};
//
//        // Mock the dependencies
//        Class<?> mockClass = mock(Class.class);
//
//        // Set up the behavior of the mocked dependencies
//        when(mockClass.getMethod(methodName, parameterTypes)).thenReturn(null);
//        when(mockClass.getDeclaringClass()).thenReturn(Object.class);
//        when(mockClass.getModifiers()).thenReturn(Modifier.PUBLIC);
//
//        // Write the test code here following the given rules
//        Method result = ClassUtils.getPublicMethod(mockClass, methodName, parameterTypes);
//
//        // Verify the method invocation and assertions
//        verify(mockClass).getMethod(methodName, parameterTypes);
//        verify(mockClass).getDeclaringClass();
//        verify(mockClass).getModifiers();
//        assertNull(result);
//    }









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




//    @Test
//    public void testGetComponentType_NullInput_ReturnsNull() {
//        // Instantiate all necessary variables here
//        Class<?> cls = null;
//
//        // Write the test code here following the given rules
//        assertNull(ClassUtils.getComponentType(cls));
//    }
//
//    @Test
//    public void testGetComponentType_NonArrayInput_ReturnsNull() {
//        // Instantiate all necessary variables here
//        Class<?> cls = String.class;
//
//        // Write the test code here following the given rules
//        assertNull(ClassUtils.getComponentType(cls));
//    }

//    @Test
//    public void testGetComponentType_ArrayInput_ReturnsComponentType() {
//        // Instantiate all necessary variables here
//        Class<?> cls = String[].class;
//
//        // Write the test code here following the given rules
//        assertEquals(String.class, ClassUtils.getComponentType(cls));
//    }




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

    //@Test
    public void shouldReturnShortClassNameFromString() {
        // Instantiate all necessary variables here
        String className = "java.util.Map$Entry";

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(className);

        assertEquals("Entry", result);
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

    //@Test
    public void shouldReturnShortClassNameFromInnerClass() {
        // Instantiate all necessary variables here
        String className = "java.util.Map$Entry$Key";

        // Write the test code here following the given rules
        String result = ClassUtils.getShortClassName(className);

        assertEquals("Key", result);
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




// Parsers fault
//    @Test
//    public void testRemove() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//
//        // Write the test code here following the given rules
//        assertThrows(UnsupportedOperationException.class, () -> classUtils.remove());
//    }




    @Test
    public void testGetAllSuperclasses_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllSuperclasses(cls);

        assertNull(result);
    }

    //@Test
    public void testGetAllSuperclasses_NoSuperclass_ReturnsEmptyList() {
        // Instantiate all necessary variables here
        Class<?> cls = String.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllSuperclasses(cls);

        assertEquals(0, result.size());
    }

    //@Test
    public void testGetAllSuperclasses_SingleSuperclass_ReturnsSingleSuperclass() {
        // Instantiate all necessary variables here
        Class<?> cls = Integer.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllSuperclasses(cls);

        assertEquals(1, result.size());
        assertEquals(Number.class, result.get(0));
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

//    @Test
//    public void testGetAbbreviatedName_ClassWithShortName_ReturnsClassName() {
//        // Arrange
//        Class<?> cls = String.class;
//        int lengthHint = 10;
//
//        // Act
//        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);
//
//        // Assert
//        assertEquals("java.lang.String", result);
//    }

//    @Test
//    public void testGetAbbreviatedName_ClassWithLongName_ReturnsAbbreviatedName() {
//        // Arrange
//        Class<?> cls = ClassUtilsTest.class;
//        int lengthHint = 15;
//
//        // Act
//        String result = ClassUtils.getAbbreviatedName(cls, lengthHint);
//
//        // Assert
//        assertEquals("c.g.ClassUtilsTest", result);
//    }

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




//    @Test
//    public void testIsPublic_WhenClassIsPublic_ReturnsTrue() {
//        // Arrange
//        Class<?> cls = MyClass.class;
//
//        // Act
//        boolean result = ClassUtils.isPublic(cls);
//
//        // Assert
//        assertTrue(result);
//    }

    @Test
    public void testIsPublic_WhenClassIsNotPublic_ReturnsFalse() {
        // Arrange
        Class<?> cls = PrivateClass.class;

        // Act
        boolean result = ClassUtils.isPublic(cls);

        // Assert
        assertFalse(result);
    }

//    @Test
//    public void testIsPublic_WhenClassIsInterface_ReturnsTrue() {
//        // Arrange
//        Class<?> cls = MyInterface.class;
//
//        // Act
//        boolean result = ClassUtils.isPublic(cls);
//
//        // Assert
//        assertTrue(result);
//    }

//    @Test
//    public void testIsPublic_WhenClassIsAbstract_ReturnsTrue() {
//        // Arrange
//        Class<?> cls = AbstractClass.class;
//
//        // Act
//        boolean result = ClassUtils.isPublic(cls);
//
//        // Assert
//        assertTrue(result);
//    }

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

//    @Test
//    public void testIsPublic_WhenClassIsNull_ReturnsFalse() {
//        // Arrange
//        Class<?> cls = null;
//
//        // Act
//        boolean result = ClassUtils.isPublic(cls);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    private static class MyClass {
//    }

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

    //@Test
    public void testGetAllInterfaces_NoInterfaces_ReturnEmptyList() {
        // Instantiate all necessary variables here
        Class<?> cls = MyClass.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        assertTrue(result.isEmpty());
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

//    @Test
//    public void testGetAllInterfaces_DuplicateInterfaces_ReturnUniqueList() {
//        // Instantiate all necessary variables here
//        Class<?> cls = MySubClassWithDuplicate.class;
//
//        // Write the test code here following the given rules
//        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);
//
//        assertEquals(3, result.size());
//        assertEquals(InterfaceA.class, result.get(0));
//        assertEquals(InterfaceB.class, result.get(1));
//        assertEquals(InterfaceC.class, result.get(2));
//    }

    //@Test
    public void testGetAllInterfaces_SuperclassInterfacesIncluded() {
        // Instantiate all necessary variables here
        Class<?> cls = MySubSubClass.class;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        assertEquals(5, result.size());
        assertEquals(InterfaceA.class, result.get(0));
        assertEquals(InterfaceB.class, result.get(1));
        assertEquals(InterfaceC.class, result.get(2));
        assertEquals(InterfaceD.class, result.get(3));
        assertEquals(InterfaceE.class, result.get(4));
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
    
    //@Test
    public void testIsInnerClass_ReturnsFalse_WhenClassIsStaticNestedClass() {
        // Arrange
        Class<?> cls = StaticNestedClass.class;

        // Act
        boolean result = ClassUtils.isInnerClass(cls);

        // Assert
        assertFalse(result);
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


//FATAL: CLASSCLOADER?


    //@Test
    public void testGetClass_withClassLoaderAndClassNameAndInitialize() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final ClassLoader classLoader = mock(ClassLoader.class);
        final String className = "java.util.Map.Entry";
        final boolean initialize = true;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(classLoader, className, initialize);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }

    //@Test
    public void testGetClass_withClassLoaderAndClassNameAndNotInitialize() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final ClassLoader classLoader = mock(ClassLoader.class);
        final String className = "java.util.Map.Entry";
        final boolean initialize = false;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(classLoader, className, initialize);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }

    //@Test
    public void testGetClass_withClassLoaderAndInvalidClassName() {
        // Instantiate all necessary variables here
        final ClassLoader classLoader = mock(ClassLoader.class);
        final String className = "invalid.class.Name";
        final boolean initialize = true;

        // Write the test code here following the given rules
        assertThrows(ClassNotFoundException.class, () -> ClassUtils.getClass(classLoader, className, initialize));
    }

    //@Test
    public void testGetClass_withClassLoaderAndClassName() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final ClassLoader classLoader = mock(ClassLoader.class);
        final String className = "java.util.Map.Entry";

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(classLoader, className);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }

    @Test
    public void testGetClass_withInvalidClassName() {
        // Instantiate all necessary variables here
        final String className = "invalid.class.Name";
        final boolean initialize = true;

        // Write the test code here following the given rules
        assertThrows(ClassNotFoundException.class, () -> ClassUtils.getClass(className, initialize));
    }

    //@Test
    public void testGetClass_withClassNameAndInitialize() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final String className = "java.util.Map.Entry";
        final boolean initialize = true;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(className, initialize);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }

    //@Test
    public void testGetClass_withClassNameAndNotInitialize() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final String className = "java.util.Map.Entry";
        final boolean initialize = false;

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(className, initialize);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }

    //@Test
    public void testGetClass_withClassName() throws ClassNotFoundException {
        // Instantiate all necessary variables here
        final String className = "java.util.Map.Entry";

        // Write the test code here following the given rules
        Class<?> result = ClassUtils.getClass(className);

        assertNotNull(result);
        assertEquals(className, result.getName());
    }




    //@Test
    public void testGetPackageCanonicalName_ClassNotNull_ReturnsPackageName() {
        // Instantiate all necessary variables here
        Class<?> cls = mock(Class.class);
        String className = "com.example.TestClass";
        when(cls.getName()).thenReturn(className);

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(cls);
        assertEquals("com.example", result);
    }
    
    @Test
    public void testGetPackageCanonicalName_ClassNull_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String result = ClassUtils.getPackageCanonicalName(cls);
        assertEquals("", result);
    }

//    @Test
//    public void testGetPackageCanonicalName_ObjectNotNull_ReturnsPackageName() {
//        // Instantiate all necessary variables here
//        Object object = mock(Object.class);
//        Class<?> cls = mock(Class.class);
//        String className = "com.example.TestClass";
//        when(object.getClass()).thenReturn(cls);
//        when(cls.getName()).thenReturn(className);
//
//        // Write the test code here following the given rules
//        String result = ClassUtils.getPackageCanonicalName(object, "default");
//        assertEquals("com.example", result);
//    }
    
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



//Parser fault
//    @Test
//    public void testNext() {
//        // Instantiate all necessary variables here
//        ClassUtils classUtils = new ClassUtils();
//        Class<?> result = Object.class;
//        Class<?> superClass = String.class;
//        Iterator<Class<?>> interfaces = mock(Iterator.class);
//        Set<Class<?>> seenInterfaces = mock(Set.class);
//        Iterator<Class<?>> wrapped = mock(Iterator.class);
//
//        // Mocking behavior for next() method
//        when(interfaces.hasNext()).thenReturn(true);
//        when(interfaces.next()).thenReturn(Object.class);
//        when(seenInterfaces.add(any(Class.class))).thenReturn(true);
//        when(wrapped.next()).thenReturn(String.class);
//
//        // Set internal state of classUtils object
//        MutableObject<Class<?>> next = new MutableObject<>(superClass);
//        Set<Class<?>> currentInterfaces = new LinkedHashSet<>();
//        currentInterfaces.add(Object.class);
//        when(seenInterfaces.iterator()).thenReturn(interfaces);
//        when(wrapped.iterator()).thenReturn(mock(Iterator.class));
//        when(wrapped.iterator().hasNext()).thenReturn(false);
//        when(wrapped.iterator().next()).thenReturn(null);
//        classUtils.next = next;
//        classUtils.interfaces = interfaces;
//        classUtils.seenInterfaces = seenInterfaces;
//        classUtils.wrapped = wrapped;
//
//        // Write the test code here following the given rules
//        assertEquals(result, classUtils.next());
//    }




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

//    @Test
//    public void convertClassesToClassNames_ClassCastException_ThrowsException() {
//        // Arrange
//        List<Class<?>> classes = new ArrayList<>();
//        classes.add((Class<?>) "InvalidClass");
//
//        // Act and Assert
//        assertThrows(ClassCastException.class, () -> ClassUtils.convertClassesToClassNames(classes));
//    }




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


    //@Test
    public void testComparator() {
        // Instantiate all necessary variables here
        Comparator<Class<?>> comparator = ClassUtils.comparator();
        Class<?> class1 = mock(Class.class);
        Class<?> class2 = mock(Class.class);

        when(class1.getName()).thenReturn("ClassA");
        when(class2.getName()).thenReturn("ClassB");

        // Write the test code here following the given rules
        int result = comparator.compare(class1, class2);

        assertEquals(-1, result);
    }




    @Test
    public void testGetPackageName_WithNullClass_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Class<?> cls = null;

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(cls);

        assertEquals("", packageName);
    }
    
    //@Test
    public void testGetPackageName_WithClass_ReturnsPackageName() {
        // Instantiate all necessary variables here
        Class<?> cls = ClassUtilsTest.class;

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(cls);

        assertEquals("com.example", packageName);
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
    
   // @Test
    public void testGetPackageName_WithObject_ReturnsPackageName() {
        // Instantiate all necessary variables here
        Object object = new ClassUtilsTest();

        // Write the test code here following the given rules
        String packageName = ClassUtils.getPackageName(object, "default");

        assertEquals("com.example", packageName);
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