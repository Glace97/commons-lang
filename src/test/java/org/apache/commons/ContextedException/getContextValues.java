import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

@TestInstance(Lifecycle.PER_CLASS)
class getContextValuesTest {

    @Test
    void testGetContextValues_ReturnsEmptyList_WhenLabelDoesNotExist() {
        // Arrange
        ContextedException exception = new ContextedException();
        String label = "nonexistentLabel";

        // Act
        List<Object> contextValues = exception.getContextValues(label);

        // Assert
        Assertions.assertEquals(0, contextValues.size());
    }

    @Test
    void testGetContextValues_ReturnsEmptyList_WhenContextValuesNotSet() {
        // Arrange
        ContextedException exception = new ContextedException();
        String label = "label";

        // Act
        List<Object> contextValues = exception.getContextValues(label);

        // Assert
        Assertions.assertEquals(0, contextValues.size());
    }

    @Test
    void testGetContextValues_ReturnsContextValues_WhenLabelExists() {
        // Arrange
        ContextedException exception = new ContextedException();
        String label = "label";
        List<Object> values = new ArrayList<>();
        values.add("value1");
        values.add("value2");
        exception.exceptionContext.setContextValues(label, values);

        // Act
        List<Object> contextValues = exception.getContextValues(label);

        // Assert
        Assertions.assertEquals(values, contextValues);
    }
}