package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Hola extends Activity
{
    /** Called when the activity is first created. */
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
        }
}

