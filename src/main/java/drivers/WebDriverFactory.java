package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class WebDriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static WebDriver getDriver(String browser){
        Browser browsertype = Browser.valueOf(browser.toUpperCase());
        AbstactDriver abstactDriver = browsertype.getDriverFactory();
        return abstactDriver.createDriver();
    }

    public static WebDriver initDriver(String browser){

        WebDriver driver = ThreadGuard.protect(getDriver(browser));
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }
    public static WebDriver get() {
        return driverThreadLocal.get();
    }
    public static void quitDriver(){
        driverThreadLocal.get().quit();
    }
}
