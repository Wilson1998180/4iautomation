package fouri.pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fouri.base.TestBase;

public class Patient_survey_5 extends TestBase{
	
	public Patient_survey_5() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@data-question-type=\"char_box\"]") WebElement Namequesion;
	@FindBy(xpath = "//input[@data-question-type='numerical_box']") WebElement Numerictype;
	@FindBy(xpath = "//textarea[@data-question-type='text_box']") WebElement multilinetype;
	@FindBy(xpath = "//input[@data-question-type='date']") WebElement datetype;
	@FindBy(xpath = "//input[@data-question-type='datetime']") WebElement datetimetype;
	@FindBy(xpath = "(//i[@class=\"o_survey_matrix_empty_checkbox fa fa-circle-thin position-relative\"])[1]") WebElement firstmatrix;
	@FindBy(xpath = "(//i[@class=\"o_survey_matrix_empty_checkbox fa fa-circle-thin position-relative\"])[5]") WebElement secondmatrix;
	@FindBy(xpath = "(//i[@class=\"o_survey_matrix_empty_checkbox fa fa-circle-thin position-relative\"])[9]") WebElement thirdmatrix;
	@FindBy(xpath = "(//i[@class='fa fa-circle-thin float-end mt-1 ms-1 position-relative'])[1]") WebElement Firstoption;
	@FindBy(xpath = "(//i[@class='fa fa-square-o float-end mt-1 ms-1 position-relative'])[1]") WebElement Firstcheckbox;
	@FindBy(xpath = "(//i[@class='fa fa-square-o float-end mt-1 ms-1 position-relative'])[2]") WebElement secondcheckbox;
	@FindBy(xpath="//button[text()[normalize-space()='Continue']]") WebElement Continuebutton;
	@FindBy(xpath="(//i[@class='fa fa-check-circle float-end mt-1 ms-1 position-relative'])[1]") WebElement SurgeryquestionYes;
	@FindBy(xpath="//button[text()[normalize-space()='Submit']]") WebElement Submit;
	@FindBy(id="confirm_survey") WebElement FinalSubmit;
	
	
	public void test() throws InterruptedException {
		
		//Height
		Thread.sleep(6000);
		Numerictype.click();
		Numerictype.sendKeys("1.8");
		Continuebutton.click();
		Thread.sleep(6000);
		//Weight
		Numerictype.click();
		Numerictype.sendKeys("85");
		Continuebutton.click();
		Thread.sleep(3000);
		//Name
		Namequesion.click();
		Namequesion.sendKeys("Richard");
		Continuebutton.click();
		Thread.sleep(3000);
		//Remarks
		multilinetype.click();
		multilinetype.sendKeys("I experience an allergy when I eat food made with wheat.");
		Continuebutton.click();
		Thread.sleep(3000);
		//Age
		Numerictype.click();
		Numerictype.sendKeys("27");
		Continuebutton.click();
		Thread.sleep(3000);
		//DOB
		datetype.click();
		datetype.sendKeys("02/06/1998");
		Continuebutton.click();
		Thread.sleep(3000);
		//Medication Using Since
		datetimetype.click();
		datetimetype.sendKeys("13/06/2015 10:05:05");
		datetimetype.sendKeys(Keys.ENTER);
		//Continuebutton.click();
		Thread.sleep(3000);
		//Matrix
		firstmatrix.click();
		secondmatrix.click();
		thirdmatrix.click();
		Continuebutton.click();
		Thread.sleep(3000);
		//file upload
		String relativepath = "src/test/resources/623b2d2ad2f8d82850218e628598eeed.jpg";
		File file = new File(relativepath);
		String absolutePath = file.getAbsolutePath();
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and @name='attachments[]']"));
		fileInput.sendKeys(absolutePath);
		
		Thread.sleep(6000);
		Continuebutton.click();
		Thread.sleep(3000);
		//Choose options
		Firstoption.click();
		Continuebutton.click();
		Thread.sleep(3000);
		//Choose options multiple
		Firstcheckbox.click();
		secondcheckbox.click();
		Thread.sleep(5000);
		
		//surgery questions
		SurgeryquestionYes.click();
		Continuebutton.click();
		Thread.sleep(6000);
		Namequesion.click();
		Namequesion.sendKeys("2025");
		Continuebutton.click();
		Thread.sleep(3000);
		Namequesion.click();
		Namequesion.sendKeys("KG Hospital");
		Continuebutton.click();
		Thread.sleep(3000);
		Namequesion.click();
		Namequesion.sendKeys("Heart");
		Continuebutton.click();
		Thread.sleep(6000);
		SurgeryquestionYes.click();
		Continuebutton.click();
		Namequesion.click();
		Thread.sleep(6000);
		Namequesion.sendKeys("diclofenac Sodium");
		Namequesion.sendKeys(Keys.ENTER);
		Namequesion.click();
		Thread.sleep(6000);
		Namequesion.sendKeys("15");
		Continuebutton.click();
		Thread.sleep(6000);
		Namequesion.click();
		Namequesion.sendKeys("2024");
		Submit.click();
		Thread.sleep(6000);
		FinalSubmit.click();
		Thread.sleep(3000);
		Submit.click();
	}
	
	
}
