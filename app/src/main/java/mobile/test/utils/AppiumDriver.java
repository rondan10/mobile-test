package mobile.test.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class AppiumDriver {
    private static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getDriver() throws MalformedURLException {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Android Emulator");
            
            // Actualización de la ruta del APK
            String apkPath = Paths.get(System.getProperty("user.dir"), "app", "saucelabs-app.apk").toString();
            capabilities.setCapability("app", apkPath);
            
            capabilities.setCapability("automationName", "UiAutomator2");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, capabilities);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}