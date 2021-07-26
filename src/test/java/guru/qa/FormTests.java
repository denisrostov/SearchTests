package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    String firstName = "Shiva",
            lastName = "Ivanova",
            gender = "Other",
            hobbie = "Reading",
            month = "January",
            year = "1984",
            day = "23",
            subjects = "comp",
            picturePath = "src/test/resources/qa.png",
            mobile = "1234567890",
            currentAddress = "World",
            state = "NCR",
            city = "Delhi";

    @Test
    void fillForm() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $(("#genterWrapper")).$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobbie)).click();
        $("#submit").scrollTo();
        $(("#dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s",day)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#uploadPicture").uploadFile(new File(picturePath));
        $("#userNumber").setValue(mobile);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").scrollTo().click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Shiva Ivanova"),
                text("23 January,1984"),
                text("World"),
                text("qa.png"),
                text("NCR Delhi"),
                text("Other"),
                text("Reading"),
                text("Computer Science"),
                text("1234567890")
        );
    }
}
