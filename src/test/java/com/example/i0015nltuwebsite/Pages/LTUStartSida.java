package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.ltu.se/
public class LTUStartSida {

        public SelenideElement buttonCybotCookiebotDialogBody = $(
                        "button[id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']");

        public SelenideElement linkStudent = $(
                        "html > body > header > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(3) > div > a:nth-of-type(1)");

        public SelenideElement linkUtbildning = $(byText("Utbildning"));

        public SelenideElement linkDataOchElektronik = $(byText("Data, IT och elektronik "));

        public SelenideElement liUtbildning = $(
                        "html > body > header > div:nth-of-type(2) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > nav > ul > li:nth-of-type(1)");

        public SelenideElement divMissat = $(
                        "html > body > main > div > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div > div > div > div");

        public String search = "I0015N";

        public SelenideElement buttonSearch = $("button[class='button is-medium ltu-search-btn']");

        public SelenideElement inputCludoSearchBar = $("input[id='cludo-search-bar-input']");

}
