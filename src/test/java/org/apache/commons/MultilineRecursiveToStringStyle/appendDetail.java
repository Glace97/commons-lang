import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class appendDetailTest {

    private MultilineRecursiveToStringStyle style;

    @BeforeEach
    void setUp() {
        style = new MultilineRecursiveToStringStyle();
    }

    @Test
    void testAppendDetail_booleanArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        boolean[] array = {true, false, true};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=true, array=false, array=true", buffer.toString());
    }

    @Test
    void testAppendDetail_byteArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        byte[] array = {1, 2, 3};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1, array=2, array=3", buffer.toString());
    }

    @Test
    void testAppendDetail_charArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        char[] array = {'a', 'b', 'c'};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=a, array=b, array=c", buffer.toString());
    }

    @Test
    void testAppendDetail_doubleArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        double[] array = {1.0, 2.0, 3.0};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1.0, array=2.0, array=3.0", buffer.toString());
    }

    @Test
    void testAppendDetail_floatArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        float[] array = {1.0f, 2.0f, 3.0f};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1.0, array=2.0, array=3.0", buffer.toString());
    }

    @Test
    void testAppendDetail_intArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        int[] array = {1, 2, 3};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1, array=2, array=3", buffer.toString());
    }

    @Test
    void testAppendDetail_longArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        long[] array = {1L, 2L, 3L};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1, array=2, array=3", buffer.toString());
    }

    @Test
    void testAppendDetail_object() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "obj";
        Object obj = new Object();
        style.appendDetail(buffer, fieldName, obj);
        assertEquals("obj=java.lang.Object@{hashcode}", buffer.toString());
    }

    @Test
    void testAppendDetail_objectArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        Object[] array = {new Object(), new Object(), new Object()};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=java.lang.Object@{hashcode}, array=java.lang.Object@{hashcode}, array=java.lang.Object@{hashcode}", buffer.toString());
    }

    @Test
    void testAppendDetail_shortArray() {
        StringBuffer buffer = new StringBuffer();
        String fieldName = "array";
        short[] array = {1, 2, 3};
        style.appendDetail(buffer, fieldName, array);
        assertEquals("array=1, array=2, array=3", buffer.toString());
    }

}