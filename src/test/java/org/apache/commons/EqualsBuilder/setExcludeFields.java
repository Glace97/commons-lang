import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class setExcludeFieldsTest {
    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void setExcludeFields_ShouldSetExcludeFields() {
        String[] excludeFields = {"field1", "field2"};
        equalsBuilder.setExcludeFields(excludeFields);
        assertArrayEquals(excludeFields, equalsBuilder.excludeFields);
    }

    @Test
    void setExcludeFields_NullExcludeFields_ShouldSetExcludeFieldsToNull() {
        equalsBuilder.setExcludeFields(null);
        assertNull(equalsBuilder.excludeFields);
    }
}