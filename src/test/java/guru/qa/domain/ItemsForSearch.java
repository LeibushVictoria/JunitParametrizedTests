package guru.qa.domain;

public enum ItemsForSearch {
    JACKET("куртка"),
    PAGAMAS("пижама"),
    CAP("шапка"),
    BOOTS("сапоги"),
    COAT("пальто");

    private final String description;

    ItemsForSearch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
