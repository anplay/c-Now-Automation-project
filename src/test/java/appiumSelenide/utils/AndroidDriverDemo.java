package appiumSelenide.utils;

import appiumSelenide.utils.props.GeneralProperties;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.remote.MobileCapabilityType.UDID;


public class AndroidDriverDemo implements WebDriverProvider {
    private final GeneralProperties props = GeneralProperties.getInstance();
    private AppiumServer invokeAppiumServer = new AppiumServer();

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        String appiumUrl = "";

        try {
            appiumUrl = invokeAppiumServer.startAppiumServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        capabilities.setCapability(VERSION, props.getOsVersion());
        capabilities.setCapability(AUTOMATION_NAME, "Appium");
        capabilities.setCapability(PLATFORM_NAME, props.getMobilePlatform());
        capabilities.setCapability(DEVICE_NAME, "Android Test Device");
        capabilities.setCapability(UDID, props.getDeviceId());
        capabilities.setCapability(APP_PACKAGE, "com.reporty.reporty");
        capabilities.setCapability(APP_ACTIVITY, "com.reporty.reporty.activities.SplashActivity");
        capabilities.setCapability(NO_RESET, true);

        try {
            return new AndroidDriver(new URL(appiumUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
