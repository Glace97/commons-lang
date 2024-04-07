import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class forEachTest {

    private ExceptionUtils exceptionUtils;

    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }

    @Test
    @DisplayName("Test forEach with Throwable without cause")
    void testForEach_ThrowableWithoutCause() {
        Throwable throwable = new Throwable("Test Throwable");
        List<Throwable> result = new ArrayList<>();
        exceptionUtils.forEach(throwable, result::add);

        assertEquals(1, result.size());
        assertEquals(throwable, result.get(0));
    }

    @Test
    @DisplayName("Test forEach with Throwable with one cause")
    void testForEach_ThrowableWithOneCause() {
        Throwable cause = new RuntimeException("Test Cause");
        Throwable throwable = new Throwable("Test Throwable", cause);
        List<Throwable> result = new ArrayList<>();
        exceptionUtils.forEach(throwable, result::add);

        assertEquals(2, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(cause, result.get(1));
    }

    @Test
    @DisplayName("Test forEach with null Throwable")
    void testForEach_NullThrowable() {
        List<Throwable> result = new ArrayList<>();
        exceptionUtils.forEach(null, result::add);

        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test forEach with recursive cause structure")
    void testForEach_RecursiveCauseStructure() {
        Throwable cause1 = new RuntimeException("Cause 1");
        Throwable cause2 = new RuntimeException("Cause 2", cause1);
        Throwable throwable = new Throwable("Throwable", cause2);
        cause1.initCause(throwable); // Create recursive cause structure
        List<Throwable> result = new ArrayList<>();
        exceptionUtils.forEach(throwable, result::add);

        assertEquals(4, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(cause2, result.get(1));
        assertEquals(cause1, result.get(2));
        assertEquals(throwable, result.get(3));
    }

    @Test
    @DisplayName("Test forEach with wrapped exception")
    void testForEach_WrappedException() {
        Throwable cause = new RuntimeException("Cause");
        Throwable throwable = new Throwable("Throwable", cause);
        List<Throwable> result = new ArrayList<>();
        exceptionUtils.forEach(throwable, result::add);

        assertEquals(2, result.size());
        assertEquals(throwable, result.get(0));
        assertEquals(cause, result.get(1));
    }
}