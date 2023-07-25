package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitWikiPageTest extends JUnit5Code {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void EnableSoftAssertionsPage() {
        // Open GitHub main page
        open("https://github.com/");

        // Search Selenide page
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // Open Wiki Project page
        $$("[data-testid='results-list']").first().$("a").click();
        $("ul.UnderlineNav-body a#wiki-tab").click();

        //Enable SoftAssertions page
        $(".markdown-body").$(byText("Soft assertions")).shouldHave(attribute("href", "https://github.com/selenide/selenide/wiki/SoftAssertions"));

        //Open SoftAssertions page
        $(".markdown-body").$(byText("Soft assertions")).click();

        //Check JUnit5 code example on SoftAssertions page
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0).shouldHave(text(jUnit5ForTest));

    }
    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }
}
