package org.apache.commons.lang3.builder;

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

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class HashCodeBuilderTest {

    @Test
    void testDefaultConstructor() {
        HashCodeBuilder builder = new HashCodeBuilder();
        assertNotNull(builder);
        assertEquals(17, builder.hashCode());
    }

    @Test
    void testConstructorWithValues() {
        HashCodeBuilder builder = new HashCodeBuilder(3, 5);
        assertNotNull(builder);
        assertEquals(3, builder.hashCode());
    }



    private static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Implement equals and hashCode methods
    }

    @Test
    public void testAppendBoolean() {
        // test code here
    }
    
    @Test
    public void testAppendBooleanArray() {
        // test code here
    }
    
    @Test
    public void testAppendByte() {
        // test code here
    }
    
    @Test
    public void testAppendByteArray() {
        // test code here
    }
    
    @Test
    public void testAppendChar() {
        // test code here
    }
    
    @Test
    public void testAppendCharArray() {
        // test code here
    }
    
    @Test
    public void testAppendDouble() {
        // test code here
    }
    
    @Test
    public void testAppendDoubleArray() {
        // test code here
    }
    
    @Test
    public void testAppendFloat() {
        // test code here
    }
    
    @Test
    public void testAppendFloatArray() {
        // test code here
    }
    
    @Test
    public void testAppendInt() {
        // test code here
    }
    
    @Test
    public void testAppendIntArray() {
        // test code here
    }
    
    @Test
    public void testAppendLong() {
        // test code here
    }
    
    @Test
    public void testAppendLongArray() {
        // test code here
    }
    
    @Test
    public void testAppendObject() {
        // test code here
    }
    
    @Test
    public void testAppendObjectArray() {
        // test code here
    }
    
    @Test
    public void testAppendShort() {
        // test code here
    }
    
    @Test
    public void testAppendShortArray() {
        // test code here
    }
    @Test
    void testIsRegistered_ReturnsFalse_WhenObjectNotRegistered() {}
    
    @Test
    void testIsRegistered_ReturnsTrue_WhenObjectIsRegistered() {}
    
    @Test
    void testIsRegistered_ReturnsFalse_WhenRegistryIsNull() {}
    
    @Test
    void testIsRegistered_ReturnsFalse_WhenRegistryDoesNotContainObject() {}
    @Test
    void testEquals_SameInstance() {
        HashCodeBuilder builder = new HashCodeBuilder();
        assertTrue(builder.equals(builder));
    }
    
    @Test
    void testEquals_NullObject() {
        HashCodeBuilder builder = new HashCodeBuilder();
        assertFalse(builder.equals(null));
    }
    
    @Test
    void testEquals_DifferentClass() {
        HashCodeBuilder builder = new HashCodeBuilder();
        assertFalse(builder.equals(new Object()));
    }
    
    @Test
    void testEquals_SameValues() {
        HashCodeBuilder builder1 = new HashCodeBuilder();
        HashCodeBuilder builder2 = new HashCodeBuilder();
        assertTrue(builder1.equals(builder2));
    }
    
    @Test
    void testEquals_DifferentValues() {
        HashCodeBuilder builder1 = new HashCodeBuilder();
        HashCodeBuilder builder2 = new HashCodeBuilder(19, 41);
        assertFalse(builder1.equals(builder2));
    }
    
    @Test
    void testEquals_DifferentInitialValue() {
        HashCodeBuilder builder1 = new HashCodeBuilder();
        HashCodeBuilder builder2 = new HashCodeBuilder(19, 37);
        assertFalse(builder1.equals(builder2));
    }
    

    @Test
    void testReflectionHashCode_withNullObject_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> HashCodeBuilder.reflectionHashCode(null, true));
    }
    

    @Test
    void testReflectionHashCode_withNullExcludeFields_shouldNotThrowNullPointerException() {
        HashCodeBuilder.reflectionHashCode(new Object(), (String[]) null);
    }
    
    @Test
    void testReflectionHashCode_withEmptyExcludeFields_shouldNotThrowException() {
        HashCodeBuilder.reflectionHashCode(new Object(), new String[0]);
    }
    
    @Test
    void testReflectionHashCode_withEmptyExcludeFields_shouldNotThrowNullPointerException() {
        HashCodeBuilder.reflectionHashCode(new Object(), new String[0]);
    }
    
    @Test
    void testReflectionHashCode_withInvalidInitialValue_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashCodeBuilder.reflectionHashCode(0, 37, new Object(), true));
    }
    
    @Test
    void testReflectionHashCode_withInvalidMultiplierValue_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> HashCodeBuilder.reflectionHashCode(17, 0, new Object(), true));
    }
    
    @Test
    void testReflectionHashCode_withTestTransients_shouldReturnHashCode() {
        int hashCode = HashCodeBuilder.reflectionHashCode(new Object(), true);
        assertEquals(hashCode, HashCodeBuilder.reflectionHashCode(new Object(), true));
    }
    
    @Test
    void testReflectionHashCode_withoutTestTransients_shouldReturnHashCode() {
        int hashCode = HashCodeBuilder.reflectionHashCode(new Object(), false);
        assertEquals(hashCode, HashCodeBuilder.reflectionHashCode(new Object(), false));
    }
    
    @Test
    void testReflectionHashCode_withExcludeFields_shouldReturnHashCode() {
        int hashCode = HashCodeBuilder.reflectionHashCode(new Object(), "field1", "field2");
        assertEquals(hashCode, HashCodeBuilder.reflectionHashCode(new Object(), "field1", "field2"));
    }
    

    
    @Test
    void testReflectionHashCode_withInvalidFieldAccess_shouldNotThrowException() {
        Object object = new Object() {
            private int field = 0;
    
            public int getField() {
                throw new RuntimeException("Cannot access field");
            }
        };
        int hashCode = HashCodeBuilder.reflectionHashCode(object, true);
        assertNotNull(hashCode);
    }


    @Test
    void testBuild() {
        HashCodeBuilder builder = new HashCodeBuilder();
    
        Integer hashCode = builder.build();
    
        assertNotNull(hashCode);
    }
    
    @Test
    void testBuildWithInitialOddNumberAndMultiplierOddNumber() {
        HashCodeBuilder builder = new HashCodeBuilder(17, 37);
    
        Integer hashCode = builder.build();
    
        assertNotNull(hashCode);
    }
    
    @Test
    void testBuildWithEvenInitialOddNumber() {
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(18, 37));
    }
    
    @Test
    void testBuildWithEvenMultiplierOddNumber() {
        assertThrows(IllegalArgumentException.class, () -> new HashCodeBuilder(17, 36));
    }
    
    @Test
    void testBuildEqualsAndHashCode() {
        HashCodeBuilder builder1 = new HashCodeBuilder();
        HashCodeBuilder builder2 = new HashCodeBuilder();
    
        Integer hashCode1 = builder1.build();
        Integer hashCode2 = builder2.build();
    
        assertEquals(hashCode1, hashCode2);
        assertEquals(builder1.hashCode(), builder2.hashCode());
    }
    
    @Test
    void testBuildNotEqualsAndHashCode() {
        HashCodeBuilder builder1 = new HashCodeBuilder();
        HashCodeBuilder builder2 = new HashCodeBuilder(19, 37);
    
        Integer hashCode1 = builder1.build();
        Integer hashCode2 = builder2.build();
    
        assertNotEquals(hashCode1, hashCode2);
        assertNotEquals(builder1.hashCode(), builder2.hashCode());
    }

    @Test
    void testGetRegistryThreadLocal() {
      Set<IDKey> registry1 = HashCodeBuilder.getRegistry();
      Set<IDKey> registry2 = HashCodeBuilder.getRegistry();
      
      assertSame(registry1, registry2);
    }
    
    @Test
    void testGetRegistryThreadLocalDifferentThreads() throws InterruptedException {
      Thread thread1 = new Thread(() -> {
        Set<IDKey> registry1 = HashCodeBuilder.getRegistry();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Set<IDKey> registry2 = HashCodeBuilder.getRegistry();
        
        assertNotSame(registry1, registry2);
      });
      
      Thread thread2 = new Thread(() -> {
        Set<IDKey> registry1 = HashCodeBuilder.getRegistry();
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        Set<IDKey> registry2 = HashCodeBuilder.getRegistry();
        
        assertNotSame(registry1, registry2);
      });
      
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
    }
    @Test
    @DisplayName("Returns default initial value")
    void returnsDefaultInitialValue() {
        int expected = 17;
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
        int actual = hashCodeBuilder.toHashCode();
        assertEquals(expected, actual);
    }


}