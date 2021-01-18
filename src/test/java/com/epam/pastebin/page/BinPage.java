package com.epam.pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BinPage extends AbstractPage {

    public BinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement newPaste;

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement nameTitle;

    public String getActualPaste() {
        return newPaste.getText();
    }

    public String getActualTitle() {
        return nameTitle.getText();
    }

    public String getColorOfBash() {
        return getColorOfWebElement(newPaste);
    }
}
