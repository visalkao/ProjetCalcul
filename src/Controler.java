import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.VBox;
//put the interface in another file 
interface CalculatrorModelInterface{
	float pushC(float a);
	public float popC();
	public float peekC();
	public void clearC();
	
}
public class Controler implements CalculatrorModelInterface {
//	View v = new View();
//	public void test() {
//		System.out.print("Hello");
//		v.button().setText("Hello");
//	}
//	private float accumulateur;
//	private Stack<Float> pile;
	
	
	
	CalculatorModel m = new CalculatorModel();

	
	private float accumulateur = m.getAccumulator();
	private Stack<Float> pile = m.getPile();
	
	
	public Controler() {
        this.accumulateur =Float.NaN;
        this.pile = new Stack<Float>();
    }
	
	
	
	private void openPopup() {
        Stage popupStage = new Stage();
        popupStage.setTitle("Error!");
        Button closeButton = new Button("Close");
        closeButton.setStyle("-fx-background-color: #8B0000; -fx-text-fill: white;");
        Text txt = new Text();
        txt.setText("We can't divide with 0");
//        Rectangle rectangle=new Rectangle(475,30);
        closeButton.setOnAction(e -> popupStage.close());

        VBox popupLayout = new VBox();
        popupLayout.getChildren().add(txt);
        
        popupLayout.getChildren().add(closeButton);
        

        Scene popupScene = new Scene(popupLayout, 50, 150);
        popupStage.setScene(popupScene);

        // To block interactions with the main window while the popup is open:
        

        popupStage.show();
    }
	
	public float pushC(float a) {
		pile.push(a);
		return a;}
	public float addC() {
		accumulateur=this.popC();
		accumulateur+=this.popC();
		this.pushA();
		//think of what to do if the pile is vide 
		//System.out.println("accumulateuuur"+accumulateur);
		return accumulateur;
	}
	public float substractC() {
		accumulateur=this.popC();
		accumulateur= this.popC() - accumulateur;
		this.pushA();
		//think of what to do if the pile is vide 
		//System.out.println("accumulateuuur"+accumulateur);
		return accumulateur;
	}
	public float multiplyC() {
		accumulateur=this.popC();
		accumulateur*=this.popC();
		this.pushA();
		//think of what to do if the pile is vide 
		System.out.println("accumulateuuur"+accumulateur);
		return accumulateur;
	}
	public float divideC() {
		accumulateur=this.popC();
		if(accumulateur != 0)
		{
			accumulateur=this.popC() / accumulateur;
		}else {
			openPopup();
		}
		
		this.pushA();
		//think of what to do if the pile is vide 
		//System.out.println("accumulateuuur"+accumulateur);
		return accumulateur;
	}
	//instead of drop we'll use popC
	public float popC() {
		try {return pile.pop();}
		catch(EmptyStackException e) {System.out.println("la pile est vide");return Float.NaN;}
	}
	public float peekC() {
		try {return pile.peek();}
		catch(EmptyStackException e) {System.out.println("la pile est vide");return Float.NaN;}
	}
	public float peekC(int a) {
		try {return pile.get(a);}
		catch(EmptyStackException e) {System.out.println("la pile est vide");return Float.NaN;}
		catch (IndexOutOfBoundsException e) {System.out.println("indexe " + a + " n existe pas");
	        return Float.NaN;
	    }
	}
	public void clearC() {pile.clear();}
	//think about adding swapC and addC if needed
	public void pushA() {this.pushC(accumulateur);}
	public void clearA() {accumulateur=Float.NaN;}
	//We'll probably change this function to link it with the interface later on 
	public float showA() {return accumulateur;}
	public int sizeC() {return pile.size();}
	

	public static void main(String[] args) {
		CalculatorModel C=new CalculatorModel();
		
//		View v = new View();
		 
//		
//		C.pushC(5);
//		C.pushC(3);
//		C.pushC(2);
//		C.multiplyC();
//		System.out.println(C.peekC());
//		C.pushC(9);
//		C.pushC(11);
//		System.out.println(C.peekC());
//		C.popC();
//		C.clearC();
////		System.out.println(C.peekC());
//		C.popC();
//		System.out.println(C.peekC());
	}

}