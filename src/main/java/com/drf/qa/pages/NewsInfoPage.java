package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsInfoPage extends TestBase {

    @FindBy(xpath = "//ul[@class='drfNavMainNavigation']//*[text()= 'News & Info']")
    WebElement newsInfoLink;
    @FindBy(xpath = "//*[@class='drfNavSubHeader']")
    WebElement newsInfoSubheaderText;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Top Headlines']")
    WebElement topHeadLinesLink;
    @FindBy(xpath = "//div[@class='headingName']")
    WebElement topHeadLinesSubHeaderLink;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Track News']")
    WebElement trackNewsLink;
    @FindBy(xpath = "//div[@class='favouiteTracksList']/h2")
    WebElement trackNewsSubHeaderLink;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Horse Racing News']")
    WebElement horseRacingNewsLink;
    @FindBy(xpath = "//*[@class='d-flex newsHeadPresentWrap']")
    WebElement horseRacingNewsText;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Race of the Day']")
    WebElement rotdLink;
    @FindBy(xpath = "//div[@class='raceNameHead']/h2")
    WebElement rotdSubHeaderLink;
    @FindBy(xpath = "//ul[@class='scrollableSecondaryNav']//*[text()= 'Hong Kong']")
    WebElement hongKongLink;
    @FindBy(xpath = "//div[@class='raceReviewRecapsWrap']//*[text()= 'Race Previews']")
    WebElement racePreviews;
    String newsInfoPageTitleText = "Top Headlines | Horse Racing News & Horse Racing Analysis";

    WebDriverWait wait;

    public NewsInfoPage() {
        PageFactory.initElements(driver, this);
    }

    public String getNewsInfoTitle() {
        return newsInfoPageTitleText;
    }

    public void clickNewsInfo() {
        newsInfoLink.click();
    }

    public String getNewsInfoSubheaderFromPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='drfNavSubHeader']"))));
        return newsInfoSubheaderText.getText();
    }

    public String clickTopHeadLines() {
        topHeadLinesLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='headingName']"))));
        return topHeadLinesSubHeaderLink.getText();
    }
    public String clickTrackNews() {
        trackNewsLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='favouiteTracksList']/h2"))));
        return trackNewsSubHeaderLink.getText();
    }

    public String clickROTD() {
        rotdLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='raceNameHead']/h2"))));
        return rotdSubHeaderLink.getText();
    }

    public String clickHorseRacingNews() {
        horseRacingNewsLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='drfNavSubHeader']"))));
        return horseRacingNewsText.getText();
    }

    public String clickHongKong() {
        hongKongLink.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='raceReviewRecapsWrap']//*[text()= 'Race Previews']"))));
        return racePreviews.getText();
    }
}