package projeto;

import static org.hamcrest.core.Is.is;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class RomanNumberComponentTest {

	private RomanNumberComponent toRoman;
	
	private Map<Integer, String> mapUseCases;
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Rule
	public ExpectedException exceptionExpected = ExpectedException.none();
	

	@Before
	public void init() {
		toRoman = new RomanNumberComponent();
		
		mapUseCases = new HashMap<Integer, String>();
		mapUseCases.put(1, "I");
		mapUseCases.put(2, "II");
		mapUseCases.put(3, "III");
		mapUseCases.put(4, "IV");
		mapUseCases.put(5, "V");
		mapUseCases.put(6, "VI");
		mapUseCases.put(9, "IX");
		mapUseCases.put(10, "X");
		mapUseCases.put(11, "XI");
		mapUseCases.put(39, "XXXIX");
		mapUseCases.put(40, "XL");
		mapUseCases.put(41, "XLI");
		mapUseCases.put(50, "L");
		mapUseCases.put(51, "LI");
		mapUseCases.put(90, "XC");
		mapUseCases.put(99, "XCIX");
		mapUseCases.put(100, "C");
		mapUseCases.put(111, "CXI");
		mapUseCases.put(199, "CXCIX");
		mapUseCases.put(400, "CD");
		mapUseCases.put(494, "CDXCIV");
		mapUseCases.put(500, "D");
		mapUseCases.put(591, "DXCI");
		mapUseCases.put(900, "CM");
		mapUseCases.put(999, "CMXCIX");
		mapUseCases.put(1000, "M");
		mapUseCases.put(1234, "MCCXXXIV");
		mapUseCases.put(1434, "MCDXXXIV");
		mapUseCases.put(1539, "MDXXXIX");
		mapUseCases.put(1999, "MCMXCIX");
		mapUseCases.put(2000, "MM");
		mapUseCases.put(2001, "MMI");
		mapUseCases.put(3000, "MMM");
	}

	@Test
	public void test_roman_exception_zero() {
		exceptionExpected.expect(IllegalArgumentException.class);
		toRoman.convertToRoman(0);
	}

	@Test
	public void test_roman_exception_null() {
		exceptionExpected.expect(IllegalArgumentException.class);
		toRoman.convertToRoman(null);
	}

	@Test
	public void test_roman_exception_negative() {
		exceptionExpected.expect(IllegalArgumentException.class);
		toRoman.convertToRoman(-1);
	}

	@Test
	public void test_roman_positive_greater_than_3000() {
		exceptionExpected.expect(IllegalArgumentException.class);
		toRoman.convertToRoman(3001);
	}
	
	
	@Test
	public void test_number_to_roman_positive_less_or_equal_3000() {
		for(Entry<Integer, String> itemUseCase : mapUseCases.entrySet()) {
			collector.checkThat(String.format("number convertToRoman %d	= %s", itemUseCase.getKey(), itemUseCase.getValue()), toRoman.convertToRoman(itemUseCase.getKey()), is(itemUseCase.getValue()));	
		}
	}
	
	@Test
	public void test_number_to_roman_positive_1539() {
		collector.checkThat("number convertToRoman 1539	= MDXXXIXs", toRoman.convertToRoman(1539), is("MDXXXIX"));	
		
	}
	
	@Test
	public void test_roman_to_numbers_invalids() {
		List<String> paramsList = Arrays.asList(
				null,
				"",
				"CIIIIIIIIII", 
				"A", "B", "F", "G","Z");
		
		paramsList.forEach(param -> {
			try {
				toRoman.convertToNumber(param);
				Assert.fail(String.format("Test roman numeral \"%s\" don't fail.", param));
			}catch(Exception illegalEx) {
				Assert.assertEquals("Fail on test of invalid numbers.", IllegalArgumentException.class, illegalEx.getClass());
			}
		});
	}

	@Test
	public void test_roman_to_numbers_positive_less_or_equal_3000() {
		for(Entry<Integer, String> itemUseCase : mapUseCases.entrySet()) {
			collector.checkThat(String.format("roman convertToNumber %s = 	%d", itemUseCase.getValue(), itemUseCase.getKey()), toRoman.convertToNumber(itemUseCase.getValue()), is(itemUseCase.getKey()));	
		}
	}
	
}
