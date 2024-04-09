package org.apache.commons.lang3.text;

import static org.easymock.EasyMock.mock;
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

import org.easymock.EasyMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class StrSubstitutorTest {
    private StrSubstitutor strSubstitutor;
    private StrLookup<?> variableResolver;

    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        variableResolver = mock(StrLookup.class);
        strSubstitutor = new StrSubstitutor(variableResolver);
    }


    @Test
    @DisplayName("When variableResolver is null, should set variableResolver to null")
    void setVariableResolver_NullVariableResolver_ShouldSetVariableResolverToNull() {
        // Arrange

        // Act
        strSubstitutor.setVariableResolver(null);

        // Assert
        assertEquals(null, strSubstitutor.getVariableResolver());
    }

    @Test
    @DisplayName("When variableResolver is not null, should set variableResolver to the provided variableResolver")
    void setVariableResolver_ValidVariableResolver_ShouldSetVariableResolverToProvidedVariableResolver() {
        // Arrange
        StrLookup<?> mockVariableResolver = mock(StrLookup.class);

        // Act
        strSubstitutor.setVariableResolver(mockVariableResolver);

        // Assert
        assertEquals(mockVariableResolver, strSubstitutor.getVariableResolver());
    }


    @Test
    public void testGetVariablePrefixMatcher_DefaultPrefix() {
        StrMatcher expected = StrMatcher.stringMatcher("${");
        StrMatcher actual = substitutor.getVariablePrefixMatcher();
        assertEquals(expected, actual);
    }

