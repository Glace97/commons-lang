import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class startTimerTest {
    @Mock
    ScheduledExecutorService executorService;

    @Mock
    ScheduledFuture<?> task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testStartTimer() {
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
        timedSemaphore.executorService = executorService;
        timedSemaphore.task = task;

        when(executorService.scheduleAtFixedRate(any(Runnable.class), anyLong(), anyLong(), any(TimeUnit.class))).thenReturn(task);

        ScheduledFuture<?> result = timedSemaphore.startTimer();

        assertNotNull(result);
        assertEquals(task, result);
        verify(executorService, times(1)).scheduleAtFixedRate(any(Runnable.class), anyLong(), anyLong(), any(TimeUnit.class));
    }
}