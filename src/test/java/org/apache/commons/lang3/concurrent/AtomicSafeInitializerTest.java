package org.apache.commons.lang3.concurrent;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtomicSafeInitializerTest {
    @Test
    void testGet1() throws ConcurrentException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>();
    
        Object obj = initializer.get();
    
        assertNotNull(obj);
    }
    
    @Test
    void testGetTwice() throws ConcurrentException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>();
    
        Object obj1 = initializer.get();
        Object obj2 = initializer.get();
    
        assertSame(obj1, obj2);
    }
    
    @Test
    void testGetConcurrent() throws ConcurrentException, InterruptedException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>();
    
        Thread t1 = new Thread(() -> {
            try {
                Object obj1 = initializer.get();
                Thread.sleep(1000);
                Object obj2 = initializer.get();
                assertSame(obj1, obj2);
            } catch (ConcurrentException | InterruptedException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        });
    
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                Object obj1 = initializer.get();
                Thread.sleep(500);
                Object obj2 = initializer.get();
                assertSame(obj1, obj2);
            } catch (ConcurrentException | InterruptedException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        });
    
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    
//    @Test
//    void testInitializeException() {
//        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> {
//            throw new ConcurrentException("Initialization exception");
//        }, null);
//
//        assertThrows(ConcurrentException.class, () -> {
//            initializer.get();
//        });
//    }
//
//    @Test
//    void testCloser() throws ConcurrentException {
//        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> new Object(), obj -> {
//            // Do nothing
//        });
//
//        Object obj = initializer.get();
//
//        assertNotNull(obj);
//
//        initializer.close();
//
//        assertThrows(ConcurrentException.class, () -> {
//            initializer.get();
//        });
//    }
//    @Test
//    @DisplayName("Test isInitialized() returns true when initialized")
//    void testIsInitializedReturnsTrueWhenInitialized() throws Exception {
//        initializer.initialize();
//        assertTrue(initializer.isInitialized());
//    }
//
//    @Test
//    @DisplayName("Test isInitialized() returns false when not initialized")
//    void testIsInitializedReturnsFalseWhenNotInitialized() {
//        assertFalse(initializer.isInitialized());
//    }
//
//    @Test
//    @DisplayName("Test isInitialized() returns true after multiple initializations")
//    void testIsInitializedReturnsTrueAfterMultipleInitializations() throws Exception {
//        initializer.initialize();
//        initializer.initialize();
//        assertTrue(initializer.isInitialized());
//    }
//
//    @Test
//    @DisplayName("Test isInitialized() returns true after initialization with exception")
//    void testIsInitializedReturnsTrueAfterInitializationWithException() {
//        initializer = new AtomicSafeInitializer<>(() -> {
//            throw new ConcurrentException("Initialization exception");
//        }, null);
//        try {
//            initializer.initialize();
//        } catch (ConcurrentException e) {
//            // Ignore exception
//        }
//        assertTrue(initializer.isInitialized());
//    }
//
//    @Test
//    @DisplayName("Test isInitialized() returns false after closing")
//    void testIsInitializedReturnsFalseAfterClosing() throws Exception {
//        initializer.initialize();
//        initializer.close();
//        assertFalse(initializer.isInitialized());
//    }


//        @Test
//        void testGet() throws ConcurrentException {
//            AtomicSafeInitializer<Object> initializer = AtomicSafeInitializer.builder().build();
//            assertNotNull(initializer.get());
//        }
//
//        @Test
//        void testInitialize() throws ConcurrentException {
//            AtomicSafeInitializer<Object> initializer = AtomicSafeInitializer.builder().build();
//            Object obj = initializer.initialize();
//            Assertions.assertNotNull(obj);
//        }
//
//        @Test
//        void testClose() throws ConcurrentException {
//            AtomicSafeInitializer.Builder<AtomicSafeInitializer<Object>, Object> builder = AtomicSafeInitializer.builder();
//            Object obj = initializer.initialize();
//            initializer.close();
//            Assertions.assertNull(initializer.reference.get());
//        }
    
        @Test
        void testBuilder() {
            AtomicSafeInitializer.Builder<AtomicSafeInitializer<Object>, Object> builder = AtomicSafeInitializer.builder();
            assertNotNull(builder);
        }
    
    @Test
    void testGetTypedException() {
      AtomicSafeInitializer initializer = new AtomicSafeInitializer();
      Exception exception = new Exception("Test exception");
    
      ConcurrentException concurrentException = initializer.getTypedException(exception);
    
      assertNotNull(concurrentException);
      assertEquals(exception, concurrentException.getCause());
    }

}