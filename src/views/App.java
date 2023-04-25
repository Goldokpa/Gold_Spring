package views;
	
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
	
	public static void main(String[] args) {
		try {
			initialise();
			try {
		        launch(args);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
	}


	public static void initialise() throws FileNotFoundException, IOException {
			
	}
	
	@Override
	public void start(Stage openingStage) throws IOException {
	      Parent root = FXMLLoader.load(getClass().getResource("/views/App.fxml")); 
	      Scene scene = new Scene(root); 
	      
	      // add external stylesheet
	      String css = getClass().getResource("/views/styles.css").toExternalForm();
	      scene.getStylesheets().add(css);

	      openingStage.setTitle("CSYM026 Project"); 
	      openingStage.setScene(scene);
	      openingStage.show();
	}

}
