module com.example.tpsae {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.tpsae to javafx.fxml;
    exports com.example.tpsae;
    exports vue;
    exports modele;
    exports controleur;
    exports algorithme;
}