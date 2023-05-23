package com.drf.qa.pages;

import com.drf.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BetNowPage extends TestBase {

    @FindBy(xpath="//ul[@class='drfNavMainNavigation']//*[text()= 'Bet Now']")
    WebElement betNowPageLink;

    @FindBy(xpath="//*[@class='drfNavSubHeader']")
    WebElement betNowSubheaderText;

    String betNowPageTitleText = "DRF Bets | Online Horse Race Betting, Free PPs, Expert Analysis";
    String betNowPageSubHeaderText = "Bet Now";

    WebDriverWait wait;
    public BetNowPage()
    {
        PageFactory.initElements(driver, this);
    }

    public String getBetNowTitle(){
        return betNowPageTitleText;
    }

    public String getBetNowPageSubHeaderText() {
        return betNowPageSubHeaderText;
    }


}
