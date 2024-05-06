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

    @Test
    public void testRun() throws Throwable {
        // Instantiate all necessary variables here
        Functions.FailableRunnable<Throwable> runnable = mock(Functions.FailableRunnable.class);

        // Write the test code here following the given rules
        Functions.run(runnable);

        verify(runnable, times(1)).run();
    }


}