package com.epam.pastebin.test;

import com.epam.pastebin.driver.DriverSetup;
import com.epam.pastebin.model.Bin;
import com.epam.pastebin.page.BinCreationPage;
import com.epam.pastebin.page.BinPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinTest extends DriverSetup {

    @Test
    public void createNewBin() {
        BinCreationPage binCreationPage = new BinCreationPage(driver);
        Bin expectedBin = new Bin();
        binCreationPage.fillNewPaste(expectedBin)
                .fillNameTitle(expectedBin)
                .selectPasteExpiration()
                .clickCreateNewPaste();
        BinPage binPage = new BinPage(driver);
        Bin actualBin = binPage.getActualBin();
        Assert.assertEquals(actualBin, expectedBin, "Expected bin wasn't found");
    }
}
