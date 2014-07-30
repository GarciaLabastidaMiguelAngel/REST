/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.persistencia;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 *
 * @author miguel
 */
@Entity
    public class Indicadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_indicador")
    private String idIndicador;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nota")
    private String nota;
   

    public Indicadores() {
    }

    public Indicadores(String idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Indicadores(String idIndicador, String descripcion) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
    }
    
    public Indicadores(String idIndicador, String descripcion, String nota) {
        this.idIndicador = idIndicador;
        this.descripcion = descripcion;
        this.nota = nota;
    }

       

    public String getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(String idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIndicador != null ? idIndicador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicadores)) {
            return false;
        }
        Indicadores other = (Indicadores) object;
        if ((this.idIndicador == null && other.idIndicador != null) || (this.idIndicador != null && !this.idIndicador.equals(other.idIndicador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.persistencia.newpackage.Indicadores[ idIndicador=" + idIndicador + " ]";
    }
    
}
