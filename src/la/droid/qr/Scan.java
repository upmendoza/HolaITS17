package la.droid.qr;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.HolaG.R;

public class Scan extends Activity {

    private static final int ACTIVITY_RESULT_QR_DRDROID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hacer_factura);

        //"Scan" button
        final Button button = (Button) findViewById(R.id.btnEscanear);
        //Set action to button
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new Intent to send to QR Droid
                Intent qrDroid = new Intent( Services.SCAN ); //Set action "la.droid.qr.scan"

                try {
                    startActivityForResult(qrDroid, ACTIVITY_RESULT_QR_DRDROID);
                } catch (ActivityNotFoundException activity) {
                    Services.qrDroidRequired(Scan.this);
                }
            }
        });
    }

    @Override
    /**
     * Reads data scanned by user and returned by QR Droid
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( ACTIVITY_RESULT_QR_DRDROID==requestCode && null!=data && data.getExtras()!=null ) {
            String result = data.getExtras().getString(Services.RESULT);

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
