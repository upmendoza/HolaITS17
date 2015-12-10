package com.example.HolaG;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import la.droid.qr.Services;

/**
 * Created by Juan Antonio Mtz on 25/11/2015.
 */
public class HacerFactura extends Activity {

    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;
    private EditText nombre;
    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.hacer_factura);

        aceptar = (Button) findViewById(R.id.btnHacerFactura);

        //Get Spinner instance
        //final Spinner spinner = (Spinner) findViewById(R.id.spin_complete);

        //"Scan" button
        final Button button = (Button) findViewById(R.id.btnEscanear);
        //Set action to button
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

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irDetalleFactura();
            }

        });
    }


    @Override
    /**
     * Reads data scanned by user and returned by QR Droid*/
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

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //Nothing
    }

    public void irDetalleFactura(){
        Intent act = new Intent(this,verFactura.class);
//        act.putExtra("Usuario",user.getText().toString());
        startActivity(act);
    }


}
