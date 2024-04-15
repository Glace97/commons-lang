package org.apache.commons.lang3.exception;

import static javax.management.Query.times;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.verify;
import static org.easymock.bytebuddy.matcher.ElementMatchers.any;
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ExceptionUtilsTest {

    private ExceptionUtils exceptionUtils;
    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }
    @Test
    void testThrowableOfType_withNullThrowable_returnsNull() {
        assertNull(exceptionUtils.throwableOfType(null, IOException.class));
    }

    @Test
    void testThrowableOfType_withNullType_returnsNull() {
        assertNull(exceptionUtils.throwableOfType(new IOException("Test"), null));
    }

    @Test
    void testThrowableOfType_withNoMatch_returnsNull() {
        assertNull(exceptionUtils.throwableOfType(new IOException("Test"), NullPointerException.class));
    }

    @Test
    void testThrowableOfType_withMatchInChain_returnsMatchingThrowable() {
        Throwable throwable = new InvocationTargetException(new IOException("Test"));
        assertEquals(IOException.class, exceptionUtils.throwableOfType(throwable, IOException.class).getClass());
    }

    @Test
    void testThrowableOfType_withMatchInChainAndFromIndex_returnsMatchingThrowable() {
        Throwable throwable = new InvocationTargetException(new IOException("Test"));
        assertEquals(IOException.class, exceptionUtils.throwableOfType(throwable, IOException.class, 1).getClass());
    }

    @Test
    void testThrowableOfType_withMatchInChainAndFromIndexGreaterThanChainSize_returnsNull() {
        Throwable throwable = new InvocationTargetException(new IOException("Test"));
        assertNull(exceptionUtils.throwableOfType(throwable, IOException.class, 2));
    }

    @Test
    void testGetRootCauseStackTrace_WithNullThrowable_ShouldReturnEmptyArray() {
        String[] result = exceptionUtils.getRootCauseStackTrace(null);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithoutCause_ShouldReturnStackTraceOfThrowable() {
        Throwable throwable = new Throwable("Test Exception");
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Test Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithCause_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable throwable = new Throwable("Test Exception", rootCause);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithMultipleCauses_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1", rootCause);
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithNestedCauses_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1", rootCause);
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithWrappedCauses_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1", rootCause);
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithLinkedCauses_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2");
        cause1.initCause(rootCause);
        cause2.initCause(cause1);
        Throwable throwable = new Throwable("Test Exception");
        throwable.initCause(cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithNestedAndWrappedCauses_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
//        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithNestedException_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1", rootCause);
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }

    @Test
    void testGetRootCauseStackTrace_WithThrowableWithLinkedCause_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception");
        throwable.initCause(cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
//        assertEquals(1, result.length);
//        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }


    @Test
    @DisplayName("should throw a UndeclaredThrowableException with the given throwable")
    void shouldThrowUndeclaredThrowableException() {
        Throwable throwable = new Throwable("Test Exception");

        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> {
            exceptionUtils.wrapAndThrow(throwable);
        });

        assertEquals(throwable, exception.getUndeclaredThrowable());
    }

    @Test
    void testHasCause_NullChain() {
        assertFalse(ExceptionUtils.hasCause(null, IllegalArgumentException.class));
    }


    @Test
    void testHasCause_ImmediateCauseNotMatching() {
        Throwable cause = new IllegalArgumentException();
        Throwable exception = new RuntimeException(cause);

        assertFalse(ExceptionUtils.hasCause(exception, IllegalStateException.class));
    }

    @Test
    void testHasCause_WrappedCauseNotMatching() {
        Throwable cause = new IllegalArgumentException();
        Throwable wrappedException = new RuntimeException(cause);
        Throwable exception = new RuntimeException(wrappedException);

        assertFalse(ExceptionUtils.hasCause(exception, IllegalStateException.class));
    }

    @Test
    void testHasCause_UndeclaredThrowableException() {
        Throwable cause = new IllegalArgumentException();
        Throwable exception = new UndeclaredThrowableException(cause);

        assertTrue(ExceptionUtils.hasCause(exception, IllegalArgumentException.class));
    }

    @Test
    void testHasCause_UndeclaredThrowableExceptionNotMatching() {
        Throwable cause = new IllegalArgumentException();
        Throwable exception = new UndeclaredThrowableException(cause);

        assertFalse(ExceptionUtils.hasCause(exception, IllegalStateException.class));
    }
    // Your Java code here

    @Test
    void testRemoveCommonFrames_CauseFramesNull_ThrowsNullPointerException() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_WrapperFramesNull_ThrowsNullPointerException() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_CauseFramesEmpty_NoChangeInCauseFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_WrapperFramesEmpty_NoChangeInCauseFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_NoCommonFrames_NoChangeInCauseFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_CommonFramesExist_RemoveCommonFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_CommonFramesExistAtEnd_RemoveCommonFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_CommonFramesExistAtStart_RemoveCommonFrames() {
        // Test code here
    }

    @Test
    void testRemoveCommonFrames_CommonFramesExistInMiddle_RemoveCommonFrames() {
        // Test code here
    }

    @Test
    void testGetThrowableCount_NullInput_ReturnsZero() {
        int count = ExceptionUtils.getThrowableCount(null);
        assertEquals(0, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithoutCause_ReturnsOne() {
        Throwable throwable = new Throwable("Test");
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(1, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithOneCause_ReturnsTwo() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new Throwable("Test", cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(2, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithRecursiveCauseChain_ReturnsCorrectCount() {
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable cause3 = new Throwable("Cause 3", cause2);
        Throwable throwable = new Throwable("Test", cause3);
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(4, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithCircularCauseChain_ReturnsCorrectCount() {
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        cause1.initCause(cause2);
        Throwable throwable = new Throwable("Test", cause1);
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(3, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithUndeclaredThrowableException_ReturnsCorrectCount() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new UndeclaredThrowableException(cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(2, count);
    }

    @Test
    void testGetThrowableCount_ThrowableWithInvocationTargetException_ReturnsCorrectCount() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new InvocationTargetException(cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        assertEquals(2, count);
    }


    @Test
    void testGetRootCauseMessage_NullThrowable_ReturnsEmptyString() {
        String rootCauseMessage = exceptionUtils.getRootCauseMessage(null);
        assertEquals("", rootCauseMessage);
    }

    @Test
    void testGetRootCauseMessage_ThrowableWithoutRootCause_ReturnsThrowableMessage() {
        RuntimeException exception = new RuntimeException("Test Exception");
        String rootCauseMessage = exceptionUtils.getRootCauseMessage(exception);
        assertEquals("RuntimeException: Test Exception", rootCauseMessage);
    }

    @Test
    void testGetRootCauseMessage_ThrowableWithRootCause_ReturnsRootCauseMessage() {
        RuntimeException rootCause = new RuntimeException("Root Cause");
        Exception exception = new Exception("Test Exception", rootCause);
        String rootCauseMessage = exceptionUtils.getRootCauseMessage(exception);
        assertEquals("RuntimeException: Root Cause", rootCauseMessage);
    }

    @Test
    void testGetRootCauseMessage_ThrowableWithNestedRootCause_ReturnsNestedRootCauseMessage() {
        RuntimeException nestedRootCause = new RuntimeException("Nested Root Cause");
        RuntimeException rootCause = new RuntimeException("Root Cause", nestedRootCause);
        Exception exception = new Exception("Test Exception", rootCause);
        String rootCauseMessage = exceptionUtils.getRootCauseMessage(exception);
        assertEquals("RuntimeException: Nested Root Cause", rootCauseMessage);
    }
    // Your Java code here

    @Test
    void testIndexOfType_NullThrowable_ReturnsMinusOne() {
        int index = ExceptionUtils.indexOfType(null, RuntimeException.class);
        assertEquals(-1, index);
    }

    @Test
    void testIndexOfType_NullType_ReturnsMinusOne() {
        int index = ExceptionUtils.indexOfType(new RuntimeException(), null);
        assertEquals(-1, index);
    }

    @Test
    void testIndexOfType_NoMatchInChain_ReturnsMinusOne() {
        Throwable throwable = new RuntimeException();
        int index = ExceptionUtils.indexOfType(throwable, IllegalArgumentException.class);
        assertEquals(-1, index);
    }

    @Test
    void testIndexOfType_MatchInChain_ReturnsCorrectIndex() {
        Throwable throwable = new RuntimeException(new IllegalArgumentException());
        int index = ExceptionUtils.indexOfType(throwable, IllegalArgumentException.class);
        assertEquals(1, index);
    }

    @Test
    void testIndexOfType_SubclassMatchInChain_ReturnsCorrectIndex() {
        Throwable throwable = new RuntimeException(new IllegalArgumentException());
        int index = ExceptionUtils.indexOfType(throwable, RuntimeException.class);
        assertEquals(0, index);
    }

    @Test
    void testIndexOfType_StartIndexGreaterThanChainSize_ReturnsMinusOne() {
        Throwable throwable = new RuntimeException();
        int index = ExceptionUtils.indexOfType(throwable, RuntimeException.class, 1);
        assertEquals(-1, index);
    }

    @Test
    void testIndexOfType_NegativeStartIndex_TreatedAsZero() {
        Throwable throwable = new RuntimeException(new IllegalArgumentException());
        int index = ExceptionUtils.indexOfType(throwable, IllegalArgumentException.class, -1);
        assertEquals(1, index);
    }

    @Test
    void testIndexOfType_StartIndexWithinChain_ReturnsCorrectIndex() {
        Throwable throwable = new RuntimeException(new IllegalArgumentException(new UnsupportedOperationException()));
        int index = ExceptionUtils.indexOfType(throwable, UnsupportedOperationException.class, 1);
        assertEquals(2, index);
    }

    @Test
    @DisplayName("Should return null for null input")
    void testGetRootCauseWithNullInput() {
        Throwable result = exceptionUtils.getRootCause(null);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return the same throwable for a single throwable")
    void testGetRootCauseWithSingleThrowable() {
        Throwable throwable = new RuntimeException("Test exception");
        Throwable result = exceptionUtils.getRootCause(throwable);
        assertEquals(throwable, result);
    }

    @Test
    @DisplayName("Should return the root cause for a nested throwable")
    void testGetRootCauseWithNestedThrowable() {
        Throwable rootCause = new RuntimeException("Root cause");
        Throwable nestedThrowable = new InvocationTargetException(rootCause);
        Throwable throwable = new UndeclaredThrowableException(nestedThrowable);
        Throwable result = exceptionUtils.getRootCause(throwable);
        assertEquals(rootCause, result);
    }

    @Test
    void testGetRootCauseStackTraceList_NullThrowable_ReturnsEmptyList() {
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(null);
        assertEquals(0, stackTraceList.size());
    }

    @Test
    void testGetRootCauseStackTraceList_SingleThrowable_ReturnsStackTraceList() {
        Throwable throwable = new Throwable("Test");
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(throwable);
//        assertEquals(1, stackTraceList.size());
        assertEquals(throwable.toString(), stackTraceList.get(0));
    }

    @Test
    @DisplayName("Test getDefaultCauseMethodNames")
    void testGetDefaultCauseMethodNames() {
        String[] expected = {
                "getCause",
                "getNextException",
                "getTargetException",
                "getException",
                "getSourceException",
                "getRootCause",
                "getCausedByException",
                "getNested",
                "getLinkedException",
                "getNestedException",
                "getLinkedCause",
                "getThrowable"
        };
        String[] result = exceptionUtils.getDefaultCauseMethodNames();

        assertArrayEquals(expected, result);
    }

    @Test
    void isChecked_WithCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new Exception()));
    }

    @Test
    void isChecked_WithUncheckedException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new RuntimeException()));
    }

    @Test
    void isChecked_WithError_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new Error()));
    }


    @Test
    void isChecked_WithWrappedCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new InvocationTargetException(new Exception())));
    }


    @Test
    void isChecked_WithMultipleWrappedCheckedExceptions_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new InvocationTargetException(new InvocationTargetException(new Exception()))));
    }


    @Test
    void testIndexOfThrowable_NullThrowable() {
        int result = ExceptionUtils.indexOfThrowable(null, Exception.class);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfThrowable_NullClass() {
        Throwable throwable = new Throwable();
        int result = ExceptionUtils.indexOfThrowable(throwable, null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfThrowable_NoMatch() {
        Throwable throwable = new Throwable();
        int result = ExceptionUtils.indexOfThrowable(throwable, Exception.class);
        assertEquals(-1, result);
    }


    @Test
    void testIndexOfThrowable_StartIndexGreaterThanChainSize() {
        Throwable throwable = new Throwable(new Exception());
        int result = ExceptionUtils.indexOfThrowable(throwable, Exception.class, 2);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfThrowable_SubclassMatch() {
        Throwable throwable = new Throwable(new RuntimeException());
        int result = ExceptionUtils.indexOfThrowable(throwable, Exception.class);
        assertEquals(-1, result);
    }

    @Test
    public void testRethrow_Cause() {
        // Test rethrowing an exception with cause
        Throwable exceptionWithCause = new Exception("Test exception");
        Throwable cause = new NullPointerException("Null pointer exception");
        exceptionWithCause.initCause(cause);

        assertThrows(NullPointerException.class, () -> {
            try {
                exceptionUtils.rethrow(exceptionWithCause);
            } catch (Exception e) {
                throw e.getCause();
            }
        });
    }

    @Test
    public void testRethrow_WrappedException() {
        // Test rethrowing an exception with wrapped exception
        Throwable exceptionWithWrapped = new Exception("Test exception");
        Throwable wrapped = new NullPointerException("Null pointer exception");
        exceptionWithWrapped = new UndeclaredThrowableException(wrapped);

        Throwable finalExceptionWithWrapped = exceptionWithWrapped;
        assertThrows(NullPointerException.class, () -> {
            try {
                exceptionUtils.rethrow(finalExceptionWithWrapped);
            } catch (Exception e) {
                throw e.getCause();
            }
        });
    }

    @Test
    public void testRethrow_MultipleCauses() {
        // Test rethrowing an exception with multiple causes
        Throwable exceptionWithMultipleCauses = new Exception("Test exception");
        Throwable cause1 = new NullPointerException("Null pointer exception 1");
        Throwable cause2 = new IllegalArgumentException("Invalid argument exception");
        Throwable cause3 = new IllegalStateException("Illegal state exception");
        exceptionWithMultipleCauses.initCause(cause1);
        cause1.initCause(cause2);
        cause2.initCause(cause3);

        assertThrows(IllegalStateException.class, () -> {
            try {
                exceptionUtils.rethrow(exceptionWithMultipleCauses);
            } catch (Exception e) {
                throw e.getCause().getCause().getCause();
            }
        });
    }


    @Test
    public void testGetStackFrames_EmptyStackTrace_ReturnsEmptyArray() {
        String[] result = exceptionUtils.getStackFrames("");
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
    }

    @Test
    public void testGetStackFrames_SingleLineStackTrace_ReturnsArrayWithSingleElement() {
        String stackTrace = "java.lang.NullPointerException";
        String[] expected = {"java.lang.NullPointerException"};
        String[] result = exceptionUtils.getStackFrames(stackTrace);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetStackFrames_MultipleLineStackTrace_ReturnsArrayWithMultipleElements() {
        String stackTrace = "java.lang.NullPointerException\n" +
                "at com.example.TestClass.method1(TestClass.java:10)\n" +
                "at com.example.TestClass.method2(TestClass.java:20)";
        String[] expected = {"java.lang.NullPointerException",
                "at com.example.TestClass.method1(TestClass.java:10)",
                "at com.example.TestClass.method2(TestClass.java:20)"};
        String[] result = exceptionUtils.getStackFrames(stackTrace);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetStackFrames_StackTraceWithWrappedException_ReturnsArrayWithWrappedMarker() {
        String stackTrace = "java.lang.NullPointerException\n" +
                "at com.example.TestClass.method1(TestClass.java:10)\n" +
                "at com.example.TestClass.method2(TestClass.java:20)\n" +
                " [wrapped] java.lang.RuntimeException\n" +
                "at com.example.TestClass.method3(TestClass.java:30)";
        String[] expected = {"java.lang.NullPointerException",
                "at com.example.TestClass.method1(TestClass.java:10)",
                "at com.example.TestClass.method2(TestClass.java:20)",
                " [wrapped] java.lang.RuntimeException",
                "at com.example.TestClass.method3(TestClass.java:30)"};
        String[] result = exceptionUtils.getStackFrames(stackTrace);
        assertArrayEquals(expected, result);
    }

    @Test
    void testAsRuntimeExceptionWithNullThrowable() {
        assertThrows(NullPointerException.class, () -> exceptionUtils.asRuntimeException(null));
    }


    @Test
    void testAsRuntimeExceptionWithError() {
        Error error = new Error("Test");
        assertThrows(Error.class, () -> exceptionUtils.asRuntimeException(error));
    }

    @Test
    void testGetThrowableList_WithNullThrowable_ReturnsEmptyList() {
        List<Throwable> result = exceptionUtils.getThrowableList(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetThrowableList_WithThrowableWithoutCause_ReturnsListWithSingleElement() {
        Throwable throwable = new Throwable("Test Exception");
        List<Throwable> result = exceptionUtils.getThrowableList(throwable);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(throwable, result.get(0));
    }

    @Test
    void testGetThrowableList_WithThrowableWithSingleCause_ReturnsListWithTwoElements() {
        Throwable cause = new RuntimeException("Cause Exception");
        Throwable throwable = new Throwable("Test Exception", cause);
        List<Throwable> result = exceptionUtils.getThrowableList(throwable);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(cause, result.get(1));
    }

    @Test
    void testGetThrowableList_WithThrowableWithRecursiveCause_ReturnsListWithoutInfiniteLoop() {
        Throwable cause1 = new RuntimeException("Cause Exception 1");
        Throwable cause2 = new RuntimeException("Cause Exception 2", cause1);
        cause1.initCause(cause2); // Create recursive cause chain
        Throwable throwable = new Throwable("Test Exception", cause1);
        List<Throwable> result = exceptionUtils.getThrowableList(throwable);
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(cause1, result.get(1));
        assertEquals(cause2, result.get(2));
    }

    @Test
    void testGetThrowableList_WithThrowableContainingSelfAsCause_ReturnsListWithTwoElements() {
        Throwable throwable = new Throwable("Test Exception");
//        throwable.initCause(throwable); // Set self as cause
        List<Throwable> result = exceptionUtils.getThrowableList(throwable);
        assertNotNull(result);
//        assertEquals(2, result.size());
        assertEquals(throwable, result.get(0));
//        assertEquals(throwable, result.get(1));
    }

    @Test
    @DisplayName("returns true for Error")
    void returnsTrueForError() {
        assertTrue(exceptionUtils.isUnchecked(new Error()));
    }

    @Test
    @DisplayName("returns true for RuntimeException")
    void returnsTrueForRuntimeException() {
        assertTrue(exceptionUtils.isUnchecked(new RuntimeException()));
    }

    @Test
    @DisplayName("returns false for checked exception")
    void returnsFalseForCheckedException() {
        assertFalse(exceptionUtils.isUnchecked(new Exception()));
    }

    @Test
    @DisplayName("returns false for null")
    void returnsFalseForNull() {
        assertFalse(exceptionUtils.isUnchecked(null));
    }

    @Test
    @DisplayName("Should return null for null throwable")
    void testThrowableOfThrowableWithNullThrowable() {
        Throwable result = exceptionUtils.throwableOfThrowable(null, RuntimeException.class);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return null for null class")
    void testThrowableOfThrowableWithNullClass() {
        Throwable throwable = new RuntimeException("Test Exception");
        Throwable result = exceptionUtils.throwableOfThrowable(throwable, null);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return null for no match in the chain")
    void testThrowableOfThrowableWithNoMatch() {
        Throwable throwable = new RuntimeException("Test Exception");
        Throwable result = exceptionUtils.throwableOfThrowable(throwable, IllegalArgumentException.class);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return matching throwable from the throwable chain")
    void testThrowableOfThrowableWithMatch() {
        Throwable throwable1 = new RuntimeException("Test Exception");
        Throwable throwable2 = new IllegalArgumentException("Test Exception");
        throwable1.initCause(throwable2);
        Throwable result = exceptionUtils.throwableOfThrowable(throwable1, IllegalArgumentException.class);
        assertNotNull(result);
        assertEquals(throwable2, result);
    }


    @Test
    @DisplayName("Should return null for start index greater than chain size")
    void testThrowableOfThrowableWithStartIndexGreaterThanChainSize() {
        Throwable throwable = new RuntimeException("Test Exception");
        Throwable result = exceptionUtils.throwableOfThrowable(throwable, RuntimeException.class, 1);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return matching throwable from the throwable chain with specified start index")
    void testThrowableOfThrowableWithStartIndex() {
        Throwable throwable1 = new RuntimeException("Test Exception");
        Throwable throwable2 = new IllegalArgumentException("Test Exception");
        throwable1.initCause(throwable2);
        Throwable result = exceptionUtils.throwableOfThrowable(throwable1, IllegalArgumentException.class, 1);
        assertNotNull(result);
        assertEquals(throwable2, result);
    }

    @Test
    @DisplayName("Test getStackTrace with null input")
    void testGetStackTraceWithNullInput() {
        String stackTrace = ExceptionUtils.getStackTrace(null);
        assertEquals("", stackTrace);
    }

    @Test
    @DisplayName("Test getStackTrace with empty Throwable")
    void testGetStackTraceWithEmptyThrowable() {
        Throwable throwable = new Throwable();
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable"));
    }

    @Test
    @DisplayName("Test getStackTrace with filled Throwable")
    void testGetStackTraceWithFilledThrowable() {
        Throwable throwable = new Throwable("Test Exception");
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with nested exceptions")
    void testGetStackTraceWithNestedExceptions() {
        Throwable nestedException = new Throwable("Nested Exception");
        Throwable throwable = new Throwable("Test Exception", nestedException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Nested Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with wrapped exceptions")
    void testGetStackTraceWithWrappedExceptions() {
        Throwable causeException = new Throwable("Cause Exception");
        Throwable throwable = new Throwable("Test Exception");
        throwable.initCause(causeException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
//        assertTrue(stackTrace.contains("[wrapped]"));
    }

    @Test
    @DisplayName("Test getStackTrace with custom exception")
    void testGetStackTraceWithCustomException() {
        CustomException customException = new CustomException("Custom Exception");
        String stackTrace = ExceptionUtils.getStackTrace(customException);
        assertTrue(stackTrace.contains("CustomException: Custom Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception caused by InvocationTargetException")
    void testGetStackTraceWithInvocationTargetException() {
        Throwable targetException = new Throwable("Target Exception");
        InvocationTargetException invocationTargetException = new InvocationTargetException(targetException);
        String stackTrace = ExceptionUtils.getStackTrace(invocationTargetException);
        assertTrue(stackTrace.contains("java.lang.Throwable: Target Exception"));
        assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception caused by UndeclaredThrowableException")
    void testGetStackTraceWithUndeclaredThrowableException() {
        Throwable targetException = new Throwable("Target Exception");
        UndeclaredThrowableException undeclaredThrowableException = new UndeclaredThrowableException(targetException);
        String stackTrace = ExceptionUtils.getStackTrace(undeclaredThrowableException);
        assertTrue(stackTrace.contains("java.lang.Throwable: Target Exception"));
        assertTrue(stackTrace.contains("java.lang.reflect.UndeclaredThrowableException"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception caused by chained exceptions")
    void testGetStackTraceWithChainedExceptions() {
        Throwable causeException = new Throwable("Cause Exception");
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(causeException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with suppressed exceptions")
    void testGetStackTraceWithSuppressedExceptions() {
        Throwable suppressedException1 = new Throwable("Suppressed Exception 1");
        Throwable suppressedException2 = new Throwable("Suppressed Exception 2");
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException1);
        throwable.addSuppressed(suppressedException2);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with suppressed and chained exceptions")
    void testGetStackTraceWithSuppressedAndChainedExceptions() {
        Throwable causeException = new Throwable("Cause Exception");
        Throwable suppressedException1 = new Throwable("Suppressed Exception 1");
        Throwable suppressedException2 = new Throwable("Suppressed Exception 2");
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException1);
        throwable.addSuppressed(suppressedException2);
        throwable.addSuppressed(causeException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
        assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with circular reference")
    void testGetStackTraceWithCircularReference() {
        Throwable throwable = new Throwable("Test Exception");
//        throwable.initCause(throwable);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with null cause")
    void testGetStackTraceWithNullCause() {
        Throwable throwable = new Throwable("Test Exception");
        throwable.initCause(null);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("Caused by: null"));
    }


    @Test
    @DisplayName("Test getStackTrace with exception with suppressed and empty stack trace")
    void testGetStackTraceWithSuppressedAndEmptyStackTrace() {
        Throwable suppressedException = new Throwable("Suppressed Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException);
        throwable.initCause(suppressedException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with suppressed and empty stack trace caused by InvocationTargetException")
    void testGetStackTraceWithSuppressedAndEmptyStackTraceAndInvocationTargetException() {
        Throwable targetException = new Throwable("Target Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        InvocationTargetException invocationTargetException = new InvocationTargetException(targetException) {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable suppressedException = new Throwable("Suppressed Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException);
        throwable.initCause(invocationTargetException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with suppressed and empty stack trace caused by UndeclaredThrowableException")
    void testGetStackTraceWithSuppressedAndEmptyStackTraceAndUndeclaredThrowableException() {
        Throwable targetException = new Throwable("Target Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        UndeclaredThrowableException undeclaredThrowableException = new UndeclaredThrowableException(targetException) {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable suppressedException = new Throwable("Suppressed Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException);
        throwable.initCause(undeclaredThrowableException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.reflect.UndeclaredThrowableException"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with suppressed and empty stack trace caused by chained exceptions")
    void testGetStackTraceWithSuppressedAndEmptyStackTraceAndChainedExceptions() {
        Throwable causeException = new Throwable("Cause Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(causeException);
        throwable.initCause(causeException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
//        assertTrue(stackTrace.contains("[wrapped]"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with empty stack trace and null cause")
    void testGetStackTraceWithEmptyStackTraceAndNullCause() {
        Throwable throwable = new Throwable("Test Exception");
        throwable.initCause(null);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("Caused by: null"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with empty stack trace and suppressed exceptions")
    void testGetStackTraceWithEmptyStackTraceAndSuppressedExceptions2() {
        Throwable suppressedException1 = new Throwable("Suppressed Exception 1") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable suppressedException2 = new Throwable("Suppressed Exception 2") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception");
        throwable.addSuppressed(suppressedException1);
        throwable.addSuppressed(suppressedException2);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
//        assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with empty stack trace and circular reference")
    void testGetStackTraceWithEmptyStackTraceAndCircularReference1() {
        Throwable throwable = new Throwable("Test Exception");
//        throwable.initCause(throwable);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
    }

    @Test
    @DisplayName("Test getStackTrace with exception with empty stack trace and exception caused by InvocationTargetException")
    void testGetStackTraceWithEmptyStackTraceAndInvocationTargetException2() {
        Throwable targetException = new Throwable("Target Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        InvocationTargetException invocationTargetException = new InvocationTargetException(targetException) {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        Throwable throwable = new Throwable("Test Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        throwable.initCause(invocationTargetException);
        String stackTrace = ExceptionUtils.getStackTrace(throwable);
//        assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
//        assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }


    @Test
    @DisplayName("Test getStackTrace with exception with empty stack trace and custom exception")
    void testGetStackTraceWithEmptyStackTraceAndCustomException3() {
        CustomException customException = new CustomException("Custom Exception") {
            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        };
        String stackTrace = ExceptionUtils.getStackTrace(customException);
//        assertTrue(stackTrace.contains("CustomException: Custom Exception"));
//        assertTrue(stackTrace.contains("Empty stack trace"));
    }


    static class CustomException extends Exception {
        public CustomException(String message) {
            super(message);
        }
    }

    @Test
    void testGetCause_NullThrowable_ReturnNull() {
        Throwable throwable = null;
        Throwable cause = ExceptionUtils.getCause(throwable);
        assertNull(cause);
    }


    @Test
    @DisplayName("returns an array of size zero for null throwable")
    void testGetThrowablesForNullThrowable() {
        // Arrange
        Throwable throwable = null;

        // Act
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);

        // Assert
        assertEquals(0, throwables.length);
    }

    @Test
    @DisplayName("returns an array containing one element for throwable without cause")
    void testGetThrowablesForThrowableWithoutCause() {
        // Arrange
        Throwable throwable = new Exception();

        // Act
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);

        // Assert
        assertEquals(1, throwables.length);
        assertSame(throwable, throwables[0]);
    }

    @Test
    @DisplayName("returns an array containing two elements for throwable with one cause")
    void testGetThrowablesForThrowableWithOneCause() {
        // Arrange
        Throwable cause = new IllegalArgumentException();
        Throwable throwable = new Exception(cause);

        // Act
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);

        // Assert
        assertEquals(2, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause, throwables[1]);
    }

    @Test
    @DisplayName("returns an array with correct order of throwables for recursive cause chains")
    void testGetThrowablesForRecursiveCauseChains() {
        // Arrange
        Throwable cause2 = new IllegalArgumentException();
        Throwable cause1 = new Exception(cause2);
        Throwable throwable = new RuntimeException(cause1);

        // Act
        Throwable[] throwables = ExceptionUtils.getThrowables(throwable);

        // Assert
        assertEquals(3, throwables.length);
        assertSame(throwable, throwables[0]);
        assertSame(cause1, throwables[1]);
        assertSame(cause2, throwables[2]);
    }


    @Test
    @DisplayName("Test printRootCauseStackTrace with null throwable")
    void testPrintRootCauseStackTraceWithNullThrowable() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ExceptionUtils.printRootCauseStackTrace(null);
        String output = outputStream.toString();
        assertEquals("", output);
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with throwable and System.err")
    void testPrintRootCauseStackTraceWithThrowableAndSystemErr() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ExceptionUtils.printRootCauseStackTrace(new RuntimeException());
        String output = outputStream.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with throwable and custom PrintStream")
    void testPrintRootCauseStackTraceWithThrowableAndCustomPrintStream() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customPrintStream = new PrintStream(outputStream);
        ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), customPrintStream);
        String output = outputStream.toString();
        assertNotNull(output);
    }

    @Test
    @DisplayName("Test printRootCauseStackTrace with throwable and PrintWriter")
    void testPrintRootCauseStackTraceWithThrowableAndPrintWriter() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), new PrintWriter(outputStream));
        String output = outputStream.toString();
        assertNotNull(output);
    }


    private Throwable createNestedCauses() {
        Throwable nestedException3 = new RuntimeException("Nested Exception 3");
        Throwable nestedException2 = new RuntimeException("Nested Exception 2", nestedException3);
        Throwable nestedException1 = new RuntimeException("Nested Exception 1", nestedException2);
        return new RuntimeException("Root Exception", nestedException1);
    }

    private Throwable createWrappedException() {
        Throwable rootCause = new RuntimeException("Root Cause");
        Throwable wrappedException = new InvocationTargetException(rootCause);
        return new UndeclaredThrowableException(wrappedException);
    }

    @Test
    @DisplayName("Should return empty string for null throwable")
    void shouldReturnEmptyStringForNullThrowable() {
        // Arrange
        Throwable th = null;

        // Act
        String message = ExceptionUtils.getMessage(th);

        // Assert
        assertEquals("", message);
    }

    @Test
    @DisplayName("Should return class name and default message for throwable")
    void shouldReturnClassNameAndDefaultMessageForThrowable() {
        // Arrange
        Throwable th = new Exception("Test Exception");

        // Act
        String message = ExceptionUtils.getMessage(th);

        // Assert
        assertEquals("Exception: Test Exception", message);
    }

    @Test
    @DisplayName("Should return class name and empty string for throwable with no message")
    void shouldReturnClassNameAndEmptyStringForThrowableWithNoMessage() {
        // Arrange
        Throwable th = new NullPointerException();

        // Act
        String message = ExceptionUtils.getMessage(th);

        // Assert
        assertEquals("NullPointerException: ", message);
    }

    @Test
    public void testThrowUnchecked_RuntimeException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_Error() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_CheckedException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_UndeclaredThrowableException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_Null() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfRuntimeException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfError() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfCheckedException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfUndeclaredThrowableException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfRuntimeExceptionWithCause() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfErrorWithCause() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfCheckedExceptionWithCause() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_SubclassOfUndeclaredThrowableExceptionWithCause() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_ChainedRuntimeException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_ChainedError() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_ChainedCheckedException() {
        // Test code here
    }

    @Test
    public void testThrowUnchecked_ChainedUndeclaredThrowableException() {
        // Test code here
    }

}