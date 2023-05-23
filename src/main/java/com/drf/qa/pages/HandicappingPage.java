package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class HandicappingPage extends TestBase {

    @FindBy(xpath = "//ul[@class='drfNavMainNavigation']//*[text()= 'Handicapping & PPs']")
    WebElement handicappingLink;
    @FindBy(xpath = "//*[@class='drfNavSubHeader']")
    WebElement handicappingSubheaderText;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'DRF Classic & Formulator PPs']")
    WebElement drfClassicLink;
    @FindBy(xpath = "//div[@class='topLine']")
    WebElement drfClassicTopLineTextOnPage;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Clocker Reports']")
    WebElement clockerReportsLink;
    @FindBy(xpath = "//div[@class='topLine firstLine']")
    WebElement clockerReportsTopLineTextOnPage;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'DRF Picks']")
    WebElement drfPicksLink;
    @FindBy(xpath = "//div[@class='calendarDesc desktopOnly']")
    WebElement drfPicksTopLineTextOnPage;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Betting Strategies']")
    WebElement bettingStrategiesLink;
    @FindBy(xpath = "//div[@class='calendarDesc desktopOnly']")
    WebElement bettingStrategiesTopLineTextOnPage;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Daily Racing Program']")
    WebElement dailyRacingLink;
    @FindBy(xpath = "//div[@class='topLine']")
    WebElement dailyRacingTopLineTextOnPage;
    @FindBy(xpath = "//span[@class='headLabel']")
    WebElement chooseProductDRFClassic;
    @FindBy(xpath = "//span[@class='headLabel']")
    WebElement chooseProductClockerReports;
    @FindBy(xpath = "//span[@class='headLabel']")
    WebElement chooseProductDRFPicks;
    @FindBy(xpath = "//span[@class='headLabel']")
    WebElement chooseProductBettingStrategies;

    String handicappingPageTitleText = "Daily Racing Form | Horse Racing | Entries | Results | PPs (Past Performances)";
    String drfClassicTopLineText = "Access DRF Formulator or Classic Past Performances, featuring exclusive Beyer Speed Figures and much more!";
    String clockerReportsTopLineText = "By Mike Welsch & the DRF Clocker Team";
    String drfPicksTopLineText = "Access picks from DRF’s expert handicappers from any device! Get mobile-optimized selections available for your favorite tracks - no matter where you play";
    String bettingStrategiesTopLineText = "DRF Betting Strategies are available on select race dates. To learn more, please visit here";
    String dailyRacingTopLineText = "Select a date to view Daily Racing Program PPs for the tracks/dates shown below. Tracks and dates not shown are not available. [Help]";

    WebDriverWait wait;
    public static Properties prop;


    public HandicappingPage() {
        PageFactory.initElements(driver, this);
    }

    public String getHandicappingTitle() {
        return handicappingPageTitleText;
    }

    public void clickHandicapping() {
        handicappingLink.click();
    }

    public String getHandicappingSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='drfNavSubHeader']"))));
        return handicappingSubheaderText.getText();
    }

    public String getDrfClassicTopLineText() {
        return drfClassicTopLineText;
    }

    public void clickDrfClassicLink() {
        drfClassicLink.click();
    }
    public String gtDrfClassicTopLineTextFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='topLine']"))));
        return drfClassicTopLineTextOnPage.getText();
    }

    public String getClockerReportsTopLineText() {
        return clockerReportsTopLineText;
    }

    public void clickClockerReports() {
        clockerReportsLink.click();
    }

    public String getClockerReportsTopLineFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='topLine firstLine']"))));
        return clockerReportsTopLineTextOnPage.getText();
    }

    public String getDrfPicksTopLineText() {
        return drfPicksTopLineText;
    }

    public void clickDrfPicksLink() {
        drfPicksLink.click();
    }
    public String getDrfPicksTopLineFromPage() {
        drfPicksLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='calendarDesc desktopOnly']"))));
        return drfPicksTopLineTextOnPage.getText();
    }

    public String getBettingStrategiesTopLineText() {
        return bettingStrategiesTopLineText;
    }
    public void clickBettingStrategies() {
        bettingStrategiesLink.click();
    }
    public String getBettingStrategiesTopLineFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='calendarDesc desktopOnly']"))));
        return bettingStrategiesTopLineTextOnPage.getText();
    }

    public String getDailyRacingTopLineText() {
        return dailyRacingTopLineText;
    }
    public void clickDailyRacingLink() {
        dailyRacingLink.click();
    }
    public String getDailyRacingTopLineFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='topLine']"))));
        return dailyRacingTopLineTextOnPage.getText();
    }

    public String purchaseModalforDRFClassicPPs() {
        return chooseProductDRFClassic.getText();
    }
    public String purchaseModalforClockerReports() {
        return chooseProductDRFClassic.getText();
    }
    public String purchaseModalforDRFPicks() {
        return chooseProductDRFPicks.getText();
    }
    public String purchaseModalforBettingStrategies() {
        return chooseProductBettingStrategies.getText();
    }
}
