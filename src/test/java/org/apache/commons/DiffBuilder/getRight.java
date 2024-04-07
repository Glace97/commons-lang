import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class getRightTest {

    private DiffBuilder<String> diffBuilder;
    private Supplier<String> leftSupplier;
    private Supplier<String> rightSupplier;

    @BeforeEach
    void setUp() {
        leftSupplier = mock(Supplier.class);
        rightSupplier = mock(Supplier.class);
        diffBuilder = new DiffBuilder<String>()
                .setLeftSupplier(leftSupplier)
                .setRightSupplier(rightSupplier);
    }

    @Test
    void testGetRight() {
        when(rightSupplier.get()).thenReturn("right");

        String right = diffBuilder.getRight();

        Assertions.assertEquals("right", right);
    }
}