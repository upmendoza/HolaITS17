package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity
{
    /** Called when the activity is first created. */

    private Button iniciar;
    private EditText user,pass;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = (EditText) findViewById(R.id.etUsuario); //campo de usuario
        pass = (EditText) findViewById(R.id.etPass); //campo de password

        iniciar = (Button) findViewById(R.id.btIniciar); // boton iniciar

        Datos login = new Datos(); // objeto para validar datos de login

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validar los datos de login con la informacion que se tiene en la BD
                if(login.validarLogin(user.getText().toString(), pass.getText().toString()))
                    Toast.makeText(getApplication(),"Login Correcto",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplication(),"Datos Erroneos",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
