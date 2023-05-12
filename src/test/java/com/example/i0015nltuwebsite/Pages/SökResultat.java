package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SökResultat {
    public SelenideElement h2TestSystemGskolepo = $("a[class='courseTitle'] h2");

    public SelenideElement linkKursplan = $(
            "html > body > main > div > div > div > div:nth-of-type(1) > nav > div:nth-of-type(1) > ul > li:nth-of-type(1) > a");

    public SelenideElement kursplanV23 = $(byText("V23"));

    public SelenideElement divDenKursenRiktarSig = $("div[class$='ingress'] div[class='epok-paragraph']");

    public SelenideElement linkKursplan3 = $(
            "html > body > main > div > div > div > div:nth-of-type(1) > nav > div:nth-of-type(1) > ul > li:nth-of-type(1) > a");

    public SelenideElement downloadKursplan = $("a.utbplan-pdf-link");

}
