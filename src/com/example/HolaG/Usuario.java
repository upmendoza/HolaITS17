package com.example.HolaG;

/**
 * Created by Jorge on 09/12/15.
 */
public class Usuario {
    //Se declaran variables protegidas con todas las variables que contendra la tabla usuario
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String telefono;
    protected String email;
    protected String codigoPostal;
    protected String user;
    protected String password;
    //--------------------------------------------------------------------------------------
    // metodo el cual resive parametros para añadirles valor a las variables privadas de la clase
    public Usuario(int id, String nombre, String apellido, String direccion, String telefono, String email, String codigoPostal, String user, String password) {
        this.id = id;//obtiene el dato resivido de id
        this.nombre = nombre;//obtiene el dato resivido de nombre
        this.apellido = apellido;//obtiene el dato resivido de apellido
        this.direccion = direccion;//obtiene el dato resivido de direccion
        this.telefono = telefono;//obtiene el dato resivido de telefono
        this.email = email;//obtiene el dato resivido de email
        this.codigoPostal = codigoPostal;//obtiene el dato resivido de codigo postal
        this.user = user;//obtiene el dato resivido de usuario
        this.password = password;//obtiene el dato resivido de password
    }
    //--------------------------------------------------------------------------------------
    //---------------------------- metodo get para id -------------------------------------
    public int getId() {
        return id;
    }
    //---------------------------- metodo set para id -------------------------------------
    public void setId(int id) {
        this.id = id;
    }
    //---------------------------- metodo get para nombre -------------------------------------
    public String getNombre() {
        return nombre;
    }
    //---------------------------- metodo set para nombre -------------------------------------
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //---------------------------- metodo get para apellido -------------------------------------
    public String getApellido() {
        return apellido;
    }
    //---------------------------- metodo set para apellido -------------------------------------
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    //---------------------------- metodo get para direccion -------------------------------------
    public String getDireccion() {
        return direccion;
    }
    //---------------------------- metodo set para direccion -------------------------------------
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    //---------------------------- metodo get para telefono -------------------------------------
    public String getTelefono() {
        return telefono;
    }
    //---------------------------- metodo set para telefono -------------------------------------
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //---------------------------- metodo get para email -------------------------------------
    public String getEmail() {
        return email;
    }
    //---------------------------- metodo set para email -------------------------------------
    public void setEmail(String email) {
        this.email = email;
    }
    //---------------------------- metodo get para codigo postal -------------------------------------
    public String getCodigoPostal() {
        return codigoPostal;
    }
    //---------------------------- metodo set para codigoPostal -------------------------------------
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    //---------------------------- metodo get para usuario -------------------------------------
    public String getUser() {
        return user;
    }
    //---------------------------- metodo set para usuario -------------------------------------
    public void setUser(String user) {
        this.user = user;
    }
    //---------------------------- metodo get para password -------------------------------------
    public String getPassword() {
        return password;
    }
    //---------------------------- metodo set para password -------------------------------------
    public void setPassword(String password) {
        this.password = password;
    }
}
