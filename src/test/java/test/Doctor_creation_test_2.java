package test;

import org.testng.annotations.Test;

import fouri.base.TestBase;
import fouri.pages.Doctor_creation_2;

public class Doctor_creation_test_2 extends TestBase{
	
Doctor_creation_2 D2;
	
	@Test
	public void T1() throws InterruptedException {
		D2=new Doctor_creation_2();
		D2.test();
	}
}
