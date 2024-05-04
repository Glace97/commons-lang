package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.function.*;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.util.stream.Stream;
import org.junit.jupiter.api.function.Executable;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import static org.mockito.Mockito.doThrow;
import org.mockito.Mockito;

import java.util.Arrays;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.Callable;
import java.util.Collection;
import java.io.UncheckedIOException;
import java.util.concurrent.ExecutionException;

public class FunctionsTest {

    @Test
    public void testCallWhenCallableReturnsValue() throws Exception {
        // Given
        Functions.FailableCallable<String, Exception> mockCallable = mock(Functions.FailableCallable.class);
        String expected = "test";
        when(mockCallable.call()).thenReturn(expected);

        // When
        String result = Functions.call(mockCallable);

        // Then
        assertEquals(expected, result);
        verify(mockCallable, times(1)).call();
    }

    @Test
    public void testCallWhenCallableThrowsException() throws Exception {
        // Given
        Functions.FailableCallable<String, Exception> mockCallable = mock(Functions.FailableCallable.class);
        Exception expectedException = new Exception("test exception");
        when(mockCallable.call()).thenThrow(expectedException);

        // When and Then
        Exception actualException = assertThrows(RuntimeException.class, () -> Functions.call(mockCallable));
        assertEquals(expectedException, actualException.getCause());
        verify(mockCallable, times(1)).call();
    }





    @Test
    public void testAcceptFailableBiConsumer() throws Exception {
        Functions.FailableBiConsumer<String, String, Exception> consumer = mock(Functions.FailableBiConsumer.class);

        // Test case: no exception is thrown
        Functions.accept(consumer, "object1", "object2");

        // Verify that the consumer was called with the correct arguments
        verify(consumer, times(1)).accept("object1", "object2");

        // Test case: an exception is thrown
        doThrow(new Exception("Test exception")).when(consumer).accept(any(String.class), any(String.class));

        assertThrows(RuntimeException.class, () -> {
            Functions.accept(consumer, "object1", "object2");
        });
    }

    @Test
    public void testAcceptFailableConsumer() throws Exception {
        Functions.FailableConsumer<String, Exception> consumer = mock(Functions.FailableConsumer.class);

        // Test case: no exception is thrown
        Functions.accept(consumer, "object");

        // Verify that the consumer was called with the correct argument
        verify(consumer, times(1)).accept("object");

        // Test case: an exception is thrown
        doThrow(new Exception("Test exception")).when(consumer).accept(any(String.class));

        assertThrows(RuntimeException.class, () -> {
            Functions.accept(consumer, "object");
        });
    }





    @Test
    public void testAsConsumer() throws Exception {
        Functions.FailableConsumer<String, Exception> mockFailableConsumer = mock(Functions.FailableConsumer.class);
        Consumer<String> consumer = Functions.asConsumer(mockFailableConsumer);
        String input = "test input";

        consumer.accept(input);

        verify(mockFailableConsumer).accept(input);
    }

    @Test
    public void testAsConsumerThrowsException() throws Exception {
        Functions.FailableConsumer<String, Exception> mockFailableConsumer = mock(Functions.FailableConsumer.class);
        Consumer<String> consumer = Functions.asConsumer(mockFailableConsumer);
        String input = "test input";

        doThrow(new RuntimeException()).when(mockFailableConsumer).accept(input);

        assertThrows(RuntimeException.class, () -> consumer.accept(input));
    }

    @Test
    public void testAsConsumerWithNullInput() throws Exception {
        Functions.FailableConsumer<String, Exception> mockFailableConsumer = mock(Functions.FailableConsumer.class);
        Consumer<String> consumer = Functions.asConsumer(mockFailableConsumer);

        consumer.accept(null);

        verify(mockFailableConsumer).accept(null);
    }







    @Test
    public void applyBiFunctionTest() {
        // Instantiate necessary variables
        Functions.FailableBiFunction<Integer, Integer, Integer, Exception> function =
                (a, b) -> a + b;

        // Test the function
        Integer result = Functions.apply(function, 1, 2);
        assertEquals(3, result);
    }

    @Test
    public void applyBiFunctionExceptionTest() {
        // Instantiate necessary variables
        Functions.FailableBiFunction<Integer, Integer, Integer, Exception> function =
                (a, b) -> { throw new Exception("Test exception"); };

        // Test the function
        assertThrows(RuntimeException.class, () -> Functions.apply(function, 1, 2));
    }

