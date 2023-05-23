package com.drf.qa.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class TestBase {


    public static WebDriver driver;
    public static Properties prop;

    public TestBase()
    {
        try {
            prop=new Properties();
            FileInputStream ip= new FileInputStream("src/main/java/com/drf/qa/config/config.properties");
            prop.load(ip);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {

        String browserName = prop.getProperty("browser"); //use WebDriver Manager
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        //opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        //opt.addArguments("--remote-allow-origins=*");
        if(browserName.equals("chrome"))
        {
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\webonise\\ChromeDriver\\chromedriver.exe");
            driver = new ChromeDriver(options);
            //driver = new ChromeDriver();
        }//write else if for FF browser

        else if(browserName.equals("Firefox"))
        {

           // System.setProperty("webdriver.gecko.driver", "C:\\Users\\webonise\\Selenium Standalone\\geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(prop.getProperty("URL")); //URL //stageURL
    }


    public void failed(String testMethodName)
    {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileHandler.copy(scrFile,new File("Screenshot/"+testMethodName+"_"+".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void tearDown(){
        driver.close();
    }


}
