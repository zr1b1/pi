/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.nutri;
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
public class servicenutri implements Iservice <nutri>
{
    @Override
    public void Ajouter(nutri t) 
    {
        String requete="INSERT INTO coach(id_user,username, password, mail, date_n, code)"
               + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getPassword());
            pst.setString(4, t.getMail());
            pst.setDate(5, (Date) t.getDate_n());
            pst.setString(6, t.getCode());
            pst.executeUpdate();
            System.out.println("Nutritionniste ajouté !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(nutri t) 
    {
        String requete = "DELETE FROM nutri WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.executeUpdate();
            System.out.println("Nutritionniste supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(nutri t) 
    {
        String requete = "UPDATE nutri SET username=?, password=?, date_n=? WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(5, t.getId_user());
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getPassword());
            pst.setDate(4, (Date) t.getDate_n());
            pst.executeUpdate();
            System.out.println("Nutritionniste modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<nutri> afficher() 
    {
        List<nutri> list = new ArrayList<>();
        
        String requete = "SELECT * FROM nutri";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new nutri(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }    

    @Override
    public List<nutri> userListe() 
    {
        List<nutri> list = new ArrayList<>();
        
        String requete = "SELECT * FROM nutri";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                nutri c =new nutri();
                c.setId_user(rs.getInt("id_user"));
                c.setUsername(rs.getString("username"));
//                c.setPassword(rs.getString("password"));
                c.setMail(rs.getString("mail"));
                c.setDate_n(rs.getDate("date_n"));
//                c.setCode(rs.getString("code"));
                list.add(c);
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public List<nutri> TrieParUsername() 
    {
        List<nutri> list = this.userListe();
        Collections.sort(list, new nutri());
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<nutri> recherche(String Xusername) 
    {
        ArrayList<nutri> ListNutriUsername = new ArrayList<>();
        try {
            String req = "Select username, mail, date_n from nutri where username=?";
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(req);
            pst.setString(1, Xusername);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                nutri n = new nutri();
                n.setUsername(rs.getString(1));
                n.setMail(rs.getString(2));
                n.setDate_n(rs.getDate(3));
                if (n.getUsername().equals(Xusername))
                {
                    ListNutriUsername.add(n);
                } 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (ListNutriUsername.isEmpty()) {
            System.out.println("Cet utilisateur n'éxiste pas.");
        }
        return ListNutriUsername;
    }
}
