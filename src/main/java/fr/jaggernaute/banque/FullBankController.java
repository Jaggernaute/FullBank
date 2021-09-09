package fr.jaggernaute.banque;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FullBankController {
    @FXML
    private Text welcome_message;
    @FXML
    private TextField id;
    @FXML
    private TextField password;
    private boolean b = false;

    private String fakeID = "Noé";
    private String fakePassword = "joe";

    @FXML
    protected void onSignInPress() {
        if (!b) {
            if(id.getText().equals(fakeID) && password.getText().equals(fakePassword)){
                welcome_message.setText("welcome " + id.getText());
            }else {
                welcome_message.setText("Kamoulox !");
            }
            b = true;
        } else {
            welcome_message.setText("");
            b = false;
        }
    }
}