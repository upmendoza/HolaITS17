package com.example.HolaG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import db.DBAdapter;

public class Login extends Activity
{
   public static Datos login = new Datos(); // objeto para validar datos de login
    /** Called when the activity is first created. */

    private Button iniciar;
    private EditText user,pass;
    private TextView reg;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        //se inicializa el layout Login en la clase
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = (EditText) findViewById(R.id.txtRfc); //campo de usuario
        pass = (EditText) findViewById(R.id.etPass); //campo de password

        iniciar = (Button) findViewById(R.id.btIniciar); // boton iniciar
        reg=(TextView)findViewById(R.id.reg);
       final DBAdapter bd = new DBAdapter(getApplicationContext());
//--------- metodo para iniciar la validacion de usuario login
        iniciar.setOnClickListener(new View.OnClickListener() {
            int contador = 0;
            @Override
            public void onClick(View v) {
                //validar los datos de login con la informacion que se tiene en la BD
//                if(login.validarLogin(user.getText().toString(), pass.getText().toString()))
//                if(bd.validarLogin(user.getText().toString(),pass.getText().toString())){
//                if(true){

//                    Toast.makeText(getApplication(),"Login Correcto",Toast.LENGTH_SHORT).show();
                    //user.setText("");
                //pass.setText("");
                //conparacio para verificar si el usuario y la contraseña sean correctas desde la base de datos
                if(bd.validarLogin(user.getText().toString(), pass.getText().toString())){
                    Toast.makeText(getApplication(),"Login Correcto",Toast.LENGTH_SHORT).show();//si el usuario es correcto se mandara un toast con mensaje de aceptacion
                    contador = 0;//controla la cantidad de intentos de conectarse
                    System.out.println("Hice Login AUQI 49");
                    irFactura();//metodo ir factura que manda a hacer factura
                }
                else
                {
                    //se crea un objeto de la clase HttpHandler
                    HttpHandler httpHandler = new HttpHandler();
                    //variable que resive respuesta para ver si se encuentra en el web service
                    final String[] respuesta = httpHandler.Login(user.getText().toString(), pass.getText().toString());//se almacena el resultado
                    if (respuesta[0].equals("1")) //si es 1 entonces es correcto el login
                    {
                        bd.agregar(respuesta[2],respuesta[3],respuesta[4],respuesta[5],respuesta[6],respuesta[7],respuesta[8],respuesta[9]);//se agregan los datos a la base de datos sqllite
                        Toast.makeText(getApplication(), "Login Correcto", Toast.LENGTH_SHORT).show();//mensaje de login correcto para el usuario
                        contador = 0;
                        irFactura();//metodo ir factura que manda a hacer factura
                    }
                    else {//si no se encuentra un resultado de 1
                        contador++;//acumula los intentos de inicio
                        if (contador == 5) {//si los intentos son 5 se enviara un mensaje de demaciados intentos
                            contador = 0;
                            Toast.makeText(getApplication(), "Demasiados intentos ", Toast.LENGTH_LONG).show();

                        }
                        else
                        {
                            //imprime en pantalla datos erroneos
                            Toast.makeText(getApplication(), "Datos Erroneos ", Toast.LENGTH_SHORT).show();
                            user.setText("");//coloca el campo de usuario en blanco
                            pass.setText("");//coloca el campo de password en blanco
                        }
                    }
                }
            }
        });
        //metodo que se activa al precionar el boton registro y redirecciona a la clase registro de usuarios
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
            }
        });
    }
    //-------- Metodo que envia a la clase de registro de usuarios parte 1 ------
    public void irRegistro()
    {
        Intent Act=new Intent(this,RegistroUsuario1.class);
        startActivity(Act);
    }
    //---------------------------------------------------------------------------
    //----------- metodo que envia a la clase de hacer factura  -----------------
    public void irFactura(){
        Intent act = new Intent(this,HacerFactura.class);//intent para hacer factura
        act.putExtra("Usuario",user.getText().toString());//se enviara a hacer factura esta variable
        startActivity(act);
    }
    //--------------------------------------------------------------------------
    //---------------------- Metodo que envia a la clase login  ----------------
    public void registrarUsuario(String user, String pass){
        login.addLogin(user,pass);
    }
    //-----------------------------------------------------------------------------------
}
