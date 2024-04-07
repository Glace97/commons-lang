import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class setBypassReflectionClassesTest {

    private EqualsBuilder equalsBuilder;

    @BeforeEach
    void setUp() {
        equalsBuilder = new EqualsBuilder();
    }

    @Test
    void setBypassReflectionClasses_WithNullList_ShouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> equalsBuilder.setBypassReflectionClasses(null));
    }

    @Test
    void setBypassReflectionClasses_WithEmptyList_ShouldSetBypassReflectionClassesToEmptyList() {
        equalsBuilder.setBypassReflectionClasses(new ArrayList<>());
        List<Class<?>> actualBypassReflectionClasses = equalsBuilder.bypassReflectionClasses;
        assertTrue(actualBypassReflectionClasses.isEmpty());
    }

    @Test
    void setBypassReflectionClasses_WithNonEmptyList_ShouldSetBypassReflectionClassesToGivenList() {
        List<Class<?>> expectedBypassReflectionClasses = new ArrayList<>();
        expectedBypassReflectionClasses.add(String.class);
        expectedBypassReflectionClasses.add(Integer.class);
        equalsBuilder.setBypassReflectionClasses(expectedBypassReflectionClasses);
        List<Class<?>> actualBypassReflectionClasses = equalsBuilder.bypassReflectionClasses;
        assertEquals(expectedBypassReflectionClasses, actualBypassReflectionClasses);
    }

    @Test
    void setBypassReflectionClasses_WithExistingBypassReflectionClasses_ShouldReplaceBypassReflectionClasses() {
        List<Class<?>> initialBypassReflectionClasses = new ArrayList<>();
        initialBypassReflectionClasses.add(String.class);
        equalsBuilder.setBypassReflectionClasses(initialBypassReflectionClasses);
        List<Class<?>> newBypassReflectionClasses = new ArrayList<>();
        newBypassReflectionClasses.add(Integer.class);
        equalsBuilder.setBypassReflectionClasses(newBypassReflectionClasses);
        List<Class<?>> actualBypassReflectionClasses = equalsBuilder.bypassReflectionClasses;
        assertEquals(newBypassReflectionClasses, actualBypassReflectionClasses);
    }

}