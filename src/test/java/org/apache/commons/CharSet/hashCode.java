import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class HashCodeTest {

    private CharSet emptySet;
    private CharSet alphaSet;
    private CharSet alphaLowerSet;
    private CharSet alphaUpperSet;
    private CharSet numericSet;

    @BeforeAll
    void setUp() {
        emptySet = new CharSet();
        alphaSet = new CharSet("a-zA-Z");
        alphaLowerSet = new CharSet("a-z");
        alphaUpperSet = new CharSet("A-Z");
        numericSet = new CharSet("0-9");
    }

    @Test
    void testEmptySetHashCode() {
        assertEquals(89, emptySet.hashCode());
    }

    @Test
    void testAlphaSetHashCode() {
        assertEquals(89 + alphaSet.set.hashCode(), alphaSet.hashCode());
    }

    @Test
    void testAlphaLowerSetHashCode() {
        assertEquals(89 + alphaLowerSet.set.hashCode(), alphaLowerSet.hashCode());
    }

    @Test
    void testAlphaUpperSetHashCode() {
        assertEquals(89 + alphaUpperSet.set.hashCode(), alphaUpperSet.hashCode());
    }

    @Test
    void testNumericSetHashCode() {
        assertEquals(89 + numericSet.set.hashCode(), numericSet.hashCode());
    }
}