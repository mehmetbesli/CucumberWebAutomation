package com.hepsiburada.steps;

import com.hepsiburada.taproject.Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {

    Page page=new Page();

    @Given("^Go to \"([^\"]*)\" url and choose browser \"([^\"]*)\"$")
    public void goToUrlAndChooseBrowser(String url, String browser) throws Throwable {
        page.ReportConfiguration();
        page.initializeDriver(browser);
        page.gotoUrl(url);
    }

    @When("^Click sign in$")
    public void clickSignIn() throws Exception {
        page.clickSignIn();
    }

    @Then("^Type email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void typeEmailAndPassword(String email, String password) throws Throwable {
        page.typeEmailAndPassword(email,password);
    }

    @And("^Control main page$")
    public void controlMainPage() {
        page.controlMainPage();
    }

    @When("^Click main menu \"([^\"]*)\" and sub menu \"([^\"]*)\"$")
    public void clickMainMenuAndSubMenu(String menu, String submenu) throws Throwable {
        //Menu parameter
        if(menu.equalsIgnoreCase("dresses")){
                page.hoverDressesMenu();
        }

        //Submenu parameter
        if(submenu.equalsIgnoreCase("summer dresses")){
                page.summerDressesSubMenu();
        }
    }

    @Then("^Click add to cart$")
    public void clickAddToCart() throws Exception {
        page.hoverToFirstProduct();
        page.clickAddToCardForFirstProduct();
    }

    @And("^Click proceed to checkout$")
    public void clickProceedToCheckout() throws Exception {
        page.clickProceedToCheckout();
    }

    @Then("^Click proceed to checkout in summary$")
    public void clickProceedToCheckoutInSummary() throws Exception {
        page.clickProceedToCheckoutInSummar();

    }

    @When("^Click proceed to checkout in address$")
    public void clickProceedToCheckoutInAddress() throws Exception {
        page.clickProceedToCheckoutInAddress();
    }

    @Then("^Click Terms of service$")
    public void clickTermsOfService() throws Exception {
        page.clickTermsOfService();
    }

    @And("^Click proceed to checkout in shipping$")
    public void clickProceedToCheckoutInShipping() throws Exception {
        page.clickProceedToCheckoutInShipping();
    }

    @When("^Select pay by bank wire part$")
    public void selectPayByBankWirePart() throws Exception {
        page.selectPayByBankWirePart();
    }

    @Then("^Click I confirm my order$")
    public void clickIConfirmMyOrder() throws Exception {
        page.clickIConfirmMyOrder();
    }

    @And("^Click my account$")
    public void clickMyAccount() throws Exception {
        page.clickMyAccount();
    }

    @When("^Click order history and details$")
    public void clickOrderHistoryAndDetails() throws Exception {
        page.clickOrderHistoryAndDetails();
    }

    @Then("^control order with payment \"([^\"]*)\"$")
    public void controlOrderWithPayment(String paymentType) throws Throwable {
        page.controlOrderWithPayment(paymentType);
    }

    @And("^Close driver$")
    public void closeDriver() {
        page.closeDriverAndReport();
    }
}
