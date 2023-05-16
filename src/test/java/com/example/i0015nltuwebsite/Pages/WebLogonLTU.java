package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

// page_url = https://weblogon.ltu.se/cas/login
public class WebLogonLTU {
    public SelenideElement inputUsername = $("input[id='username']");
    public SelenideElement inputPassword = $("input[id='password']");
    public SelenideElement buttonLogin = $("input.btn-submit");


}
