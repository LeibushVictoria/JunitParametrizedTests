package guru.qa.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WildberriesPage {

    public static final String URL = "https://www.wildberries.ru/";

    private SelenideElement
            logo = $(".nav-element__logo"),
            searchInput = $(".search-catalog__input"),
            searchResultTab = $(".searching-results__inner");

    public WildberriesPage openPage() {
        open(URL);
        logo.shouldBe(visible);
        return this;
    }

    public WildberriesPage searchValue(String value) {
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public WildberriesPage checkResult(String s) {
        searchResultTab.shouldBe(visible);
        searchResultTab.find(byText(s));
        return this;
    }
}
