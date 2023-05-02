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

}
