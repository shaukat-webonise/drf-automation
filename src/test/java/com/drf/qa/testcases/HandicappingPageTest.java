package com.drf.qa.testcases;

import com.drf.qa.base.TestBase;
import com.drf.qa.pages.HandicappingPage;
import com.drf.qa.pages.HomePage;
import com.drf.qa.util.Utilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HandicappingPageTest extends TestBase {
    HomePage homePage;
    HandicappingPage handicappingPage;
    Utilities utility;

    HandicappingPageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() {

        initialization();

        utility = new Utilities();
        homePage = new HomePage();
        handicappingPage = new HandicappingPage();

        homePage.closeOverlay();
    }

    @Test(priority=1)
    public void isUserLoggedIn() throws Exception {
        Assert.assertTrue(homePage.isLoginLinkVisible());
    }

    //@Test(priority=2)
    public void checkHandicappingTitleAndSubHeader() throws Exception    {

        handicappingPage.clickHandicapping();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(handicappingPage.getHandicappingTitle(), actualTitle);

        String actualsubHeader = handicappingPage.getHandicappingSubheaderFromPage();
        Assert.assertTrue(actualsubHeader.contains("Handicapping & PPs"));
    }

    //@Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkLinksOnDrfClassicPage() throws Exception {
        handicappingPage.clickDrfClassicLink();
        String expectedTopLineText = handicappingPage.getDrfClassicTopLineText();
        String actualTopLineText = handicappingPage.gtDrfClassicTopLineTextFromPage();
        Assert.assertEquals(expectedTopLineText,actualTopLineText);
    }

    //@Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkLinksOnClockerReportsPage() throws Exception {
        handicappingPage.clickClockerReports();
        String expectedTopLineText = handicappingPage.getClockerReportsTopLineText();
        String actualTopLineText = handicappingPage.getClockerReportsTopLineFromPage();
        Assert.assertEquals(expectedTopLineText,actualTopLineText);
    }

    //@Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkLinksOnDrfPicksPage() throws Exception {
        handicappingPage.clickDrfPicksLink();
        String expectedTopLineText = handicappingPage.getDrfPicksTopLineText();
        String actualTopLineText = handicappingPage.getDrfPicksTopLineFromPage();
        Assert.assertEquals(expectedTopLineText,actualTopLineText);
    }

    //@Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkLinksOnBettingStrategiesPage() throws Exception {
        handicappingPage.clickBettingStrategies();
        String expectedTopLineText = handicappingPage.getBettingStrategiesTopLineText();
        String actualTopLineText = handicappingPage.getBettingStrategiesTopLineFromPage();
        Assert.assertEquals(expectedTopLineText,actualTopLineText);
    }

   // @Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkLinksOnDailyRacingPage() throws Exception    {
        handicappingPage.clickDailyRacingLink();
        String expectedTopLineText = handicappingPage.getDailyRacingTopLineText();
        String actualTopLineText = handicappingPage.getDailyRacingTopLineFromPage();
        Assert.assertEquals(expectedTopLineText,actualTopLineText);
    }


    @Test(dependsOnMethods = {"isUserLoggedIn"}) //isUserLoggedIn //checkLinksOnDailyRacingPage
    public void checkLogin() throws Exception {
        String userId = prop.getProperty("userWE"); //userWE    //userStageWE
        String pass = prop.getProperty("passwordWE"); //passwordWE //passwordStageWE
        homePage.isLoginLinkVisible();
        Assert.assertTrue(homePage.login(userId,pass));
    }

    //C9267	- As a new user without Entitlement, ensure you get purchase modal for PPs, BS, Picks and Clocker Reports access
    @Test(dependsOnMethods = {"checkLogin"})
    public void checkPurchaseModalforDRFClassicPPs(){
        handicappingPage.clickHandicapping();
        handicappingPage.clickDrfClassicLink();
        int datesCount = homePage.clickonRandomDate();

        if (datesCount==0) {
            throw new SkipException("Skipping as there are no races for DRF Classic & Formulator PPs");
        }
        else{
            String isProductListAvailable = handicappingPage.purchaseModalforDRFClassicPPs();
            Assert.assertEquals(isProductListAvailable, "Choose Product");
        }
    }

   @Test(dependsOnMethods = {"checkPurchaseModalforDRFClassicPPs"})
    public void checkPurchaseModalforClockerReports(){
       driver.navigate().back();
       handicappingPage.clickClockerReports();
       int datesCount = driver.findElements(By.xpath("//span[@class='dateNo']")).size();

        if (datesCount ==0) {
            throw new SkipException("Skipping as there are no races for Clocker Reports ");
        }
        else{
            homePage.clickonRandomDate();
            String isProductListAvailable = handicappingPage.purchaseModalforClockerReports();
            Assert.assertEquals(isProductListAvailable, "Choose Product");
        }
    }

    @Test(dependsOnMethods = {"checkPurchaseModalforClockerReports"})
    public void checkPurchaseModalforDRFPicks(){
        driver.navigate().back();
        handicappingPage.clickDrfPicksLink();
        int datesCount = driver.findElements(By.xpath("//span[@class='dateNo']")).size();

        if (datesCount ==0) {
            throw new SkipException("Skipping as there are no races for DRF Picks ");
        }
        else{
            homePage.clickonRandomDate();
            String isProductListAvailable = handicappingPage.purchaseModalforDRFPicks();
            Assert.assertEquals(isProductListAvailable, "Choose Product");
        }
    }

    @Test(dependsOnMethods = {"checkPurchaseModalforDRFPicks"})
    public void checkPurchaseModalforBettingStrategies(){
        driver.navigate().back();
        handicappingPage.clickBettingStrategies();
        int datesCount = driver.findElements(By.xpath("//span[@class='dateNo']")).size();

        if (datesCount ==0) {
            throw new SkipException("Skipping as there are no races for Betting Strategies ");
        }
        else{
            homePage.clickonRandomDate();
            String isProductListAvailable = handicappingPage.purchaseModalforBettingStrategies();
            Assert.assertEquals(isProductListAvailable, "Choose Product");
        }
    }

    //C9278	Verify Betting Strategies link displays in the designated PPs Card.
    @Test(dependsOnMethods = {"checkPurchaseModalforBettingStrategies"})
    public void checkPPsEntitledUserCanViewPPsCard(){
        String userID = prop.getProperty("userPPsEntitled"); //userWE    //userStageWE
        String pass = prop.getProperty("passPPsEntitled"); //passwordWE //passwordStageWE
        driver.navigate().back();
        homePage.logout();
        homePage.login(userID,pass);
        //handicappingPage.clickHandicapping();
        //handicappingPage.clickBettingStrategies();



    }

    //@AfterClass
    public void teardown()
    {
        driver.close();
    }


}