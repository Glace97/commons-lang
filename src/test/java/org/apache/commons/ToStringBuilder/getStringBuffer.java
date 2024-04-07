
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getStringBufferTest {

    private ToStringBuilder toStringBuilder;

    @BeforeEach
    void setUp() {
        toStringBuilder = new ToStringBuilder(mock(Object.class));
    }

    @Nested
    class WhenStyleAndBufferAreNull {

        @BeforeEach
        void setUp() {
            toStringBuilder = new ToStringBuilder(mock(Object.class), null, null);
        }

        @Test
        void shouldReturnNotNullStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertNotNull(buffer);
        }

        @Test
        void shouldReturnEmptyStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertEquals(0, buffer.length());
        }
    }

    @Nested
    class WhenStyleIsNull {

        @BeforeEach
        void setUp() {
            toStringBuilder = new ToStringBuilder(mock(Object.class), null);
        }

        @Test
        void shouldReturnNotNullStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertNotNull(buffer);
        }

        @Test
        void shouldReturnEmptyStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertEquals(0, buffer.length());
        }
    }

    @Nested
    class WhenBufferIsNull {

        @BeforeEach
        void setUp() {
            toStringBuilder = new ToStringBuilder(mock(Object.class), mock(ToStringStyle.class), null);
        }

        @Test
        void shouldReturnNotNullStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertNotNull(buffer);
        }

        @Test
        void shouldReturnEmptyStringBuffer() {
            StringBuffer buffer = toStringBuilder.getStringBuffer();
            assertEquals(0, buffer.length());
        }
    }

    @Nested
    class WhenStyleAndBufferAreNotNull {

        private ToStringStyle style;
        private StringBuffer buffer;

        @BeforeEach
        void setUp() {
            style = mock(ToStringStyle.class);
            buffer = new StringBuffer();
            toStringBuilder = new ToStringBuilder(mock(Object.class), style, buffer);
        }

        @Test
        void shouldReturnSameStringBuffer() {
            StringBuffer returnedBuffer = toStringBuilder.getStringBuffer();
            assertSame(buffer, returnedBuffer);
        }

        @Test
        void shouldAppendStartWithStyle() {
            toStringBuilder.getStringBuffer();
            verify(style).appendStart(buffer, toStringBuilder.object);
        }
    }
}
