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
public class RegistrosAnios {
    private int anio;
     private int total;

    public RegistrosAnios(int anio, int total) {
        this.anio = anio;
        this.total = total;
    }

    public RegistrosAnios() {
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
   

    
}
