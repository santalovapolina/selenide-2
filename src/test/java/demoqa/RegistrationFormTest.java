package demoqa;

import com.codeborne.selenide.Configuration;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1800x1100";
    }


    @Test
    void successfullRegistrationTest()  {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Test");
        $("#userEmail").setValue("test@test.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click(); // click on date of birth input
        $(".react-datepicker__month-select").selectOption("January"); // select from months dropdown
        $(".react-datepicker__year-select").selectOption("1993"); // select from years dropdown
        $(".react-datepicker__month").$$(".react-datepicker__week")
                .get(1).$$(".react-datepicker__day").findBy(text("6")).click(); // select the day
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("pol.jpg");
        $("#currentAddress").setValue("Some address");
        $("#state").click(); // click on states dropdown
        $("#react-select-3-option-0").sibling(0).click(); // set the state
        $("#city").click(); // click on cities dropdown
        $("#city").lastChild().find(((byText("Lucknow")))).click(); // set the city
        $("#submit").pressEnter();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text("test@test.com"));


        //sleep(2000);

    }
}
