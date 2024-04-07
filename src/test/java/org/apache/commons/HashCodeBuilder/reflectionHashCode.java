import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class reflectionHashCodeTest {

    @Test
    void reflectionHashCode_shouldReturnSameHashCodeForSameObject() {
        Object obj = new Object();
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj);
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void reflectionHashCode_shouldReturnDifferentHashCodeForDifferentObjects() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        int hashCode1 = HashCodeBuilder.reflectionHashCode(obj1);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(obj2);
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void reflectionHashCode_shouldIncludeAllFields() {
        class TestClass {
            private int field1;
            private String field2;
            private boolean field3;

            public TestClass(int field1, String field2, boolean field3) {
                this.field1 = field1;
                this.field2 = field2;
                this.field3 = field3;
            }
        }

        TestClass obj = new TestClass(10, "test", true);
        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertEquals(Objects.hash(10, "test", true), hashCode);
    }

    @Test
    void reflectionHashCode_shouldExcludeTransientFields() {
        class TestClass {
            private int field1;
            private transient String field2;

            public TestClass(int field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }
        }

        TestClass obj = new TestClass(10, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertEquals(Objects.hash(10), hashCode);
    }

    @Test
    void reflectionHashCode_shouldIncludeSuperclassFields() {
        class SuperClass {
            private int superField1;
        }

        class SubClass extends SuperClass {
            private String subField1;
        }

        SubClass obj = new SubClass();
        obj.superField1 = 10;
        obj.subField1 = "test";

        int hashCode = HashCodeBuilder.reflectionHashCode(obj);
        assertEquals(Objects.hash(10, "test"), hashCode);
    }

    @Test
    void reflectionHashCode_shouldIncludeFieldsUpToSpecifiedSuperclass() {
        class SuperClass {
            private int superField1;
        }

        class SubClass extends SuperClass {
            private String subField1;
        }

        SubClass obj = new SubClass();
        obj.superField1 = 10;
        obj.subField1 = "test";

        int hashCode = HashCodeBuilder.reflectionHashCode(obj, SuperClass.class);
        assertEquals(Objects.hash(10), hashCode);
    }

    @Test
    void reflectionHashCode_shouldExcludeSpecifiedFields() {
        class TestClass {
            private int field1;
            private String field2;

            public TestClass(int field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }
        }

        TestClass obj = new TestClass(10, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(obj, "field2");
        assertEquals(Objects.hash(10), hashCode);
    }

    @Test
    void reflectionHashCode_shouldReturnSameHashCodeForSameObjects_withCustomInitialAndMultiplierValues() {
        Object obj = new Object();
        int hashCode1 = HashCodeBuilder.reflectionHashCode(10, 20, obj);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(10, 20, obj);
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void reflectionHashCode_shouldReturnDifferentHashCodeForDifferentObjects_withCustomInitialAndMultiplierValues() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        int hashCode1 = HashCodeBuilder.reflectionHashCode(10, 20, obj1);
        int hashCode2 = HashCodeBuilder.reflectionHashCode(10, 20, obj2);
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void reflectionHashCode_shouldIncludeAllFields_withCustomInitialAndMultiplierValues() {
        class TestClass {
            private int field1;
            private String field2;
            private boolean field3;

            public TestClass(int field1, String field2, boolean field3) {
                this.field1 = field1;
                this.field2 = field2;
                this.field3 = field3;
            }
        }

        TestClass obj = new TestClass(10, "test", true);
        int hashCode = HashCodeBuilder.reflectionHashCode(10, 20, obj);
        assertEquals(Objects.hash(10, "test", true), hashCode);
    }

    @Test
    void reflectionHashCode_shouldExcludeTransientFields_withCustomInitialAndMultiplierValues() {
        class TestClass {
            private int field1;
            private transient String field2;

            public TestClass(int field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }
        }

        TestClass obj = new TestClass(10, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(10, 20, obj);
        assertEquals(Objects.hash(10), hashCode);
    }

    @Test
    void reflectionHashCode_shouldIncludeSuperclassFields_withCustomInitialAndMultiplierValues() {
        class SuperClass {
            private int superField1;
        }

        class SubClass extends SuperClass {
            private String subField1;
        }

        SubClass obj = new SubClass();
        obj.superField1 = 10;
        obj.subField1 = "test";

        int hashCode = HashCodeBuilder.reflectionHashCode(10, 20, obj);
        assertEquals(Objects.hash(10, "test"), hashCode);
    }

    @Test
    void reflectionHashCode_shouldIncludeFieldsUpToSpecifiedSuperclass_withCustomInitialAndMultiplierValues() {
        class SuperClass {
            private int superField1;
        }

        class SubClass extends SuperClass {
            private String subField1;
        }

        SubClass obj = new SubClass();
        obj.superField1 = 10;
        obj.subField1 = "test";

        int hashCode = HashCodeBuilder.reflectionHashCode(10, 20, obj, false, SuperClass.class);
        assertEquals(Objects.hash(10), hashCode);
    }

    @Test
    void reflectionHashCode_shouldExcludeSpecifiedFields_withCustomInitialAndMultiplierValues() {
        class TestClass {
            private int field1;
            private String field2;

            public TestClass(int field1, String field2) {
                this.field1 = field1;
                this.field2 = field2;
            }
        }

        TestClass obj = new TestClass(10, "test");
        int hashCode = HashCodeBuilder.reflectionHashCode(10, 20, obj, false, null, "field2");
        assertEquals(Objects.hash(10), hashCode);
    }
}