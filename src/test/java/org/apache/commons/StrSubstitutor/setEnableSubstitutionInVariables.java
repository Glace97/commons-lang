
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class setEnableSubstitutionInVariablesTest {
    private StrSubstitutor substitutor;

    @BeforeEach
    void setUp() {
        substitutor = new StrSubstitutor();
    }

    @Nested
    @DisplayName("when enableSubstitutionInVariables is set to true")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class EnableSubstitutionInVariablesTrue {
        @BeforeEach
        void setUp() {
            substitutor.setEnableSubstitutionInVariables(true);
        }

        @Test
        void shouldSetEnableSubstitutionInVariablesToTrue() {
            assertTrue(substitutor.enableSubstitutionInVariables);
        }

        @Test
        void shouldReturnTrueWhenGetEnableSubstitutionInVariables() {
            assertTrue(substitutor.getEnableSubstitutionInVariables());
        }
    }

    @Nested
    @DisplayName("when enableSubstitutionInVariables is set to false")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class EnableSubstitutionInVariablesFalse {
        @BeforeEach
        void setUp() {
            substitutor.setEnableSubstitutionInVariables(false);
        }

        @Test
        void shouldSetEnableSubstitutionInVariablesToFalse() {
            assertFalse(substitutor.enableSubstitutionInVariables);
        }

        @Test
        void shouldReturnFalseWhenGetEnableSubstitutionInVariables() {
            assertFalse(substitutor.getEnableSubstitutionInVariables());
        }
    }
}
