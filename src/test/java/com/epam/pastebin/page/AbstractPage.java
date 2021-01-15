package com.epam.pastebin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    protected static final int TIME_OUT = 3;

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIME_OUT);
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void sendKeysWhenInputIntractable(WebElement element, String text) {
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void selectItemFromDropdown(String dropDownItem) {
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//li[@role='option']"));
        dropDownOptions
                .stream()
                .filter(opt -> opt.getText().equals(dropDownItem))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
