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
public class Municipios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_municipio")
    private Integer idMunicipio;
    @Column(name = "desc_municiopio")
    private String descMuniciopio;
    @Column(name = "id_entidad")
    private Integer idEntidad;

    public Municipios() {
    }

    public Municipios(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipios(Integer idMunicipio, String descMuniciopio) {
        this.idMunicipio = idMunicipio;
        this.descMuniciopio = descMuniciopio;
    }

    public Municipios(String descMuniciopio) {
        this.descMuniciopio = descMuniciopio;
    }

    public Municipios(String descMuniciopio, Integer idEntidad) {
        this.descMuniciopio = descMuniciopio;
        this.idEntidad = idEntidad;
    }
    
    

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getDescMuniciopio() {
        return descMuniciopio;
    }

    public void setDescMuniciopio(String descMuniciopio) {
        this.descMuniciopio = descMuniciopio;
    }

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.Municipios[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
