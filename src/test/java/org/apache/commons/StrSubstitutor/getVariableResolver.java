import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

class getVariableResolverTest {
    private StrSubstitutor substitutor;
    
    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }
    
    @Test
    void testGetVariableResolverReturnsNullWhenNotSet() {
        assertNull(substitutor.getVariableResolver());
    }
    
    @Test
    void testGetVariableResolverReturnsSetResolver() {
        StrLookup<?> resolver = new MyVariableResolver();
        substitutor.setVariableResolver(resolver);
        
        assertEquals(resolver, substitutor.getVariableResolver());
    }
    
    @Test
    void testGetVariableResolverReturnsNewResolverAfterSettingNull() {
        substitutor.setVariableResolver(null);
        
        assertNotNull(substitutor.getVariableResolver());
    }
    
    private class MyVariableResolver extends StrLookup<String> {
        @Override
        public String lookup(String key) {
            // Custom implementation for variable resolution
            return null;
        }
    }
}