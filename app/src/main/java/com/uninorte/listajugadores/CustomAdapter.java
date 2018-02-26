package com.uninorte.listajugadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {


    private Context context;
    private Jugador[] jugadores;

    public CustomAdapter(Context context, Jugador[] jugadores) {
        this.context = context;
        this.jugadores = jugadores;
    }

    @Override
    public int getCount() {
        return jugadores.length;
    }

    @Override
    public Object getItem(int i) {
        return jugadores[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Jugador jugador =jugadores[i];
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.fila,null);
        }
        TextView tvnombre =view.findViewById(R.id.nombre);
        TextView tvpos =view.findViewById(R.id.posicion);
        TextView tvconvocado =view.findViewById(R.id.convocado);
        tvnombre.setText(jugador.getNombre()+" "+jugador.getApellido());
        tvpos.setText(jugador.getPosicion());
        if (jugador.isConvocado()==false){
            tvconvocado.setText("No convocado");
        }else{
            tvconvocado.setText("Si convocado");
        }
        Button boton =view.findViewById(R.id.boton);
        boton.setTag(i);
        return view;
    }
}
