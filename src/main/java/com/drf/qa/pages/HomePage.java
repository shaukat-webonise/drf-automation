package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import com.drf.qa.util.Utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class HomePage extends TestBase {

    @FindBy(xpath = "//a[@class='logInBtn']")
    WebElement loginLink;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailID;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//button[@class='actionBtn false false']")
    WebElement loginButton;
    @FindBy(xpath = "//button[@class='createAccountBtn btnRed btn']")
    WebElement registerButton;
    @FindBy(xpath = "//*[@class='drfNavUserProfileWrap']")
    WebElement userProfileWrap;
    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logout;

    @FindBy(xpath = "//div[@id='adOverlay']/div")
    WebElement overlay;
    @FindBy(xpath = "//div[@id='adOverlayClose']")
    WebElement overlayCross;
    @FindBy(xpath = "//div[@class='leftNavFixed']/ul/li[1]")
    WebElement selectedWagering;
    @FindBy(xpath = "//div[@class='leftNavFixed']/ul/li[2]")
    WebElement selectedPP;
    @FindBy(xpath = "//span[@class='dateNo']")
    WebElement selectOneDate;
    @FindBy(xpath = "//div[@class='DRFLogo'] | //*[@id='mainNav']/a[1]")
    WebElement drfHomePageLogo;

    @FindBy(xpath = "//*[@class='DRFLogo loginState']")
    WebElement loginStateDRFLogo;
    @FindBy(xpath = "//ul[@class='drfNavMainNavigation']//*[text()= 'Bet Now']")
    WebElement drfBetsLink;
    @FindBy(xpath = "//*[@class='drfNavSubHeader']")
    WebElement drfBetsSubheaderText;

    // handicapping and News& Info xpath Link in Handicapping class
    @FindBy(xpath = "//ul[@class='drfNavMainNavigation']//*[text()= 'Preakness']")
    WebElement preaknessLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement preaknessSubheaderText;
    @FindBy(xpath = "//div[@id='mainNav']//*[text()= 'Shop']")
    WebElement shopLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement shopSubheaderText;
    @FindBy(xpath = "//div[@id='mainMenu']//*[text()= 'Entries']")
    WebElement entriesLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement entriesSubheaderText;
    @FindBy(xpath = "//div[@id='mainNav']//*[text()= 'Results']")
    WebElement resultsLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement resultsSubheaderText;
    @FindBy(xpath = "//div[@id='mainNav']//*[text()= 'Breeding']")
    WebElement breedingLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement breedingSubheaderText;
    @FindBy(xpath = "//div[@id='mainNav']//*[text()= 'Harness']")
    WebElement harnessLink;
    @FindBy(xpath = "//*[@class='subNavHeaderText']")
    WebElement harnessSubheaderText;
    @FindBy(xpath = "//div[@id='mainMenu']//*[text()= 'Sports Betting']")
    WebElement sportsBettingLink;
    @FindBy(xpath = "//*[@class='matchUps_tabHead__swx0n']/h2")
    WebElement sportsBettingSubheaderText;
    @FindBy(xpath = "//div[@id='mainMenu']//*[text()= 'Help']" )
    WebElement helpLink;
    @FindBy(xpath = "//*[@class='intro-title text-center']")
    WebElement helpSubheaderText;

    WebDriverWait wait;
    Utilities utility;
    JavascriptExecutor js;
    HandicappingPage handicappingPage;
    NewsInfoPage newsInfoPage;
    public static Properties prop;

    String expectedTitle = "Daily Racing Form | Horse Racing | Entries | Results | PPs (Past Performances)";
    String drfBetsTitleText = "DRF Bets | Online Horse Race Betting, Free PPs, Expert Analysis";
    String preaknessTitleText = "preakness 2023";
    String shopTitleText = "Daily Racing Form | DRF | America's Turf Authority Since 1894";
    String entriesTitleText = "Daily Racing Form | Horse Racing Entries | Charts & Payouts";
    String resultsTitleText = "Daily Racing Form | Horse Racing Results | Charts & Payouts";
    String breedingTitleText = "Breeding Page | DRF WCMS";
    String harnessTitleText = "Daily Racing Form | Harness";
    String sportsBettingTitleText = "Daily Sports News | Guides & Spreads | DRF Sports";
    String helpTitleText = "DRF Help";


    public HomePage() {
        PageFactory.initElements(driver, this);
        }

    public String getExpectedTitle() {
        return expectedTitle;
    }

    //Method to close Overlay when they appear on HomePage
    public void closeOverlay() {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='adOverlay']/div"))));
            overlayCross.click();

        } catch (Exception e) {
        }
    }

    public Boolean isLoginLinkVisible() {
        return loginLink.isDisplayed();
    }

    public boolean login(String userId, String pass){

        loginLink.click();
        emailID.sendKeys(userId);
        password.sendKeys(pass);
        loginButton.click();
        return loginStateDRFLogo.isDisplayed();
    }

    public void logout(){
      // if(!isLoginLinkVisible()){
           userProfileWrap.click();
           logout.click();
       //}
    }
    public String getDrfBetsTitle() {
        return drfBetsTitleText;
    }
    public void clickDrfBets() {
        drfBetsLink.click();
    }
    public String getDrfBetsSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='drfNavSubHeader']"))));
        return drfBetsSubheaderText.getText();
    }

    public String getPreaknessTitle() {
        return preaknessTitleText;
    }
    public void clickPreakness() {
        preaknessLink.click();
    }
    public String getPreaknessSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return preaknessSubheaderText.getText();
    }

    public String getShopTitle() {
        return shopTitleText;
    }
    public void clickShop() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainNav']//*[text()= 'Shop']"))));
        shopLink.click();
    }
    public String getShopSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return shopSubheaderText.getText();
    }

    public String getEntriesTitle() {
        return entriesTitleText;
    }
    public void clickEntries() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainMenu']//*[text()= 'Entries']"))));
        entriesLink.click();
    }
    public String getEntriesSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return entriesSubheaderText.getText();
    }

    public String getResultsTitle() {
        return resultsTitleText;
    }
    public void clickResults() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainNav']//*[text()= 'Results']"))));
        resultsLink.click();
    }
    public String getResultsSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return resultsSubheaderText.getText();
    }

    public String getBreedingTitle() {
        return breedingTitleText;
    }
    public void clickBreeding() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainNav']//*[text()= 'Breeding']"))));
        breedingLink.click();
    }
    public String getBreedingSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return breedingSubheaderText.getText();
    }

    public String getHarnessTitle() {
        return harnessTitleText;
    }
    public void clickHarness() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainNav']//*[text()= 'Harness']"))));
        harnessLink.click();
    }
    public String getHarnessSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='subNavHeaderText']"))));
        return harnessSubheaderText.getText();
    }

    public String getSportsBettingTitle() {
        return sportsBettingTitleText;
    }

    public void clickSportsBetting() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainMenu']//*[text()= 'Sports Betting']"))));
        sportsBettingLink.click();
    }

    public String getSportsBettingSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='matchUps_tabHead__swx0n']/h2"))));
        return sportsBettingSubheaderText.getText();
    }
    public String getHelpTitle() {
        return helpTitleText;
    }

    public void clickHelp() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='mainMenu']//*[text()= 'Help']"))));
        helpLink.click();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it =  handles.iterator();

        String homePage = it.next();
        String helpPage = it.next();
        driver.switchTo().window(helpPage);
    }

    public String getHelpSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='intro-title text-center']"))));
        return helpSubheaderText.getText();
    }

    public int selectOneRandomDate() {

        utility = new Utilities();
        //span[@class='dateNo'](//*[@class='pixelTracker dateItem ']/span[1])
        int size = driver.findElements(By.xpath("//span[@class='dateNo']")).size();
        int randNo = utility.retunARandomNumber(size);
        WebElement randomDate = driver.findElement(By.xpath("//span[@class='dateNo']['"+randNo+"']"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dateNo']['"+randNo+"']"))));
        //randomDate.click();

        return size;
    }
    public int clickonRandomDate() {

        utility = new Utilities();
        //span[@class='dateNo'](//*[@class='pixelTracker dateItem ']/span[1])
        int size = driver.findElements(By.xpath("//span[@class='dateNo']")).size();
        int randNo = utility.retunARandomNumber(size);
        WebElement randomDate = driver.findElement(By.xpath("//span[@class='dateNo']['"+randNo+"']"));
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", randomDate);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='dateNo']['"+randNo+"']"))));
        randomDate.click();
        return size;
    }


}

