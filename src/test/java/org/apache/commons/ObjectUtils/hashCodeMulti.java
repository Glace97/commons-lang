import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

class hashCodeMultiTest {

    @Test
    void testHashCodeMultiWithNoObjects() {
        int expected = 1;
        int actual = ObjectUtils.hashCodeMulti();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCodeMultiWithNullObjects() {
        int expected = 1;
        int actual = ObjectUtils.hashCodeMulti((Object[]) null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCodeMultiWithSingleObject() {
        Object obj = new Object();
        int expected = 31 + obj.hashCode();
        int actual = ObjectUtils.hashCodeMulti(obj);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCodeMultiWithMultipleObjects() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        int expected = ((31 + obj1.hashCode()) * 31 + obj2.hashCode()) * 31 + obj3.hashCode();
        int actual = ObjectUtils.hashCodeMulti(obj1, obj2, obj3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCodeMultiWithNullInObjects() {
        Object obj1 = new Object();
        Object obj2 = null;
        Object obj3 = new Object();
        int expected = ((31 + obj1.hashCode()) * 31) * 31 + obj3.hashCode();
        int actual = ObjectUtils.hashCodeMulti(obj1, obj2, obj3);
        Assertions.assertEquals(expected, actual);
    }
}