package triangletest;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.Test;

import triangle.triangle;

public class test {
	public triangle tri = new triangle();
	

	@Test
	public void testnumber() {
		assertEquals(false,tri.judgement2(-1));
		assertEquals(false,tri.judgement2(84));
		assertEquals(true,tri.judgement2(83));
		assertEquals(false,tri.judgement2(40));
		assertEquals(true,tri.judgement2(30));
	}

}
