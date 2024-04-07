import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void testBuild() {
        ReflectionDiffBuilder.Builder<String> builder = ReflectionDiffBuilder.builder();

        ReflectionDiffBuilder<String> reflectionDiffBuilder = builder.build();

        assertNotNull(reflectionDiffBuilder);
    }

    @Test
    void testSetDiffBuilder() {
        ReflectionDiffBuilder.Builder<String> builder = ReflectionDiffBuilder.builder();
        DiffBuilder<String> diffBuilder = new DiffBuilder<>();

        builder.setDiffBuilder(diffBuilder);

        ReflectionDiffBuilder<String> reflectionDiffBuilder = builder.build();
        assertEquals(diffBuilder, reflectionDiffBuilder.getDiffBuilder());
    }

    @Test
    void testSetExcludeFieldNames() {
        ReflectionDiffBuilder.Builder<String> builder = ReflectionDiffBuilder.builder();
        String[] excludeFieldNames = {"password", "lastModificationDate"};

        builder.setExcludeFieldNames(excludeFieldNames);

        ReflectionDiffBuilder<String> reflectionDiffBuilder = builder.build();
        assertArrayEquals(excludeFieldNames, reflectionDiffBuilder.getExcludeFieldNames());
    }
}