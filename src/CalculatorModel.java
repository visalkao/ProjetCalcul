import java.util.*;
public class CalculatorModel {
	private float accumulateur;
	private Stack<Float> pile;
	
	public CalculatorModel() {
        this.accumulateur =Float.NaN;
        this.pile = new Stack<Float>();
    }
	public float pushC(float a) {
		pile.push(a);
		return a;}
	//instead of drop we'll use popC
	public float popC() {
		try {return pile.pop();}
		catch(EmptyStackException e) {System.out.println("la pile est vide");return Float.NaN;}
	}
	public float peekC() {
		try {return pile.peek();}
		catch(EmptyStackException e) {System.out.println("la pile est vide");return Float.NaN;}
	}
	public void clearC() {pile.clear();}
	//think about adding swapC and addC if needed
	public void pushA() {this.pushC(accumulateur);}
	public void clearA() {accumulateur=Float.NaN;}
	//We'll probably change this function to link it with the interface later on 
	public void showA() {System.out.println(accumulateur);}

}
