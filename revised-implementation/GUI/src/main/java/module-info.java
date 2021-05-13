module GUI_module {
    requires java.logging;
    requires transitive javafx.controls;
    requires transitive javafx.fxml;
    requires businessentities_module;
    requires transitive businesslogic_module;
    requires nl.homberghp.fxuiscraper;
    opens fontys.frontend to javafx.fxml;
    exports fontys.frontend;
}
