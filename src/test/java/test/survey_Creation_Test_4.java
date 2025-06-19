package test;

import org.testng.annotations.Test;

import fouri.base.TestBase;
import fouri.pages.Survey_Creation_4;

public class survey_Creation_Test_4 extends TestBase{
	
	Survey_Creation_4 S4;
	
	@Test
	public void T1() throws InterruptedException {
		S4=new Survey_Creation_4();
		S4.test();
	}
}
