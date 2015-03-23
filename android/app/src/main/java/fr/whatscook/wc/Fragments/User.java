package fr.whatscook.wc.Fragments;

/**
 * Created by Benjamin on 23/03/2015.
 */
public class User {


    public String name;
    public String passwd;
    public User(String name,String passwd){
        this.name=name;
        this.passwd=passwd;
    }
    public String getPasswd() {
        return passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
