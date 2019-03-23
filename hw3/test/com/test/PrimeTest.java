package com.test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import com.prime.Prime;
public class PrimeTest {
	ByteArrayOutputStream str;
	
	@Before
    public void setUp() throws Exception {
        str = new ByteArrayOutputStream();
        System.setOut(new PrintStream(str));
    }
	
	@Test
	public void testPrime() {
		String outcome = new String("Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n");
        Prime.printPrimes(3);
        assertEquals(outcome, str.toString()); 
	}
}
