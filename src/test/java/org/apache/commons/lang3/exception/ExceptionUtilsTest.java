package org.apache.commons.lang3.exception;

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

public class ExceptionUtilsTest {
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
    void forEach_WithThrowableWithoutCause_ShouldInvokeConsumerOnce() {
        // Arrange
        Throwable throwable = new Throwable();
    
        // Act
        exceptionUtils.forEach(throwable, mockConsumer);
    
        // Assert
        verify(mockConsumer, times(1)).accept(throwable);
    }
    
    @Test
    void forEach_WithThrowableWithOneCause_ShouldInvokeConsumerTwice() {
        // Arrange
        Throwable cause = new Throwable();
        Throwable throwable = new Throwable(cause);
    
        // Act
        exceptionUtils.forEach(throwable, mockConsumer);
    
        // Assert
        InOrder inOrder = inOrder(mockConsumer);
        inOrder.verify(mockConsumer).accept(throwable);
        inOrder.verify(mockConsumer).accept(cause);
    }
    
    @Test
    void forEach_WithNullThrowable_ShouldNotInvokeConsumer() {
        // Arrange
        Throwable throwable = null;
    
        // Act
        exceptionUtils.forEach(throwable, mockConsumer);
    
        // Assert
        verify(mockConsumer, never()).accept(any());
    }
    
    @Test
    void forEach_WithRecursiveCauseStructure_ShouldNotCauseInfiniteLoop() {
        // Arrange
        Throwable cause1 = new Throwable();
        Throwable cause2 = new Throwable(cause1);
        cause1.initCause(cause2);
    
        // Act
        exceptionUtils.forEach(cause1, mockConsumer);
    
        // Assert
        verify(mockConsumer, times(2)).accept(any());
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
        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Test Exception", result[0]);
    }
    
