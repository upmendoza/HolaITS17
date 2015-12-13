package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jorge on 07/12/15.
 */
public class DBAdapter {

    public static final String ID = "_id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String EMAIL = "email";
    public static final String CP = "cp";
    public static final String RFC = "rfc";
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
    public long agregar(String n, String ap, String dir, String tel, String email, String cp, String user, String pass){
        this.open();

        Cursor miCursor = db.query(TABLE_NAME, new String[]{RFC,PASS}, "rfc = ? and password = ? ",
                new String[] {user, pass}, null, null, null);
        miCursor.moveToFirst();

        if(miCursor.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put(NOMBRE, n);
            values.put(APELLIDO, ap);
            values.put(DIRECCION, dir);
            values.put(TELEFONO, tel);
            values.put(EMAIL, email);
            values.put(CP, cp);
            values.put(RFC, user);
            values.put(PASS, pass);
            return db.insert(TABLE_NAME, null, values);
        }else{
            return -1;
        }
    }
    public boolean validarLogin(String rfc, String pass){
        this.open();
        Cursor MiCursor = db.query(TABLE_NAME, new String[]{RFC, PASS}, "rfc = ? and password = ?",
                new String[]{rfc, pass}, null, null, null);
        if(MiCursor != null)
            if (MiCursor.getCount() > 0)
                return true;
            else
                return false;
        else
            return false;
    }
    public boolean validarLogin2(String rfc)
    {
        this.open();
        Cursor MiCursor = db.query(TABLE_NAME, new String[]{RFC}, "rfc = ?", new String[]{rfc}, null, null, null);
        if(MiCursor != null)
            if (MiCursor.getCount() > 0)
                return true;
            else
                return false;
        else
            return false;
    }

    public Cursor getDatosUsuario(String user){
        this.open();
        return db.query(TABLE_NAME, new String[]{ID, NOMBRE, APELLIDO, DIRECCION, TELEFONO, EMAIL,CP, RFC,PASS},
                "rfc = ?", new String[]{user}, null, null, null);


    }

}
