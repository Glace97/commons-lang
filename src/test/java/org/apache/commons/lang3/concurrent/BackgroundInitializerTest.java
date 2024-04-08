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

public class BackgroundInitializerTest {
    @Test
    void testGetActiveExecutorWithExternalExecutor() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(externalExecutor);
        initializer.start();
        ExecutorService activeExecutor = initializer.getActiveExecutor();
        assertEquals(externalExecutor, activeExecutor);
    }
    
    @Test
    void testGetActiveExecutorWithNullExternalExecutor() {
        initializer.start();
        ExecutorService activeExecutor = initializer.getActiveExecutor();
        assertNotNull(activeExecutor);
    }
    
    @Test
    void testGetActiveExecutorBeforeStart() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(externalExecutor);
        ExecutorService activeExecutor = initializer.getActiveExecutor();
        assertNull(activeExecutor);
    }
    
    @Test
    void testGetActiveExecutorAfterStart() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(externalExecutor);
        initializer.start();
        ExecutorService activeExecutor = initializer.getActiveExecutor();
        assertNotNull(activeExecutor);
    }
    
    @Test
    void testGetActiveExecutorMultipleTimes() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(externalExecutor);
        initializer.start();
        ExecutorService activeExecutor1 = initializer.getActiveExecutor();
        ExecutorService activeExecutor2 = initializer.getActiveExecutor();
        assertEquals(activeExecutor1, activeExecutor2);
    }
    @Test
    void isStarted_shouldReturnTrueIfFutureIsNotNull() {
        assertTrue(backgroundInitializer.isStarted());
    }
    
    @Test
    void isStarted_shouldReturnFalseIfFutureIsNull() {
        backgroundInitializer.setFuture(null);
        assertFalse(backgroundInitializer.isStarted());
    }
    @Test
    void setExternalExecutor_ShouldSetExternalExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        initializer.setExternalExecutor(executorService);
    
        assertEquals(executorService, initializer.getExternalExecutor());
    }
    
    @Test
    void setExternalExecutor_WithNull_ShouldSetExternalExecutorToNull() {
        initializer.setExternalExecutor(null);
    
        assertNull(initializer.getExternalExecutor());
    }
    
    @Test
    void setExternalExecutor_AfterStart_ShouldThrowIllegalStateException() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        initializer.start();
    
        assertThrows(IllegalStateException.class, () -> initializer.setExternalExecutor(executorService));
    }
    
    @Test
    void getExecutor_AfterStart_ShouldReturnActiveExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        initializer.setExternalExecutor(executorService);
        initializer.start();
    
        assertEquals(executorService, initializer.getExecutor());
    }
    
    @Test
    void getExecutor_BeforeStart_ShouldReturnNull() {
        assertNull(initializer.getExecutor());
    }
    
    @Test
    void getFuture_AfterStart_ShouldReturnNonNullFuture() {
        initializer.start();
    
        assertNotNull(initializer.getFuture());
    }
    
    @Test
    void getFuture_BeforeStart_ShouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> initializer.getFuture());
    }
    
    @Test
    void isInitialized_AfterSuccessfulInitialization_ShouldReturnTrue() {
        initializer.initialize(() -> 10);
    
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void isInitialized_AfterFailedInitialization_ShouldReturnFalse() {
        initializer.initialize(() -> {
            throw new Exception("Initialization failed");
        });
    
        assertFalse(initializer.isInitialized());
    }
    
    @Test
    void isStarted_AfterStart_ShouldReturnTrue() {
        initializer.start();
    
        assertTrue(initializer.isStarted());
    }
    
    @Test
    void isStarted_BeforeStart_ShouldReturnFalse() {
        assertFalse(initializer.isStarted());
    }
    
    @Test
    void setExternalExecutor_AfterStart_ShouldThrowIllegalStateException() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        initializer.start();
    
        assertThrows(IllegalStateException.class, () -> initializer.setExternalExecutor(executorService));
    }
    @Test
    void testGetFutureThrowsExceptionWhenNotStarted() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            backgroundInitializer.getFuture();
        });
    }
    
    @Test
    void testGetFutureReturnsFutureWhenStarted() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Result";
            }
        });
    
        backgroundInitializer.start();
        backgroundInitializer.setExternalExecutor(executorService);
        backgroundInitializer.getFuture();
    
        Assertions.assertEquals(future.get(), backgroundInitializer.getFuture().get());
    }
    
    @Test
    void testGetFutureReturnsSameFutureAfterStart() {
        backgroundInitializer.start();
        Future<String> future1 = backgroundInitializer.getFuture();
        Future<String> future2 = backgroundInitializer.getFuture();
    
        Assertions.assertSame(future1, future2);
    }
    
    @Test
    void testStartReturnsTrueOnFirstInvocation() {
        boolean result = backgroundInitializer.start();
    
        Assertions.assertTrue(result);
    }
    
    @Test
    void testStartReturnsFalseOnSubsequentInvocations() {
        backgroundInitializer.start();
        boolean result = backgroundInitializer.start();
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterSuccessfulInitialization() throws InterruptedException {
        backgroundInitializer.start();
    
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Result";
            }
        });
    
        backgroundInitializer.setExternalExecutor(executorService);
        backgroundInitializer.getFuture().get();
    
        Assertions.assertTrue(backgroundInitializer.isInitialized());
    }
    
    @Test
    void testSetExternalExecutorThrowsExceptionIfAlreadyStarted() {
        backgroundInitializer.start();
    
        Assertions.assertThrows(IllegalStateException.class, () -> {
            backgroundInitializer.setExternalExecutor(Executors.newSingleThreadExecutor());
        });
    }
    import org.junit.jupiter.api.Test;
    
    class BackgroundInitializerTest {
    
        @Test
        void testStart() {
            // Test code here
        }
    
        @Test
        void testGetExecutorService() {
            // Test code here
        }
    
        @Test
        void testSetExternalExecutor() {
            // Test code here
        }
    
        @Test
        void testGetFuture() {
            // Test code here
        }
    
        @Test
        void testIsInitialized() {
            // Test code here
        }
    
        @Test
        void testCreateTask() {
            // Test code here
        }
    
        @Test
        void testCreateTaskWithExecutor() {
            // Test code here
        }
    }
    @Test
    void testGetBeforeStart() {
        assertThrows(IllegalStateException.class, () -> {
            initializer.get();
        });
    }
    
    @Test
    void testGetAfterStart() throws ConcurrentException {
        initializer.start();
        MyClass result = initializer.get();
        assertNotNull(result);
    }
    
    @Test
    void testGetThrowsException() {
        initializer = new BackgroundInitializer<>(new MyInitializer(), null, null);
    
        assertThrows(ConcurrentException.class, () -> {
            initializer.get();
        });
    }
    
    @Test
    void testGetWithExternalExecutor() throws ConcurrentException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(executorService);
        initializer.start();
        MyClass result = initializer.get();
        assertNotNull(result);
        assertTrue(executorService.isShutdown());
    }
    
    @Test
    void testGetWithNullExternalExecutor() throws ConcurrentException {
        initializer.setExternalExecutor(null);
        initializer.start();
        MyClass result = initializer.get();
        assertNotNull(result);
    }
    @Test
    void testGetExternalExecutor() {
        ExecutorService externalExecutor = backgroundInitializer.getExternalExecutor();
        assertEquals(mockExternalExecutor, externalExecutor);
    }
    
    @Test
    void testGetExternalExecutorReturnsNullWhenNotSet() {
        backgroundInitializer.setExternalExecutor(null);
        ExecutorService externalExecutor = backgroundInitializer.getExternalExecutor();
        assertNull(externalExecutor);
    }
    
    @Test
    void testSetExternalExecutor() {
        backgroundInitializer.setExternalExecutor(mockExecutor);
        ExecutorService externalExecutor = backgroundInitializer.getExternalExecutor();
        assertEquals(mockExecutor, externalExecutor);
    }
    
    @Test
    void testStart() throws Exception {
        when(mockExternalExecutor.submit(any(Callable.class))).thenReturn(mockFuture);
    
        boolean started = backgroundInitializer.start();
    
        assertTrue(started);
        verify(mockExternalExecutor).submit(any(Callable.class));
        verify(mockFuture).get();
    }
    
    @Test
    void testStartReturnsFalseWhenAlreadyStarted() {
        backgroundInitializer.start();
        boolean started = backgroundInitializer.start();
    
        assertFalse(started);
        verifyZeroInteractions(mockExternalExecutor);
        verifyZeroInteractions(mockFuture);
    }
    
    @Test
    void testStartThrowsExceptionWhenExecutorNotSet() {
        backgroundInitializer.setExternalExecutor(null);
    
        assertThrows(IllegalStateException.class, () -> backgroundInitializer.start());
        verifyZeroInteractions(mockExternalExecutor);
        verifyZeroInteractions(mockFuture);
    }
    
    @Test
    void testCall() throws Exception {
        Object expectedResult = new Object();
        when(mockInitializer.get()).thenReturn(expectedResult);
    
        Object result = backgroundInitializer.call();
    
        assertEquals(expectedResult, result);
        verify(mockInitializer).get();
        verify(mockCloser, never()).accept(any());
    }
    
    @Test
    void testCallClosesExecutor() throws Exception {
        ExecutorService mockExecutor = mock(ExecutorService.class);
        backgroundInitializer = new BackgroundInitializer<>(mockInitializer, mockCloser, mockExecutor);
    
        backgroundInitializer.call();
    
        verify(mockExecutor).shutdown();
    }
    
    @Test
    void testCallThrowsExceptionWhenInitializerThrowsException() throws Exception {
        Exception expectedException = new ConcurrentException();
        when(mockInitializer.get()).thenThrow(expectedException);
    
        assertThrows(Exception.class, () -> backgroundInitializer.call());
        verify(mockInitializer).get();
        verify(mockCloser, never()).accept(any());
    }
    
    @Test
    void testCallThrowsExceptionWhenCloserThrowsException() throws Exception {
        Exception expectedException = new ConcurrentException();
        when(mockInitializer.get()).thenReturn(new Object());
        doThrow(expectedException).when(mockCloser).accept(any());
    
        assertThrows(Exception.class, () -> backgroundInitializer.call());
        verify(mockInitializer).get();
        verify(mockCloser).accept(any());
    }
    
    @Test
    void testIsInitialized() throws Exception {
        backgroundInitializer.start();
    
        boolean initialized = backgroundInitializer.isInitialized();
    
        assertTrue(initialized);
    }
    
    @Test
    void testIsInitializedReturnsFalseWhenNotStarted() {
        boolean initialized = backgroundInitializer.isInitialized();
    
        assertFalse(initialized);
    }
    
    @Test
    void testGetFuture() throws Exception {
        backgroundInitializer.start();
    
        Future<Object> future = backgroundInitializer.getFuture();
    
        assertEquals(mockFuture, future);
    }
    
    @Test
    void testGetFutureThrowsExceptionWhenNotStarted() {
        assertThrows(IllegalStateException.class, () -> backgroundInitializer.getFuture());
    }
    @Test
    @DisplayName("Should return 1 when no external executor is set")
    void shouldReturnOneWhenNoExternalExecutorSet() {
        int taskCount = backgroundInitializer.getTaskCount();
        Assertions.assertEquals(1, taskCount);
    }
    
    @Test
    @DisplayName("Should return 1 when external executor is set")
    void shouldReturnOneWhenExternalExecutorSet() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        backgroundInitializer.setExternalExecutor(executorService);
        int taskCount = backgroundInitializer.getTaskCount();
        Assertions.assertEquals(1, taskCount);
    }
    @Test
    void testIsInitialized_ReturnsFalse_WhenFutureIsNull() {
        assertFalse(backgroundInitializer.isInitialized());
    }
    
    @Test
    void testIsInitialized_ReturnsFalse_WhenFutureIsNotDone() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        backgroundInitializer.setFuture(future);
    
        assertFalse(backgroundInitializer.isInitialized());
    
        executorService.shutdown();
    }
    
    @Test
    void testIsInitialized_ReturnsTrue_WhenFutureIsDone() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        backgroundInitializer.setFuture(future);
    
        future.cancel(true);
    
        assertTrue(backgroundInitializer.isInitialized());
    
        executorService.shutdown();
    }
    
    @Test
    void testIsInitialized_ReturnsFalse_WhenFutureThrowsCancellationException() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                throw new CancellationException();
            }
        });
        backgroundInitializer.setFuture(future);
    
        assertFalse(backgroundInitializer.isInitialized());
    
        executorService.shutdown();
    }
    
    @Test
    void testIsInitialized_ReturnsFalse_WhenFutureThrowsExecutionException() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                throw new ExecutionException(null);
            }
        });
        backgroundInitializer.setFuture(future);
    
        assertFalse(backgroundInitializer.isInitialized());
    
        executorService.shutdown();
    }
    
    @Test
    void testIsInitialized_ReturnsFalse_WhenFutureThrowsInterruptedException() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                throw new InterruptedException();
            }
        });
        backgroundInitializer.setFuture(future);
    
        assertFalse(backgroundInitializer.isInitialized());
    
        executorService.shutdown();
    }
    @Test
    @DisplayName("Should return null when no external executor is set")
    void shouldReturnNullWhenNoExternalExecutorIsSet() {
        assertNull(backgroundInitializer.getExternalExecutor());
    }
    
    @Test
    @DisplayName("Should return the set external executor")
    void shouldReturnSetExternalExecutor() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        backgroundInitializer.setExternalExecutor(executorService);
    
        assertEquals(executorService, backgroundInitializer.getExternalExecutor());
    }
    @Test
    void testBuilder() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        assertNotNull(builder);
    }
    
    @Test
    void testSetExternalExecutor() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        builder.setExternalExecutor(externalExecutor);
        assertNotNull(builder.getExternalExecutor());
    }
    
    @Test
    void testInitializationTask() throws Exception {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        BackgroundInitializer<String> initializer = builder.get();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(externalExecutor);
    
        Callable<String> initializationTask = initializer.new InitializationTask(externalExecutor);
        String result = initializationTask.call();
        assertNotNull(result);
    }
    
    @Test
    void testBackgroundInitializerNoExternalExecutor() {
        BackgroundInitializer<String> initializer = new BackgroundInitializer<>();
        assertNull(initializer.getExternalExecutor());
    }
    
    @Test
    void testBackgroundInitializerWithExternalExecutor() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = new BackgroundInitializer<>(externalExecutor);
        assertNotNull(initializer.getExternalExecutor());
    }
    
    @Test
    void testBackgroundInitializerWithInitializerAndCloser() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
    
        Callable<String> initializationTask = initializer.new InitializationTask(externalExecutor);
        String result = initializationTask.call();
        assertNotNull(result);
    }
    
    @Test
    void testGetExecutorService() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
        assertNotNull(initializer.getExecutorService());
    }
    
    @Test
    void testGetFuture() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
        initializer.start();
        Future<String> future = initializer.getFuture();
        assertNotNull(future);
    }
    
    @Test
    void testIsInitialized() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
        initializer.start();
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsStarted() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
        assertFalse(initializer.isStarted());
        initializer.start();
        assertTrue(initializer.isStarted());
    }
    @Test
    void shouldReturnTypedException() {
        // Arrange
        Exception originalException = new Exception("Test Exception");
        
        // Act
        Exception typedException = backgroundInitializer.getTypedException(originalException);
        
        // Assert
        assertSame(originalException, typedException);
    }
    
    @Test
    void shouldReturnCancellationException() {
        // Arrange
        Exception originalException = new CancellationException("Test Cancellation");
        
        // Act
        Exception typedException = backgroundInitializer.getTypedException(originalException);
        
        // Assert
        assertTrue(typedException instanceof CancellationException);
        assertSame(originalException, typedException);
    }
    
    @Test
    void shouldReturnExecutionException() {
        // Arrange
        Exception originalException = new ExecutionException("Test Execution", null);
        
        // Act
        Exception typedException = backgroundInitializer.getTypedException(originalException);
        
        // Assert
        assertTrue(typedException instanceof ExecutionException);
        assertSame(originalException, typedException);
    }
    
    @Test
    void shouldReturnException() {
        // Arrange
        Exception originalException = new RuntimeException("Test Runtime");
        
        // Act
        Exception typedException = backgroundInitializer.getTypedException(originalException);
        
        // Assert
        assertTrue(typedException instanceof Exception);
        assertSame(originalException, typedException);
    }

}