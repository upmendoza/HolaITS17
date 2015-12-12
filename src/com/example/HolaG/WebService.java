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

    private String ipServer = "192.168.1.5";
    private String destino;

    public WebService() {

        // WebServer Request URL
        String serverURL = "http://"+ ipServer +"/webservice/JsonReturn.php";


        // Use AsyncTask execute Method To Prevent ANR Problem
        new LongOperation().execute(serverURL);
    }

    private class LongOperation extends AsyncTask<String, Void, Void> {

        // Required initialization

        private final HttpClient Client = new DefaultHttpClient();
        private String Content;
        private String Error = null;

        String data = "";

        int sizeData = 0;


        protected void onPreExecute() {

            try {
                // Set Request parameter
                data += "&" + URLEncoder.encode("data", "UTF-8") + "=1"; //+ serverText.getText();
                System.out.println(data);
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
                wr.write(data);
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

//                    for(String dato : jsonChildNode){
//                        System.out.println(dato);
//                    }

                    String nombre = jsonChildNode.optString("nombre").toString();
                    String apellido = jsonChildNode.optString("apellido").toString();
                    String direccion = jsonChildNode.optString("direccion").toString();
                    String telefono = jsonChildNode.optString("telefono").toString();
                    String email = jsonChildNode.optString("email").toString();
                    String codigo_postal = jsonChildNode.optString("codigo_postal").toString();
                    String usuario = jsonChildNode.optString("usuario").toString();
                    String password = jsonChildNode.optString("password").toString();


                    OutputData += "\tnombre -> " + nombre + "\n" +
                            "\tapellido -> " + apellido + "\n" +
                            "\tdireccion -> " + direccion + "\n" +
                            "\ttelefono -> " + telefono + "\n" +
                            "\temail -> " + email + "\n" +
                            "\tcodigo_postal -> " + codigo_postal + "\n" +
                            "\tusuario -> " + usuario + "\n" +
                            "\tpassword -> " + password;


                }
                /****************** End Parse Response JSON Data *************/

                //Show Parsed Output on screen (activity)
//                    jsonParsed.setText(OutputData);
//                System.out.println(OutputData);

            } catch (JSONException e) {

                e.printStackTrace();
            }
        }
    }
}
