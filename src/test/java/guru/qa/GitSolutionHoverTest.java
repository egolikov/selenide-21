package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitSolutionHoverTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void callHoverOnSolution() {
        // Open GitHub main page
        open("https://github.com/");

        // Hover by Solutions
        $(".header-menu-wrapper").$(byText("Solutions")).hover();

        // Click Enterprise on hover
        $(".header-menu-wrapper").$(byText("Enterprise")).click();

        // Check header with text
        $(".application-main h1").shouldHave(text("Build like the best"));
    }

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
