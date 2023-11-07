import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
interface ControlerInterface {

	  
	    void changetxt(Text[] txt);
	    void setButtonHandlers(Button[] numberButtons, Button plusSign, Button sustractSign, Button multipleSign, Button divideSign, Button addToStackButton, Button clearButton, Button commaButton, Button changeSign, Button swap);

}
