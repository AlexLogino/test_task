package system_io.steps;

import io.qameta.allure.Step;
import system_io.pages.BasePage;
import system_io.pages.PopupComponent;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class Router {

    private static final Router instance = new Router();

    public PopupComponent framePopup = new PopupComponent();
    public BasePage basePage = new BasePage();

    private Router() {
    }

    public static Router getRouter() {
        return instance;
    }

    @Step("open url")
    public Router openUrl(String url) {
        open(url);
        return this;
    }

    @Step("switch to default frame")
    public Router switchToDefaultFrame() {
        switchTo().defaultContent();
        return this;
    }
}
