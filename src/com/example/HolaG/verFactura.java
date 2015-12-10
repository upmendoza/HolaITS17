package com.example.HolaG;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Juan Antonio Mtz on 08/12/2015.
 */
public class verFactura extends Activity
{
    private TextView folio;
    private TextView fecha;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.mostrar_factura);
        Calendar calendario = new GregorianCalendar();

        folio = (TextView)findViewById(R.id.verNfactura);
        fecha = (TextView)findViewById(R.id.verFecha);
        String YEAR = ""+calendario.get(Calendar.YEAR);
        String MONTH = ""+(calendario.get(Calendar.MONTH)+1);
        String DAY = ""+calendario.get(Calendar.DAY_OF_MONTH);

        fecha.setText(DAY + "-" + MONTH +"-" + YEAR);
//        fecha.setText(calendario.toString());
        folio.setText(bundle.getString("Folio"));


    }
}
