import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("supplierTest")
class SupplierTest {

    private Supplier<List<String>> supplier;

    @BeforeEach
    void setUp() {
        supplier = new Streams().supplier();
    }

    @Nested
    @DisplayName("supplier")
    class SupplierMethod {

        @Test
        @DisplayName("returns a new ArrayList")
        void returnsNewArrayList() {
            List<String> list = supplier.get();
            assertTrue(list instanceof ArrayList);
        }

        @Test
        @DisplayName("returns an empty list")
        void returnsEmptyList() {
            List<String> list = supplier.get();
            assertTrue(list.isEmpty());
        }

        @Test
        @DisplayName("returns a new instance on each call")
        void returnsNewInstanceOnEachCall() {
            List<String> list1 = supplier.get();
            List<String> list2 = supplier.get();
            assertTrue(list1 != list2);
        }
    }
}