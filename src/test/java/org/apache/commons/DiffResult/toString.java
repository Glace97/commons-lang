
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ToStringTest")
class ToStringTest {

    private ToStringStyle style;
    private List<Diff<?>> diffList;
    private String toStringFormat;

    @BeforeEach
    void setUp() {
        style = ToStringStyle.SHORT_PREFIX_STYLE;
        diffList = new ArrayList<>();
        toStringFormat = "%s differs from %s";
    }

    @Nested
    @DisplayName("toString()")
    class ToStringMethod {

        @Test
        @DisplayName("should return OBJECTS_SAME_STRING when diffList is empty")
        void whenDiffListIsEmpty_shouldReturnObjectsSameString() {
            DiffResult diffResult = new DiffResult(null, null, diffList, style, toStringFormat);
            assertEquals(StringUtils.EMPTY, diffResult.toString());
        }

        @Test
        @DisplayName("should return formatted string with differences")
        void whenDiffListIsNotEmpty_shouldReturnFormattedStringWithDifferences() {
            diffList.add(new Diff<>("field1", "oldValue1", "newValue1"));
            diffList.add(new Diff<>("field2", "oldValue2", "newValue2"));
            T lhs = createMockObject();
            T rhs = createMockObject();
            DiffResult diffResult = new DiffResult(lhs, rhs, diffList, style, toStringFormat);
            String expected = "MockObject[field1=oldValue1,field2=oldValue2] differs from MockObject[field1=newValue1,field2=newValue2]";
            assertEquals(expected, diffResult.toString());
        }
    }

    @Nested
    @DisplayName("toString(ToStringStyle style)")
    class ToStringWithStyleMethod {

        @Test
        @DisplayName("should return OBJECTS_SAME_STRING when diffList is empty")
        void whenDiffListIsEmpty_shouldReturnObjectsSameString() {
            DiffResult diffResult = new DiffResult(null, null, diffList, style, toStringFormat);
            assertEquals(StringUtils.EMPTY, diffResult.toString(style));
        }

        @Test
        @DisplayName("should return formatted string with differences")
        void whenDiffListIsNotEmpty_shouldReturnFormattedStringWithDifferences() {
            diffList.add(new Diff<>("field1", "oldValue1", "newValue1"));
            diffList.add(new Diff<>("field2", "oldValue2", "newValue2"));
            T lhs = createMockObject();
            T rhs = createMockObject();
            DiffResult diffResult = new DiffResult(lhs, rhs, diffList, style, toStringFormat);
            String expected = "MockObject[field1=oldValue1,field2=oldValue2] differs from MockObject[field1=newValue1,field2=newValue2]";
            assertEquals(expected, diffResult.toString(style));
        }
    }

    private T createMockObject() {
        // Implement the logic to create a mock object of type T
        return null;
    }
}
