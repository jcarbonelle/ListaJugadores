package com.uninorte.listajugadores;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class EditActivity extends AppCompatActivity {
    String nombre;
    String apellido;
    String edad;
    String posicion;
    Boolean convocado;
    EditText tvnom,tvap,tvpos,tvedad;
    ToggleButton tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent i=getIntent();
        nombre= i.getStringExtra("nombre");
        apellido=i.getStringExtra("apellido");
        edad=i.getStringExtra("edad");
        posicion=i.getStringExtra("posicion");
        convocado=i.getBooleanExtra("convocado",true);
        tvnom=findViewById(R.id.tvnombre);
        tvnom.setText(nombre);
        tvap=findViewById(R.id.tvap);
        tvap.setText(apellido);
        tvpos=findViewById(R.id.tvpos);
        tvpos.setText(posicion);
        tvedad=findViewById(R.id.tvedad);
        tvedad.setText(edad);
        tb=findViewById(R.id.toggleButton);
        tb.setChecked(convocado);
    }

    public void guardarDatos(View view) {
        Intent i =getIntent();
        nombre=tvnom.getText().toString();
        apellido=tvap.getText().toString();
        edad=tvedad.getText().toString();
        posicion=tvpos.getText().toString();
        convocado=tb.isChecked();
        i.putExtra("nombre",nombre);
        i.putExtra("apellido",apellido);
        i.putExtra("edad",edad);
        i.putExtra("posicion",posicion);
        i.putExtra("convocado",convocado);
        setResult(Activity.RESULT_OK,i);
        finish();
    }
}
