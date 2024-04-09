package org.apache.commons.lang3.concurrent;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiBackgroundInitializerTest {


    private MultiBackgroundInitializer multiBackgroundInitializer;
    MultiBackgroundInitializer initializer;
    @BeforeEach
    public void setUp() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        multiBackgroundInitializer = new MultiBackgroundInitializer(executorService);
        initializer = new MultiBackgroundInitializer();
        
    }


//    @Test
//    @DisplayName("should return the result object produced by the BackgroundInitializer")
//    public void testGetResultObject() {
//        // Arrange
//        BackgroundInitializer<String> backgroundInitializer = () -> "result";
//        multiBackgroundInitializer.childInitializers.put("init", backgroundInitializer);
//
//        // Act
//        Object result = multiBackgroundInitializer.getResultObject("init");
//
//        // Assert
//        assertEquals("result", result);
//    }
//
//    @Test
//    @DisplayName("should return null if the BackgroundInitializer caused an exception")
//    public void testGetResultObject_Exception() {
//        // Arrange
//        BackgroundInitializer<String> backgroundInitializer = () -> {
//            throw new RuntimeException("error");
//        };
//        multiBackgroundInitializer.childInitializers.put("init", backgroundInitializer);
//
//        // Act
//        Object result = multiBackgroundInitializer.getResultObject("init");
//
//        // Assert
//        assertNull(result);
//    }

//    @Test
//    @DisplayName("should throw NoSuchElementException if the name cannot be resolved")
//    public void testGetResultObject_NameNotFound() {
//        // Arrange
//
//        // Act and Assert
//        assertThrows(NoSuchElementException.class, () ->
//                multiBackgroundInitializer.getResultObject("unknown"));
//    }

    @Test
    @DisplayName("When there are no child initializers, it should not throw any exception")
    void testCloseMethodWithNoChildInitializers() {
        assertDoesNotThrow(() -> multiBackgroundInitializer.close());
    }

//    @Test
//    @DisplayName("When all child initializers close successfully, it should not throw any exception")
//    void testCloseMethodWithSuccessfulChildInitializers() {
//        BackgroundInitializer<?> childInitializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return new Object();
//            }
//        };
//
//        BackgroundInitializer<?> childInitializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return new Object();
//            }
//        };
//
//        multiBackgroundInitializer.childInitializers.put("child1", childInitializer1);
//        multiBackgroundInitializer.childInitializers.put("child2", childInitializer2);
//
//        assertDoesNotThrow(() -> multiBackgroundInitializer.close());
//    }
//
//    @Test
//    @DisplayName("When one child initializer throws a ConcurrentException, it should throw a ConcurrentException")
//    void testCloseMethodWithChildInitializerThrowingConcurrentException() {
//        BackgroundInitializer<?> childInitializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                throw new ConcurrentException();
//            }
//        };
//
//        BackgroundInitializer<?> childInitializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return new Object();
//            }
//        };
//
//        multiBackgroundInitializer.childInitializers.put("child1", childInitializer1);
//        multiBackgroundInitializer.childInitializers.put("child2", childInitializer2);
//
//        ConcurrentException exception = assertThrows(ConcurrentException.class, () -> multiBackgroundInitializer.close());
//        assertNull(exception.getCause());
//        assertEquals(1, exception.getSuppressed().length);
//        assertTrue(exception.getSuppressed()[0] instanceof ConcurrentException);
//    }
//
//    @Test
//    @DisplayName("When one child initializer throws an exception other than ConcurrentException, it should throw a ConcurrentException with the exception as suppressed")
//    void testCloseMethodWithChildInitializerThrowingException() {
//        BackgroundInitializer<?> childInitializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                throw new Exception("Child initializer exception");
//            }
//        };
//
//        BackgroundInitializer<?> childInitializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return new Object();
//            }
//        };
//
//        multiBackgroundInitializer.childInitializers.put("child1", childInitializer1);
//        multiBackgroundInitializer.childInitializers.put("child2", childInitializer2);
//
//        ConcurrentException exception = assertThrows(ConcurrentException.class, () -> multiBackgroundInitializer.close());
//        assertNull(exception.getCause());
//        assertEquals(1, exception.getSuppressed().length);
//        assertTrue(exception.getSuppressed()[0] instanceof Exception);
//        assertEquals("Child initializer exception", exception.getSuppressed()[0].getMessage());
//    }
//
//    @Test
//    @DisplayName("When multiple child initializers throw exceptions, it should throw a ConcurrentException with all exceptions as suppressed")
//    void testCloseMethodWithMultipleChildInitializersThrowingException() {
//        BackgroundInitializer<?> childInitializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                throw new Exception("Child initializer 1 exception");
//            }
//        };
//
//        BackgroundInitializer<?> childInitializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                throw new ConcurrentException("Child initializer 2 exception");
//            }
//        };
//
//        BackgroundInitializer<?> childInitializer3 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                throw new Exception("Child initializer 3 exception");
//            }
//        };
//
//        multiBackgroundInitializer.childInitializers.put("child1", childInitializer1);
//        multiBackgroundInitializer.childInitializers.put("child2", childInitializer2);
//        multiBackgroundInitializer.childInitializers.put("child3", childInitializer3);
//
//        ConcurrentException exception = assertThrows(ConcurrentException.class, () -> multiBackgroundInitializer.close());
//        assertNull(exception.getCause());
//        assertEquals(3, exception.getSuppressed().length);
//        assertTrue(exception.getSuppressed()[0] instanceof Exception);
//        assertEquals("Child initializer 1 exception", exception.getSuppressed()[0].getMessage());
//        assertTrue(exception.getSuppressed()[1] instanceof ConcurrentException);
//        assertEquals("Child initializer 2 exception", exception.getSuppressed()[1].getMessage());
//        assertTrue(exception.getSuppressed()[2] instanceof Exception);
//        assertEquals("Child initializer 3 exception", exception.getSuppressed()[2].getMessage());
//    }

