package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    @Test
    void fillForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Shiva");
        $("#lastName").setValue("Ivanova");
        $(("#genterWrapper")).$(byText("Other")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $(("#dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1984");
        $((".react-datepicker__day--023")).click();
//        альтеонативный выбор даты в календаре
//        $("#dateOfBirthInput").click();
//        $("#dateOfBirthInput").sendKeys(Keys.CONTROL, "a");
//        $("#dateOfBirthInput").sendKeys(Keys.SPACE);
//        $("#dateOfBirthInput").setValue("23 January 1984").pressEnter();
        $("#subjectsInput").setValue("comp").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/qa.png"));
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("World");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
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
