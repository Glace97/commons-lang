
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class buildTest {
    private DiffBuilder<String> diffBuilder;

    @BeforeEach
    void setUp() {
        diffBuilder = new DiffBuilder<>();
    }

    @Test
    void testBuild_withDifferentLeftAndRight_shouldReturnDiffBuilderWithDiffs() {
        diffBuilder.setLeft("left");
        diffBuilder.setRight("right");

        DiffBuilder<String> result = diffBuilder.build();

        assertNotEquals(diffBuilder, result);
        assertEquals("left", result.getLeft());
        assertEquals("right", result.getRight());
    }

    @Test
    void testBuild_withSameLeftAndRight_shouldReturnDiffBuilderWithNoDiffs() {
        diffBuilder.setLeft("same");
        diffBuilder.setRight("same");

        DiffBuilder<String> result = diffBuilder.build();

        assertNotEquals(diffBuilder, result);
        assertEquals("same", result.getLeft());
        assertEquals("same", result.getRight());
    }

    @Test
    void testBuild_withNullLeftAndRight_shouldThrowNullPointerException() {
        diffBuilder.setLeft(null);
        diffBuilder.setRight(null);

        assertThrows(NullPointerException.class, () -> diffBuilder.build());
    }
}
