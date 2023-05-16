package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LTUinstructure {
    public SelenideElement Kurser = $("svg[class='ic-icon-svg ic-icon-svg--courses']");

    public SelenideElement Testavit = $x("//*[text() = 'I0015N, Test av IT-system, Lp4, V23']");


    public SelenideElement myProfile1 = $x("//*[@id='global_nav_profile_link']");
    public SelenideElement logout = $(
            "button[style='margin: 1.5rem 0px 0.5rem; padding: 0px; border-radius: 0.25rem; border-width: 0px; width: auto; cursor: pointer;']");


}
