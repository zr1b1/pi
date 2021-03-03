/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PIClass;

/**
 *
 * @author HP
 */
public class prev extends user
{
    private String type;

    public prev(int id_user, String username, String password, String mail, String date_n, String type) {
        super(id_user, username, password, mail, date_n);
        this.type = type;
    }

    public prev()
    {}

    @Override
    public String toString() 
    {
        return super.toString()+ "prev{" + "type=" + type + '}';
    }

    public int getId_user() 
    {
        return id_user;
    }

    public void setId_user(int id_user) 
    {
        this.id_user = id_user;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getMail() 
    {
        return mail;
    }

    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getDate_n() 
    {
        return date_n;
    }

    public void setDate_n(String date_n) 
    {
        this.date_n = date_n;
    }
    
    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    
    public int compare(prev o1, prev o2)
    {
        return o1.getType().compareTo(o2.getType());
    }
    
}
