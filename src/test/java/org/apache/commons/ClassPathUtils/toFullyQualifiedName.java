import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toFullyQualifiedNameTest {

    @Test
    void toFullyQualifiedName_withClassAndResourceName_shouldReturnFullyQualifiedName() {
        String result = ClassPathUtils.toFullyQualifiedName(StringUtils.class, "StringUtils.properties");
        assertEquals("org.apache.commons.lang3.StringUtils.properties", result);
    }

    @Test
    void toFullyQualifiedName_withPackageAndResourceName_shouldReturnFullyQualifiedName() {
        String result = ClassPathUtils.toFullyQualifiedName(StringUtils.class.getPackage(), "StringUtils.properties");
        assertEquals("org.apache.commons.lang3.StringUtils.properties", result);
    }

    @Test
    void toFullyQualifiedName_withNullContext_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedName(null, "StringUtils.properties");
        });
    }

    @Test
    void toFullyQualifiedName_withNullResourceName_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            ClassPathUtils.toFullyQualifiedName(StringUtils.class, null);
        });
    }
}