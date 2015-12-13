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

        continuar = (Button)findViewById(R.id.btnContinuar);

       // final Datos login = new Datos();

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
                if(pass.getText().toString().equals(Rpass.getText().toString()))
                {
                    if(bd.validarLogin2(rfc.getText().toString()))
                    {
                        regresarLogin();
                        Toast.makeText(getApplication(),"Usuario ya esta registrado ",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        irRegistroUsuarios2();
                    }
                }
                else
                {
                    Toast.makeText(getApplication(),"Las contraseñas no coinsiden ",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public void irRegistroUsuarios2()
    {
        Intent Act=new Intent(this,RegistroUsuario2.class);
        Act.putExtra("rfc",rfc.getText().toString());
        Act.putExtra("password",pass.getText().toString());
        startActivity(Act);
    }
    public void regresarLogin()
    {
        Intent Act=new Intent(this,Login.class);
        startActivity(Act);
    }

}
