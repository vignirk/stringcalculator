package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    	public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
    	public void testNewLine(){
        assertEquals(6, Calculator.add("1\n2,3"));
    	}

	 @Test
        public void testNewLine2(){
        assertEquals(12, Calculator.add("1\n2,3,4\n2"));
        }

	@Test
        public void testDifferentDelimiter(){
        assertEquals(8, Calculator.add("//;\n1;2;2;3"));
	}

	@Test
        public void testDifferentDelimiter2(){
        assertEquals(5, Calculator.add("//*\n1*2*2"));
        }

        @Test
        public void testLowerThanThousund(){
        assertEquals(1003, Calculator.add("1001,2,2,999,2014"));
        }

	@Test
        public void testLowerThanThousund2(){
        assertEquals(0, Calculator.add("0,2014"));
        }
	
	@Test
        public void testDelimitersOfAnyLength(){
        assertEquals(6, Calculator.add("//[***]\n1***2***3"));
        }

	@Test
        public void testMultipleDelimiters(){
        assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
        }

	@Test
        public void testMultipleDelimitersOfAnyLength(){
        assertEquals(7, Calculator.add("//[**][%%%]\n1**2%%%3**1"));
        }

	@Test(expected = IllegalArgumentException.class)
        public void testInsertNegativeNumbers(){
        Calculator.add("-1,-2,0,-3");
        }


	@Test(expected = IllegalArgumentException.class)
        public void testInsertNegativeNumbers2(){
        Calculator.add("//[**][%%%]\n1**2%%%-3**1");
   	}
}
