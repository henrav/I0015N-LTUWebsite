package com.example.i0015nltuwebsite.PageTests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.impl.Waiter;
import com.codeborne.selenide.logevents.ErrorsCollector;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.SelenideLog;
import com.example.i0015nltuwebsite.Config.ConfigConfig;
import com.example.i0015nltuwebsite.Pages.*;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TranscriptFunctionality {
    LTUStartSida ltuStartSida = new LTUStartSida();
    LTUStudentSida ltuStudentSida = new LTUStudentSida();
    StudentLadokSeStudentAppPage studentLadokSeStudentAppPage = new StudentLadokSeStudentAppPage();
    WebLogonLTU webLogonLTU = new WebLogonLTU();
    StudentLadokSeStudentAppPageStart studentLadokSeStudentAppPageStart = new StudentLadokSeStudentAppPageStart();
    StudentLadokSeStudentAppPageTranscripts studentLadokSeStudentAppPageTranscripts = new StudentLadokSeStudentAppPageTranscripts();
    LTUinstructure ltuinstructure = new LTUinstructure();
    LTUinstructureI0015N ltuinstructureI0015N = new LTUinstructureI0015N();
    LTUinstructureI0015Nmoduler ltuinstructureI0015Nmoduler = new LTUinstructureI0015Nmoduler();
    LtuSeEduBliStudentPage ltuSeEduBliStudentPage = new LtuSeEduBliStudentPage();




    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 10000;

    }


    @BeforeEach
    public void setUp() {
        // Fix the issue
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.ltu.se/");
    }
    @Test
    @Description("Test transcript functionality")
    public void transcriptFunctionality() {
        try {
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
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            closeWebDriver();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void finalExaminationFunctionality(){
        try {
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
            ltuStartSida.linkStudent.shouldBe(visible).click();
            ltuStudentSida.divLoggaCanvas.shouldBe(visible).click();
            webLogonLTU.inputUsername.shouldBe(visible).setValue(ConfigConfig.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible).setValue(ConfigConfig.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible).click();
            ltuinstructure.Kurser.shouldBe(visible).click();
            ltuinstructure.Testavit.shouldBe(visible).click();
            ltuinstructureI0015N.linkModuler.shouldBe(visible).click();
            ltuinstructureI0015Nmoduler.linkModuler.shouldBe(visible).click();
            ltuinstructureI0015Nmoduler.textOmTenta.shouldBe(visible);
            if (ltuinstructureI0015Nmoduler.textOmTenta.getText().contains("Final Examination Information")) {
                screenshot("tentainfo.png");
                System.out.println("Tenta är öppen");
            } else {
                System.out.println("Tenta är stängd");
            }
        } catch (ElementNotFound e) {
            throw new RuntimeException(e);
        }
        closeWebDriver();


    }
    @Test
    public void downloadTranscript(){
        try {
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
            studentLadokSeStudentAppPageTranscripts.linkOpenDocumentNewWindow.shouldBe(visible).click();
        } catch (ElementNotFound e) {
            throw new RuntimeException(e);
        }
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        closeWebDriver();
    }


    @Test
    public void courseSyllabus(){
        try{
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).sendKeys(Keys.ENTER);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ltuStartSida.divMissat.shouldBe(visible).click();
            ltuSeEduBliStudentPage.datorITlänk.shouldBe(visible).click();
            ltuSeEduBliStudentPage.Systemvetenskap.shouldBe(visible).click();
            ltuSeEduBliStudentPage.syllabus.shouldBe(visible).click();
            ltuSeEduBliStudentPage.downloadSyllabus.shouldBe(visible).click();
        } catch (ElementNotFound e) {
            throw new RuntimeException(e);
        }
        try{
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        closeWebDriver();

    }
}
