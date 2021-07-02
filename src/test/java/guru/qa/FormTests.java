package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;


public class FormTests {

    @BeforeAll
    static void setup () {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.startMaximized = true;
    }

    @Test
    void fillForm () {
        open( "/automation-practice-form");

    }

}
