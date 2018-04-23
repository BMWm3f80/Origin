package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Vendor implements Initializable {
    public Label username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void GetUser(String user){
        username.setText(user);

    }
}
