package test;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fouri.base.TestBase;
import fouri.pages.Admin_Login1;


public class Admin_login_test extends TestBase{
	
Admin_Login1 al;

@BeforeMethod
public void setup() {
	initialisation();
	al=new Admin_Login1();
	
}




	@Test
	public void T1() throws InterruptedException {
		al.test();

}
}