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
public class CreateSimpleController implements Initializable {

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnConfirm;
    @FXML
    private TextField tfMail;
    @FXML
    private TextField tfUsername;
    @FXML
    private DatePicker tfDate;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfId;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutersimple(ActionEvent event) throws IOException 
    {
        servicesimple ss= new servicesimple();
        ss.Ajouter( new simple ((Integer.parseInt(tfId.getText())), tfUsername.getText(), tfPassword.getText(), tfMail.getText(), java.sql.Date.valueOf((tfDate.getValue()))) );
        
        JOptionPane.showMessageDialog(null,"User added");
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("profil.fxml"));
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
