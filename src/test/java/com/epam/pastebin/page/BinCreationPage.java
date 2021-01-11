package com.epam.pastebin.page;

import com.epam.pastebin.model.Bin;
import com.epam.pastebin.utils.PropertyLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BinCreationPage extends AbstractPage {

    protected static final String PASTE_EXPIRATION_ITEM = PropertyLoader.loadProperty("expirationDropdown.item");
    protected static final String SCROLL_PAGE_DOWN = PropertyLoader.loadProperty("scroll.page.down");

    @FindBy(id = "postform-text")
    private WebElement newPaste;

    @FindBy(id = "postform-name")
    private WebElement nameTitle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteBtn;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement expirationDropDown;

    public BinCreationPage(WebDriver driver) {
        super(driver);
    }

    public BinCreationPage fillNewPaste(Bin bin) {
        sendKeysWhenInputIntractable(newPaste, bin.getNewPaste());

        return this;
    }

    public BinCreationPage fillNameTitle(Bin bin) {
        sendKeysWhenInputIntractable(nameTitle, bin.getNameTitle());

        return this;
    }

    public void expandExpirationDropDown() {
        expirationDropDown.click();
    }

    public BinCreationPage selectPasteExpiration() {
        expandExpirationDropDown();
        selectItemFromDropdown(PASTE_EXPIRATION_ITEM);

        return this;
    }

    public BinPage clickCreateNewPaste() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(SCROLL_PAGE_DOWN);
        waitForElementToBeClickable(createNewPasteBtn).click();

        return new BinPage(driver);
    }
}
