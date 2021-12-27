package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.SummerDerssesPage;
import com.automationpractice.utility.Utility;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SummerDressesOptionTest extends Utility {
    HomePage homePage;
    SummerDerssesPage summerDerssesPage;

    @BeforeMethod(groups = {"smoke","sanity","redression"})
    public void init1(){
        homePage= new HomePage();
        summerDerssesPage = new SummerDerssesPage();
    }
    @Test(groups = {"sanity","regression"})
    public void viewSummerDressesOptionFromTheNaviGationMenu(){
        homePage.selectItemFromMainMenu("Women");
        homePage.selectItemsFromWomensMenu("Summer Dresses");
        summerDerssesPage.verifySummerDressesPageVerificationText("SUMMER DRESSES");
    }
}
