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
@Table(name = "temas_nivel_3")
public class TemasNivel3 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_temas_nivel_3")
    private Integer idTemasNivel3;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "id_temas_nivel_2")
    private Integer idTemasNivel2;

    public TemasNivel3() {
    }

    public TemasNivel3(Integer idTemasNivel3) {
        this.idTemasNivel3 = idTemasNivel3;
    }

    public Integer getIdTemasNivel3() {
        return idTemasNivel3;
    }

    public TemasNivel3(String descripcion, Integer idTemasNivel2) {
        this.descripcion = descripcion;
        this.idTemasNivel2 = idTemasNivel2;
    }
    
    

    public void setIdTemasNivel3(Integer idTemasNivel3) {
        this.idTemasNivel3 = idTemasNivel3;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Integer getIdTemasNivel2() {
        return idTemasNivel2;
    }

    public void setIdTemasNivel2(Integer idTemasNivel2) {
        this.idTemasNivel2 = idTemasNivel2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTemasNivel3 != null ? idTemasNivel3.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TemasNivel3)) {
            return false;
        }
        TemasNivel3 other = (TemasNivel3) object;
        if ((this.idTemasNivel3 == null && other.idTemasNivel3 != null) || (this.idTemasNivel3 != null && !this.idTemasNivel3.equals(other.idTemasNivel3))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.TemasNivel3[ idTemasNivel3=" + idTemasNivel3 + " ]";
    }
    
}
