import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getToStringStyleTest {

    private DiffResult diffResult;
    
    @BeforeEach
    void setUp() {
        List<Diff<?>> diffList = new ArrayList<>();
        ToStringStyle style = ToStringStyle.DEFAULT_STYLE;
        String toStringFormat = "%s differs from %s";
        diffResult = new DiffResult(null, null, diffList, style, toStringFormat);
    }
    
    @Test
    void getToStringStyle_NotNull() {
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_ReturnsCorrectStyle() {
        ToStringStyle expectedStyle = ToStringStyle.DEFAULT_STYLE;
        assertEquals(expectedStyle, diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_ChangeStyle() {
        ToStringStyle newStyle = ToStringStyle.MULTI_LINE_STYLE;
        diffResult.style = newStyle;
        assertEquals(newStyle, diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_ChangeStyleToNull() {
        diffResult.style = null;
        ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
        assertEquals(defaultStyle, diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_ChangeStyleAfterNull() {
        diffResult.style = null;
        ToStringStyle newStyle = ToStringStyle.NO_CLASS_NAME_STYLE;
        diffResult.style = newStyle;
        assertEquals(newStyle, diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_ChangeStyleToCustom() {
        ToStringStyle customStyle = new CustomToStringStyle();
        diffResult.style = customStyle;
        assertEquals(customStyle, diffResult.getToStringStyle());
    }
    
    // Additional tests for edge cases
    
    @Test
    void getToStringStyle_NullStyle() {
        diffResult.style = null;
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_NullToStringFormat() {
        diffResult.toStringFormat = null;
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_EmptyToStringFormat() {
        diffResult.toStringFormat = "";
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_NullLhs() {
        diffResult.lhs = null;
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_NullRhs() {
        diffResult.rhs = null;
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_NullDiffList() {
        diffResult.diffList = null;
        assertNotNull(diffResult.getToStringStyle());
    }
    
    @Test
    void getToStringStyle_EmptyDiffList() {
        diffResult.diffList = Collections.emptyList();
        assertNotNull(diffResult.getToStringStyle());
    }
    
    // Custom ToStringStyle for testing
    private class CustomToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1L;
        
        @Override
        public String toString() {
            return "CustomToStringStyle";
        }
    }
}