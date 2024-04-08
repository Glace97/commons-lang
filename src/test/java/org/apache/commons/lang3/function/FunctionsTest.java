package org.apache.commons.lang3.function;

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

public class FunctionsTest {
    @Test
    public void testFunctionReturnsArgument() {
        Function<Integer, Integer> function = Functions.function(x -> x + 1);
        int result = function.apply(5);
        Assertions.assertEquals(6, result);
    }
    
    @Test
    public void testFunctionWithNullArgument() {
        Function<String, Integer> function = Functions.function(Integer::parseInt);
        Integer result = function.apply(null);
        Assertions.assertNull(result);
    }
    
    @Test
    public void testFunctionWithNegativeArgument() {
        Function<Integer, Integer> function = Functions.function(x -> x * -1);
        int result = function.apply(-5);
        Assertions.assertEquals(5, result);
    }
    
    @Test
    public void testFunctionWithZeroArgument() {
        Function<Integer, Integer> function = Functions.function(x -> x * 0);
        int result = function.apply(10);
        Assertions.assertEquals(0, result);
    }

}