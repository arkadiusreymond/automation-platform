package com.kumparan.pageobject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class BasePage {

    protected final AndroidDriver<AndroidElement> driver;
    private int maxSwipeCount = 15;

    public BasePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    private AndroidElement findElementContainsText(String text) {

        AndroidElement element = null;
        for (int i = 0; i < maxSwipeCount; i++) {

            try {
                element = driver.findElementByAndroidUIAutomator(
                        "new UiSelector().textContains(\"" + text + "\")");
                if (isElementPresent(element)) break;
            } catch (NoSuchElementException e) {
                swipeUp();
            }
        }
        return element;

    }

    private List<AndroidElement> findElementsWithText(String text) {

        List<AndroidElement> element = null;
        for (int i = 0; i < maxSwipeCount; i++) {
            try {
                element = driver.findElementsByAndroidUIAutomator(
                        "new UiSelector().text(\"" + text + "\")");
                if (isElementPresent(element.get(0))) break;
            } catch (NoSuchElementException e) {
                swipeUp();
            }
        }
        return element;
    }

    private AndroidElement findElementWithXpath(String xpath) {
        AndroidElement element = null;
        for (int i = 0; i < maxSwipeCount; i++) {
            try {
                element = driver.findElementByXPath(xpath);
                if (isElementPresent(element)) break;
            } catch (NoSuchElementException e) {
                swipeUp();
            }
        }
        return element;
    }


    private AndroidElement findElementWithIdWithTimeout(String id, int timeOutInSeconds) {
        By by = By.id(id);
        return (AndroidElement) (new WebDriverWait(driver, timeOutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isElementPresent(AndroidElement androidElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(androidElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresentById(String id, int timeOut) {
        By by = By.id(id);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresentByText(String text, int timeOut) {
        AndroidElement element = null;
        for (int i = 0; i < timeOut; i++) {

            try {
                element = driver.findElementByAndroidUIAutomator(
                        "new UiSelector().textContains(\"" + text + "\")");
                if (isElementPresent(element)) {
                    return true;
                }
            } catch (NoSuchElementException e) {
                delay(1000);
            }
        }
        return false;
    }

    public boolean isElementPresentByXpath(String xpath, int timeOut) {
        AndroidElement element = null;
        for (int i = 0; i < timeOut; i++) {

            try {
                element = driver.findElementByXPath(xpath);
                if (isElementPresent(element)) {
                    return true;
                }
            } catch (NoSuchElementException e) {
                delay(1000);
            }
        }
        return false;
    }

    public void tapViewWithIdAndTimeOut(String id, int timeout) {
        findElementWithIdWithTimeout(id, timeout).click();
    }

    public void tapViewWithTextOnIndex(String text, int index) {
        findElementsWithText(text).get(index).click();
    }

    public void tapViewContainsText(String text) {
        findElementContainsText(text).click();
    }

    public void tapViewWithXpath(String xpath) {
        findElementWithXpath(xpath).click();
    }

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int y0 = (int) (size.height * 0.7);
        int y1 = (int) (size.height * 0.3);
        int x = (size.width / 2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(new PointOption().withCoordinates(x, y0)).waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1))).moveTo(new PointOption().withCoordinates(x, y1)).release().perform();
    }

    public void delay(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pressBackButton() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void pressEnterButton() {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
    }

    public void goToForYouTab() {
        for (int i = 0; i < 5; i++) {
            if(isElementPresentByText("For You", 2)) {
                tapViewContainsText("For You");
                break;
            }
            else {
                pressBackButton();
            }
        }
    }

    public String getTextFromViewByXpath(String xpath) {
        return findElementWithXpath(xpath).getText();
    }

    public void checkFirstAppLoad() {
        if (isElementPresentByText("Pilih Kanal", 5)) {
            Assert.assertTrue(isElementPresentByText("Pilih Kanal", 5));
            tapViewWithTextOnIndex("OFF", 0);
            tapViewWithTextOnIndex("OFF", 1);
            tapViewWithTextOnIndex("OFF", 2);
            tapViewContainsText("Selanjutnya");
            Assert.assertTrue(isElementPresentByText("Cari di sini...", 5));
        }
        else {
            System.out.println("Skip pilih kanal");
        }
    }

    public void typeTextWithPlaceHolder(String placeholder, String value) {
        AndroidElement element = findElementContainsText(placeholder);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void typeTextWithXpath(String xpath, String value) {
        AndroidElement element = findElementWithXpath(xpath);
        element.click();
        element.clear();
        element.sendKeys(value);
    }

    public void getElementWithXpath(String xpath) {
        findElementWithXpath(xpath);
    }


    public void resetApp() {
        driver.resetApp();
    }

    public void closeApp() {
        driver.closeApp();
    }

    public void launchApp() {
        driver.launchApp();
    }

    public void clearCache() {
        driver.closeApp();
        delay(2000);
        driver.launchApp();
        delay(2000);
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            System.out.println("Keyboard already hide");
        }
    }
}
