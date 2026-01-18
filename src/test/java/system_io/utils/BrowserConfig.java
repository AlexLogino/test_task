package system_io.utils;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class BrowserConfig {

    public static void configure() {
        switch (RunProfile.resolve()) {
            case LOCAL -> local();
            case CI -> ci();
        }
    }

    private static void local() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--incognito");
        options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));

        Configuration.headless = false;
        Configuration.browserCapabilities = options;

        common();
    }

    private static void ci() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--window-size=1920,1080");
        options.setCapability("goog:loggingPrefs", Map.of("browser", "ALL"));

        Configuration.headless = true;
        Configuration.browserCapabilities = options;

        common();
    }

    private static void common() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = true;
        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.webdriverLogsEnabled = true;
    }
}
