package org.apache.commons.lang3;

import org.apache.commons.lang3.function.FailableConsumer;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.Streams.FailableStream;
import org.apache.commons.lang3.function.FailablePredicate;
import java.util.stream.Stream;
import java.util.function.Supplier;
import org.apache.commons.lang3.function.FailableSupplier;
import org.apache.commons.lang3.exception.ExceptionUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.function.FailableRunnable;
import java.io.IOException;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.mockito.*;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.Failable;
import java.util.function.Predicate;

import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.UndeclaredThrowableException;
import org.mockito.stubbing.Answer;
import org.apache.commons.lang3.function.FailableFunction;
import java.util.function.BiConsumer;
import java.util.concurrent.Callable;
import java.util.function.BiPredicate;
import org.apache.commons.lang3.function.FailableCallable;
import java.util.function.Consumer;

import org.apache.commons.lang3.function.FailableBiConsumer;
import java.util.function.Function;
import java.io.UncheckedIOException;

public class FunctionsTest {





//    @Test
//    public void testAsCallable() throws Exception {
//        // Instantiate all necessary variables here
//        FailableCallable<String, Exception> failableCallable = mock(FailableCallable.class);
//        String expectedResult = "Test Result";
//
//        // Mock the behavior of the failableCallable
//        when(failableCallable.call()).thenReturn(expectedResult);
//
//        // Convert the failableCallable to a standard callable using asCallable() method
//        Callable<String> callable = Functions.asCallable(failableCallable);
//
//        // Call the callable and assert the result
//        String result = callable.call();
//
//        assertEquals(expectedResult, result);
//        verify(failableCallable, times(1)).call();
//    }





