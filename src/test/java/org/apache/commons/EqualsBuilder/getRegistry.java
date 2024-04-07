import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.lang.reflect.Field;
import java.util.Set;

@TestInstance(Lifecycle.PER_CLASS)
class getRegistryTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void getRegistry_ReturnsEmptySet_WhenNoObjectsTraversed() {
        Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
        assertNotNull(registry);
        assertTrue(registry.isEmpty());
    }

    @Test
    void getRegistry_ReturnsSetContainingTraversedObjectPairs() {
        EqualsBuilder.REGISTRY.set(createRegistryWithObjectPairs());
        Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
        assertNotNull(registry);
        assertEquals(2, registry.size());
        assertTrue(registry.contains(Pair.of(new IDKey("obj1"), new IDKey("obj2"))));
        assertTrue(registry.contains(Pair.of(new IDKey("obj3"), new IDKey("obj4"))));
    }

    @Test
    void getRegistry_ReturnsUniqueSetForEachThread() throws InterruptedException {
        final Set<Pair<IDKey, IDKey>> registry1 = createRegistryWithObjectPairs();
        final Set<Pair<IDKey, IDKey>> registry2 = createRegistryWithObjectPairs();

        Thread thread1 = new Thread(() -> {
            EqualsBuilder.REGISTRY.set(registry1);
            Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
            assertEquals(registry1, registry);
        });

        Thread thread2 = new Thread(() -> {
            EqualsBuilder.REGISTRY.set(registry2);
            Set<Pair<IDKey, IDKey>> registry = EqualsBuilder.getRegistry();
            assertEquals(registry2, registry);
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private Set<Pair<IDKey, IDKey>> createRegistryWithObjectPairs() {
        Set<Pair<IDKey, IDKey>> registry = new HashSet<>();
        registry.add(Pair.of(new IDKey("obj1"), new IDKey("obj2")));
        registry.add(Pair.of(new IDKey("obj3"), new IDKey("obj4")));
        return registry;
    }
}