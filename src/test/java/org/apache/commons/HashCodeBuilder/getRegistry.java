import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Field;
import java.util.Set;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getRegistryTest {

    private HashCodeBuilder hashCodeBuilder;

    @BeforeEach
    void setUp() {
        hashCodeBuilder = new HashCodeBuilder();
    }

    @Test
    void testGetRegistry() throws NoSuchFieldException, IllegalAccessException {
        // Create a new HashCodeBuilder instance
        HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

        // Get the REGISTRY field using reflection
        Field registryField = HashCodeBuilder.class.getDeclaredField("REGISTRY");
        registryField.setAccessible(true);

        // Get the value of the REGISTRY field
        Set<IDKey> registry = (Set<IDKey>) registryField.get(hashCodeBuilder);

        // Make sure the registry is not null
        assertNotNull(registry);

        // Make sure the registry is empty initially
        assertTrue(registry.isEmpty());

        // Add an IDKey object to the registry
        IDKey idKey = new IDKey();
        registry.add(idKey);

        // Get the registry again
        Set<IDKey> updatedRegistry = (Set<IDKey>) registryField.get(hashCodeBuilder);

        // Make sure the registry is not null
        assertNotNull(updatedRegistry);

        // Make sure the registry is not empty
        assertFalse(updatedRegistry.isEmpty());

        // Make sure the registry contains the added IDKey object
        assertTrue(updatedRegistry.contains(idKey));
    }
}