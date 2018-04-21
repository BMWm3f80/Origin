package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control. *;

public class Login {
    public Button kirish_button;
    public Label warning_label;

    public void handle_kirish_button(){
        warning_label.setVisible(true);
    }


}
