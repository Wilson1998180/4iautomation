package fouri.base;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 // Deprecated in Selenium 4
import org.openqa.selenium.support.events.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;
//import pg.commonutility.Activitycapture;  // Make sure Activitycapture implements WebDriverListener

public class TestBase {

    public static Properties prop = new Properties();
    public static WebDriver driver;

    static {
        try (InputStream input = TestBase.class.getClassLoader()
                .getResourceAsStream("fouri/config/appconfig.properties")) {
            if (input == null) {
                throw new RuntimeException("Cannot find appconfig.properties in classpath");
            }
            prop.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }

    public static void initialisation() {
    	String browser=prop.getProperty("BROWSER");
        boolean isHeadless = Boolean.parseBoolean(prop.getProperty("HEADLESS", "false"));

        // Choose the browser
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

//        // Using EventFiringWebDriver (deprecated but still usable)
//        Activitycapture listener = new Activitycapture();  // Your listener implementation
//
//        // Register listener to EventFiringWebDriver
//        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
//        eventFiringWebDriver.register(listener);  // Register the listener
//
//        // Replace driver with the EventFiringWebDriver
//        driver = eventFiringWebDriver;

        // Basic configurations
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("URL"));
    }
}
