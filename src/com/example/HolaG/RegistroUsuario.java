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
public class RegistroUsuario extends Activity {

    private Button registrar;
    private EditText user,pass,nombre,apellido,direccion,tel,mail,cp;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);
        user = (EditText) findViewById(R.id.etUsuario); //campo de usuario
        pass = (EditText) findViewById(R.id.etPassword); //campo de password
        pass = (EditText) findViewById(R.id.etPassword); //campo de password
        pass = (EditText) findViewById(R.id.etPassword); //campo de password
        pass = (EditText) findViewById(R.id.etPassword); //campo de password
        pass = (EditText) findViewById(R.id.etPassword); //campo de password

        registrar = (Button)findViewById(R.id.btRegistrar);

        final Datos login = new Datos();
        DBAdapter bd = new DBAdapter(this.getApplicationContext());

        registrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

//                login.addLogin(user.getText().toString(), pass.getText().toString());

                bd.agregar( user.getText().toString(),

                        );

                Toast.makeText(getApplication(),"Registro Exitoso",Toast.LENGTH_SHORT).show();
                irLogin();
            }
        });
    }
    public void irLogin()
    {
        Intent Act=new Intent(this,Login.class);
        startActivity(Act);
    }
}
