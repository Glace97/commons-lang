
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class getEnumListTest {

    @Test
    void testGetEnumList() {
        List<MyEnum> enumList = EnumUtils.getEnumList(MyEnum.class);
        
        assertEquals(4, enumList.size());
        assertEquals(MyEnum.VALUE1, enumList.get(0));
        assertEquals(MyEnum.VALUE2, enumList.get(1));
        assertEquals(MyEnum.VALUE3, enumList.get(2));
        assertEquals(MyEnum.VALUE4, enumList.get(3));
    }

    @Test
    void testEmptyEnumList() {
        List<EmptyEnum> enumList = EnumUtils.getEnumList(EmptyEnum.class);
        assertEquals(0, enumList.size());
    }

    @Test
    void testNullEnumClass() {
        assertThrows(NullPointerException.class, () -> {
            EnumUtils.getEnumList(null);
        });
    }

    @Test
    void testEnumListModification() {
        List<MyEnum> enumList = EnumUtils.getEnumList(MyEnum.class);
        
        assertThrows(UnsupportedOperationException.class, () -> {
            enumList.add(MyEnum.VALUE5);
        });
    }

    enum MyEnum {
        VALUE1, VALUE2, VALUE3, VALUE4
    }
    
    enum EmptyEnum {
        
    }
}
