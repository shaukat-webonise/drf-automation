package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreaknessPage extends TestBase {

    @FindBy(xpath="//*[@class='drfNavMainNavigation']//*[text()= 'Preakness']")
    WebElement preaknessPageLink;

    @FindBy(xpath="//*[@class='drfNavSubHeader']")
    WebElement preaknessSubheaderText;

    String preaknessPageTitleText = "";
    String preaknessPageSubHeaderText = " ";

    WebDriverWait wait;
    public PreaknessPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String getpreaknessTitle(){
        return preaknessPageTitleText;
    }

    public String getpreaknessPageSubHeaderText() {
        return preaknessPageSubHeaderText;
    }


}
