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
public class Entidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_entidad")
    private Integer idEntidad;
    @Column(name = "desc_entidad")
    private String descEntidad;
    

    public Entidades() {
    }

   

    
     public Entidades( String descEntidad) {
        this.descEntidad = descEntidad;
    }

    public Entidades(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Entidades(Integer idEntidad, String descEntidad) {
        this.idEntidad = idEntidad;
        this.descEntidad = descEntidad;
    }
    
     
     public Integer getIdEntidad() {
        return idEntidad;
    }
     

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public String getDescEntidad() {
        return descEntidad;
    }

    public void setDescEntidad(String descEntidad) {
        this.descEntidad = descEntidad;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidad != null ? idEntidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
        if ((this.idEntidad == null && other.idEntidad != null) || (this.idEntidad != null && !this.idEntidad.equals(other.idEntidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.Entidades[ idEntidad=" + idEntidad + " ]";
    }
    
}
