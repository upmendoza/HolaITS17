package com.example.HolaG;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import la.droid.qr.Services;

/**
 * Created by Juan Antonio Mtz on 25/11/2015.
 */
public class HacerFactura extends Activity {
    //se declaran variables privadas
    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;
    private EditText nombre, folio;
    private Button aceptar;
    private String usuario;

    @Override
    //metodo para crear o enlazar el layout a la clase
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();//bundle se utiliza para obtener valores de otras clases
        setContentView(R.layout.hacer_factura);//aqui dice que hacer factura sera la que se mostrara en esta clase
        usuario = bundle.getString("Usuario");//se obtiene el bundle con id de Usuario
        aceptar = (Button) findViewById(R.id.btnHacerFactura); //aceptar que hace referencia a el boton  hacer factura de el layout
        folio = (EditText) findViewById(R.id.txtFolioManual);//folio tomara el valor de el campo de texto folio

        //Get Spinner instance
        //final Spinner spinner = (Spinner) findViewById(R.id.spin_complete);

        //"Scan" button
        final Button button = (Button) findViewById(R.id.btnEscanear);
        //Set action to button
        // metedo que envia a la clase scan de la aplicacion
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new Intent to send to QR Droid
                Intent qrDroid = new Intent(Services.SCAN); //Set action "la.droid.qr.scan"

//                Check whether a complete or displayable result is needed
//                if( spinner.getSelectedItemId()==0 ) { //First item selected ("Complete content")
//                    //Notify we want complete results (default is FALSE)
//                    qrDroid.putExtra( Services.COMPLETE , true);
//                }

                //Send intent and wait result
                try {
                    startActivityForResult(qrDroid, ACTIVITY_RESULT_QR_DRDROID);
                } catch (ActivityNotFoundException activity) {
                    Services.qrDroidRequired(HacerFactura.this);
                }
            }
        });
        //metodo de ir a factura
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datos factura = new Datos();
//                if(factura.validaFolio(folio.getText().toString()))
                    irDetalleFactura();
//                else
//                    Toast.makeText(getApplicationContext(),"Folio no válido",Toast.LENGTH_LONG).show();
            }

        });
    }


    @Override
    /**
     * Reads data scanned by user and returned by QR Droid*/
    //metodo para leer los datos resivido por el escaner
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( ACTIVITY_RESULT_QR_DRDROID==requestCode && null!=data && data.getExtras()!=null ) {
            //Read result from QR Droid (it's stored in la.droid.qr.result)
            String result = data.getExtras().getString(Services.RESULT);
//            Just set result to EditText to be able to view it
//            EditText resultTxt = ( EditText ) findViewById(R.id.result);
//            resultTxt.setText( result );
//            resultTxt.setVisibility(View.VISIBLE);
            nombre = (EditText)findViewById(R.id.txtFolioManual);
            nombre.setText(data.getExtras().getString(Services.RESULT));
            irDetalleFactura();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Nothing
    }
//metodo que obtiene valores y los mantiene para su uso con bundle este metodo redirecciona a ver factura
    public void irDetalleFactura(){
        Intent act = new Intent(this,verFactura.class);
        act.putExtra("Folio",folio.getText().toString());
        act.putExtra("Usuario",usuario);
        startActivity(act);
    }
    //----------------------------------------------------------


}
