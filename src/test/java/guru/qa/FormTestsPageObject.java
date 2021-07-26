package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTestsPageObject {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Shiva",
            lastName = "Ivanova",
            gender = "Other",
            hobbies = "Reading",
            month = "January",
            year = "1984",
            day = "23",
            subjects = "Computer Science",
            picture = "qa.png",
            mobile = "1234567890",
            currentAddress = "World",
            state = "NCR",
            city = "Delhi";

    @Test
    void fillForm() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeGender(gender);
        registrationPage.typeHobbies(hobbies);
        registrationPage.setDate(day, month, year);
        registrationPage.typeSubjects(subjects);
        registrationPage.typeUploadFile(picture);
        registrationPage.typeMobile(mobile);
        registrationPage.typeAddress(currentAddress);
        registrationPage.setStateCity(state,city);
       registrationPage.submit();

        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(firstName + " " + lastName);
        registrationPage.checkResultsValue(gender);
        registrationPage.checkResultsValue(day + " " + month + "," + year);
        registrationPage.checkResultsValue(currentAddress);
        registrationPage.checkResultsValue(picture);
        registrationPage.checkResultsValue(mobile);
        registrationPage.checkResultsValue(state + " " + city);
        registrationPage.checkResultsValue(hobbies);
        registrationPage.checkResultsValue(subjects);
    }
}
