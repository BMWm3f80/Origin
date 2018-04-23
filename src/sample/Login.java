package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control. *;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable {
    public LoginModel loginModel = new LoginModel();
    public Button kirish_button;
    public Label warning_label;
    public Label dbstatus;
    public TextField textIsm;
    public TextField textPassword;

    public void handle_kirish_button(ActionEvent event) throws IOException {
        warning_label.setVisible(true);
        try {
            if (loginModel.isLogin(textIsm.getText(), textPassword.getText())){
                warning_label.setText("Correct");
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage primaryStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                Pane root  = loader.load(getClass().getResource("Vendor.fxml").openStream());
                Vendor vendor  = (Vendor)loader.getController();
                vendor.GetUser(textIsm.getText());
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();

            } else {
                warning_label.setText("Username yoki password xato!!!");
            }
        } catch (SQLException e) {
            warning_label.setText("Username yoki password xato!!!");
            e.printStackTrace();
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (loginModel.isDbConnected()){
            dbstatus.setText("Connected");
        } else {
            dbstatus.setText("No Connection");
        }

    }
}
