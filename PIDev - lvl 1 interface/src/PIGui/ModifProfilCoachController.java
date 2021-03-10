/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import PIClass.coach;
import PIServices.servicecoach;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModifProfilCoachController implements Initializable {

    @FXML
    private DatePicker tfDateU;
    @FXML
    private TextField tfMailU;
    @FXML
    private TextField tfUsernameU;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnCancelU;
    @FXML
    private PasswordField tfPasswordU;
    @FXML
    private TextField tfIdU;
    @FXML
    private TextField tfCodeU;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) throws IOException 
    {
        servicecoach sc= new servicecoach();
        sc.Modifier(new coach ((Integer.parseInt(tfIdU.getText())), tfUsernameU.getText(), tfPasswordU.getText(), tfMailU.getText(), java.sql.Date.valueOf((tfDateU.getValue())), tfCodeU.getText() ));
        
        JOptionPane.showMessageDialog(null,"Coach modified");
        
        FXMLLoader loader2= new FXMLLoader(getClass().getResource("ProfilCoach.fxml"));
        Parent root0= loader2.load();
        btnUpdate.getScene().setRoot(root0);
        
        ProfilController pc= loader2.getController();
        pc.setLbId(Integer.parseInt(tfIdU.getText()));
        pc.setLbUsername(tfUsernameU.getText());
        pc.setLbMail(tfMailU.getText());
        pc.setLbDate(java.sql.Date.valueOf(tfDateU.getValue()));
    }

    @FXML
    private void cancelupdate(ActionEvent event) {
    }
    
}
