package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class VerifikasiPage extends BasePage {

    public VerifikasiPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnVerifikasiPage() {
        Assert.assertTrue(isElementPresentByText("Verifikasi", 10));
    }
}