    @Test
    public void applyFunctionTest() {
        // Instantiate necessary variables
        Functions.FailableFunction<Integer, Integer, Exception> function =
                a -> a * 2;

        // Test the function
        Integer result = Functions.apply(function, 2);
        assertEquals(4, result);
    }

    @Test
    public void applyFunctionExceptionTest() {
        // Instantiate necessary variables
        Functions.FailableFunction<Integer, Integer, Exception> function =
                a -> { throw new Exception("Test exception"); };

        // Test the function
        assertThrows(RuntimeException.class, () -> Functions.apply(function, 2));
    }





    @Test
    public void asRunnable_noException() throws Exception {
        Functions.FailableRunnable<Exception> failableRunnable = mock(Functions.FailableRunnable.class);

        Runnable runnable = Functions.asRunnable(failableRunnable);

        runnable.run();

        verify(failableRunnable, times(1)).run();
    }

    @Test
    public void asRunnable_withException() throws Exception {
        Functions.FailableRunnable<Exception> failableRunnable = mock(Functions.FailableRunnable.class);
        doThrow(new Exception("Test exception")).when(failableRunnable).run();

        Runnable runnable = Functions.asRunnable(failableRunnable);

        assertThrows(Exception.class, runnable::run);

        verify(failableRunnable, times(1)).run();
    }









    @Test
    public void asBiConsumer_GivenValidConsumer_ShouldReturnBiConsumerThatDoesNotThrowException() {
        // Instantiate all necessary variables here
        Functions.FailableBiConsumer<String, String, IOException> failableBiConsumer = mock(Functions.FailableBiConsumer.class);

        // Write the test code here following the given rules
        BiConsumer<String, String> biConsumer = Functions.asBiConsumer(failableBiConsumer);

        assertDoesNotThrow(() -> biConsumer.accept("input1", "input2"));
    }

    @Test
    public void asBiConsumer_GivenConsumerThatThrowsException_ShouldReturnBiConsumerThatDoesNotThrowException() throws IOException {
        // Instantiate all necessary variables here
        Functions.FailableBiConsumer<String, String, IOException> failableBiConsumer = mock(Functions.FailableBiConsumer.class);
        doThrow(IOException.class).when(failableBiConsumer).accept(anyString(), anyString());

        // Write the test code here following the given rules
        BiConsumer<String, String> biConsumer = Functions.asBiConsumer(failableBiConsumer);

        assertDoesNotThrow(() -> biConsumer.accept("input1", "input2"));
    }



    @Test
    public void testRun_ThrowsException() throws Throwable {
        // Instantiate all necessary variables here
        Functions.FailableRunnable<Throwable> mockRunnable = mock(Functions.FailableRunnable.class);

        // Mock the run method to throw a new Exception
        doThrow(new Exception("Test exception")).when(mockRunnable).run();

        // Write the test code here following the given rules
        // The run method should throw a RuntimeException when the FailableRunnable throws an exception
        assertThrows(RuntimeException.class, () -> Functions.run(mockRunnable));
    }

    @Test
    public void testRun_NoException() {
        // Instantiate all necessary variables here
        Functions.FailableRunnable<Throwable> mockRunnable = mock(Functions.FailableRunnable.class);

        // No exception should be thrown when the FailableRunnable does not throw an exception
        assertDoesNotThrow(() -> Functions.run(mockRunnable));
    }




    @Test
    @DisplayName("Test asFunction with a function that does not throw an exception")
    public void testAsFunctionWithoutException() throws Exception {
        Functions.FailableFunction<Integer, Integer, Exception> failableFunction = mock(Functions.FailableFunction.class);
        when(failableFunction.apply(5)).thenReturn(25);

        Function<Integer, Integer> function = Functions.asFunction(failableFunction);
        assertEquals(25, function.apply(5));
    }

    @Test
    @DisplayName("Test asFunction with a function that throws an exception")
    public void testAsFunctionWithException() throws Exception {
        Functions.FailableFunction<Integer, Integer, Exception> failableFunction = mock(Functions.FailableFunction.class);
        when(failableFunction.apply(5)).thenThrow(new Exception("Test Exception"));

        Function<Integer, Integer> function = Functions.asFunction(failableFunction);
        assertThrows(RuntimeException.class, () -> function.apply(5));
    }




