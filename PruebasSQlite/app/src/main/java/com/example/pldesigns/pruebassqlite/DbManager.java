package com.example.pldesigns.pruebassqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Pepe on 28/01/2015.
 */
public class DbManager
{
    public static final String TABLE_NAME = "contactos";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_PHONE = "telefono";

    public static final String CREATE_TABLE = "create table "+TABLE_NAME+"("+CN_ID+" integer primary key autoincrement," +
            "                                                           "+CN_NAME+" text not null," +
            "                                                           "+CN_PHONE+" text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DbManager(Context context)
    {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String nombre,String telefono)
    {
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME,nombre);
        valores.put(CN_PHONE,telefono);

        return valores;
    }

    public void insertar (String nombre,String telefono)
    {
        db.insert(TABLE_NAME,null,generarContentValues(nombre,telefono));
    }
    public void insertarSql (String nombre,String telefono)
    {
        db.execSQL("insert into "+TABLE_NAME+" values (null,'"+nombre+"','"+telefono+"');");
    }
    public void eliminar (String nombre)
    {
        db.delete(TABLE_NAME,CN_NAME+"=?",new String[]{nombre});
    }
    public void eliminarMultiple (String id1,String id2)
    {
        db.delete(TABLE_NAME,CN_ID+"IN (?,?)",new String[]{id1,id2});
    }
    public void modificarTelefono(String nombre, String nuevoTelf )
    {
        db.update(TABLE_NAME,generarContentValues(nombre,nuevoTelf),CN_NAME+"=?",new String[]{nombre});
    }
    //para devolver todos los campos de la Db
    public Cursor cargarCursorContactos()
    {
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_PHONE};

        return db.query(TABLE_NAME,columnas,null,null,null,null,null);
    }
    public Cursor buscarContacto(String nombre)
    {
        String[] columnas = new String[]{CN_ID,CN_NAME,CN_PHONE};
        return db.query(TABLE_NAME,columnas,CN_NAME+"=?",new String[]{nombre},null,null,null);
    }
}
