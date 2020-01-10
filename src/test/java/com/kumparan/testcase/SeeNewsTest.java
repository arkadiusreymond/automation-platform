package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeeNewsTest extends TestInstrument {

    @AfterMethod
    public void goToForYouTab() {
        kumparan.newsPage().goToForYouTab();
    }

    @Test
    public void seeHeadLineNews() {
        kumparan.pilihKanalPage().checkFirstAppLoad();
        kumparan.pilihKanalPage().checkFirstAppLoad();
        kumparan.forYouPage().setHeadlineNewsTitle();
        kumparan.forYouPage().tapOnHeadlineNews();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().validateNewsTitle();
    }

    @Test(priority = 1)
    public void seeNewsOnEntertaimentLandingPage() {
        kumparan.forYouPage().tapOnCategoryTab("Entertainment");
        kumparan.categoryLandingPage().isOnCategoryLandingPage("Entertainment");
        kumparan.categoryLandingPage().setNewsTitle();
        kumparan.categoryLandingPage().tapOnNewsTitle();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().validateNewsTitle();
    }

    @Test(priority = 2)
    public void seeNewsOnTrendingPage() {
        kumparan.forYouPage().tapOnCategoryTab("Trending");
        kumparan.trendingLandingPage().isOnTrendingLandingPage();
        kumparan.trendingLandingPage().tapOnCategoryTab("News");
        kumparan.trendingLandingPage().isOnTrendingLandingPage();
        kumparan.trendingLandingPage().setNewsTitle();
        kumparan.trendingLandingPage().tapOnNewsTitle();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().validateNewsTitle();
    }
    @Test(priority = 3)
    public void seeNewsFromRelatedArticle() {
        kumparan.forYouPage().tapOnHeadlineNews();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().swipeToRelatedNewsTitle();
        kumparan.newsPage().setNewsTitle();
        kumparan.newsPage().tapOnRelatedNewsTitle();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().validateNewsTitle();
    }

    @Test(priority = 4)
    public void seeNewsFromSearch() {
        kumparan.forYouPage().isOnForYouPage();
        kumparan.forYouPage().typeOnSearchBarEditText("buku");
        kumparan.searchResultPage().isOnSearchResultPage();
        kumparan.searchResultPage().validateSerachKeyword();
        kumparan.searchResultPage().validateNewsTitleMustContain("buku");
        kumparan.searchResultPage().setNewsTitle();
        kumparan.searchResultPage().tapOnNewsTitle();
        kumparan.newsPage().isOnNewsPage();
        kumparan.newsPage().validateNewsTitle();
    }
}