    @Test
    public void rethrow_RuntimeException_Test() {
        RuntimeException runtimeException = new RuntimeException("test");
        Exception exception = assertThrows(RuntimeException.class, () -> Functions.rethrow(runtimeException));
        assertEquals("test", exception.getMessage());
    }

//    @Test
//    public void rethrow_ErrorException_Test() {
//        Error error = new Error("test");
//        Exception exception = assertThrows(Error.class, () -> Functions.rethrow(error));
//        assertEquals("test", exception.getMessage());
//    }

    @Test
    public void rethrow_IOException_Test() {
        IOException ioException = new IOException("test");
        Exception exception = assertThrows(UncheckedIOException.class, () -> Functions.rethrow(ioException));
        assertEquals("test", exception.getMessage());
    }

    @Test
    public void rethrow_OtherException_Test() {
        Exception otherException = new Exception("test");
        Exception exception = assertThrows(UndeclaredThrowableException.class, () -> Functions.rethrow(otherException));
        assertEquals("test", exception.getCause().getMessage());
    }

    @Test
    public void rethrow_NullPointerException_Test() {
        assertThrows(NullPointerException.class, () -> Functions.rethrow(null));
    }






    @Test
    public void testAsBiFunction_withNoExceptionThrown() {
        Functions.FailableBiFunction<String, String, Integer, IOException> failableBiFunction = (s1, s2) -> s1.length() + s2.length();
        BiFunction<String, String, Integer> biFunction = Functions.asBiFunction(failableBiFunction);

        Integer result = biFunction.apply("abc", "def");
        assertEquals(6, result);
    }

    @Test
    public void testAsBiFunction_withExceptionThrown() {
        Functions.FailableBiFunction<String, String, Integer, IOException> failableBiFunction = (s1, s2) -> {
            throw new IOException("Test");
        };

        BiFunction<String, String, Integer> biFunction = Functions.asBiFunction(failableBiFunction);

        assertThrows(UndeclaredThrowableException.class, () -> biFunction.apply("abc", "def"));
    }

    @Test
    public void testAsBiFunction_withNullInput() {
        Functions.FailableBiFunction<String, String, Integer, IOException> failableBiFunction = (s1, s2) -> s1.length() + s2.length();
        BiFunction<String, String, Integer> biFunction = Functions.asBiFunction(failableBiFunction);

        Integer result = biFunction.apply(null, null);
        assertEquals(0, result);
    }

    @Test
    public void testAsBiFunction_withNullFunction() {
        assertThrows(NullPointerException.class, () -> Functions.asBiFunction(null));
    }







//    @Test
//    public void testStreamFromCollection() {
//        // Instantiate necessary variables
//        Collection<String> collection = Arrays.asList("Element 1", "Element 2", "Element 3");
//
//        // Call the method under test
//        Functions.FailableStream<String> failableStream = Functions.stream(collection);
//
//        // Verify the result
//        assertNotNull(failableStream);
//        assertEquals(3, failableStream.count());
//    }
//
//    @Test
//    public void testStreamFromStream() {
//        // Instantiate necessary variables
//        Stream<String> stream = Stream.of("Element 1", "Element 2", "Element 3");
//
//        // Call the method under test
//        Functions.FailableStream<String> failableStream = Functions.stream(stream);
//
//        // Verify the result
//        assertNotNull(failableStream);
//        assertEquals(3, failableStream.count());
//    }
//
//    @Test
//    public void testStreamFromEmptyCollection() {
//        // Instantiate necessary variables
//        Collection<String> collection = Arrays.asList();
//
//        // Call the method under test
//        Functions.FailableStream<String> failableStream = Functions.stream(collection);
//
//        // Verify the result
//        assertNotNull(failableStream);
//        assertEquals(0, failableStream.count());
//    }

    @Test
    public void testStreamFromNullCollection() {
        // Expect an exception
        assertThrows(NullPointerException.class, () -> {
            // Call the method with a null collection
            Functions.stream((Collection<String>) null);
        });
    }

    @Test
    public void testStreamFromNullStream() {
        // Expect an exception
        assertThrows(NullPointerException.class, () -> {
            // Call the method with a null stream
            Functions.stream((Stream<String>) null);
        });
    }




