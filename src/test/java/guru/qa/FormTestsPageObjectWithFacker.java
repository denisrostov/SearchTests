package guru.qa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class FormTestsPageObjectWithFacker {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String currentAddress = faker.address().fullAddress();
    String email = faker.internet().emailAddress();
    String gender = "Other",
            hobbies = "Reading",
            month = "January",
            year = "1984",
            day = "23",
            subjects = "Computer Science",
            picture = "qa.png",
            mobile = "1234567890",
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
        registrationPage.typeEmail(email);
        registrationPage.typeAddress(currentAddress);
        registrationPage.setStateCity(state, city);
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
        registrationPage.checkResultsValue(email);
        registrationPage.checkResultsValue(subjects);
    }
}
