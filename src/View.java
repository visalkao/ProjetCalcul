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


public class View {
	
	private Text displayText;
	VBox vbox = new VBox(1);
//	private Controler Controler;
//    public static void main(String[] args) {
//        launch(args);
//    }
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
    public View(CalculatorModel C, Controler Controler) {
    	displayText = new Text("0.00");
        
    	
        Text[] txt = new Text[5];
        for (int i = 0; i < 5; i++) 
        { 	txt[i]= new Text("0.00");
        	StackPane s=new StackPane();
        	Rectangle rectangle=new Rectangle(475,30);
        	rectangle.setFill(Color.LIGHTGREY);
            s.getChildren().addAll(rectangle,txt[i]); 
            vbox.getChildren().add(s);
            
        } 


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
	           
        	
	       
        }
        Button commaBtn = new Button(); 
        commaBtn.setText(",");
        commaBtn.setPrefHeight(100);
        commaBtn.setPrefWidth(100);
        GridPane.setRowIndex(commaBtn, 3);
        GridPane.setColumnIndex(commaBtn, 1); 
   
        
        
        Button changeSign = new Button(); 
        changeSign.setText("+/-");
        changeSign.setPrefHeight(100);
        changeSign.setPrefWidth(100);
        GridPane.setRowIndex(changeSign, 3);
        GridPane.setColumnIndex(changeSign, 2); 
       
        
        
        Button plusSign = new Button(); 
        plusSign.setText("+");
        plusSign.setPrefHeight(52.8);
        plusSign.setPrefWidth(100);
        GridPane.setRowIndex(plusSign, 2);
        GridPane.setColumnIndex(plusSign, 1); 
   
        
        
        Button minusSign = new Button(); 
        minusSign.setText("-");
        minusSign.setPrefHeight(52.8);
        minusSign.setPrefWidth(100);
        GridPane.setRowIndex(minusSign, 3);
        GridPane.setColumnIndex(minusSign, 1); 
  
        
        
        Button multipleSign = new Button(); 
        multipleSign.setText("x");
        multipleSign.setPrefHeight(52.8);
        multipleSign.setPrefWidth(100);
        GridPane.setRowIndex(multipleSign, 4);
        GridPane.setColumnIndex(multipleSign, 1); 
     
        
        
        Button divideSign = new Button(); 
        divideSign.setText("/");
        divideSign.setPrefHeight(52.8);
        divideSign.setPrefWidth(100);
        GridPane.setRowIndex(divideSign, 5);
        GridPane.setColumnIndex(divideSign, 1); 
     
        
        
        Button addtoStackSign = new Button(); 
        addtoStackSign.setText("Push");
        addtoStackSign.setPrefHeight(52.8);
        addtoStackSign.setPrefWidth(100);
        GridPane.setRowIndex(addtoStackSign, 6);
        GridPane.setColumnIndex(addtoStackSign, 1); 
     
        
        
        Button backSpaceSign = new Button(); 
        backSpaceSign.setText("C");
        backSpaceSign.setPrefHeight(52.8);
        backSpaceSign.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white;");
        backSpaceSign.setPrefWidth(100);
        GridPane.setRowIndex(backSpaceSign, 1);
        GridPane.setColumnIndex(backSpaceSign, 1); 
        
        Button swap = new Button(); 
        swap.setText("Swap");
        swap.setPrefHeight(52.8);
        swap.setPrefWidth(100);
        GridPane.setRowIndex(swap, 7);
        GridPane.setColumnIndex(swap, 1); 
     
     
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
    	newgrid.getChildren().add(swap);
//    	vbox.getChildren().add(grid);
    	HBox hbox = new HBox();
    	
    	hbox.getChildren().add(grid);
    	hbox.getChildren().add(newgrid);
    	
//    	newgrid.getChildren().add(grid);
    	vbox.getChildren().add(hbox);
    	
    	Controler = new Controler(C, txt);
        Controler.setButtonHandlers(btn, plusSign, minusSign, multipleSign, divideSign, addtoStackSign, backSpaceSign, commaBtn, changeSign, swap);
        
    }
    public VBox getVbox() {
    	return vbox;
    }
    
}