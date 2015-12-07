package db;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jorge on 07/12/15.
 */
public class DBAdapter {

    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String EMAIL = "email";
    public static final String CP = "cp";
    public static final String USER = "usuario";
    public static final String PASS = "password";


    private Context context;
    private DB dbHelper;

    public DBAdapter(Context context) {
        this.context = context;
    }

    public DBAdapter open() throws SQLException {
        dbHelper = new DB(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close (){
        dbHelper.close();
    }

    public void agregar(String n, String ap, String dir, String tel, String email, String cp, String user, String pass){



    }
}
