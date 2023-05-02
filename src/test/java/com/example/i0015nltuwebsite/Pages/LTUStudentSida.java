package com.example.i0015nltuwebsite.Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.ltu.se/student
public class LTUStudentSida {

    public SelenideElement Cookies = $("button[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");
    public SelenideElement divLoggaCanvas = $("html > body > main > div > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div > div > ul > li:nth-of-type(4) > a > div");
    public SelenideElement divRegisterUtag = $("html > body > main > div > div > div:nth-of-type(1) > div > div:nth-of-type(2) > div > div > div > div > ul > li:nth-of-type(1) > a > div");




}
