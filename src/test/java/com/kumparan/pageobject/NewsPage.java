package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class NewsPage extends BasePage{

    public NewsPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnNewsPage() {
        Assert.assertTrue(isElementPresentByText("Tulis komentar...", 10));
        Assert.assertTrue(isElementPresentByXpath("//android.widget.TextView[@content-desc=\"story-title\"]", 10));
    }

    public void validateNewsTitle() {
        Assert.assertEquals(getTextFromViewByXpath("//android.widget.TextView[@content-desc=\"story-title\"]"), NewsData.getNewsTitle());
    }

    public void setNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]"));
    }

    public void swipeToRelatedNewsTitle() {
        getElementWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]");
    }

    public void tapOnRelatedNewsTitle() {
        tapViewWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]");
    }
}
