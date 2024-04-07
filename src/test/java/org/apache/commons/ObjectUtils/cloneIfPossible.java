
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CloneIfPossibleTest {

    @Nested
    @DisplayName("When cloning a cloneable object")
    class CloneableTest {
        
        private CloneableObject cloneableObject;

        @BeforeEach
        void setUp() {
            cloneableObject = new CloneableObject();
        }

        @Test
        @DisplayName("Should return a clone of the object")
        void testCloneable() {
            CloneableObject clone = ObjectUtils.cloneIfPossible(cloneableObject);
            assertNotSame(cloneableObject, clone);
            assertEquals(cloneableObject, clone);
        }

        @Test
        @DisplayName("Should throw CloneFailedException if clone operation fails")
        void testCloneableWithFailedClone() {
            cloneableObject.setFailClone(true);
            assertThrows(CloneFailedException.class, () -> ObjectUtils.cloneIfPossible(cloneableObject));
        }
    }

    @Nested
    @DisplayName("When cloning a non-cloneable object")
    class NonCloneableTest {

        private NonCloneableObject nonCloneableObject;

        @BeforeEach
        void setUp() {
            nonCloneableObject = new NonCloneableObject();
        }

        @Test
        @DisplayName("Should return the same object")
        void testNonCloneable() {
            NonCloneableObject nonCloneable = ObjectUtils.cloneIfPossible(nonCloneableObject);
            assertSame(nonCloneableObject, nonCloneable);
        }
    }

    private static class CloneableObject implements Cloneable {

        private boolean failClone;

        public void setFailClone(boolean failClone) {
            this.failClone = failClone;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            if (failClone) {
                throw new CloneNotSupportedException();
            }
            return super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }

    private static class NonCloneableObject {
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return 42;
        }
    }
}
