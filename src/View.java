


import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class View extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ma calculette");
        VBox vbox = new VBox();
        Text[] txt = new Text[5];
        for (int i = 0; i < 5; i++) 
        { 	txt[i]= new Text("0.00");
        	StackPane s=new StackPane();
        	Rectangle rectangle=new Rectangle(300,30);
        	rectangle.setFill(Color.LIGHTGREY);
            s.getChildren().addAll(rectangle,txt[i]); 
            vbox.getChildren().add(s);
            
        } 
       /* Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });*/
        
        StackPane root = new StackPane();
        //root.getChildren().add(btn);
        primaryStage.setScene(new Scene(vbox, 300, 250));
        primaryStage.show();
    }
}
