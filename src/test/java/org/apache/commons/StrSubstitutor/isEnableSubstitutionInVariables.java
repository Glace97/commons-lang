import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isEnableSubstitutionInVariablesTest {
    
    private StrSubstitutor substitutor;
    
    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }
    
    @Test
    void testIsEnableSubstitutionInVariables_DefaultValue() {
        boolean result = substitutor.isEnableSubstitutionInVariables();
        assertFalse(result);
    }
    
    @Test
    void testIsEnableSubstitutionInVariables_SetToTrue() {
        substitutor.setEnableSubstitutionInVariables(true);
        boolean result = substitutor.isEnableSubstitutionInVariables();
        assertTrue(result);
    }
    
    @Test
    void testIsEnableSubstitutionInVariables_SetToFalse() {
        substitutor.setEnableSubstitutionInVariables(false);
        boolean result = substitutor.isEnableSubstitutionInVariables();
        assertFalse(result);
    }
}