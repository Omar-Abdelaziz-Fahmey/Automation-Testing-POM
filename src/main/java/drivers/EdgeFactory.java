package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeFactory extends AbstactDriver {
    private EdgeOptions getOptions() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        return options;
    }

    @Override
    public WebDriver createDriver() {

        return new EdgeDriver(getOptions());
    }
}
