
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class buildTest {

    private ReflectionDiffBuilder<Object> reflectionDiffBuilder;
    private DiffResult<Object> diffResult;

    @BeforeEach
    void setUp() {
        reflectionDiffBuilder = mock(ReflectionDiffBuilder.class);
        diffResult = mock(DiffResult.class);
    }

    @Test
    void testBuild_ObjectsAreEqual() {
        Object left = new Object();
        Object right = new Object();

        when(reflectionDiffBuilder.getLeft()).thenReturn(left);
        when(reflectionDiffBuilder.getRight()).thenReturn(right);
        when(left.equals(right)).thenReturn(true);

        DiffResult<Object> result = reflectionDiffBuilder.build();

        verify(reflectionDiffBuilder).build();
        assertEquals(diffResult, result);
    }

    @Test
    void testBuild_ObjectsAreNotEqual() {
        Object left = new Object();
        Object right = new Object();

        when(reflectionDiffBuilder.getLeft()).thenReturn(left);
        when(reflectionDiffBuilder.getRight()).thenReturn(right);
        when(left.equals(right)).thenReturn(false);

        reflectionDiffBuilder.build();

        verify(reflectionDiffBuilder).appendFields(left.getClass());
        verify(reflectionDiffBuilder).build();
    }

}
