package system_io.pages;

import system_io.steps.Element;

public class BasePage {

    public Element iframePopup =
            new Element("//iframe[contains(@id,'systemeio-iframe')]");
}
