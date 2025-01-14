package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver getDriver(){
        if(driverThreadLocal.get() == null){
            try {
                if(System.getProperty("useBrowserStack") != null) {
                    DesiredCapabilities caps = new DesiredCapabilities();
                    caps.setCapability("browser", "chrome");
                    caps.setCapability("browser_version", "latest");
                    caps.setCapability("os", "Windows");
                    caps.setCapability("os_version", "10");
                    caps.setCapability("name", "BrowserStack Test");

                    driverThreadLocal.set(new RemoteWebDriver(new URL("https://bsuser_PZcs6M:RszxAFsyyrrmAHcV639L@hub-cloud.browserstack.com/wd/hub"), caps));
                } else {
                    String browser = System.getProperty("browser", "chrome");
                    if(browser.equalsIgnoreCase("chrome")) {
                        driverThreadLocal.set(new ChromeDriver());
                    } else if (browser.equalsIgnoreCase("firefox")) {
                        driverThreadLocal.set(new FirefoxDriver());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize WebDriver!");
            }
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }
}
