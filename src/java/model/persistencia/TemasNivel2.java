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
import javax.persistence.Table;

/**
 *
 * @author miguel
 */
@Entity
@Table(name = "temas_nivel_2")
public class TemasNivel2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_temas_nivel_2")
    private Integer idTemasNivel2;
    @Column(name = "descripcion")
    private String descripcion;
   @Column(name = "id_temas_nivel_1")
    private Integer idTemasNivel1;

    public TemasNivel2() {
    }

    public TemasNivel2(Integer idTemasNivel2) {
        this.idTemasNivel2 = idTemasNivel2;
    }

    public Integer getIdTemasNivel2() {
        return idTemasNivel2;
    }

    public TemasNivel2(String descripcion, Integer idTemasNivel1) {
        this.descripcion = descripcion;
        this.idTemasNivel1 = idTemasNivel1;
    }
    
    

    public void setIdTemasNivel2(Integer idTemasNivel2) {
        this.idTemasNivel2 = idTemasNivel2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Integer getIdTemasNivel1() {
        return idTemasNivel1;
    }

    public void setIdTemasNivel1(Integer idTemasNivel1) {
        this.idTemasNivel1 = idTemasNivel1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemasNivel2 != null ? idTemasNivel2.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasNivel2)) {
            return false;
        }
        TemasNivel2 other = (TemasNivel2) object;
        if ((this.idTemasNivel2 == null && other.idTemasNivel2 != null) || (this.idTemasNivel2 != null && !this.idTemasNivel2.equals(other.idTemasNivel2))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.TemasNivel2[ idTemasNivel2=" + idTemasNivel2 + " ]";
    }
    
    
    
    
}
