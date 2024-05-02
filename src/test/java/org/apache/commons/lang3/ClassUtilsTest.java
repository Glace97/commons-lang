package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.jupiter.api.function.Executable;
import java.lang.reflect.Method;
import java.util.Iterator;
import static org.mockito.Mockito.mock;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import java.util.Comparator;
import java.lang.ClassNotFoundException;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ClassUtilsTest {









    @Test
    public void shouldReturnClassNameWhenClassIsNotNull() {
        Class<?> cls = String.class;

        String result = ClassUtils.getName(cls);

        assertNotNull(result);
        assertEquals("java.lang.String", result);
    }

    @Test
    public void shouldReturnEmptyStringWhenClassIsNull() {
        Class<?> cls = null;

        String result = ClassUtils.getName(cls);

        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    public void shouldReturnClassNameWhenClassAndValueIfNullAreNotNull() {
        Class<?> cls = Integer.class;
        String valueIfNull = "Test";

        String result = ClassUtils.getName(cls, valueIfNull);

        assertNotNull(result);
        assertEquals("java.lang.Integer", result);
    }

    @Test
    public void shouldReturnValueIfNullWhenClassIsNull() {
        Class<?> cls = null;
        String valueIfNull = "Test";

        String result = ClassUtils.getName(cls, valueIfNull);

        assertNotNull(result);
        assertEquals("Test", result);
    }

    @Test
    public void shouldReturnClassNameWhenObjectIsNotNull() {
        Object obj = new String();

        String result = ClassUtils.getName(obj);

        assertNotNull(result);
        assertEquals("java.lang.String", result);
    }

    @Test
    public void shouldReturnEmptyStringWhenObjectIsNull() {
        Object obj = null;

        String result = ClassUtils.getName(obj);

        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    public void shouldReturnClassNameWhenObjectAndValueIfNullAreNotNull() {
        Object obj = new Integer(1);
        String valueIfNull = "Test";

        String result = ClassUtils.getName(obj, valueIfNull);

        assertNotNull(result);
        assertEquals("java.lang.Integer", result);
    }

    @Test
    public void shouldReturnValueIfNullWhenObjectIsNull() {
        Object obj = null;
        String valueIfNull = "Test";

        String result = ClassUtils.getName(obj, valueIfNull);

        assertNotNull(result);
        assertEquals("Test", result);
    }





    @Test
    public void getPackageName_withNullClass() {
        // Test case: when cls is null, getPackageName should return an empty string
        String packageName = ClassUtils.getPackageName((Class<?>) null);
        assertEquals("", packageName);
    }

    @Test
    public void getPackageName_withNonNullClass() {
        // Test case: when cls is not null, getPackageName should return the package name
        String packageName = ClassUtils.getPackageName(String.class);
        assertEquals("java.lang", packageName);
    }

    @Test
    public void getPackageName_withNullObject() {
        // Test case: when object is null, getPackageName should return the valueIfNull
        String packageName = ClassUtils.getPackageName(null, "default");
        assertEquals("default", packageName);
    }

    @Test
    public void getPackageName_withNonNullObject() {
        // Test case: when object is not null, getPackageName should return the package name
        String packageName = ClassUtils.getPackageName("test", "default");
        assertEquals("java.lang", packageName);
    }

    @Test
    public void getPackageName_withNullClassName() {
        // Test case: when className is null, getPackageName should return an empty string
        String packageName = ClassUtils.getPackageName((String) null);
        assertEquals("", packageName);
    }

    @Test
    public void getPackageName_withEmptyClassName() {
        // Test case: when className is an empty string, getPackageName should return an empty string
        String packageName = ClassUtils.getPackageName("");
        assertEquals("", packageName);
    }

    @Test
    public void getPackageName_withClassNameNoPackage() {
        // Test case: when className has no package (e.g. "String"), getPackageName should return an empty string
        String packageName = ClassUtils.getPackageName("String");
        assertEquals("", packageName);
    }

    @Test
    public void getPackageName_withClassNameHasPackage() {
        // Test case: when className has a package (e.g. "java.lang.String"), getPackageName should return the package name
        String packageName = ClassUtils.getPackageName("java.lang.String");
        assertEquals("java.lang", packageName);
    }









    @Test
    public void testPrimitivesToWrappers() {
        Class<?>[] classes = {int.class, boolean.class, char.class, byte.class, short.class, long.class, float.class, double.class};
        Class<?>[] expected = {Integer.class, Boolean.class, Character.class, Byte.class, Short.class, Long.class, Float.class, Double.class};
        assertArrayEquals(expected, ClassUtils.primitivesToWrappers(classes));
    }

    @Test
    public void testPrimitivesToWrappersWithNonPrimitive() {
        Class<?>[] classes = {String.class};
        Class<?>[] expected = {String.class};
        assertArrayEquals(expected, ClassUtils.primitivesToWrappers(classes));
    }

    @Test
    public void testPrimitivesToWrappersWithNull() {
        assertNull(ClassUtils.primitivesToWrappers(null));
    }

    @Test
    public void testPrimitivesToWrappersWithEmpty() {
        Class<?>[] classes = {};
        assertArrayEquals(classes, ClassUtils.primitivesToWrappers(classes));
    }

    @Test
    public void testPrimitivesToWrappersWithVoid() {
        Class<?>[] classes = {void.class};
        Class<?>[] expected = {Void.class};
        assertArrayEquals(expected, ClassUtils.primitivesToWrappers(classes));
    }





    @Test
    public void whenTypeIsNull_shouldReturnFalse() {
        assertFalse(ClassUtils.isPrimitiveWrapper(null));
    }

    @Test
    public void whenTypeIsPrimitive_shouldReturnFalse() {
        assertFalse(ClassUtils.isPrimitiveWrapper(int.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(boolean.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(char.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(byte.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(short.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(long.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(float.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(double.class));
    }

    @Test
    public void whenTypeIsWrapper_shouldReturnTrue() {
        assertTrue(ClassUtils.isPrimitiveWrapper(Integer.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Boolean.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Character.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Byte.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Short.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Long.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Float.class));
        assertTrue(ClassUtils.isPrimitiveWrapper(Double.class));
    }

    @Test
    public void whenTypeIsNotPrimitiveOrWrapper_shouldReturnFalse() {
        assertFalse(ClassUtils.isPrimitiveWrapper(String.class));
        assertFalse(ClassUtils.isPrimitiveWrapper(Object.class));
    }





    @Test
    public void convertClassesToClassNames_withNullList() {
        // Test for null input
        assertNull(ClassUtils.convertClassesToClassNames(null));
    }

    @Test
    public void convertClassesToClassNames_withEmptyList() {
        // Test for empty list
        List<Class<?>> classes = Collections.emptyList();
        List<String> classNames = ClassUtils.convertClassesToClassNames(classes);
        assertTrue(classNames.isEmpty());
    }

    @Test
    public void convertClassesToClassNames_withValidClasses() {
        // Test for valid classes
        List<Class<?>> classes = Arrays.asList(String.class, Integer.class, Double.class);
        List<String> classNames = ClassUtils.convertClassesToClassNames(classes);
        assertEquals(3, classNames.size());
        assertTrue(classNames.contains("java.lang.String"));
        assertTrue(classNames.contains("java.lang.Integer"));
        assertTrue(classNames.contains("java.lang.Double"));
    }

    @Test
    public void convertClassesToClassNames_withNullElementInList() {
        // Test for list containing null
        List<Class<?>> classes = Arrays.asList(String.class, null, Double.class);
        List<String> classNames = ClassUtils.convertClassesToClassNames(classes);
        assertEquals(3, classNames.size());
        assertTrue(classNames.contains("java.lang.String"));
        assertNull(classNames.get(1)); // Second element should be null
        assertTrue(classNames.contains("java.lang.Double"));
    }









    @Test
    public void testGetPackageCanonicalNameWithNullClass() {
        String result = ClassUtils.getPackageCanonicalName((Class<?>) null);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNonNullClass() {
        String result = ClassUtils.getPackageCanonicalName(String.class);
        assertEquals("java.lang", result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNullObjectAndNonNullValue() {
        String result = ClassUtils.getPackageCanonicalName(null, "default");
        assertEquals("default", result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNonNullObjectAndNonNullValue() {
        String result = ClassUtils.getPackageCanonicalName(new String(), "default");
        assertEquals("java.lang", result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNullName() {
        String result = ClassUtils.getPackageCanonicalName((String) null);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNonNullName() {
        String result = ClassUtils.getPackageCanonicalName("java.lang.String");
        assertEquals("java.lang", result);
    }

    @Test
    public void testGetPackageCanonicalNameWithNonCanonicalName() {
        String result = ClassUtils.getPackageCanonicalName("java$util$List");
        assertEquals("", result);
    }





    @Test
    public void getClass_whenClassNameIsNull_thenThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ClassUtils.getClass(null));
    }

    @Test
    public void getClass_whenClassDoesNotExist_thenThrowsClassNotFoundException() {
        assertThrows(ClassNotFoundException.class, () -> ClassUtils.getClass("Non.Existing.Class"));
    }

    @Test
    public void getClass_whenClassExists_thenReturnsClass() throws ClassNotFoundException {
        Class<?> clazz = ClassUtils.getClass("java.lang.String");
        assertNotNull(clazz);
        assertEquals("java.lang.String", clazz.getName());
    }

    @Test
    public void getClass_whenCalledWithClassLoaderAndClassName_thenReturnsClass() throws ClassNotFoundException {
        ClassLoader classLoader = mock(ClassLoader.class);
        when(classLoader.loadClass(anyString())).thenReturn(String.class);
        Class<?> clazz = ClassUtils.getClass(classLoader, "java.lang.String");
        assertNotNull(clazz);
        assertEquals("java.lang.String", clazz.getName());
    }

    @Test
    public void getClass_whenCalledWithClassLoaderAndClassNameAndInitializeFlag_thenReturnsClass() throws ClassNotFoundException {
        ClassLoader classLoader = mock(ClassLoader.class);
        when(classLoader.loadClass(anyString())).thenReturn(String.class);
        Class<?> clazz = ClassUtils.getClass(classLoader, "java.lang.String", true);
        assertNotNull(clazz);
        assertEquals("java.lang.String", clazz.getName());
    }





    @Test
    public void hasNext_True_Test() {
        // Instantiate all necessary variables here
        Iterator iterator = mock(Iterator.class);

        when(iterator.hasNext()).thenReturn(true);

        ClassUtils classUtils = new ClassUtils(iterator);

        // Assert
        assertTrue(classUtils.hasNext());
    }

    @Test
    public void hasNext_False_Test() {
        // Instantiate all necessary variables here
        Iterator iterator = mock(Iterator.class);

        when(iterator.hasNext()).thenReturn(false);

        ClassUtils classUtils = new ClassUtils(iterator);

        // Assert
        assertFalse(classUtils.hasNext());
    }





    @Test
    public void testIsInnerClass_NullClass() {
        // Test case: The input class is null
        assertFalse(ClassUtils.isInnerClass(null));
    }

    @Test
    public void testIsInnerClass_InnerClass() {
        // Test case: The input class is an inner class
        Class<?> innerClass = InnerClass.class;
        assertTrue(ClassUtils.isInnerClass(innerClass));
    }

    @Test
    public void testIsInnerClass_NonInnerClass() {
        // Test case: The input class is not an inner class
        Class<?> nonInnerClass = NonInnerClass.class;
        assertFalse(ClassUtils.isInnerClass(nonInnerClass));
    }

    @Test
    public void testIsInnerClass_MockInnerClass() {
        // Test case: The input class is a mock inner class
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getEnclosingClass()).thenReturn(NonInnerClass.class);
        assertTrue(ClassUtils.isInnerClass(mockClass));
    }

    @Test
    public void testIsInnerClass_MockNonInnerClass() {
        // Test case: The input class is a mock non-inner class
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getEnclosingClass()).thenReturn(null);
        assertFalse(ClassUtils.isInnerClass(mockClass));
    }

    // Inner class for testing
    class InnerClass {
    }

    // Non-inner class for testing
    public class NonInnerClass {
    }













    @Test
    public void testRemoveMethod() {
        // Instantiate ClassUtils
        ClassUtils classUtils = new ClassUtils();

        // Expect UnsupportedOperationException when remove method is called
        assertThrows(UnsupportedOperationException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                classUtils.remove();
            }
        });
    }

    @Test
    public void testRemoveMethodWithMockito() {
        // Create a spy of ClassUtils
        ClassUtils classUtils = spy(new ClassUtils());

        // When remove method is called, throw UnsupportedOperationException
        doThrow(new UnsupportedOperationException()).when(classUtils).remove();

        // Assert that UnsupportedOperationException is thrown
        assertThrows(UnsupportedOperationException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                classUtils.remove();
            }
        });
    }







    @Mock
    private Class<?> mockClass;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHierarchyWithExcludeInterfaces() {
        // Given
        when(mockClass.getSuperclass()).thenReturn(null);

        // When
        Iterable<Class<?>> output = ClassUtils.hierarchy(mockClass, ClassUtils.Interfaces.EXCLUDE);

        // Then
        assert output != null;
        Iterator<Class<?>> iterator = output.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(mockClass, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHierarchyWithIncludeInterfaces() {
        // Given
        when(mockClass.getInterfaces()).thenReturn(new Class<?>[0]);
        when(mockClass.getSuperclass()).thenReturn(null);

        // When
        Iterable<Class<?>> output = ClassUtils.hierarchy(mockClass, ClassUtils.Interfaces.INCLUDE);

        // Then
        assert output != null;
        Iterator<Class<?>> iterator = output.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(mockClass, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHierarchyWithSuperClassAndExcludeInterfaces() {
        // Given
        when(mockClass.getSuperclass()).thenReturn(Object.class);

        // When
        Iterable<Class<?>> output = ClassUtils.hierarchy(mockClass, ClassUtils.Interfaces.EXCLUDE);

        // Then
        assert output != null;
        Iterator<Class<?>> iterator = output.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(mockClass, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Object.class, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHierarchyWithSuperClassAndIncludeInterfaces() {
        // Given
        when(mockClass.getInterfaces()).thenReturn(new Class<?>[0]);
        when(mockClass.getSuperclass()).thenReturn(Object.class);

        // When
        Iterable<Class<?>> output = ClassUtils.hierarchy(mockClass, ClassUtils.Interfaces.INCLUDE);

        // Then
        assert output != null;
        Iterator<Class<?>> iterator = output.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(mockClass, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Object.class, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHierarchyWithInterfaceAndIncludeInterfaces() {
        // Given
        Class<?> mockInterface = mock(Class.class);
        when(mockClass.getInterfaces()).thenReturn(new Class<?>[]{mockInterface});
        when(mockClass.getSuperclass()).thenReturn(null);
        when(mockInterface.getInterfaces()).thenReturn(new Class<?>[0]);

        // When
        Iterable<Class<?>> output = ClassUtils.hierarchy(mockClass, ClassUtils.Interfaces.INCLUDE);

        // Then
        assert output != null;
        Iterator<Class<?>> iterator = output.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(mockClass, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(mockInterface, iterator.next());
        assertFalse(iterator.hasNext());
    }






    @Test
    public void whenTypeIsNull_thenReturnsFalse() {
        Class<?> type = null;
        assertFalse(ClassUtils.isPrimitiveOrWrapper(type));
    }

    @Test
    public void whenTypeIsPrimitive_thenReturnsTrue() {
        Class<?> type = int.class;
        assertTrue(ClassUtils.isPrimitiveOrWrapper(type));
    }

    @Test
    public void whenTypeIsWrapper_thenReturnsTrue() {
        Class<?> type = Integer.class;
        assertTrue(ClassUtils.isPrimitiveOrWrapper(type));
    }

    @Test
    public void whenTypeIsNotPrimitiveOrWrapper_thenReturnsFalse() {
        Class<?> type = String.class;
        assertFalse(ClassUtils.isPrimitiveOrWrapper(type));
    }





    @Test
    public void testWalkInterfaces() throws NoSuchFieldException, IllegalAccessException {
        // Instantiate necessary variables
        ClassUtils classUtils = new ClassUtils();
        Set<Class<?>> addTo = new HashSet<>();
        Class<?> classToTest = Mockito.mock(Class.class);
        Class<?> interface1 = Mockito.mock(Class.class);
        Class<?> interface2 = Mockito.mock(Class.class);
        Class<?>[] interfaces = {interface1, interface2};

        // Mocking the getInterfaces method of the Class object
        when(classToTest.getInterfaces()).thenReturn(interfaces);

        // Access the private field seenInterfaces
        Field seenInterfacesField = ClassUtils.class.getDeclaredField("seenInterfaces");
        seenInterfacesField.setAccessible(true);
        Set<Class<?>> seenInterfaces = (Set<Class<?>>) seenInterfacesField.get(classUtils);

        // Add the first interface to the seenInterfaces set
        seenInterfaces.add(interface1);

        // Write the test code
        classUtils.walkInterfaces(addTo, classToTest);

        // Check if the second interface was added to the addTo set
        assertEquals(1, addTo.size());
        assertTrue(addTo.contains(interface2));

        // Check if the first interface was not added to the addTo set
        assertFalse(addTo.contains(interface1));
    }







    @Test
    public void testGetCanonicalName() {
        Class<?> cls = String.class;
        assertEquals("java.lang.String", ClassUtils.getCanonicalName(cls));

        cls = int.class;
        assertEquals("int", ClassUtils.getCanonicalName(cls));

        cls = null;
        assertEquals("", ClassUtils.getCanonicalName(cls));
    }

    @Test
    public void testGetCanonicalNameWithDefaultValue() {
        Class<?> cls = String.class;
        assertEquals("java.lang.String", ClassUtils.getCanonicalName(cls, "Default"));

        cls = int.class;
        assertEquals("int", ClassUtils.getCanonicalName(cls, "Default"));

        cls = null;
        assertEquals("Default", ClassUtils.getCanonicalName(cls, "Default"));
    }

    @Test
    public void testGetCanonicalNameForObject() {
        Object object = "String object";
        assertEquals("java.lang.String", ClassUtils.getCanonicalName(object));

        object = 1;  // Integer object
        assertEquals("java.lang.Integer", ClassUtils.getCanonicalName(object));

        object = null;
        assertEquals("", ClassUtils.getCanonicalName(object));
    }

    @Test
    public void testGetCanonicalNameForObjectWithDefaultValue() {
        Object object = "String object";
        assertEquals("java.lang.String", ClassUtils.getCanonicalName(object, "Default"));

        object = 1;  // Integer object
        assertEquals("java.lang.Integer", ClassUtils.getCanonicalName(object, "Default"));

        object = null;
        assertEquals("Default", ClassUtils.getCanonicalName(object, "Default"));
    }







    @Test
    public void testWrappersToPrimitives_NullInput() {
        assertNull(ClassUtils.wrappersToPrimitives(null));
    }

    @Test
    public void testWrappersToPrimitives_EmptyInput() {
        Class<?>[] classes = new Class[0];
        assertArrayEquals(classes, ClassUtils.wrappersToPrimitives(classes));
    }

    @Test
    public void testWrappersToPrimitives_WithPrimitiveWrapper() {
        Class<?>[] classes = new Class[]{Integer.class, Double.class, Boolean.class};
        Class<?>[] expected = new Class[]{int.class, double.class, boolean.class};
        assertArrayEquals(expected, ClassUtils.wrappersToPrimitives(classes));
    }

    @Test
    public void testWrappersToPrimitives_WithoutPrimitiveWrapper() {
        Class<?>[] classes = new Class[]{String.class, Object.class};
        Class<?>[] expected = new Class[]{null, null};
        assertArrayEquals(expected, ClassUtils.wrappersToPrimitives(classes));
    }

    @Test
    public void testWrappersToPrimitives_WithAndWithoutPrimitiveWrapper() {
        Class<?>[] classes = new Class[]{Integer.class, String.class, Double.class, Object.class};
        Class<?>[] expected = new Class[]{int.class, null, double.class, null};
        assertArrayEquals(expected, ClassUtils.wrappersToPrimitives(classes));
    }




    @Test
    public void getComponentType_whenClassIsNull() {
        Class<Integer[]> cls = null;
        Class<Integer> result = ClassUtils.getComponentType(cls);
        assertNull(result, "Result should be null when the input class is null");
    }

    @Test
    public void getComponentType_whenClassIsNotArray() {
        Class<String> cls = String.class;
        Class<String> result = ClassUtils.getComponentType(cls);
        assertNull(result, "Result should be null when the input class is not an array");
    }

    @Test
    public void getComponentType_whenClassIsArray() {
        Class<Integer[]> cls = Integer[].class;
        Class<Integer> result = ClassUtils.getComponentType(cls);
        assertEquals(Integer.class, result, "Result should match the component type of the input array class");
    }

    @Test
    public void getComponentType_whenClassIsMultiDimensionalArray() {
        Class<ArrayList[][][]> cls = ArrayList[][][].class;
        Class<ArrayList[][]> result = ClassUtils.getComponentType(cls);
        assertEquals(ArrayList[][].class, result, "Result should match the component type of the input multi-dimensional array class");
    }





    @Test
    public void testGetPublicMethodSuccess() {
        try {
            Method m = ClassUtils.getPublicMethod(ClassUtils.class, "getPublicMethod", Class.class, String.class, Class[].class);
            assertNotNull(m);
            assertEquals("getPublicMethod", m.getName());
        } catch (NoSuchMethodException e) {
            fail("Method should exist");
        }
    }

    @Test
    public void testGetPublicMethodFailure() {
        assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(ClassUtils.class, "nonExistentMethod", Class.class, String.class, Class[].class);
        });
    }

    @Test
    public void testGetPublicMethodWithPrivateClass() {
        class PrivateClass {
            public void publicMethod() {}
        }

        assertThrows(NoSuchMethodException.class, () -> {
            ClassUtils.getPublicMethod(PrivateClass.class, "publicMethod");
        });
    }

    @Test
    public void testGetPublicMethodNullClass() {
        assertThrows(NullPointerException.class, () -> {
            ClassUtils.getPublicMethod(null, "whatever");
        });
    }

    @Test
    public void testGetPublicMethodNullMethodName() {
        assertThrows(NullPointerException.class, () -> {
            ClassUtils.getPublicMethod(ClassUtils.class, null);
        });
    }

    @Test
    public void testGetPublicMethodNullParameters() {
        assertThrows(NullPointerException.class, () -> {
            ClassUtils.getPublicMethod(ClassUtils.class, "getPublicMethod", (Class<?>[]) null);
        });
    }






    @Test
    public void testGetShortClassNameWithClass() {
        // Test with non-null Class
        String className = ClassUtils.getShortClassName(String.class);
        assertEquals("String", className);

        // Test with null Class
        className = ClassUtils.getShortClassName(null);
        assertEquals("", className);

        // Test with inner Class
        className = ClassUtils.getShortClassName(Map.Entry.class);
        assertEquals("Map.Entry", className);
    }

    @Test
    public void testGetShortClassNameWithObject() {
        // Test with non-null object
        String className = ClassUtils.getShortClassName(new String(), "default");
        assertEquals("String", className);

        // Test with null object
        className = ClassUtils.getShortClassName(null, "default");
        assertEquals("default", className);

        // Test with inner object
        className = ClassUtils.getShortClassName(new HashMap.SimpleEntry<>("key", "value"), "default");
        assertEquals("SimpleEntry", className);
    }

    @Test
    public void testGetShortClassNameWithString() {
        // Test with non-null className
        String className = ClassUtils.getShortClassName("java.lang.String");
        assertEquals("String", className);

        // Test with null className
        className = ClassUtils.getShortClassName(null);
        assertEquals("", className);

        // Test with empty className
        className = ClassUtils.getShortClassName("");
        assertEquals("", className);

        // Test with className of inner class
        className = ClassUtils.getShortClassName("java.util.Map$Entry");
        assertEquals("Map.Entry", className);
    }





    @Test
    public void testGetSimpleNameWithClassNotNull() {
        // Instantiate necessary variables
        Class<?> cls = String.class;

        // Call the method to test
        String result = ClassUtils.getSimpleName(cls);

        // Assert the result
        assertEquals("String", result);
    }

    @Test
    public void testGetSimpleNameWithClassNull() {
        // Instantiate necessary variables
        Class<?> cls = null;

        // Call the method to test
        String result = ClassUtils.getSimpleName(cls);

        // Assert the result
        assertNull(result);
    }

    @Test
    public void testGetSimpleNameWithObjectNotNull() {
        // Instantiate necessary variables
        Object obj = new String();

        // Call the method to test
        String result = ClassUtils.getSimpleName(obj);

        // Assert the result
        assertEquals("String", result);
    }

    @Test
    public void testGetSimpleNameWithObjectNull() {
        // Instantiate necessary variables
        Object obj = null;

        // Call the method to test
        String result = ClassUtils.getSimpleName(obj);

        // Assert the result
        assertNull(result);
    }

    @Test
    public void testGetSimpleNameWithClassAndValueIfNullNotNull() {
        // Instantiate necessary variables
        Class<?> cls = null;
        String valueIfNull = "default";

        // Call the method to test
        String result = ClassUtils.getSimpleName(cls, valueIfNull);

        // Assert the result
        assertEquals("default", result);
    }

    @Test
    public void testGetSimpleNameWithObjectAndValueIfNullNotNull() {
        // Instantiate necessary variables
        Object obj = null;
        String valueIfNull = "default";

        // Call the method to test
        String result = ClassUtils.getSimpleName(obj, valueIfNull);

        // Assert the result
        assertEquals("default", result);
    }





    @Test
    public void testGetAllSuperclasses() {
        // Instantiate necessary variables
        Class<?> cls = String.class;

        // Call the method to test
        List<Class<?>> superclasses = ClassUtils.getAllSuperclasses(cls);

        // Check the result
        assertNotNull(superclasses);
        assertEquals(2, superclasses.size());
        assertTrue(superclasses.contains(Object.class));
    }

    @Test
    public void testGetAllSuperclassesWithNoSuperclass() {
        // Instantiate necessary variables
        Class<?> cls = Object.class;

        // Call the method to test
        List<Class<?>> superclasses = ClassUtils.getAllSuperclasses(cls);

        // Check the result
        assertNotNull(superclasses);
        assertTrue(superclasses.isEmpty());
    }

    @Test
    public void testGetAllSuperclassesWithNull() {
        // Call the method to test with null
        List<Class<?>> superclasses = ClassUtils.getAllSuperclasses(null);

        // Check the result
        assertNull(superclasses);
    }



    @Test
    public void testGetAbbreviatedNameNullClass() {
        assertNull(ClassUtils.getAbbreviatedName((Class<?>) null, 1));
    }

    @Test
    public void testGetAbbreviatedNameNegativeLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", -1);
        });

        String expectedMessage = "len must be > 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetAbbreviatedNameLengthZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 0);
        });

        String expectedMessage = "len must be > 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testGetAbbreviatedNameLengthShorterThanClassName() {
        assertEquals("o.a.c.l.ClassUtils", ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 18));
    }

    @Test
    public void testGetAbbreviatedNameLengthLongerThanClassName() {
        assertEquals("org.apache.commons.lang3.ClassUtils", ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", 30));
    }

    @Test
    public void testGetAbbreviatedNameLengthEqualToClassName() {
        assertEquals("org.apache.commons.lang3.ClassUtils", ClassUtils.getAbbreviatedName("org.apache.commons.lang3.ClassUtils", "org.apache.commons.lang3.ClassUtils".length()));
    }




    @Test
    public void testIsPublic_ClassIsPublic() {
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getModifiers()).thenReturn(Modifier.PUBLIC);
        assertTrue(ClassUtils.isPublic(mockClass));
    }

    @Test
    public void testIsPublic_ClassIsPrivate() {
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getModifiers()).thenReturn(Modifier.PRIVATE);
        assertFalse(ClassUtils.isPublic(mockClass));
    }

    @Test
    public void testIsPublic_ClassIsProtected() {
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getModifiers()).thenReturn(Modifier.PROTECTED);
        assertFalse(ClassUtils.isPublic(mockClass));
    }

    @Test
    public void testIsPublic_ClassIsNotPublic() {
        Class<?> mockClass = mock(Class.class);
        when(mockClass.getModifiers()).thenReturn(0);
        assertFalse(ClassUtils.isPublic(mockClass));
    }

    @Test
    public void testIsPublic_ClassIsNull() {
        assertThrows(NullPointerException.class, () -> {
            ClassUtils.isPublic(null);
        });
    }




    @Test
    public void testGetAllInterfaces_WithNullClass() {
        // Given
        Class<?> cls = null;

        // When
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        // Then
        assertNull(result, "Should return null for null class");
    }

    @Test
    public void testGetAllInterfaces_WithNoInterfaces() {
        // Given
        Class<?> cls = ArrayList.class; // ArrayList doesn't implement any interfaces directly

        // When
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        // Then
        assertEquals(0, result.size(), "Should return empty list for class with no interfaces");
    }

    @Test
    public void testGetAllInterfaces_WithInterfaces() {
        // Given
        Class<?> cls = List.class; // List interface extends Collection

        // When
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        // Then
        assertEquals(1, result.size(), "Should return list with one interface for class with one interface");
        assertEquals(Collection.class, result.get(0), "Should return correct interface for class with one interface");
    }

    @Test
    public void testGetAllInterfaces_WithInheritedInterfaces() {
        // Given
        Class<?> cls = HashSet.class; // HashSet implements Set which extends Collection

        // When
        List<Class<?>> result = ClassUtils.getAllInterfaces(cls);

        // Then
        assertEquals(2, result.size(), "Should return list with two interfaces for class with inherited interfaces");
        assertTrue(result.contains(Set.class), "Should return correct interfaces for class with inherited interfaces");
        assertTrue(result.contains(Collection.class), "Should return correct interfaces for class with inherited interfaces");
    }








    @Test
    public void testIsAssignable() {
        // test with nulls, should return false
        assertFalse(ClassUtils.isAssignable((Class<?>) null, (Class<?>) null));

        // test with identical classes, should return true
        assertTrue(ClassUtils.isAssignable(String.class, String.class));

        // test with subclasses, should return true
        assertTrue(ClassUtils.isAssignable(String.class, Object.class));
        assertFalse(ClassUtils.isAssignable(Object.class, String.class));

        // test with interfaces, should return true
        assertTrue(ClassUtils.isAssignable(String.class, CharSequence.class));
        assertFalse(ClassUtils.isAssignable(CharSequence.class, String.class));

        // test with primitive types, should return true
        assertTrue(ClassUtils.isAssignable(int.class, Integer.class));
        assertFalse(ClassUtils.isAssignable(Integer.class, int.class));

        // test with primitive types and autoboxing, should return true
        assertTrue(ClassUtils.isAssignable(int.class, Integer.class, true));
        assertTrue(ClassUtils.isAssignable(Integer.class, int.class, true));

        // test with primitive types without autoboxing, should return false
        assertFalse(ClassUtils.isAssignable(int.class, Integer.class, false));
        assertFalse(ClassUtils.isAssignable(Integer.class, int.class, false));

        // test with arrays, should return true
        assertTrue(ClassUtils.isAssignable(new Class[]{String.class, Integer.class}, new Class[]{String.class, Integer.class}));

        // test with arrays of different lengths, should return false
        assertFalse(ClassUtils.isAssignable(new Class[]{String.class}, new Class[]{String.class, Integer.class}));

        // test with arrays and autoboxing, should return true
        assertTrue(ClassUtils.isAssignable(new Class[]{int.class, Integer.class}, new Class[]{Integer.class, int.class}, true));

        // test with arrays and without autoboxing, should return false
        assertFalse(ClassUtils.isAssignable(new Class[]{int.class, Integer.class}, new Class[]{Integer.class, int.class}, false));
    }




    @Test
    public void testNext1() {
        ClassUtils classUtils = new ClassUtils();
        Method method;

        try {
            method = ClassUtils.class.getDeclaredMethod("next");
            method.setAccessible(true);

            assertNotNull(method.invoke(classUtils));

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNext2() {
        ClassUtils classUtils = new ClassUtils();
        Method method;

        try {
            method = ClassUtils.class.getDeclaredMethod("next");
            method.setAccessible(true);

            assertThrows(Exception.class, () -> method.invoke(classUtils));

        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }







    @Test
    public void testGetShortCanonicalName_whenClassIsNull() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName((Class<?>) null);
        assertEquals("", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenClassIsPrimitive() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName(int.class);
        assertEquals("int", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenClassIsArray() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName(int[].class);
        assertEquals("int[]", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenClassIsRegular() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName(ClassUtilsTest.class);
        assertEquals("ClassUtilsTest", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenCanonicalNameIsNull() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName((String) null);
        assertEquals("", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenCanonicalNameIsArray() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName("int[]");
        assertEquals("int[]", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalName_whenCanonicalNameIsRegular() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName("org.apache.commons.lang3.ClassUtilsTest");
        assertEquals("ClassUtilsTest", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalNameForObject_whenObjectIsNull() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName(null, "null");
        assertEquals("null", shortCanonicalName);
    }

    @Test
    public void testGetShortCanonicalNameForObject_whenObjectIsNotNull() {
        String shortCanonicalName = ClassUtils.getShortCanonicalName(new ClassUtilsTest(), "null");
        assertEquals("ClassUtilsTest", shortCanonicalName);
    }




    @Test
    public void comparator_shouldReturnComparator() {
        Class<String> class1 = String.class;
        Class<String> class2 = String.class;
        Comparator<Class<?>> comparator = ClassUtils.comparator();

        assertNotNull(comparator, "Comparator should not be null");
        assertEquals(0, comparator.compare(class1, class2), "Comparator should return 0 when comparing two same classes");

        Class<String> class3 = String.class;
        Class<Integer> class4 = Integer.class;
        assertTrue(comparator.compare(class3, class4) > 0, "Comparator should return positive when comparing class of String and class of Integer");
        assertTrue(comparator.compare(class4, class3) < 0, "Comparator should return negative when comparing class of Integer and class of String");
    }

    @Test
    public void comparator_shouldHandleNullArguments() {
        Comparator<Class<?>> comparator = ClassUtils.comparator();

        assertThrows(NullPointerException.class, () -> comparator.compare(null, String.class), "Comparator should throw NullPointerException when first argument is null");
        assertThrows(NullPointerException.class, () -> comparator.compare(String.class, null), "Comparator should throw NullPointerException when second argument is null");
        assertThrows(NullPointerException.class, () -> comparator.compare(null, null), "Comparator should throw NullPointerException when both arguments are null");
    }

    @Test
    public void comparator_shouldHandleNamelessClasses() {
        Comparator<Class<?>> comparator = ClassUtils.comparator();

        Class<?> anonymousClass = new Object() { }.getClass();
        Class<String> namedClass = String.class;
        assertDoesNotThrow(() -> comparator.compare(anonymousClass, namedClass), "Comparator should not throw exception when comparing anonymous class with named class");
        assertDoesNotThrow(() -> comparator.compare(namedClass, anonymousClass), "Comparator should not throw exception when comparing named class with anonymous class");
    }






    @Test
    public void testConvertClassNamesToClasses() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList("java.lang.String", "java.lang.Integer", "invalid.class.Name");
        
        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertEquals(3, result.size());
        assertTrue(result.contains(String.class));
        assertTrue(result.contains(Integer.class));
        assertNull(result.get(2));
    }

    @Test
    public void testConvertClassNamesToClassesWithNull() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList(null, "java.lang.Integer");

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertEquals(2, result.size());
        assertTrue(result.contains(Integer.class));
        assertNull(result.get(0));
    }

    @Test
    public void testConvertClassNamesToClassesWithEmptyList() {
        // Instantiate all necessary variables here
        List<String> classNames = Arrays.asList();

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertTrue(result.isEmpty());
    }

    @Test
    public void testConvertClassNamesToClassesWithNullList() {
        // Instantiate all necessary variables here
        List<String> classNames = null;

        // Write the test code here following the given rules
        List<Class<?>> result = ClassUtils.convertClassNamesToClasses(classNames);

        // Assertions
        assertNull(result);
    }




    @Test
    public void testWrapperToPrimitive() {
        // Test with Integer wrapper class
        Class<?> primitiveClass = ClassUtils.wrapperToPrimitive(Integer.class);
        assertEquals(int.class, primitiveClass);
        
        // Test with Double wrapper class
        primitiveClass = ClassUtils.wrapperToPrimitive(Double.class);
        assertEquals(double.class, primitiveClass);
    }

    @Test
    public void testWrapperToPrimitiveWithNonWrapperClass() {
        // Test with non-wrapper class
        Class<?> primitiveClass = ClassUtils.wrapperToPrimitive(String.class);
        assertNull(primitiveClass);
    }

    @Test
    public void testWrapperToPrimitiveWithNull() {
        // Test with null
        Class<?> primitiveClass = ClassUtils.wrapperToPrimitive(null);
        assertNull(primitiveClass);
    }




    @Test
    public void testToClassWithNullArray() {
        // Test data
        Object[] array = null;

        // Call the method under test
        Class<?>[] result = ClassUtils.toClass(array);

        // Assertions
        assertNull(result, "The result should be null for a null input array");
    }

    @Test
    public void testToClassWithEmptyArray() {
        // Test data
        Object[] array = new Object[0];

        // Call the method under test
        Class<?>[] result = ClassUtils.toClass(array);

        // Assertions
        assertNotNull(result, "The result should not be null for an empty input array");
        assertEquals(0, result.length, "The result array should be empty for an empty input array");
    }

    @Test
    public void testToClassWithNonNullElements() {
        // Test data
        Object[] array = new Object[]{1, "String", 1.0};

        // Call the method under test
        Class<?>[] result = ClassUtils.toClass(array);

        // Assertions
        assertNotNull(result, "The result should not be null for a non-null input array");
        assertEquals(3, result.length, "The result array should have the same length as the input array");
        assertEquals(Integer.class, result[0], "The class of the first element should be Integer");
        assertEquals(String.class, result[1], "The class of the second element should be String");
        assertEquals(Double.class, result[2], "The class of the third element should be Double");
    }

    @Test
    public void testToClassWithNullElements() {
        // Test data
        Object[] array = new Object[]{null, "String", null};

        // Call the method under test
        Class<?>[] result = ClassUtils.toClass(array);

        // Assertions
        assertNotNull(result, "The result should not be null for a non-null input array");
        assertEquals(3, result.length, "The result array should have the same length as the input array");
        assertNull(result[0], "The class of the first element should be null");
        assertEquals(String.class, result[1], "The class of the second element should be String");
        assertNull(result[2], "The class of the third element should be null");
    }

}