    @Test
    public void testFailableBiPredicate() {
        // Instantiate all necessary variables here
        Functions.FailableBiPredicate<String, Integer, Exception> failableBiPredicate = 
            (string, integer) -> string.length() == integer;

        // Test case where the predicate's evaluation is true
        boolean result = Functions.test(failableBiPredicate, "test", 4);
        assertTrue(result);

        // Test case where the predicate's evaluation is false
        result = Functions.test(failableBiPredicate, "test", 5);
        assertFalse(result);

        // Test case where the predicate throws an exception
        Functions.FailableBiPredicate<String, Integer, Exception> failableBiPredicateException = 
            (string, integer) -> { throw new Exception("Test Exception"); };
        
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Functions.test(failableBiPredicateException, "test", 5);
        });
        
        assertEquals("Test Exception", exception.getCause().getMessage());
    }

    @Test
    public void testFailablePredicate() {
        // Instantiate all necessary variables here
        Functions.FailablePredicate<String, Exception> failablePredicate = 
            string -> string.length() > 0;

        // Test case where the predicate's evaluation is true
        boolean result = Functions.test(failablePredicate, "test");
        assertTrue(result);

        // Test case where the predicate's evaluation is false
        result = Functions.test(failablePredicate, "");
        assertFalse(result);

        // Test case where the predicate throws an exception
        Functions.FailablePredicate<String, Exception> failablePredicateException = 
            string -> { throw new Exception("Test Exception"); };
        
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Functions.test(failablePredicateException, "test");
        });
        
        assertEquals("Test Exception", exception.getCause().getMessage());
    }




    @Test
    public void tryWithResourcesActionSuccessResourcesSuccess() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        Functions.tryWithResources(action, resource);
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
    }
    
    @Test
    public void tryWithResourcesActionSuccessResourcesFailure() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        doThrow(new RuntimeException()).when(resource).run();
        assertThrows(RuntimeException.class, () -> Functions.tryWithResources(action, resource));
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
    }
    
    @Test
    public void tryWithResourcesActionFailureResourcesSuccess() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        doThrow(new RuntimeException()).when(action).run();
        assertThrows(RuntimeException.class, () -> Functions.tryWithResources(action, resource));
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
    }
    
    @Test
    public void tryWithResourcesActionFailureResourcesFailure() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        doThrow(new RuntimeException()).when(action).run();
        doThrow(new RuntimeException()).when(resource).run();
        assertThrows(RuntimeException.class, () -> Functions.tryWithResources(action, resource));
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
    }
    
    @Test
    public void tryWithResourcesActionSuccessResourcesSuccessWithErrorHandler() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableConsumer<Throwable, Throwable> errorHandler = Mockito.mock(Functions.FailableConsumer.class);
        Functions.tryWithResources(action, errorHandler, resource);
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
    }
    
    @Test
    public void tryWithResourcesActionFailureResourcesSuccessWithErrorHandler() throws Throwable {
        Functions.FailableRunnable<Throwable> action = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableRunnable<Throwable> resource = Mockito.mock(Functions.FailableRunnable.class);
        Functions.FailableConsumer<Throwable, Throwable> errorHandler = Mockito.mock(Functions.FailableConsumer.class);
        doThrow(new RuntimeException()).when(action).run();
        Functions.tryWithResources(action, errorHandler, resource);
        Mockito.verify(action).run();
        Mockito.verify(resource).run();
        Mockito.verify(errorHandler).accept(Mockito.any(RuntimeException.class));
    }




    @Test
    @DisplayName("asPredicate - success scenario")
    public void testAsPredicate_Success() throws Exception {
        // Given
        Functions.FailablePredicate<String, Exception> failablePredicate = input -> input.equals("test");

        // When
        Predicate<String> predicate = Functions.asPredicate(failablePredicate);

        // Then
        assertTrue(predicate.test("test"));
        assertFalse(predicate.test("invalid"));
    }

    @Test
    @DisplayName("asPredicate - exception scenario")
    public void testAsPredicate_Exception() {
        // Given
        Functions.FailablePredicate<String, Exception> failablePredicate = input -> {
            throw new Exception("Test Exception");
        };
        
        // When
        Predicate<String> predicate = Functions.asPredicate(failablePredicate);

        // Then
        assertThrows(UndeclaredThrowableException.class, () -> predicate.test("test"));
    }




    @Test
    public void asSupplier_ShouldReturnSupplier_WhenFailableSupplierIsProvided() {
        // Arrange
        String expectedValue = "Hello, World!";
        Functions.FailableSupplier<String, Exception> failableSupplierMock = mock(Functions.FailableSupplier.class);

        // Use Mockito to define the behavior of the mock object
        try {
            when(failableSupplierMock.get()).thenReturn(expectedValue);
        } catch (Exception e) {
            fail("Exception thrown during test setup");
        }

        // Act
        Supplier<String> supplier = Functions.asSupplier(failableSupplierMock);
        String actualValue = supplier.get();

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void asSupplier_ShouldThrowRuntimeException_WhenFailableSupplierThrowsException() {
        // Arrange
        Functions.FailableSupplier<String, Exception> failableSupplierMock = mock(Functions.FailableSupplier.class);

        // Use Mockito to define the behavior of the mock object
        try {
            when(failableSupplierMock.get()).thenThrow(new Exception("Test Exception"));
        } catch (Exception e) {
            fail("Exception thrown during test setup");
        }

        // Act
        Supplier<String> supplier = Functions.asSupplier(failableSupplierMock);

        // Assert
        assertThrows(RuntimeException.class, supplier::get);
    }



    
    @Test
    public void testGet_whenSupplierReturnsValue() throws Exception {
        // Instantiate necessary variables
        Functions.FailableSupplier<String, Exception> supplier = mock(Functions.FailableSupplier.class);

        // Mock behavior
        when(supplier.get()).thenReturn("Test");

        // Test method
        String result = Functions.get(supplier);

        // Assert results
        assertEquals("Test", result);
    }

    @Test
    public void testGet_whenSupplierThrowsException() throws Exception {
        // Instantiate necessary variables
        Functions.FailableSupplier<String, Exception> supplier = mock(Functions.FailableSupplier.class);

        // Mock behavior
        when(supplier.get()).thenThrow(new Exception("Test exception"));

        // Test method
        Executable executable = () -> Functions.get(supplier);

        // Assert results
        Exception exception = assertThrows(RuntimeException.class, executable);
        assertEquals("Test exception", exception.getCause().getMessage());
    }




    @Test
    public void testAsCallable() throws Exception {
        // Instantiate all necessary variables here
        Functions.FailableCallable<String, Exception> failableCallable = mock(Functions.FailableCallable.class);

        // Define behavior of the mock
        when(failableCallable.call()).thenReturn("Test");

        // Write the test code here following the given rules
        Callable<String> result = Functions.asCallable(failableCallable);
        assertNotNull(result);
        assertEquals("Test", result.call());

        verify(failableCallable, times(1)).call();
    }

    @Test
    public void testAsCallable_Exception() throws Exception {
        // Instantiate all necessary variables here
        Functions.FailableCallable<String, Exception> failableCallable = mock(Functions.FailableCallable.class);

        // Define behavior of the mock
        when(failableCallable.call()).thenThrow(new Exception("Test Exception"));

        // Write the test code here following the given rules
        Callable<String> result = Functions.asCallable(failableCallable);
        assertNotNull(result);
        assertThrows(ExecutionException.class, result::call);

        verify(failableCallable, times(1)).call();
    }




    @Test
    public void asBiPredicate_whenPredicateDoesNotThrowException_shouldReturnTrue() {
        // Instantiate necessary variables
        Functions.FailableBiPredicate<String, String, Exception> failableBiPredicate = (s1, s2) -> true;

        // Call the method to test
        BiPredicate<String, String> biPredicate = Functions.asBiPredicate(failableBiPredicate);

        // Assert results
        assertTrue(biPredicate.test("test1", "test2"));
    }

    @Test
    public void asBiPredicate_whenPredicateThrowsException_shouldReturnFalse() {
        // Instantiate necessary variables
        Functions.FailableBiPredicate<String, String, Exception> failableBiPredicate = (s1, s2) -> {
            throw new Exception("Test exception");
        };

        // Call the method to test
        BiPredicate<String, String> biPredicate = Functions.asBiPredicate(failableBiPredicate);

        // Assert results
        assertFalse(biPredicate.test("test1", "test2"));
    }

    @Test
    public void asBiPredicate_whenPredicateReturnsFalse_shouldReturnFalse() {
        // Instantiate necessary variables
        Functions.FailableBiPredicate<String, String, Exception> failableBiPredicate = (s1, s2) -> false;

        // Call the method to test
        BiPredicate<String, String> biPredicate = Functions.asBiPredicate(failableBiPredicate);

        // Assert results
        assertFalse(biPredicate.test("test1", "test2"));
    }

}