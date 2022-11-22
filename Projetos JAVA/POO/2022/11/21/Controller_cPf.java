import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Controller_cPf {

    @FXML
    private TextField entradaCelsius;

    @FXML
    private Label lblResultado;

    @FXML
    void btConverter(ActionEvent event) {

        try {
            int tempFahr = (int)((Double.parseDouble(entradaCelsius.getText()))* 1.8 + 32);
            lblResultado.setText(tempFahr + " Fahrenheit");
        } catch (Exception e) {
            lblResultado.setText("Usa o \n Programa \n Direito.");
        }

    }
}