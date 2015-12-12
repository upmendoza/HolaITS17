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
    //private EditText rfc,pass;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);
       // rfc = (EditText) findViewById(R.id.txtRfc); //campo de usuario
        //pass = (EditText) findViewById(R.id.txtPassword); //campo de password
        /*nombre = (EditText) findViewById(R.id.txtNombre); //campo de nombre
        apellido = (EditText) findViewById(R.id.txtApellido); //campo de apellido
        direccion = (EditText) findViewById(R.id.txtDireccion); //campo de direccion
        tel = (EditText) findViewById(R.id.txtTelefono); //campo de telefono
        mail = (EditText) findViewById(R.id.txteMail); //campo de email
        cp = (EditText) findViewById(R.id.txtCodigoPostal); //campo de codigo postal*/

        continuar = (Button)findViewById(R.id.btnContinuar);

       // final Datos login = new Datos();
        //final DBAdapter bd = new DBAdapter(this.getApplicationContext());// ponia el error que tenia qe ser final

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
                irRegistroUsuarios2();
            }
        });
    }
    public void irRegistroUsuarios2()
    {
        Intent Act=new Intent(this,RegistroUsuario2.class);
        startActivity(Act);
    }
}
