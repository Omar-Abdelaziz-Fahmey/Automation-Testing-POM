package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxFactory extends AbstactDriver{
    private FirefoxOptions getOptions() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    @Override
    public WebDriver createDriver() {

        return new FirefoxDriver(getOptions());
    }
}
