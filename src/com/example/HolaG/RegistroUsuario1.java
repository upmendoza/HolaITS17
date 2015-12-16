package com.example.HolaG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import db.DBAdapter;

/**
 * Created by Jorge on 25/11/15.
 */
public class RegistroUsuario1 extends Activity {

    private Button continuar;
    private EditText rfc,pass,Rpass;
    //private String rfcs[]=new String[]{"JUHA7807197W7","URDJ940617","MAFJ920217"};


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);
        rfc = (EditText) findViewById(R.id.txtRfc); //campo de usuario
        pass = (EditText) findViewById(R.id.txtPassword); //campo de password
        Rpass = (EditText) findViewById(R.id.txtRPass); //campo de password


        final DBAdapter bd = new DBAdapter(this.getApplicationContext());// ponia el error que tenia qe ser final

        continuar = (Button)findViewById(R.id.btnContinuar);// se hace referencia de btnContinuar con el nombre continuar

       // final Datos login = new Datos();
        //listener para avanzar a la parte 2 de el registro de usuario
        continuar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                login.addLogin(user.getText().toString(), pass.getText().toString());
/*
                if (bd.agregar(nombre.getText().toString(),
                        apellido.getText().toString(),
                        direccion.getText().toString(),
                        tel.getText().toString(),
                        mail.getText().toString(),
                        cp.getText().toString(),
                        rfc.getText().toString(),
                        pass.getText().toString()) != -1) {


                    Toast.makeText(getApplication(), "Registro Exitoso ", Toast.LENGTH_SHORT).show();
                    irLogin();
                } else {
                    Toast.makeText(getApplication(), "Usuario Duplicado ", Toast.LENGTH_LONG).show();
                }*/
                //--- Compara los campos de texto de contraseña y repetir contraseña
                if(pass.getText().toString().equals(Rpass.getText().toString()))
                {
                    //Verifica que el rfc que ha sido añadido concuerde con los de la base de datos
                    if(bd.validarLogin2(rfc.getText().toString()))
                    {
                        regresarLogin();//si coinside en alguna parte significa que ya esta registrado el usuario y lo manda a login nuevamente
                    }
                    else//si no se encuentra en la base de datos sqlLite entonces manda a el web service a buscarlos
                    {
                        HttpHandler httpHandler = new HttpHandler();//Se crea el objeto de la clase HttpHander para buscar en el webService
                        final String[] resp = httpHandler.Login(rfc.getText().toString(),pass.getText().toString());

                        if(resp[0].equals("1"))//si el arreglo resp regresa 1 de la busqueda
                        {
                            //marca que el usuario ya ha sido registrado
                            Toast.makeText(getApplication(),"Usuario ya esta registrado ",Toast.LENGTH_LONG).show();
                        }
                        else
                            //Si no ha sido registrado el usuario entonces sera redireccionado a la segunda parte de registro de usuario
                            irRegistroUsuarios2();
                    }
                }
                else//else si son las contraseñas iguales
                {
                    //manda texto en pantalla para el usuario de error en las contraseñas
                    Toast.makeText(getApplication(),"Las contraseñas no coinciden ",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //------------- Metodo para redireccionar a registro de usuarios segunda parte -----------
    public void irRegistroUsuarios2()
    {
        Intent Act=new Intent(this,RegistroUsuario2.class);//se crea un intent para ir a la clase registro usuarios parte 2
        Act.putExtra("rfc",rfc.getText().toString());//mandara esta variable a registro usuarios2
        Act.putExtra("password",pass.getText().toString());//mandara esta variable a registro usuarios2
        startActivity(Act);
    }
    //---------------------------------------------------------------------------------------
    // ---------------------------  metodo para ir al login --------------------------------
    public void regresarLogin()
    {
        Intent Act=new Intent(this,Login.class);
        startActivity(Act);
    }
    //----------------------------------------------------------------------------------------

}
