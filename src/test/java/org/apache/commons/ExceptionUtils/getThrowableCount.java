import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getThrowableCountTest {

    private ExceptionUtils exceptionUtils;

    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }

    @Nested
    @DisplayName("Tests for getThrowableCount method")
    class GetThrowableCountTests {

        @Test
        @DisplayName("Should return 0 when throwable is null")
        void shouldReturnZeroWhenThrowableIsNull() {
            Throwable throwable = null;
            int expectedCount = 0;

            int actualCount = exceptionUtils.getThrowableCount(throwable);

            assertEquals(expectedCount, actualCount);
        }

        @Test
        @DisplayName("Should return 1 when throwable has no cause")
        void shouldReturnOneWhenThrowableHasNoCause() {
            Throwable throwable = new Throwable();
            int expectedCount = 1;

            int actualCount = exceptionUtils.getThrowableCount(throwable);

            assertEquals(expectedCount, actualCount);
        }

        @Test
        @DisplayName("Should return 2 when throwable has one cause")
        void shouldReturnTwoWhenThrowableHasOneCause() {
            Throwable cause = new Exception();
            Throwable throwable = new Throwable(cause);
            int expectedCount = 2;

            int actualCount = exceptionUtils.getThrowableCount(throwable);

            assertEquals(expectedCount, actualCount);
        }

        @Test
        @DisplayName("Should return correct count for complex chain of throwables")
        void shouldReturnCorrectCountForComplexChainOfThrowables() {
            Throwable cause1 = new Exception();
            Throwable cause2 = new RuntimeException(cause1);
            Throwable cause3 = new UndeclaredThrowableException(cause2);
            Throwable cause4 = new InvocationTargetException(cause3);
            Throwable throwable = new Throwable(cause4);
            int expectedCount = 5;

            int actualCount = exceptionUtils.getThrowableCount(throwable);

            assertEquals(expectedCount, actualCount);
        }

        @Test
        @DisplayName("Should return 0 when throwable is wrapped and cause is null")
        void shouldReturnZeroWhenThrowableIsWrappedAndCauseIsNull() {
            Throwable cause = null;
            Throwable wrappedThrowable = new Throwable(cause);
            int expectedCount = 0;

            int actualCount = exceptionUtils.getThrowableCount(wrappedThrowable);

            assertEquals(expectedCount, actualCount);
        }

        @Test
        @DisplayName("Should return correct count for wrapped throwable")
        void shouldReturnCorrectCountForWrappedThrowable() {
            Throwable cause = new Exception();
            Throwable wrappedThrowable = new Throwable(cause);
            int expectedCount = 2;

            int actualCount = exceptionUtils.getThrowableCount(wrappedThrowable);

            assertEquals(expectedCount, actualCount);
        }
    }
}