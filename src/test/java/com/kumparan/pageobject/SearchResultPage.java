package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class SearchResultPage extends BasePage {
    public SearchResultPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnSearchResultPage() {
        Assert.assertTrue(isElementPresentByText("Relevansi", 10));
        Assert.assertTrue(isElementPresentByText("Terbaru", 10));
        Assert.assertTrue(isElementPresentByText("Relevansi", 10));
    }

    public void validateSerachKeyword() {
        Assert.assertEquals(NewsData.getKeyword(), getTextFromViewByXpath("//android.widget.EditText"));
    }

    public void validateNewsTitleMustContain(String value) {
        String title = getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]").toLowerCase();
        Assert.assertTrue(title.contains(value));
    }

    public void setNewsTitle() {
        NewsData.setNewsTitle(getTextFromViewByXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]"));
    }

    public void tapOnNewsTitle() {
        tapViewWithXpath("(//android.widget.TextView[@content-desc=\"title\"])[1]");
    }

}
