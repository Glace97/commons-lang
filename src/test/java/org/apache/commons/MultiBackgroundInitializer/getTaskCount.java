import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getTaskCountTest {
    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeEach
    void setUp() {
        multiBackgroundInitializer = new MultiBackgroundInitializer();
    }

    @Test
    void testGetTaskCountNoChildInitializers() {
        assertEquals(1, multiBackgroundInitializer.getTaskCount());
    }

    @Test
    void testGetTaskCountWithChildInitializers() {
        BackgroundInitializer<?> childInitializer1 = new BackgroundInitializerImpl();
        BackgroundInitializer<?> childInitializer2 = new BackgroundInitializerImpl();
        multiBackgroundInitializer.childInitializers.put("child1", childInitializer1);
        multiBackgroundInitializer.childInitializers.put("child2", childInitializer2);
        
        assertEquals(3, multiBackgroundInitializer.getTaskCount());
    }

    @Test
    void testGetTaskCountWithNestedMultiBackgroundInitializer() {
        BackgroundInitializer<?> childInitializer = new BackgroundInitializerImpl();
        MultiBackgroundInitializer nestedMultiBackgroundInitializer = new MultiBackgroundInitializer();
        nestedMultiBackgroundInitializer.childInitializers.put("nestedChild", childInitializer);
        multiBackgroundInitializer.childInitializers.put("nestedMulti", nestedMultiBackgroundInitializer);
        
        assertEquals(4, multiBackgroundInitializer.getTaskCount());
    }

    @Test
    void testGetTaskCountWithNullChildInitializer() {
        multiBackgroundInitializer.childInitializers.put("child", null);
        
        assertEquals(2, multiBackgroundInitializer.getTaskCount());
    }

    private static class BackgroundInitializerImpl extends BackgroundInitializer<Object> {
        @Override
        protected Object initialize() throws Exception {
            return null;
        }
    }
}