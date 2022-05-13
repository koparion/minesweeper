module application {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires java.desktop;

	opens application to javafx.fxml;

	exports application;
}