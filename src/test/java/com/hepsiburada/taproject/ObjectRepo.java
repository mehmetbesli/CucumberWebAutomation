package com.hepsiburada.taproject;

import org.openqa.selenium.By;

public class ObjectRepo {

    public static final By signIn = By.cssSelector("div[class='header_user_info'] a");
    public static final By loginForm = By.id("login_form");
    public static final By email = By.id("email");
    public static final By password = By.id("passwd");
    public static final By signInBtn = By.id("SubmitLogin");
    public static final By mainPage = By.id("page");
    public static final By dressesMenu = By.xpath("//div[@id=\"block_top_menu\"]/ul/li[2]");
    public static final By summerDressesSubMenu = By.xpath("//li[@class='sfHover']//li[3]");
    public static final By firstProduct = By.xpath("//div[@id=\"center_column\"]/ul/li[1]");
    public static final By addToCartForFirstProduct = By.xpath("(//a[@title='Add to cart'])[1]/span");
    public static final By proceedToCheckout = By.cssSelector("a[title='Proceed to checkout']");
    public static final By proceedToCheckoutInSummary = By.cssSelector("div[id='center_column'] a[title='Proceed to checkout']");
    public static final By proceedToCheckoutInAddress = By.cssSelector("button[name='processAddress']");
    public static final By termsOfService = By.cssSelector("div[id='uniform-cgv'] span");
    public static final By proceedToCheckoutInShipping = By.cssSelector("button[name='processCarrier']");
    public static final By payByBankWire= By.cssSelector("a[class='bankwire']");
    public static final By confirmOrder= By.cssSelector("p[id='cart_navigation'] button");
    public static final By acoount= By.cssSelector("a[title='View my customer account']");
    public static final By orderHistoryAndDetails= By.cssSelector("a[title='Orders']");
    public static final By paymentType= By.cssSelector("[id='order-list'] [class='history_method']");


}
