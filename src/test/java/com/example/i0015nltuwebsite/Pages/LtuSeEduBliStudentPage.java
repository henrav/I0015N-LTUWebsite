package com.example.i0015nltuwebsite.Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.ltu.se/edu/bli-student/prog/IT
public class LtuSeEduBliStudentPage {
    public SelenideElement linkKandidatexamen = $(byText("\n                                    Systemvetenskap, kandidatexamen \n                                                                    "));

    public SelenideElement divProgramHeader = $(byText("\n                                        Utbildningsplan\n                                        \n                                    "));

    public SelenideElement linkUtbplan = $(byText("\n                    \n                    \n                                                    Utbildningsplan\n                                       ..."));

}