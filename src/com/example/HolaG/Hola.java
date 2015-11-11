package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Hola extends Activity
{
    /** Called when the activity is first created. */
    
    //BIENVENIDOS ESTUDIANTES//


    /*JUAN MARTINEZ*/
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toast.makeText(this.getApplicationContext(),"Mi Texto para Mostrar",Toast.LENGTH_LONG).show();

        Button alberto = (Button) findViewById(R.id.villa);
            alberto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Alberto villa",Toast.LENGTH_LONG).show();
                }
            });
        

        Button Fito = (Button)findViewById(R.id.btnfito);

        Fito.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),"Rodolfo :D :P",Toast.LENGTH_LONG).show();
            }

        });

        Button bjavier = (Button) findViewById(R.id.button_javier);

        bjavier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button Javier",Toast.LENGTH_LONG).show();
            }
        });

        Button bdulce = (Button) findViewById(R.id.button_dulce);

        bdulce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button Dulce :DD",Toast.LENGTH_LONG).show();
            }
        });
    }
}
