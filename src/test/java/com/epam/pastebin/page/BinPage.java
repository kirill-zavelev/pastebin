package com.epam.pastebin.page;

import com.epam.pastebin.model.Bin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BinPage extends AbstractPage {

    public BinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postform-text")
    private WebElement newPaste;

    private static final By NAME_TITLE = By.xpath("//div[@class='info-top']/h1");
    private static final By NEW_PASTE = By.xpath("//div[@class='de1']");

    public Bin getActualBin() {
        Bin actualBin = new Bin();
        actualBin.setNewPaste(driver.findElement(NEW_PASTE).getText());
        actualBin.setNameTitle(driver.findElement(NAME_TITLE).getText());

        return actualBin;
    }
}
