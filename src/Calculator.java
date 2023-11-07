import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;


public class Calculator extends Application{
	 public static void main(String[] args) {
	        launch(args);
	    }
    public void start(Stage primaryStage)  {
    	
        primaryStage.setTitle("RPN Calculator");
        CalculatorModel C = new CalculatorModel();
        Controler Controler = new Controler();
        
        View v = new View(C, Controler);
	    primaryStage.setScene(new Scene(v.getVbox(), 500, 500));
	    primaryStage.show();
    }
}