package com.example.pepe.ejemplopreferencias;

/**
 * Created by Pepe on 09/12/2014.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;
public class PantallaOpciones extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.opciones);
    }
}