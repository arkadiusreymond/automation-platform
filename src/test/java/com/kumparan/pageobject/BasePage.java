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

    public void tapViewWithIdAndTimeOut(String id, int timeout) {
        findElementWithIdWithTimeout(id, timeout).click();
    }

    public void tapViewWithTextOnIndex(String text, int index) {
        findElementsWithText(text).get(index).click();
    }

    public void tapViewContainsText(String text) {
        findElementContainsText(text).click();
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

    public void goToForYouTab() {
        for (int i = 0; i < 5; i++) {
            try {
                isElementPresentByText("For You", 2);
                tapViewContainsText("For You");
                break;
            } catch (Exception e) {
                pressBackButton();
            }
        }
    }

    public void resetApp() {
        driver.resetApp();
    }
}
