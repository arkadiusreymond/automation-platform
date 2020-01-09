package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class ForYouPage extends BasePage {

    public ForYouPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnForYouPage() {
        Assert.assertTrue(isElementPresentByText("Cari di sini...", 30));
    }
}
