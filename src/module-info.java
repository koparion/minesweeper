module application {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.media;


    opens application to javafx.fxml;
    exports application;
}