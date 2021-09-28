package guru.qa.domain;

public enum ItemsForSearch {
    JACKET("куртка"),
    PAGAMAS("пижама"),
    CAP("шапка"),
    SHOES("туфли");

    private final String description;

    ItemsForSearch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
