/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegistrosDAO;
import model.persistencia.Registros;
import model.util.Datos;
import model.util.schemas.DatosRegistros;
import model.util.Error;
import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miguel
 */
@RestController
@RequestMapping("api/indicadoresmontos")
public class IndicadoresMontoRestController {
    /**
     *
     * @param idi
     * @param idm
     * @param request
     * @param response
     * @return JSON
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(value="/{idi}/municipios/{idm}",method=RequestMethod.GET,
                    produces="application/json")    
            public String getJSON(@PathVariable("idi") String idi,
                                  @PathVariable("idm") int idm,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            

            Gson JSON;
            List<DatosRegistros> listaFinal;
            List<Registros> listaRegistros;
            RegistrosDAO tablaRegistros;
            tablaRegistros = new RegistrosDAO();
             /*
            *obtenemos la lista Registros
            */
            try {
                listaRegistros=tablaRegistros.selectAllResgistrosByIdIndicadorAndMunicipio(idi,idm);
                if(listaRegistros.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros del indicador:"+idi+" asociados al municipio con id:"+idm);
                    JSON=new Gson();
                     return JSON.toJson(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("DataBase",ex.getMessage());
                    JSON=new Gson();
                     return JSON.toJson(e);
            }
            listaFinal=new ArrayList<>();
            for(Registros r:listaRegistros){
                listaFinal.add(new DatosRegistros(r.getAnio(),r.getCantidad()));
            }
                      
        
            Datos<DatosRegistros> datos = new Datos<>();
            datos.setDatos(listaFinal);
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(datos);
            }
}
            
            
            
 