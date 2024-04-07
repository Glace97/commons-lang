import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class getDiffsTest {

    private DiffResult<String> diffResult;
    private List<Diff<?>> diffList;

    @BeforeEach
    void setUp() {
        diffList = new ArrayList<>();
        diffResult = new DiffResult<>("abc", "def", diffList, ToStringStyle.DEFAULT_STYLE, "%s differs from %s");
    }

    @Test
    @DisplayName("Test getDiffs - with differences")
    void testGetDiffs_withDifferences() {
        diffList.add(new Diff<>("property", "abc", "def"));
        List<Diff<?>> diffs = diffResult.getDiffs();
        assertNotNull(diffs);
        assertEquals(1, diffs.size());
        assertTrue(diffs.contains(new Diff<>("property", "abc", "def")));
    }

    @Test
    @DisplayName("Test getDiffs - no differences")
    void testGetDiffs_noDifferences() {
        List<Diff<?>> diffs = diffResult.getDiffs();
        assertNotNull(diffs);
        assertEquals(0, diffs.size());
    }
}