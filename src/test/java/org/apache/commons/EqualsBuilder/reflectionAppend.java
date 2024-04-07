import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class reflectionAppendTest {

    @Test
    void testReflectionAppend_SameObject() {
        Object obj = new Object();
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(obj, obj));
        assertTrue(builder.isEquals);
    }

    @Test
    void testReflectionAppend_NullObject() {
        Object obj = new Object();
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(obj, null));
        assertFalse(builder.isEquals);

        assertSame(builder, builder.reflectionAppend(null, obj));
        assertFalse(builder.isEquals);

        assertSame(builder, builder.reflectionAppend(null, null));
        assertFalse(builder.isEquals);
    }

    @Test
    void testReflectionAppend_Arrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(array1, array2));
        assertTrue(builder.isEquals);
    }

    @Test
    void testReflectionAppend_BypassReflectionClasses() {
        String str1 = "hello";
        String str2 = "hello";
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(str1, str2));
        assertTrue(builder.isEquals);
    }

    @Test
    void testReflectionAppend_SubclassWithIvars() {
        Subclass obj1 = new Subclass("hello", 123);
        Subclass obj2 = new Subclass("hello", 123);
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(obj1, obj2));
        assertTrue(builder.isEquals);
    }

    @Test
    void testReflectionAppend_SubclassWithoutIvars() {
        SubclassWithoutIvars obj1 = new SubclassWithoutIvars();
        SubclassWithoutIvars obj2 = new SubclassWithoutIvars();
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(obj1, obj2));
        assertTrue(builder.isEquals);
    }

    @Test
    void testReflectionAppend_Exception() {
        EqualsBuilder builder = new EqualsBuilder();

        assertSame(builder, builder.reflectionAppend(new Exception(), new Exception()));
        assertFalse(builder.isEquals);
    }

    class Subclass extends EqualsBuilder {
        private String str;
        private int num;

        Subclass(String str, int num) {
            this.str = str;
            this.num = num;
        }
    }

    class SubclassWithoutIvars extends EqualsBuilder {
    }
}