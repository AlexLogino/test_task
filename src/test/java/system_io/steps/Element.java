package system_io.steps;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system_io.tests.BaseTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class Element extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(Router.class);

    private final String locator;

    public Element(String locator) {
        this.locator = locator;
    }

    @Step("element should be visible")
    public Router shouldBeVisible() {
        log.info("element '{}' should be visible", locator);
        Selenide.$x(locator).shouldBe(visible);
        return Router.getRouter();
    }

    @Step("switch to frame")
    public Router switchToFrame() {
        log.info("switch to frame '{}'", locator);
        switchTo().frame($x(locator).shouldBe(visible));
        return Router.getRouter();
    }

    @Step("click on element")
    public Router click() {
        log.info("click on element '{}'", locator);
        Selenide.$x(locator).click();
        return Router.getRouter();
    }

    @Step("element should not be visible")
    public Router shouldNotBeVisible() {
        log.info("element '{}' should not be visible", locator);
        Selenide.$x(locator).shouldNotBe(visible);
        return Router.getRouter();
    }
}

