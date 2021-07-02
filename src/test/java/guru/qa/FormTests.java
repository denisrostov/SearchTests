package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

//import static com.codeborne.selenide.Selenide.*;
//import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm () {


        open( "/automation-practice-form");
       $("#firstName").setValue("Shiva");

       $("#lastName").setValue("Ivanova");
       $(("[for=\"gender-radio-3\"]")).click();
//        $(By.xpath("//label[contains(text(),'Male')]")).click();
        $("#userNumber").setValue("1234567890");
       $("#submit").scrollTo();
       $("#submit").click();

       $("#example-modal-sizes-title-lg").shouldHave(text ("Thanks for submitting the form"));

    }

}
