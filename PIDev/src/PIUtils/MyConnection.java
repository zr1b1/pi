/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedbouslah
 */
public class MyConnection {
    public String url = "jdbc:mysql://127.0.0.1:3306/pi";
    public String login="root";
    public String pwd="";
    public Connection cn;
    
    public MyConnection() {
        
        try {
            cn = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connextion etablie !");
        } catch (SQLException ex) {
            System.out.println("Erreur de connextion");
            System.out.println(ex.getMessage());
        }
    }
    
    
}
    
