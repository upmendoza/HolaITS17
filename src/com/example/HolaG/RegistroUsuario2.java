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

    //  variables para poder utilizar lo de el layout registro_usuarios2
        private Button registrar;
        private EditText nombre,apellido,direccion,tel,mail,cp;
        private String rfc,pass;
    //-----------------------------------------------------------------


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final Bundle bundle=new Bundle(getIntent().getExtras());//se crea objeto de la clase Bundle
        setContentView(R.layout.registro_usuario2);//se inicializa el layout registro usuario2
        nombre = (EditText) findViewById(R.id.txtNombre); //campo de nombre
        apellido = (EditText) findViewById(R.id.txtApellido); //campo de apellido
        direccion = (EditText) findViewById(R.id.txtDireccion); //campo de direccion
        tel = (EditText) findViewById(R.id.txtTelefono); //campo de telefono
        mail = (EditText) findViewById(R.id.txteMail); //campo de email
        cp = (EditText) findViewById(R.id.txtCodigoPostal); //campo de codigo postal
        rfc=bundle.getString("rfc");//se obtiene el valor mediante bundle de la clase registro usuario1
        pass=bundle.getString("password");//se obtiene el valor mediante bundle de la clase registro usuario1
        registrar = (Button)findViewById(R.id.btnRegistrar);// se hace referencia de btnRegistrar con el nombre registrar
        final Datos login = new Datos();//se crea objeto de la clase login
        final DBAdapter bd = new DBAdapter(this.getApplicationContext());// ponia el error que tenia qe ser final
        //----- metodo listener que funciona para registrar
        registrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

//                login.addLogin(user.getText().toString(), pass.getText().toString());
                HttpHandler httpHandler = new HttpHandler();
            //registra el nuevo usuario en el web service
            final String resp  = httpHandler.Resgistro(
                    nombre.getText().toString(),//campo nombre
                    apellido.getText().toString(),//campo apellido
                    direccion.getText().toString(),// campo direccion
                    tel.getText().toString(),// campo telefono
                    mail.getText().toString(),// campo correo
                    cp.getText().toString(),// campo codigo postal
                    bundle.getString("rfc"),// campo de el rfc
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
                if(resp.equals("1")){//si la consulta anterior manda un 1 de regreso entonces el usuario es registrado exitosamente

                           Toast.makeText(getApplication(), "Registro Exitoso ", Toast.LENGTH_SHORT).show();//imprime en pantalla registro exitoso para el usuario
                    //se agrega la misma consulta de INSERT a la base de datos sql Lite con los mismos datos
                    if( bd.agregar(nombre.getText().toString(),//campo nombre
                                 apellido.getText().toString(),// campo apellido
                                 direccion.getText().toString(),// campo direccion
                                 tel.getText().toString(),// campo telefono
                                 mail.getText().toString(),// campo correo electronico
                                 cp.getText().toString(),// campo codigo postal
                                 bundle.getString("rfc"), // campo rfc
                                 pass) != -1)
                                irLogin();//metodo que redirecciona a login
                }
                else {
                    //imprime en pantalla que el usuario esta duplicado
                           Toast.makeText(getApplication(), "Usuario Duplicado ", Toast.LENGTH_LONG).show();
                       }
            }
        });
    }
    //------------------ Metodo para mandar a login ------------------------
    public void irLogin()
    {
        Intent Act=new Intent(this,Login.class);
        startActivity(Act);
    }
    //-----------------------------------------------------------------------
}
