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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class NotImplementedExceptionTest {
    @Test
    public void testGetCodeNull() {
        NotImplementedException exception = new NotImplementedException();
        Assertions.assertNull(exception.getCode());
    }
    
    @Test
    public void testGetCodeEmpty() {
        NotImplementedException exception = new NotImplementedException("", "");
        Assertions.assertEquals("", exception.getCode());
    }
    
    @Test
    public void testGetCode() {
        NotImplementedException exception = new NotImplementedException("message", "code");
        Assertions.assertEquals("code", exception.getCode());
    }
    
    @Test
    public void testGetCodeWithMessage() {
        NotImplementedException exception = new NotImplementedException("message");
        Assertions.assertNull(exception.getCode());
    }
    
    @Test
    public void testGetCodeWithCause() {
        NotImplementedException exception = new NotImplementedException(new RuntimeException());
        Assertions.assertNull(exception.getCode());
    }
    
    @Test
    public void testGetCodeWithCauseAndCode() {
        NotImplementedException exception = new NotImplementedException(new RuntimeException(), "code");
        Assertions.assertEquals("code", exception.getCode());
    }
    
    @Test
    public void testGetCodeWithMessageAndCause() {
        NotImplementedException exception = new NotImplementedException("message", new RuntimeException());
        Assertions.assertNull(exception.getCode());
    }
    
    @Test
    public void testGetCodeWithMessageCauseAndCode() {
        NotImplementedException exception = new NotImplementedException("message", new RuntimeException(), "code");
        Assertions.assertEquals("code", exception.getCode());
    }

}