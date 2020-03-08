package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

    private WebDriver createDriver() {
        switch (environmentType) {

            case LOCAL: {
                driver = createLocalDriver();
                break;
            }

            case REMOTE: {
                driver = createRemoteDriver();
                break;
            }
        }

        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX: {
                driver = new FirefoxDriver();
                break;
            }

            case CHROME: {
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            }

            case INTERNETEXPLORER: {
                driver = new InternetExplorerDriver();
                break;
            }
        }

        if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
        }

        return driver;
    }


    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }
}
