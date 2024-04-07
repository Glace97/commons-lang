import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class removeCommonFramesTest {

    private List<String> causeFrames;
    private List<String> wrapperFrames;

    @BeforeEach
    void setUp() {
        causeFrames = new ArrayList<>();
        wrapperFrames = new ArrayList<>();
    }

    @Test
    void testRemoveCommonFrames_NoCommonFrames() {
        causeFrames.add("Frame 1");
        causeFrames.add("Frame 2");
        causeFrames.add("Frame 3");

        wrapperFrames.add("Wrapper Frame 1");
        wrapperFrames.add("Wrapper Frame 2");
        wrapperFrames.add("Wrapper Frame 3");

        ExceptionUtils.removeCommonFrames(causeFrames, wrapperFrames);

        assertEquals(3, causeFrames.size());
        assertEquals(3, wrapperFrames.size());
    }

    @Test
    void testRemoveCommonFrames_CommonFramesExist() {
        causeFrames.add("Common Frame 1");
        causeFrames.add("Common Frame 2");
        causeFrames.add("Frame 1");
        causeFrames.add("Frame 2");

        wrapperFrames.add("Common Frame 1");
        wrapperFrames.add("Common Frame 2");
        wrapperFrames.add("Wrapper Frame 1");
        wrapperFrames.add("Wrapper Frame 2");

        ExceptionUtils.removeCommonFrames(causeFrames, wrapperFrames);

        assertEquals(2, causeFrames.size());
        assertEquals(2, wrapperFrames.size());
    }

    @Test
    void testRemoveCommonFrames_CauseFramesEmpty() {
        wrapperFrames.add("Wrapper Frame 1");
        wrapperFrames.add("Wrapper Frame 2");
        wrapperFrames.add("Wrapper Frame 3");

        ExceptionUtils.removeCommonFrames(causeFrames, wrapperFrames);

        assertEquals(0, causeFrames.size());
        assertEquals(3, wrapperFrames.size());
    }

    @Test
    void testRemoveCommonFrames_WrapperFramesEmpty() {
        causeFrames.add("Frame 1");
        causeFrames.add("Frame 2");
        causeFrames.add("Frame 3");

        ExceptionUtils.removeCommonFrames(causeFrames, wrapperFrames);

        assertEquals(3, causeFrames.size());
        assertEquals(0, wrapperFrames.size());
    }

    @Test
    void testRemoveCommonFrames_BothFramesEmpty() {
        ExceptionUtils.removeCommonFrames(causeFrames, wrapperFrames);

        assertEquals(0, causeFrames.size());
        assertEquals(0, wrapperFrames.size());
    }

    @Test
    void testRemoveCommonFrames_CauseFramesNull() {
        assertThrows(NullPointerException.class, () -> ExceptionUtils.removeCommonFrames(null, wrapperFrames));
    }

    @Test
    void testRemoveCommonFrames_WrapperFramesNull() {
        assertThrows(NullPointerException.class, () -> ExceptionUtils.removeCommonFrames(causeFrames, null));
    }

    @Test
    void testRemoveCommonFrames_BothFramesNull() {
        assertThrows(NullPointerException.class, () -> ExceptionUtils.removeCommonFrames(null, null));
    }
}