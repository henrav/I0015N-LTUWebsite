package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LTUinstructure {
    public SelenideElement Kurser = $("svg[class='ic-icon-svg ic-icon-svg--courses']");

    public SelenideElement Testavit = $x("//*[text() = 'I0015N, Test av IT-system, Lp4, V23']");

    @FindBy(xpath = "//*[text() = 'I0015N, Test av IT-system, Lp4, V23']")
    public WebElement linkTestSystem;

   


    
    
    


}
