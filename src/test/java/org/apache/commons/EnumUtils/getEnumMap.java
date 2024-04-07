
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class getEnumMapTest {

    enum Color {
        RED, GREEN, BLUE
    }

    @Test
    void testGetEnumMap() {
        Map<String, Color> enumMap = EnumUtils.getEnumMap(Color.class);
        assertNotNull(enumMap);
        assertEquals(3, enumMap.size());
        assertEquals(Color.RED, enumMap.get("RED"));
        assertEquals(Color.GREEN, enumMap.get("GREEN"));
        assertEquals(Color.BLUE, enumMap.get("BLUE"));
    }

    @Test
    void testGetEnumMapWithKeyFunction() {
        Function<Color, Integer> keyFunction = color -> color.ordinal() + 1;
        Map<Integer, Color> enumMap = EnumUtils.getEnumMap(Color.class, keyFunction);
        assertNotNull(enumMap);
        assertEquals(3, enumMap.size());
        assertEquals(Color.RED, enumMap.get(1));
        assertEquals(Color.GREEN, enumMap.get(2));
        assertEquals(Color.BLUE, enumMap.get(3));
    }
}
