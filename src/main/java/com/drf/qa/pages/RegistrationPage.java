package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends TestBase {

    @FindBy(xpath="//div[@class='purchaseFlow-Wrapper PF-container']/h2")
    WebElement registerText;

    @FindBy(xpath="")
    WebElement registerButton;

    WebDriverWait wait;
    public RegistrationPage()
    {
        PageFactory.initElements(driver, this);
    }

    String registerPageSubHeaderText = "Register & Continue to Checkout";
    public String getRegisterPageSubHeaderText(){
        return registerPageSubHeaderText;
    }
    public String getRegistertext(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='purchaseFlow-Wrapper PF-container']/h2"))));

        String regsiterText = registerText.getText();
        return regsiterText;
    }



}
