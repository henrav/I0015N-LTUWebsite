package com.example.i0015nltuwebsite.PageTests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.Waiter;
import com.example.i0015nltuwebsite.Config.ConfigConfig;
import com.example.i0015nltuwebsite.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class TranscriptFunctionality {
    LTUStartSida ltuStartSida = new LTUStartSida();
    LTUStudentSida ltuStudentSida = new LTUStudentSida();
    StudentLadokSeStudentAppPage studentLadokSeStudentAppPage = new StudentLadokSeStudentAppPage();
    WebLogonLTU webLogonLTU = new WebLogonLTU();
    StudentLadokSeStudentAppPageStart studentLadokSeStudentAppPageStart = new StudentLadokSeStudentAppPageStart();
    StudentLadokSeStudentAppPageTranscripts studentLadokSeStudentAppPageTranscripts = new StudentLadokSeStudentAppPageTranscripts();



    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }



    @BeforeEach
    public void setUp() {
        // Fix the issue
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.ltu.se/");
    }
    @Test
    public void transcriptFunctionality(){
        ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
        ltuStartSida.linkStudent.shouldBe(visible).click();
        ltuStudentSida.divRegisterUtag.shouldBe(visible).click();
        studentLadokSeStudentAppPage.linkInloggningViaDittRos.shouldBe(visible).click();
        studentLadokSeStudentAppPage.inputSearchinput.shouldBe(visible).setValue(ConfigConfig.getSchoolSearch("schoolsearch"));
        studentLadokSeStudentAppPage.liSelectLuleaUniversityTechnology.shouldBe(visible).click();
        webLogonLTU.inputUsername.shouldBe(visible).setValue(ConfigConfig.getEmail("email"));
        webLogonLTU.inputPassword.shouldBe(visible).setValue(ConfigConfig.getPassword("password"));
        webLogonLTU.buttonLogin.shouldBe(visible).click();
        studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible).click();
        studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible).click();
        studentLadokSeStudentAppPageTranscripts.buttonCreateTranscripts.shouldBe(visible).click();
        studentLadokSeStudentAppPageTranscripts.optionObject.shouldBe(visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible).click();
        studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible).click();
        studentLadokSeStudentAppPageTranscripts.linkOpenDocumentNewWindow.shouldBe(visible).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
