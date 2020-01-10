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

    public void tapOnHeadlineNews() {
        tapViewWithXpath("//android.widget.TextView[@text='HEADLINE']/following-sibling::android.view.ViewGroup/child::android.widget.TextView");
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
}
