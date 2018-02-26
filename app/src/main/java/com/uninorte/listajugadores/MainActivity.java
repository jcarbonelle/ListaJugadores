package com.uninorte.listajugadores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    int editando;
    Jugador falcao = new Jugador("Radamel Falcao","Garcia","DEL","32",true);
    Jugador james = new Jugador("James","Rodriguez","MP","26",true);
    Jugador cuadrado = new Jugador("Juan Guillermo","Cuadrado","ED", "29",true);
    Jugador teo= new Jugador("Teofilo","Gutierrez","DEL","32",false);
    Jugador[] jugadores={falcao,james,cuadrado,teo};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lista);
        CustomAdapter customAdapter= new CustomAdapter(this,jugadores);
        lv.setAdapter(customAdapter);
    }

    public void enviarInformacion (Jugador jugador,int pos){
        Intent i=new Intent(this, EditActivity.class);
        i.putExtra("nombre",jugador.getNombre());
        i.putExtra("apellido",jugador.getApellido());
        i.putExtra("edad",jugador.getEdad());
        i.putExtra("posicion",jugador.getPosicion());
        i.putExtra("convocado",jugador.isConvocado());
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1){
            if (resultCode==RESULT_OK){
                jugadores[editando].setNombre(data.getStringExtra("nombre"));
                jugadores[editando].setApellido(data.getStringExtra("apellido"));
                jugadores[editando].setEdad(data.getStringExtra("edad"));
                jugadores[editando].setPosicion(data.getStringExtra("posicion"));
                jugadores[editando].setConvocado(data.getBooleanExtra("convocado",true));
                CustomAdapter customAdapter= new CustomAdapter(this,jugadores);
                lv.setAdapter(customAdapter);
            }
        }
    }

    public void abrirEdicion(View view) {
        editando= (int) view.getTag();
        enviarInformacion(jugadores[editando],editando);
    }
}
