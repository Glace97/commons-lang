import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class getRightTest {

    @Test
    void testGetRight() {
        // Create sample objects
        String lhs = "left";
        String rhs = "right";
        List<Diff<?>> diffList = new ArrayList<>();
        ToStringStyle style = ToStringStyle.DEFAULT_STYLE;
        String toStringFormat = "%s differs from %s";
        
        // Create DiffResult object
        DiffResult diffResult = new DiffResult(lhs, rhs, diffList, style, toStringFormat);
        
        // Test getRight method
        String result = diffResult.getRight();
        
        // Assert the result is the same as the expected value
        assertEquals(rhs, result);
    }
}