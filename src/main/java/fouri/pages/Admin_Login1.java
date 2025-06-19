package fouri.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fouri.base.TestBase;

public class Admin_Login1 extends TestBase{
	
	
	public Admin_Login1() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//*[@id=\"country_selector\"]") WebElement countrycode;
	@FindBy(xpath="//*[@id=\"mobile_number\"]") WebElement Mobile;
	@FindBy(xpath="//button[text()='Sign in']") WebElement signin;



	public void test() throws InterruptedException {
		Mobile.sendKeys(prop.getProperty("USERNAME"));
		signin.click();
		Thread.sleep(3000);
	}

}
