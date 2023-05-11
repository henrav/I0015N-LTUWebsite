package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.student.ladok.se/student/app/studentwebb/intyg
public class StudentLadokSeStudentAppPageTranscripts {

    public SelenideElement buttonCreateTranscripts = $("button[class$='btn-ladok-brand']");

    public SelenideElement optionObject = $x("//option[@value='2: Object']");

    public SelenideElement linkOpenDocumentNewWindow = $("a.card-link");

    public SelenideElement buttonCreateNewTranscript = $x("//button[contains(@class, 'me-lg-3')]");

}