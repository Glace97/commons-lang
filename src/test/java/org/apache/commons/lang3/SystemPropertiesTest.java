package org.apache.commons.lang3;

import static org.apache.commons.lang3.SystemUtils.JAVA_SPECIFICATION_NAME;
import static org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.PROPERTY_NAME;
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
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import java.security.AccessControlException;
import java.util.Properties;
import java.util.function.IntSupplier;

public class SystemPropertiesTest {


    private SecurityManager originalSecurityManager;

    @BeforeEach
    void setUp(TestInfo testInfo) {
        originalSecurityManager = System.getSecurityManager();

    }

    @AfterEach
    void tearDown() {
        System.setSecurityManager(originalSecurityManager);
    }

}