/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import PIClass.*;
import PIServices.serviceprev;
import PIServices.serviceuser;
import PIUtils.MyConnection;

/**
 *
 * @author HP
 */
public class PIDev {

    public static void main(String[] args) 
    {
        MyConnection mc =new MyConnection();
        serviceuser su = new serviceuser();
        serviceprev sp = new serviceprev();
        user u1= new user(1,"A", "azety", "mourad.zribi@esprit.tn", "13/05/99");
        prev p1= new prev(7,"AwA","azerty", "xxx@yyy.z","01/01/1990" ,"Z");
        //su.Ajouter(u1);
        //su.Supprimer(u1);
        //su.Modifier(u1);
        //su.afficher().forEach(System.out::println);
        //System.out.println(" == ");
        //su.TrieParUsername().forEach(System.out::println);
        //___________________________________________________
        //sp.Ajouter(p1);
        //sp.Supprimer(p1);
        //sp.Modifier(p1);
        //sp.afficher().forEach(System.out::println);
        //System.out.println(" == ");
        //sp.TrieParUsername().forEach(System.out::println);
    }
    
}
