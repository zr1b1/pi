/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.simple;
import PIUtils.MyConnection;
import java.sql.Date;
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
public class servicesimple implements Iservice <simple>{

    @Override
    public void Ajouter(simple t)
    {
        String requete="INSERT INTO simple(id_user, username, password, mail, date_n)"
               + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getPassword());
            pst.setString(4, t.getMail());
            pst.setDate(5, (Date) t.getDate_n());
            pst.executeUpdate();
            System.out.println("Utilisateur ajoutee !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(simple t)
    {
        String requete = "DELETE FROM simple WHERE id_user=?";
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
    public void Modifier(simple t) 
    {
        String requete = "UPDATE simple SET id_user=?, username=?, mail=?, date_n=? WHERE password=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getMail());
            pst.setDate(4, (Date) t.getDate_n());
            pst.setString(5, t.getPassword());
            pst.executeUpdate();
            System.out.println("utilisateur Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<simple> afficher() 
    {
        List<simple> list = new ArrayList<>();
        
        String requete = "SELECT * FROM simple";
        try {            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new simple(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<simple> userListe() 
    {
        List<simple> list = new ArrayList<>();
        
        String requete = "SELECT * FROM simple";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                simple u =new simple();
                u.setId_user(rs.getInt("id_user"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setMail(rs.getString("mail"));
                u.setDate_n(rs.getDate("date_n"));
                
                list.add(u);
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<simple> TrieParUsername() 
    {
        List<simple> list = this.userListe();
        Collections.sort(list, new simple());
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<simple> recherche(String Xusername)
    {
        ArrayList<simple> ListSimpleUsername = new ArrayList<>();
        try {
            String req = "Select username, mail, date_n from simple where username=?";
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(req);
            pst.setString(1, Xusername);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                simple c = new simple();
                c.setUsername(rs.getString(1));
                c.setMail(rs.getString(2));
                c.setDate_n(rs.getDate(3));
                if (c.getUsername().equals(Xusername))
                {
                    ListSimpleUsername.add(c);
                } 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (ListSimpleUsername.isEmpty()) {
            System.out.println("Cet utilisateur n'éxiste pas.");
        }
        return ListSimpleUsername;
    }
}

