package com.example.pldesigns.examen2eval;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Pepe on 28/01/2015.
 */
public class DbManager
{
    public static final String TABLE_NAME = "datos";

    public static final String CN_ID = "_id";
    public static final String CN_ZONA = "zona";
    public static final String CN_COSTE = "coste";

    public static final String CREATE_TABLE = "create table "+TABLE_NAME+"("+CN_ID+" integer primary key autoincrement," +
            "                                                           "+ CN_ZONA +" text not null," +
            "                                                           "+CN_COSTE+" text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DbManager(Context context)
    {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String zona,String coste)
    {
        ContentValues valores = new ContentValues();
        valores.put(CN_ZONA,zona);
        valores.put(CN_COSTE,coste);

        return valores;
    }

    public void insertar (String zona,String coste)
    {
        db.insert(TABLE_NAME,null,generarContentValues(zona,coste));
    }
    public void insertarSql (String zona,String coste)
    {
        db.execSQL("insert into "+TABLE_NAME+" values (null,'"+zona+"','"+coste+"');");
    }

    //para devolver todos los campos de la Db
    public Cursor cargarCursorContactos()
    {
        String[] columnas = new String[]{CN_ID, CN_ZONA,CN_COSTE};

        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }
}
