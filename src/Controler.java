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

    public void setButtonHandlers(Button[] numberButtons, Button operationButton, Button addToStackButton, Button clearButton) {
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
//
//        operationButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String buttonText = operationButton.getText();
//                if (buttonText.equals("+")) {
//                	System.out.println(C.addC());
//                	//think of putting all of this in a function
//                	changetxt(txt);
//                } else if (buttonText.equals("-")) {
//                    C.substractC();
//                // Handle other operations similarly
//                }
//                txt.setText(Float.toString(C.peekC()));
//            }
//        });
//
//        addToStackButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                String currentDisplay = txt.getText();
//                float value = Float.parseFloat(currentDisplay);
//                C.pushC(value);
//                txt.setText("0.00");
//            }
//        });
//
//        clearButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                C.clearC();
//                txt.setText("0.00");
//            }
//        });
    }
}
