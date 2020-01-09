package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BottomBar extends BasePage {


    public BottomBar(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void tapOnForYouBottomBar() {
        tapViewContainsText("For You");
    }

    public void tapOnTerbaruBottomBar() {
        tapViewContainsText("Terbaru");
    }

    public void tapOnCollectionBottomBar() {
        tapViewContainsText("Collection");
    }

    public void tapOnNotifikasiBottomBar() {
        tapViewContainsText("Notifikasi");
    }

    public void tapOnMenuBottomBar() { tapViewContainsText("Menu");
    }

}
