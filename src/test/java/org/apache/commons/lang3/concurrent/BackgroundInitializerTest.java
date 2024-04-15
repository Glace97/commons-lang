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

import java.util.concurrent.*;

public class BackgroundInitializerTest {

    @Test
    void testBuilder() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        assertNotNull(builder);
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
    void testGetFuture() {
        BackgroundInitializer.Builder<BackgroundInitializer<String>, String> builder = BackgroundInitializer.builder();
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        BackgroundInitializer<String> initializer = builder.setExternalExecutor(externalExecutor).get();
        initializer.start();
        Future<String> future = initializer.getFuture();
        assertNotNull(future);
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

}