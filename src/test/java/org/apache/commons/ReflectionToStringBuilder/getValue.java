import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

class getValueTest {
    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void testGetValue() throws IllegalAccessException {
        Field[] fields = ReflectionToStringBuilder.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = builder.getValue(field);
            assertNotNull(value);
            assertEquals(field.get(builder.getObject()), value);
        }
    }
}