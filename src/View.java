import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class View extends Application {
	CalculatorModel C=new CalculatorModel();
    public static void main(String[] args) {
        launch(args);
    }
    //recheck what this does
    public Integer convertToValue(Text inputText) {
    	String tmptext = inputText.getText();
    	if(tmptext=="0.00")
    	{
    		tmptext = "0";
    	}
    	int parsedValue = Integer.parseInt(tmptext);
    	
    	return parsedValue;
    }
    public void changetxt(Text[] txt) {
    	txt[4].setText("0.00");
    	txt[3].setText(Float.toString(C.peekC(C.sizeC()-1)));
    	for (int i=0;i<3;i++) {
    		txt[i].setText(Float.toString(C.peekC(C.sizeC()-4+i)));
    		if(txt[i].getText() == "NaN")
    		{
    			txt[i].setText("0.00");
    		}
    	}
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPN Calculator");
        
        VBox vbox = new VBox(1);
        Text[] txt = new Text[5];
        for (int i = 0; i < 5; i++) 
        { 	txt[i]= new Text("0.00");
        	StackPane s=new StackPane();
        	Rectangle rectangle=new Rectangle(475,30);
        	rectangle.setFill(Color.LIGHTGREY);
            s.getChildren().addAll(rectangle,txt[i]); 
            vbox.getChildren().add(s);
            
        } 

        
        StackPane root = new StackPane();
        //root.getChildren().add(btn);
//        primaryStage.setScene(new Scene(vbox, 300, 250));
//        primaryStage.show();
//        
        
//        primaryStage.setScene(null);
        
        
 //think of adding try catch blocks to the code 
        Button[] btn = new Button[10];
        for(int i=0;i<10;i++) {
        	
	        	btn[i]= new Button();
	        	int finalI = i;
	            btn[i].setText(Integer.toString(i));
	            int row,col;
	       if(i>0) {
	           row=(i-1)/3;
	           col=(i-1)%3;
	       }else {
	    	   row=3;
	    	   col=0;
	       }
	            GridPane.setRowIndex(btn[i], row);
	            GridPane.setColumnIndex(btn[i], col);
	            btn[i].setPrefHeight(100);
	            btn[i].setPrefWidth(100);
	            btn[i].setOnAction(new EventHandler<ActionEvent>() {
	                @Override
	                public void handle(ActionEvent event) {
	                	System.out.println("Button" + finalI + "clicked!");
	                	
	                	 if (txt[4].getText() == "0.00") {
	                         txt[4].setText(Integer.toString(finalI));
	                     }else {
	                    	 txt[4].setText(txt[4].getText() + finalI);
	                     }
	                }
	            });
        	
	       
        }
        Button commaBtn = new Button(); 
        commaBtn.setText(",");
        commaBtn.setPrefHeight(100);
        commaBtn.setPrefWidth(100);
        GridPane.setRowIndex(commaBtn, 3);
        GridPane.setColumnIndex(commaBtn, 1); 
        commaBtn.setOnAction(new EventHandler<ActionEvent>() {
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
        
        
        Button changeSign = new Button(); 
        changeSign.setText("+/-");
        changeSign.setPrefHeight(100);
        changeSign.setPrefWidth(100);
        GridPane.setRowIndex(changeSign, 3);
        GridPane.setColumnIndex(changeSign, 2); 
        changeSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txt[4].setText(Float.toString(Float.parseFloat(txt[4].getText()) * (-1)));
            	//txt[4].setText(Integer.toString(convertToValue(txt[4]) * (-1)));
                
            }
        });
        
        
        Button plusSign = new Button(); 
        plusSign.setText("+");
        plusSign.setPrefHeight(63.33);
        plusSign.setPrefWidth(100);
        GridPane.setRowIndex(plusSign, 2);
        GridPane.setColumnIndex(plusSign, 1); 
        plusSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.out.println(C.addC());
            	//think of putting all of this in a function
            	changetxt(txt);
                
            }
        });
        
        
        Button minusSign = new Button(); 
        minusSign.setText("-");
        minusSign.setPrefHeight(63.33);
        minusSign.setPrefWidth(100);
        GridPane.setRowIndex(minusSign, 3);
        GridPane.setColumnIndex(minusSign, 1); 
        minusSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	System.out.println(C.substractC());
            	
                
            }
        });
        
        
        Button multipleSign = new Button(); 
        multipleSign.setText("x");
        multipleSign.setPrefHeight(63.33);
        multipleSign.setPrefWidth(100);
        GridPane.setRowIndex(multipleSign, 4);
        GridPane.setColumnIndex(multipleSign, 1); 
        multipleSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                C.multiplyC();
                changetxt(txt);
            }
        });
        
        
        Button divideSign = new Button(); 
        divideSign.setText("/");
        divideSign.setPrefHeight(63.33);
        divideSign.setPrefWidth(100);
        GridPane.setRowIndex(divideSign, 5);
        GridPane.setColumnIndex(divideSign, 1); 
        divideSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	C.divideC();
            	changetxt(txt);
                
            }
        });
        
        
        Button addtoStackSign = new Button(); 
        addtoStackSign.setText("<>");
        addtoStackSign.setPrefHeight(63.33);
        addtoStackSign.setPrefWidth(100);
        GridPane.setRowIndex(addtoStackSign, 6);
        GridPane.setColumnIndex(addtoStackSign, 1); 
        addtoStackSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	String text0 = txt[4].getText();
            	float float0= Float.parseFloat(text0);
            	C.pushC(float0);
            	changetxt(txt);
            	System.out.println(C.peekC());
            	
                
            }
        });
        
        
        Button backSpaceSign = new Button(); 
        backSpaceSign.setText("C");
        backSpaceSign.setPrefHeight(63.33);
        backSpaceSign.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white;");
        backSpaceSign.setPrefWidth(100);
        GridPane.setRowIndex(backSpaceSign, 1);
        GridPane.setColumnIndex(backSpaceSign, 1); 
        backSpaceSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	C.clearC();
            	changetxt(txt);
                
            }
        });
        
        
        
        
      
//        
//        
//        

//        
        GridPane grid = new GridPane();
        GridPane newgrid = new GridPane();
        
        newgrid.setVgap(12);
        newgrid.setPadding(new Insets(10));
        newgrid.setHgap(10);
        
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
	    for(int i=0; i<10;i++)
	    {
	    	grid.getChildren().add(btn[i]);
	    }
    	grid.getChildren().add(commaBtn);
    	grid.getChildren().add(changeSign);
    	newgrid.getChildren().add(plusSign);
    	newgrid.getChildren().add(minusSign);
    	newgrid.getChildren().add(multipleSign);
    	newgrid.getChildren().add(divideSign);
    	newgrid.getChildren().add(addtoStackSign);
    	newgrid.getChildren().add(backSpaceSign);
//    	vbox.getChildren().add(grid);
    	HBox hbox = new HBox();
    	
    	hbox.getChildren().add(grid);
    	hbox.getChildren().add(newgrid);
    	
//    	newgrid.getChildren().add(grid);
    	vbox.getChildren().add(hbox);
	    primaryStage.setScene(new Scene(vbox, 500, 500));
	    primaryStage.show();
    }
}