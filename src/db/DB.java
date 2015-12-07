package db;

import android.content.ContentValues;
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
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String EMAIL = "email";
    public static final String CP = "cp";
    public static final String USER = "usuario";
    public static final String PASS = "password";
    public static final String TABLE_NAME = "usuarios";



    public static final String USUARIOS_TABLA = "CREATE TABLE "+ TABLE_NAME  +" (" +
            ID + " integer primary key autoincrement," +
            NOMBRE + " text NOT NULL, " +
            APELLIDO +  " text NOT NULL, " +
            DIRECCION + " text NOT NULL, " +
            TELEFONO + " text NOT NULL, " +
            EMAIL + " text NOT NULL, " +
            CP + " text NOT NULL, " +
            USER + " text NOT NULL, " +
            PASS + " password text NOT NULL);";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(USUARIOS_TABLA);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
