import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

class appendDetailTest {
   
   @Test
   void testAppendDetailWithAnnotation() {
      AnnotationUtils annotationUtils = new AnnotationUtils();
      
      ToStringStyle.TO_STRING_STYLE.appendDetail(new StringBuffer(), "fieldName", new Annotation() {
         @Override
         public Class<? extends Annotation> annotationType() {
            return null;
         }
      });
   }
   
   @Test
   void testAppendDetailWithString() {
      AnnotationUtils annotationUtils = new AnnotationUtils();
      
      ToStringStyle.TO_STRING_STYLE.appendDetail(new StringBuffer(), "fieldName", "value");
   }
   
   @Test
   void testAppendDetailWithNullValue() {
      AnnotationUtils annotationUtils = new AnnotationUtils();
      
      ToStringStyle.TO_STRING_STYLE.appendDetail(new StringBuffer(), "fieldName", null);
   }
   
   @Test
   void testAppendDetailWithArray() {
      AnnotationUtils annotationUtils = new AnnotationUtils();
      
      ToStringStyle.TO_STRING_STYLE.appendDetail(new StringBuffer(), "fieldName", new Object[] {1, 2, 3});
   }
   
   @Test
   void testAppendDetailWithEmptyArray() {
      AnnotationUtils annotationUtils = new AnnotationUtils();
      
      ToStringStyle.TO_STRING_STYLE.appendDetail(new StringBuffer(), "fieldName", new Object[] {});
   }
}