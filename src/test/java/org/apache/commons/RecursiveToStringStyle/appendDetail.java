import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class appendDetailTest {

    private RecursiveToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new RecursiveToStringStyle();
    }

    @Test
    void testAppendDetail_withCollection_shouldAppendClassNameAndIdentityHashCodeAndArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "field";
        Collection<String> coll = List.of("item1", "item2");

        style.appendDetail(buffer, fieldName, coll);

        assertEquals("java.util.ArrayList@" + Integer.toHexString(coll.hashCode()) + " [item1, item2]", buffer.toString());
    }

    @Test
    void testAppendDetail_withNonPrimitiveWrapper_shouldCallSuperAppendDetail() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "field";
        Integer value = 10;

        style.appendDetail(buffer, fieldName, value);

        assertEquals("field=" + value.toString(), buffer.toString());
    }

    @Test
    void testAppendDetail_withPrimitiveWrapper_shouldCallSuperAppendDetail() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "field";
        Boolean value = true;

        style.appendDetail(buffer, fieldName, value);

        assertEquals("field=" + value.toString(), buffer.toString());
    }

    @Test
    void testAppendDetail_withString_shouldCallSuperAppendDetail() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "field";
        String value = "text";

        style.appendDetail(buffer, fieldName, value);

        assertEquals("field=" + value, buffer.toString());
    }
}