package com.epam.pastebin.test;

import com.epam.pastebin.driver.DriverSetup;
import com.epam.pastebin.page.BinCreationPage;
import com.epam.pastebin.page.BinPage;
import com.epam.pastebin.utils.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinTest extends DriverSetup {

    @Test
    public void createNewBin() {
        String defaultColor = PropertyLoader.loadProperty("default.color");
        BinCreationPage binCreationPage = new BinCreationPage(driver);
        String expectedNewPaste = binCreationPage.fillNewPaste()
                .getNewPasteText();
        String expectedNameTitle = binCreationPage.fillNameTitle()
                .getNameTitleText();
        binCreationPage.selectPasteExpiration()
                .selectSyntaxHighlighting()
                .clickCreateNewPaste();
        BinPage binPage = new BinPage(driver);
        Assert.assertEquals(binPage.getActualPaste(), expectedNewPaste, "Expected paste: " + expectedNewPaste + " wasn't found");
        Assert.assertEquals(binPage.getActualTitle(), expectedNameTitle, "Expected title: " + expectedNameTitle + " wasn't found");
        Assert.assertNotEquals(binPage.getColorOfBash(), defaultColor, "Bash has default color: " + defaultColor);
    }
}
