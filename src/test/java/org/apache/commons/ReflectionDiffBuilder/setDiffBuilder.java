import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setDiffBuilderTest {

    private ReflectionDiffBuilder.Builder<String> builder;

    @BeforeEach
    void setUp() {
        builder = new ReflectionDiffBuilder.Builder<>();
    }

    @Test
    void testSetDiffBuilder() {
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();
        ReflectionDiffBuilder.Builder<String> result = builder.setDiffBuilder(diffBuilder);
        assertEquals(diffBuilder, result.getDiffBuilder());
    }

    @Test
    void testSetExcludeFieldNames() {
        String[] excludeFieldNames = {"password", "lastModificationDate"};
        ReflectionDiffBuilder.Builder<String> result = builder.setExcludeFieldNames(excludeFieldNames);
        assertArrayEquals(excludeFieldNames, result.getExcludeFieldNames());
    }
}