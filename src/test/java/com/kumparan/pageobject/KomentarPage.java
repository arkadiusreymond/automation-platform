package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class KomentarPage extends BasePage {
    public KomentarPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnKomentarPage() {
        Assert.assertTrue(isElementPresentByXpath("//android.widget.TextView[@content-desc=\"title\"]", 10));
        Assert.assertEquals(getTextFromViewByXpath("//android.widget.TextView[@content-desc=\"header-title\"]"), "Komentar");
        Assert.assertTrue(isElementPresentByText("Tulis komentar...", 10));

    }

    public void typeOnTulisKomentar(String value) {
        typeTextWithPlaceHolder("Tulis komentar...", value);
    }

    public void tapOnSendButton() {
        tapViewWithXpath("//android.view.ViewGroup[@content-desc=\"btn-send-comment\"]");
    }

    public void validateCommentIsExist(String komentar) {
        Assert.assertTrue(isElementPresentByText(komentar, 20));
    }

    public void swipeToBottomPage() {
        for (int i=0;i<=5;i++){
            delay(1000);
            swipeUp();
            delay(1000);
        }
    }
}
