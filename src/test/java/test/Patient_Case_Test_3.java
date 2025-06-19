package test;

import org.testng.annotations.Test;

import fouri.base.TestBase;
import fouri.pages.Patient_Case_3;

public class Patient_Case_Test_3 extends TestBase{
	
	Patient_Case_3 P3;

	@Test
	public void T1() throws InterruptedException {
		P3=new Patient_Case_3();
		P3.test();
	}
	
}
