
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReplaceTest {

    private Map<String, String> valueMap;

    @BeforeEach
    void setUp() {
        valueMap = new HashMap<>();
        valueMap.put("name", "John");
        valueMap.put("age", "25");
    }

    @Test
    void testReplaceWithMap() {
        String source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source, valueMap);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithCustomPrefixAndSuffix() {
        String source = "My name is <name> and I am <age> years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source, valueMap, "<", ">");
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithProperties() {
        Properties valueProperties = new Properties();
        valueProperties.setProperty("name", "John");
        valueProperties.setProperty("age", "25");

        String source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source, valueProperties);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithCharArray() {
        char[] source = "My name is ${name} and I am ${age} years old.".toCharArray();
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithCharSequence() {
        CharSequence source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithObject() {
        Object source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithStrBuilder() {
        StrBuilder source = new StrBuilder("My name is ${name} and I am ${age} years old.");
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithStringBuffer() {
        StringBuffer source = new StringBuffer("My name is ${name} and I am ${age} years old.");
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }

    @Test
    void testReplaceWithString() {
        String source = "My name is ${name} and I am ${age} years old.";
        String expected = "My name is John and I am 25 years old.";
        String result = StrSubstitutor.replace(source);
        assertEquals(expected, result);
    }
}
