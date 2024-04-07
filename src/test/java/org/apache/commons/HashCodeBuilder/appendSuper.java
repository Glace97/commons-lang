import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class appendSuperTest {

    @Test
    void testAppendSuper() {
        HashCodeBuilder builder = new HashCodeBuilder();
        int superHashCode = 12345;
        int expectedTotal = builder.iTotal * builder.iConstant + superHashCode;

        HashCodeBuilder result = builder.appendSuper(superHashCode);

        Assertions.assertEquals(expectedTotal, result.iTotal);
    }
}