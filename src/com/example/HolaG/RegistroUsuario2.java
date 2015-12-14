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
public class RegistroUsuario2 extends Activity {

    private Button registrar;
    private EditText nombre,apellido,direccion,tel,mail,cp;
    private String rfc,pass;


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final Bundle bundle=new Bundle(getIntent().getExtras());
        setContentView(R.layout.registro_usuario2);
        nombre = (EditText) findViewById(R.id.txtNombre); //campo de nombre
        apellido = (EditText) findViewById(R.id.txtApellido); //campo de apellido
        direccion = (EditText) findViewById(R.id.txtDireccion); //campo de direccion
        tel = (EditText) findViewById(R.id.txtTelefono); //campo de telefono
        mail = (EditText) findViewById(R.id.txteMail); //campo de email
        cp = (EditText) findViewById(R.id.txtCodigoPostal); //campo de codigo postal

        rfc=bundle.getString("rfc");
        pass=bundle.getString("password");
        registrar = (Button)findViewById(R.id.btnRegistrar);

        final Datos login = new Datos();
        final DBAdapter bd = new DBAdapter(this.getApplicationContext());// ponia el error que tenia qe ser final

        registrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

//                login.addLogin(user.getText().toString(), pass.getText().toString());
                HttpHandler httpHandler = new HttpHandler();

            final String resp  = httpHandler.Resgistro(
                    nombre.getText().toString(),
                    apellido.getText().toString(),
                    direccion.getText().toString(),
                    tel.getText().toString(),
                    mail.getText().toString(),
                    cp.getText().toString(),
                    bundle.getString("rfc"),
                    pass
                );


//                if( bd.agregar(nombre.getText().toString(),
//                                 apellido.getText().toString(),
//                                 direccion.getText().toString(),
//                                 tel.getText().toString(),
//                                 mail.getText().toString(),
//                                 cp.getText().toString(),
//                                 bundle.getString("rfc"),
//                                 pass) != -1) {
                if(resp.equals("1")){

                           Toast.makeText(getApplication(), "Registro Exitoso ", Toast.LENGTH_SHORT).show();

                    if( bd.agregar(nombre.getText().toString(),
                                 apellido.getText().toString(),
                                 direccion.getText().toString(),
                                 tel.getText().toString(),
                                 mail.getText().toString(),
                                 cp.getText().toString(),
                                 bundle.getString("rfc"),
                                 pass) != -1)
                                irLogin();
                }
                else {
                           Toast.makeText(getApplication(), "Usuario Duplicado ", Toast.LENGTH_LONG).show();

                       }
            }
        });
    }
    public void irLogin()
    {
        Intent Act=new Intent(this,Login.class);
        startActivity(Act);
    }
}