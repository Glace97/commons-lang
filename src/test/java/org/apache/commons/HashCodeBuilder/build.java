import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class buildTest {

    private HashCodeBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new HashCodeBuilder();
    }

    @Test
    void testBuild_DefaultValues_ReturnsHashCode() {
        Integer expected = 17;
        Integer actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuild_CustomValues_ReturnsHashCode() {
        builder = new HashCodeBuilder(23, 31);
        Integer expected = 23;
        Integer actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuild_EqualObjects_ReturnsSameHashCode() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        builder.append(obj1).append(obj2);
        Integer expected = obj1.hashCode();
        Integer actual = builder.build();
        assertEquals(expected, actual);
    }

    @Test
    void testBuild_DifferentObjects_ReturnsDifferentHashCode() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        builder.append(obj1).append(obj2);
        Integer expected = Objects.hash(obj1, obj2);
        Integer actual = builder.build();
        assertEquals(expected, actual);
    }
}