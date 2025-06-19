package test;

import org.testng.annotations.Test;

import fouri.base.TestBase;
import fouri.pages.Patient_survey_5;

public class Patient_survey_test_5 extends TestBase{
	
	Patient_survey_5 PS5;

	@Test
	public void T1() throws InterruptedException {
		PS5=new Patient_survey_5();
		PS5.test();
	}
	
}