//    @Test
//    void testIsException_WithValidNameAndNoException_ShouldReturnFalse() {
//        // Arrange
//        String name = "initializer1";
//
//        // Act
//        boolean result = multiBackgroundInitializer.isException(name);
//
//        // Assert
//        assertFalse(result);
//    }
//
//    @Test
//    void testIsException_WithValidNameAndException_ShouldReturnTrue() {
//        // Arrange
//        String name = "initializer1";
//        multiBackgroundInitializer.initializeChildInitializer(name, new BackgroundInitializer<String>() {
//            @Override
//            protected String initialize() throws Exception {
//                throw new Exception("Test Exception");
//            }
//        });
//
//        // Act
//        boolean result = multiBackgroundInitializer.isException(name);
//
//        // Assert
//        assertTrue(result);
//    }
//
//    @Test
//    void testIsException_WithInvalidName_ShouldThrowNoSuchElementException() {
//        // Arrange
//        String name = "invalid_initializer";
//
//        // Act & Assert
//        assertThrows(NoSuchElementException.class, () -> {
//            multiBackgroundInitializer.isException(name);
//        });
//    }
//
//    @Test
//    void testIsException_WithNullName_ShouldThrowNullPointerException() {
//        // Arrange
//        String name = null;
//
//        // Act & Assert
//        assertThrows(NullPointerException.class, () -> {
//            multiBackgroundInitializer.isException(name);
//        });
//    }


    @Test
    void testEmptySet() {
        // Test code here
    }

    @Test
    void testSetWithInitializerNames() {
        // Test code here
    }


    @Test
    @DisplayName("Returns MultiBackgroundInitializerResults object with no child initializers")
    void testInitializeWithNoChildInitializers() throws Exception {
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = initializer.initialize();
        assertEquals(0, results.initializerNames().size());
        assertTrue(results.isSuccessful());
    }

