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

    public static final String USUARIOS_TABLA = "CREATE TABLE usuarios (" +
            "id integer primary key autoincrement," +
            " nombre text NOT NULL," +
            " apellido text NOT NULL," +
            " direccion text NOT NULL," +
            " Telefono text NOT NULL," +
            " email text NOT NULL," +
            " cp text NOT NULL," +
            " usuario text NOT NULL," +
            " password text NOT NULL";

    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(USUARIOS_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
