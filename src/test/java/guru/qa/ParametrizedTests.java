package guru.qa;

import com.codeborne.selenide.Configuration;
import guru.qa.domain.ItemsForSearch;
import guru.qa.page.WildberriesPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ParametrizedTests {

    WildberriesPage wildberriesPage = new WildberriesPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @ValueSource(strings = {
            "куртка",
            "пижама",
            "шапка",
            "туфли"
    })
    @ParameterizedTest(name = "Search with ValueSource: {0}")
    void searchByValueSource(String value) {
        wildberriesPage.openPage()
                .searchValue(value)
                .checkResult(value);
    }

    @CsvSource(value = {
            "куртка; зимняя",
            "пижама; детская",
            "шапка; бини",
            "туфли; женские"
    }, delimiter = ';')
    @ParameterizedTest(name = "Search with CsvSource: {0}, {1}")
    void searchByCsvSource(String item, String property) {
        wildberriesPage.openPage()
                .searchValue(item + " " + property)
                .checkResult(item);
    }

    @EnumSource(ItemsForSearch.class)
    @ParameterizedTest(name = "search with EnumSource: {0}")
    void searchByEnumSource(ItemsForSearch items) {
        wildberriesPage.openPage()
                .searchValue(items.getDescription())
                .checkResult(items.getDescription());
    }

    static Stream<String> stringProvider() {
        return Stream.of("куртка зимняя", "пижама детская", "шапка бини", "туфли женские");
    }

    @MethodSource("stringProvider")
    @ParameterizedTest(name = "search with MethodSource: {0}")
    void searchByMethodSource(String s) {
        wildberriesPage.openPage()
                .searchValue(s)
                .checkResult(s);
    }
}
