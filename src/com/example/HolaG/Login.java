package com.example.HolaG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import db.DBAdapter;

public class Login extends Activity
{
   public static Datos login = new Datos(); // objeto para validar datos de login
    /** Called when the activity is first created. */

    private Button iniciar, registrar;
    private EditText user,pass;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = (EditText) findViewById(R.id.txtRfc); //campo de usuario
        pass = (EditText) findViewById(R.id.etPass); //campo de password

        registrar = (Button)findViewById(R.id.btRegistrar);
        iniciar = (Button) findViewById(R.id.btIniciar); // boton iniciar

       final DBAdapter bd = new DBAdapter(getApplicationContext());

        iniciar.setOnClickListener(new View.OnClickListener() {
            int contador = 0;
            @Override
            public void onClick(View v) {
                //validar los datos de login con la informacion que se tiene en la BD
//                if(login.validarLogin(user.getText().toString(), pass.getText().toString()))
                if(bd.validarLogin(user.getText().toString(),pass.getText().toString())){

                    Toast.makeText(getApplication(),"Login Correcto",Toast.LENGTH_SHORT).show();
                    //user.setText("");
                    //pass.setText("");
                    contador = 0;
                    irFactura();
                }
                else{
                    contador ++;
                    if(contador == 5)
                    {
                        contador=0;
                        Toast.makeText(getApplication(),"Demasiados intentos ",Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(getApplication(), "Datos Erroneos ", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        pass.setText("");
                    }
                }
            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
               // WebService ws = new WebService();
            }

        });

    }
    public void irRegistro()
    {
        Intent Act=new Intent(this,RegistroUsuario1.class);
        startActivity(Act);
    }

    public void irFactura(){
        Intent act = new Intent(this,HacerFactura.class);
        act.putExtra("Usuario",user.getText().toString());
        startActivity(act);
    }

    public void registrarUsuario(String user, String pass){
        login.addLogin(user,pass);
    }
}
