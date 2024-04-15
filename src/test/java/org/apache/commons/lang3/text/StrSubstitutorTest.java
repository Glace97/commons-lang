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
    void test1() {
        // Test code here
    }

    @Test
    void test2() {
        // Test code here
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
    public void testSetVariablePrefix_Null() {
        assertThrows(NullPointerException.class, () -> substitutor.setVariablePrefix(null));
    }

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
    void shouldThrowExceptionForNullAndEmptyPrefixMatcher() {
        StrMatcher prefixMatcher = null;
        assertThrows(NullPointerException.class, () -> substitutor.setVariablePrefixMatcher(prefixMatcher));
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
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull4() {
        assertNull(strSubstitutor.replace((CharSequence) null));
    }


    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull5() {
        assertNull(strSubstitutor.replace((Object) null));
    }

    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull6() {
        assertNull(strSubstitutor.replace((StrBuilder) null));
    }

    @Test
    @DisplayName("should return null when source is null")
    void shouldReturnNullWhenSourceIsNull7() {
        assertNull(strSubstitutor.replace((StringBuffer) null));
    }

}