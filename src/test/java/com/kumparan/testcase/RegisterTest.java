package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegisterTest extends TestInstrument {
    int randomNum = (int) (Math.random() * 1000);

    @AfterMethod
    public void goToForYouTab() {
        kumparan.newsPage().goToForYouTab();
    }

    @Test
    public void registerUser() {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().typeOnEmailEditText("emailemail"+randomNum+"@gmail.com");
        kumparan.registerPage().typeOnNamadEditText("namanama"+randomNum);
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().isPopUpSuccessShow();
        kumparan.registerPage().tapButtonOKPopUp();
        kumparan.verifikasiPage().isOnVerifikasiPage();
    }

    @Test(priority = 1)
    public void registerUserEmptyEmail() {
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().typeOnNamadEditText("namanama"+randomNum);
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().validateSnackBarErrorShow();
    }

    @Test(priority = 2)
    public void registerUserEmptyName() {
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().typeOnEmailEditText("emailemail"+randomNum+"@gmail.com");
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().validateSnackBarErrorShow();
    }

    @Test(priority = 3)
    public void registerUserEmpty() {
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().validateSnackBarErrorShow();
    }

    @Test(priority = 3)
    public void registerUserInvalidEmail() {
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().typeOnEmailEditText("emailemail#$%^&*1172727");
        kumparan.registerPage().typeOnNamadEditText("namanama"+randomNum);
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().validateSnackBarErrorShow();
    }

    @Test(priority = 4)
    public void registerUserLongName() {
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnDaftarSekarang();
        kumparan.registerPage().isOnRegisterPage();
        kumparan.registerPage().typeOnEmailEditText("emailemail"+randomNum+"@gmail.com");
        kumparan.registerPage().typeOnNamadEditText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
                "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."+randomNum);
        kumparan.registerPage().tapOnDaftarButton();
        kumparan.registerPage().validateSnackBarErrorShow();
    }
}
