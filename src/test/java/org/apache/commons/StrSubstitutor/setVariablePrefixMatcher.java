import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class setVariablePrefixMatcherTest {
    
    private StrSubstitutor substitutor;
    
    @BeforeEach
    void setup() {
        substitutor = new StrSubstitutor();
    }
    
    @Nested
    @DisplayName("When setting variable prefix matcher")
    class WhenSettingVariablePrefixMatcher {
        
        @Test
        @DisplayName("should set the prefix matcher correctly")
        void shouldSetPrefixMatcherCorrectly() {
            StrMatcher prefixMatcher = StrMatcher.charMatcher('$');
            
            substitutor.setVariablePrefixMatcher(prefixMatcher);
            
            assertSame(prefixMatcher, substitutor.getPrefixMatcher());
        }
        
        @Test
        @DisplayName("should return the instance of StrSubstitutor to enable chaining")
        void shouldReturnInstanceToEnableChaining() {
            StrMatcher prefixMatcher = StrMatcher.charMatcher('$');
            
            StrSubstitutor result = substitutor.setVariablePrefixMatcher(prefixMatcher);
            
            assertSame(substitutor, result);
        }
        
        @Test
        @DisplayName("should throw NullPointerException if prefixMatcher is null")
        void shouldThrowNullPointerExceptionIfPrefixMatcherIsNull() {
            assertThrows(NullPointerException.class, () -> {
                substitutor.setVariablePrefixMatcher(null);
            });
        }
    }
}