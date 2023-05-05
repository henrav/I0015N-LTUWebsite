package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class LTUinstructureI0015N {
    public SelenideElement linkModuler = $x("//*[text() = 'Moduler']");

    @FindBy(xpath = "//*[text() = 'Moduler']")
    public WebElement linkModuler2;

    @FindBy(css = "html > body > div:nth-of-type(3) > div:nth-of-type(2) > div:nth-of-type(2) > div:nth-of-type(3) > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div:nth-of-type(3) > table > tbody > tr:nth-of-type(6) > td > p > span:nth-of-type(1) > strong > a > span:nth-of-type(1)")
    public WebElement spanKursplsdaanen;

    @FindBy(xpath = "//*[text() = 'kursplanen']")
    public WebElement spanKursplanen2;
    public SelenideElement kursplanen = $x("//*[text() = 'kursplanen']");


}
