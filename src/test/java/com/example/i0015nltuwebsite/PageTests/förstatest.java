package com.example.i0015nltuwebsite.PageTests;
import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.Screenshot;
import com.codeborne.selenide.impl.Waiter;
import com.example.i0015nltuwebsite.Config.ConfigConfig;
import com.example.i0015nltuwebsite.Pages.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.impl.Waiter.*;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.selenide.AllureSelenide.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class förstatest {

    LTUStartSida ltuStartSida = new LTUStartSida();
    LTUStudentSida ltuStudentSida = new LTUStudentSida();
    WebLogonLTU webLogonLTU = new WebLogonLTU();
    LTUinstructure ltuinstructure = new LTUinstructure();
    LTUinstructureI0015N ltuinstructureI0015N = new LTUinstructureI0015N();
    StudentLadokSeStudentAppPageStart studentLadokSeStudentAppPageStart = new StudentLadokSeStudentAppPageStart();
    StudentLadokSeStudentAppPageTranscripts studentLadokSeStudentAppPageTranscripts = new StudentLadokSeStudentAppPageTranscripts();

    LTUinstructureI0015Nmoduler ltuinstructureI0015Nmoduler = new LTUinstructureI0015Nmoduler();



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
    public void klickaStudent() throws InterruptedException {
        try {
            ltuStartSida.buttonCybotCookiebotDialogBody.shouldBe(visible);
            ltuStartSida.buttonCybotCookiebotDialogBody.click();
            ltuStartSida.linkStudent.click();
            ltuStudentSida.divLoggaCanvas.shouldBe(visible);
            ltuStudentSida.divLoggaCanvas.click();
            System.out.println(webLogonLTU.inputUsername);
            webLogonLTU.inputUsername.sendKeys(ConfigConfig.getEmail("email"));
            webLogonLTU.inputPassword.sendKeys(ConfigConfig.getPassword("password"));
            webLogonLTU.buttonLogin.click();
            ltuinstructure.Kurser.shouldBe(visible);
            ltuinstructure.Kurser.click();
            ltuinstructure.Testavit.shouldBe(visible);
            ltuinstructure.Testavit.click();
            ltuinstructureI0015N.linkModuler.shouldBe(visible);
            ltuinstructureI0015N.linkModuler.click();
            ltuinstructureI0015Nmoduler.linkModuler.shouldBe(visible);
            ltuinstructureI0015Nmoduler.linkModuler.click();
            ltuinstructureI0015Nmoduler.textOmTenta.shouldBe(visible);
            ltuinstructureI0015Nmoduler.textOmTenta.click();
            if (ltuinstructureI0015Nmoduler.textOmTenta.has(text("Final Examination Information"))) {
                System.out.println("Texten finns");
                screenshot("final_examination" + ".jpg");
                TestResult result = new TestResult();
                result.setStatus(Status.PASSED);

            } else {
                System.out.println("Texten finns inte");
            }
            Thread.sleep(10000);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
