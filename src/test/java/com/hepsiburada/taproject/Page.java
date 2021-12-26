package com.hepsiburada.taproject;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class Page extends AbstractPage {


    public void initializeDriver(String browser) {
        Locale.setDefault(new Locale("en", "EN"));

        File f = new File("lib");
        File chromeDriver = new File(f,"chromedriver.exe");
        File firefoxDriver = new File(f,"geckodriver.exe");

        String browserName=getBrowserName(browser).toLowerCase();

        if (browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("--disable-popup-blocking");
            ops.addArguments("--disable-infobars");
            ops.addArguments("--start-maximized");

            driver = new ChromeDriver(ops);
            wait = new WebDriverWait(driver, 15);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", firefoxDriver.getAbsolutePath());

            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public String getBrowserName(String BrowserName) {
        if (BrowserName.contains("firefox")) {
            BrowserName = "FIREFOX";
        } else if (BrowserName.contains("chrome")) {
            BrowserName = "CHROME";
        } else {
            BrowserName = "";
        }
        return BrowserName;
    }

    public void clickSignIn() throws Exception {
        if (isElementExist(ObjectRepo.signIn,3)) {
            click(ObjectRepo.signIn);
            log.log(Level.INFO, "Clicked sign in");
            test.log(LogStatus.PASS, "Clicked sign in");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Clicked sign in");
            test.log(LogStatus.FAIL, "Could not Click sign in");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void typeEmailAndPassword(String email, String password) throws Exception {
        scrollMainWindow(0,350);

        control(isElementExist(ObjectRepo.loginForm), "You are in login form page", "You are in login form page");

        if (isElementExist(ObjectRepo.email)) {
            sendKeys(ObjectRepo.email, email);
            log.log(Level.INFO, "Email  typed");
            test.log(LogStatus.PASS, "email typed");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Email type");
            test.log(LogStatus.FAIL, "Could not email type");
            report.flush();
            Assert.assertTrue(false);
        }

        if (isElementExist(ObjectRepo.password)) {
            sendKeys(ObjectRepo.password, password);
            log.log(Level.INFO, "Password typed");
            test.log(LogStatus.PASS, "Password typed");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Password type");
            test.log(LogStatus.FAIL, "Could not password type");
            report.flush();
            Assert.assertTrue(false);
        }

        if (isElementExist(ObjectRepo.signInBtn)) {
            click(ObjectRepo.signInBtn);
            log.log(Level.INFO, "Clicked sign in for login");
            test.log(LogStatus.PASS, "Clicked sign in for login");

        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click sign in for login");
            test.log(LogStatus.FAIL, "Could not Click sign in for login");
            report.flush();
            Assert.assertTrue(false);
        }

    }

    public void controlMainPage() {
        control(isElementExist(ObjectRepo.mainPage), "You are in mainpage", "You are not in mainpage");
        test.log(LogStatus.PASS, "You are in mainpage");
    }

    public void hoverDressesMenu() throws Exception {
        if (isElementExist(ObjectRepo.dressesMenu)) {
            hoverToElement(ObjectRepo.dressesMenu);
            log.log(Level.INFO, "Hovered dressed menu");
            test.log(LogStatus.PASS, "Hovered dressed menu");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Hover dressed menu");
            test.log(LogStatus.FAIL, "Could not Hover dressed menu");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void summerDressesSubMenu() throws Exception {
        if (isElementExist(ObjectRepo.summerDressesSubMenu)) {
            wait.until(ExpectedConditions.elementToBeClickable(ObjectRepo.summerDressesSubMenu));
            click(ObjectRepo.summerDressesSubMenu);
            log.log(Level.INFO, "Clicked summer dress submenu");
            test.log(LogStatus.PASS, "Clicked summer dress submenu\"");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click summer dress submenu");
            test.log(LogStatus.FAIL, "Could not Click summer dress submenu\"");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void hoverToFirstProduct() throws Exception {
        scrollMainWindow(0,250);
        if (isElementExist(ObjectRepo.firstProduct)) {
            hoverToElement(ObjectRepo.firstProduct);
            log.log(Level.INFO, "Hovered product");
            test.log(LogStatus.PASS, "Hovered product");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Hover product");
            test.log(LogStatus.FAIL, "Could not Hover product");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickAddToCardForFirstProduct() throws Exception {
        if (isElementExist(ObjectRepo.addToCartForFirstProduct)) {
            click(ObjectRepo.addToCartForFirstProduct);
            log.log(Level.INFO, "Clicked add to cart");
            test.log(LogStatus.PASS, "Clicked add to cart");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click add to cart");
            test.log(LogStatus.FAIL, "Could not Click add to cart");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickProceedToCheckout() throws Exception {
        if (isElementExist(ObjectRepo.proceedToCheckout)) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ObjectRepo.proceedToCheckout));
            click(ObjectRepo.proceedToCheckout);
            log.log(Level.INFO, "Clicked proceed to checkout");
            test.log(LogStatus.PASS, "Clicked proceed to checkout");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click proceed to checkout");
            test.log(LogStatus.FAIL, "Could not Click proceed to checkout");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickProceedToCheckoutInSummar() throws Exception {
        if (isElementExist(ObjectRepo.proceedToCheckoutInSummary)) {
            click(ObjectRepo.proceedToCheckoutInSummary);
            log.log(Level.INFO, "Clicked proceed to checkout in summary");
            test.log(LogStatus.PASS, "Clicked proceed to checkout in summary");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click proceed to checkout in summary");
            test.log(LogStatus.FAIL, "Could not Click proceed to checkout in summary");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickProceedToCheckoutInAddress() throws Exception {
        if (isElementExist(ObjectRepo.proceedToCheckoutInAddress)) {
            click(ObjectRepo.proceedToCheckoutInAddress);
            log.log(Level.INFO, "Clicked proceed to checkout in address");
            test.log(LogStatus.PASS, "Clicked proceed to checkout in address");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click proceed to checkout in address");
            test.log(LogStatus.FAIL, "Could not Click proceed to checkout in address");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickTermsOfService() throws Exception {
        if (isElementExist(ObjectRepo.termsOfService)) {
            click(ObjectRepo.termsOfService);
            scrollMainWindow(0, 250);
            log.log(Level.INFO, "Clicked term of service");
            test.log(LogStatus.PASS, "Clicked term of service");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click term of service");
            test.log(LogStatus.FAIL, "Could not Click term of service");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickProceedToCheckoutInShipping() throws Exception {
        if (isElementExist(ObjectRepo.proceedToCheckoutInShipping)) {
            click(ObjectRepo.proceedToCheckoutInShipping);
            log.log(Level.INFO, "Clicked proceed to checkout in shipping");
            test.log(LogStatus.PASS, "Clicked proceed to checkout in shipping");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click term of service");
            test.log(LogStatus.FAIL, "Could not Click term of service");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void selectPayByBankWirePart() throws Exception {
        if (isElementExist(ObjectRepo.payByBankWire)) {
            click(ObjectRepo.payByBankWire);
            log.log(Level.INFO, "Selected pay by bank wire");
            test.log(LogStatus.PASS, "Selected pay by bank wire");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Select pay by bank wire");
            test.log(LogStatus.FAIL, "Could not Select pay by bank wire");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickIConfirmMyOrder() throws Exception {
        if (isElementExist(ObjectRepo.confirmOrder)) {
            click(ObjectRepo.confirmOrder);
            log.log(Level.INFO, "Clicked I confirm my order");
            test.log(LogStatus.PASS, "Clicked I confirm my order");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click I confirm my order");
            test.log(LogStatus.FAIL, "Could not Click I confirm my order");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickMyAccount() throws Exception {
        control(isElementExist(ObjectRepo.acoount), "You are in account page", "You are not in account page");
        if (isElementExist(ObjectRepo.acoount)) {
            click(ObjectRepo.acoount);
            log.log(Level.INFO, "Clicked my acount");
            test.log(LogStatus.PASS, "Clicked my acount");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click my acount");
            test.log(LogStatus.FAIL, "Could not Click my acount");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void clickOrderHistoryAndDetails() throws Exception {
        control(isElementExist(ObjectRepo.orderHistoryAndDetails), "You are in order History And Details page", "You are not in  History And Details page");
        if (isElementExist(ObjectRepo.orderHistoryAndDetails)) {
            click(ObjectRepo.orderHistoryAndDetails);
            log.log(Level.INFO, "Clicked order history and details");
            test.log(LogStatus.PASS, "Clicked order history and details");
        }else {
            takeSnapShot();
            log.log(Level.INFO, "Could not Click order history and details");
            test.log(LogStatus.FAIL, "Could not Click order history and details");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void controlOrderWithPayment(String paymentType) throws Exception {
        List<WebElement> elementList = findElements(ObjectRepo.paymentType);
        boolean durum = false;

        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equalsIgnoreCase(paymentType)) {
                durum = true;
                break;
            }
        }
        if (durum) {
            control(durum, "Ordered product exist", "Ordered product is not exist");
            test.log(LogStatus.PASS, "Ordered product exist");
        }else {
            takeSnapShot();
            test.log(LogStatus.FAIL, "Order product is not exist");
            report.flush();
            Assert.assertTrue(false);
        }
    }

    public void ReportConfiguration() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd-HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        String sysDate = dtf.format(now);

        report = new ExtentReports(System.getProperty("user.dir")+"\\TestReport\\Report\\"+sysDate+".html");
        //Case Name
        test = report.startTest("Buy a dress");
    }

    public void closeDriverAndReport() {
        report.flush();
        driver.close();
    }
}
