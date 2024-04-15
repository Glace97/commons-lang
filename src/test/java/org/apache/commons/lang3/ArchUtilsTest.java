package org.apache.commons.lang3;

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


import org.apache.commons.lang3.arch.Processor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ArchUtilsTest {

    private ArchUtils archUtils;

    @Test
    void testGetProcessor_ReturnsProcessorWhenSupported() {
        Processor processor = archUtils.getProcessor("x86");
        assertNotNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsNullWhenProcessorNotSupported() {
        Processor processor = archUtils.getProcessor("unknown");
        assertNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsNullWhenValueIsNull() {
        Processor processor = archUtils.getProcessor(null);
        assertNull(processor);
    }

    @Test
    void testGetProcessor_ReturnsProcessorForCurrentJVM() {
        Processor processor = archUtils.getProcessor();
        assertNotNull(processor);
    }


}