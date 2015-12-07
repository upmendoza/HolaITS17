package com.example.HolaG;

import java.util.LinkedList;

/**
 * Created by Jorge on 17/11/15.
 */
public class Datos {
    private LinkedList user;
    private LinkedList password;

    public Datos() {
        user = new LinkedList();
        password = new LinkedList();
        user.add("jorge");
        password.add("123");
        user.add("juan");
        password.add("123");
    }
    public void addLogin(String user, String password){
        this.user.add(user);
        this.password.add(password);
    }

    public boolean validarLogin(String user, String password){
        if(this.user.contains(user) && this.password.contains(password))
            return true;
        else
            return false;
    }
}
