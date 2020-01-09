package com.kumparan;

import com.kumparan.pageobject.BottomBar;
import com.kumparan.pageobject.ForYouPage;
import com.kumparan.pageobject.MenuPage;
import com.kumparan.pageobject.PilihKanalPage;
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
//
//    public BottomBar bottomBar() { return new BottomBar(driver);}
//
//    public ForYouPage forYouPage() {return new ForYouPage(driver);}
//
//    public MenuPage menuPage() {return new MenuPage(driver);}

}
