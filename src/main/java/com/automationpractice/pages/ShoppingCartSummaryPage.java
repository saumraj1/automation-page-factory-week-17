package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends Utility {
    public ShoppingCartSummaryPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='alert alert-warning']")
    WebElement emptyShoppingCartVerificationText;

    public void verifyShoppingCartIsEmptyMessage(String message){
        clickOnElement(cartButton);
        verifyElements(emptyShoppingCartVerificationText,message,"Incorrect Message");
    }

}
