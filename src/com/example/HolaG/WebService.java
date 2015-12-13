package com.example.HolaG;

import android.os.AsyncTask;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class WebService {

    //    private String url;
    private String serverURL = "";
    private String rfc, pass;
    private int tipo_metodo;
    private static int exito=2;

    public static int getExito() {
        return exito;
    }

    public static void setExito(int exito) {
        WebService.exito = exito;
    }

    public WebService() {
//        this.url = url;

        // WebServer Request URL
        serverURL = "http://192.168.1.67/webservice/JsonReturn.php";
    }

    public WebService(String rfc, String pass) {
        serverURL = "http://192.168.1.67/webservice/JsonReturn.php";
        this.rfc = rfc;
        this.pass = pass;
        this.tipo_metodo = 1;

    }

    public boolean ejecutarWS() {


//        new LongOperation().execute(serverURL);
        if(new LongOperation().execute(serverURL).getStatus() == AsyncTask.Status.FINISHED)

        System.out.println("GET EXITO -> " + getExito());


//        System.out.println("TERMINO EL METODO ejecutarWS");



        if(getExito() == 1)
            return true;
        else
            return false;
        // Use AsyncTask execute Method To Prevent ANR Problem
    }

    public  class LongOperation extends AsyncTask<String, Void, Void> {

        // Required initialization
        private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;

        //        private ProgressDialog Dialog = new ProgressDialog(RestFulWebservice.this);

        String data_rfc = "";
        String data_pass = "";


        protected void onPreExecute() {
            // NOTE: You can call UI Element here.

            try {
                // Set Request parameter
                if (tipo_metodo == 1) {
                    data_rfc += "&" + URLEncoder.encode("rfc", "UTF-8") + "=" + rfc; //+ serverText.getText();
                    data_pass += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + pass; //+ serverText.getText();
                }
//                data += "&" + URLEncoder.encode("data", "UTF-8") + "=1"; //+ serverText.getText();
                System.out.println(data_rfc);
                System.out.println(data_pass);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {

            /************ Make Post Call To Web Server ***********/
            BufferedReader reader = null;

            // Send data
            try {

                // Defined URL  where to send data
                URL url = new URL(urls[0]);

                // Send POST data request

                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
//                wr.write( "&data=PETER" );
                if (tipo_metodo == 1) {
                    wr.write(data_rfc);
                    wr.write(data_pass);
                }

                wr.flush();

                // Get the server response

                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while ((line = reader.readLine()) != null) {
                    // Append server response in string
                    sb.append(line + " ");
                }

                // Append Server Response To Content String
                Content = sb.toString();
            } catch (Exception ex) {
                Error = ex.getMessage();
            } finally {
                try {

                    reader.close();
                } catch (Exception ex) {
                }
            }

            /*****************************************************/
            return null;
        }

        protected void onPostExecute(Void unused) {
            // NOTE: You can call UI Element here.

            // Close progress dialog
//            Dialog.dismiss();

//            if (Error != null) {
//
//                uiUpdate.setText("Output : " + Error);
//
//            } else {
//
//                // Show Response Json On Screen (activity)
//                uiUpdate.setText(Content);

            /****************** Start Parse Response JSON Data *************/

            String OutputData = "";
            JSONObject jsonResponse;

            try {

                /****** Creates a new JSONObject with name/value mappings from the JSON string. ********/
                jsonResponse = new JSONObject(Content);

                /***** Returns the value mapped by name if it exists and is a JSONArray. ***/
                /*******  Returns null otherwise.  *******/
                JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");

                /*********** Process each JSON Node ************/

                int lengthJsonArr = jsonMainNode.length();

                for (int i = 0; i < lengthJsonArr; i++) {
                    /****** Get Object for each JSON node.***********/
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                    /******* Fetch node values **********/

                    String resultado = jsonChildNode.optString("resultado").toString();

                    if (tipo_metodo == 1 && resultado.equals("1")) {

                        WebService.exito = 1;
                        WebService.setExito(1);
                        exito = 1;


                        String nombre = jsonChildNode.optString("nombre").toString();
                        String apellido = jsonChildNode.optString("apellido").toString();
                        String direccion = jsonChildNode.optString("direccion").toString();
                        String telefono = jsonChildNode.optString("telefono").toString();
                        String email = jsonChildNode.optString("email").toString();
                        String codigo_postal = jsonChildNode.optString("codigo_postal").toString();
                        String rfc = jsonChildNode.optString("rfc").toString();
                        String password = jsonChildNode.optString("password").toString();


                        OutputData += "\tnombre -> " + nombre + "\n" +
                                "\tapellido -> " + apellido + "\n" +
                                "\tdireccion -> " + direccion + "\n" +
                                "\ttelefono -> " + telefono + "\n" +
                                "\temail -> " + email + "\n" +
                                "\tcodigo_postal -> " + codigo_postal + "\n" +
                                "\trfc -> " + rfc + "\n" +
                                "\tpassword -> " + password + "\n" + "resultado -> " + resultado;
                        setExito(Integer.parseInt(resultado));
                        //ban=true;
                    }

                    if(tipo_metodo == 2){}

                    if(tipo_metodo == 3){}

                }
                /****************** End Parse Response JSON Data *************/

                //Show Parsed Output on screen (activity)
//                    jsonParsed.setText(OutputData);
                System.out.println(OutputData + "\n exito -> "+ exito);

            } catch (JSONException e) {

                e.printStackTrace();
                //exito = 0;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }
    }
}
