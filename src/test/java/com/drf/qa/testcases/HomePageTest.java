package com.drf.qa.testcases;

import com.drf.qa.base.TestBase;
import com.drf.qa.pages.*;
import com.drf.qa.util.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {

    HomePage homePage;
    Utilities utility;
    HandicappingPage handicappingPage;
    NewsInfoPage newsInfoPage;

    HomePageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() {
        initialization();

        utility = new Utilities();
        homePage = new HomePage();
        handicappingPage = new HandicappingPage();
        newsInfoPage = new NewsInfoPage();

        homePage.closeOverlay();
    }

    @Test(priority = 1)
    public void getTitle() throws Exception {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(homePage.getExpectedTitle(), actualTitle);
    }

    @Test(dependsOnMethods = {"getTitle"})
    public void checkHandicappingTitleAndSubHeader() throws Exception {
        handicappingPage.clickHandicapping();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(handicappingPage.getHandicappingTitle(), actualTitle);

        String actualsubHeader = handicappingPage.getHandicappingSubheaderFromPage();
        Assert.assertTrue(actualsubHeader.contains("Handicapping & PPs"));
    }

    @Test(dependsOnMethods = {"checkHandicappingTitleAndSubHeader"})
    public void checkNewsInfoTitleAndSubHeader() throws Exception {
        newsInfoPage.clickNewsInfo();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, newsInfoPage.getNewsInfoTitle());

        String actualsubHeader = newsInfoPage.getNewsInfoSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "News & Info");
    }

    @Test(dependsOnMethods = {"checkNewsInfoTitleAndSubHeader"})
    public void checkDrfBetsTitleAndSubHeader() throws Exception {
        homePage.clickDrfBets();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getDrfBetsTitle());

        String actualsubHeader = homePage.getDrfBetsSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Bet Now");
    }

    @Test(dependsOnMethods = {"checkDrfBetsTitleAndSubHeader"})
    public void checkPreaknessTitleAndSubHeader() throws Exception {
        homePage.clickPreakness();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getPreaknessTitle());

        String actualsubHeader = homePage.getPreaknessSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Preakness");
    }

    @Test(dependsOnMethods = {"checkPreaknessTitleAndSubHeader"})
    public void checkShopTitleAndSubHeader() throws Exception {
        homePage.clickShop();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getShopTitle());

        String actualsubHeader = homePage.getShopSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Shop");
    }

    @Test(dependsOnMethods = {"checkShopTitleAndSubHeader"})
    public void checkEntriesTitleAndSubHeader() throws Exception {
        homePage.clickEntries();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getEntriesTitle());

        String actualsubHeader = homePage.getEntriesSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Entries & Live Odds");
    }

    @Test(dependsOnMethods = {"checkEntriesTitleAndSubHeader"})
    public void checkResultsTitleAndSubHeader() throws Exception {
        homePage.clickResults();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getResultsTitle());

        String actualsubHeader = homePage.getResultsSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Results");
    }

    @Test(dependsOnMethods = {"checkResultsTitleAndSubHeader"})
    public void checkBreedingTitleAndSubHeader() throws Exception {
        homePage.clickBreeding();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getBreedingTitle());

        String actualsubHeader = homePage.getBreedingSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "Breeding");
    }

    @Test(dependsOnMethods = {"checkBreedingTitleAndSubHeader"})
    public void checkHarnessTitleAndSubHeader() throws Exception {
        homePage.clickHarness();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getHarnessTitle());

        String actualsubHeader = homePage.getHarnessSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "DRF Harness");
    }

    @Test(dependsOnMethods = {"checkHarnessTitleAndSubHeader"})
    public void checkSportsBettingTitleAndSubHeader() throws Exception {
        homePage.clickSportsBetting();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getSportsBettingTitle());

        String actualsubHeader = homePage.getSportsBettingSubheaderFromPage();
        Assert.assertTrue("Matchups".equalsIgnoreCase(actualsubHeader));
    }

    @Test(dependsOnMethods = {"checkSportsBettingTitleAndSubHeader"})
    public void checkHelpTitleAndSubHeader() throws Exception {
        driver.navigate().back();
        homePage.clickHelp();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homePage.getHelpTitle());

        String actualsubHeader = homePage.getHelpSubheaderFromPage();
        Assert.assertEquals(actualsubHeader, "How can we help?");
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}

