package com.example.pepe.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.*;


public class Resultado extends Activity
{
    Bundle miBundle;
    int resultado;
    TextView resu;
    TextView res;
    InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        // Crear el intersticial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-1592244461539892/5780194362");
        // Crear la solicitud de anuncio.
        AdRequest adRequestI = new AdRequest.Builder().build();
        // Comenzar la carga del intersticial.
        interstitial.loadAd(adRequestI);

        // Buscar AdView como recurso y cargar una solicitud.
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        resultado = getIntent().getExtras().getInt("RESULTADO");
        res = (TextView) findViewById(R.id.tvRes);

        res.setText(String.valueOf(resultado));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
        return true;
    }
    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event)
    {
        if (keyCode == event.KEYCODE_BACK)
        {
            displayInterstitial();
        }
        return super.onKeyDown(keyCode,event);
    }
    // Invoca displayInterstitial() cuando esté preparado para mostrar un intersticial.
    public void displayInterstitial()
    {
        if(interstitial.isLoaded())
        {
            interstitial.show();
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            Toast.makeText(getApplicationContext(),"Busca mis apps en Google Play...",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
