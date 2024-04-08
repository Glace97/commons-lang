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

public class FutureTasksTest {
    @Test
    void testRun() throws Exception {
        // Test with a Callable that returns a String
        Callable<String> callable1 = () -> "Hello, World!";
        FutureTask<String> futureTask1 = FutureTasks.run(callable1);
        Assertions.assertEquals("Hello, World!", futureTask1.get());
    
        // Test with a Callable that returns an Integer
        Callable<Integer> callable2 = () -> 42;
        FutureTask<Integer> futureTask2 = FutureTasks.run(callable2);
        Assertions.assertEquals(42, futureTask2.get());
    
        // Test with a Callable that throws an Exception
        Callable<Object> callable3 = () -> {
            throw new Exception("Test Exception");
        };
        FutureTask<Object> futureTask3 = FutureTasks.run(callable3);
        Assertions.assertThrows(Exception.class, futureTask3::get);
    
        // Test with a Callable that takes a long time to execute
        Callable<String> callable4 = () -> {
            Thread.sleep(5000);
            return "Done";
        };
        FutureTask<String> futureTask4 = FutureTasks.run(callable4);
        Assertions.assertEquals("Done", futureTask4.get());
    }

}