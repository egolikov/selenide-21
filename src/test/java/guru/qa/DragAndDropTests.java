package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Test with actions doesn't work
        actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
    }



    @Test
    void dragAndDropCommand() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Test with dragAndDropTo working
        $("#column-a").dragAndDropTo($("#column-b"));

        // Check column-a header after dragAndDropTo
        $("#column-a header").shouldHave(text("B"));

        // Check column-b header after dragAndDropTo
        $("#column-b header").shouldHave(text("A"));

    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
