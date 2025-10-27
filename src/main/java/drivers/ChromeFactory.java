package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeFactory extends AbstactDriver{

    private ChromeOptions getOptions() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    @Override
    public WebDriver createDriver() {

        return new ChromeDriver(getOptions());
    }
}
