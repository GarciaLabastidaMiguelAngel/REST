/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.util.schemas;

import java.util.ArrayList;
import java.util.List;
import model.persistencia.Entidades;
import model.persistencia.Indicadores;

/**
 *
 * @author miguel
 */
public class DatosRegistros {
    private Entidades entidad;
    private Indicadores indicador;
    private List<RegistrosAnios> registros;

    public DatosRegistros() {
        registros=new ArrayList<>();
    }

    public DatosRegistros(Entidades entidad, Indicadores indicador, List<RegistrosAnios> lista) {
        this.entidad = entidad;
        this.indicador = indicador;
        this.registros = lista;
    }

    public Entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidades entidad) {
        this.entidad = entidad;
    }

    public Indicadores getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicadores indicador) {
        this.indicador = indicador;
    }

    public List<RegistrosAnios> getLista() {
        return registros;
    }

    public void setLista(List<RegistrosAnios> lista) {
        this.registros = lista;
    }
    
    public void addRegistroAnios(RegistrosAnios r){
            registros.add(r);
    }
    
}
