/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.prev;
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
public class serviceprev implements Iservice <prev>
{

    @Override
    public void Ajouter(prev t) 
    {
        String requete="INSERT INTO priv(id_user,username, password, mail, date_n, type)"
               + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getPassword());
            pst.setString(4, t.getMail());
            pst.setString(5, t.getDate_n());
            pst.setString(6, t.getType());
            pst.executeUpdate();
            System.out.println("Utilisateur priviligié ajoutee !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(prev t) 
    {
        String requete = "DELETE FROM priv WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.executeUpdate();
            System.out.println("Utilisateur priviligié Supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(prev t) 
    {
        String requete = "UPDATE priv SET username=?, password=? ,mail=? ,date_n=?WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(5, t.getId_user());
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getPassword());
            pst.setString(3, t.getMail());
            pst.setString(4, t.getDate_n());
            pst.executeUpdate();
            System.out.println("utilisateur priviligié Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<prev> afficher() 
    {
        List<prev> list = new ArrayList<>();
        
        String requete = "SELECT * FROM priv";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new prev(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }    

    @Override
    public List<prev> userListe() 
    {
        List<prev> list = new ArrayList<>();
        
        String requete = "SELECT * FROM priv";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                prev p =new prev();
                p.setId_user(rs.getInt("id_user"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                p.setMail(rs.getString("mail"));
                p.setDate_n(rs.getString("date_n"));
                p.setType(rs.getString("type"));
                list.add(p);
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<prev> TrieParUsername() 
    {
        List<prev> list = this.userListe();
        Collections.sort(list, new prev());
        Collections.reverse(list);
        return list;
    }

//    @Override
//    public void recherche(prev t) 
//    {
//        String requete = "SELECT id_user, username, mail, date_n, type FROM priv WHERE id_user= ?";
//        try 
//        {
//            PreparedStatement pst = new MyConnection().cn.prepareStatement(requete);
//            ResultSet rs = pst.executeQuery(requete);
//            pst.setInt(1, t.getId_user());
//            while (rs.next())
//            {
//                int id_user = rs.getInt("id_user");
//                String username0 = rs.getString("username");
//                String mail0 = rs.getString("mail");
//                String date_n0 = rs.getString("date_n");
//                String type0 = rs.getString("type");
//                System.out.println("username : " + username0+ " mail : " + mail0 + " date_n : " + date_n0 + " type ; " + type0);
//            }
//        } catch (SQLException e1) 
//        {
//            e1.printStackTrace();
//        } 
//    }

    
}
