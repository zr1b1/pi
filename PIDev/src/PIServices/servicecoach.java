/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIServices;

import PIClass.coach;
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
public class servicecoach implements Iservice <coach>
{
    @Override
    public void Ajouter(coach t) 
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
            System.out.println("Coach ajouté !");

            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void Supprimer(coach t) 
    {
        String requete = "DELETE FROM coach WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(1, t.getId_user());
            pst.executeUpdate();
            System.out.println("Coach supprimé !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void Modifier(coach t) 
    {
        String requete = "UPDATE coach SET username=?, password=?, date_n=? WHERE id_user=?";
        try {
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            pst.setInt(5, t.getId_user());
            pst.setString(1, t.getUsername());
            pst.setString(2, t.getPassword());
            pst.setDate(4, (Date) t.getDate_n());
            pst.executeUpdate();
            System.out.println("Coach modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<coach> afficher() 
    {
        List<coach> list = new ArrayList<>();
        
        String requete = "SELECT * FROM coach";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new coach(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }    

    @Override
    public List<coach> userListe() 
    {
        List<coach> list = new ArrayList<>();
        
        String requete = "SELECT * FROM coach";
        try {
            
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                coach c =new coach();
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
    public List<coach> TrieParUsername() 
    {
        List<coach> list = this.userListe();
        Collections.sort(list, new coach());
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

    @Override
    public List<coach> recherche(String Xusername) 
    {
        ArrayList<coach> ListCoachUsername = new ArrayList<>();
        try {
            String req = "Select username, mail, date_n from coach where username=?";
            PreparedStatement pst = 
                    new MyConnection().cn.prepareStatement(req);
            pst.setString(1, Xusername);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                coach c = new coach();
                c.setUsername(rs.getString(1));
                c.setMail(rs.getString(2));
                c.setDate_n(rs.getDate(3));
                if (c.getUsername().equals(Xusername))
                {
                    ListCoachUsername.add(c);
                } 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (ListCoachUsername.isEmpty()) {
            System.out.println("Cet utilisateur n'éxiste pas.");
        }
        return ListCoachUsername;
    }  
}
    
//    //comparator Date
//    public static Comparator<Article> ArticleComparatorDate = (Article s1, Article s2) -> {
//        Date d1 = s1.getDate_art();
//        Date d2 = s2.getDate_art();
//        return d1.compareTo(d2);
//    }