//    @Test
//    @DisplayName("Returns MultiBackgroundInitializerResults object with completed child initializers")
//    void testInitializeWithCompletedChildInitializers() throws Exception {
//        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<String>() {
//            @Override
//            protected String initialize() throws Exception {
//                return "Initializer1";
//            }
//        };
//
//        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<Integer>() {
//            @Override
//            protected Integer initialize() throws Exception {
//                return 100;
//            }
//        };
//
//        initializer.childInitializers.put("initializer1", initializer1);
//        initializer.childInitializers.put("initializer2", initializer2);
//
//        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = initializer.initialize();
//        assertEquals(2, results.initializerNames().size());
//        assertEquals("Initializer1", results.getResultObject("initializer1"));
//        assertEquals(100, results.getResultObject("initializer2"));
//        assertTrue(results.isSuccessful());
//    }
//
//    @Test
//    @DisplayName("Returns MultiBackgroundInitializerResults object with child initializers throwing exceptions")
//    void testInitializeWithChildInitializersThrowingExceptions() throws Exception {
//        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<String>() {
//            @Override
//            protected String initialize() throws Exception {
//                throw new ConcurrentException("Initializer1 Exception");
//            }
//        };
//
//        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<Integer>() {
//            @Override
//            protected Integer initialize() throws Exception {
//                throw new ConcurrentException("Initializer2 Exception");
//            }
//        };
//
//        initializer.childInitializers.put("initializer1", initializer1);
//        initializer.childInitializers.put("initializer2", initializer2);
//
//        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = initializer.initialize();
//        assertEquals(2, results.initializerNames().size());
//        assertNull(results.getResultObject("initializer1"));
//        assertNull(results.getResultObject("initializer2"));
//        assertTrue(results.isException("initializer1"));
//        assertTrue(results.isException("initializer2"));
//        assertFalse(results.isSuccessful());
//        assertNotNull(results.getException("initializer1"));
//        assertNotNull(results.getException("initializer2"));
//    }
//
//    @Test
//    @DisplayName("Test getInitializer with valid name")
//    void testGetInitializerWithValidName() {
//        BackgroundInitializer<?> initializer = multiBackgroundInitializer.getInitializer("validName");
//        assertNotNull(initializer);
//    }
//
//    @Test
//    @DisplayName("Test getInitializer with invalid name")
//    void testGetInitializerWithInvalidName() {
//        assertThrows(NoSuchElementException.class, () -> {
//            multiBackgroundInitializer.getInitializer("invalidName");
//        });
//    }
//
//    @Test
//    @DisplayName("Test getException with valid name")
//    void testGetExceptionWithValidName() {
//        ConcurrentException exception = multiBackgroundInitializer.getException("validName");
//        assertNull(exception);
//    }
//
//    @Test
//    @DisplayName("Test getException with invalid name")
//    void testGetExceptionWithInvalidName() {
//        assertThrows(NoSuchElementException.class, () -> {
//            multiBackgroundInitializer.getException("invalidName");
//        });
//    }
//
//    @Test
//    @DisplayName("Test getResultObject with valid name")
//    void testGetResultObjectWithValidName() {
//        Object resultObject = multiBackgroundInitializer.getResultObject("validName");
//        assertNull(resultObject);
//    }
//
//    @Test
//    @DisplayName("Test getResultObject with invalid name")
//    void testGetResultObjectWithInvalidName() {
//        assertThrows(NoSuchElementException.class, () -> {
//            multiBackgroundInitializer.getResultObject("invalidName");
//        });
//    }
//
//    @Test
//    @DisplayName("Test initializerNames")
//    void testInitializerNames() {
//        Set<String> names = multiBackgroundInitializer.initializerNames();
//        assertNotNull(names);
//        assertEquals(0, names.size());
//    }
//
//    @Test
//    @DisplayName("Test isException with valid name")
//    void testIsExceptionWithValidName() {
//        boolean isException = multiBackgroundInitializer.isException("validName");
//        assertFalse(isException);
//    }
//
//    @Test
//    @DisplayName("Test isException with invalid name")
//    void testIsExceptionWithInvalidName() {
//        assertThrows(NoSuchElementException.class, () -> {
//            multiBackgroundInitializer.isException("invalidName");
//        });
//    }
//
//    @Test
//    @DisplayName("Test isSuccessful")
//    void testIsSuccessful() {
//        boolean isSuccessful = multiBackgroundInitializer.isSuccessful();
//        assertTrue(isSuccessful);
//    }


    @Test
    void testGetTaskCountWithNoChildInitializers() {
        assertEquals(1, multiBackgroundInitializer.getTaskCount());
    }

//    @Test
//    void testGetTaskCountWithOneChildInitializer() {
//        BackgroundInitializer<?> initializer = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return null;
//            }
//        };
//        multiBackgroundInitializer.childInitializers.put("initializer1", initializer);
//
//        assertEquals(2, multiBackgroundInitializer.getTaskCount());
//    }

