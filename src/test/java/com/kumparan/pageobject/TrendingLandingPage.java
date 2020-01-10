package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class TrendingLandingPage extends BasePage {
    public TrendingLandingPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnTrendingLandingPage() {
        Assert.assertTrue(isElementPresentByText("Trending", 10));
        Assert.assertTrue(isElementPresentByXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]", 10));
    }

    public void tapOnCategoryTab(String categoryName) {
        tapViewContainsText(categoryName);
    }

    public void setNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]"));
    }

    public void tapOnNewsTitle() {
        tapViewWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]");
    }
}
