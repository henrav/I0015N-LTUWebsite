package com.example.i0015nltuwebsite.Pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
public class LTUinstructureI0015Nmoduler {
    public SelenideElement linkModuler = $("a[title*='Examination']");
    public SelenideElement textOmTenta = $x("//div[contains(@class, 'clearfix')]");

    @FindBy(xpath = "//*[text() = '\n              Final Examination Information\n            ']")
    public WebElement linkFinalExaminationInformation;

    @FindBy(css = "a[title*='Examination']")
    public WebElement linkFinalExaminationInformation2;


    

    
}
