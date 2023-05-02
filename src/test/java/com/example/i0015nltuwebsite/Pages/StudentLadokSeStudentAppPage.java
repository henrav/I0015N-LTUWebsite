package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.student.ladok.se/student/app/studentwebb/
public class StudentLadokSeStudentAppPage {
    public SelenideElement linkInloggningViaDittRos = $("a[class$='btn-ladok-inloggning']");

    public SelenideElement inputSearchinput = $("input[id='searchinput']");

    public SelenideElement liSelectLuleaUniversityTechnology = $("li");

    
}