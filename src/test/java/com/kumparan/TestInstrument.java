package com.kumparan;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.util.Objects;

public class TestInstrument {
    private static AppiumDriverLocalService service;
    protected static AndroidDriver<AndroidElement> driver;
    protected static Kumparan kumparan;

    @BeforeSuite
    public void beforeSuite() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
        service = AppiumDriverLocalService.buildService(builder);
        if (service == null || !service.isRunning()) {
            System.out.println("Starting Appium Server!");
            service.stop();
            service.start();
        }

        File appDir = new File("/Users/" + System.getProperty("user.name") + "/automation-platform/");
        File app = new File(appDir, Objects.requireNonNull("kumparan.apk"));
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        capabilities.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 240000);
        capabilities.setCapability("uiautomator2ServerInstallTimeout", 240000);
        capabilities.setCapability("uiautomator2ServerLaunchTimeout", 240000);

        driver = new AndroidDriver<>(service.getUrl(), capabilities);
        kumparan = new Kumparan(driver);
    }

    @BeforeClass
    public void beforeClass() {
        kumparan.forYouPage().resetApp();
        kumparan.forYouPage().delay(3000);
    }



    @AfterSuite
    public void afterSuite() {
        // Stop the appium server and close app
        if (service != null && driver != null) {
            driver.quit();
            service.stop();
        }
    }
}