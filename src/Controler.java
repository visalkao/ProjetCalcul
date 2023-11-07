import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controler implements ControlerInterface{
    private CalculatorModel C;
    private Text[] txt;
    public void openPopup(String printText) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Error!");
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white;");
        Text txt = new Text();
        txt.setText(printText);
//        Rectangle rectangle=new Rectangle(475,30);
        closeButton.setOnAction(e -> popupStage.close());
        StackPane s1=new StackPane();
        Rectangle rectangle1=new Rectangle(275,30);
        rectangle1.setFill(Color.LIGHTGREY);
        
        StackPane s2=new StackPane();
        Rectangle rectangle2=new Rectangle(275,30);
        rectangle2.setFill(Color.LIGHTGREY);
        
        s1.getChildren().addAll(rectangle1,txt); 
        
        s2.getChildren().addAll(rectangle2,closeButton); 
        
        VBox popupLayout = new VBox();
        popupLayout.getChildren().add(s1);
    
        
        popupLayout.getChildren().add(s2);


        Scene popupScene = new Scene(popupLayout, 275, 60);
        popupStage.setScene(popupScene);

        // To block interactions with the main window while the popup is open:


        popupStage.show();
    }
    
    public Controler() {}
    public Controler(CalculatorModel C, Text[] txt) {
        this.C = C;
        this.txt = txt;
    }
    public void changetxt(Text[] txt) {
    	txt[4].setText("0.00");
    	txt[3].setText(Float.toString(C.peekC(C.sizeC()-1)));
    	for (int i=0;i<3;i++) {
    		txt[i].setText(Float.toString(C.peekC(C.sizeC()-4+i)));
//    		if(txt[i].getText() == "NaN")
//    		{
//    			txt[i].setText("0.00");
//    		}
    	}
//    	if(txt[3].getText() == "NaN") {
//    		txt[3].setText("0.00");
//    	}
    }
    public void setButtonHandlers(Button[] numberButtons, Button plusSign,Button sustractSign, Button multipleSign, 
    		Button divideSign, Button addToStackButton, Button clearButton, Button commaButton, Button changeSign, Button swap) {
        for (Button button : numberButtons) {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                	String buttonText = button.getText();
                 	System.out.println("Button" + buttonText + "clicked!");
                	
               	 if (txt[4].getText() == "0.00") {
                        txt[4].setText(buttonText);
                    }else {
                   	 txt[4].setText(txt[4].getText() + buttonText);
                    }}
            });
        }

        plusSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               
                	
        
//                	changetxt(txt);
                	
                	if(txt[2].getText() == "NaN" ) {
                		
                		openPopup("The Stack is empty!");
                	}else {
                		System.out.println(C.addC());
                        changetxt(txt);
                        
                	}
                	System.out.println("Text 3 =" + txt[3].getText());
                
            }
        });
        
        sustractSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
 
                	
                	if(txt[2].getText() == "NaN" ) {
                		
                		openPopup("The Stack is empty!");
                	}else {
                		System.out.println(C.substractC());
                    	changetxt(txt);
                        
                	}
                	
              
            }
        });
        
        multipleSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               
                	
                	if(txt[2].getText() == "NaN" ) {
                		
                		openPopup("The Stack is empty!");
                	}else {
                		System.out.println(C.multiplyC());
                    	changetxt(txt);
                        
                	}
       
            }
        });
        
        divideSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.out.print("txt3 = " + txt[2].getText());
        		System.out.print("txt4 = " + txt[3].getText());
            	if(txt[3].getText() == "0.0" || txt[3].getText() == "0.00") {
            		
            		openPopup("Can't divide by 0!");
            	}else if(txt[2].getText() == "NaN"){

            		openPopup("The Stack is empty!");
            	}
            	else{
            		C.divideC();
                    changetxt(txt);
                    
            	}
                	
        
            }
        });
        
        commaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
            	System.out.println("Button ',' clicked!");
                String text = txt[4].getText();
                boolean existVirgule = text.indexOf('.') >= 0;
                if(existVirgule)
                {
                	
                }else {
                	txt[4].setText(txt[4].getText() + '.');
                }
            }
        });
        changeSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txt[4].setText(Float.toString(Float.parseFloat(txt[4].getText()) * (-1)));
   
                
            }
        });
        
        addToStackButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String text0 = txt[4].getText();
            	float float0= Float.parseFloat(text0);
            	C.pushC(float0);
            	changetxt(txt);
            	System.out.println(C.peekC());

            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	C.clearC();
            	changetxt(txt);
            }
        });
        
        swap.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	C.swapC();
            	changetxt(txt);
            }
        });
    }
}
