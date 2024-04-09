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


import org.junit.jupiter.api.*;

import java.util.function.Supplier;

public class SuppliersTest {
    Suppliers nulSupplier = null;
    @Test
    void testGetWithNonNullSupplier() {
        Supplier<String> supplier = () -> "Hello";
        String result = Suppliers.get(supplier);
        Assertions.assertEquals("Hello", result);
    }
    
    @Test
    void testGetWithNullSupplier() {
        String result = Suppliers.get(null);
        Assertions.assertNull(result);
    }
//    @Test
//    void testNulReturnsNull() {
//        Assertions.assertNull(nulSupplier.get());
//    }
//
//    @Test
//    void testNulDoesNotThrowException() {
//        Assertions.assertDoesNotThrow(nulSupplier::get);
//    }

}