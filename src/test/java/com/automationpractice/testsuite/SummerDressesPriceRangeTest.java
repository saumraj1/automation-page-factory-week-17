package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDerssesPage;
import com.automationpractice.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SummerDressesPriceRangeTest extends Utility {

    HomePage homePage;
    SummerDerssesPage summerDerssesPage;

    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void init1(){
        homePage = new HomePage();
        summerDerssesPage = new SummerDerssesPage();
    }
    @Test(groups = {"smoke","regression"})
    public void updateSearchResultsAfterChangingPriceRange(){
        //Select Women Category from the main menu
        homePage.selectItemFromMainMenu("Women");
        //Select summer dresses from the submenu
        homePage.selectItemsFromWomensMenu("Summer Dresses");
        //verify the summer dresses page
        summerDerssesPage.verifySummerDressesPageVerificationText("SUMMER DRESSES");
        //move the slider to change the price range
        summerDerssesPage.moveSliderToChangePrice();
        //search results are updated
        //items returned are within the price range
    }

}
