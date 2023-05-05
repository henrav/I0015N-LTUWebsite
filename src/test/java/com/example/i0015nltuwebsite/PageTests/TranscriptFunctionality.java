package com.example.i0015nltuwebsite.PageTests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import com.codeborne.selenide.ex.TimeoutException;
import com.example.i0015nltuwebsite.Config.ConfigConfig;
import com.example.i0015nltuwebsite.Pages.*;
import com.example.i0015nltuwebsite.WindowsEventLogHandler;
import io.qameta.allure.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

import java.util.logging.Level;
import java.util.logging.Logger;

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

    private static final Logger LOGGER = Logger.getLogger(TranscriptFunctionality.class.getName());


    @BeforeAll
    public static void setUpAll() {
        LOGGER.info("Starting test suite");
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 10000;
        LOGGER.addHandler(new WindowsEventLogHandler());
        LOGGER.setLevel(Level.ALL);

    }


    @BeforeEach
    public void setUp(TestInfo testInfo) {
        // Fix the issue
        //Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        String methodName = testInfo.getDisplayName();
        LOGGER.info("Starting test for method: " + methodName);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--lang=en-US");

        Configuration.browserCapabilities = chromeOptions;
        open("https://www.ltu.se/");

    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        String methodName = testInfo.getDisplayName();
        LOGGER.info("Ending test for method: " + methodName);
    }

    @Test
    @Description("Test transcript functionality")
    public void transcriptFunctionality() {
        try {
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuStartSida.linkStudent.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuStudentSida.divRegisterUtag.shouldBe(visible, Duration.ofSeconds(10)).click();

            studentLadokSeStudentAppPage.linkInloggningViaDittRos.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPage.inputSearchinput.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getSchoolSearch("schoolsearch"));
            studentLadokSeStudentAppPage.liSelectLuleaUniversityTechnology.shouldBe(visible, Duration.ofSeconds(10)).click();

            webLogonLTU.inputUsername.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible, Duration.ofSeconds(10)).click();

            studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPageTranscripts.buttonCreateTranscripts.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPageTranscripts.optionObject.shouldBe(visible, Duration.ofSeconds(10)).click();
            //studentLadokSeStudentAppPageTranscripts.buttonCreateNewTranscript.shouldBe(visible, Duration.ofSeconds(10)).click();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                LOGGER.warning("Unexpected error: " + e.getMessage());
            }
            closeWebDriver();
        } catch (ElementNotFound e) {
            LOGGER.warning("Element not found: " + e.getMessage());
            throw e;
        } catch (ElementShould e) {
            LOGGER.warning("Element should condition failed: " + e.getMessage());
            throw e;
        } catch (TimeoutException e) {
            LOGGER.warning("Timeout occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
            throw e;
        }
        LOGGER.info("Closing the browser");
        closeWebDriver();
    }

    @Test
    public void finalExaminationFunctionality() {
        try {
            LOGGER.info("Trying to find the final examination date");
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
            ltuStartSida.linkStudent.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuStudentSida.divLoggaCanvas.shouldBe(visible, Duration.ofSeconds(10)).click();

            webLogonLTU.inputUsername.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible, Duration.ofSeconds(10)).click();

            ltuinstructure.Kurser.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuinstructure.Testavit.shouldBe(visible, Duration.ofSeconds(10)).click();

            ltuinstructureI0015N.linkModuler.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuinstructureI0015Nmoduler.linkModuler.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuinstructureI0015Nmoduler.textOmTenta.shouldBe(visible, Duration.ofSeconds(10));

            if (ltuinstructureI0015Nmoduler.textOmTenta.getText().contains("Final Examination Information")) {
                screenshot("tentainfo.png");
                LOGGER.info("Examination date found");
            } else {
                LOGGER.warning("Examination date was not found");
            }
        } catch (ElementNotFound e) {
            LOGGER.warning("Element not found: " + e.getMessage());
            throw e;
        } catch (ElementShould e) {
            LOGGER.warning("Element should condition failed: " + e.getMessage());
            throw e;
        } catch (TimeoutException e) {
            LOGGER.warning("Timeout occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
            throw e;
        }
        LOGGER.info("Closing the browser");
        closeWebDriver();


    }

    @Test
    public void downloadTranscript() {
        try {
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuStartSida.linkStudent.shouldBe(visible, Duration.ofSeconds(10)).click();
            ltuStudentSida.divRegisterUtag.shouldBe(visible, Duration.ofSeconds(10)).click();

            studentLadokSeStudentAppPage.linkInloggningViaDittRos.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPage.inputSearchinput.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getSchoolSearch("schoolsearch"));
            studentLadokSeStudentAppPage.liSelectLuleaUniversityTechnology.shouldBe(visible, Duration.ofSeconds(10)).click();

            webLogonLTU.inputUsername.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible, Duration.ofSeconds(10)).setValue(ConfigConfig.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible, Duration.ofSeconds(10)).click();

            studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible, Duration.ofSeconds(10)).click();
            studentLadokSeStudentAppPageTranscripts.linkOpenDocumentNewWindow.shouldBe(visible, Duration.ofSeconds(10)).click();
            LOGGER.info("Downloading transcript...");

        } catch (ElementNotFound e) {
            LOGGER.warning("Element not found: " + e.getMessage());
            throw e;
        } catch (ElementShould e) {
            LOGGER.warning("Element should condition failed: " + e.getMessage());
            throw e;
        } catch (TimeoutException e) {
            LOGGER.warning("Timeout occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
            throw e;
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
        }
        LOGGER.info("Download completed");
        LOGGER.info("Closing the browser");
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

            ltuStartSida.divMissat.shouldBe(visible).click();

            ltuSeEduBliStudentPage.datorITlänk.shouldBe(visible).click();
            ltuSeEduBliStudentPage.Systemvetenskap.shouldBe(visible).click();
            ltuSeEduBliStudentPage.syllabus.shouldBe(visible).click();
            ltuSeEduBliStudentPage.downloadSyllabus.shouldBe(visible).click();
            LOGGER.info("Downloading syllabus...");
        } catch (ElementNotFound e) {
            LOGGER.warning("Element not found: " + e.getMessage());
            throw e;
        } catch (ElementShould e) {
            LOGGER.warning("Element should condition failed: " + e.getMessage());
            throw e;
        } catch (TimeoutException e) {
            LOGGER.warning("Timeout occurred: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
            throw e;
        }
        try {
            Thread.sleep(9000);
            Thread.sleep(4000);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            LOGGER.warning("Unexpected error: " + e.getMessage());
        }
        LOGGER.info("Download completed");
        LOGGER.info("Closing the browser");
        closeWebDriver();

    }
}