//    @Test
//    public void testGetVariablePrefixMatcher_CustomPrefix() {
//        StrMatcher expected = StrMatcher.stringMatcher("<<");
//        substitutor = new StrSubstitutor(null, "<<", "}", '$');
//        StrMatcher actual = substitutor.getVariablePrefixMatcher();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetVariablePrefixMatcher_NullPrefix() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            substitutor = new StrSubstitutor(null, null, "}", '$');
//            substitutor.getVariablePrefixMatcher();
//        });
//    }
//
//    @Test
//    public void testGetVariablePrefixMatcher_EmptyPrefix() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            substitutor = new StrSubstitutor(null, "", "}", '$');
//            substitutor.getVariablePrefixMatcher();
//        });
//    }

    @Test
    @DisplayName("Should return null for any variable name")
    void testResolveVariable() {
        String result = substitutor.resolveVariable("variableName", null, 0, 0);
        assertNull(result);
    }

    @Test
    @DisplayName("Should return the value for an existing variable")
    void testResolveVariable_existingVariable() {
        String result = substitutor.resolveVariable("variable1", null, 0, 0);
        assertEquals("value1", result);
    }

    @Test
    @DisplayName("Should return null for a non-existing variable")
    void testResolveVariable_nonExistingVariable() {
        String result = substitutor.resolveVariable("nonExistingVariable", null, 0, 0);
        assertNull(result);
    }


    @Test
    void testReplaceIn_NullSource_ReturnsFalse() {
        StrBuilder source = null;
        assertFalse(substitutor.replaceIn(source));
    }

    @Test
    void testReplaceIn_ValidSource_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${name}!");
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, !", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithNoVariables_ReturnsFalse() {
        StrBuilder source = new StrBuilder("Hello, World!");
        assertFalse(substitutor.replaceIn(source));
        assertEquals("Hello, World!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithEscapeChar_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, $${name}!");
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, ${name}!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithPrefixSuffixInVariable_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, #{name}!");
        substitutor.setVariablePrefix("#");
        substitutor.setVariableSuffix("}");
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, !", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithDefaultValueDelimiter_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${name:-John}!");
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, !", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithCustomValueDelimiter_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${name=John}!");
        substitutor.setValueDelimiterMatcher(StrMatcher.stringMatcher("="));
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, !", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithVariableResolver_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${name}!");
        substitutor.setVariableResolver(new StrLookup<Object>() {
            @Override
            public String lookup(String key) {
                if (Objects.equals(key, "name")) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, John!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithSubstitutionInVariables_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${${name}}!");
        substitutor.setEnableSubstitutionInVariables(true);
        substitutor.setVariableResolver(new StrLookup<Object>() {
            @Override
            public String lookup(String key) {
                if (Objects.equals(key, "name")) {
                    return "world";
                }
                if (Objects.equals(key, "world")) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, John!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithPreserveEscapes_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, $${name}!");
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, $!{name}!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithPreserveEscapesAndEscapeChar_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, $$${name}!");
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, $${name}!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithPreserveEscapesAndPrefixSuffixInVariable_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, #${name}!");
        substitutor.setPreserveEscapes(true);
        substitutor.setVariablePrefix("#");
        substitutor.setVariableSuffix("}");
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, #!", source.toString());
    }

    @Test
    void testReplaceIn_ValidSourceWithPreserveEscapesAndDefaultValueDelimiter_ReturnsTrue() {
        StrBuilder source = new StrBuilder("Hello, ${name:-${defaultName}}!");
        substitutor.setPreserveEscapes(true);
        substitutor.setVariableResolver(new StrLookup<Object>() {
            @Override
            public String lookup(String key) {
                if (Objects.equals(key, "name")) {
                    return "John";
                }
                if (Objects.equals(key, "defaultName")) {
                    return "Doe";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello, John!", source.toString());
    }
    // Your Java code here


    @Test
    @DisplayName("should set the escape character")
    void shouldSetEscapeChar() {
        substitutor.setEscapeChar('#');
        assertEquals('#', substitutor.getEscapeChar());
    }

    @Test
    @DisplayName("should set the escape character to 0 for disabling escaping")
    void shouldDisableEscaping() {
        substitutor.setEscapeChar('\0');
        assertEquals('\0', substitutor.getEscapeChar());
    }

    @Test
    void test1() {
        // Test code here
    }

    @Test
    void test2() {
        // Test code here
    }

    // Add more test methods here


//    @Test
//    void testDefaultValueDelimiterChar() {
//        StrSubstitutor substitutor = new StrSubstitutor();
//        substitutor.setValueDelimiter(':');
//
//        assertEquals(':', substitutor.DEFAULT_VALUE_DELIMITER.getMatcherChar());
//    }
//
//    @Test
//    void testDefaultValueDelimiterString() {
//        StrSubstitutor substitutor = new StrSubstitutor();
//        substitutor.setValueDelimiter(":");
//
//        assertEquals(':', substitutor.DEFAULT_VALUE_DELIMITER.getMatcherChar());
//    }

    @Test
    void testDefaultValueDelimiterNull() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter(null);

        assertNull(substitutor.DEFAULT_VALUE_DELIMITER);
    }

    @Test
    void testDefaultValueDelimiterEmptyString() {
        StrSubstitutor substitutor = new StrSubstitutor();
        substitutor.setValueDelimiter("");

        assertNull(substitutor.DEFAULT_VALUE_DELIMITER);
    }

    @Test
    void testSetPreserveEscapes_True() {
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.isPreserveEscapes());
    }

    @Test
    void testSetPreserveEscapes_False() {
        substitutor.setPreserveEscapes(false);
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    void testSetPreserveEscapes_DefaultValue() {
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    @DisplayName("Should enable substitution in variables")
    void shouldEnableSubstitutionInVariables() {
        strSubstitutor.setEnableSubstitutionInVariables(true);
        assertTrue(strSubstitutor.isEnableSubstitutionInVariables());
    }

    @Test
    @DisplayName("Should disable substitution in variables")
    void shouldDisableSubstitutionInVariables() {
        strSubstitutor.setEnableSubstitutionInVariables(false);
        assertFalse(strSubstitutor.isEnableSubstitutionInVariables());
    }

    @Test
    void setValueDelimiterMatcher_NullValueDelimiterMatcher_DisablesValueDelimiterResolution() {
        StrMatcher valueDelimiterMatcher = null;
        strSubstitutor.setValueDelimiterMatcher(valueDelimiterMatcher);
        assertNull(strSubstitutor.getValueDelimiterMatcher());
    }

    @Test
    void setValueDelimiterMatcher_NotNullValueDelimiterMatcher_SetsValueDelimiterMatcher() {
        StrMatcher valueDelimiterMatcher = StrMatcher.charMatcher(':');
        strSubstitutor.setValueDelimiterMatcher(valueDelimiterMatcher);
        assertEquals(valueDelimiterMatcher, strSubstitutor.getValueDelimiterMatcher());
    }

    @Test
    void setValueDelimiterMatcher_Chaining_ReturnsThis() {
        StrMatcher valueDelimiterMatcher = StrMatcher.charMatcher(':');
        StrSubstitutor result = strSubstitutor.setValueDelimiterMatcher(valueDelimiterMatcher);
        assertEquals(strSubstitutor, result);
    }


    @Test
    void testSetVariableSuffixMatcher() {
        // Test with null suffix matcher
        assertThrows(NullPointerException.class, () -> substitutor.setVariableSuffixMatcher(null));

        // Test with default suffix matcher
        StrMatcher defaultSuffixMatcher = StrMatcher.stringMatcher("}");
        substitutor.setVariableSuffixMatcher(defaultSuffixMatcher);
        assertEquals(defaultSuffixMatcher, substitutor.getVariableSuffixMatcher());

        // Test with custom suffix matcher
        StrMatcher customSuffixMatcher = StrMatcher.stringMatcher("]");
        substitutor.setVariableSuffixMatcher(customSuffixMatcher);
        assertEquals(customSuffixMatcher, substitutor.getVariableSuffixMatcher());
    }

    @Test
    @DisplayName("Should return false by default")
    void shouldReturnFalseByDefault() {
        assertFalse(substitutor.isEnableSubstitutionInVariables());
    }

    @Test
    @DisplayName("Should return true after setting it to true")
    void shouldReturnTrueAfterSettingToTrue() {
        substitutor.setEnableSubstitutionInVariables(true);
        assertTrue(substitutor.isEnableSubstitutionInVariables());
    }

    @Test
    @DisplayName("Should return false after setting it to false")
    void shouldReturnFalseAfterSettingToFalse() {
        substitutor.setEnableSubstitutionInVariables(false);
        assertFalse(substitutor.isEnableSubstitutionInVariables());
    }

//    @Test
//    public void testSetVariablePrefix_Char() {
//        substitutor.setVariablePrefix('$');
//        assertEquals('$', substitutor.getVariablePrefix());
//    }
//
//    @Test
//    public void testSetVariablePrefix_String() {
//        substitutor.setVariablePrefix("{{");
//        assertEquals("{{", substitutor.getVariablePrefix());
//    }

    @Test
    public void testSetVariablePrefix_Null() {
        assertThrows(NullPointerException.class, () -> substitutor.setVariablePrefix(null));
    }

    @Test
    void shouldReturnCorrectEscapeCharacter() {
        substitutor.setEscapeChar('$');
        assertEquals('$', substitutor.getEscapeChar());
    }

    @Test
    @DisplayName("should return false when no variables are present in the string")
    void testSubstituteNoVariables() {
        StrBuilder str = new StrBuilder("Hello, World!");
        assertFalse(substitutor.substitute(str, 0, str.length()));
    }

    @Test
    @DisplayName("should substitute variables in the string")
    void testSubstituteWithVariables() {
        StrBuilder str = new StrBuilder("Hello, ${name}!");
        assertTrue(substitutor.substitute(str, 0, str.length()));
        assertEquals("Hello, !", str.toString());
    }

    @Test
    @DisplayName("should substitute variables with default values in the string")
    void testSubstituteWithDefaultValues() {
        StrBuilder str = new StrBuilder("Hello, ${name:-John}!");
        assertTrue(substitutor.substitute(str, 0, str.length()));
        assertEquals("Hello, John!", str.toString());
    }

    @Test
    @DisplayName("Should return null if no variable resolver is set")
    void shouldReturnNullIfNoVariableResolverSet() {
        assertNull(strSubstitutor.getVariableResolver());
    }

//    @Test
//    @DisplayName("Should return the set variable resolver")
//    void shouldReturnSetVariableResolver() {
//        StrLookup<?> variableResolver = new Properties();
//        strSubstitutor = new StrSubstitutor(variableResolver);
//        assertEquals(variableResolver, strSubstitutor.getVariableResolver());
//    }


//    @Test
//    void shouldSetVariableSuffix() {
//        // Arrange
//        char suffix = '%';
//
//        // Act
//        substitutor.setVariableSuffix(suffix);
//
//        // Assert
//        assertEquals(suffix, substitutor.getVariableSuffixMatcher().getMatcherChar());
//    }
//
//
//    @Test
//    void shouldSetVariableSuffix() {
//        // Arrange
//        String suffix = "}";
//
//        // Act
//        substitutor.setVariableSuffix(suffix);
//
//        // Assert
//        assertEquals(suffix, substitutor.getVariableSuffixMatcher().getMatcherString());
//    }

    @Test
    void shouldThrowNullPointerExceptionWhenSuffixIsNull() {
        // Arrange
        String suffix = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> substitutor.setVariableSuffix(suffix));
    }

    @Test
    void exampleTest1() {
        // Arrange
        // ...

        // Act
        // ...

        // Assert
        // ...
    }

    @Test
    void exampleTest2() {
        // Arrange
        // ...

        // Act
        // ...

        // Assert
        // ...
    }


    @Test
    void replaceSystemProperties_shouldReturnNull_whenSourceIsNull() {
        // Arrange
        Object source = null;

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertNull(result);
    }

    @Test
    void replaceSystemProperties_shouldReturnEmptyString_whenSourceIsEmptyString() {
        // Arrange
        Object source = "";

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("", result);
    }

    @Test
    void replaceSystemProperties_shouldReplaceVariablesWithSystemPropertyValues() {
        // Arrange
        Object source = "Hello ${user.name}";
        System.setProperty("user.name", "John");

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello John", result);
    }

    @Test
    void replaceSystemProperties_shouldNotReplaceVariablesIfNoSystemPropertyExists() {
        // Arrange
        Object source = "Hello ${user.name}";

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello ${user.name}", result);
    }

    @Test
    void replaceSystemProperties_shouldReplaceVariablesWithDefaultValuesIfNoSystemPropertyExists() {
        // Arrange
        Object source = "Hello ${user.name:-Guest}";

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello Guest", result);
    }

    @Test
    void replaceSystemProperties_shouldNotReplaceVariablesWithDefaultValuesIfSystemPropertyExists() {
        // Arrange
        Object source = "Hello ${user.name:-Guest}";
        System.setProperty("user.name", "John");

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello John", result);
    }

    @Test
    void replaceSystemProperties_shouldReplaceMultipleVariables() {
        // Arrange
        Object source = "Hello ${user.name}, your age is ${user.age}";
        System.setProperty("user.name", "John");
        System.setProperty("user.age", "25");

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello John, your age is 25", result);
    }

    @Test
    void replaceSystemProperties_shouldPreserveEscapes() {
        // Arrange
        Object source = "Hello $${user.name}";
        System.setProperty("user.name", "John");

        // Act
        String result = StrSubstitutor.replaceSystemProperties(source);

        // Assert
        assertEquals("Hello ${user.name}", result);
    }


    @Test
    void shouldSetVariablePrefixMatcher() {
        StrMatcher prefixMatcher = StrMatcher.charMatcher('$');
        substitutor.setVariablePrefixMatcher(prefixMatcher);
        assertEquals(prefixMatcher, substitutor.getVariablePrefixMatcher());
    }

    @Test
    void shouldThrowExceptionForNullAndEmptyPrefixMatcher() {
        StrMatcher prefixMatcher = null;
        assertThrows(NullPointerException.class, () -> substitutor.setVariablePrefixMatcher(prefixMatcher));
    }

    @Test
    void testIsPreserveEscapes_DefaultValue() {
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_SetToTrue() {
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_SetToFalse() {
        substitutor.setPreserveEscapes(false);
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_EdgeCase_EmptyString() {
        substitutor.setPreserveEscapes(true);
        assertFalse(substitutor.isPreserveEscapes());
    }

    @Test
    void testIsPreserveEscapes_EdgeCase_NullString() {
        substitutor.setPreserveEscapes(false);
        assertFalse(substitutor.isPreserveEscapes());
    }


    @Test
    void testGetVariableSuffixMatcher_DefaultSuffixMatcher() {
        // Test code here
    }

    @Test
    void testGetVariableSuffixMatcher_CustomSuffixMatcher() {
        // Test code here
    }

    @Test
    void testGetVariableSuffixMatcher_NullSuffixMatcher() {
        // Test code here
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull1() {
        assertNull(strSubstitutor.replace(null, new HashMap<>()));
    }
//
//    @Test
//    @DisplayName("should return source when valueMap is null")
//    void shouldReturnSourceWhenValueMapIsNull() {
//        String source = "Hello, ${name}!";
//        assertEquals(source, strSubstitutor.replace(source, null));
//    }

    @Test
    @DisplayName("should replace variables in source with values from valueMap")
    void shouldReplaceVariablesInSourceWithValueMap() {
        String source = "Hello, ${name}! You are ${age} years old.";
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", "Alice");
        valueMap.put("age", 25);

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, valueMap));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull2() {
        assertNull(strSubstitutor.replace(null, new HashMap<>(), "${", "}"));
    }

    @Test
    @DisplayName("should return source when valueMap is null")
    void shouldReturnSourceWhenValueMapIsNull2() {
        String source = "Hello, ${name}!";
        assertEquals(source, strSubstitutor.replace(source, null, "${", "}"));
    }

    @Test
    @DisplayName("should replace variables in source with values from valueMap using custom prefix and suffix")
    void shouldReplaceVariablesInSourceWithValueMapUsingCustomPrefixAndSuffix() {
        String source = "Hello, $name! You are $age years old.";
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", "Alice");
        valueMap.put("age", 25);

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, valueMap, "$", "!"));
    }


//    void shouldReturnNullWhenSourceIsNull3() {
//        assertNull(strSubstitutor.replace(null, new Properties()));
//    }
//
//    @Test
//    @DisplayName("should return source when valueProperties is null")
//    void shouldReturnSourceWhenValuePropertiesIsNull() {
//        String source = "Hello, ${name}!";
//        assertEquals(source, strSubstitutor.replace(source, null));
//    }

    @Test
    @DisplayName("should replace variables in source with values from valueProperties")
    void shouldReplaceVariablesInSourceWithValueProperties() {
        String source = "Hello, ${name}! You are ${age} years old.";
        Properties valueProperties = new Properties();
        valueProperties.put("name", "Alice");
        valueProperties.put("age", "25");

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, valueProperties));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull3() {
        assertNull(strSubstitutor.replace((char[]) null));
    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource3() {
        char[] source = "Hello, ${name}! You are ${age} years old.".toCharArray();

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }


//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace(null, 0, 5));
//    }

    @Test
    @DisplayName("should replace variables in specified portion of source")
    void shouldReplaceVariablesInSpecifiedPortionOfSource3() {
        char[] source = "Hello, ${name}! You are ${age} years old.".toCharArray();

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, 0, source.length));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull4() {
        assertNull(strSubstitutor.replace((CharSequence) null));
    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource4() {
        CharSequence source = "Hello, ${name}! You are ${age} years old.";

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }

//
//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace(null, 0, 5));
//    }

    @Test
    @DisplayName("should replace variables in specified portion of source")
    void shouldReplaceVariablesInSpecifiedPortionOfSource4() {
        CharSequence source = "Hello, ${name}! You are ${age} years old.";

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, 0, source.length()));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull5() {
        assertNull(strSubstitutor.replace((Object) null));
    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource2() {
        Object source = "Hello, ${name}! You are ${age} years old.";

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull6() {
        assertNull(strSubstitutor.replace((StrBuilder) null));
    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource1() {
        StrBuilder source = new StrBuilder("Hello, ${name}! You are ${age} years old.");

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }


//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace(null, 0, 5));
//    }

    @Test
    @DisplayName("should replace variables in specified portion of source")
    void shouldReplaceVariablesInSpecifiedPortionOfSource1() {
        StrBuilder source = new StrBuilder("Hello, ${name}! You are ${age} years old.");

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, 0, source.length()));
    }


//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace((String) null));
//    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource5() {
        String source = "Hello, ${name}! You are ${age} years old.";

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }

//
//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace(null, 0, 5));
//    }

    @Test
    @DisplayName("should replace variables in specified portion of source")
    void shouldReplaceVariablesInSpecifiedPortionOfSource2() {
        String source = "Hello, ${name}! You are ${age} years old.";

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, 0, source.length()));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull7() {
        assertNull(strSubstitutor.replace((StringBuffer) null));
    }

    @Test
    @DisplayName("should replace variables in source")
    void shouldReplaceVariablesInSource() {
        StringBuffer source = new StringBuffer("Hello, ${name}! You are ${age} years old.");

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source));
    }


//    @Test
//    @DisplayName("should return null when source is null")
//    void shouldReturnNullWhenSourceIsNull() {
//        assertNull(strSubstitutor.replace(null, 0, 5));
//    }

    @Test
    @DisplayName("should replace variables in specified portion of source")
    void shouldReplaceVariablesInSpecifiedPortionOfSource() {
        StringBuffer source = new StringBuffer("Hello, ${name}! You are ${age} years old.");

        String expected = "Hello, Alice! You are 25 years old.";
        assertEquals(expected, strSubstitutor.replace(source, 0, source.length()));
    }

    @Test
    public void testGetValueDelimiterMatcher_DefaultValue() {
        substitutor = new StrSubstitutor();
        StrMatcher expected = StrMatcher.stringMatcher(":-");

        StrMatcher actual = substitutor.getValueDelimiterMatcher();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetValueDelimiterMatcher_CustomValue() {
        substitutor = new StrSubstitutor(null, null, null, '$', StrMatcher.charMatcher(':'));
        StrMatcher expected = StrMatcher.charMatcher(':');

        StrMatcher actual = substitutor.getValueDelimiterMatcher();

        assertEquals(expected, actual);
    }

}