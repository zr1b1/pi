/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import PIClass.simple;
import PIServices.servicesimple;
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
public class ModifProfilController implements Initializable {

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void update(ActionEvent event) throws IOException {
        servicesimple ss= new servicesimple();
        ss.Modifier(new simple ((Integer.parseInt(tfIdU.getText())), tfUsernameU.getText(), tfPasswordU.getText(), tfMailU.getText(), java.sql.Date.valueOf((tfDateU.getValue()))) );
        
        JOptionPane.showMessageDialog(null,"User modified");
        
        FXMLLoader loader2= new FXMLLoader(getClass().getResource("Profil.fxml"));
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
