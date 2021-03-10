/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIGui;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ProfilController implements Initializable {

    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSignOut;
    @FXML
    private Label lbUsername;
    @FXML
    private Label lbMail;
    @FXML
    private Label lbId;
    @FXML
    private Label lbDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void edit(ActionEvent event) throws IOException 
    {
        FXMLLoader loader2= new FXMLLoader(getClass().getResource("Modifprofil.fxml"));
        Parent root0= loader2.load();
        btnSignOut.getScene().setRoot(root0);
    }

    @FXML
    private void search(ActionEvent event) 
    {
        
    }

    @FXML
    private void signout(ActionEvent event) 
    {
        
    }
    
    public void setLbUsername(String username) {
        this.lbUsername.setText(username);
    }

    public void setLbMail(String mail) {
        this.lbMail.setText(mail);
    }

    public void setLbId(int id) {
        this.lbId.setText(String.valueOf(id));
    }

    public void setLbDate(Date date) {
        this.lbDate.setText(date.toString());
    }
}
