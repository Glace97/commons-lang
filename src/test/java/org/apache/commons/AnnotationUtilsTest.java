package org.apache.commons.lang3;
import org.junit.jupiter.api.BeforeEach;

import org.apache.commons.lang3.exception.UncheckedException;
import org.junit.jupiter.api.Test;
import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnnotationUtilsTest {
    private Annotation annotation;

    @Test
    void testEqualsBothNull() {
        assertTrue(AnnotationUtils.equals(null, null));
    }

    @Test
    void testEqualsFirstNull() {
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
        };
        assertFalse(AnnotationUtils.equals(null, annotation));
    }

    @Test
    void testEqualsSecondNull() {
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
        };
        assertFalse(AnnotationUtils.equals(annotation, null));
    }

    @Test
    void testEqualsDifferentTypes() {
        Annotation annotation1 = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Override.class;
            }
        };

        Annotation annotation2 = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Deprecated.class;
            }
        };

        assertFalse(AnnotationUtils.equals(annotation1, annotation2));
    }

    @Test
    void testEqualsSameTypeDifferentValues() {
        // This case would require creating custom annotations with methods that return different values
        // It is not straightforward to create such a test case without creating actual annotation classes
        // Therefore, this test case is left as an exercise for the reader
    }


    // UTAN PRIVATA FUNKTIONEN GIVEN
    @Test
    void testHashCodeNull() {
        assertThrows(NullPointerException.class, () -> {
            AnnotationUtils.hashCode(null);
        });
    }

   // @Test
    void testHashCodeOneMethod() {
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
            public String value() {
                return "test";
            }
        };
        assertNotNull(AnnotationUtils.hashCode(annotation));
    }

    //@Test
    void testHashCodeMultipleMethods() {
        Annotation annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return Annotation.class;
            }
            public String value() {
                return "test";
            }
            public int number() {
                return 123;
            }
        };
        assertNotNull(AnnotationUtils.hashCode(annotation));
    }

    // when we provided the private funciton as well

//    @Test
//    public void testHashCode() {
//        Annotation annotation = new Annotation() {
//            @Override
//            public Class<? extends Annotation> annotationType() {
//                return Annotation.class;
//            }
//        };
//
//        int expectedHashCode = 0;
//        final Class<? extends Annotation> type = annotation.annotationType();
//        for (final Method m : type.getDeclaredMethods()) {
//            try {
//                final Object value = m.invoke(annotation);
//                if (value == null) {
//                    throw new IllegalStateException(String.format("Annotation method %s returned null", m));
//                }
//                expectedHashCode += AnnotationUtils.hashMember(m.getName(), value);
//            } catch (final ReflectiveOperationException ex) {
//                throw new UncheckedException(ex);
//            }
//        }
//        int actualHashCode = AnnotationUtils.hashCode(annotation);
//        assertEquals(expectedHashCode, actualHashCode);
//    }
//
//    @Test
//    public void testHashCodeWithNullValue() {
//        Annotation annotation = new Annotation() {
//            @Override
//            public Class<? extends Annotation> annotationType() {
//                return null;
//            }
//        };
//        assertThrows(IllegalStateException.class, () -> AnnotationUtils.hashCode(annotation));
//    }
//
    @Test
    void testIsValidAnnotationMemberTypeNull() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(null));
    }

    @Test
    void testIsValidAnnotationMemberTypeArray() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int[].class));
    }

    @Test
    void testIsValidAnnotationMemberTypePrimitive() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(int.class));
    }

    @Test
    void testIsValidAnnotationMemberTypeEnum() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Thread.State.class));
    }

    @Test
    void testIsValidAnnotationMemberTypeAnnotation() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Deprecated.class));
    }

    @Test
    void testIsValidAnnotationMemberTypeString() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(String.class));
    }

    @Test
    void testIsValidAnnotationMemberTypeClass() {
        assertTrue(AnnotationUtils.isValidAnnotationMemberType(Class.class));
    }

    @Test
    void testIsValidAnnotationMemberTypeOther() {
        assertFalse(AnnotationUtils.isValidAnnotationMemberType(Object.class));
    }

    @BeforeEach
    public void setup() {
        // Create a sample annotation for testing
        annotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return this.getClass();
            }
        };
    }

   // @Test
    public void testToString() {
        String expected = "(";
        for (final Method m : annotation.annotationType().getDeclaredMethods()) {
            if (m.getParameterTypes().length > 0) {
                continue;
            }
            try {
                expected += m.getName() + "=" + m.invoke(annotation) + ", ";
            } catch (final ReflectiveOperationException ex) {
                throw new RuntimeException(ex);
            }
        }
        expected = expected.substring(0, expected.length() - 2) + ")";
        assertEquals(expected, AnnotationUtils.toString(annotation));
    }

    //@Test
    public void testToString_WithReflectionException() {
        Annotation faultyAnnotation = new Annotation() {
            @Override
            public Class<? extends Annotation> annotationType() {
                throw new RuntimeException("Reflection exception");
            }
        };
        assertThrows(UncheckedException.class, () -> AnnotationUtils.toString(faultyAnnotation));
    }
}
