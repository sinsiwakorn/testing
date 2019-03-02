package th.co.cdgs.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static th.co.cdgs.train.Train.add;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import th.co.cdgs.bean.TestBean;

public class TestTrain {

	@Test
	public void add_addValue_three() {

		// Arrange
		Integer x = 1;
		Integer y = 2;
		
		// Act
		int actual = add(x, y);
		
		// Assert
		assertEquals(3, actual);
		
	}

	@Test
	public void add_addValue_nullPointerException() {

		// Arrange
		Integer x = null;
		Integer y = 2;
		
		// Act
		NullPointerException throwException = assertThrows(NullPointerException.class, () -> add(x, y));
		
		// Assert
//		assertEquals(3, actual);
		
	}

	@ParameterizedTest
	@MethodSource("provideAdd_addValue_success")
	public void add_addValue_success(TestBean<Map<String, Integer>, Integer> testBean) {
		// Arrange
		Map<String, Integer> testParam = testBean.getArrangeValue();
		Integer x = testParam.get("x");
		Integer y = testParam.get("y");
		
		// Act
		Integer actual = add(x, y);
		
		// Assert
		assertEquals(testBean.getExpectValue(), actual);
	}
	
	static Stream<TestBean<Map<String, Integer>, Integer>> provideAdd_addValue_success() {
		
		Map<String, Integer> a = new HashMap<String, Integer>();
		a.put("x", 1);
		a.put("y", 2);
		
		Map<String, Integer> b = new HashMap<String, Integer>() {{
			put("x", 2);
			put("y", 3);
		}};
		
		return Stream.of(
				new TestBean<Map<String, Integer>, Integer>(a, 3),
				new TestBean<Map<String, Integer>, Integer>(b, 5),
				new TestBean<Map<String, Integer>, Integer>(b, 5),
				new TestBean<Map<String, Integer>, Integer>(b, 5),
				new TestBean<Map<String, Integer>, Integer>(b, 5),
				new TestBean<Map<String, Integer>, Integer>(b, 5)
			);
	}
	
}
