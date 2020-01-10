package com.kumparan.pageobject;

import com.kumparan.data.NewsData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnLoginPage() {
        Assert.assertTrue(isElementPresentByText("Gunakan akun media sosialmu untuk mengakses seluruh fitur kumparan", 10));
        Assert.assertTrue(isElementPresentByXpath("(//android.widget.TextView[@text='Login'])[2]", 10));
        Assert.assertTrue(isElementPresentByText("Email", 10));
        Assert.assertTrue(isElementPresentByText("Password", 10));
    }

    public void typeOnUsernameEditText(String value) {
        typeTextWithXpath("//android.widget.EditText[@text='Email']", value);
    }

    public void typeOnPasswordEditText(String value) {
        typeTextWithXpath("//android.widget.EditText[@text='Password']", value);
    }

    public void tapOnLoginButton() {
        tapViewWithXpath("(//android.widget.TextView[@text='Login'])[2]");
    }

    public void validateSnackBarErrorShow() {
        Assert.assertTrue(isElementPresentByText("Email / Password salah", 3));
    }

    public void login(String username, String password) {
        typeOnUsernameEditText(username);
        typeOnPasswordEditText(password);
        tapOnLoginButton();
    }
}
