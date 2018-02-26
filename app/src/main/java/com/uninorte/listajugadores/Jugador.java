package com.uninorte.listajugadores;


public class Jugador {

    private String Nombre;
    private String Apellido;
    private String Posicion;
    private String edad;
    private boolean Convocado;

    public Jugador(String nombre, String apellido, String posicion, String edad, boolean convocado) {
        Nombre = nombre;
        Apellido = apellido;
        Posicion = posicion;
        this.edad = edad;
        Convocado = convocado;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getPosicion() {
        return Posicion;
    }

    public String getEdad() {
        return edad;
    }

    public boolean isConvocado() {
        return Convocado;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setConvocado(boolean convocado) {
        Convocado = convocado;
    }
}
