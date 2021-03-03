/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.user;
import PIUtils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author HP
 */
public class serviceuser implements Iservice <user>{

    @Override
    public void Ajouter(user t)
    {
        String requete="INSERT INTO user(id_user,username, password, mail, date_n)"
               + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getPassword());
            pst.setString(4, t.getMail());
            pst.setString(5, t.getDate_n());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoutee !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(user t)
    {
        String requete = "DELETE FROM user WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.executeUpdate();
            System.out.println("Utilisateur Supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(user t) 
    {
        String requete = "UPDATE user SET username=?, password=? ,mail=? ,date_n=?WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(5, t.getId_user());
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getPassword());
            pst.setString(3, t.getMail());
            pst.setString(4, t.getDate_n());
            pst.executeUpdate();
            System.out.println("utilisateur Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<user> afficher() 
    {
        List<user> list = new ArrayList<>();
        
        String requete = "SELECT * FROM user";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new user(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<user> userListe() 
    {
        List<user> list = new ArrayList<>();
        
        String requete = "SELECT * FROM user";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                user u =new user();
                u.setId_user(rs.getInt("id_user"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setMail(rs.getString("mail"));
                u.setDate_n(rs.getString("date_n"));
                
                list.add(u);
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<user> TrieParUsername() 
    {
        List<user> list = this.userListe();
        Collections.sort(list, new user());
        Collections.reverse(list);
        return list;
    }
    
    
}

