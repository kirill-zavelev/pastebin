package com.epam.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class BinPage extends AbstractPage {

    public BinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postform-text")
    private WebElement newPaste;

    private static final By NAME_TITLE = By.xpath("//div[@class='info-top']/h1");
    private static final By NEW_PASTE = By.xpath("//ol[@class='bash']");

    public String getActualPaste() {
//        Bin actualBin = new Bin();
        return driver.findElement(NEW_PASTE).getText();
    }

    public String getActualTitle() {
//        Bin actualBin = new Bin();
        return driver.findElement(NAME_TITLE).getText();
    }
}
