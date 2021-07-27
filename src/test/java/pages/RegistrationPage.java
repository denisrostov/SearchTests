package pages;

import com.codeborne.selenide.SelenideElement;
import componets.CalendarComponet;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponet calendarComponet = new CalendarComponet();
    private final static String FORM_TITLE = "Student Registration Form";
    private final static String RESULTS_TITLE = "Thanks for submitting the form";


    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderInput = $("#genterWrapper");

    public void typeFirstName(String value) {
        firstNameInput.val(value);
    }

    public void typeLastName(String value) {
        lastNameInput.val(value);
    }

    public void typeGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

    }

    public void typeSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();

    }

    public void typeUploadFile(String picture) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));

    }

    public void typeHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();

    }
    public void typeMobile(String mobile) {
        $("#userNumber").setValue(mobile);

    }
        public void typeAddress(String currentAddress) {
            $("#currentAddress").setValue(currentAddress);

    }
    public RegistrationPage typeEmail(String email){
        $("#userEmail").setValue(email);
        return this;
    }

     public void setStateCity(String state,String city) {
         $("#react-select-3-input").setValue(state).pressEnter();
         $("#react-select-4-input").setValue(city).pressEnter();

    }
         public void submit() {
             $("#submit").scrollTo().click();

    }


    public RegistrationPage setDate(String day, String month, String year) {
        calendarComponet.setDate(day, month, year);
        return this;
    }

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FORM_TITLE));
    }

    public void checkResultsTitle() {
        $("#example-modal-sizes-title-lg").shouldHave(text(RESULTS_TITLE));
    }

    public void checkResultsValue(String value) {
        $(".table-responsive").shouldHave(text(value));
    }

}
