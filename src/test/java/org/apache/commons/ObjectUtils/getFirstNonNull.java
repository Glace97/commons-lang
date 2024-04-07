import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getFirstNonNullTest {

    private Supplier<String> supplier1;
    private Supplier<String> supplier2;
    private Supplier<String> supplier3;

    @BeforeEach
    void setUp() {
        supplier1 = mock(Supplier.class);
        supplier2 = mock(Supplier.class);
        supplier3 = mock(Supplier.class);
    }

    @Test
    void testGetFirstNonNull_withNonNullSuppliers() {
        when(supplier1.get()).thenReturn("value1");
        when(supplier2.get()).thenReturn("value2");

        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);

        assertEquals("value1", result);
        verify(supplier1, times(1)).get();
        verify(supplier2, never()).get();
    }

    @Test
    void testGetFirstNonNull_withNullSuppliers() {
        when(supplier1.get()).thenReturn(null);
        when(supplier2.get()).thenReturn(null);

        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);

        assertNull(result);
        verify(supplier1, times(1)).get();
        verify(supplier2, times(1)).get();
    }

    @Test
    void testGetFirstNonNull_withMixedSuppliers() {
        when(supplier1.get()).thenReturn(null);
        when(supplier2.get()).thenReturn("value2");

        String result = ObjectUtils.getFirstNonNull(supplier1, supplier2);

        assertEquals("value2", result);
        verify(supplier1, times(1)).get();
        verify(supplier2, never()).get();
    }

    @Test
    void testGetFirstNonNull_withNoSuppliers() {
        String result = ObjectUtils.getFirstNonNull();

        assertNull(result);
    }
}