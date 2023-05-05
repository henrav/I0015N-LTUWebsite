package com.example.i0015nltuwebsite.PageTests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import com.example.i0015nltuwebsite.Config.ConfigConfig;
import com.example.i0015nltuwebsite.Pages.*;
import io.qameta.allure.Description;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import java.io.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Tests {
    LTUStartSida ltuStartSida = new LTUStartSida();
    LTUStudentSida ltuStudentSida = new LTUStudentSida();
    StudentLadokSeStudentAppPage studentLadokSeStudentAppPage = new StudentLadokSeStudentAppPage();
    WebLogonLTU webLogonLTU = new WebLogonLTU();
    StudentLadokSeStudentAppPageStart studentLadokSeStudentAppPageStart = new StudentLadokSeStudentAppPageStart();
    StudentLadokSeStudentAppPageTranscripts studentLadokSeStudentAppPageTranscripts = new StudentLadokSeStudentAppPageTranscripts();
    LTUinstructure ltuinstructure = new LTUinstructure();
    LTUinstructureI0015N ltuinstructureI0015N = new LTUinstructureI0015N();
    LTUinstructureI0015Nmoduler ltuinstructureI0015Nmoduler = new LTUinstructureI0015Nmoduler();
    SökResultat sökResultat = new SökResultat();




    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--lang=SWE");
        Configuration.browserSize = "1280-1024";
        Configuration.browserCapabilities = options;
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
            studentLadokSeStudentAppPageTranscripts.buttonCreate.scrollIntoView(true);
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String expectedUrl= "https://www.student.ladok.se/student/app/studentwebb/intyg/skapa-intyg";
            String actualUrl = url();
            Assertions.assertEquals(expectedUrl, actualUrl);
        } catch (ElementNotFound e) {
            throw new RuntimeException(e);
        }
        closeWebDriver();
    }





    @Test
    public void finalExaminationFunctionality() {
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
                File screenshot = Screenshots.takeScreenShotAsFile();
                String directoryPath = "target/screenshots";
                File directory = new File(directoryPath);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                String filnamn = "Final_examination.jpeg";
                File screenshotwithnamn = new File(directoryPath, filnamn);
                try {
                    FileUtils.copyFile(screenshot, screenshotwithnamn);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Tenta är stängd");
            }
        } catch (ElementNotFound e) {
            throw new RuntimeException(e);
        }
        String expectedUrl= "https://ltu.instructure.com/courses/18863/pages/final-examination-information?module_item_id=321907";
        String actualUrl = url();
        Assertions.assertEquals(expectedUrl, actualUrl);
        ltuinstructure.myProfile.shouldBe(visible).click();
        ltuinstructure.logout.shouldBe(visible).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String expectedURLlogout = "https://ltu.instructure.com/logout";
        String actualURLlogout = url();
        Assertions.assertEquals(expectedURLlogout, actualURLlogout);


        closeWebDriver();


    }

    @Test
    public void downloadTranscript() {
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
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        screenshot("transcript.png");
        String expectedUrl= "https://www.student.ladok.se/student/app/studentwebb/intyg";
        String actualUrl = url();
        Assertions.assertEquals(expectedUrl, actualUrl);
        closeWebDriver();
    }


    @Test
    public void courseSyllabus() {
        try {
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).sendKeys(Keys.ENTER);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            ltuStartSida.buttonSearch.shouldBe(visible).click();
            ltuStartSida.inputCludoSearchBar.shouldBe(visible).setValue(ltuStartSida.search);
            ltuStartSida.inputCludoSearchBar.sendKeys(Keys.ENTER);
            sökResultat.h2TestSystemGskolepo.shouldBe(visible).click();
            sökResultat.divDenKursenRiktarSig.shouldBe(visible);
            sökResultat.linkKursplan3.shouldBe(visible).click();
            sökResultat.kursplanV23.shouldBe(visible).click();
            sökResultat.downloadKursplan.shouldBe(visible).click();



            File tjena = sökResultat.downloadKursplan.download();
            String directoryPath = "target/downloads";
            File directory = new File(directoryPath);
            if(!directory.exists()){
                directory.mkdirs();
            }
            String filnamn = "Syllabus.pdf";
            File syllabus = new File(directoryPath, filnamn);
            try {
                FileUtils.copyFile(tjena, syllabus);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            try{
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String expectedUrl= "https://www.ltu.se/edu/course/I00/I0015N/I0015N-Test-av-IT-system-1.81215?kursView=kursplan&termin=V23";
            String actualUrl = url();
            Assertions.assertEquals(expectedUrl, actualUrl);

            closeWebDriver();

        } catch (ElementNotFound | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


