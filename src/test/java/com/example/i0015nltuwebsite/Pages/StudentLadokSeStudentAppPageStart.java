package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.student.ladok.se/student/app/studentwebb/start
public class StudentLadokSeStudentAppPageStart {
    public SelenideElement spanMenu = $x("//span[@class='menytext']");

    public SelenideElement linkAndCertificates = $x("//a[@href='/student/app/studentwebb/intyg']");

}