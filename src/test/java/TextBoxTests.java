import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void FillFormTest() {
        open("/text-box");

        $("#userName").setValue("Elina Bel");
        $("#userEmail").setValue("Elina@dfr.ru");
        $("#currentAddress").setValue("Russia, Saratov");
        $("#permanentAddress").setValue("Russia, Moscow");
        $("#submit").click();

        $("#output").shouldHave(text("Elina Bel"), text("Elina@dfr.ru"),
                text("Russia, Saratov"), text("Russia, Moscow"));
    }
}
