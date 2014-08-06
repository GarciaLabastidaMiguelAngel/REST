/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.util.schemas;



/**
 *
 * @author miguel
 */
public class DatosRegistros {
    private int anio;
    private int cantidad;

    public DatosRegistros(int anio, int cantidad) {
        this.anio = anio;
        this.cantidad = cantidad;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public DatosRegistros() {
    }

   
}
