package com.example.HolaG;

import java.util.LinkedList;

/**
 * Created by Jorge on 17/11/15.
 */
public class Datos {
    private LinkedList user;
    private LinkedList password;
    private LinkedList folios;

    public Datos() {
        user = new LinkedList();
        password = new LinkedList();
        user.add("jorge");
        password.add("123");

        folios = new LinkedList();
        folios.add("12345678");
        folios.add("87654321");
        folios.add("43215678");
        folios.add("19543687");
        folios.add("22451293");

    }

    public boolean validarFolio(String folio){
        if(this.folios.contains(folio))
            return true;
        else
            return false;
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