    @Test
    public void testGet() {
        // Instantiate all necessary variables here
        Functions.FailableSupplier<String, RuntimeException> supplier = mock(Functions.FailableSupplier.class);
        String expectedResult = "Test Result";

        // Set up mock behavior
        try {
            when(supplier.get()).thenReturn(expectedResult);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Invoke the method to be tested
        String actualResult = Functions.get(supplier);

        // Verify the result
        assertEquals(expectedResult, actualResult);

        // Verify the supplier was called
        try {
            verify(supplier, times(1)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }









//    @Test
//    public void testTryWithResources() throws Throwable {
//        // Mock the dependencies
//        FailableRunnable<? extends Throwable> action = mock(FailableRunnable.class);
//        FailableConsumer<Throwable, ? extends Throwable> errorHandler = mock(FailableConsumer.class);
//        FailableRunnable<? extends Throwable> resource1 = mock(FailableRunnable.class);
//        FailableRunnable<? extends Throwable> resource2 = mock(FailableRunnable.class);
//
//        // Capture the arguments passed to the mocks
//        ArgumentCaptor<Throwable> errorHandlerCaptor = ArgumentCaptor.forClass(Throwable.class);
//
//        // Call the method under test
//        Functions.tryWithResources(action, errorHandler, resource1, resource2);
//
//        // Verify that the dependencies are invoked in the correct order
//        InOrder inOrder = inOrder(action, resource1, resource2, errorHandler);
//
//        inOrder.verify(action).run();
//        inOrder.verify(resource1).run();
//        inOrder.verify(resource2).run();
//        inOrder.verifyNoMoreInteractions();
//
//        // Verify that the errorHandler is invoked with the correct argument
//        verify(errorHandler).accept(errorHandlerCaptor.capture());
//        Throwable error = errorHandlerCaptor.getValue();
//        assertNotNull(error);
//    }







//    @Test
//    public void testStream_WithEmptyCollection_ShouldReturnEmptyStream() {
//        // Instantiate all necessary variables here
//        Collection<Object> emptyCollection = new ArrayList<>();
//
//        // Write the test code here following the given rules
//        FailableStream<Object> stream = Functions.stream(emptyCollection);
//
//        assertTrue(stream.isEmpty());
//    }
//
//    @Test
//    public void testStream_WithNonEmptyCollection_ShouldReturnStreamWithSameElements() {
//        // Instantiate all necessary variables here
//        Collection<Integer> collection = Arrays.asList(1, 2, 3);
//
//        // Write the test code here following the given rules
//        FailableStream<Integer> stream = Functions.stream(collection);
//
//        List<Integer> result = stream.toList();
//        assertEquals(collection.size(), result.size());
//        assertTrue(result.containsAll(collection));
//    }

//    @Test
//    public void testStream_WithFailablePredicate_ShouldApplyPredicateOnAllElements() throws Exception {
//        // Instantiate all necessary variables here
//        Collection<Integer> collection = Arrays.asList(1, 2, 3);
//        FailablePredicate<Integer, Exception> failablePredicate = mock(FailablePredicate.class);
//
//        // Configure the mock
//        when(failablePredicate.test(anyInt())).thenReturn(true);
//
//        // Write the test code here following the given rules
//        FailableStream<Integer> stream = Functions.stream(collection);
//        stream.allMatch(failablePredicate);
//
//        // Verify the mock
//        verify(failablePredicate, times(collection.size())).test(anyInt());
//    }
//
//    @Test
//    public void testStream_WithFailableFunction_ShouldApplyFunctionToAllElements() throws Exception {
//        // Instantiate all necessary variables here
//        Collection<Integer> collection = Arrays.asList(1, 2, 3);
//        FailableFunction<Integer, String, Exception> failableFunction = mock(FailableFunction.class);
//
//        // Configure the mock
//        when(failableFunction.apply(anyInt())).thenAnswer((Answer<String>) invocation -> "Result");
//
//        // Write the test code here following the given rules
//        FailableStream<Integer> stream = Functions.stream(collection);
//        stream.map(failableFunction);
//
//        // Verify the mock
//        verify(failableFunction, times(collection.size())).apply(anyInt());
//    }
//
//    @Test
//    public void testStream_WithFailableConsumer_ShouldApplyConsumerToAllElements() throws Exception {
//        // Instantiate all necessary variables here
//        Collection<Integer> collection = Arrays.asList(1, 2, 3);
//        FailableConsumer<Integer, Exception> failableConsumer = mock(FailableConsumer.class);
//
//        // Write the test code here following the given rules
//        FailableStream<Integer> stream = Functions.stream(collection);
//        stream.forEach(failableConsumer);
//
//        // Verify the mock
//        verify(failableConsumer, times(collection.size())).accept(anyInt());
//    }





//    @Test
//    public void call_shouldReturnResultFromCallable() throws Exception {
//        // Instantiate all necessary variables here
//        FailableCallable<String, Exception> callable = mock(FailableCallable.class);
//        String expectedResult = "result";
//        when(callable.call()).thenReturn(expectedResult);
//
//        // Write the test code here following the given rules
//        String actualResult = Functions.call(callable);
//
//        assertEquals(expectedResult, actualResult);
//        verify(callable, times(1)).call();
//    }
//
//    @Test
//    public void call_shouldRethrowExceptionFromCallable() throws Exception {
//        // Instantiate all necessary variables here
//        FailableCallable<String, Exception> callable = mock(FailableCallable.class);
//        Exception exception = new Exception("error");
//        when(callable.call()).thenThrow(exception);
//
//        // Write the test code here following the given rules
//        assertThrows(RuntimeException.class, () -> Functions.call(callable));
//        verify(callable, times(1)).call();
//    }





    @Test
    public void testAccept_ShouldCallConsumer() throws Exception {
        // Instantiate all necessary variables here
        Functions.FailableBiConsumer<String, Integer, Exception> consumer = Mockito.mock(Functions.FailableBiConsumer.class);
        String object1 = "test";
        Integer object2 = 5;

        // Write the test code here following the given rules
        Functions.accept(consumer, object1, object2);

        // Verify that the consumer's accept method was called with the correct arguments
        verify(consumer).accept(object1, object2);
    }

    @Test
    public void testAccept_ShouldRethrowExceptionAsRuntimeException() throws Exception {
        // Instantiate all necessary variables here
        Functions.FailableBiConsumer<String, Integer, Exception> consumer = Mockito.mock(Functions.FailableBiConsumer.class);
        String object1 = "test";
        Integer object2 = 5;
        Exception exception = new Exception("Test Exception");

        // Configure the consumer to throw an exception
        doThrow(exception).when(consumer).accept(object1, object2);

        // Write the test code here following the given rules
        assertThrows(RuntimeException.class, () -> Functions.accept(consumer, object1, object2));
    }




//    @Test
//    public void testAsRunnable() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableRunnable<IOException> failableRunnable = mock(FailableRunnable.class);
//        Runnable runnable = Functions.asRunnable(failableRunnable);
//
//        // Write the test code here following the given rules
//        doThrow(IOException.class).when(failableRunnable).run();
//        assertThrows(IOException.class, () -> runnable.run());
//    }





    @Test
    public void testRethrow_RuntimeException() {
        assertThrows(RuntimeException.class, () -> Functions.rethrow(new RuntimeException()));
    }
    
    @Test
    public void testRethrow_Error() {
        assertThrows(Error.class, () -> Functions.rethrow(new Error()));
    }
    
    @Test
    public void testRethrow_IOException() {
        assertThrows(UncheckedIOException.class, () -> Functions.rethrow(new IOException()));
    }
    
    @Test
    public void testRethrow_OtherException() {
        assertThrows(UndeclaredThrowableException.class, () -> Functions.rethrow(new Exception()));
    }


//    @Test
//    public void testAsBiConsumer() throws Exception {
//        // Instantiate all necessary variables here
//        FailableBiConsumer<String, String, Exception> failableBiConsumer = mock(FailableBiConsumer.class);
//        BiConsumer<String, String> biConsumer = Functions.asBiConsumer(failableBiConsumer);
//        String input1 = "input1";
//        String input2 = "input2";
//
//        // Write the test code here following the given rules
//        assertDoesNotThrow(() -> biConsumer.accept(input1, input2));
//        verify(failableBiConsumer, times(1)).accept(input1, input2);
//    }



    @Test
    public void testRun() throws Throwable {
        // Instantiate all necessary variables here
        Functions.FailableRunnable<Throwable> runnable = mock(Functions.FailableRunnable.class);

        // Write the test code here following the given rules
        Functions.run(runnable);

        verify(runnable, times(1)).run();
    }




//    @Test
//    public void asFunction_ShouldReturnFunctionThatAppliesFailableFunction() throws Exception {
//        // Instantiate all necessary variables here
//        FailableFunction<String, Integer, Exception> failableFunction = mock(FailableFunction.class);
//        when(failableFunction.apply(anyString())).thenReturn(10);
//
//        // Write the test code here following the given rules
//        Function<String, Integer> function = Functions.asFunction(failableFunction);
//        Integer result = function.apply("input");
//
//        assertEquals(10, result);
//        verify(failableFunction).apply("input");
//    }

//    @Test
//    public void asFunction_ShouldThrowException_WhenFailableFunctionThrowsException() throws Exception {
//        // Instantiate all necessary variables here
//        FailableFunction<String, Integer, Exception> failableFunction = mock(FailableFunction.class);
//        when(failableFunction.apply(anyString())).thenThrow(new Exception());
//
//        // Write the test code here following the given rules
//        Function<String, Integer> function = Functions.asFunction(failableFunction);
//
//        assertThrows(Exception.class, () -> function.apply("input"));
//        verify(failableFunction).apply("input");
//    }






//    @Test
//    public void apply_FailableBiFunction_ReturnsResult() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableBiFunction<Integer, Integer, Integer, Throwable> function = mock(FailableBiFunction.class);
//        int input1 = 10;
//        int input2 = 5;
//        int expectedResult = 15;
//        when(function.apply(input1, input2)).thenReturn(expectedResult);
//
//        // Write the test code here following the given rules
//        int actualResult = Functions.apply(function, input1, input2);
//
//        assertEquals(expectedResult, actualResult);
//        verify(function).apply(input1, input2);
//    }
//
//    @Test
//    public void apply_FailableBiFunction_ThrowsException() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableBiFunction<Integer, Integer, Integer, Throwable> function = mock(FailableBiFunction.class);
//        int input1 = 10;
//        int input2 = 0;
//        Throwable exception = new IllegalArgumentException("Divide by zero");
//        when(function.apply(input1, input2)).thenThrow(exception);
//
//        // Write the test code here following the given rules
//        assertThrows(RuntimeException.class, () -> Functions.apply(function, input1, input2));
//        verify(function).apply(input1, input2);
//    }
//
//    @Test
//    public void apply_FailableFunction_ReturnsResult() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableFunction<Integer, Integer, Throwable> function = mock(FailableFunction.class);
//        int input = 10;
//        int expectedResult = 100;
//        when(function.apply(input)).thenReturn(expectedResult);
//
//        // Write the test code here following the given rules
//        int actualResult = Functions.apply(function, input);
//
//        assertEquals(expectedResult, actualResult);
//        verify(function).apply(input);
//    }
//
//    @Test
//    public void apply_FailableFunction_ThrowsException() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableFunction<Integer, Integer, Throwable> function = mock(FailableFunction.class);
//        int input = -10;
//        Throwable exception = new IllegalArgumentException("Negative input");
//        when(function.apply(input)).thenThrow(exception);
//
//        // Write the test code here following the given rules
//        assertThrows(RuntimeException.class, () -> Functions.apply(function, input));
//        verify(function).apply(input);
//    }




//    @Test
//    public void testAsBiFunction() throws Exception {
//        // Instantiate all necessary variables here
//        FailableBiFunction<String, Integer, Double, IOException> failableBiFunction = mock(FailableBiFunction.class);
//        BiFunction<String, Integer, Double> biFunction = Functions.asBiFunction(failableBiFunction);
//        String input1 = "input1";
//        Integer input2 = 5;
//        Double expectedResult = 10.0;
//
//        // Set up mock behavior
//        when(failableBiFunction.apply(input1, input2)).thenReturn(expectedResult);
//
//        // Execute the code to be tested
//        Double actualResult = biFunction.apply(input1, input2);
//
//        // Verify the result
//        assertEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(failableBiFunction).apply(input1, input2);
//    }



//
//    @Test
//    public void testAsConsumer() throws Exception {
//        // Instantiate all necessary variables here
//        FailableConsumer<String, Exception> failableConsumer = mock(FailableConsumer.class);
//        Consumer<String> consumer = Functions.asConsumer(failableConsumer);
//        String input = "test";
//
//        // Write the test code here following the given rules
//        assertDoesNotThrow(() -> consumer.accept(input));
//        verify(failableConsumer, times(1)).accept(input);
//    }
//






//    @Test
//    public void testTestWithFailableBiPredicate() throws Throwable {
//        // Instantiate all necessary variables here
//        String object1 = "hello";
//        Integer object2 = 5;
//        boolean expectedResult = true;
//
//        FailableBiPredicate<String, Integer, Throwable> predicate = mock(FailableBiPredicate.class);
//        when(predicate.test(object1, object2)).thenReturn(expectedResult);
//
//        // Write the test code here following the given rules
//        boolean result = Functions.test(predicate, object1, object2);
//
//        // Verify the result
//        assertEquals(expectedResult, result);
//    }
//
//    @Test
//    public void testTestWithFailablePredicate() throws Throwable {
//        // Instantiate all necessary variables here
//        String object = "world";
//        boolean expectedResult = true;
//
//        FailablePredicate<String, Throwable> predicate = mock(FailablePredicate.class);
//        when(predicate.test(object)).thenReturn(expectedResult);
//
//        // Write the test code here following the given rules
//        boolean result = Functions.test(predicate, object);
//
//        // Verify the result
//        assertEquals(expectedResult, result);
//    }





//    @Test
//    public void testAsPredicate() throws Throwable {
//        // Instantiate all necessary variables here
//        FailablePredicate<Integer, Throwable> failablePredicate = mock(FailablePredicate.class);
//        Functions functions = new Functions();
//
//        // Write the test code here following the given rules
//        Predicate<Integer> predicate = functions.asPredicate(failablePredicate);
//        assertNotNull(predicate);
//
//        // Verify that the failablePredicate is called when the predicate is tested
//        Integer input = 10;
//        predicate.test(input);
//        verify(failablePredicate).test(input);
//    }




//    @Test
//    public void testAsSupplier() throws Exception {
//        // Mock the FailableSupplier
//        FailableSupplier<String, Exception> failableSupplier = mock(FailableSupplier.class);
//
//        // Define the expected result
//        String expectedResult = "Test";
//
//        // Define the behavior of the failableSupplier mock
//        when(failableSupplier.get()).thenReturn(expectedResult);
//
//        // Convert the failableSupplier to a regular Supplier using asSupplier()
//        Supplier<String> supplier = Functions.asSupplier(failableSupplier);
//
//        // Call the get() method on the supplier
//        String actualResult = supplier.get();
//
//        // Verify that the failableSupplier.get() method was called
//        verify(failableSupplier, times(1)).get();
//
//        // Assert that the actual result matches the expected result
//        assertEquals(expectedResult, actualResult);
//    }






//    @Test
//    public void testAsBiPredicate() throws Throwable {
//        // Instantiate all necessary variables here
//        FailableBiPredicate<Integer, Integer, IOException> failableBiPredicate = (i, j) -> i > j;
//
//        // Mock the FailableBiPredicate using Mockito
//        FailableBiPredicate mockPredicate = mock(FailableBiPredicate.class);
//
//        // Set up the mock behavior
//        when(mockPredicate.test(anyInt(), anyInt())).thenReturn(true);
//
//        // Convert the FailableBiPredicate to a standard BiPredicate
//        BiPredicate<Integer, Integer> biPredicate = Functions.asBiPredicate(mockPredicate);
//
//        // Test the converted BiPredicate
//        assertTrue(biPredicate.test(5, 3));
//
//        // Verify that the mockPredicate was called
//        verify(mockPredicate).test(anyInt(), anyInt());
//    }

}