import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.Consumer;

class forEachTest {

    @Test
    void testForEach() {
        BooleanUtils.forEach((Boolean b) -> {
            assertNotNull(b);
        });
    }

    @Test
    void testForEachFalse() {
        BooleanUtils.forEach((Boolean b) -> {
            assertFalse(b);
        });
    }

    @Test
    void testForEachTrue() {
        BooleanUtils.forEach((Boolean b) -> {
            assertTrue(b);
        });
    }

    @Test
    void testForEachNoNullAction() {
        assertThrows(NullPointerException.class, () -> {
            BooleanUtils.forEach(null);
        });
    }

    @Test
    void testForEachEmptyList() {
        List<Boolean> emptyList = Collections.emptyList();
        emptyList.forEach((Boolean b) -> {
            fail("Should not be executed");
        });
    }

    @Test
    void testForEachWithCustomAction() {
        StringBuilder sb = new StringBuilder();
        Consumer<Boolean> customAction = (Boolean b) -> {
            sb.append(b);
        };
        BooleanUtils.forEach(customAction);
        assertEquals("falsetruenoyesoffon", sb.toString());
    }
}