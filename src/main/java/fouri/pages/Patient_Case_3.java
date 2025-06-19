package fouri.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fouri.base.TestBase;

public class Patient_Case_3 extends TestBase{
	public Patient_Case_3() {
		PageFactory.initElements(driver,this);
	}
	
	private String sharedMobileNumber;
	
	@FindBy(xpath = "//div[contains(@class,'d-xl-inline-flex')]//button[contains(@class,'o_list_button_add')]") WebElement newbutton;
	@FindBy(id = "patient_first_name_0") WebElement Patientfirstname;
	@FindBy(id = "patient_last_name_0") WebElement patientlastname;
	@FindBy(id = "patient_phone_code_0") WebElement patientphonecode;
	@FindBy(id = "patient_mob_0") WebElement patientphone;
	@FindBy(id = "patient_nric_number_0") WebElement patientnirc;
	@FindBy(id = "patient_gender_0") WebElement genderselection;
	@FindBy(id = "patient_dob_0") WebElement patientdob;
	@FindBy(id = "op_process_0") WebElement opprocess;
	@FindBy(id = "op_process_detail_0") WebElement opprocessdetail;
	@FindBy(id = "op_date_0") WebElement opdate;
	@FindBy(id = "op_duration_hrs_0") WebElement duration;
	@FindBy(id = "op_location_id_0") WebElement oplocation;
	@FindBy(id = "op_surgeon_0") WebElement opsurgeon;
	@FindBy(id = "medic_survey_id_0") WebElement survey;
	@FindBy(xpath="//span[contains(text(),'Vanaesa')]") WebElement vanaesamenu;
	@FindBy(xpath="//span[contains(text(),'Bookings')]") WebElement bookings;
	@FindBy(xpath="//span[contains(text(),'Reference Templates')]") WebElement ReferenceTemplates;
	@FindBy(xpath=".//input[@placeholder='Search...']") WebElement searchbutton;
	@FindBy(xpath="(//tr[contains(@class, 'o_data_row')])[1]/td[@name='title']") WebElement mytemplateselection;
	@FindBy(id="version_0") WebElement version;
	@FindBy(xpath="//span[contains(text(),'Initiate Collection')]") WebElement initiatecollection;
	
	//finalize button
	@FindBy(xpath="//span[normalize-space(text())='Finalise']") WebElement Finalisebutton;
	//use template
	@FindBy(xpath="//tr[1]//span[contains(text(),\"Use this Template\")]") WebElement usetemplate;
	
	@FindBy(xpath=".//span[contains(text(),'All Patients')]") WebElement patient;
	@FindBy(xpath="//td[@class='o_list_record_selector user-select-none']//label") WebElement firstpatient;
	
	//Adminlogin
	@FindBy(xpath="//*[@id=\"country_selector\"]") WebElement countrycode;
	@FindBy(xpath="//*[@id=\"mobile_number\"]") WebElement Mobile;
	@FindBy(xpath="//button[text()='Sign in']") WebElement signin;
	@FindBy(xpath="//input[@placeholder=\"Search...\"]") WebElement patientsearch;
	
	@FindBy(xpath="//div[contains(@class, 'o-dropdown')]//button[.//i[contains(@class, 'fa-cog')]]") WebElement settings;
	@FindBy(xpath="//span[text()='Delete']") WebElement Delete;
	@FindBy(xpath="//footer[contains(@class, 'modal-footer')]//button[text()='Delete']") WebElement Delete1;
	@FindBy(xpath="//footer[contains(@class, 'modal-footer')]//button[text()='Go to users']") WebElement Gotouser;
	@FindBy(xpath="//a[text()='Preferences']") WebElement prefernece;
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Is Specific Login'])[1]/following::label[1]") WebElement checkbox;
	@FindBy(xpath="//a[@class='dropdown-item' and span[text()='SMS Logs']]") WebElement SMSlogs;
	@FindBy(xpath="//tr[@class='o_data_row'][1]//td[@name='partner_id']") WebElement SMSclick;
	@FindBy(xpath="//div[@name='body']//span[1]") WebElement linkText;
	@FindBy(xpath="//li[@id=\"4\"]") WebElement mobileoptioninderopdown;
	
	@FindBy(xpath="//img[@alt=\"User\"]") WebElement Clickuser;
	@FindBy(xpath=".//a[text()='Log out']") WebElement Logout;
	
