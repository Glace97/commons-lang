package org.apache.commons.lang3.concurrent;

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

public class LazyInitializerTest {
    @Test
    void testGet() throws ConcurrentException {
        // Test case 1: Object is not initialized
        LazyInitializer<Object> initializer1 = new LazyInitializer<>();
        assertNull(initializer1.get());
    
        // Test case 2: Object is initialized
        FailableSupplier<Object, ConcurrentException> initializer2 = () -> new Object();
        LazyInitializer<Object> initializer3 = new LazyInitializer<>(initializer2, null);
        assertNotNull(initializer3.get());
    
        // Test case 3: Object is initialized and then accessed again
        LazyInitializer<Object> initializer4 = new LazyInitializer<>(initializer2, null);
        Object obj1 = initializer4.get();
        Object obj2 = initializer4.get();
        assertSame(obj1, obj2);
    }
    import org.junit.jupiter.api.Test;
    
    class LazyInitializerTestSuite {
    
        @Test
        void testIsInitializedReturnsFalseWhenNotInitialized() {
            // test code here
        }
    
        @Test
        void testIsInitializedReturnsTrueWhenInitialized() {
            // test code here
        }
    
        @Test
        void testIsInitializedReturnsTrueAfterMultipleInitializations() {
            // test code here
        }
    
        @Test
        void testIsInitializedReturnsFalseAfterClose() {
            // test code here
        }
    
        @Test
        void testIsInitializedReturnsFalseAfterCloseAndReinitialize() {
            // test code here
        }
    
        @Test
        void testIsInitializedReturnsTrueAfterCloseAndReinitializeAndInitialize() {
            // test code here
        }
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.condition.EnabledOnOs;
    import org.junit.jupiter.api.condition.OS;
    
    @Test
    void testGet_NoInitializer_ReturnsInitializedObject() {
        LazyInitializer<String> initializer = LazyInitializer.builder().build();
        String result = initializer.get();
        assertNotNull(result);
    }
    
    @Test
    void testGet_WithInitializer_ReturnsInitializedObject() {
        FailableSupplier<String, ConcurrentException> initializer = () -> "initialized";
        LazyInitializer<String> lazyInitializer = LazyInitializer.builder().initializer(initializer).build();
        String result = lazyInitializer.get();
        assertEquals("initialized", result);
    }
    
    @Test
    void testGet_WithCloser_ClosesObject() throws ConcurrentException {
        FailableConsumer<String, ConcurrentException> closer = obj -> { /* logic to close object */ };
        LazyInitializer<String> lazyInitializer = LazyInitializer.builder().closer(closer).build();
        String result = lazyInitializer.get();
        assertNotNull(result);
        lazyInitializer.close();
        // Assert that the closer was called to close the object
    }
    
    @Test
    void testGet_MultipleCalls_ReturnsSameObject() {
        LazyInitializer<String> initializer = LazyInitializer.builder().build();
        String result1 = initializer.get();
        String result2 = initializer.get();
        assertSame(result1, result2);
    }
    
    @Test
    void testClose_ObjectInitialized_ClosesObject() throws ConcurrentException {
        FailableConsumer<String, ConcurrentException> closer = obj -> { /* logic to close object */ };
        LazyInitializer<String> lazyInitializer = LazyInitializer.builder().closer(closer).build();
        lazyInitializer.get();
        lazyInitializer.close();
        // Assert that the closer was called to close the object
    }
    
    @Test
    void testClose_ObjectNotInitialized_DoesNothing() throws ConcurrentException {
        LazyInitializer<String> lazyInitializer = LazyInitializer.builder().build();
        lazyInitializer.close();
        // Assert that the closer was not called
    }
    
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testBuilder_WindowsOS_ReturnsBuilder() {
        Builder<LazyInitializer<String>, String> builder = LazyInitializer.builder();
        assertNotNull(builder);
    }
    
    @Test
    @EnabledOnOs(OS.LINUX)
    void testBuilder_LinuxOS_ReturnsBuilder() {
        Builder<LazyInitializer<String>, String> builder = LazyInitializer.builder();
        assertNotNull(builder);
    }
    import org.junit.jupiter.api.*;
    import static org.junit.jupiter.api.Assertions.*;
    
    class LazyInitializerTest {
    
        LazyInitializer<Object, ConcurrentException> initializer;
    
        @BeforeEach
        void setUp() {
            FailableSupplier<Object, ConcurrentException> initializerSupplier = () -> new Object();
            FailableConsumer<Object, ConcurrentException> closerConsumer = obj -> {};
            initializer = new LazyInitializer<>(initializerSupplier, closerConsumer);
        }
    
        @Test
        void testGetTypedException() {
            Exception exception = new Exception("Test Exception");
            ConcurrentException concurrentException = initializer.getTypedException(exception);
            assertNotNull(concurrentException);
            assertEquals(exception, concurrentException.getCause());
        }
    }

}