import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controler {
    private CalculatorModel C;
    private Text[] txt;

    public Controler(CalculatorModel C, Text[] txt) {
        this.C = C;
        this.txt = txt;
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
    public void setButtonHandlers(Button[] numberButtons, Button plusSign,Button sustractSign, Button multipleSign, 
    		Button divideSign, Button addToStackButton, Button clearButton, Button commaButton, Button changeSign) {
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
               
               
                	System.out.println(C.addC());
                	//think of putting all of this in a function
                	changetxt(txt);
           
                	
                
//                txt.setText(Float.toString(C.peekC()));
            }
        });
        
        sustractSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
 
                	System.out.println(C.substractC());
                	changetxt(txt);
                	
                
//                txt.setText(Float.toString(C.peekC()));
            }
        });
        
        multipleSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
               
                	C.multiplyC();
                    changetxt(txt);
       
                
//                txt.setText(Float.toString(C.peekC()));
            }
        });
        
        divideSign.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
        
                	C.divideC();
                    changetxt(txt);
        
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
            	//txt[4].setText(Integer.toString(convertToValue(txt[4]) * (-1)));
                
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
//                txt.setText("0.00");
            }
        });

        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	C.clearC();
            	changetxt(txt);
            }
        });
    }
}
