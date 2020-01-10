package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class MenuPage extends BasePage {

    public MenuPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnMenuPageBeforeLoginFirstInstall() {
        Assert.assertTrue(isElementPresentByText("Masuk kumparan menggunakan", 30));
    }

    public void isOnMenuPageAfterClearCache() {
        Assert.assertTrue(isElementPresentByText("Login", 30));
    }

    public void isPopUpGoogleShow() {
        Assert.assertTrue(isElementPresentById("com.google.android.gms:id/main_title", 30));
    }

    public void tapOnEmailTextView() {
        tapViewWithIdAndTimeOut("com.google.android.gms:id/account_display_name", 30);
    }

    public void tapOnGooleButton() {
        tapViewContainsText("Google");
    }

    public void tapOnLoginMenu() {
        tapViewContainsText("Login");
    }

    public void tapOnFacebookButton() {
        tapViewContainsText("Facebook");
    }

    public void isOnMenuPageAfterLogin() {
        Assert.assertTrue(isElementPresentByText("Ubah Profil", 30));
    }
}
