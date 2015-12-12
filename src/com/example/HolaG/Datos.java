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
        user.add("juan");
        password.add("123");

        folios = new LinkedList();
        folios.add("12345678");
        folios.add("12345123");
        folios.add("42345678");
        folios.add("11223344");
        folios.add("11226378");
        folios.add("87654321");

    }
    public void addLogin(String user, String password){
        this.user.add(user);
        this.password.add(password);
    }

    public boolean validarLogin(String user, String password){
        if(this.user.contains(user) && this.password.contains(password)) {
            folios.clear();
            return true;
        }
        else
            return false;
    }

    public boolean validaFolio(String folio){
        if(folios.contains(folio))
            return true;
        else
            return false;
    }
}
