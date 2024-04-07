import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class toStringTest {
  
  @Test
  void testToStringWithEmptyAnnotation() {
    AnnotationUtils annotationUtils = new AnnotationUtils();
    EmptyAnnotation emptyAnnotation = createEmptyAnnotation();
    
    String expected = "EmptyAnnotation()";
    String actual = annotationUtils.toString(emptyAnnotation);
    
    assertEquals(expected, actual);
  }
  
  @Test
  void testToStringWithSingleValueAnnotation() {
    AnnotationUtils annotationUtils = new AnnotationUtils();
    SingleValueAnnotation singleValueAnnotation = createSingleValueAnnotation();
    
    String expected = "SingleValueAnnotation(value=10)";
    String actual = annotationUtils.toString(singleValueAnnotation);
    
    assertEquals(expected, actual);
  }
  
  @Test
  void testToStringWithArrayAnnotation() {
    AnnotationUtils annotationUtils = new AnnotationUtils();
    ArrayAnnotation arrayAnnotation = createArrayAnnotation();
    
    String expected = "ArrayAnnotation(value=[1, 2, 3])";
    String actual = annotationUtils.toString(arrayAnnotation);
    
    assertEquals(expected, actual);
  }
  
  @Test
  void testToStringWithMultipleValuesAnnotation() {
    AnnotationUtils annotationUtils = new AnnotationUtils();
    MultipleValuesAnnotation multipleValuesAnnotation = createMultipleValuesAnnotation();
    
    String expected = "MultipleValuesAnnotation(value=10, name=John)";
    String actual = annotationUtils.toString(multipleValuesAnnotation);
    
    assertEquals(expected, actual);
  }
  
  @Test
  void testToStringWithNestedAnnotation() {
    AnnotationUtils annotationUtils = new AnnotationUtils();
    NestedAnnotation nestedAnnotation = createNestedAnnotation();
    
    String expected = "NestedAnnotation(subAnnotation=@SubAnnotation(subValue=20))";
    String actual = annotationUtils.toString(nestedAnnotation);
    
    assertEquals(expected, actual);
  }
  
  private EmptyAnnotation createEmptyAnnotation() {
    return new EmptyAnnotation() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return EmptyAnnotation.class;
      }
    };
  }
  
  private SingleValueAnnotation createSingleValueAnnotation() {
    return new SingleValueAnnotation() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return SingleValueAnnotation.class;
      }
      
      @Override
      public int value() {
        return 10;
      }
    };
  }
  
  private ArrayAnnotation createArrayAnnotation() {
    return new ArrayAnnotation() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return ArrayAnnotation.class;
      }
      
      @Override
      public int[] value() {
        return new int[] {1, 2, 3};
      }
    };
  }
  
  private MultipleValuesAnnotation createMultipleValuesAnnotation() {
    return new MultipleValuesAnnotation() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return MultipleValuesAnnotation.class;
      }
      
      @Override
      public int value() {
        return 10;
      }
      
      @Override
      public String name() {
        return "John";
      }
    };
  }
  
  private NestedAnnotation createNestedAnnotation() {
    return new NestedAnnotation() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return NestedAnnotation.class;
      }
      
      @Override
      public SubAnnotation subAnnotation() {
        return new SubAnnotation() {
          @Override
          public Class<? extends Annotation> annotationType() {
            return SubAnnotation.class;
          }
          
          @Override
          public int subValue() {
            return 20;
          }
        };
      }
    };
  }
  
  @interface EmptyAnnotation {
    // Empty annotation
  }
  
  @interface SingleValueAnnotation {
    int value();
  }
  
  @interface ArrayAnnotation {
    int[] value();
  }
  
  @interface MultipleValuesAnnotation {
    int value();
    String name();
  }
  
  @interface NestedAnnotation {
    SubAnnotation subAnnotation();
  }
  
  @interface SubAnnotation {
    int subValue();
  }
}