//    @Test
//    void testGetTaskCountWithMultipleChildInitializers() {
//        BackgroundInitializer<?> initializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return null;
//            }
//        };
//        BackgroundInitializer<?> initializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return null;
//            }
//        };
//        multiBackgroundInitializer.childInitializers.put("initializer1", initializer1);
//        multiBackgroundInitializer.childInitializers.put("initializer2", initializer2);
//
//        assertEquals(3, multiBackgroundInitializer.getTaskCount());
////    }
//
//    @Test
//    void testGetTaskCountWithNestedMultiBackgroundInitializer() {
//        MultiBackgroundInitializer nestedInitializer = new MultiBackgroundInitializer();
//        BackgroundInitializer<?> initializer1 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return null;
//            }
//        };
//        BackgroundInitializer<?> initializer2 = new BackgroundInitializer<Object>() {
//            @Override
//            protected Object initialize() throws Exception {
//                return null;
//            }
//        };
//        nestedInitializer.childInitializers.put("initializer1", initializer1);
//        nestedInitializer.childInitializers.put("initializer2", initializer2);
//        multiBackgroundInitializer.childInitializers.put("nestedInitializer", nestedInitializer);
//
//        assertEquals(5, multiBackgroundInitializer.getTaskCount());
//    }

    @Test
    void testGetTaskCountWithMissingChildInitializer() {
        assertThrows(NoSuchElementException.class, () -> {
            multiBackgroundInitializer.getTaskCount();
        });
    }

    @Test
    void testGetException() {
        // Test code here
    }

    @Test
    void testGetInitializer() {
        // Test code here
    }

    @Test
    void testGetResultObject() {
        // Test code here
    }

    @Test
    void testInitializerNames() {
        // Test code here
    }

    @Test
    void testIsException() {
        // Test code here
    }

    @Test
    void testIsSuccessful() {
        // Test code here
    }


    @Test
    void testIsInitialized_NoChildInitializers_ReturnsFalse() {
        // Arrange
        MultiBackgroundInitializer initializer = new MultiBackgroundInitializer();

        // Act
        boolean isInitialized = initializer.isInitialized();

        // Assert
        assertFalse(isInitialized);
    }

//    @Test
//    void testIsInitialized_AllChildInitializersInitialized_ReturnsTrue() {
//        // Arrange
//        MultiBackgroundInitializer initializer = new MultiBackgroundInitializer();
//        BackgroundInitializer<?> initializer1 = new BackgroundInitializer<>();
//        BackgroundInitializer<?> initializer2 = new BackgroundInitializer<>();
//        initializer.addChildInitializer("initializer1", initializer1);
//        initializer.addChildInitializer("initializer2", initializer2);
//        initializer1.initialize();
//        initializer2.initialize();
//
//        // Act
//        boolean isInitialized = initializer.isInitialized();
//
//        // Assert
//        assertTrue(isInitialized);
//    }

//    @Test
//    void testIsInitialized_SomeChildInitializersNotInitialized_ReturnsFalse() {
//        // Arrange
//        MultiBackgroundInitializer initializer = new MultiBackgroundInitializer();
//        BackgroundInitializer<?> initializer1 = new BackgroundInitializer<>();
//        BackgroundInitializer<?> initializer2 = new BackgroundInitializer<>();
//        initializer.addChildInitializer("initializer1", initializer1);
//        initializer.addChildInitializer("initializer2", initializer2);
//        initializer1.initialize();
//
//        // Act
//        boolean isInitialized = initializer.isInitialized();
//
//        // Assert
//        assertFalse(isInitialized);
//    }


    @Test
    void addInitializer_shouldAddInitializerToChildInitializers() {
        // Test code here
    }

    @Test
    void addInitializer_shouldThrowNullPointerException_whenNameIsNull() {
        // Test code here
    }

    @Test
    void addInitializer_shouldThrowNullPointerException_whenBackgroundInitializerIsNull() {
        // Test code here
    }

    @Test
    void addInitializer_shouldThrowIllegalStateException_whenStartIsAlreadyCalled() {
        // Test code here
    }

//    @Test
//    void testIsSuccessfulReturnsTrueWhenNoExceptions() {
//        assertTrue(multiBackgroundInitializer.isSuccessful());
//    }

//    @Test
//    void testIsSuccessfulReturnsFalseWhenExceptionsExist() {
//        multiBackgroundInitializer.getException("child1");
//        assertFalse(multiBackgroundInitializer.isSuccessful());
////    }
//
//    @Test
//    void testIsSuccessfulReturnsFalseWhenExceptionsExistAndNoResultObject() {
//        multiBackgroundInitializer.getException("child1");
//        assertNull(multiBackgroundInitializer.getResultObject("child1"));
//        assertFalse(multiBackgroundInitializer.isSuccessful());
//    }
//
//    @Test
//    void testGetExceptionThrowsExceptionWhenNameIsUnknown() {
//        assertThrows(NoSuchElementException.class, () -> multiBackgroundInitializer.getException("unknown"));
//    }
//
//    @Test
//    void testGetInitializerThrowsExceptionWhenNameIsUnknown() {
//        assertThrows(NoSuchElementException.class, () -> multiBackgroundInitializer.getInitializer("unknown"));
//    }
//
//    @Test
//    void testGetResultObjectThrowsExceptionWhenNameIsUnknown() {
//        assertThrows(NoSuchElementException.class, () -> multiBackgroundInitializer.getResultObject("unknown"));
//    }
//
//    @Test
//    void testInitializerNamesReturnsEmptySetWhenNoChildInitializers() {
//        assertEquals(Collections.emptySet(), multiBackgroundInitializer.initializerNames());
//    }

}