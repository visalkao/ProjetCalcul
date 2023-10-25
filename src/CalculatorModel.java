import java.util.*;
//put the interface in another file 
interface CalculatrorModelInterface{
	float pushC(float a);
	public float popC();
	public float peekC();
	public void clearC();
	
}

public class CalculatorModel implements CalculatrorModelInterface {
	private float accumulateur;
	private Stack<Float> pile;
	
	public CalculatorModel() {
        this.accumulateur =Float.NaN;
        this.pile = new Stack<Float>();
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
		accumulateur=this.popC() / accumulateur;
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
	public void swapC() {
		float tmp;
		accumulateur = this.popC();
		tmp = this.popC();
		this.pushC(accumulateur);
		this.pushC(tmp);
	}
	public void clearA() {accumulateur=Float.NaN;}
	//We'll probably change this function to link it with the interface later on 
	public float showA() {return accumulateur;}
	public int sizeC() {return pile.size();}

}