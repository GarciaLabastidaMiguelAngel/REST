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
public class DatosRegistrosIdMunicipio {
    private int id;

    public DatosRegistrosIdMunicipio(int id, int anio, int cantidad) {
        this.id = id;
        this.anio = anio;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private int anio;
    private int cantidad;

    public DatosRegistrosIdMunicipio(int anio, int cantidad) {
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

    public DatosRegistrosIdMunicipio() {
    }

   
}
