import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class unsplitTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void unsplit_WhenSplitStateIsSplit_ShouldRemoveSplit() {
        // Arrange
        stopWatch.splitState = StopWatch.SplitState.SPLIT;

        // Act
        stopWatch.unsplit();

        // Assert
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
    }

    @Test
    void unsplit_WhenSplitStateIsUnsplit_ShouldThrowIllegalStateException() {
        // Arrange
        stopWatch.splitState = StopWatch.SplitState.UNSPLIT;

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> stopWatch.unsplit());
    }
}