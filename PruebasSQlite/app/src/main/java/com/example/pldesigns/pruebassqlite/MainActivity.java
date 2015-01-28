package com.example.pldesigns.pruebassqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class MainActivity extends ActionBarActivity
{
    private DbManager dbManager;
    private Cursor cursor;
    private ListView lista;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DbManager(this);
        lista = (ListView)findViewById(R.id.listView);

        dbManager.insertar("Pepe","635552884");
        dbManager.insertar("Juan","123456789");

        String[] from = new String[]{dbManager.CN_NAME,dbManager.CN_PHONE};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = dbManager.cargarCursorContactos();
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);

        lista.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
