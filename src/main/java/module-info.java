module fr.jaggernaute.banque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;
    requires java.dotenv;
    //requires eu.hansolo.tilesfx;

    opens fr.jaggernaute.banque to javafx.fxml;
    exports fr.jaggernaute.banque;
}