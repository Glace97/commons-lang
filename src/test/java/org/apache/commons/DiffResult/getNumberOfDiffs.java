import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getNumberOfDiffsTest {

    private DiffResult<String> diffResult;
    
    @BeforeEach
    void setUp() {
        List<Diff<?>> diffList = new ArrayList<>();
        diffList.add(new Diff<>("field1", "value1"));
        diffList.add(new Diff<>("field2", "value2"));
        diffList.add(new Diff<>("field3", "value3"));
        diffResult = new DiffResult<>("object1", "object2", diffList, null, null);
    }
    
    @Nested
    @DisplayName("When diffList is empty")
    class WhenDiffListIsEmpty {
        
        @BeforeEach
        void setUp() {
            diffResult = new DiffResult<>("object1", "object2", Collections.emptyList(), null, null);
        }
        
        @Test
        @DisplayName("Should return 0")
        void shouldReturnZero() {
            assertEquals(0, diffResult.getNumberOfDiffs());
        }
    }
    
    @Nested
    @DisplayName("When diffList is not empty")
    class WhenDiffListIsNotEmpty {
        
        @Test
        @DisplayName("Should return the size of diffList")
        void shouldReturnDiffListSize() {
            assertEquals(3, diffResult.getNumberOfDiffs());
        }
    }
}