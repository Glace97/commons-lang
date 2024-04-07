import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class resolveVariableTest {

    private StrSubstitutor substitutor;

    @BeforeEach
    void setup() {
        substitutor = new StrSubstitutor();
    }

    @Test
    void testResolveVariable_WithExistingVariable_ShouldReturnVariableValue() {
        // Arrange
        substitutor.setVariableResolver(new StrLookup<String>() {
            @Override
            public String lookup(String key) {
                if (key.equals("name")) {
                    return "John";
                }
                return null;
            }
        });
        String variableName = "name";
        StrBuilder buf = new StrBuilder();
        buf.append("Hello, ${name}!");
        int startPos = 7;
        int endPos = 13;

        // Act
        String result = substitutor.resolveVariable(variableName, buf, startPos, endPos);

        // Assert
        assertEquals("John", result);
    }

    @Test
    void testResolveVariable_WithNonExistingVariable_ShouldReturnNull() {
        // Arrange
        substitutor.setVariableResolver(null);
        String variableName = "age";
        StrBuilder buf = new StrBuilder();
        buf.append("My age is ${age}.");
        int startPos = 11;
        int endPos = 15;

        // Act
        String result = substitutor.resolveVariable(variableName, buf, startPos, endPos);

        // Assert
        assertNull(result);
    }

    @Test
    void testResolveVariable_WithEmptyBuffer_ShouldReturnNull() {
        // Arrange
        substitutor.setVariableResolver(null);
        String variableName = "name";
        StrBuilder buf = new StrBuilder();
        int startPos = 0;
        int endPos = 0;

        // Act
        String result = substitutor.resolveVariable(variableName, buf, startPos, endPos);

        // Assert
        assertNull(result);
    }

    @Test
    void testResolveVariable_WithInvalidStartPos_ShouldThrowException() {
        // Arrange
        substitutor.setVariableResolver(null);
        String variableName = "name";
        StrBuilder buf = new StrBuilder();
        buf.append("Hello, ${name}!");
        int startPos = -1;
        int endPos = 13;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> substitutor.resolveVariable(variableName, buf, startPos, endPos));
    }

    @Test
    void testResolveVariable_WithInvalidEndPos_ShouldThrowException() {
        // Arrange
        substitutor.setVariableResolver(null);
        String variableName = "name";
        StrBuilder buf = new StrBuilder();
        buf.append("Hello, ${name}!");
        int startPos = 7;
        int endPos = 20;

        // Act & Assert
        assertThrows(IndexOutOfBoundsException.class, () -> substitutor.resolveVariable(variableName, buf, startPos, endPos));
    }
}