	@FindBy(id="dob") WebElement DOB;
	@FindBy(xpath="//button[contains(text(), \"Start Questionnaire\")]") WebElement startsurvey;
	
	
	
	
	public void test() throws InterruptedException {
		
		Thread.sleep(10000);
		//Survey available check
//		vanaesamenu.click();
	    ReferenceTemplates.click();
	    Thread.sleep(5000);

	    LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = today.format(formatter);
	    

	    searchbutton.click();
	    searchbutton.clear();
	    
	    searchbutton.sendKeys("Medication Survey " + formattedDate);
        searchbutton.sendKeys(Keys.ENTER);
        
        System.out.println("survey searched");
        
	    String Surveyname = "Medication Survey " + formattedDate;
	    boolean nameFound = false;
	   

	    List<WebElement> items = driver.findElements(By.xpath("//tbody[@class='ui-sortable']"));
        for (WebElement item : items) {
            // Get the text (or a child element’s text) from the item
            String nameText = item.getText();
            System.out.println("name text name: " + nameText);

	        if (nameText.contains(Surveyname)) {
	            nameFound = true;
	            
	            System.out.println("Survey found: " + nameText);
	            
	            Thread.sleep(3000);
	            
	            usetemplate.click();
	            System.out.println("templateclicked");
	            
//		        vanaesamenu.click();
		        Thread.sleep(5000);
		        
		        mytemplateselection.click();
		        
		        Thread.sleep(3000);
		        version.sendKeys("1");
		        Thread.sleep(3000);
		        Finalisebutton.click();
		        Thread.sleep(3000);
		        bookings.click();
		        newbutton.click();

		        Patientfirstname.click();
		        Patientfirstname.clear();
		        Patientfirstname.sendKeys("Richard");

		        patientlastname.click();
		        patientlastname.clear();
		        patientlastname.sendKeys("John");
		        
		        sharedMobileNumber = generateRandom10DigitNumber();
		        
		        patientphonecode.click();
		        patientphonecode.sendKeys("+91");
		        driver.findElement(By.xpath("//a[text()='+91']")).click();

		        patientphone.click();
		        patientphone.clear();
		        patientphone.sendKeys(sharedMobileNumber);
		        
		        

		        patientnirc.click();
		        patientnirc.clear();
		        patientnirc.sendKeys("ASD1235432");

		        new Select(genderselection).selectByVisibleText("Male");

		        patientdob.click();
		        patientdob.sendKeys("02/06/1998");
//		        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sat'])[1]/following::span[26]")).click();

		        opprocess.click();
		        opprocess.clear();
		        opprocess.sendKeys("General Surgery");

		        opprocessdetail.click();
		        opprocessdetail.clear();
		        opprocessdetail.sendKeys("Normal Open Surgery");

		        
		        LocalDate tomorrow = LocalDate.now().plusDays(1);
		        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        String formattedTomorrow = tomorrow.format(dateFormatter);
		        
		        Thread.sleep(3000);
		        opdate.click();
		        opdate.sendKeys(formattedTomorrow + " 18:00:00");
		        Thread.sleep(3000);
//		        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sat'])[1]/following::span[27]")).click();

		        duration.click();
		        duration.clear();
		        duration.sendKeys("2");

		        oplocation.click();
		        driver.findElement(By.id("op_location_id_0_0_0")).click();

		        opsurgeon.click();
		        opsurgeon.clear();
		        opsurgeon.sendKeys("Dr Ken");
		        
		        survey.click();
		        Thread.sleep(3000);        
		        survey.sendKeys(Keys.ENTER);
		        Thread.sleep(3000);
		        initiatecollection.click();	
		        Thread.sleep(6000);		        
		        
	            System.out.println("mobilenumber is " + sharedMobileNumber);
		        Thread.sleep(3000);
		        
		        //Admin login
		        
		        driver.get(prop.getProperty("URL"));
		        Mobile.sendKeys(prop.getProperty("USERNAME"));
				signin.click();
				Thread.sleep(25000);
				
//				vanaesamenu.click();
				patient.click();
				Thread.sleep(3000);
				patientsearch.click();
				
				patientsearch.sendKeys(sharedMobileNumber);
				Thread.sleep(3000);
				
				patientsearch.sendKeys(Keys.ARROW_DOWN);
				patientsearch.sendKeys(Keys.ARROW_DOWN);
				patientsearch.sendKeys(Keys.ARROW_DOWN);
				patientsearch.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				
				firstpatient.click();
				Thread.sleep(6000);
				
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
			    
			    Thread.sleep(3000);  
			    Clickuser.click();
			    Thread.sleep(3000);
			    Logout.click();
			    Thread.sleep(6000);   
			    driver.get(url1);
			    Thread.sleep(3000);
			    DOB.click();
			    DOB.sendKeys("02");
			    Thread.sleep(2000);
			    DOB.sendKeys("06");
			    Thread.sleep(2000);
			    DOB.sendKeys("1998");
			    Thread.sleep(2000);
//			    DOB.click();
//			    Thread.sleep(3000);
//			    DOB.sendKeys(Keys.ENTER);
			    
			    
			    signin.click();
			    Thread.sleep(6000);
			    driver.get(url1);
			    Thread.sleep(6000);
			    startsurvey.click();
			    
			    }
				
				
		        
		        
		        
	            break;
	        }
	    }

        if (!nameFound) {
        	
	        System.out.println("Survey not found");
	        throw new RuntimeException("Survey '" + Surveyname + "' not found. Stopping test.");
	    }
	}
	
	public static String generateRandom10DigitNumber() {
        Random random = new Random();
        long number = 1000000000L + (long)(random.nextDouble() * 8999999999L);
        return String.valueOf(number);
}
}