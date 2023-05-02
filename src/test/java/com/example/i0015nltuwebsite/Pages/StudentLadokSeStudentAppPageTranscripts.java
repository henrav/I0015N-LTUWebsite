package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.student.ladok.se/student/app/studentwebb/intyg
public class StudentLadokSeStudentAppPageTranscripts {
    public SelenideElement buttonCreateTranscripts = $x("//button[@title='Create']");

    public SelenideElement optionObject = $x("//option[@value='2: Object']");

    public SelenideElement buttonCreate2 = $x("//button[contains(@class, 'me-lg-3')]");

    public SelenideElement linkOpenDocumentNewWindow = $x("//a[@class='card-link']");


    public SelenideElement downloadTranscript = $x("//a[@id='download']");



    

}