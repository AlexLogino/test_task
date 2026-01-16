package system_io.utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetChromeDriver {

    public static void getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-debugging-port=9222");

        Configuration.browser =
                System.getProperty(
                        "selenide.browser",
                        System.getenv().getOrDefault("SELENIDE_BROWSER", "chrome")
                );

        Configuration.headless = Boolean.parseBoolean(
                System.getProperty(
                        "selenide.headless",
                        System.getenv().getOrDefault("SELENIDE_HEADLESS", "true")
                )
        );

        Configuration.screenshots = true;
        Configuration.timeout = 15000;
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserCapabilities = options;
    }
}
