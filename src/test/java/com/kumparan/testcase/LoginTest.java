package com.kumparan.testcase;

import com.kumparan.TestInstrument;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class LoginTest extends TestInstrument {

    @AfterMethod
    public void resetApp() {
        kumparan.forYouPage().resetApp();
        kumparan.forYouPage().delay(3000);
    }

    @Test
    public void loginWithUserNameAndPassword()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().login("nanmaidabunanmaidabu@gmail.com", "mantanqwerty");
        kumparan.menuPage().isOnMenuPageAfterLogin();
    }

    @Test(priority = 1)
    public void loginWithUserNameAndEmptyPassword()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().typeOnUsernameEditText("nanmaidabunanmaidabu@gmail.com");
        kumparan.loginPage().tapOnLoginButton();
        kumparan.loginPage().validateSnackBarErrorShow();
    }

    @Test(priority = 2)
    public void loginWithEmptyUserNameAndPassword()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().typeOnPasswordEditText("mantanqwerty");
        kumparan.loginPage().tapOnLoginButton();
        kumparan.loginPage().validateSnackBarErrorShow();
    }

    @Test(priority = 3)
    public void loginWithEmptyUserNameAndEmptyPassword()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().tapOnLoginButton();
        kumparan.loginPage().validateSnackBarErrorShow();
    }

    @Test(priority = 4)
    public void loginWithWrongUsernamePassword()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().clearCache();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageAfterClearCache();
        kumparan.menuPage().tapOnLoginMenu();
        kumparan.loginPage().isOnLoginPage();
        kumparan.loginPage().login("dfgsgfsdg", "sdfsd");
        kumparan.loginPage().tapOnLoginButton();
        kumparan.loginPage().validateSnackBarErrorShow();
    }

    @Test(priority = 5)
    public void loginGoogleTest()  {
        kumparan.forYouPage().resetApp();
        kumparan.forYouPage().delay(3000);
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().isOnForYouPage();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageBeforeLoginFirstInstall();
        kumparan.menuPage().tapOnGooleButton();
        kumparan.menuPage().isPopUpGoogleShow();
        kumparan.menuPage().tapOnEmailTextView();
        kumparan.menuPage().isOnMenuPageAfterLogin();
    }

    @Test(priority = 6)
    public void loginFacebookTest()  {
        kumparan.forYouPage().checkFirstAppLoad();
        kumparan.forYouPage().isOnForYouPage();
        kumparan.bottomBar().tapOnMenuBottomBar();
        kumparan.menuPage().isOnMenuPageBeforeLoginFirstInstall();
        kumparan.menuPage().tapOnFacebookButton();
        kumparan.menuPage().isOnMenuPageAfterLogin();
    }
}