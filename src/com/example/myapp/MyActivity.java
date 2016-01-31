package com.example.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MyActivity extends Activity {
    private EditText txtNombre, txtRecibo;
    private RadioGroup rgNivel, rgUsuario;

    private int [][] tablaPrecios = {
            {50, 70, 100},
            {40, 50, 80},
            {70, 100, 120}
    };

    private String [] nivel = {"Basico", "Intermedio", "Avanzado"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        txtNombre = (EditText)findViewById(R.id.txtNombre);
        txtRecibo = (EditText)findViewById(R.id.txtRecibo);
        rgNivel = (RadioGroup)findViewById(R.id.rgNivel);
        rgUsuario = (RadioGroup)findViewById(R.id.rgUsuario);
    }

    private int calcular() {
        return tablaPrecios[rgNivel.getCheckedRadioButtonId()][rgUsuario.getCheckedRadioButtonId()];
    }

    public void show(View v) {
        txtRecibo.setText("");
        txtRecibo.append("Nombre: " + txtNombre.getText().toString());
        txtRecibo.append("Precio: " + String.valueOf(calcular()));
        txtRecibo.append("Nivel: " + nivel[rgNivel.getCheckedRadioButtonId()]);
    }
}
