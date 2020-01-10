package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class PilihKanalPage extends BasePage{

    public PilihKanalPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnPilihKanalPage() {
        Assert.assertTrue(isElementPresentByText("Pilih Kanal", 30));
    }

    public void tapOnKanalNews() {
        tapViewWithTextOnIndex("OFF", 0);
    }

    public void tapOnKanalOtomotif() {
        tapViewWithTextOnIndex("OFF", 1);
    }

    public void tapOnKanalBisnis() {
        tapViewWithTextOnIndex("OFF", 2);
    }

    public void tapOnSelanjutnyaButton() {
        tapViewContainsText("Selanjutnya");
    }

}
