package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a")
    List<WebElement>menuList;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//ul//li//a")
    List<WebElement>innerMenuList;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement signInButton;

    @FindBy(xpath = "//section[@id='block_various_links_footer']//ul[@class='toggle-footer']//a")
    List<WebElement>informationFooterOptions;


    public void selectItemFromMainMenu(String selection)  {
      for(WebElement name: menuList) {
            if (name.getText().equalsIgnoreCase(selection)) {
              mouseHoverNoClick(name);
                break;
            }
        }
    }

    public void selectItemsFromWomensMenu(String innerMenu) {
        for (WebElement in : innerMenuList)
            if (in.getText().equalsIgnoreCase(innerMenu)) {
              mouseHoverAndClick(in);
                break;
            }
    }

    public void clickOnSignInButton(){
        clickOnElement(signInButton);
    }

    public void selectFromInformationFooter(String selection){
        for(WebElement item : informationFooterOptions){
            if(item.getText().equalsIgnoreCase(selection)){
               clickOnElement(item);
                break;
            }
        }

    }
}




