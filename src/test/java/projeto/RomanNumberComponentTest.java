package projeto;

import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

public class RomanNumberComponentTest {

	private RomanNumberComponent toRoman;
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Rule
	public ExpectedException exceptionExpected = ExpectedException.none();
	

	@Before
	public void init() {
		toRoman = new RomanNumberComponent();
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
	public void test_roman_positive_less_or_equal_3000() {
		collector.checkThat("number 1		= I"	    , toRoman.convertToRoman(1)	 , is("I" ));
		collector.checkThat("number 4 		= IV"	    , toRoman.convertToRoman(4)	 , is("IV" ));
		collector.checkThat("number 5 		= V"	    , toRoman.convertToRoman(5)	 , is("V" ));
		collector.checkThat("number 9 		= IX"	    , toRoman.convertToRoman(9)	 , is("IX" ));
		collector.checkThat("number 10 		= X"	    , toRoman.convertToRoman(10)	 , is("X" ));
		collector.checkThat("number 11 		= XI"	    , toRoman.convertToRoman(11)	 , is("XI" ));
		collector.checkThat("number 39 		= XXXIX"    , toRoman.convertToRoman(39)	 , is("XXXIX" ));
		collector.checkThat("number 40 		= XL"	    , toRoman.convertToRoman(40)	 , is("XL" ));
		collector.checkThat("number 41 		= XLI"	    , toRoman.convertToRoman(41)	 , is("XLI" ));
		collector.checkThat("number 50 		= L"	    , toRoman.convertToRoman(50)	 , is("L" ));
		collector.checkThat("number 51 		= LI"	    , toRoman.convertToRoman(51)	 , is("LI" ));
		collector.checkThat("number 90 		= XC"	    , toRoman.convertToRoman(90)	 , is("XC" ));
		collector.checkThat("number 99 		= XCIX"	    , toRoman.convertToRoman(99)	 , is("XCIX" ));
		collector.checkThat("number 100 	= C"	    , toRoman.convertToRoman(100)	 , is("C" ));
		collector.checkThat("number 111 	= CXI"	    , toRoman.convertToRoman(111)	 , is("CXI" ));
		collector.checkThat("number 199 	= CXCIX"    , toRoman.convertToRoman(199)	 , is("CXCIX" ));
		collector.checkThat("number 400 	= CD"	    , toRoman.convertToRoman(400)	 , is("CD" ));
		collector.checkThat("number 494 	= CDXCIV"	, toRoman.convertToRoman(494)	 , is("CDXCIV" ));
		collector.checkThat("number 500 	= D"	    , toRoman.convertToRoman(500)	 , is("D" ));
		collector.checkThat("number 591 	= DXCI"	    , toRoman.convertToRoman(591)	 , is("DXCI" ));
		collector.checkThat("number 900 	= CM"	    , toRoman.convertToRoman(900)	 , is("CM" ));
		collector.checkThat("number 999 	= CMXCIX"	, toRoman.convertToRoman(999)	 , is("CMXCIX" ));
		collector.checkThat("number 1000 	= M"	    , toRoman.convertToRoman(1000)	 , is("M" ));
		collector.checkThat("number 1234 	= MCCXXXIV"	, toRoman.convertToRoman(1234)	 , is("MCCXXXIV" ));
		collector.checkThat("number 1434 	= MCDXXXIV"	, toRoman.convertToRoman(1434)	 , is("MCDXXXIV" ));
		collector.checkThat("number 1539 	= MDXXXIX"	, toRoman.convertToRoman(1539)	 , is("MDXXXIX" ));
		collector.checkThat("number 1999 	= MCMXCIX"	, toRoman.convertToRoman(1999)	 , is("MCMXCIX" ));
		collector.checkThat("number 2000 	= MM"	    , toRoman.convertToRoman(2000)	 , is("MM" ));
		collector.checkThat("number 2001 	= MMI"	    , toRoman.convertToRoman(2001)	 , is("MMI" ));
		collector.checkThat("number 3000 	= MMM"	    , toRoman.convertToRoman(3000)	 , is("MMM" ));
	}
	
	@Test
	public void test_roman_to_numbers_invalids() {
		exceptionExpected.expect(IllegalArgumentException.class);
		//110 expression wrong
		toRoman.convertToNumber("CIIIIIIIIII");
	}
	
	@Test
	public void test_numbers_positive_less_or_equal_3000() {
		collector.checkThat("number I		= 1"	    , toRoman.convertToNumber("I")	, is(1));
		collector.checkThat("number IV 		= 4"     	, toRoman.convertToNumber("IV")	, is(4 ));
		collector.checkThat("number V 		= 5"    	, toRoman.convertToNumber("V")	, is(5 ));
		collector.checkThat("number IX 		= 9"     	, toRoman.convertToNumber("IX")	, is(9 ));
		collector.checkThat("number X 		= 10"    	, toRoman.convertToNumber("X")	, is(10 ));
		collector.checkThat("number XI 		= 11"	    , toRoman.convertToNumber("XI")	, is(11 ));
		collector.checkThat("number CX 		= 110"	    , toRoman.convertToNumber("CX")	, is(110 ));
	}
	
}
