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

    @FindBy(css = "a.fOyUs_bGBk.fbyHH_bGBk.fbyHH_bSMN")
    public WebElement linkTestSystem2;

    @FindBy(css = "html > body > div:nth-of-type(4) > span > span > div > div > div > div > div > ul:nth-of-type(1) > li:nth-of-type(8) > a")
    public WebElement linkTestSystem3;

    public SelenideElement myProfile = $("button[id*='profile']");
    public SelenideElement myProfile1 = $x("//*[@id='global_nav_profile_link']");
    public SelenideElement logout = $(
            "button[style='margin: 1.5rem 0px 0.5rem; padding: 0px; border-radius: 0.25rem; border-width: 0px; width: auto; cursor: pointer;']");
    @FindBy(css = "button[id*='profile']")
    public WebElement buttonGlobalNavProfileLink;

    @FindBy(css = "button[style='margin: 1.5rem 0px 0.5rem; padding: 0px; border-radius: 0.25rem; border-width: 0px; width: auto; cursor: pointer;']")
    public WebElement buttonLogga;

    @FindBy(css = "a[id*='profile']")
    public WebElement linkGlobalNavProfile;

    @FindBy(xpath = "//*[@id='global_nav_profile_link']")
    public WebElement linkGlobalNavProfile2;

}
