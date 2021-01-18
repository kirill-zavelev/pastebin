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
        String expectedPaste = PropertyLoader.loadProperty("new.paste");
        String expectedTitle = PropertyLoader.loadProperty("name.title");
        String defaultColor = PropertyLoader.loadProperty("default.color");

        BinCreationPage binCreationPage = new BinCreationPage(driver);
        binCreationPage.fillNewPaste()
            .fillNameTitle()
            .selectPasteExpiration()
            .selectSyntaxHighlighting()
            .clickCreateNewPaste();
        BinPage binPage = new BinPage(driver);
        Assert.assertEquals(binPage.getActualPaste(), expectedPaste, "Expected paste: " + expectedPaste + " wasn't found");
        Assert.assertEquals(binPage.getActualTitle(), expectedTitle, "Expected title: " + expectedTitle + " wasn't found");
        Assert.assertNotEquals(binPage.getColorOfBash(), defaultColor, "Bash has default color: " + defaultColor);
    }
}
