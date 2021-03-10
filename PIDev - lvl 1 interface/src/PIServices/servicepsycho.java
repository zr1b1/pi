/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.psycho;
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
public class servicepsycho implements Iservice <psycho>
{
    @Override
    public void Ajouter(psycho t) 
    {
        String requete="INSERT INTO psycho(id_user, username, password, mail, date_n, code)"
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
            System.out.println("Psychologue ajouté !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(psycho t) 
    {
        String requete = "DELETE FROM psycho WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.executeUpdate();
            System.out.println("Psychologue supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(psycho t) 
    {
        String requete = "UPDATE psycho SET id_user=?, username=?, mail=?, date_n=? WHERE password=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.setString(2, t.getUsername());
            pst.setString(3, t.getMail());
            pst.setDate(4, (Date) t.getDate_n());
            pst.setString(5, t.getPassword());
            pst.executeUpdate();
            System.out.println("Psycho modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<psycho> afficher() 
    {
        List<psycho> list = new ArrayList<>();
        
        String requete = "SELECT * FROM psycho";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new psycho(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }    

    @Override
    public List<psycho> userListe() 
    {
        List<psycho> list = new ArrayList<>();
        
        String requete = "SELECT * FROM psycho";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                psycho c =new psycho();
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
    public List<psycho> TrieParUsername() 
    {
        List<psycho> list = this.userListe();
        Collections.sort(list, new psycho());
        Collections.reverse(list);
        return list;
    }
    
    @Override
    public List<psycho> recherche(String Xusername) 
    {
        ArrayList<psycho> ListPsychoUsername = new ArrayList<>();
        try {
            String req = "Select username, mail, date_n from psycho where username=?";
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(req);
            pst.setString(1, Xusername);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                psycho c = new psycho();
                c.setUsername(rs.getString(1));
                c.setMail(rs.getString(2));
                c.setDate_n(rs.getDate(3));
                if (c.getUsername().equals(Xusername))
                {
                    ListPsychoUsername.add(c);
                } 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (ListPsychoUsername.isEmpty()) {
            System.out.println("Cet utilisateur n'éxiste pas.");
        }
        return ListPsychoUsername;
    }
}
