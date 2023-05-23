package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class GetAccessToPPsPage extends TestBase {

    @FindBy(xpath="//*[@class= 'purchaseFlow-Wrapper PF-container']/h2")
    WebElement getAccesstext;

    @FindBy(xpath="//div[@class='chooseSubscription hiddenMobile']/ul/li[3]/button")
    WebElement buyFormulatedPPs;

    WebDriverWait wait;

    String accessPageSubHeaderText = "Get Access to Past Performances";

    public String getAccessPageSubHeaderText(){
        return accessPageSubHeaderText;
    }

    public GetAccessToPPsPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String getAccesstext(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class= 'purchaseFlow-Wrapper PF-container']/h2"))));

        String accessText = getAccesstext.getText();
        return accessText;
    }

    public void clickonbuyFormulatedPPs(){
        buyFormulatedPPs.click();
    }



}
