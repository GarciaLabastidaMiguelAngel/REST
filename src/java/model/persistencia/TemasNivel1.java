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
@Table(name = "temas_nivel_1")
public class TemasNivel1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_temas_nivel_1")
    private Integer idTemasNivel1;
    @Column(name = "descripcion")
    private String descripcion;
   

    public TemasNivel1() {
    }

    public TemasNivel1(Integer idTemasNivel1) {
        this.idTemasNivel1 = idTemasNivel1;
    }

    public TemasNivel1(Integer idTemasNivel1, String descripcion) {
        this.idTemasNivel1 = idTemasNivel1;
        this.descripcion = descripcion;
    }

    public TemasNivel1(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public Integer getIdTemasNivel1() {
        return idTemasNivel1;
    }

    public void setIdTemasNivel1(Integer idTemasNivel1) {
        this.idTemasNivel1 = idTemasNivel1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemasNivel1 != null ? idTemasNivel1.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasNivel1)) {
            return false;
        }
        TemasNivel1 other = (TemasNivel1) object;
        if ((this.idTemasNivel1 == null && other.idTemasNivel1 != null) || (this.idTemasNivel1 != null && !this.idTemasNivel1.equals(other.idTemasNivel1))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.TemasNivel1[ idTemasNivel1=" + idTemasNivel1 + " ]";
    }
    
}
