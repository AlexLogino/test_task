package system_io.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static system_io.steps.Router.getRouter;
import static system_io.utils.TestData.BASE_URL;

public class PopUpTest extends BaseTest {

    @Test
    @Description("Popup contains CTA button")
    void testPopupContainsButton() {

        getRouter()
                .openUrl(BASE_URL)
                .basePage.iframePopup.switchToFrame()
                .framePopup.windowPopup.shouldBeVisible()

                .framePopup.buttonCTA.shouldBeVisible();
    }

    @Test
    @Description("Popup can be closed")
    void testPopupClose() {

        step("open url",
                () -> getRouter().openUrl(BASE_URL));
        step("switch to frame Popup",
                () -> getRouter().basePage.iframePopup.switchToFrame());
        step("window Popup should be visible",
                () -> getRouter().framePopup.windowPopup.shouldBeVisible());
        step("click on button ClosePopup",
                () -> getRouter().framePopup.buttonClosePopup.click());
        step("switch to default frame",
                () -> getRouter().switchToDefaultFrame());

        step("window Popup should not be visible",
                () -> getRouter().basePage.iframePopup.shouldNotBeVisible());
    }
}
