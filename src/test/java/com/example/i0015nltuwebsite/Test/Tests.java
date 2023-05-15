package com.example.i0015nltuwebsite.Test;

import com.codeborne.selenide.*;
import com.codeborne.selenide.ex.ElementNotFound;
import com.example.i0015nltuwebsite.Config.Config;
import com.example.i0015nltuwebsite.Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println("Setting up the tests");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("video", true);
        Configuration.browser = "chrome";
        ChromeOptions options = new ChromeOptions();
        Configuration.downloadsFolder = "newDownloadsFolder";
        options.addArguments("--lang=en");
        Configuration.browserSize = "1280x1024";
        Configuration.browserCapabilities = options;
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.timeout = 10000;

    }

    @AfterAll
    public static void tearDownAll() throws IOException {
        Path directory = Path.of("newDownloadsFolder");
        if (Files.exists(directory)) {
            Files.walk(directory)
                    .sorted((path1, path2) -> -path1.compareTo(path2)) // sort in reverse order
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            System.err.println("Failed to delete " + path + ": " + e.getMessage());
                        }
                    });
        }
        System.out.println("All tests are done");
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");

        open("https://www.ltu.se/");
    }

    //@Disabled("Do not want to create a new transcript every time")
    @Test
    public void transcriptFunctionality() {
        try {
            // Click cookies and navigate to ladok link and page
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
            ltuStartSida.linkStudent.shouldBe(visible).click();
            ltuStudentSida.divRegisterUtag.shouldBe(visible).click();
            System.out.println("Navigated to ladok successfully");

            // Select Luleå University of Technology as school
            studentLadokSeStudentAppPage.linkInloggningViaDittRos.shouldBe(visible).click();
            studentLadokSeStudentAppPage.inputSearchinput.shouldBe(visible)
                    .setValue(Config.getSchoolSearch("schoolsearch"));
            studentLadokSeStudentAppPage.liSelectLuleaUniversityTechnology.shouldBe(visible).click();
            System.out.println("Selected Luleå University of Technology as the school successfully");

            // Login to ladok
            webLogonLTU.inputUsername.shouldBe(visible).setValue(Config.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible).setValue(Config.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible).click();
            System.out.println("Logged in to ladok successfully");

            // Navigate to transcripts
            studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible).click();
            studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible).click();
            System.out.println("Navigated to transcripts successfully");

            // Create new transcript, and select options
            studentLadokSeStudentAppPageTranscripts.buttonCreateTranscripts.shouldBe(visible).click();
            studentLadokSeStudentAppPageTranscripts.optionObject.shouldBe(visible).click();
            studentLadokSeStudentAppPageTranscripts.buttonCreateNewTranscript.scrollIntoView(true);
            System.out.println("Filled in all transcript options successfully");

            // THIS LINE CREATES THE NEW TRANSCRIPT, 
            studentLadokSeStudentAppPageTranscripts.buttonCreateNewTranscript.shouldBe(visible).click();

            // Give time for the transcript to be created
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted exception while waiting: " + e.getMessage());
                Thread.currentThread().interrupt();
            }

            // Only works if you also create a new transcript, otherwise actualUrl will be
            // different
            String expectedUrl = "https://www.student.ladok.se/student/app/studentwebb/intyg";
            String actualUrl = url();
            Assertions.assertEquals(expectedUrl, actualUrl);

        } catch (ElementNotFound e) {
            System.err.println("Element not found: " + e.getMessage());
        }
        closeWebDriver();

    }

    @Test
    public void finalExaminationFunctionality() {
        try {
            // Click cookies and navigate to login page
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
            ltuStartSida.linkStudent.shouldBe(visible).click();
            ltuStudentSida.divLoggaCanvas.shouldBe(visible).click();
            System.out.println("Navigated to the student Canvas page successfully.");

            // Login to account
            webLogonLTU.inputUsername.shouldBe(visible).setValue(Config.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible).setValue(Config.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible).click();
            System.out.println("Logged in successfully.");

            // Navigate to the course page
            ltuinstructure.Kurser.shouldBe(visible).click();
            Selenide.executeJavaScript("arguments[0].click();", ltuinstructure.Testavit.shouldBe(visible));
            System.out.println("Course and test link clicked successfully.");

            // Navigate to the module page
            ltuinstructureI0015N.linkModuler.shouldBe(visible).click();
            ltuinstructureI0015Nmoduler.linkModuler.shouldBe(visible).click();
            ltuinstructureI0015Nmoduler.textOmTenta.shouldBe(visible);

            // Check if information regarding exam was found, if so take a screenshot and
            // print date and time
            Assertions.assertTrue(
                    ltuinstructureI0015Nmoduler.textOmTenta.getText().contains("Final Examination Information"),
                    "Examination text does not contain 'Final Examination Information'.");
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
                    System.out.println("Final Examination Information found and screenshot captured.");
                } catch (IOException e) {
                    System.err.println("Error occurred while copying the screenshot: " + e.getMessage());
                    throw new RuntimeException(e);
                }

                // Extract date and time
                String text = ltuinstructureI0015Nmoduler.textOmTenta.getText();
                Pattern pattern = Pattern.compile(
                        "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday),\\s\\w+\\s\\d{1,2}(st|nd|rd|th),\\sfrom\\s\\d{1,2}:\\d{2}\\s-\\s\\d{1,2}:\\d{2}");
                Matcher matcher = pattern.matcher(text);
                if (matcher.find()) {
                    String dateTime = matcher.group();
                    System.out.println("Date and time found: " + dateTime);
                    System.out.println(dateTime);
                } else {
                    System.out.println("Date and time not found.");
                }

            } else {
                System.out.println("Final Examination Information not found.");
            }

        } catch (ElementNotFound e) {
            System.err.println("Failed to find element: " + e.getMessage());
            throw new RuntimeException(e);
        }

        String expectedUrl = "https://ltu.instructure.com/courses/18863/pages/final-examination-information?module_item_id=321907";
        String actualUrl = url();
        Assertions.assertEquals(expectedUrl, actualUrl,
                "Failed to navigate to the expected URL after clicking the test link.");

        ltuinstructure.myProfile1.shouldBe(visible).click();
        ltuinstructure.logout.shouldBe(visible).click();
        System.out.println("Logged out successfully.");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        String expectedURLlogout = "https://ltu.instructure.com/logout";
        String actualURLlogout = url();
        Assertions.assertEquals(expectedURLlogout, actualURLlogout,
                "Failed to navigate to the logout URL after clicking the logout link.");

        closeWebDriver();
    }

    @Test
    public void downloadTranscript() {
        try {
            // Click cookies and navigate to ladok link and page
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();
            ltuStartSida.linkStudent.shouldBe(visible).click();
            ltuStudentSida.divRegisterUtag.shouldBe(visible).click();
            System.out.println("Navigated to ladok successfully");

            // Select Luleå University of Technology as school
            studentLadokSeStudentAppPage.linkInloggningViaDittRos.shouldBe(visible).click();
            studentLadokSeStudentAppPage.inputSearchinput.shouldBe(visible)
                    .setValue(Config.getSchoolSearch("schoolsearch"));
            studentLadokSeStudentAppPage.liSelectLuleaUniversityTechnology.shouldBe(visible).click();
            System.out.println("Selected Luleå University of Technology as the school successfully");

            // Login to ladok
            webLogonLTU.inputUsername.shouldBe(visible).setValue(Config.getEmail("email"));
            webLogonLTU.inputPassword.shouldBe(visible).setValue(Config.getPassword("password"));
            webLogonLTU.buttonLogin.shouldBe(visible).click();
            System.out.println("Logged in to ladok successfully");

            // Navigate to transcripts
            studentLadokSeStudentAppPageStart.spanMenu.shouldBe(visible).click();
            studentLadokSeStudentAppPageStart.linkAndCertificates.shouldBe(visible).click();
            System.out.println("Navigated to transcripts successfully");

            // Click the most recent pdf, which will download it
            studentLadokSeStudentAppPageTranscripts.linkOpenDocumentNewWindow.shouldBe(visible).click();
            System.out.println("Initiated download of the most recently created PDF.");

            File tempFile = studentLadokSeStudentAppPageTranscripts.linkOpenDocumentNewWindow.download();
            String directoryPath = "target/downloads";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String fileName = "Transcript.pdf";
            File transcript = new File(directoryPath, fileName);
            try {
                FileUtils.copyFile(tempFile, transcript);
                System.out.println("Successfully downloaded and saved the transcript.");
            } catch (IOException e) {
                System.err.println("Failed to save the downloaded transcript. Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted while waiting after the download. Error: " + e.getMessage());
                throw new RuntimeException(e);
            }

        } catch (ElementNotFound | FileNotFoundException e) {
            System.err.println("Failed to find an element or the file. Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting before asserting the URL. Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
        screenshot("transcript.png");
        String expectedUrl = "https://www.student.ladok.se/student/app/studentwebb/intyg";
        String actualUrl = url();
        Assertions.assertEquals(expectedUrl, actualUrl, "Failed to verify the URL after downloading transcript.");
        closeWebDriver();
    }

    @Test
    public void courseSyllabus() {
        try {
            // Click cookies and navigate to ladok link and page
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible).click();

            // Click search icon, and search for "I0015N"
            ltuStartSida.buttonSearch.shouldBe(visible).click();
            ltuStartSida.inputCludoSearchBar.shouldBe(visible).setValue(ltuStartSida.search);
            ltuStartSida.inputCludoSearchBar.sendKeys(Keys.ENTER);
            System.out.println("Searched for I0015N successfully");

            // Navigate to I0015N course page
            sökResultat.h2TestSystemGskolepo.shouldBe(visible).click();
            sökResultat.divDenKursenRiktarSig.shouldBe(visible);
            System.out.println("Navigated to the course page successfully");

            // Check that the url is correct for the course page
            String courseUrl = "https://www.ltu.se/edu/course/I00/I0015N/I0015N-Test-av-IT-system-1.81215";
            String actualUrl = url();
            Assertions.assertEquals(courseUrl, actualUrl, "Failed to navigate to the course page.");

            // Navigate to course syllabus
            sökResultat.linkKursplan3.shouldBe(visible).click();
            sökResultat.kursplanV23.shouldBe(visible).click();
            System.out.println("Navigated to the course syllabus successfully");

            // Make sure that the syllabys is for the correct year
            String correctYearUrl = "https://www.ltu.se/edu/course/I00/I0015N/I0015N-Test-av-IT-system-1.81215?kursView=kursplan&termin=V23";
            actualUrl = url();
            Assertions.assertEquals(correctYearUrl, actualUrl, "Failed to navigate to the correct year.");

            // download the course syllabys
            sökResultat.downloadKursplan.shouldBe(visible).click();
            System.out.println("Initiated download of the course syllabus...");

            File tempFile = sökResultat.downloadKursplan.download();
            String directoryPath = "target/downloads";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String fileName = "Syllabus.pdf";
            File syllabus = new File(directoryPath, fileName);
            try {
                FileUtils.copyFile(tempFile, syllabus);
                System.out.println("Successfully downloaded and saved the syllabus");
            } catch (IOException e) {
                System.err.println("Failed to save the downloaded syllabus. Error: " + e.getMessage());
                throw new RuntimeException(e);
            }
            
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted while waiting after the download. Error: " + e.getMessage());
                throw new RuntimeException(e);
            }

            String expectedUrl = "https://www.ltu.se/edu/course/I00/I0015N/I0015N-Test-av-IT-system-1.81215?kursView=kursplan&termin=V23";
            actualUrl = url();
            Assertions.assertEquals(expectedUrl, actualUrl, "Failed to verify the URL after downloading syllabus");

            closeWebDriver();

        } catch (ElementNotFound | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
