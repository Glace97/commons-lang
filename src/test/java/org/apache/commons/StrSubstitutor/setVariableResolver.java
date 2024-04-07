import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setVariableResolverTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testSetVariableResolver_NullResolver() {
        substitutor.setVariableResolver(null);
        assertNull(substitutor.getVariableResolver());
    }

    @Test
    void testSetVariableResolver_NotNullResolver() {
        StrLookup<?> resolver = new StrLookup<Object>() {
            @Override
            public String lookup(String key) {
                return null;
            }
        };

        substitutor.setVariableResolver(resolver);
        assertEquals(resolver, substitutor.getVariableResolver());
    }
}