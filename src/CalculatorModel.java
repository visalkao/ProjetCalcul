import java.util.Stack;

public class CalculatorModel {
	private float accumulateur;
	private Stack<Float> pile;
	
	
	
	
	
	
	public CalculatorModel() {
        this.accumulateur =Float.NaN;
        this.pile = new Stack<Float>();
    }
	
	public void setPile(Stack pile) {
		this.pile = pile;
	}
	
	public Stack getPile() {
		return this.pile;
	}
	
	public void setAccumulateur(float accumulator) {
		this.accumulateur = accumulator;
	}
	
	public float getAccumulator() {
		return this.accumulateur;
	}
}