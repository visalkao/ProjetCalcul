
public class Controler {

	public static void main(String[] args) {
		CalculatorModel C=new CalculatorModel();
		C.pushC(5);
		C.pushC(3);
		C.pushC(2);
		System.out.println(C.peekC());
		C.pushC(9);
		C.pushC(11);
		C.popC();
		C.clearC();
		System.out.println(C.peekC());

	}

}
