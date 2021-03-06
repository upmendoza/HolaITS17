package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jorge on 27/11/15.
 */
public class DB extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Facturalo.db";

    public static final String ID = "_id";
    public static final String IDFOLIO= "_id";
    public static final String FOLIO="folio";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String EMAIL = "email";
    public static final String CP = "cp";
    public static final String RFC = "rfc";
    public static final String PASS = "password";
    public static final String TABLE_USER = "usuarios";
    public static final String TABLE_FOLIO ="folios";
    public static final String FOLIOS_TABLA= "CREATE TABLE"+ TABLE_FOLIO +" ("+IDFOLIO+" integer primary key autoincrement, "+FOLIO+" text NOT NULL);";
    public static final String USUARIOS_TABLA = "CREATE TABLE "+ TABLE_USER +" (" +
            ID + " integer primary key autoincrement," +
            NOMBRE + " text NOT NULL, " +
            APELLIDO +  " text NOT NULL, " +
            DIRECCION + " text NOT NULL, " +
            TELEFONO + " text NOT NULL, " +
            EMAIL + " text NOT NULL, " +
            CP + " text NOT NULL, " +
            RFC + " text NOT NULL, " +
            PASS + " password text NOT NULL);";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(USUARIOS_TABLA);
        //db.execSQL(FOLIOS_TABLA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
