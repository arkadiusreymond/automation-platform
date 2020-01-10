package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class CategoryLandingPage extends BasePage {
    public CategoryLandingPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnCategoryLandingPage(String categoryName) {
        isElementPresentByText(categoryName, 10);
        Assert.assertTrue(isElementPresentByXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]", 10));
    }

    public void setNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]"));
    }

    public void tapOnNewsTitle() {
        tapViewWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[2]");
    }
}
