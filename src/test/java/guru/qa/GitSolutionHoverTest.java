package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitSolutionHoverTest {

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
}
