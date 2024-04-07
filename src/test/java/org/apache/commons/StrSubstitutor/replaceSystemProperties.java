import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Properties;

class replaceSystemPropertiesTest {

    private Properties systemProperties;
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        systemProperties = System.getProperties();
        substitutor = new StrSubstitutor(StrLookup.systemPropertiesLookup());
    }

    @Test
    void testReplaceSystemProperties_NullSource_ReturnsNull() {
        assertNull(substitutor.replaceSystemProperties(null));
    }

    @Test
    void testReplaceSystemProperties_EmptySource_ReturnsEmptyString() {
        assertEquals("", substitutor.replaceSystemProperties(""));
    }

    @Test
    void testReplaceSystemProperties_NoVariablesInSource_ReturnsSameSource() {
        String source = "This is a test";
        assertEquals(source, substitutor.replaceSystemProperties(source));
    }

    @Test
    void testReplaceSystemProperties_WithVariablesInSource_ReturnsReplacedSource() {
        systemProperties.setProperty("name", "John");
        systemProperties.setProperty("age", "25");
        String source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        assertEquals(expected, substitutor.replaceSystemProperties(source));
    }

    @Test
    void testReplaceSystemProperties_WithMissingVariablesInSource_ReturnsSourceWithUnreplacedVariables() {
        systemProperties.setProperty("name", "John");
        String source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am ${age} years old.";
        assertEquals(expected, substitutor.replaceSystemProperties(source));
    }

    @Test
    void testReplaceSystemProperties_WithEscapeCharacter_ReturnsSourceWithEscapedVariables() {
        systemProperties.setProperty("name", "John");
        String source = "My name is $${name} and I am ${age} years old.";
        String expected = "My name is ${name} and I am ${age} years old.";
        assertEquals(expected, substitutor.replaceSystemProperties(source));
    }

    @Test
    void testReplaceSystemProperties_WithCustomPrefixAndSuffix_ReturnsReplacedSource() {
        systemProperties.setProperty("name", "John");
        systemProperties.setProperty("age", "25");
        substitutor.setVariablePrefix("[[");
        substitutor.setVariableSuffix("]]");
        String source = "My name is [[name]] and I am [[age]] years old.";
        String expected = "My name is John and I am 25 years old.";
        assertEquals(expected, substitutor.replaceSystemProperties(source));
    }

    @Test
    void testReplaceSystemProperties_WithDefaultValueDelimiter_ReturnsReplacedSource() {
        systemProperties.setProperty("name", "John");
        String source = "My name is ${name:-Unknown} and I am ${age:-30} years old.";
        String expected = "My name is John and I am 30 years old.";
        assertEquals(expected, substitutor.replaceSystemProperties(source));
    }

}