package com.example.HolaG;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import db.DBAdapter;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Juan Antonio Mtz on 08/12/2015.
 */
public class verFactura extends Activity
{
    //se declaran estas variables para poder obtener valores desde el layout verFactura
    private TextView folio;
    private TextView fecha;
    private TextView nombre;
    private TextView direccion;
    private TextView telefono;
    private Button aceptar;
    private String usuario;
    //--------------------------------------------------------------------------------------
    Cursor cursor;
    DBAdapter adapter;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();

        setContentView(R.layout.mostrar_factura);

        Calendar calendario = new GregorianCalendar();

        adapter = new DBAdapter(this);
        cursor = adapter.getDatosUsuario(bundle.getString("Usuario"));
        cursor.moveToFirst();

        folio = (TextView)findViewById(R.id.verNfactura);
        fecha = (TextView)findViewById(R.id.verFecha);
        nombre = (TextView)findViewById(R.id.verNombreCliente);
        direccion = (TextView)findViewById(R.id.verDireccionCliente);
        telefono = (TextView)findViewById(R.id.verTelefonoCliente);
        aceptar = (Button)findViewById(R.id.AceptarFacturaVista);

        String YEAR = ""+calendario.get(Calendar.YEAR);
        String MONTH = ""+(calendario.get(Calendar.MONTH)+1);
        String DAY = ""+calendario.get(Calendar.DAY_OF_MONTH);

        fecha.setText(DAY + "-" + MONTH +"-" + YEAR);
//        fecha.setText(calendario.toString());
        folio.setText(bundle.getString("Folio"));

        nombre.setText(cursor.getString(1) + " " + cursor.getString(2));

        direccion.setText(cursor.getString(3));

        telefono.setText(cursor.getString(4));

        usuario = bundle.getString("Usuario");
//        System.out.println( " USUARIO L66 => " + usuario);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpHandler httpHandler = new HttpHandler();
              final String resp =  httpHandler.Factura(folio.getText().toString(),usuario);

                if(resp.equals("1")){
                    Toast.makeText(getApplicationContext(),"Factura Correcta",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Folio no Valido",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
