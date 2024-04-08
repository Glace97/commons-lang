package org.apache.commons.lang3.reflect;

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

public class InheritanceUtilsTest {
    @Test
    void testDistance_SameClass_ReturnsZero() {
        Assertions.assertEquals(0, InheritanceUtils.distance(String.class, String.class));
    }
    
    @Test
    void testDistance_ChildNull_ReturnsNegativeOne() {
        Assertions.assertEquals(-1, InheritanceUtils.distance(null, String.class));
    }
    
    @Test
    void testDistance_ParentNull_ReturnsNegativeOne() {
        Assertions.assertEquals(-1, InheritanceUtils.distance(String.class, null));
    }
    
    @Test
    void testDistance_ChildAndParentNull_ReturnsNegativeOne() {
        Assertions.assertEquals(-1, InheritanceUtils.distance(null, null));
    }
    
    @Test
    void testDistance_DirectInheritance_ReturnsOne() {
        Assertions.assertEquals(1, InheritanceUtils.distance(ChildClass.class, ParentClass.class));
    }
    
    @Test
    void testDistance_IndirectInheritance_ReturnsTwo() {
        Assertions.assertEquals(2, InheritanceUtils.distance(GrandChildClass.class, ParentClass.class));
    }
    
    @Test
    void testDistance_NoInheritance_ReturnsNegativeOne() {
        Assertions.assertEquals(-1, InheritanceUtils.distance(NoInheritanceClass.class, ParentClass.class));
    }
    
    @Test
    void testDistance_ChildIsInterface_ReturnsNegativeOne() {
        Assertions.assertEquals(-1, InheritanceUtils.distance(InterfaceClass.class, ParentClass.class));
    }

}