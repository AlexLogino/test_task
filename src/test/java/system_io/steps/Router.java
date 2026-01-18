package system_io.steps;

import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system_io.pages.BasePage;
import system_io.pages.PopupComponent;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class Router {

    private static final Logger log = LoggerFactory.getLogger(Router.class);
    private static final Router instance = new Router();

    public PopupComponent framePopup = new PopupComponent();
    public BasePage basePage = new BasePage();

    private Router() {
    }

    public static Router getRouter() {
        return instance;
    }

    @Step("open URL: {url}")
    public Router openUrl(String url) {
        log.info("opening URL: {}", url);
        open(url);
        return this;
    }

    @Step("switch to default frame")
    public Router switchToDefaultFrame() {
        log.info("switch to default frame");
        switchTo().defaultContent();
        return this;
    }
}