    @Test
    void testGetRootCauseStackTrace_WithThrowableWithCause_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable throwable = new Throwable("Test Exception", rootCause);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }
    
    @Test
    void testGetRootCauseStackTrace_WithThrowableWithLinkedException_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception");
        throwable.setCause(cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }
    
    @Test
    void testGetRootCauseStackTrace_WithThrowableWithNestedException_ShouldReturnStackTraceOfRootCause() {
        Throwable rootCause = new Throwable("Root Cause Exception");
        Throwable cause1 = new Throwable("Cause 1", rootCause);
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable throwable = new Throwable("Test Exception", cause2);
        String[] result = exceptionUtils.getRootCauseStackTrace(throwable);
        assertNotNull(result);
        assertEquals(1, result.length);
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
        assertEquals(1, result.length);
        assertEquals("java.lang.Throwable: Root Cause Exception", result[0]);
    }
    import org.junit.jupiter.api.Test;
    
    @Test
    void testGetStackFrameList_EmptyThrowable_ReturnsEmptyList() {
        List<String> stackFrameList = ExceptionUtils.getStackFrameList(new Throwable());
        assertTrue(stackFrameList.isEmpty());
    }
    
    @Test
    void testGetStackFrameList_SingleStackTrace_ReturnsSingleFrame() {
        Throwable throwable = createThrowableWithStackTrace("at com.example.MyClass.myMethod(MyClass.java:10)");
        List<String> stackFrameList = ExceptionUtils.getStackFrameList(throwable);
        assertEquals(1, stackFrameList.size());
        assertEquals("at com.example.MyClass.myMethod(MyClass.java:10)", stackFrameList.get(0));
    }
    
    @Test
    void testGetStackFrameList_MultipleStackTraces_ReturnsAllFrames() {
        Throwable throwable = createThrowableWithStackTrace(
                "at com.example.MyClass.myMethod1(MyClass.java:10)",
                "at com.example.MyClass.myMethod2(MyClass.java:20)",
                "at com.example.MyClass.myMethod3(MyClass.java:30)"
        );
        List<String> stackFrameList = ExceptionUtils.getStackFrameList(throwable);
        assertEquals(3, stackFrameList.size());
        assertEquals("at com.example.MyClass.myMethod1(MyClass.java:10)", stackFrameList.get(0));
        assertEquals("at com.example.MyClass.myMethod2(MyClass.java:20)", stackFrameList.get(1));
        assertEquals("at com.example.MyClass.myMethod3(MyClass.java:30)", stackFrameList.get(2));
    }
    
    @Test
    void testGetStackFrameList_StackTraceWithWrappedException_ReturnsFramesUpToWrappedException() {
        Throwable throwable = createThrowableWithStackTrace(
                "at com.example.MyClass.myMethod1(MyClass.java:10)",
                "at com.example.MyClass.myMethod2(MyClass.java:20)",
                ExceptionUtils.WRAPPED_MARKER,
                "at com.example.MyClass.myMethod3(MyClass.java:30)",
                "at com.example.MyClass.myMethod4(MyClass.java:40)"
        );
        List<String> stackFrameList = ExceptionUtils.getStackFrameList(throwable);
        assertEquals(2, stackFrameList.size());
        assertEquals("at com.example.MyClass.myMethod1(MyClass.java:10)", stackFrameList.get(0));
        assertEquals("at com.example.MyClass.myMethod2(MyClass.java:20)", stackFrameList.get(1));
    }
    
    @Test
    void testGetStackFrameList_StackTraceWithNoFrames_ReturnsEmptyList() {
        Throwable throwable = createThrowableWithStackTrace("");
        List<String> stackFrameList = ExceptionUtils.getStackFrameList(throwable);
        assertTrue(stackFrameList.isEmpty());
    }
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    
    import java.io.IOException;
    import java.lang.reflect.InvocationTargetException;
    import java.lang.reflect.Method;
    import java.lang.reflect.UndeclaredThrowableException;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @Nested
    @DisplayName("ExceptionUtilsTest")
    class ExceptionUtilsTest {
    
        private ExceptionUtils exceptionUtils;
    
        @BeforeEach
        void setUp() {
            exceptionUtils = new ExceptionUtils();
        }
    
        @Nested
        @DisplayName("wrapAndThrow method")
        class WrapAndThrowMethod {
    
            @Test
            @DisplayName("should throw a UndeclaredThrowableException with the given throwable")
            void shouldThrowUndeclaredThrowableException() {
                Throwable throwable = new Throwable("Test Exception");
    
                UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> {
                    exceptionUtils.wrapAndThrow(throwable);
                });
    
                assertEquals(throwable, exception.getUndeclaredThrowable());
            }
    
        }
    }
    @Test
    void testHasCause_ImmediateCause() {
        Throwable cause = new IllegalArgumentException();
        Throwable exception = new RuntimeException(cause);
    
        assertTrue(ExceptionUtils.hasCause(exception, IllegalArgumentException.class));
    }
    
    @Test
    void testHasCause_WrappedCause() {
        Throwable cause = new IllegalArgumentException();
        Throwable wrappedException = new RuntimeException(cause);
        Throwable exception = new RuntimeException(wrappedException);
    
        assertTrue(ExceptionUtils.hasCause(exception, IllegalArgumentException.class));
    }
    
    @Test
    void testHasCause_NullChain() {
        assertFalse(ExceptionUtils.hasCause(null, IllegalArgumentException.class));
    }
    
    @Test
    void testHasCause_NullType() {
        Throwable exception = new RuntimeException();
    
        assertFalse(ExceptionUtils.hasCause(exception, null));
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
    
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class ExceptionUtilsTest {
    
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
    }
    @Test
    void testGetThrowableCount_NullInput_ReturnsZero() {
        int count = ExceptionUtils.getThrowableCount(null);
        Assertions.assertEquals(0, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithoutCause_ReturnsOne() {
        Throwable throwable = new Throwable("Test");
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(1, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithOneCause_ReturnsTwo() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new Throwable("Test", cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(2, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithRecursiveCauseChain_ReturnsCorrectCount() {
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        Throwable cause3 = new Throwable("Cause 3", cause2);
        Throwable throwable = new Throwable("Test", cause3);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(4, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithCircularCauseChain_ReturnsCorrectCount() {
        Throwable cause1 = new Throwable("Cause 1");
        Throwable cause2 = new Throwable("Cause 2", cause1);
        cause1.initCause(cause2);
        Throwable throwable = new Throwable("Test", cause1);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(3, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithUndeclaredThrowableException_ReturnsCorrectCount() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new UndeclaredThrowableException(cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(2, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithInvocationTargetException_ReturnsCorrectCount() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new InvocationTargetException(cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(2, count);
    }
    
    @Test
    void testGetThrowableCount_ThrowableWithCustomCauseMethod_ReturnsCorrectCount() {
        Throwable cause = new Throwable("Cause");
        Throwable throwable = new CustomThrowable("Test", cause);
        int count = ExceptionUtils.getThrowableCount(throwable);
        Assertions.assertEquals(2, count);
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
    
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    class ExceptionUtilsTest {
    
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
    }
    @Test
    void testStreamWithNoCause() {
        Throwable throwable = new Throwable();
        Stream<Throwable> stream = ExceptionUtils.stream(throwable);
        
        assertEquals(1, stream.count());
    }
    
    @Test
    void testStreamWithOneCause() {
        Throwable cause = new IOException();
        Throwable throwable = new Throwable(cause);
        Stream<Throwable> stream = ExceptionUtils.stream(throwable);
        
        assertEquals(2, stream.count());
    }
    
    @Test
    void testStreamWithRecursiveCauseChain() {
        Throwable cause1 = new Exception();
        Throwable cause2 = new IOException(cause1);
        Throwable throwable = new Throwable(cause2);
        Stream<Throwable> stream = ExceptionUtils.stream(throwable);
        
        assertEquals(3, stream.count());
    }
    
    @Test
    void testStreamWithNullThrowable() {
        Throwable throwable = null;
        Stream<Throwable> stream = ExceptionUtils.stream(throwable);
        
        assertEquals(0, stream.count());
    }
    // Your Java code here
    
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
    @DisplayName("Should return the root cause for a deeply nested throwable")
    void testGetRootCauseWithDeeplyNestedThrowable() {
        Throwable rootCause = new RuntimeException("Root cause");
        Throwable nestedThrowable1 = new InvocationTargetException(new RuntimeException());
        Throwable nestedThrowable2 = new UndeclaredThrowableException(nestedThrowable1);
        Throwable nestedThrowable3 = new InvocationTargetException(nestedThrowable2);
        Throwable throwable = new UndeclaredThrowableException(nestedThrowable3);
        Throwable result = exceptionUtils.getRootCause(throwable);
        assertEquals(rootCause, result);
    }
    
    @Test
    @DisplayName("Should handle a loop in the throwable chain")
    void testGetRootCauseWithLoopInThrowableChain() {
        Throwable loopedThrowable = new RuntimeException("Looped throwable");
        Throwable throwable1 = new InvocationTargetException(loopedThrowable);
        Throwable throwable2 = new UndeclaredThrowableException(throwable1);
        loopedThrowable.initCause(throwable2); // Create a loop in the throwable chain
        Throwable result = exceptionUtils.getRootCause(throwable2);
        assertEquals(throwable2, result);
    }
    
    @Test
    @DisplayName("Should handle a loop in the throwable chain with multiple wrapped markers")
    void testGetRootCauseWithLoopInThrowableChainAndMultipleWrappedMarkers() {
        Throwable loopedThrowable = new RuntimeException("Looped throwable");
        Throwable throwable1 = new InvocationTargetException(loopedThrowable);
        Throwable throwable2 = new UndeclaredThrowableException(throwable1);
        loopedThrowable.initCause(throwable2); // Create a loop in the throwable chain
        Throwable throwable3 = new InvocationTargetException(throwable2);
        Throwable throwable4 = new UndeclaredThrowableException(throwable3);
        throwable3.initCause(throwable4); // Create another loop in the throwable chain
        Throwable result = exceptionUtils.getRootCause(throwable3);
        assertEquals(throwable3, result);
    }
    
    @Test
    @DisplayName("Should handle a null cause in the throwable chain")
    void testGetRootCauseWithNullCauseInThrowableChain() {
        Throwable throwable1 = new InvocationTargetException(null);
        Throwable throwable2 = new UndeclaredThrowableException(throwable1);
        Throwable result = exceptionUtils.getRootCause(throwable2);
        assertEquals(throwable2, result);
    }
    
    @Test
    @DisplayName("Should handle a null cause in the throwable chain with multiple wrapped markers")
    void testGetRootCauseWithNullCauseInThrowableChainAndMultipleWrappedMarkers() {
        Throwable throwable1 = new InvocationTargetException(null);
        Throwable throwable2 = new UndeclaredThrowableException(throwable1);
        Throwable throwable3 = new InvocationTargetException(throwable2);
        Throwable throwable4 = new UndeclaredThrowableException(throwable3);
        Throwable result = exceptionUtils.getRootCause(throwable4);
        assertEquals(throwable4, result);
    }
    @Test
    void testGetRootCauseStackTraceList_NullThrowable_ReturnsEmptyList() {
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(null);
        Assertions.assertEquals(0, stackTraceList.size());
    }
    
    @Test
    void testGetRootCauseStackTraceList_SingleThrowable_ReturnsStackTraceList() {
        Throwable throwable = new Throwable("Test");
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(throwable);
        Assertions.assertEquals(1, stackTraceList.size());
        Assertions.assertEquals(throwable.toString(), stackTraceList.get(0));
    }
    
    @Test
    void testGetRootCauseStackTraceList_MultipleThrowables_ReturnsStackTraceListWithWrappedMarkers() {
        Throwable throwable1 = new Throwable("Test1");
        Throwable throwable2 = new Throwable("Test2", throwable1);
        Throwable throwable3 = new Throwable("Test3", throwable2);
    
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(throwable3);
    
        Assertions.assertEquals(5, stackTraceList.size());
        Assertions.assertEquals(throwable3.toString(), stackTraceList.get(0));
        Assertions.assertEquals(ExceptionUtils.WRAPPED_MARKER + throwable2.toString(), stackTraceList.get(1));
        Assertions.assertEquals(ExceptionUtils.WRAPPED_MARKER + throwable1.toString(), stackTraceList.get(2));
        Assertions.assertEquals(throwable2.toString(), stackTraceList.get(3));
        Assertions.assertEquals(throwable1.toString(), stackTraceList.get(4));
    }
    
    @Test
    void testGetRootCauseStackTraceList_ThrowablesWithCommonFrames_RemovesCommonFrames() {
        Throwable throwable1 = new Throwable("Test1");
        Throwable throwable2 = new Throwable("Test2", throwable1);
    
        StackTraceElement[] stackTrace1 = new StackTraceElement[2];
        stackTrace1[0] = new StackTraceElement("Class1", "Method1", "File1", 1);
        stackTrace1[1] = new StackTraceElement("Class2", "Method2", "File2", 2);
        throwable1.setStackTrace(stackTrace1);
    
        StackTraceElement[] stackTrace2 = new StackTraceElement[3];
        stackTrace2[0] = new StackTraceElement("Class1", "Method1", "File1", 1);
        stackTrace2[1] = new StackTraceElement("Class2", "Method2", "File2", 2);
        stackTrace2[2] = new StackTraceElement("Class3", "Method3", "File3", 3);
        throwable2.setStackTrace(stackTrace2);
    
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(throwable2);
    
        Assertions.assertEquals(4, stackTraceList.size());
        Assertions.assertEquals(throwable2.toString(), stackTraceList.get(0));
        Assertions.assertEquals(ExceptionUtils.WRAPPED_MARKER + throwable1.toString(), stackTraceList.get(1));
        Assertions.assertEquals("Class3.Method3(File3:3)", stackTraceList.get(2));
        Assertions.assertEquals("Class2.Method2(File2:2)", stackTraceList.get(3));
    }
    
    @Test
    void testGetRootCauseStackTraceList_ThrowablesWithNoStackTrace_ReturnsStackTraceListWithoutStackTraceElements() {
        Throwable throwable1 = new Throwable("Test1");
        Throwable throwable2 = new Throwable("Test2", throwable1);
    
        throwable1.setStackTrace(new StackTraceElement[0]);
        throwable2.setStackTrace(new StackTraceElement[0]);
    
        List<String> stackTraceList = ExceptionUtils.getRootCauseStackTraceList(throwable2);
    
        Assertions.assertEquals(3, stackTraceList.size());
        Assertions.assertEquals(throwable2.toString(), stackTraceList.get(0));
        Assertions.assertEquals(ExceptionUtils.WRAPPED_MARKER + throwable1.toString(), stackTraceList.get(1));
        Assertions.assertEquals("", stackTraceList.get(2));
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
    @DisplayName("Test getDefaultCauseMethodNames - Cloned Array")
    void testGetDefaultCauseMethodNamesClonedArray() {
        String[] result = exceptionUtils.getDefaultCauseMethodNames();
    
        assertNotSame(exceptionUtils.CAUSE_METHOD_NAMES, result);
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
    void isChecked_WithNull_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ExceptionUtils.isChecked(null));
    }
    
    @Test
    void isChecked_WithCustomCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new CustomCheckedException()));
    }
    
    @Test
    void isChecked_WithCustomUncheckedException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new CustomUncheckedException()));
    }
    
    @Test
    void isChecked_WithCustomError_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new CustomError()));
    }
    
    @Test
    void isChecked_WithSubclassOfCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new SubclassOfCheckedException()));
    }
    
    @Test
    void isChecked_WithSubclassOfUncheckedException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new SubclassOfUncheckedException()));
    }
    
    @Test
    void isChecked_WithSubclassOfError_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new SubclassOfError()));
    }
    
    @Test
    void isChecked_WithWrappedCheckedException_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new InvocationTargetException(new Exception())));
    }
    
    @Test
    void isChecked_WithWrappedUncheckedException_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new InvocationTargetException(new RuntimeException())));
    }
    
    @Test
    void isChecked_WithWrappedError_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new InvocationTargetException(new Error())));
    }
    
    @Test
    void isChecked_WithMultipleWrappedCheckedExceptions_ReturnsTrue() {
        assertTrue(ExceptionUtils.isChecked(new InvocationTargetException(new InvocationTargetException(new Exception()))));
    }
    
    @Test
    void isChecked_WithMultipleWrappedUncheckedExceptions_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new InvocationTargetException(new InvocationTargetException(new RuntimeException()))));
    }
    
    @Test
    void isChecked_WithMultipleWrappedErrors_ReturnsFalse() {
        assertFalse(ExceptionUtils.isChecked(new InvocationTargetException(new InvocationTargetException(new Error()))));
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
    void testIndexOfThrowable_ZeroStartIndex() {
        Throwable throwable = new Throwable(new Exception());
        int result = ExceptionUtils.indexOfThrowable(throwable, Exception.class);
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOfThrowable_NegativeStartIndex() {
        Throwable throwable = new Throwable(new Exception());
        int result = ExceptionUtils.indexOfThrowable(throwable, Exception.class, -1);
        assertEquals(0, result);
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
    void testIndexOfThrowable_MatchingIndex() {
        Throwable throwable = new Throwable(new Exception(new RuntimeException()));
        int result = ExceptionUtils.indexOfThrowable(throwable, RuntimeException.class);
        assertEquals(1, result);
    }
    
    @Test
    void testIndexOfThrowable_MatchingIndexWithStartIndex() {
        Throwable throwable = new Throwable(new Exception(new RuntimeException()));
        int result = ExceptionUtils.indexOfThrowable(throwable, RuntimeException.class, 1);
        assertEquals(1, result);
    }
    @Test
    public void testRethrow() {
        // Test rethrowing a null throwable
        assertThrows(NullPointerException.class, () -> exceptionUtils.rethrow(null));
    
        // Test rethrowing an undeclared throwable
        assertThrows(UndeclaredThrowableException.class, () -> {
            try {
                throw new Exception("Test exception");
            } catch (Exception e) {
                exceptionUtils.rethrow(e);
            }
        });
    
        // Test rethrowing a checked exception without adding to throws clause
        assertThrows(IOException.class, () -> {
            try {
                throw new IOException("Test exception");
            } catch (IOException e) {
                exceptionUtils.rethrow(e);
            }
        });
    
        // Test rethrowing a checked exception with adding to throws clause
        assertThrows(IOException.class, () -> {
            try {
                throw new IOException("Test exception");
            } catch (IOException e) {
                throw e;
            }
        });
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
    
        assertThrows(NullPointerException.class, () -> {
            try {
                exceptionUtils.rethrow(exceptionWithWrapped);
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
    public void testGetStackFrames_NullStackTrace_ReturnsEmptyArray() {
        String[] result = exceptionUtils.getStackFrames(null);
        assertArrayEquals(ArrayUtils.EMPTY_STRING_ARRAY, result);
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
    import org.junit.jupiter.api.Test;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    class ExceptionUtilsTest {
    
        @Test
        void testAsRuntimeExceptionWithNullThrowable() {
            assertThrows(NullPointerException.class, () -> exceptionUtils.asRuntimeException(null));
        }
    
        @Test
        void testAsRuntimeExceptionWithRuntimeException() {
            RuntimeException exception = new RuntimeException("Test");
            RuntimeException result = exceptionUtils.asRuntimeException(exception);
            assertSame(exception, result);
        }
    
        @Test
        void testAsRuntimeExceptionWithCheckedException() {
            Exception exception = new Exception("Test");
            RuntimeException result = exceptionUtils.asRuntimeException(exception);
            assertTrue(result instanceof UndeclaredThrowableException);
            assertSame(exception, result.getCause());
        }
    
        @Test
        void testAsRuntimeExceptionWithError() {
            Error error = new Error("Test");
            assertThrows(Error.class, () -> exceptionUtils.asRuntimeException(error));
        }
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
        throwable.initCause(throwable); // Set self as cause
        List<Throwable> result = exceptionUtils.getThrowableList(throwable);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(throwable, result.get(1));
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
    @DisplayName("Should return null for negative start index")
    void testThrowableOfThrowableWithNegativeStartIndex() {
        Throwable throwable = new RuntimeException("Test Exception");
        Throwable result = exceptionUtils.throwableOfThrowable(throwable, RuntimeException.class, -1);
        assertNull(result);
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
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    import java.io.ByteArrayOutputStream;
    import java.io.PrintStream;
    
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertTrue;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ExceptionUtilsTestSuite {
    
        private ExceptionUtils exceptionUtils;
    
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
            assertTrue(stackTrace.contains("[wrapped]"));
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
            throwable.initCause(throwable);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with null cause")
        void testGetStackTraceWithNullCause() {
            Throwable throwable = new Throwable("Test Exception");
            throwable.initCause(null);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: null"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace")
        void testGetStackTraceWithEmptyStackTrace() {
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
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
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
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
            assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
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
            assertTrue(stackTrace.contains("java.lang.reflect.UndeclaredThrowableException"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
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
            assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("[wrapped]"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and null cause")
        void testGetStackTraceWithEmptyStackTraceAndNullCause() {
            Throwable throwable = new Throwable("Test Exception");
            throwable.initCause(null);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: null"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and suppressed exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedExceptions() {
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
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and suppressed and chained exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedAndChainedExceptions() {
            Throwable causeException = new Throwable("Cause Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
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
            throwable.initCause(causeException);
            throwable.addSuppressed(causeException);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("[wrapped]"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Suppressed Exception 1"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and circular reference")
        void testGetStackTraceWithEmptyStackTraceAndCircularReference() {
            Throwable throwable = new Throwable("Test Exception");
            throwable.initCause(throwable);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and custom exception")
        void testGetStackTraceWithEmptyStackTraceAndCustomException() {
            CustomException customException = new CustomException("Custom Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            String stackTrace = ExceptionUtils.getStackTrace(customException);
            assertTrue(stackTrace.contains("CustomException: Custom Exception"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception caused by InvocationTargetException")
        void testGetStackTraceWithEmptyStackTraceAndInvocationTargetException() {
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
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception caused by UndeclaredThrowableException")
        void testGetStackTraceWithEmptyStackTraceAndUndeclaredThrowableException() {
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.initCause(undeclaredThrowableException);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.reflect.UndeclaredThrowableException"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with suppressed exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedExceptions() {
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.addSuppressed(suppressedException1);
            throwable.addSuppressed(suppressedException2);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with suppressed and chained exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedAndChainedExceptions() {
            Throwable causeException = new Throwable("Cause Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.addSuppressed(suppressedException1);
            throwable.addSuppressed(suppressedException2);
            throwable.initCause(causeException);
            throwable.addSuppressed(causeException);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("[wrapped]"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with circular reference")
        void testGetStackTraceWithEmptyStackTraceAndCircularReference() {
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.initCause(throwable);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and custom exception")
        void testGetStackTraceWithEmptyStackTraceAndCustomException() {
            CustomException customException = new CustomException("Custom Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            String stackTrace = ExceptionUtils.getStackTrace(customException);
            assertTrue(stackTrace.contains("CustomException: Custom Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception caused by InvocationTargetException")
        void testGetStackTraceWithEmptyStackTraceAndInvocationTargetException() {
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
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.reflect.InvocationTargetException"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception caused by UndeclaredThrowableException")
        void testGetStackTraceWithEmptyStackTraceAndUndeclaredThrowableException() {
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.initCause(undeclaredThrowableException);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.reflect.UndeclaredThrowableException"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with suppressed exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedExceptions() {
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.addSuppressed(suppressedException1);
            throwable.addSuppressed(suppressedException2);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with suppressed and chained exceptions")
        void testGetStackTraceWithEmptyStackTraceAndSuppressedAndChainedExceptions() {
            Throwable causeException = new Throwable("Cause Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
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
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.addSuppressed(suppressedException1);
            throwable.addSuppressed(suppressedException2);
            throwable.initCause(causeException);
            throwable.addSuppressed(causeException);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("[wrapped]"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Cause Exception"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("java.lang.Throwable: Suppressed Exception 2"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Suppressed Exception 1"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and exception with circular reference")
        void testGetStackTraceWithEmptyStackTraceAndCircularReference() {
            Throwable throwable = new Throwable("Test Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            throwable.initCause(throwable);
            String stackTrace = ExceptionUtils.getStackTrace(throwable);
            assertTrue(stackTrace.contains("java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Caused by: java.lang.Throwable: Test Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    
        @Test
        @DisplayName("Test getStackTrace with exception with empty stack trace and custom exception")
        void testGetStackTraceWithEmptyStackTraceAndCustomException() {
            CustomException customException = new CustomException("Custom Exception") {
                @Override
                public synchronized Throwable fillInStackTrace() {
                    return this;
                }
            };
            String stackTrace = ExceptionUtils.getStackTrace(customException);
            assertTrue(stackTrace.contains("CustomException: Custom Exception"));
            assertTrue(stackTrace.contains("Empty stack trace"));
        }
    }
    
    class CustomException extends Exception {
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
    void testGetCause_DefaultMethodNames_ReturnCorrectCause() {
        Throwable throwable = new RuntimeException(new IOException(new InvocationTargetException(new NullPointerException())));
        Throwable cause = ExceptionUtils.getCause(throwable);
        assertNotNull(cause);
        assertTrue(cause instanceof NullPointerException);
    }
    
    @Test
    void testGetCause_CustomMethodNames_ReturnCorrectCause() {
        Throwable throwable = new RuntimeException(new IOException(new InvocationTargetException(new NullPointerException())));
        String[] methodNames = {"getRootCause", "getNested"};
        Throwable cause = ExceptionUtils.getCause(throwable, methodNames);
        assertNotNull(cause);
        assertTrue(cause instanceof IOException);
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
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.DisplayName;
    
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNotNull;
    import static org.junit.jupiter.api.Assertions.assertNull;
    
    class ExceptionUtilsTestSuite {
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with null throwable")
        void testPrintRootCauseStackTraceWithNullThrowable() {
            ExceptionUtils.printRootCauseStackTrace(null);
            String output = outputStream.toString();
            assertEquals("", output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and System.err")
        void testPrintRootCauseStackTraceWithThrowableAndSystemErr() {
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException());
            String output = outputStream.toString();
            assertNotNull(output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and custom PrintStream")
        void testPrintRootCauseStackTraceWithThrowableAndCustomPrintStream() {
            PrintStream customPrintStream = new PrintStream(outputStream);
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), customPrintStream);
            String output = outputStream.toString();
            assertNotNull(output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and PrintWriter")
        void testPrintRootCauseStackTraceWithThrowableAndPrintWriter() {
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), new PrintWriter(outputStream));
            String output = outputStream.toString();
            assertNotNull(output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with nested causes")
        void testPrintRootCauseStackTraceWithNestedCauses() {
            Throwable rootCause = createNestedCauses();
            ExceptionUtils.printRootCauseStackTrace(rootCause);
            String output = outputStream.toString();
    
            // Check if the output contains the nested causes
            assertTrue(output.contains("Nested Exception 1"));
            assertTrue(output.contains("Nested Exception 2"));
            assertTrue(output.contains("Nested Exception 3"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with wrapped exception")
        void testPrintRootCauseStackTraceWithWrappedException() {
            Throwable wrappedException = createWrappedException();
            ExceptionUtils.printRootCauseStackTrace(wrappedException);
            String output = outputStream.toString();
    
            // Check if the output contains the wrapped exception marker
            assertTrue(output.contains(ExceptionUtils.WRAPPED_MARKER));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with different throwable types")
        void testPrintRootCauseStackTraceWithDifferentThrowableTypes() {
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException("Runtime Exception"));
            ExceptionUtils.printRootCauseStackTrace(new IllegalArgumentException("Invalid Argument Exception"));
            ExceptionUtils.printRootCauseStackTrace(new NullPointerException("Null Pointer Exception"));
            String output = outputStream.toString();
    
            // Check if the output contains the throwable names
            assertTrue(output.contains("RuntimeException"));
            assertTrue(output.contains("IllegalArgumentException"));
            assertTrue(output.contains("NullPointerException"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and null PrintStream")
        void testPrintRootCauseStackTraceWithThrowableAndNullPrintStream() {
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), null);
            String output = outputStream.toString();
            assertEquals("", output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and null PrintWriter")
        void testPrintRootCauseStackTraceWithThrowableAndNullPrintWriter() {
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), null);
            String output = outputStream.toString();
            assertEquals("", output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with custom cause method names")
        void testPrintRootCauseStackTraceWithCustomCauseMethodNames() {
            ExceptionUtils exceptionUtils = new ExceptionUtils();
            exceptionUtils.CAUSE_METHOD_NAMES = new String[]{"customCauseMethod"};
            Throwable throwable = createNestedCauses();
            exceptionUtils.printRootCauseStackTrace(throwable);
            String output = outputStream.toString();
    
            // Check if the output contains the custom cause method name
            assertTrue(output.contains("customCauseMethod"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with null cause method names")
        void testPrintRootCauseStackTraceWithNullCauseMethodNames() {
            ExceptionUtils exceptionUtils = new ExceptionUtils();
            exceptionUtils.CAUSE_METHOD_NAMES = null;
            Throwable throwable = createNestedCauses();
            exceptionUtils.printRootCauseStackTrace(throwable);
            String output = outputStream.toString();
    
            // Check if the output does not contain any cause method names
            assertFalse(output.contains("getCause"));
            assertFalse(output.contains("getNextException"));
            assertFalse(output.contains("getTargetException"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with empty cause method names")
        void testPrintRootCauseStackTraceWithEmptyCauseMethodNames() {
            ExceptionUtils exceptionUtils = new ExceptionUtils();
            exceptionUtils.CAUSE_METHOD_NAMES = new String[]{};
            Throwable throwable = createNestedCauses();
            exceptionUtils.printRootCauseStackTrace(throwable);
            String output = outputStream.toString();
    
            // Check if the output does not contain any cause method names
            assertFalse(output.contains("getCause"));
            assertFalse(output.contains("getNextException"));
            assertFalse(output.contains("getTargetException"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with invalid cause method names")
        void testPrintRootCauseStackTraceWithInvalidCauseMethodNames() {
            ExceptionUtils exceptionUtils = new ExceptionUtils();
            exceptionUtils.CAUSE_METHOD_NAMES = new String[]{"invalidMethod"};
            Throwable throwable = createNestedCauses();
            exceptionUtils.printRootCauseStackTrace(throwable);
            String output = outputStream.toString();
    
            // Check if the output does not contain any cause method names
            assertFalse(output.contains("invalidMethod"));
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with null throwable and null PrintStream")
        void testPrintRootCauseStackTraceWithNullThrowableAndNullPrintStream() {
            ExceptionUtils.printRootCauseStackTrace(null, null);
            String output = outputStream.toString();
            assertEquals("", output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with null throwable and null PrintWriter")
        void testPrintRootCauseStackTraceWithNullThrowableAndNullPrintWriter() {
            ExceptionUtils.printRootCauseStackTrace(null, null);
            String output = outputStream.toString();
            assertEquals("", output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and custom PrintStream and null PrintWriter")
        void testPrintRootCauseStackTraceWithThrowableAndCustomPrintStreamAndNullPrintWriter() {
            PrintStream customPrintStream = new PrintStream(outputStream);
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), customPrintStream, null);
            String output = outputStream.toString();
            assertNotNull(output);
        }
    
        @Test
        @DisplayName("Test printRootCauseStackTrace with throwable and null PrintStream and custom PrintWriter")
        void testPrintRootCauseStackTraceWithThrowableAndNullPrintStreamAndCustomPrintWriter() {
            PrintWriter customPrintWriter = new PrintWriter(outputStream);
            ExceptionUtils.printRootCauseStackTrace(new RuntimeException(), null, customPrintWriter);
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
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    public class ExceptionUtilsTest {
    
        private ExceptionUtils exceptionUtils;
    
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

}