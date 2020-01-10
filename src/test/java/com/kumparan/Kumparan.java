package com.kumparan;

import com.kumparan.pageobject.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Kumparan {

    private final AndroidDriver<AndroidElement> driver;

    public Kumparan(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public PilihKanalPage pilihKanalPage() { return new PilihKanalPage(driver);}

    public MenuPage menuPage() {return new MenuPage(driver);}

    public ForYouPage forYouPage() {return new ForYouPage(driver);}

    public BottomBar bottomBar() {return new BottomBar(driver);}

    public NewsPage newsPage() {return new NewsPage(driver);}

    public CategoryLandingPage categoryLandingPage() {return new CategoryLandingPage(driver);}

    public TrendingLandingPage trendingLandingPage() {return new TrendingLandingPage(driver);}

    public SearchResultPage searchResultPage() {return new SearchResultPage(driver);}

    public LoginPage loginPage() {return new LoginPage(driver);}

    public KomentarPage komentarPage() {return new KomentarPage(driver);}

}
