package fouri.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fouri.base.TestBase;

public class Survey_Creation_4 extends TestBase{
	
	public Survey_Creation_4() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[contains(text(),'Vanaesa')]") WebElement vanaesamenu;
	@FindBy(xpath="//span[contains(text(),'Reference Templates')]") WebElement ReferenceTemplates;
	@FindBy(xpath="//input[@placeholder=\"Search...\"]") WebElement searchbutton;
	@FindBy(xpath = "//div[contains(@class,'d-xl-inline-flex')]//button[contains(@class,'o_list_button_add')]") WebElement newbutton;
	
	//Survey locators
	@FindBy(xpath="//a[text()='Detailed Questions']") WebElement detailedquestions;
	@FindBy(id="title_0") WebElement title;
	@FindBy(id="version_0") WebElement version;
	@FindBy(xpath=".//div[@name='is_surgery_ques_enabled']//div[contains(@class, 'o-checkbox')]") WebElement surgerycheckbox;
	@FindBy(xpath="//div[contains(@class, 'o-checkbox')]//label[@for='is_medic_ques_enabled_0']") WebElement medicationcheckbox;
	@FindBy(xpath="//div[contains(@class, 'o-checkbox')]//label[@for='is_height_ques_enabled_0']") WebElement Heightcheckbox;
	@FindBy(xpath="//div[contains(@class, 'o-checkbox')]//label[@for='is_weight_ques_enabled_0']") WebElement Weightcheckbox;

	
	
	@FindBy(linkText="Add a question") WebElement Addaquestion;
	//question type X-path
	@FindBy(xpath="//label[normalize-space(text())='Single Line Text Box']") WebElement SingleLineTextBox;
	@FindBy(xpath="//label[normalize-space(text())='Numerical Value']") WebElement NumericalValue;
	@FindBy(xpath="//label[normalize-space(text())='Date']") WebElement Datequestion;
	@FindBy(xpath="//label[normalize-space(text())='Datetime']") WebElement DateTimequestion;
	@FindBy(xpath=".//label[normalize-space(text())='Multiple Lines Text Box']") WebElement multiplelinequestion;
	@FindBy(xpath="//label[normalize-space(text())='Matrix']") WebElement Matrixquestion;
	@FindBy(xpath="//label[normalize-space(text())='Multiple choice: only one answer']") WebElement Multioption;
	@FindBy(xpath="//label[normalize-space(text())='Multiple choice: multiple answers']") WebElement Multiselectionquestion;
	
	@FindBy(xpath=".//label[normalize-space(text())='Upload File']") WebElement uploadfilequestion;
	//question add line
	@FindBy(xpath="//a[normalize-space(text())='Add a line']") WebElement addlineinquestion;
	//adding options in questions
	@FindBy(xpath="//div[@name='value']/input") WebElement addoptions;
	@FindBy(xpath="(//div[@name='value']/input)[2]") WebElement addoptions2;
	//For matrix addline 1 & 2
	@FindBy(xpath="(//a[normalize-space(text()) = 'Add a line'])[1]") WebElement addlinematrix1;
	@FindBy(xpath="(//a[normalize-space(text()) = 'Add a line'])[2]") WebElement addlinematrix2;
	
	//save&close
	@FindBy(xpath=".//button[normalize-space(text())='Save & Close']") WebElement saveandclose;
	//finalize button
	@FindBy(xpath=".//span[normalize-space(text())='Finalise']") WebElement Finalisebutton;
	//question name
	@FindBy(xpath=".//input[contains(@placeholder, 'What is the')]") WebElement questionname;
	//input[contains(@placeholder, 'What is the')]
	
	
	
	
	
	
	
	
	public void test() throws InterruptedException {
		
		Thread.sleep(30000);
//		vanaesamenu.click();
		ReferenceTemplates.click();
		
		
		//get_today_date
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
        
        Thread.sleep(3000);
        searchbutton.click();
        searchbutton.sendKeys("Medication Survey " + formattedDate);
        searchbutton.sendKeys(Keys.ENTER);
        
        //Store the survey name
        String Surveyname = "Medication Survey " + formattedDate;
        boolean nameFound = false;
        
        List<WebElement> items = driver.findElements(By.xpath("//tbody[@class='ui-sortable']"));
        for (WebElement item : items) {
            // Get the text (or a child element’s text) from the item
            String nameText = item.getText();

            if (nameText.contains(Surveyname)) {
                nameFound = true;
                System.out.println("Name found and Moved to next page");
                break;
            }
        }

        if (!nameFound) {
            System.out.println("Name not found. Continuing flow...");
        
        newbutton.click();
        title.clear();
        title.sendKeys("Medication Survey " + formattedDate);
        //version
        version.click();
        version.clear();
        version.sendKeys("1");
        
        //check box enable
        surgerycheckbox.click();
        medicationcheckbox.click();
        Heightcheckbox.click();
        Weightcheckbox.click();
        Thread.sleep(3000);
        detailedquestions.click();
        Thread.sleep(3000);
        //add questions
        Addaquestion.click();
        //Single line questions
        questionname.clear();
        questionname.sendKeys("Name");
        SingleLineTextBox.click();
        saveandclose.click();
        Thread.sleep(3000);
        //multiple line questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Remarks");
        multiplelinequestion.click();
        saveandclose.click();
        Thread.sleep(3000);
        //Numeric questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Age");
        NumericalValue.click();
        saveandclose.click();
        Thread.sleep(3000);
        //Date questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("DOB");
        Datequestion.click();
        saveandclose.click();
        Thread.sleep(3000);
        //Date time questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Medication Using Since");
        DateTimequestion.click();
        saveandclose.click();
        Thread.sleep(3000);
        //Matrix Questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Health issue - matrix");
        Matrixquestion.click();
        //Choices selection
        addlinematrix1.click();
        addoptions.click();
        addoptions.sendKeys("Yes");
        addlinematrix1.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("NO");
        addlinematrix1.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("N/A");
        Thread.sleep(2000);
        //row selection
        addlinematrix2.click();
        Thread.sleep(2000);
        addoptions2.click();
        addoptions.sendKeys("Sugar");
        addlinematrix2.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("acidity");
        addlinematrix2.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("Ulcer");
        saveandclose.click();
        //Upload Questions
        Thread.sleep(3000);
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Medical Report");
        uploadfilequestion.click();
        saveandclose.click();
        Thread.sleep(3000);
        //Multi-option single selection Questions
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Choose Options");
        Multioption.click();
        //to select options
        addlineinquestion.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("Yes");
        addlineinquestion.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("No");
        saveandclose.click();
        //Multi-option Multiple selection selection Questions
        Thread.sleep(3000);
        Addaquestion.click();
        questionname.clear();
        questionname.sendKeys("Choose Options");
        Multiselectionquestion.click();
        //to select options
        addlineinquestion.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("Yes");
        addlineinquestion.click();
        Thread.sleep(2000);
        addoptions.click();
        addoptions.sendKeys("No");
        saveandclose.click();
        //Finalize the survey.
        Thread.sleep(3000);
        Finalisebutton.click();
        
        
	    
        }
}
}
