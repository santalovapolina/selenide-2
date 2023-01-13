package demoqa_tests;

import com.codeborne.selenide.Configuration;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }


    @Test
    void successfulRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        String firstName = "Test";
        String lastName = "Test";
        String userEmail = "test@test.com";
        String userNumber = "1234567890";
        String userSubject1 = "Maths";
        String userSubject2 = "Computer Science";
        String userAddress = "Some address";
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January"); // select from months dropdown
        $(".react-datepicker__year-select").selectOption("1993"); // select from years dropdown
        $(".react-datepicker__month").$$(".react-datepicker__week")
                .get(1).$$(".react-datepicker__day").findBy(text("6")).click(); // select the day
        $("#subjectsInput").setValue(userSubject1).pressEnter();
        $("#subjectsInput").setValue(userSubject2).pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("pol.jpg");
        $("#currentAddress").setValue(userAddress);
        $("#state").click(); // click on states dropdown
        $("#react-select-3-option-0").sibling(0).click(); // set the state
        $("#city").click(); // click on cities dropdown
        $("#city").lastChild().find(byText("Lucknow")).click(); // set the city
        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").shouldHave(text(userEmail));
    }
    @Test
    void unsuccessfulRegistrationTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".was-validated").shouldNot(exist);
        String firstName = "Test";
        String lastName = "Test";
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#submit").click();
        $(".was-validated").should(exist);
        $(".table").shouldNotBe(visible);

    }
}
