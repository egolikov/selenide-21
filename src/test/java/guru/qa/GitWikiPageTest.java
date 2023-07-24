package guru.qa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitWikiPageTest {

    @Test
    void EnableSoftAssertionsPage() {

        // Open GitHub
        open("https://github.com/");



        // Search Selenide page
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();

        // Open Wiki Project page


    }
}