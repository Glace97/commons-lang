import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class setValueDelimiterTest {
    
    @Test
    void testSetValueDelimiterWithChar() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter(':');
        
        char actualDelimiter = substitutor.getValueDelimiterMatcher().getMatchChars()[0];
        Assertions.assertEquals(':', actualDelimiter);
    }
    
    @Test
    void testSetValueDelimiterWithString() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter("=");
        
        String actualDelimiter = substitutor.getValueDelimiterMatcher().toString();
        Assertions.assertEquals("=", actualDelimiter);
    }
    
    @Test
    void testSetValueDelimiterWithNull() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter(null);
        
        Assertions.assertNull(substitutor.getValueDelimiterMatcher());
    }
    
    @Test
    void testSetValueDelimiterWithEmptyString() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter("");
        
        Assertions.assertNull(substitutor.getValueDelimiterMatcher());
    }
    
    @Test
    void testSetValueDelimiterWithValidValue() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter(":");
        
        char actualDelimiter = substitutor.getValueDelimiterMatcher().getMatchChars()[0];
        Assertions.assertEquals(':', actualDelimiter);
    }
}