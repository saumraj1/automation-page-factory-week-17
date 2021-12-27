package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends Utility {
    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(css = "a[title='View my customer account'] span")
    WebElement accountNameVerification;

    public void verifyUserCanSeeAccountNameOnTopRight(String expectedName){
        verifyElements(accountNameVerification,expectedName,"Incorrect Account");
    }
}
