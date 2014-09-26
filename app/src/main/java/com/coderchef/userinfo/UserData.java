package com.coderchef.userinfo;

/**
 * Created by riajur on 9/6/2014.
 */
public class UserData {
    private String username;
    private String password;
    private String email;

    public UserData(){};
    public UserData(String email,String username,String password){
        super();
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public  void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

}
