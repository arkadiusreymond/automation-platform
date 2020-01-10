package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
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

    public void tapOnHeadlineNewsTitle() {
        tapViewWithXpath("//android.widget.TextView[@text='HEADLINE']/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
    }

    public void tapOnNewsTitle() {
        tapViewWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]");
    }

    public void setNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]"));
    }

    public void valodateNewsTitleOnThumnail() {
        Assert.assertEquals(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]"), NewsData.getNewsTitle());
    }

    public void setHeadlineNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("//android.widget.TextView[@text='HEADLINE']/following-sibling::android.view.ViewGroup/child::android.widget.TextView"));
    }

    public void tapOnCategoryTab(String categoryName) {
        tapViewContainsText(categoryName);
    }

    public void typeOnSearchBarEditText(String value) {
        typeTextWithPlaceHolder("Cari di sini...", value);
        NewsData.setKeyword(value);
    }

    public void tapOnButtonComment() {
        tapViewWithXpath("(//android.view.ViewGroup[@content-desc=\"btn-comment\"])[1]");
    }

    public void swipeToBottomPage() {
        for (int i=0;i<=5;i++){
            delay(1000);
            swipeUp();
            delay(1000);
        }
    }
}
