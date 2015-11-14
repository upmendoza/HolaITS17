package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hola extends Activity
{
    /** Called when the activity is first created. */
    
    //BIENVENIDOS ESTUDIANTES//
    //Makashi32 esta presente!//
    //hola maestro ulises soy jaime y jacel...
    //TheObserver te Observa//

    //nuevos cambios

    /*JUAN MARTINEZ*/
    /*JorshxD was here*/

    private Button iniciar;
    private EditText user,pass;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user = (EditText) findViewById(R.id.etUsuario);
        pass = (EditText) findViewById(R.id.etPass);

        iniciar = (Button) findViewById(R.id.btIniciar);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals("jorge") && pass.getText().toString().equals("123"))
                    Toast.makeText(getApplication(),"Login Correcto",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplication(),"Datos Erroneos",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
