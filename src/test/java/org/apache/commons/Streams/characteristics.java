import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class CharacteristicsTest {

    private ArrayCollector<String> arrayCollector;

    @BeforeEach
    void setUp() {
        arrayCollector = new ArrayCollector<>(String.class);
    }

    @Test
    void testAccumulator() {
        List<String> list = new ArrayList<>();
        arrayCollector.accumulator().accept(list, "element");
        assertEquals(1, list.size());
        assertEquals("element", list.get(0));
    }

    @Test
    void testCharacteristics() {
        Set<Characteristics> characteristics = arrayCollector.characteristics();
        assertEquals(0, characteristics.size());
    }

    @Test
    void testCombiner() {
        List<String> list1 = new ArrayList<>();
        list1.add("element1");
        List<String> list2 = new ArrayList<>();
        list2.add("element2");
        List<String> combinedList = arrayCollector.combiner().apply(list1, list2);
        assertEquals(2, combinedList.size());
        assertEquals("element1", combinedList.get(0));
        assertEquals("element2", combinedList.get(1));
    }

    @Test
    void testFinisher() {
        List<String> list = new ArrayList<>();
        list.add("element1");
        list.add("element2");
        String[] array = arrayCollector.finisher().apply(list);
        assertEquals(2, array.length);
        assertEquals("element1", array[0]);
        assertEquals("element2", array[1]);
    }

    @Test
    void testSupplier() {
        List<String> list = arrayCollector.supplier().get();
        assertEquals(0, list.size());
    }
    
    @Test
    void testConstructor() {
        assertThrows(NullPointerException.class, () -> new ArrayCollector<>(null));
    }
}