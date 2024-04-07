
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrSubstitutorTest {

    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void substitute_withNoVariables_shouldReturnSameString() {
        String input = "Hello, world!";
        String result = substitutor.substitute(input);
        assertEquals(input, result);
    }

    @Test
    void substitute_withSingleVariable_shouldSubstituteVariable() {
        String input = "Hello, ${name}!";
        substitutor.setVariable("name", "Alice");
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withMultipleVariables_shouldSubstituteAllVariables() {
        String input = "Hello, ${name}! My age is ${age}.";
        substitutor.setVariable("name", "Alice");
        substitutor.setVariable("age", "25");
        String expected = "Hello, Alice! My age is 25.";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withRecursiveVariables_shouldSubstituteRecursively() {
        String input = "Hello, ${name}! My age is ${age}.";
        substitutor.setVariable("name", "Alice");
        substitutor.setVariable("age", "${age_value}");
        substitutor.setVariable("age_value", "25");
        String expected = "Hello, Alice! My age is 25.";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withUnknownVariable_shouldLeaveVariableUnsubstituted() {
        String input = "Hello, ${name}!";
        String expected = "Hello, ${name}!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withEscapeCharacter_shouldNotSubstituteVariable() {
        String input = "Hello, $${name}!";
        substitutor.setVariable("name", "Alice");
        String expected = "Hello, ${name}!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withCustomPrefixAndSuffix_shouldSubstituteVariables() {
        String input = "Hello, $[name]!";
        substitutor.setVariablePrefix("$[");
        substitutor.setVariableSuffix("]");
        substitutor.setVariable("name", "Alice");
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withCustomEscapeCharacter_shouldNotSubstituteVariable() {
        String input = "Hello, #[name]!";
        substitutor.setEscapeChar('#');
        substitutor.setVariable("name", "Alice");
        String expected = "Hello, #[name]!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withDefaultValue_shouldSubstituteDefaultWhenVariableNotFound() {
        String input = "Hello, ${name:-Alice}!";
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withDefaultValueAndUnknownVariable_shouldSubstituteDefault() {
        String input = "Hello, ${name:-Alice}!";
        substitutor.setVariable("age", "25");
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withCustomValueDelimiter_shouldSubstituteVariableWithValueDelimiter() {
        String input = "Hello, ${name:=Alice}!";
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }

    @Test
    void substitute_withCustomValueDelimiterAndDefault_shouldSubstituteDefaultWhenVariableNotFound() {
        String input = "Hello, ${name:=Alice}!";
        String expected = "Hello, Alice!";
        String result = substitutor.substitute(input);
        assertEquals(expected, result);
    }
}
