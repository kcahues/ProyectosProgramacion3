
package com.kc.entity;

/**
 *
 * @author kevin
 */
public class Jugador {
    //Se crean las variables a tratar para jugador
    private int idJugador;
    private String nombre;
    private int saldo;
    private boolean borrado;
    
    //Constructor vacio para poder iniciarlizar vacio
    public Jugador() {
    }

    //Constructor con los parametros del jugador
    public Jugador(int idJugador, String nombre, int saldo, boolean borrado) {
        this.idJugador = idJugador;
        this.nombre    = nombre;
        this.saldo     = saldo;
        this.borrado     = borrado;
    }
    
    //Generamos getters and setters, para poder tener acceso privado 
    //a las variables
    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
}
