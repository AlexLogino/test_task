package system_io.pages;

import system_io.steps.Element;

public class PopupComponent {

    public Element windowPopup =
            new Element("//div[@id='app']/div[./div/button[@data-testid='popup-close-icon']]");
    public Element buttonCTA =
            new Element("//button[./div[text()='I want to receive my copy ']]");
    public Element buttonClosePopup =
            new Element("//button[@data-testid='popup-close-icon']");
}
