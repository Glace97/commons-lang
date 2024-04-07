import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@DisplayName("getFirstContextValue Test Suite")
class getFirstContextValueTest {

    private DefaultExceptionContext exceptionContext;

    @BeforeEach
    void setUp() {
        exceptionContext = new DefaultExceptionContext();
    }

    @Nested
    @DisplayName("When label is present in contextValues")
    class WhenLabelIsPresent {

        private final String label = "label";
        private final Object value = "value";

        @BeforeEach
        void setUp() {
            exceptionContext.contextValues.add(Pair.of(label, value));
        }

        @Test
        @DisplayName("Should return the value for the given label")
        void shouldReturnTheValue() {
            assertEquals(value, exceptionContext.getFirstContextValue(label));
        }

        @Test
        @DisplayName("Should return null if label is null")
        void shouldReturnNullForNullLabel() {
            assertEquals(null, exceptionContext.getFirstContextValue(null));
        }

        @Test
        @DisplayName("Should return null if label is empty")
        void shouldReturnNullForEmptyLabel() {
            assertEquals(null, exceptionContext.getFirstContextValue(StringUtils.EMPTY));
        }
    }

    @Nested
    @DisplayName("When label is not present in contextValues")
    class WhenLabelIsNotPresent {

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            assertEquals(null, exceptionContext.getFirstContextValue("nonexistentLabel"));
        }
    }
}