import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

  @Test
  void testToString_NullObject_ReturnsNullText() {
    String expected = ToStringStyle.DEFAULT_STYLE.getNullText();
    String result = ReflectionToStringBuilder.toString(null);
    assertEquals(expected, result);
  }

  @Test
  void testToString_DefaultStyle_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c";
    Object object = new Object();
    String result = ReflectionToStringBuilder.toString(object);
    assertEquals(expected, result);
  }

  @Test
  void testToString_CustomStyle_ReturnsExpectedString() {
    String expected = "CustomStyleString";
    Object object = new Object();
    ToStringStyle customStyle = new ToStringStyle() {
      @Override
      public String toString() {
        return "CustomStyleString";
      }
    };
    String result = ReflectionToStringBuilder.toString(object, customStyle);
    assertEquals(expected, result);
  }

  @Test
  void testToString_OutputTransients_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c[transientField=transientValue]";
    ObjectWithTransientFields object = new ObjectWithTransientFields();
    String result = ReflectionToStringBuilder.toString(object, true);
    assertEquals(expected, result);
  }

  @Test
  void testToString_OutputStatics_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c[staticField=staticValue]";
    ObjectWithStaticFields object = new ObjectWithStaticFields();
    String result = ReflectionToStringBuilder.toString(object, false, true);
    assertEquals(expected, result);
  }

  @Test
  void testToString_ExcludeNullValues_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c[stringField=stringValue]";
    ObjectWithNullFields object = new ObjectWithNullFields();
    String result = ReflectionToStringBuilder.toString(object, false, false, true);
    assertEquals(expected, result);
  }

  @Test
  void testToString_ReflectUpToClass_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c[parentField=parentValue,childField=childValue]";
    ChildObject child = new ChildObject();
    String result = ReflectionToStringBuilder.toString(child, false, false, ChildObject.class);
    assertEquals(expected, result);
  }

  @Test
  void testToString_AllOptions_ReturnsExpectedString() {
    String expected = "ToStringBuilder@1f4f0b4c[parentField=parentValue,childField=childValue]";
    ChildObject child = new ChildObject();
    ToStringStyle customStyle = new ToStringStyle() {
      @Override
      public String toString() {
        return "CustomStyleString";
      }
    };
    String result = ReflectionToStringBuilder.toString(child, customStyle, true, false, true, ChildObject.class);
    assertEquals(expected, result);
  }

  // Helper classes for testing

  static class ObjectWithTransientFields {
    private transient String transientField = "transientValue";
  }

  static class ObjectWithStaticFields {
    private static String staticField = "staticValue";
  }

  static class ObjectWithNullFields {
    private String stringField = "stringValue";
    private String nullField = null;
  }

  static class ParentObject {
    private String parentField = "parentValue";
  }

  static class ChildObject extends ParentObject {
    private String childField = "childValue";
  }
}