package componets;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponet {
    public void setDate (String day,String month, String year){
        $("#submit").scrollTo();
        $(("#dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(String.format(".react-datepicker__day--0%s",day)).click();
    }
}
