/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import PIClass.*;
import PIServices.*;
import PIUtils.MyConnection;

/**
 *
 * @author HP
 */
public class PIDev {

    public static void main(String[] args) 
    {
        MyConnection  mc = new MyConnection();
        
        servicecoach  sc = new servicecoach();
        servicenutri  sn = new servicenutri();
        servicepsycho sp = new servicepsycho();
        servicesimple ss = new servicesimple();
        
        //user u1= new user("Mourad", "azety", "mourad.zribi@esprit.tn", "13/05/99");
        //prev p1= new prev(1778,"IkI","azerty", "bbb@yyy.z","01/01/1990" ,"A","a8b1");
        //Int.valueOf(id_user)
        //su.Ajouter(u1);
        //su.Supprimer(u1);
        //su.Modifier(u1);
        //su.afficher().forEach(System.out::println);
        //System.out.println(" == ");
        //su.TrieParUsername().forEach(System.out::println);
        //su.recherche(u1);
        //les users 
        //___________________________________________________
        
    }
    
}
