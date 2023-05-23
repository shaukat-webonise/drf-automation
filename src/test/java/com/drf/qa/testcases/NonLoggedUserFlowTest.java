package com.drf.qa.testcases;

import com.drf.qa.base.TestBase;
import com.drf.qa.pages.BetNowPage;
import com.drf.qa.pages.GetAccessToPPsPage;
import com.drf.qa.pages.HomePage;
import com.drf.qa.pages.RegistrationPage;
import com.drf.qa.util.Utilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class NonLoggedUserFlowTest extends TestBase {

    HomePage homePage ;
    GetAccessToPPsPage  getAccessToPPsPage;
    RegistrationPage registrationPage ;
    BetNowPage betNowPage;
    Utilities utility;

    NonLoggedUserFlowTest() throws IOException
    {
        super();
    }

    @BeforeClass
    public void setUp()
    {
        initialization();

        utility = new Utilities();
        homePage = new HomePage();
        getAccessToPPsPage = new GetAccessToPPsPage();
        registrationPage = new RegistrationPage();
        betNowPage = new BetNowPage();

        homePage.closeOverlay();
    }

    @Test(priority=1)
    public void getTitle() throws Exception    {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(homePage.getExpectedTitle(), actualTitle);
    }

    @Test(priority=2)
    public void isUserLoggedIn() throws Exception {
        Assert.assertTrue(homePage.isLoginLinkVisible());
    }

    @Test(dependsOnMethods = {"isUserLoggedIn"})
    public void navigateToAccessPage() throws Exception {
        homePage.clickonRandomDate();
        String accessPageText = getAccessToPPsPage.getAccesstext();
        Assert.assertEquals(getAccessToPPsPage.getAccessPageSubHeaderText(), accessPageText);
    }

    @Test(dependsOnMethods = {"navigateToAccessPage"})
    public void navigateToRegistrationPage() throws Exception {
        getAccessToPPsPage.clickonbuyFormulatedPPs();
        String registerPageText = registrationPage.getRegistertext();
        Assert.assertEquals(registrationPage.getRegisterPageSubHeaderText(), registerPageText);
    }

    @AfterClass
    public void teardown()
    {
        driver.close();
    }


}


