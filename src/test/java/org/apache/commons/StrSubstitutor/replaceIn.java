import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class replaceInTest {

    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testReplaceIn_NullSource_ReturnsFalse() {
        assertFalse(substitutor.replaceIn(null));
    }

    @Test
    void testReplaceIn_EmptySource_ReturnsFalse() {
        StrBuilder source = new StrBuilder();
        assertFalse(substitutor.replaceIn(source));
        assertEquals("", source.toString());
    }

    @Test
    void testReplaceIn_NoVariablesInSource_ReturnsFalse() {
        StrBuilder source = new StrBuilder("No variables in source");
        assertFalse(substitutor.replaceIn(source));
        assertEquals("No variables in source", source.toString());
    }

    @Test
    void testReplaceIn_SingleVariableInSource_ReplacesVariableWithResolverValue() {
        StrBuilder source = new StrBuilder("Hello ${name}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello John!", source.toString());
    }

    @Test
    void testReplaceIn_MultipleVariablesInSource_ReplacesAllVariablesWithResolverValues() {
        StrBuilder source = new StrBuilder("Hello ${name}! My favorite color is ${color}.");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                if ("color".equals(key)) {
                    return "blue";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello John! My favorite color is blue.", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValue_DoesNotReplaceVariableIfResolverReturnsNull() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello World!", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValue_ReplacesVariableWithDefaultValueIfResolverReturnsNull() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return null;
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello World!", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValue_ReplacesVariableWithResolverValueIfResolverReturnsNotNull() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello John!", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValueDelimiter_ReplacesVariableWithDefaultValueIfResolverReturnsNull() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return null;
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello World!", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValueDelimiter_ReplacesVariableWithDefaultValueIfResolverReturnsEmptyString() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello World!", source.toString());
    }

    @Test
    void testReplaceIn_VariableWithDefaultValueDelimiter_ReplacesVariableWithResolverValueIfResolverReturnsNotNullOrEmptyString() {
        StrBuilder source = new StrBuilder("Hello ${name:-World}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello John!", source.toString());
    }

    @Test
    void testReplaceIn_EscapedVariable_DoesNotReplaceVariable() {
        StrBuilder source = new StrBuilder("Hello $${name}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                return null;
            }
        });
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello ${name}!", source.toString());
    }

    @Test
    void testReplaceIn_EnableSubstitutionInVariables_VariableInVariable_ReplacesInnerVariableWithResolverValue() {
        StrBuilder source = new StrBuilder("Hello ${${name}}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "color";
                }
                if ("color".equals(key)) {
                    return "blue";
                }
                return null;
            }
        });
        substitutor.setEnableSubstitutionInVariables(true);
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello blue!", source.toString());
    }

    @Test
    void testReplaceIn_DisableSubstitutionInVariables_VariableInVariable_DoesNotReplaceInnerVariable() {
        StrBuilder source = new StrBuilder("Hello ${${name}}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "color";
                }
                if ("color".equals(key)) {
                    return "blue";
                }
                return null;
            }
        });
        substitutor.setEnableSubstitutionInVariables(false);
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello ${color}!", source.toString());
    }

    @Test
    void testReplaceIn_PreserveEscapes_EscapedVariable_DoesNotReplaceVariable() {
        StrBuilder source = new StrBuilder("Hello $${name}!");
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if ("name".equals(key)) {
                    return "John";
                }
                return null;
            }
        });
        substitutor.setPreserveEscapes(true);
        assertTrue(substitutor.replaceIn(source));
        assertEquals("Hello $${name}!", source.toString());
    }
}