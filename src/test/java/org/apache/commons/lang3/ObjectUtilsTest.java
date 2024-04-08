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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ObjectUtilsTest {
    @Test
    @DisplayName("should return default value if object is null")
    void shouldReturnDefaultValueIfObjectIsNull() {
        String defaultValue = "default";
        String result = objectUtils.defaultIfNull(null, defaultValue);
        assertEquals(defaultValue, result);
    }
    
    @Test
    @DisplayName("should return object if object is not null")
    void shouldReturnObjectIfObjectIsNotNull() {
        String object = "value";
        String defaultValue = "default";
        String result = objectUtils.defaultIfNull(object, defaultValue);
        assertSame(object, result);
    }
    
    @Test
    @DisplayName("should return null if both object and default value are null")
    void shouldReturnNullIfObjectAndDefaultValueAreNull() {
        String result = objectUtils.defaultIfNull(null, null);
        assertNull(result);
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNotEquals;
    import static org.junit.jupiter.api.Assertions.assertTrue;
    
    import org.junit.jupiter.api.Test;
    
    public class ObjectUtilsTestSuite {
    
      @Test
      void testHashCodeMultiWithNoObjects() {
        assertEquals(1, ObjectUtils.hashCodeMulti());
      }
    
      @Test
      void testHashCodeMultiWithSingleObject() {
        Object object = new Object();
        int expectedHashCode = 31 + Objects.hashCode(object);
        assertEquals(expectedHashCode, ObjectUtils.hashCodeMulti(object));
      }
    
      @Test
      void testHashCodeMultiWithMultipleObjects() {
        Object object1 = new Object();
        Object object2 = new Object();
        int expectedHashCode = 1;
        expectedHashCode = expectedHashCode * 31 + Objects.hashCode(object1);
        expectedHashCode = expectedHashCode * 31 + Objects.hashCode(object2);
        assertEquals(expectedHashCode, ObjectUtils.hashCodeMulti(object1, object2));
      }
    
      @Test
      void testHashCodeMultiWithNullObject() {
        assertEquals(1, ObjectUtils.hashCodeMulti((Object) null));
      }
    
      @Test
      void testHashCodeMultiWithSameObjects() {
        Object object = new Object();
        int hashCode1 = ObjectUtils.hashCodeMulti(object);
        int hashCode2 = ObjectUtils.hashCodeMulti(object);
        assertEquals(hashCode1, hashCode2);
      }
    
      @Test
      void testHashCodeMultiWithDifferentObjects() {
        Object object1 = new Object();
        Object object2 = new Object();
        int hashCode1 = ObjectUtils.hashCodeMulti(object1);
        int hashCode2 = ObjectUtils.hashCodeMulti(object2);
        assertNotEquals(hashCode1, hashCode2);
      }
    }
    @Test
    void testWait_ZeroDuration() {
        assertDoesNotThrow(() -> ObjectUtils.wait(testObject, Duration.ZERO));
    }
    
    @Test
    void testWait_PositiveDuration() {
        assertDoesNotThrow(() -> ObjectUtils.wait(testObject, Duration.ofSeconds(1)));
    }
    
    @Test
    void testWait_NegativeDuration() {
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.wait(testObject, Duration.ofSeconds(-1)));
    }
    
    @Test
    void testWait_NullObject() {
        assertThrows(NullPointerException.class, () -> ObjectUtils.wait(null, Duration.ofSeconds(1)));
    }
    
    @Test
    void testWait_Interrupted() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                ObjectUtils.wait(testObject, Duration.ofSeconds(2));
            } catch (InterruptedException e) {
                // Do nothing
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        assertTrue(thread.isInterrupted());
    }
    
    @Test
    void testWait_IllegalMonitorState() {
        Object mockObject = mock(Object.class);
        assertThrows(IllegalMonitorStateException.class, () -> ObjectUtils.wait(mockObject, Duration.ofSeconds(1)));
    }
    @Test
    void testFirstNonNullWithNullValues() {
        assertNull(ObjectUtils.firstNonNull(null, null));
    }
    
    @Test
    void testFirstNonNullWithNullAndNonNullValues() {
        assertEquals("", ObjectUtils.firstNonNull(null, ""));
    }
    
    @Test
    void testFirstNonNullWithNullAndNonNullValuesAndEmptyString() {
        assertEquals("", ObjectUtils.firstNonNull(null, null, ""));
    }
    
    @Test
    void testFirstNonNullWithNullAndNonNullValuesAndNonEmptyString() {
        assertEquals("zz", ObjectUtils.firstNonNull(null, "zz"));
    }
    
    @Test
    void testFirstNonNullWithNonNullAndNullValues() {
        assertEquals("abc", ObjectUtils.firstNonNull("abc", null));
    }
    
    @Test
    void testFirstNonNullWithNullAndNonNullValuesAndMultipleNonNullValues() {
        assertEquals("xyz", ObjectUtils.firstNonNull(null, "xyz", null));
    }
    
    @Test
    void testFirstNonNullWithNonNullBooleanValueAndNonNullValues() {
        assertTrue(ObjectUtils.firstNonNull(Boolean.TRUE, null));
    }
    
    @Test
    void testFirstNonNullWithNoValues() {
        assertNull(ObjectUtils.firstNonNull());
    }
    @Test
    @DisplayName("Test identityHashCodeHex with null object")
    void testIdentityHashCodeHexWithNullObject() {
        Assertions.assertEquals("0", ObjectUtils.identityHashCodeHex(null));
    }
    
    @Test
    @DisplayName("Test identityHashCodeHex with non-null object")
    void testIdentityHashCodeHexWithNonNullObject() {
        Object obj = new Object();
        int hashCode = System.identityHashCode(obj);
        String expected = Integer.toHexString(hashCode);
        Assertions.assertEquals(expected, ObjectUtils.identityHashCodeHex(obj));
    }
    @Test
    @DisplayName("should return 0 when object is null")
    void shouldReturnZeroWhenObjectIsNull() {
        Object obj = null;
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return the hash code of the object when object is not null")
    void shouldReturnHashCodeOfObjectWhenObjectIsNotNull() {
        Object obj = new Object();
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(obj.hashCode(), result);
    }
    
    @Test
    @DisplayName("should return the hash code of the Null object when object is Null")
    void shouldReturnHashCodeOfNullObjectWhenObjectIsNull() {
        Object obj = ObjectUtils.NULL;
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(ObjectUtils.NULL.hashCode(), result);
    }
    
    @Test
    @DisplayName("should return the hash code of the object when object is not null and is a Null instance")
    void shouldReturnHashCodeOfObjectWhenObjectIsNotNullAndIsANullInstance() {
        Object obj = new ObjectUtils.Null();
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(obj.hashCode(), result);
    }
    
    @Test
    @DisplayName("should return the hash code of a HashMap when object is a HashMap")
    void shouldReturnHashCodeOfHashMapWhenObjectIsHashMap() {
        Object obj = new HashMap<>();
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(obj.hashCode(), result);
    }
    
    @Test
    @DisplayName("should return the hash code of a Hashtable when object is a Hashtable")
    void shouldReturnHashCodeOfHashtableWhenObjectIsHashtable() {
        Object obj = new Hashtable<>();
    
        int result = objectUtils.hashCode(obj);
    
        assertEquals(obj.hashCode(), result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class ObjectUtilsTestSuite {
    
        @Test
        @DisplayName("Test anyNotNull with all non-null values")
        void testAnyNotNullWithNonNullValues() {
            Object[] values = { "abc", 123, true, new Object() };
            assertTrue(ObjectUtils.anyNotNull(values));
        }
    
        @Test
        @DisplayName("Test anyNotNull with all null values")
        void testAnyNotNullWithNullValues() {
            Object[] values = { null, null, null };
            assertFalse(ObjectUtils.anyNotNull(values));
        }
    
        @Test
        @DisplayName("Test anyNotNull with a mix of null and non-null values")
        void testAnyNotNullWithMixedValues() {
            Object[] values = { "abc", null, true, null };
            assertTrue(ObjectUtils.anyNotNull(values));
        }
    
        @Test
        @DisplayName("Test anyNotNull with an empty array")
        void testAnyNotNullWithEmptyArray() {
            Object[] values = {};
            assertFalse(ObjectUtils.anyNotNull(values));
        }
    
        @Test
        @DisplayName("Test anyNotNull with a null array")
        void testAnyNotNullWithNullArray() {
            Object[] values = null;
            assertFalse(ObjectUtils.anyNotNull(values));
        }
    }
    @Test
    void testModeWithNullItems() {
        Object result = objectUtils.mode();
        Assertions.assertNull(result);
    }
    
    @Test
    void testModeWithEmptyItems() {
        Object result = objectUtils.mode(new Object[0]);
        Assertions.assertNull(result);
    }
    
    @Test
    void testMode(Object[] items, Object expected) {
        Object result = objectUtils.mode(items);
        Assertions.assertEquals(expected, result);
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNull;
    import static org.mockito.Mockito.*;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    class ObjectUtilsTest {
    
        private ObjectUtils objectUtils;
    
        @BeforeEach
        void setUp() {
            objectUtils = new ObjectUtils();
        }
    
        @Test
        void testIdentityToStringWithNonNullObject() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = new Object();
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNullObject() {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullAppendable() {
            Appendable appendable = null;
            Object object = new Object();
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullAppendable() {
            Appendable appendable = null;
            Object object = new Object();
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullAppendable() {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndIOException() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = new Object();
    
            doThrow(new IOException()).when(appendable).append(anyString());
    
            assertThrows(IOException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = new Object();
    
            when(appendable.append(anyString())).thenReturn(null);
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = new Object();
    
            when(appendable.append(anyString())).thenReturn(appendable);
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObject() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObject() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObject() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = new Object();
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndIOException() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            doThrow(new IOException()).when(appendable).append(anyString());
    
            assertThrows(IOException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndIOException() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            doThrow(new IOException()).when(appendable).append(anyString());
    
            assertThrows(IOException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendable() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            objectUtils.identityToString(appendable, object);
    
            verify(appendable).append(object.getClass().getName());
            verify(appendable).append("@");
            verify(appendable).append(Integer.toHexString(System.identityHashCode(object)));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndIOExceptionAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            when(appendable.append(anyString())).thenReturn(null);
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndIOExceptionAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            when(appendable.append(anyString())).thenReturn(null);
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNonNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendableAndNullReturn() throws IOException {
            Appendable appendable = mock(Appendable.class);
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndIOExceptionAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndIOExceptionAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNullObjectAndNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNonNullObjectAndNonNullObjectAndNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNullObjectAndNonNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = null;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    
        @Test
        void testIdentityToStringWithNullObjectAndNonNullObjectAndNonNullAppendableAndNullReturnAndNullAppendable() throws IOException {
            Appendable appendable = null;
            Object object = ObjectUtils.NULL;
    
            assertThrows(NullPointerException.class, () -> objectUtils.identityToString(appendable, object));
        }
    }
    @Test
    void testMedianWithIntegers() {
        assertEquals(2, ObjectUtils.median(1, 2, 3));
        assertEquals(3, ObjectUtils.median(1, 2, 3, 4));
        assertEquals(5, ObjectUtils.median(5));
        assertEquals(0, ObjectUtils.median(-1, 0, 1));
        assertEquals(-10, ObjectUtils.median(-20, -10, 0, 10, 20));
    }
    
    @Test
    void testMedianWithDoubles() {
        assertEquals(2.5, ObjectUtils.median(1.5, 2.5, 3.5));
        assertEquals(3.5, ObjectUtils.median(1.5, 2.5, 3.5, 4.5));
        assertEquals(5.0, ObjectUtils.median(5.0));
        assertEquals(0.0, ObjectUtils.median(-1.0, 0.0, 1.0));
        assertEquals(-10.0, ObjectUtils.median(-20.0, -10.0, 0.0, 10.0, 20.0));
    }
    
    @Test
    void testMedianWithStrings() {
        assertEquals("b", ObjectUtils.median("a", "b", "c"));
        assertEquals("c", ObjectUtils.median("a", "b", "c", "d"));
        assertEquals("e", ObjectUtils.median("e"));
        assertEquals("a", ObjectUtils.median("a", "b", "c", "d", "e", "f", "g"));
    }
    
    @Test
    void testMedianWithNull() {
        assertThrows(NullPointerException.class, () -> ObjectUtils.median((Integer) null));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median());
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(1, null, 3));
    }
    
    @Test
    void testMedianWithComparator() {
        Comparator<String> stringLengthComparator = Comparator.comparing(String::length);
        assertEquals("b", ObjectUtils.median(stringLengthComparator, "aa", "b", "ccc"));
        assertEquals("ccc", ObjectUtils.median(stringLengthComparator, "aa", "b", "ccc", "dddd"));
        assertEquals("e", ObjectUtils.median(stringLengthComparator, "e"));
        assertEquals("a", ObjectUtils.median(stringLengthComparator, "a", "bb", "ccc", "dddd", "eeeee", "ffffff", "ggggggg"));
    }
    
    @Test
    void testMedianWithComparatorAndNull() {
        Comparator<String> stringLengthComparator = Comparator.comparing(String::length);
        assertThrows(NullPointerException.class, () -> ObjectUtils.median(stringLengthComparator, (String) null));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(stringLengthComparator));
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.median(stringLengthComparator, "a", null, "ccc"));
    }
    @Test
    void testConstByteInRange() {
        byte result = objectUtils.CONST_BYTE(0);
        assertEquals(0, result);
    }
    
    @Test
    void testConstByteMinValue() {
        byte result = objectUtils.CONST_BYTE(Byte.MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, result);
    }
    
    @Test
    void testConstByteMaxValue() {
        byte result = objectUtils.CONST_BYTE(Byte.MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, result);
    }
    
    @Test
    void testConstByteOutOfRange() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            objectUtils.CONST_BYTE(128);
        });
        String expectedMessage = "Supplied value must be a valid byte literal between -128 and 127: [128]";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    
    @Test
    void testConstByteNegativeValue() {
        byte result = objectUtils.CONST_BYTE(-1);
        assertEquals(-1, result);
    }
    
    @Test
    void testConstBytePositiveValue() {
        byte result = objectUtils.CONST_BYTE(1);
        assertEquals(1, result);
    }
    // Your Java code here
    
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class ObjectUtilsTest {
    
        private ObjectUtils objectUtils;
    
        @BeforeAll
        public void setup() {
            objectUtils = new ObjectUtils();
        }
    
        @Test
        void testAnyNull_withNoNullValues_shouldReturnFalse() {
            assertFalse(objectUtils.anyNull(1, "abc", new Object()));
        }
    
        @Test
        void testAnyNull_withNullValue_shouldReturnTrue() {
            assertTrue(objectUtils.anyNull(null));
        }
    
        @Test
        void testAnyNull_withMultipleNullValues_shouldReturnTrue() {
            assertTrue(objectUtils.anyNull(null, null));
        }
    
        @Test
        void testAnyNull_withMixedNullAndNonNullValues_shouldReturnTrue() {
            assertTrue(objectUtils.anyNull(null, "abc", null, new Object()));
        }
    
        @Test
        void testAnyNull_withEmptyArray_shouldReturnTrue() {
            assertTrue(objectUtils.anyNull());
        }
    
        @Test
        void testAnyNull_withNullArray_shouldReturnTrue() {
            assertTrue(objectUtils.anyNull((Object[]) null));
        }
    }
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    
    class ObjectUtilsTest {
        
        @Test
        void testGetClass() {
            // Test with null input
            Class<Null> nullClass = ObjectUtils.getClass(null);
            Assertions.assertNull(nullClass);
            
            // Test with primitive types
            Class<Boolean> booleanClass = ObjectUtils.getClass(true);
            Assertions.assertEquals(boolean.class, booleanClass);
            
            Class<Byte> byteClass = ObjectUtils.getClass((byte) 1);
            Assertions.assertEquals(byte.class, byteClass);
            
            Class<Character> charClass = ObjectUtils.getClass('a');
            Assertions.assertEquals(char.class, charClass);
            
            Class<Short> shortClass = ObjectUtils.getClass((short) 1);
            Assertions.assertEquals(short.class, shortClass);
            
            Class<Integer> intClass = ObjectUtils.getClass(1);
            Assertions.assertEquals(int.class, intClass);
            
            Class<Long> longClass = ObjectUtils.getClass(1L);
            Assertions.assertEquals(long.class, longClass);
            
            Class<Float> floatClass = ObjectUtils.getClass(1.0f);
            Assertions.assertEquals(float.class, floatClass);
            
            Class<Double> doubleClass = ObjectUtils.getClass(1.0);
            Assertions.assertEquals(double.class, doubleClass);
            
            // Test with array types
            Class<int[]> intArrayClass = ObjectUtils.getClass(new int[0]);
            Assertions.assertEquals(int[].class, intArrayClass);
            
            Class<String[]> stringArrayClass = ObjectUtils.getClass(new String[0]);
            Assertions.assertEquals(String[].class, stringArrayClass);
            
            // Test with generic types
            Class<ArrayList<String>> arrayListClass = ObjectUtils.getClass(new ArrayList<String>());
            Assertions.assertEquals(ArrayList.class, arrayListClass);
            
            Class<HashMap<String, Integer>> hashMapClass = ObjectUtils.getClass(new HashMap<String, Integer>());
            Assertions.assertEquals(HashMap.class, hashMapClass);
            
            // Test with custom class
            Class<CustomClass> customClass = ObjectUtils.getClass(new CustomClass());
            Assertions.assertEquals(CustomClass.class, customClass);
        }
    }
    @Test
    void testRequireNonEmpty_validObject() {
        String obj = "test";
        String result = objectUtils.requireNonEmpty(obj);
        assertEquals(obj, result);
    }
    
    @Test
    void testRequireNonEmpty_nullObject() {
        String obj = null;
        assertThrows(NullPointerException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyString() {
        String obj = "";
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyCollection() {
        Collection<String> obj = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyArray() {
        String[] obj = new String[0];
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyMap() {
        Map<String, String> obj = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyOptional() {
        Optional<String> obj = Optional.empty();
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    
    @Test
    void testRequireNonEmpty_emptyStream() {
        Stream<String> obj = Stream.empty();
        assertThrows(IllegalArgumentException.class, () -> objectUtils.requireNonEmpty(obj));
    }
    @Test
    void testNotEqual_bothNull() {
        Object object1 = null;
        Object object2 = null;
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_firstNull() {
        Object object1 = null;
        Object object2 = "";
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_secondNull() {
        Object object1 = "";
        Object object2 = null;
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_bothEmptyString() {
        Object object1 = "";
        Object object2 = "";
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_differentString() {
        Object object1 = "Hello";
        Object object2 = "World";
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_sameString() {
        Object object1 = "Hello";
        Object object2 = "Hello";
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_differentBoolean() {
        Object object1 = true;
        Object object2 = false;
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_sameBoolean() {
        Object object1 = true;
        Object object2 = true;
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_differentIntegers() {
        Object object1 = 10;
        Object object2 = 20;
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_sameIntegers() {
        Object object1 = 10;
        Object object2 = 10;
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_differentObjects() {
        Object object1 = new Object();
        Object object2 = new Object();
        assertTrue(ObjectUtils.notEqual(object1, object2));
    }
    
    @Test
    void testNotEqual_sameObject() {
        Object object1 = new Object();
        Object object2 = object1;
        assertFalse(ObjectUtils.notEqual(object1, object2));
    }
    @Test
    void testCloneIfPossible_withCloneableInterface_shouldReturnClone() {
        // Arrange
        CloneableClass obj = new CloneableClass();
    
        // Act
        CloneableClass clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertNotSame(obj, clone);
        assertEquals(obj, clone);
    }
    
    @Test
    void testCloneIfPossible_withNonCloneableInterface_shouldReturnSameObject() {
        // Arrange
        NonCloneableClass obj = new NonCloneableClass();
    
        // Act
        NonCloneableClass clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertSame(obj, clone);
    }
    
    @Test
    void testCloneIfPossible_withNullObject_shouldReturnNull() {
        // Arrange
        Object obj = null;
    
        // Act
        Object clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertNull(clone);
    }
    
    @Test
    void testCloneIfPossible_withHashMap_shouldReturnClone() {
        // Arrange
        Map<Integer, String> obj = new HashMap<>();
        obj.put(1, "one");
        obj.put(2, "two");
    
        // Act
        Map<Integer, String> clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertNotSame(obj, clone);
        assertEquals(obj, clone);
    }
    
    @Test
    void testCloneIfPossible_withHashtable_shouldReturnClone() {
        // Arrange
        Map<Integer, String> obj = new Hashtable<>();
        obj.put(1, "one");
        obj.put(2, "two");
    
        // Act
        Map<Integer, String> clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertNotSame(obj, clone);
        assertEquals(obj, clone);
    }
    
    @Test
    void testCloneIfPossible_withCustomCloneableClass_shouldReturnClone() {
        // Arrange
        CustomCloneableClass obj = new CustomCloneableClass();
    
        // Act
        CustomCloneableClass clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertNotSame(obj, clone);
        assertEquals(obj, clone);
    }
    
    @Test
    void testCloneIfPossible_withCustomNonCloneableClass_shouldReturnSameObject() {
        // Arrange
        CustomNonCloneableClass obj = new CustomNonCloneableClass();
    
        // Act
        CustomNonCloneableClass clone = objectUtils.cloneIfPossible(obj);
    
        // Assert
        assertSame(obj, clone);
    }
    @Test
    @DisplayName("should return null for null input")
    void testMaxWithNullInput() {
        assertNull(ObjectUtils.max(null));
    }
    
    @Test
    @DisplayName("should return null for empty input")
    void testMaxWithEmptyInput() {
        assertNull(ObjectUtils.max());
    }
    
    @Test
    @DisplayName("should return the maximum value for non-null input")
    void testMaxWithNonNullInput() {
        assertEquals(5, ObjectUtils.max(1, 3, 5));
    }
    
    @Test
    @DisplayName("should return the maximum value for non-null input with duplicate values")
    void testMaxWithDuplicateValues() {
        assertEquals(5, ObjectUtils.max(1, 3, 5, 5));
    }
    
    @Test
    @DisplayName("should return the maximum value for non-null input with negative values")
    void testMaxWithNegativeValues() {
        assertEquals(-1, ObjectUtils.max(-1, -3, -5));
    }
    
    @Test
    @DisplayName("should return the maximum value for non-null input with mixed positive and negative values")
    void testMaxWithMixedPositiveAndNegativeValues() {
        assertEquals(5, ObjectUtils.max(-1, -3, 5));
    }
    
    @Test
    @DisplayName("should return the maximum value for non-null input with mixed integer and floating-point values")
    void testMaxWithMixedIntegerAndFloatingPointValues() {
        assertEquals(5.5, ObjectUtils.max(2.3, 5.5, 4));
    }
    @Test
    void testAllNull_withNullValues_shouldReturnTrue() {
        assertTrue(ObjectUtils.allNull((Object[]) null));
    }
    
    @Test
    void testAllNull_withEmptyArray_shouldReturnTrue() {
        assertTrue(ObjectUtils.allNull());
    }
    
    @Test
    void testAllNull_withAllNullValues_shouldReturnTrue() {
        assertTrue(ObjectUtils.allNull(null, null, null));
    }
    
    @Test
    void testAllNull_withNonNullValue_shouldReturnFalse() {
        assertFalse(ObjectUtils.allNull("test"));
    }
    
    @Test
    void testAllNull_withMixedNullAndNonNullValues_shouldReturnFalse() {
        assertFalse(ObjectUtils.allNull(null, "test", null));
    }
    
    @Test
    void testAllNull_withArrayContainingNullObject_shouldReturnFalse() {
        assertFalse(ObjectUtils.allNull(new Object[] { null }));
    }
    
    @Test
    void testAllNull_withArrayContainingNonNullObject_shouldReturnFalse() {
        assertFalse(ObjectUtils.allNull(new Object[] { "test" }));
    }
    @Test
    void testGetFirstNonNull() {
        // Test case 1: No suppliers provided, expect null
        assertNull(ObjectUtils.getFirstNonNull());
    
        // Test case 2: Single supplier returns null, expect null
        Supplier<String> supplier1 = () -> null;
        assertNull(ObjectUtils.getFirstNonNull(supplier1));
    
        // Test case 3: Single supplier returns non-null value, expect the value
        Supplier<String> supplier2 = () -> "Hello";
        assertEquals("Hello", ObjectUtils.getFirstNonNull(supplier2));
    
        // Test case 4: Multiple suppliers, first supplier returns non-null value, expect the value
        Supplier<String> supplier3 = () -> "Hello";
        Supplier<String> supplier4 = () -> "World";
        assertEquals("Hello", ObjectUtils.getFirstNonNull(supplier3, supplier4));
    
        // Test case 5: Multiple suppliers, all suppliers return null, expect null
        Supplier<String> supplier5 = () -> null;
        Supplier<String> supplier6 = () -> null;
        assertNull(ObjectUtils.getFirstNonNull(supplier5, supplier6));
    
        // Test case 6: Multiple suppliers, first supplier returns null, second supplier returns non-null value, expect the value
        Supplier<String> supplier7 = () -> null;
        Supplier<String> supplier8 = () -> "World";
        assertEquals("World", ObjectUtils.getFirstNonNull(supplier7, supplier8));
    }
    @Test
    public void testCONSTBoolean() {
        boolean value = true;
        boolean result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTByte() {
        byte value = 127;
        byte result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTChar() {
        char value = 'a';
        char result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTDouble() {
        double value = 1.0;
        double result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTFloat() {
        float value = 1.0f;
        float result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTInt() {
        int value = 123;
        int result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTLong() {
        long value = 123L;
        long result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTShort() {
        short value = 123;
        short result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    
    @Test
    public void testCONSTString() {
        String value = "abc";
        String result = ObjectUtils.CONST(value);
        Assertions.assertEquals(value, result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class ObjectUtilsTest {
    
        @Test
        void testEqualsBothNull() {
            assertTrue(ObjectUtils.equals(null, null));
        }
    
        @Test
        void testEqualsFirstNull() {
            assertFalse(ObjectUtils.equals(null, ""));
        }
    
        @Test
        void testEqualsSecondNull() {
            assertFalse(ObjectUtils.equals("", null));
        }
    
        @Test
        void testEqualsBothEmptyString() {
            assertTrue(ObjectUtils.equals("", ""));
        }
    
        @Test
        void testEqualsFirstBooleanNull() {
            assertFalse(ObjectUtils.equals(Boolean.TRUE, null));
        }
    
        @Test
        void testEqualsFirstBooleanString() {
            assertFalse(ObjectUtils.equals(Boolean.TRUE, "true"));
        }
    
        @Test
        void testEqualsBothBooleanTrue() {
            assertTrue(ObjectUtils.equals(Boolean.TRUE, Boolean.TRUE));
        }
    
        @Test
        void testEqualsBothBooleanFalse() {
            assertFalse(ObjectUtils.equals(Boolean.TRUE, Boolean.FALSE));
        }
    }
    @Test
    void testClone_shouldReturnNullForNullObject() {
      assertNull(ObjectUtils.clone(null));
    }
    
    @Test
    void testClone_shouldReturnSameInstanceForNonCloneableObjects() {
      Object obj = new Object();
      Object clonedObj = ObjectUtils.clone(obj);
      assertSame(obj, clonedObj);
    }
    
    @Test
    void testClone_shouldReturnClonedArrayForArray() {
      int[] arr = new int[] {1, 2, 3};
      int[] clonedArr = ObjectUtils.clone(arr);
      assertArrayEquals(arr, clonedArr);
      assertNotSame(arr, clonedArr);
    }
    
    @Test
    void testClone_shouldReturnClonedObjectForCloneableObjects() {
      CloneableObject obj = new CloneableObject();
      CloneableObject clonedObj = ObjectUtils.clone(obj);
      assertNotNull(clonedObj);
      assertNotSame(obj, clonedObj);
      assertEquals(obj.getValue(), clonedObj.getValue());
    }
    
    @Test
    void testClone_shouldThrowCloneFailedExceptionForNonCloneableTypes() {
      assertThrows(CloneFailedException.class, () -> ObjectUtils.clone(new NonCloneableObject()));
    }
    
    @Test
    void testClone_shouldThrowCloneFailedExceptionForInaccessibleCloneMethod() {
      assertThrows(CloneFailedException.class, () -> ObjectUtils.clone(new InaccessibleCloneableObject()));
    }
    
    @Test
    void testClone_shouldThrowCloneFailedExceptionForExceptionInCloneMethod() {
      assertThrows(CloneFailedException.class, () -> ObjectUtils.clone(new ExceptionInCloneMethodObject()));
    }
    @Test
    @DisplayName("Should return the provided value unchanged")
    void shouldReturnProvidedValueUnchanged() {
        // Arrange
        int value = 50;
    
        // Act
        short result = ObjectUtils.CONST_SHORT(value);
    
        // Assert
        assertEquals(value, result);
    }
    
    @Test
    @DisplayName("Should throw IllegalArgumentException when value is smaller than Short.MIN_VALUE")
    void shouldThrowExceptionWhenValueIsSmallerThanShortMinValue() {
        // Arrange
        int value = Short.MIN_VALUE - 1;
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(value));
    }
    
    @Test
    @DisplayName("Should throw IllegalArgumentException when value is larger than Short.MAX_VALUE")
    void shouldThrowExceptionWhenValueIsLargerThanShortMaxValue() {
        // Arrange
        int value = Short.MAX_VALUE + 1;
    
        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.CONST_SHORT(value));
    }
    
    @Test
    @DisplayName("Should not throw exception when value is Short.MIN_VALUE")
    void shouldNotThrowExceptionWhenValueIsShortMinValue() {
        // Arrange
        int value = Short.MIN_VALUE;
    
        // Act and Assert
        assertDoesNotThrow(() -> ObjectUtils.CONST_SHORT(value));
    }
    
    @Test
    @DisplayName("Should not throw exception when value is Short.MAX_VALUE")
    void shouldNotThrowExceptionWhenValueIsShortMaxValue() {
        // Arrange
        int value = Short.MAX_VALUE;
    
        // Act and Assert
        assertDoesNotThrow(() -> ObjectUtils.CONST_SHORT(value));
    }
    @Test
    public void testHashCodeHex_NullObject_ReturnsNull() {
      Object object = null;
    
      String result = objectUtils.hashCodeHex(object);
    
      assertEquals(null, result);
    }
    
    @Test
    public void testHashCodeHex_NonNullObject_ReturnsHexadecimalString() {
      Object object = new Object();
    
      String result = objectUtils.hashCodeHex(object);
    
      assertEquals(Integer.toHexString(object.hashCode()), result);
    }
    
    @Test
    public void testHashCodeHex_EqualObjects_ReturnsSameHashCode() {
      Object object1 = new Object();
      Object object2 = object1;
    
      String result1 = objectUtils.hashCodeHex(object1);
      String result2 = objectUtils.hashCodeHex(object2);
    
      assertEquals(Integer.toHexString(object1.hashCode()), result1);
      assertEquals(Integer.toHexString(object2.hashCode()), result2);
      assertEquals(result1, result2);
    }
    
    @Test
    public void testHashCodeHex_DifferentObjects_ReturnsDifferentHashCodes() {
      Object object1 = new Object();
      Object object2 = new Object();
    
      String result1 = objectUtils.hashCodeHex(object1);
      String result2 = objectUtils.hashCodeHex(object2);
    
      assertEquals(Integer.toHexString(object1.hashCode()), result1);
      assertEquals(Integer.toHexString(object2.hashCode()), result2);
      assertEquals(false, result1.equals(result2));
    }
    
    @Test
    public void testHashCodeHex_SameHashCode_ReturnsSameResult() {
      Object object1 = new Object();
      Object object2 = new Object();
    
      int hashCode = object1.hashCode();
      object2.hashCode = hashCode;
    
      String result1 = objectUtils.hashCodeHex(object1);
      String result2 = objectUtils.hashCodeHex(object2);
    
      assertEquals(Integer.toHexString(hashCode), result1);
      assertEquals(Integer.toHexString(hashCode), result2);
      assertEquals(result1, result2);
    }
    
    @Test
    public void testHashCodeHex_NullValue_ReturnsNull() {
      Object object = ObjectUtils.NULL;
    
      String result = objectUtils.hashCodeHex(object);
    
      assertEquals(null, result);
    }
    // Your Java code here
    
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ObjectUtilsTest {
    
        @Nested
        @DisplayName("compare")
        class CompareTest {
    
            @Test
            @DisplayName("Should return 0 when both values are null")
            void compare_bothNull() {
                // Arrange
                Integer c1 = null;
                Integer c2 = null;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(0, result);
            }
    
            @Test
            @DisplayName("Should return -1 when first value is null and second value is not null")
            void compare_firstNull() {
                // Arrange
                Integer c1 = null;
                Integer c2 = 5;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(-1, result);
            }
    
            @Test
            @DisplayName("Should return 1 when first value is not null and second value is null")
            void compare_secondNull() {
                // Arrange
                Integer c1 = 5;
                Integer c2 = null;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(1, result);
            }
    
            @Test
            @DisplayName("Should return a negative value when first value is less than second value")
            void compare_firstLessThanSecond() {
                // Arrange
                Integer c1 = 10;
                Integer c2 = 20;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(-1, result);
            }
    
            @Test
            @DisplayName("Should return a positive value when first value is greater than second value")
            void compare_firstGreaterThanSecond() {
                // Arrange
                Integer c1 = 20;
                Integer c2 = 10;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(1, result);
            }
    
            @Test
            @DisplayName("Should return 0 when both values are equal")
            void compare_bothEqual() {
                // Arrange
                Integer c1 = 10;
                Integer c2 = 10;
    
                // Act
                int result = ObjectUtils.compare(c1, c2);
    
                // Assert
                assertEquals(0, result);
            }
    
            @Test
            @DisplayName("Should return a negative value when first value is less than second value (nullGreater=true)")
            void compare_nullGreater_firstLessThanSecond() {
                // Arrange
                Integer c1 = 10;
                Integer c2 = 20;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(-1, result);
            }
    
            @Test
            @DisplayName("Should return a positive value when first value is greater than second value (nullGreater=true)")
            void compare_nullGreater_firstGreaterThanSecond() {
                // Arrange
                Integer c1 = 20;
                Integer c2 = 10;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(1, result);
            }
    
            @Test
            @DisplayName("Should return 1 when first value is null and second value is not null (nullGreater=true)")
            void compare_nullGreater_firstNull() {
                // Arrange
                Integer c1 = null;
                Integer c2 = 5;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(1, result);
            }
    
            @Test
            @DisplayName("Should return -1 when first value is not null and second value is null (nullGreater=true)")
            void compare_nullGreater_secondNull() {
                // Arrange
                Integer c1 = 5;
                Integer c2 = null;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(-1, result);
            }
    
            @Test
            @DisplayName("Should return 0 when both values are null (nullGreater=true)")
            void compare_nullGreater_bothNull() {
                // Arrange
                Integer c1 = null;
                Integer c2 = null;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(0, result);
            }
    
            @Test
            @DisplayName("Should return 0 when both values are equal (nullGreater=true)")
            void compare_nullGreater_bothEqual() {
                // Arrange
                Integer c1 = 10;
                Integer c2 = 10;
    
                // Act
                int result = ObjectUtils.compare(c1, c2, true);
    
                // Assert
                assertEquals(0, result);
            }
        }
    }
    @Test
    @DisplayName("should return false when object is null")
    void shouldReturnFalseWhenObjectIsNull() {
        Object object = null;
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertFalse(result);
    }
    
    @Test
    @DisplayName("should return false when object is an empty CharSequence")
    void shouldReturnFalseWhenObjectIsEmptyCharSequence() {
        Object object = "";
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertFalse(result);
    }
    
    @Test
    @DisplayName("should return true when object is a non-empty CharSequence")
    void shouldReturnTrueWhenObjectIsNonEmptyCharSequence() {
        Object object = "ab";
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertTrue(result);
    }
    
    @Test
    @DisplayName("should return false when object is an empty array")
    void shouldReturnFalseWhenObjectIsEmptyArray() {
        Object object = new int[]{};
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertFalse(result);
    }
    
    @Test
    @DisplayName("should return true when object is a non-empty array")
    void shouldReturnTrueWhenObjectIsNonEmptyArray() {
        Object object = new int[]{1, 2, 3};
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertTrue(result);
    }
    
    @Test
    @DisplayName("should return true when object is a non-empty collection")
    void shouldReturnTrueWhenObjectIsNonEmptyCollection() {
        Object object = Collections.singletonList("item");
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertTrue(result);
    }
    
    @Test
    @DisplayName("should return true when object is a non-empty map")
    void shouldReturnTrueWhenObjectIsNonEmptyMap() {
        Object object = Collections.singletonMap("key", "value");
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertTrue(result);
    }
    
    @Test
    @DisplayName("should return true when object is a non-empty Optional")
    void shouldReturnTrueWhenObjectIsNonEmptyOptional() {
        Object object = Optional.of("value");
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertTrue(result);
    }
    
    @Test
    @DisplayName("should return false when object is an empty Optional")
    void shouldReturnFalseWhenObjectIsEmptyOptional() {
        Object object = Optional.empty();
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertFalse(result);
    }
    
    @Test
    @DisplayName("should return false when object has an unsupported type")
    void shouldReturnFalseWhenObjectHasUnsupportedType() {
        Object object = new Object();
    
        boolean result = ObjectUtils.isNotEmpty(object);
    
        assertFalse(result);
    }
    import org.junit.jupiter.api.Test;
    
    @Test
    void testAllNotNullWithNullValues() {
        assertFalse(ObjectUtils.allNotNull(null));
        assertFalse(ObjectUtils.allNotNull(null, null));
        assertFalse(ObjectUtils.allNotNull(null, "value"));
        assertFalse(ObjectUtils.allNotNull("value", null));
        assertFalse(ObjectUtils.allNotNull("value", null, "value"));
    }
    
    @Test
    void testAllNotNullWithNonNullValues() {
        assertTrue(ObjectUtils.allNotNull());
        assertTrue(ObjectUtils.allNotNull("value"));
        assertTrue(ObjectUtils.allNotNull("value1", "value2"));
        assertTrue(ObjectUtils.allNotNull(1, 2, 3));
    }
    
    @Test
    void testAllNotNullWithEmptyArray() {
        assertTrue(ObjectUtils.allNotNull(new Object[0]));
    }
    
    @Test
    void testAllNotNullWithMixedValues() {
        assertFalse(ObjectUtils.allNotNull("value1", null, "value2"));
        assertFalse(ObjectUtils.allNotNull(null, "value1", null, "value2"));
        assertFalse(ObjectUtils.allNotNull(null, "value1", "value2", null));
    }
    @Test
    @DisplayName("Test toString with null input")
    public void testToStringWithNullInput() {
        Object obj = null;
        String expected = "";
        String actual = objectUtils.toString(obj);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with empty string input")
    public void testToStringWithEmptyStringInput() {
        Object obj = "";
        String expected = "";
        String actual = objectUtils.toString(obj);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with non-null string input")
    public void testToStringWithNonNullStringInput() {
        Object obj = "bat";
        String expected = "bat";
        String actual = objectUtils.toString(obj);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with Boolean object input")
    public void testToStringWithBooleanObjectInput() {
        Object obj = Boolean.TRUE;
        String expected = "true";
        String actual = objectUtils.toString(obj);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with null input and nullStr")
    public void testToStringWithNullInputAndNullStr() {
        Object obj = null;
        String nullStr = "null";
        String expected = "null";
        String actual = objectUtils.toString(obj, nullStr);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with empty string input and nullStr")
    public void testToStringWithEmptyStringInputAndNullStr() {
        Object obj = "";
        String nullStr = "null";
        String expected = "";
        String actual = objectUtils.toString(obj, nullStr);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with non-null string input and nullStr")
    public void testToStringWithNonNullStringInputAndNullStr() {
        Object obj = "bat";
        String nullStr = "null";
        String expected = "bat";
        String actual = objectUtils.toString(obj, nullStr);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with Boolean object input and nullStr")
    public void testToStringWithBooleanObjectInputAndNullStr() {
        Object obj = Boolean.TRUE;
        String nullStr = "null";
        String expected = "true";
        String actual = objectUtils.toString(obj, nullStr);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with Supplier object input")
    public void testToStringWithSupplierInput() {
        Supplier<Object> obj = () -> "bat";
        String expected = "bat";
        String actual = objectUtils.toString(obj);
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Test toString with Supplier object input and supplier")
    public void testToStringWithSupplierInputAndSupplier() {
        Supplier<Object> obj = () -> null;
        Supplier<String> supplier = () -> "null";
        String expected = "null";
        String actual = objectUtils.toString(obj, supplier);
        assertEquals(expected, actual);
    }
    @Test
    void testIsEmpty_Null() {
        assertTrue(ObjectUtils.isEmpty(null));
    }
    
    @Test
    void testIsEmpty_EmptyString() {
        assertTrue(ObjectUtils.isEmpty(""));
    }
    
    @Test
    void testIsEmpty_NonEmptyString() {
        assertFalse(ObjectUtils.isEmpty("ab"));
    }
    
    @Test
    void testIsEmpty_EmptyArray() {
        assertTrue(ObjectUtils.isEmpty(new int[] {}));
    }
    
    @Test
    void testIsEmpty_NonEmptyArray() {
        assertFalse(ObjectUtils.isEmpty(new int[] {1, 2, 3}));
    }
    
    @Test
    void testIsEmpty_NonEmptyInteger() {
        assertFalse(ObjectUtils.isEmpty(1234));
    }
    
    @Test
    void testIsEmpty_NonEmptyLong() {
        assertFalse(ObjectUtils.isEmpty(1234L));
    }
    
    @Test
    void testIsEmpty_EmptyOptional() {
        assertTrue(ObjectUtils.isEmpty(Optional.empty()));
    }
    
    @Test
    void testIsEmpty_NonEmptyOptional() {
        assertFalse(ObjectUtils.isEmpty(Optional.of("")));
    }
    
    @Test
    void testIsEmpty_EmptyCollection() {
        assertTrue(ObjectUtils.isEmpty(new ArrayList<>()));
    }
    
    @Test
    void testIsEmpty_NonEmptyCollection() {
        ArrayList<String> list = new ArrayList<>();
        list.add("item");
        assertFalse(ObjectUtils.isEmpty(list));
    }
    
    @Test
    void testIsEmpty_EmptyMap() {
        assertTrue(ObjectUtils.isEmpty(new HashMap<>()));
    }
    
    @Test
    void testIsEmpty_NonEmptyMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 1);
        assertFalse(ObjectUtils.isEmpty(map));
    }
    
    @Test
    void testIsEmpty_EmptyTreeSet() {
        assertTrue(ObjectUtils.isEmpty(new TreeSet<>()));
    }
    
    @Test
    void testIsEmpty_NonEmptyTreeSet() {
        TreeSet<String> set = new TreeSet<>();
        set.add("item");
        assertFalse(ObjectUtils.isEmpty(set));
    }
    @Test
    void testIsArrayWithNullObject() {
        assertFalse(ObjectUtils.isArray(null));
    }
    
    @Test
    void testIsArrayWithString() {
        assertFalse(ObjectUtils.isArray(""));
    }
    
    @Test
    void testIsArrayWithStringArray() {
        assertTrue(ObjectUtils.isArray(new String[] {}));
    }
    
    @Test
    void testIsArrayWithIntArray() {
        assertTrue(ObjectUtils.isArray(new int[] {1, 2, 3}));
    }
    
    @Test
    void testIsArrayWithInteger() {
        assertFalse(ObjectUtils.isArray(1234));
    }
    
    @Test
    void testIsArrayWithNullPlaceholder() {
        assertFalse(ObjectUtils.isArray(ObjectUtils.NULL));
    }
    
    @Test
    void testIsArrayWithSerializableObject() {
        assertFalse(ObjectUtils.isArray(new Serializable() {}));
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNull;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.Arguments;
    import org.junit.jupiter.params.provider.MethodSource;
    
    import java.util.stream.Stream;
    
    public class ObjectUtilsTest {
    
        @Nested
        @DisplayName("min method")
        class MinMethod {
    
            @Test
            @DisplayName("should return null when no values are provided")
            void shouldReturnNullWhenNoValuesAreProvided() {
                assertNull(ObjectUtils.min());
            }
    
            @Test
            @DisplayName("should return the minimum value when multiple values are provided")
            void shouldReturnMinimumValueWhenMultipleValuesAreProvided() {
                Integer min = ObjectUtils.min(5, 3, 9, 2, 7);
                assertEquals(2, min);
            }
    
            @Test
            @DisplayName("should return the minimum value when only one value is provided")
            void shouldReturnMinimumValueWhenOnlyOneValueIsProvided() {
                Integer min = ObjectUtils.min(5);
                assertEquals(5, min);
            }
        }
    }
    @Test
    void getIfNull_NullObjectAndNullDefaultSupplier_ReturnsNull() {
        Object nullObject = null;
        Supplier<Object> nullSupplier = null;
        Object result = ObjectUtils.getIfNull(nullObject, nullSupplier);
        assertNull(result);
    }
    
    @Test
    void getIfNull_NullObjectAndSupplierReturnsNull_ReturnsNull() {
        Object nullObject = null;
        Supplier<Object> supplier = () -> null;
        Object result = ObjectUtils.getIfNull(nullObject, supplier);
        assertNull(result);
    }
    
    @Test
    void getIfNull_NullObjectAndSupplierReturnsEmptyString_ReturnsEmptyString() {
        Object nullObject = null;
        Supplier<Object> supplier = () -> "";
        Object result = ObjectUtils.getIfNull(nullObject, supplier);
        assertEquals("", result);
    }
    
    @Test
    void getIfNull_NullObjectAndSupplierReturnsZZ_ReturnsZZ() {
        Object nullObject = null;
        Supplier<Object> supplier = () -> "zz";
        Object result = ObjectUtils.getIfNull(nullObject, supplier);
        assertEquals("zz", result);
    }
    
    @Test
    void getIfNull_NonNullObjectAndNullDefaultSupplier_ReturnsObject() {
        Object nonNullObject = "abc";
        Supplier<Object> nullSupplier = null;
        Object result = ObjectUtils.getIfNull(nonNullObject, nullSupplier);
        assertEquals("abc", result);
    }
    
    @Test
    void getIfNull_NonNullObjectAndSupplierReturnsNull_ReturnsObject() {
        Object nonNullObject = "abc";
        Supplier<Object> supplier = () -> null;
        Object result = ObjectUtils.getIfNull(nonNullObject, supplier);
        assertEquals("abc", result);
    }
    
    @Test
    void getIfNull_NonNullObjectAndSupplierReturnsEmptyString_ReturnsObject() {
        Object nonNullObject = "abc";
        Supplier<Object> supplier = () -> "";
        Object result = ObjectUtils.getIfNull(nonNullObject, supplier);
        assertEquals("abc", result);
    }
    
    @Test
    void getIfNull_NonNullObjectAndSupplierReturnsZZ_ReturnsObject() {
        Object nonNullObject = "abc";
        Supplier<Object> supplier = () -> "zz";
        Object result = ObjectUtils.getIfNull(nonNullObject, supplier);
        assertEquals("abc", result);
    }

}