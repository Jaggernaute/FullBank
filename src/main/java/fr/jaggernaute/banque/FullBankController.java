package fr.jaggernaute.banque;

import io.github.cdimascio.dotenv.Dotenv;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.*;

public class FullBankController {
    private static String idInput;
    @FXML
    private Text welcome_message;
    @FXML
    private TextField idFeild;
    @FXML
    private TextField passwordField;

    private boolean b = false;
    private String passwordInput;
    protected static String bddPassword;
    protected static String bddName;
    protected  static String advisor;
    @FXML
    protected void onSignInPress() throws ClassNotFoundException {

        passwordInput = passwordField.getText();
        idInput = idFeild.getText();

        connectionRequest();

        if (!b) {
            if(passwordInput.equals(bddPassword)){
                welcome_message.setText("welcome " + bddName);
            }else {
                welcome_message.setText("Kamoulox !");

            }
            b = true;
        } else {
            welcome_message.setText("");
            b = false;
        }
    }

    public static void connectionRequest() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());

            Dotenv dotenv = Dotenv.configure().load();
            String bddpass = dotenv.get("PASSWORD");
            String bdduser = dotenv.get("USER");
            String url = dotenv.get("URL");

            assert url != null;
            Connection conn = DriverManager.getConnection(url, bdduser, bddpass);
            Statement stmt = conn.createStatement();

            String sql = "SELECT user.password, user.fname, staff.name " +
                         "FROM fulbank.user " +
                         "inner join staff " +
                         "on advisor=staff.id " +
                         "where user.fname = ?" +
                         "and staff.id = advisor";

            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setString(1, idInput);

            ResultSet rs;

            rs = prep.executeQuery();
            String result;

            while (rs.next())
            {
                bddPassword = rs.getString(1);
                bddName = rs.getString(2);
                advisor = rs.getString(3);
                System.out.println("name : " + bddName);
                System.out.println("password : " + bddPassword);
                System.out.println("advisor : " + advisor);
             }

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}