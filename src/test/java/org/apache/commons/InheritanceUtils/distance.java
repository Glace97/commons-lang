import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class distanceTest {

    @Test
    void testDistanceSameClass() {
        Class<?> cls = String.class;
        assertEquals(0, InheritanceUtils.distance(cls, cls));
    }

    @Test
    void testDistanceNullClass() {
        Class<?> cls = String.class;
        assertNull(InheritanceUtils.distance(null, cls));
        assertNull(InheritanceUtils.distance(cls, null));
    }

    @Test
    void testDistanceNoInheritance() {
        Class<?> child = Integer.class;
        Class<?> parent = String.class;
        assertEquals(-1, InheritanceUtils.distance(child, parent));
    }

    @Test
    void testDistanceDirectInheritance() {
        Class<?> child = Integer.class;
        Class<?> parent = Number.class;
        assertEquals(1, InheritanceUtils.distance(child, parent));
    }

    @Test
    void testDistanceIndirectInheritance() {
        Class<?> child = Integer.class;
        Class<?> parent = Object.class;
        assertEquals(2, InheritanceUtils.distance(child, parent));
    }
}