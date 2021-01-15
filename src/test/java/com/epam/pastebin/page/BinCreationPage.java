package com.epam.pastebin.page;

import com.epam.pastebin.utils.PropertyLoader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BinCreationPage extends AbstractPage {

    private static final String PASTE_EXPIRATION_ITEM = PropertyLoader.loadProperty("expirationDropdown.item");
    private static final String SYNTAX_HIGHLIGHTING_ITEM = PropertyLoader.loadProperty("syntaxHighlighting.item");
    private static final String SCROLL_PAGE_DOWN = PropertyLoader.loadProperty("scroll.page.down");
    private static final String NEW_PASTE_TEXT = PropertyLoader.loadProperty("new.paste");
    private static final String NAME_TITLE_TEXT = PropertyLoader.loadProperty("name.title");

    private static final String a = "a";
    private static final String b = "b";

    @FindBy(id = "postform-text")
    private WebElement newPaste;

    @FindBy(id = "postform-name")
    private WebElement nameTitle;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteBtn;

    @FindBy(xpath = "//span[@data-select2-id='3']")
    private WebElement expirationDropDown;

    @FindBy(xpath = "//span[@data-select2-id='1']")
    private WebElement syntaxHighlightingDropDown;

    public BinCreationPage(WebDriver driver) {
        super(driver);
    }

    public BinCreationPage fillNewPaste() {
        sendKeysWhenInputIntractable(newPaste, NEW_PASTE_TEXT);

        return this;
    }

    public BinCreationPage fillNameTitle() {
        sendKeysWhenInputIntractable(nameTitle, NAME_TITLE_TEXT);

        return this;
    }

    public void expandExpirationDropDown() {
        expirationDropDown.click();
    }

    public void expandSyntaxHighlightingDropDown() {
        syntaxHighlightingDropDown.click();
    }

//    public void expandDropDown(String dropDown) {
//        String expiration = "a";
//        String syntax = "b";
//        switch (dropDown) {
//            case (a):
//                expirationDropDown.click();
//                break;
//            case (b):
//                syntaxHighlightingDropDown.click();
//                break;
//        }
//    }

    public BinCreationPage selectPasteExpiration() {
        expandExpirationDropDown();
        selectItemFromDropdown(PASTE_EXPIRATION_ITEM);

        return this;
    }

    public BinCreationPage selectSyntaxHighlighting() {
        expandSyntaxHighlightingDropDown();
        selectItemFromDropdown(SYNTAX_HIGHLIGHTING_ITEM);

        return this;
    }

    public BinPage clickCreateNewPaste() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(SCROLL_PAGE_DOWN);
        waitForElementToBeClickable(createNewPasteBtn).click();

        return new BinPage(driver);
    }
}
