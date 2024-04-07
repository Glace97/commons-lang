import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.function.FailableBiConsumer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcceptTest {

    private FailableBiConsumer<Long, Integer, Throwable> consumer;
    private Duration duration;

    @BeforeEach
    void setUp() {
        consumer = mock(FailableBiConsumer.class);
        duration = Duration.ofSeconds(10);
    }

    @Test
    void accept_ValidConsumerAndDuration_ConsumerAcceptCalledWithCorrectArguments() throws Throwable {
        DurationUtils.accept(consumer, duration);

        verify(consumer).accept(10000L, 0);
    }

    @Test
    void accept_NullConsumer_NullPointerExceptionThrown() {
        assertThrows(NullPointerException.class, () -> DurationUtils.accept(null, duration));
    }

    @Test
    void accept_NullDuration_ConsumerAcceptNotCalled() throws Throwable {
        DurationUtils.accept(consumer, null);

        verify(consumer, never()).accept(anyLong(), anyInt());
    }

    @Test
    void accept_NullConsumerAndDuration_NullPointerExceptionThrown() {
        assertThrows(NullPointerException.class, () -> DurationUtils.accept(null, null));
    }

    @Test
    void accept_ConsumerThrowsException_ExceptionForwarded() throws Throwable {
        doThrow(RuntimeException.class).when(consumer).accept(anyLong(), anyInt());

        assertThrows(RuntimeException.class, () -> DurationUtils.accept(consumer, duration));
    }
}