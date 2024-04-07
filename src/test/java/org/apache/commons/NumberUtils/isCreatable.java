import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class isCreatableTest {
    
    private NumberUtils numberUtils;
    
    @BeforeEach
    void setUp() {
        numberUtils = new NumberUtils();
    }
    
    @Nested
    @DisplayName("Positive Test Cases")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class PositiveTestCases {
        
        @Test
        void testIsCreatableWithValidNumber() {
            assertTrue(numberUtils.isCreatable("12345"));
        }
        
        @Test
        void testIsCreatableWithValidHexadecimalNumber() {
            assertTrue(numberUtils.isCreatable("0xABCDEF"));
        }
        
        @Test
        void testIsCreatableWithValidOctalNumber() {
            assertTrue(numberUtils.isCreatable("01234567"));
        }
        
        @Test
        void testIsCreatableWithValidScientificNotation() {
            assertTrue(numberUtils.isCreatable("1.23E4"));
        }
        
        @Test
        void testIsCreatableWithValidNumberWithQualifier() {
            assertTrue(numberUtils.isCreatable("12345L"));
        }
        
    }
    
    @Nested
    @DisplayName("Negative Test Cases")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class NegativeTestCases {
        
        @Test
        void testIsCreatableWithEmptyString() {
            assertFalse(numberUtils.isCreatable(""));
        }
        
        @Test
        void testIsCreatableWithBlankString() {
            assertFalse(numberUtils.isCreatable("  "));
        }
        
        @Test
        void testIsCreatableWithInvalidNumber() {
            assertFalse(numberUtils.isCreatable("12.34.56"));
        }
        
        @Test
        void testIsCreatableWithInvalidHexadecimalNumber() {
            assertFalse(numberUtils.isCreatable("0xGHIJKL"));
        }
        
        @Test
        void testIsCreatableWithInvalidOctalNumber() {
            assertFalse(numberUtils.isCreatable("012345678"));
        }
        
        @Test
        void testIsCreatableWithInvalidScientificNotation() {
            assertFalse(numberUtils.isCreatable("1.23E4.56"));
        }
        
        @Test
        void testIsCreatableWithInvalidNumberWithQualifier() {
            assertFalse(numberUtils.isCreatable("12345X"));
        }
        
        @Test
        void testIsCreatableWithNegativeZero() {
            assertFalse(numberUtils.isCreatable("-0"));
        }
        
    }
    
}