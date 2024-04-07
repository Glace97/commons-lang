import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class emptyArrayTest {

    @Test
    void testEmptyArray() {
        ImmutablePair<?, ?>[] result = ImmutablePair.emptyArray();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testEmptyArrayWithType() {
        ImmutablePair<Integer, String>[] result = ImmutablePair.emptyArray();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testEmptyArrayWithNullType() {
        ImmutablePair<?, ?>[] result = ImmutablePair.emptyArray();
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    @Test
    void testEmptyArrayMultipleTimes() {
        ImmutablePair<?, ?>[] result1 = ImmutablePair.emptyArray();
        ImmutablePair<?, ?>[] result2 = ImmutablePair.emptyArray();
        ImmutablePair<?, ?>[] result3 = ImmutablePair.emptyArray();
        
        assertSame(result1, result2);
        assertSame(result2, result3);
    }
    
    @Test
    void testEmptyArrayWithTypeMultipleTimes() {
        ImmutablePair<Integer, String>[] result1 = ImmutablePair.emptyArray();
        ImmutablePair<Integer, String>[] result2 = ImmutablePair.emptyArray();
        ImmutablePair<Integer, String>[] result3 = ImmutablePair.emptyArray();
        
        assertSame(result1, result2);
        assertSame(result2, result3);
    }

}