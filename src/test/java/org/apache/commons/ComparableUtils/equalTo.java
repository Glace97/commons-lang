import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class equalToTest {

    private ComparableUtils comparableUtils;

    @BeforeAll
    void setUp() {
        comparableUtils = new ComparableUtils();
    }

    @ParameterizedTest
    @MethodSource("equalToTestCases")
    void equalTo_shouldReturnExpectedResult(A a, boolean expected) {
        boolean actual = comparableUtils.equalTo(a);
        assertEquals(expected, actual);
    }

    private Stream<Arguments> equalToTestCases() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of(1, false),
                Arguments.of(1, true),
                // Add more test cases here
        );
    }
}