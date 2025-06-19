package fouri.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fouri.base.TestBase;

public class Doctor_creation_2 extends TestBase{
	public Doctor_creation_2() {
		PageFactory.initElements(driver,this);
	}
	
	private String sharedMobileNumber;
	
	@FindBy(xpath="//span[contains(text(),'Vanaesa')]") WebElement vanaesamenu;
	@FindBy(xpath="//span[contains(text(),'All Doctors')]") WebElement doctormenu;
	@FindBy(xpath="//input[@placeholder=\"Search...\"]") WebElement Doctorsearch;
	@FindBy(xpath = "//div[contains(@class,'d-xl-inline-flex')]//button[contains(@class,'o_list_button_add')]") WebElement newbutton;
	@FindBy(id = "name_2") WebElement firstname;
	@FindBy(id = "last_name_0") WebElement lastname;
	@FindBy(xpath = "//button[@name='create_verified_user']") WebElement initiateverification;
	@FindBy(xpath="//a[@class='dropdown-item' and span[text()='SMS Logs']]") WebElement SMSlogs;
	@FindBy(xpath="//tr[@class='o_data_row'][1]//td[@name='partner_id']") WebElement SMSclick;
	@FindBy(xpath="//div[@name='body']//span[1]") WebElement linkText;
	@FindBy(xpath="//div[contains(@class, 'o-dropdown')]//button[.//i[contains(@class, 'fa-cog')]]") WebElement settings;
	@FindBy(xpath="//span[text()='Delete']") WebElement Delete;
	@FindBy(xpath="//footer[contains(@class, 'modal-footer')]//button[text()='Delete']") WebElement Delete1;
	@FindBy(xpath="//footer[contains(@class, 'modal-footer')]//button[text()='Go to users']") WebElement Gotouser;
	@FindBy(xpath="//a[text()='Preferences']") WebElement prefernece;
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Is Specific Login'])[1]/following::label[1]") WebElement checkbox;
	@FindBy(xpath="//button[text()='Sign in']") WebElement signin;
	@FindBy(xpath="//td[@class='o_list_record_selector user-select-none']//label") WebElement selectinlist;
	
	
	
		public void test() throws InterruptedException {
			Thread.sleep(20000);
//			vanaesamenu.click();
//			Thread.sleep(3000);
			doctormenu.click();
			Thread.sleep(3000);
			newbutton.click();
			Thread.sleep(3000);
			firstname.click();
		    firstname.clear();
		    firstname.sendKeys("Adam");
		    lastname.click();
		    lastname.clear();
		    lastname.sendKeys("Kim");
		    //for_phone_code
		    driver.findElement(By.id("phone_code_0")).click();
		    driver.findElement(By.id("phone_code_0")).sendKeys("+91");
		    driver.findElement(By.xpath("//a[text()='+91']")).click();
		    
		    Thread.sleep(3000);
		    //for_mobile_number
		    driver.findElement(By.id("mob_0")).click();
		    driver.findElement(By.id("mob_0")).clear();
		    //To_give_randomnumber
		    sharedMobileNumber = generateRandom10DigitNumber();
		    driver.findElement(By.id("mob_0")).sendKeys(sharedMobileNumber);
		    //Next_process
		    driver.findElement(By.id("dob_1")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sat'])[1]/following::span[25]")).click();
		    //gender_choose
		    driver.findElement(By.id("gender_0")).click();
		    new Select(driver.findElement(By.id("gender_0"))).selectByVisibleText("Male");
		    //save
		    driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		    //verification
		    initiateverification.click();
		    //to_activate_special_login
		    Thread.sleep(6000);
		    doctormenu.click();
		    Doctorsearch.click();
		    Doctorsearch.sendKeys(sharedMobileNumber);
		    Thread.sleep(3000);
		    Doctorsearch.sendKeys(Keys.ARROW_DOWN);
		    Doctorsearch.sendKeys(Keys.ARROW_DOWN);
		    Doctorsearch.sendKeys(Keys.ARROW_DOWN);
		    Doctorsearch.sendKeys(Keys.ENTER);
		    Thread.sleep(3000);
		    selectinlist.click();
		    Thread.sleep(3000);
		    settings.click();
		    Thread.sleep(3000);
		    Delete.click();
		    Thread.sleep(3000);
		    Delete1.click();
		    Thread.sleep(3000);
		    Gotouser.click();
		    Thread.sleep(3000);
		    prefernece.click();
		    Thread.sleep(3000);
		    checkbox.click();
		    //SMSLinkCapturing
		    SMSlogs.click();
		    Thread.sleep(3000);
		    SMSclick.click();
		    Thread.sleep(3000);
		    //text_capture_from_SMS
		    String url = linkText.getText();
		    System.out.println("Captured URL: " + url);   
	        // Extracting the URL using regular expression
		    int start = url.indexOf("http");
		    if (start != -1) {
		        String url1 = url.substring(start).split(" ")[0]; // Stop at first space
		        System.out.println("Captured URL: " + url1);   
		    driver.get(url1);
		    Thread.sleep(3000);
		    signin.click();
		    Thread.sleep(6000);
		    }
		    }	
		//for_genarating_random_number
		 public static String generateRandom10DigitNumber() {
		        Random random = new Random();
		        long number = 1000000000L + (long)(random.nextDouble() * 8999999999L);
		        return String.valueOf(number);	
	}
}