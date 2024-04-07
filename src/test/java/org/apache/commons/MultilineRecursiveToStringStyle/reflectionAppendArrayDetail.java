import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class reflectionAppendArrayDetailTest {
    private MultilineRecursiveToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new MultilineRecursiveToStringStyle();
    }

    @Test
    void reflectionAppendArrayDetail_ShouldAppendArrayDetail_WhenArrayIsNotEmpty() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "arrayField";
        Object[] array = {1, 2, 3};

        style.reflectionAppendArrayDetail(buffer, fieldName, array);

        String expected = "arrayField={" + System.lineSeparator() +
                "  [0]=1" + System.lineSeparator() +
                "  [1]=2" + System.lineSeparator() +
                "  [2]=3" + System.lineSeparator() +
                "}";

        assertEquals(expected, buffer.toString());
    }

    @Test
    void reflectionAppendArrayDetail_ShouldNotAppendArrayDetail_WhenArrayIsEmpty() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "arrayField";
        Object[] array = {};

        style.reflectionAppendArrayDetail(buffer, fieldName, array);

        String expected = "arrayField={}";

        assertEquals(expected, buffer.toString());
    }

    @Test
    void reflectionAppendArrayDetail_ShouldNotAppendArrayDetail_WhenArrayIsNull() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "arrayField";
        Object[] array = null;

        style.reflectionAppendArrayDetail(buffer, fieldName, array);

        String expected = "arrayField=null";

        assertEquals(expected, buffer.toString());
    }
}