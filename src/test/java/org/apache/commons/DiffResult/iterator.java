import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class iteratorTest {

    private DiffResult diffResult;

    @BeforeEach
    void setUp() {
        List<Diff<?>> diffList = Arrays.asList(
                new Diff<>("field1", "value1", "value2"),
                new Diff<>("field2", 10, 20),
                new Diff<>("field3", true, false)
        );
        diffResult = new DiffResult("lhs", "rhs", diffList, ToStringStyle.DEFAULT_STYLE, "%s differs from %s");
    }

    @Test
    void iteratorShouldReturnCorrectNumberOfElements() {
        Iterator<Diff<?>> iterator = diffResult.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    void iteratorShouldReturnAllDiffsInOrder() {
        Iterator<Diff<?>> iterator = diffResult.iterator();
        List<Diff<?>> expectedDiffs = Arrays.asList(
                new Diff<>("field1", "value1", "value2"),
                new Diff<>("field2", 10, 20),
                new Diff<>("field3", true, false)
        );

        for (Diff<?> expectedDiff : expectedDiffs) {
            assertTrue(iterator.hasNext());
            assertEquals(expectedDiff, iterator.next());
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void iteratorShouldThrowExceptionWhenRemovingElement() {
        Iterator<Diff<?>> iterator = diffResult.iterator();
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}