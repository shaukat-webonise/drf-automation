package com.drf.qa.testcases;

import com.drf.qa.base.TestBase;
import com.drf.qa.pages.HandicappingPage;
import com.drf.qa.pages.HomePage;
import com.drf.qa.pages.NewsInfoPage;
import com.drf.qa.util.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewsInfoPageTest extends TestBase {
    HomePage homePage;
    NewsInfoPage newsInfoPage;
    Utilities utility;

    NewsInfoPageTest() throws IOException {
        super();
    }

    @BeforeClass
    public void setUp() {

        initialization();

        utility = new Utilities();
        homePage = new HomePage();
        newsInfoPage = new NewsInfoPage();

        homePage.closeOverlay();
    }

    @Test(priority = 1)
    public void isUserLoggedIn() throws Exception {
        Assert.assertTrue(homePage.isLoginLinkVisible());
    }

    @Test(priority = 2)
    public void checkTitleAndSubHeader() throws Exception {
        newsInfoPage.clickNewsInfo();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(newsInfoPage.getNewsInfoTitle(), actualTitle);

        String actualsubHeader = newsInfoPage.getNewsInfoSubheaderFromPage();
        Assert.assertEquals(actualsubHeader,"News & Info");
    }

    @Test(dependsOnMethods = {"checkTitleAndSubHeader"})
    public void checkTopHeadLines() throws Exception {
        String subHeaderText = newsInfoPage.clickTopHeadLines();
        Assert.assertTrue(subHeaderText.contains("Top Horse Racing News"));
    }

    @Test(dependsOnMethods = {"checkTopHeadLines"})
    public void checkTrackNews() throws Exception {
        String subHeaderText = newsInfoPage.clickTrackNews();
        Assert.assertTrue(subHeaderText.contains("Top Tracks"));
    }

    @Test(dependsOnMethods = {"checkTrackNews"})
    public void checkROTD() throws Exception {
        String subHeaderText = newsInfoPage.clickROTD();
        Assert.assertTrue(subHeaderText.contains("DRF Race of the Day"));
    }
    @Test(dependsOnMethods = {"checkROTD"})
    public void checkHorseRacingNews() throws Exception {
        String subHeaderText = newsInfoPage.clickHorseRacingNews();
        Assert.assertTrue(subHeaderText.contains("Horse Racing News"));
    }

    @Test(dependsOnMethods = {"checkHorseRacingNews"})
    public void checkLinksOnHongKongPage() throws Exception {
       String racePreviewsText = newsInfoPage.clickHongKong();
       Assert.assertTrue(racePreviewsText.contains("Race Previews"));
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }


}