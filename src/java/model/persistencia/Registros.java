/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.persistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author miguel
 */
@Entity
public class Registros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_registros")
    private Integer idRegistros;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "id_indicador")
    private String idIndicador;
    @Column(name = "id_municipio")
    private Integer idMunicipio;
    @Column(name = "id_temas_nivel_3")
    private Integer idTemasNivel3;

    public Registros() {
    }

    public Registros(Integer idRegistros) {
        this.idRegistros = idRegistros;
    }

    public Registros(Integer idRegistros, Integer anio, Integer cantidad) {
        this.idRegistros = idRegistros;
        this.anio = anio;
        this.cantidad = cantidad;
    }
    

    public Registros(Integer anio, Integer cantidad, String idIndicador, Integer idMunicipio, Integer idTemasNivel3) {
        this.anio = anio;
        this.cantidad = cantidad;
        this.idIndicador = idIndicador;
        this.idMunicipio = idMunicipio;
        this.idTemasNivel3 = idTemasNivel3;
    }
    

    public Integer getIdRegistros() {
        return idRegistros;
    }

    public void setIdRegistros(Integer idRegistros) {
        this.idRegistros = idRegistros;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(String idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdTemasNivel3() {
        return idTemasNivel3;
    }

    public void setIdTemasNivel3(Integer idTemasNivel3) {
        this.idTemasNivel3 = idTemasNivel3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistros != null ? idRegistros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registros)) {
            return false;
        }
        Registros other = (Registros) object;
        if ((this.idRegistros == null && other.idRegistros != null) || (this.idRegistros != null && !this.idRegistros.equals(other.idRegistros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.Registros[ idRegistros=" + idRegistros + " ]";
    }
    
}
