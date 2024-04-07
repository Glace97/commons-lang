import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getExcludeFieldNamesTest {

    private ReflectionToStringBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionToStringBuilder(new Object());
    }

    @Test
    void testGetExcludeFieldNames() {
        String[] excludeFieldNames = builder.getExcludeFieldNames();
        assertNotNull(excludeFieldNames);
        assertEquals(0, excludeFieldNames.length);
    }
}