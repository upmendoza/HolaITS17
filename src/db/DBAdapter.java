package db;


import android.content.ContentValues;
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

    public static final String TABLE_NAME = "usuarios";

    private Context context;
    private DB dbHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context context) {
        this.context = context;
    }
    public DBAdapter open() throws SQLException {
        dbHelper = new DB(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close (){
        dbHelper.close();
    }
    public void agregar(String n, String ap, String dir, String tel, String email, String cp, String user, String pass){

        ContentValues values = new ContentValues();
        values.put(NOMBRE, n);
        values.put(APELLIDO, ap);
        values.put(DIRECCION, dir);
        values.put(TELEFONO, tel);
        values.put(EMAIL, email);
        values.put(CP, cp);
        values.put(USER, user);
        values.put(PASS, pass);
        db.insert(TABLE_NAME, null, values);
    }



}
