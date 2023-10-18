//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
// 
//public class View extends Application {
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Hello World123!");
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
// 
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        primaryStage.setScene(new Scene(root, 300, 250));
//        primaryStage.show();
//    }
////}
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class View extends Application {
//
//    private TextField display;
//
//    private String operator = "";
//    private double num1 = 0;
//    private boolean start = true;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Calculator");
//
//        display = new TextField();
//        display.setEditable(false);
//
//        // Create number buttons
//        Button[] numberButtons = new Button[10];
//        for (int i = 0; i < 10; i++) {
//            numberButtons[i] = createNumberButton(Integer.toString(i));
//        }
//
//        // Create operator buttons
//        Button addButton = createOperatorButton("+");
//        Button subtractButton = createOperatorButton("-");
//        Button multiplyButton = createOperatorButton("*");
//        Button divideButton = createOperatorButton("/");
//
//        Button equalsButton = new Button("=");
//        equalsButton.setOnAction(e -> calculate());
//
//        Button clearButton = new Button("C");
//        clearButton.setOnAction(e -> {
//            display.clear();
//            operator = "";
//            num1 = 0;
//            start = true;
//        });
//
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        // Set the positions of the buttons in the grid
//        for (int i = 0; i < 10; i++) {
//            int row = (9 - i) / 3;
//            int col = (i % 3);
//            grid.add(numberButtons[i], col, row + 1);
//        }
//
//        grid.add(addButton, 3, 1);
//        grid.add(subtractButton, 3, 2);
//        grid.add(multiplyButton, 3, 3);
//        grid.add(divideButton, 3, 4);
//        grid.add(equalsButton, 2, 4);
//        grid.add(clearButton, 0, 4);
//        grid.add(display, 0, 0, 4, 1);
//
//        Scene scene = new Scene(grid, 300, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private Button createNumberButton(final String text) {
//        Button button = new Button(text);
//        button.setOnAction(e -> {
//            if (start) {
//                display.clear();
//                start = false;
//            }
//            display.appendText(text);
//        });
//        return button;
//    }
//
//    private Button createOperatorButton(final String text) {
//        Button button = new Button(text);
//        button.setOnAction(e -> {
//            if (!start) {
//                calculate();
//                start = true;
//                operator = text;
//            } else {
//                operator = text;
//                num1 = Double.parseDouble(display.getText());
//                start = false;
//            }
//        });
//        return button;
//    }
//
//    private void calculate() {
//        double num2 = Double.parseDouble(display.getText());
//        double result = 0;
//        switch (operator) {
//            case "+":
//                result = num1 + num2;
//                break;
//            case "-":
//                result = num1 - num2;
//                break;
//            case "*":
//                result = num1 * num2;
//                break;
//            case "/":
//                if (num2 != 0)
//                    result = num1 / num2;
//                else
//                    display.setText("Error");
//                break;
//        }
//        display.setText(String.valueOf(result));
//    }
//}
//import javafx.application.Application;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.stage.Stage;
//
//public class View extends Application {
//
//    private TextField display;
//    private String operator = "";
//    private double num1 = 0;
//    private boolean start = true;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Calculator12333");
//
//        display = new TextField();
//        display.setEditable(false);
//
//        GridPane gridPane = createGridPane();
//
//        Scene scene = new Scene(gridPane, 300, 300);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//    private GridPane createGridPane() {
//        GridPane gridPane = new GridPane();
//        gridPane.setAlignment(Pos.CENTER);
//        gridPane.setHgap(10);
//        gridPane.setVgap(10);
//
//        String[] buttonLabels = {
//                "7", "8", "9", "/",
//                "4", "5", "6", "*",
//                "1", "2", "3", "-",
//                "0", ".", "=", "+"
//        };
//
//        int row = 0;
//        int col = 0;
//
//        for (String label : buttonLabels) {
//            Button button = createButton(label);
//            gridPane.add(button, col, row);
//
//            col++;
//            if (col > 3) {
//                col = 0;
//                row++;
//            }
//        }
//
//        // Set TextField to span across all columns
//        GridPane.setColumnSpan(display, 4);
//        gridPane.add(display, 0, 0);
//
//        return gridPane;
//    }
//
//    private Button createButton(final String text) {
//        Button button = new Button(text);
//        button.setOnAction(e -> handleButtonClick(text));
//        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        return button;
//    }
//
//    private void handleButtonClick(String text) {
//        if (start) {
//            display.clear();
//            start = false;
//        }
//
//        if (!text.equals("=")) {
//            if (!operator.isEmpty())
//                return;
//
//            operator = text;
//            num1 = Double.parseDouble(display.getText());
//            display.clear();
//        } else {
//            if (operator.isEmpty())
//                return;
//
//            double num2 = Double.parseDouble(display.getText());
//            double result = calculate(num1, num2, operator);
//            display.setText(String.valueOf(result));
//
//            operator = "";
//            start = true;
//        }
//    }
//
//    private double calculate(double num1, double num2, String operator) {
//        switch (operator) {
//            case "+":
//                return num1 + num2;
//            case "-":
//                return num1 - num2;
//            case "*":
//                return num1 * num2;
//            case "/":
//                if (num2 != 0)
//                    return num1 / num2;
//                else {
//                    display.setText("Error");
//                    return 0;
//                }
//            default:
//                return 0;
//        }
//    }
//}

import javax.swing.text.html.ListView;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class View extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("RPN Calculator");
        Button[] btn = new Button[10];
        for(int i=1;i<10;i++) {
        	btn[i]= new Button();
        	int finalI = i;
            btn[i].setText(Integer.toString(i));
            int row=i/3;
            int col=i%3;
            GridPane.setRowIndex(btn[i], row);
            GridPane.setColumnIndex(btn[i], col);
            btn[i].setPrefHeight(100);
            btn[i].setPrefWidth(200);
            btn[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("Button" + finalI + "clicked!");
                }
            });
        }
    
//        StackPane root = new StackPane();
//        for(int i=0; i<10;i++)
//        {
//        	 root.getChildren().add(btn[i]);
//        }
//        	 primaryStage.setScene(new Scene(root, 30, 250));
//             primaryStage.show();
//        
        GridPane grid = new GridPane();
        
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
	    for(int i=1; i<10;i++)
	    {
	    	grid.getChildren().add(btn[i]);
	    }
	    primaryStage.setScene(new Scene(grid, 500, 500));
	    primaryStage.show();
    }
}