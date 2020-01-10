package com.kumparan.pageobject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class RegisterPage extends BasePage {
    public RegisterPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void isOnRegisterPage() {
        Assert.assertTrue(isElementPresentByXpath("//android.widget.EditText[@text='Email']", 10));
        Assert.assertTrue(isElementPresentByXpath("//android.widget.EditText[@text='Nama']", 10));
    }

    public void typeOnEmailEditText(String value) {
        typeTextWithXpath("//android.widget.EditText[@text='Email']", value);
    }

    public void typeOnNamadEditText(String value) {
        typeTextWithXpath("//android.widget.EditText[@text='Nama']", value);
    }

    public void tapOnDaftarButton() {
        tapViewWithXpath("(//android.widget.TextView[@text='Daftar'])[2]");
    }

    public void isPopUpSuccessShow() {
        Assert.assertTrue(isElementPresentByText("Selamat", 10));
    }

    public void tapButtonOKPopUp() {
        tapViewWithXpath("//android.widget.TextView[@text='Oke']");
    }

    public void validateSnackBarErrorShow() {
        Assert.assertTrue(isElementPresentByText("Email / Nama salah", 3));
    }
}
