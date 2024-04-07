
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class reflectionCompareTest {

    @Test
    void reflectionCompare_ShouldReturnZero_WhenBothObjectsAreNull() {
        assertEquals(0, CompareToBuilder.reflectionCompare(null, null));
    }

    @Test
    void reflectionCompare_ShouldThrowNullPointerException_WhenOnlyOneObjectIsNull() {
        assertThrows(NullPointerException.class, () -> CompareToBuilder.reflectionCompare(null, new Object()));
        assertThrows(NullPointerException.class, () -> CompareToBuilder.reflectionCompare(new Object(), null));
    }

    @Test
    void reflectionCompare_ShouldThrowClassCastException_WhenObjectsAreNotAssignmentCompatible() {
        assertThrows(ClassCastException.class, () -> CompareToBuilder.reflectionCompare(new Integer(1), new String("1")));
    }

    @Test
    void reflectionCompare_ShouldReturnZero_WhenObjectsAreEqual() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertEquals(0, CompareToBuilder.reflectionCompare(obj1, obj2));
    }

    @Test
    void reflectionCompare_ShouldReturnPositiveInteger_WhenFirstObjectIsGreaterThanSecondObject() {
        Object obj1 = new Integer(2);
        Object obj2 = new Integer(1);
        assertTrue(CompareToBuilder.reflectionCompare(obj1, obj2) > 0);
    }

    @Test
    void reflectionCompare_ShouldReturnNegativeInteger_WhenFirstObjectIsLessThanSecondObject() {
        Object obj1 = new Integer(1);
        Object obj2 = new Integer(2);
        assertTrue(CompareToBuilder.reflectionCompare(obj1, obj2) < 0);
    }

    // Add more test cases to cover edge cases and achieve high coverage

}
