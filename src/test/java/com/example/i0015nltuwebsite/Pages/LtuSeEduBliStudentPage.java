package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.ltu.se/edu/bli-student/prog/IT
public class LtuSeEduBliStudentPage {
    public SelenideElement datorITlänk = $("html > body > main > div > div > div > div:nth-of-type(1) > nav > div > ul > li:nth-of-type(1) > ul > li:nth-of-type(4)");

    public SelenideElement Systemvetenskap = $("html > body > main > div > div > div > div:nth-of-type(1) > nav > div > ul > li:nth-of-type(7)");

    public SelenideElement syllabus = $("div[class='utbplan-puff'] a");

    public SelenideElement downloadSyllabus = $("a[class='utbplan-pdf-link']");
    
    
    
    

    
    

    
    



}