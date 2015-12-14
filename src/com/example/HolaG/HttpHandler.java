package com.example.HolaG;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Jorge on 13/12/15.
 */
public class HttpHandler {

//    private String url = "http://192.168.1.67/webservice/prueba.php";
    private String url = "http://192.168.1.86/webservice/webservice.php";
//    private String url = "http://189.252.237.128/webservice/webservice.php";


    public String[] Login(String rfc, String password){

        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

//            AÑADIR PARAMETROS

            LinkedList<NameValuePair> parametros = new LinkedList<NameValuePair>();
            parametros.add(new BasicNameValuePair("opc","login"));
            parametros.add(new BasicNameValuePair("rfc",rfc));
            parametros.add(new BasicNameValuePair("password",password));

            httpPost.setEntity(new UrlEncodedFormEntity(parametros));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            String text = EntityUtils.toString(entity);

            String[] arreglo = text.split(",");

            System.out.println("L43 RESPUESTA => " + text );
            System.out.println("L43 ARREGLO => " + arreglo[0] );
            return arreglo;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR!! L48");
//            return "error";
            String[] a = {"0"};
            return a;
        }
    }// end method login


    public String Resgistro (String nombre,String apell, String dir, String tel, String mail, String cp, String rfc, String password){

        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

//            AÑADIR PARAMETROS

            LinkedList<NameValuePair> parametros = new LinkedList<NameValuePair>();
            parametros.add(new BasicNameValuePair("opc","registro"));
            parametros.add(new BasicNameValuePair("nombre",nombre));
            parametros.add(new BasicNameValuePair("apellido",apell));
            parametros.add(new BasicNameValuePair("dir",dir));
            parametros.add(new BasicNameValuePair("tel",tel));
            parametros.add(new BasicNameValuePair("mail",mail));
            parametros.add(new BasicNameValuePair("cp",cp));
            parametros.add(new BasicNameValuePair("rfc",rfc));
            parametros.add(new BasicNameValuePair("password",password));

            httpPost.setEntity(new UrlEncodedFormEntity(parametros));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            String text = EntityUtils.toString(entity);
            System.out.println("L81 RESPUESTA => " + text );
            return text;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR!! L88");
            return "error";
        }
    }//end method registro

    public String Factura(String folio){
        try {

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

//            AÑADIR PARAMETROS

            LinkedList<NameValuePair> parametros = new LinkedList<NameValuePair>();
            parametros.add(new BasicNameValuePair("opc","factura"));
            parametros.add(new BasicNameValuePair("folio",folio));


            httpPost.setEntity(new UrlEncodedFormEntity(parametros));

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            String text = EntityUtils.toString(entity);
            System.out.println("L 110 RESPUESTA => " + text );
            return text;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR!! 115");
            return "error";
        }
    }

}// end class
