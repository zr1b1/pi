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
public class CreateCoachController implements Initializable {

    @FXML
    private TextField tfId;
    @FXML
    private TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfMail;
    @FXML
    private DatePicker tfDate;
    @FXML
    private TextField tfCode;
    @FXML
    private Button btnConfirm;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_psy(ActionEvent event) throws IOException 
    {
        servicecoach sc= new servicecoach();
        sc.Ajouter(new coach ((Integer.parseInt(tfId.getText())), tfUsername.getText(), tfPassword.getText(), tfMail.getText(), java.sql.Date.valueOf((tfDate.getValue())), tfCode.getText()) ) ;
        
        JOptionPane.showMessageDialog(null,"Coach added");
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("profilCoach.fxml"));
        Parent root= loader.load();
        tfUsername.getScene().setRoot(root);
       
        ProfilController pc= loader.getController();
        pc.setLbId(Integer.parseInt(tfId.getText()));
        pc.setLbUsername(tfUsername.getText());
        pc.setLbMail(tfMail.getText());
        pc.setLbDate(java.sql.Date.valueOf(tfDate.getValue()));

    }

    @FXML
    private void cancel_create(ActionEvent event) throws IOException 
    {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Create.fxml"));
        Parent root= loader.load();
        btnCancel.getScene().setRoot(root);
    }
    
}
