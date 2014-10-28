package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
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
    }
}
