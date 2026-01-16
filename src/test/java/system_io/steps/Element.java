package system_io.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import system_io.tests.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Element extends BaseTest {

    private final String locator;

    public Element(String locator) {
        this.locator = locator;
    }

    @Step("element should be visible")
    public Router shouldBeVisible() {
        Selenide.$x(locator).shouldBe(visible);
        return Router.getRouter();
    }

    @Step("switch to frame")
    public Router switchToFrame() {
        switchTo().frame($x(locator).shouldBe(visible));
        return Router.getRouter();
    }

    @Step("click on element")
    public Router click() {
        Selenide.$x(locator).click();
        return Router.getRouter();
    }

    @Step("element should not be visible")
    public Router shouldNotBeVisible() {
        Selenide.$x(locator).shouldNotBe(visible);
        return Router.getRouter();
    }
}

