import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class getThrowableListTest {

	@Test
	void testGetThrowableList_NullThrowable_ReturnsEmptyList() {
		Throwable throwable = null;
		
		List<Throwable> result = ExceptionUtils.getThrowableList(throwable);
		
		assertTrue(result.isEmpty());
	}
	
	@Test
	void testGetThrowableList_ThrowableWithoutCause_ReturnsListWithInputThrowable() {
		Throwable throwable = new Throwable();
		
		List<Throwable> result = ExceptionUtils.getThrowableList(throwable);
		
		assertEquals(1, result.size());
		assertSame(throwable, result.get(0));
	}
	
	@Test
	void testGetThrowableList_ThrowableWithOneCause_ReturnsListWithInputThrowableAndCauseThrowable() {
		Throwable cause = new Throwable();
		Throwable throwable = new Throwable(cause);
		
		List<Throwable> result = ExceptionUtils.getThrowableList(throwable);
		
		assertEquals(2, result.size());
		assertSame(throwable, result.get(0));
		assertSame(cause, result.get(1));
	}
	
	@Test
	void testGetThrowableList_ThrowableWithRecursiveCause_ReturnsListWithInputThrowableAndRecursiveCause() {
		Throwable cause1 = new Throwable();
		Throwable cause2 = new Throwable(cause1);
		Throwable throwable = new Throwable(cause2);
		
		List<Throwable> result = ExceptionUtils.getThrowableList(throwable);
		
		assertEquals(3, result.size());
		assertSame(throwable, result.get(0));
		assertSame(cause2, result.get(1));
		assertSame(cause1, result.get(2));
	}
	
	@Test
	void testGetThrowableList_ThrowableWithSelfCause_ReturnsListWithInputThrowableOnly() {
		Throwable throwable = new Throwable();
		throwable.initCause(throwable);
		
		List<Throwable> result = ExceptionUtils.getThrowableList(throwable);
		
		assertEquals(1, result.size());
		assertSame(throwable, result.get(0));
	}
}