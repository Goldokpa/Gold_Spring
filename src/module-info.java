module CSYM026_AssessmentProject {	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.junit.jupiter.api;
	requires javafx.base;

	opens src to javafx.graphics, javafx.fxml, javafx.base;
	opens views to javafx.graphics, javafx.fxml;
	opens controllers to javafx.graphics, javafx.fxml;
}