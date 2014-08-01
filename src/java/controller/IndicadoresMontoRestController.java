/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EntidadesDAO;
import model.IndicadoresDAO;
import model.RegistrosDAO;
import model.persistencia.Entidades;
import model.persistencia.Indicadores;
import model.persistencia.Registros;
import model.util.Datos;
import model.util.schemas.DatosRegistros;
import model.util.Error;
import model.util.schemas.RegistrosAnios;
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
@RequestMapping("api/indicadoresMonto")
public class IndicadoresMontoRestController {
    /**
     *
     * @param id
     * @param request
     * @param response
     * @return JSON
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(value="/{id}/entidades",method=RequestMethod.GET,
                    produces="application/json")    
            public String getJSON(@PathVariable("id") String id,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            
            EntidadesDAO tablaEntidades;
            Gson JSON;
            List<Entidades> listaEntidades;
            List<DatosRegistros> listaFinal;
            List<Registros> listaRegistros;
            IndicadoresDAO tablaIndicadores;
            RegistrosDAO tablaRegistros;
            tablaEntidades = new EntidadesDAO();
             /*
            *obtenemos la lista de entidades
            */
            try {
                listaEntidades=tablaEntidades.selectAll();
                if(listaEntidades.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros de entidades");
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
            /*
            *obtenemos el indicador
            */
            
            tablaIndicadores = new IndicadoresDAO();
            Indicadores indicador;
            try {
                indicador=tablaIndicadores.selectById(id);
                if(indicador==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existe el indicador solicitado con id:"+id);
                    JSON=new Gson();
                    return JSON.toJson(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("DataBaseError",ex.getMessage());
                    JSON=new Gson();
                     return JSON.toJson(e);
            }
            
            tablaRegistros = new RegistrosDAO();
             /*
            *obtenemos la lista Registros
            */
            try {
                listaRegistros=tablaRegistros.selectAllResgistrosByIdIndicador(id);
                if(listaRegistros.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros del indicador con id:"+id);
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
            for(Entidades e:listaEntidades){
                DatosRegistros d=new DatosRegistros();
                d.setEntidad(e);
                d.setIndicador(indicador);
                for(Registros r:listaRegistros){
                    if(r.getIdEntidad().equals(e.getIdEntidad())){
                        RegistrosAnios a=new RegistrosAnios(r.getAnio(),r.getCantidad());
                        d.addRegistroAnios(a);
                    }
                }
                listaFinal.add(d);
            }
                      
        
            Datos<DatosRegistros> datos = new Datos<>();
            datos.setDatos(listaFinal);
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(datos);
            }
            
            
            
            
            
            /**
     *
     * @param id
     * @param request
     * @param response
     * @return XML
     * Este metodo se encarga de generar la lista de indicadores monto de las entidades
     */    
    
    @RequestMapping(value="/{id}/entidades",method=RequestMethod.GET,
                    produces="application/xml")    
            public String getXML(@PathVariable("id") String id,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            
            EntidadesDAO tablaEntidades;
            XStream XML;
            List<Entidades> listaEntidades;
            List<DatosRegistros> listaFinal;
            List<Registros> listaRegistros;
            IndicadoresDAO tablaIndicadores;
            RegistrosDAO tablaRegistros;
            tablaEntidades = new EntidadesDAO();
             /*
            *obtenemos la lista de entidades
            */
            try {
                listaEntidades=tablaEntidades.selectAll();
                if(listaEntidades.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros de entidades");
                    XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("DataBase",ex.getMessage());
                     XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
            }
            /*
            *obtenemos el indicador
            */
            
            tablaIndicadores = new IndicadoresDAO();
            Indicadores indicador;
            try {
                indicador=tablaIndicadores.selectById(id);
                if(indicador==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existe el indicador solicitado con id:"+id);
                     XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("DataBaseError",ex.getMessage());
                    XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
            }
            
            tablaRegistros = new RegistrosDAO();
             /*
            *obtenemos la lista Registros
            */
            try {
                listaRegistros=tablaRegistros.selectAllResgistrosByIdIndicador(id);
                if(listaRegistros.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros del indicador con id:"+id);
                     XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("DataBase",ex.getMessage());
                     XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
            }
            listaFinal=new ArrayList<>();
            for(Entidades e:listaEntidades){
                DatosRegistros d=new DatosRegistros();
                d.setEntidad(e);
                d.setIndicador(indicador);
                for(Registros r:listaRegistros){
                    if(r.getIdEntidad().equals(e.getIdEntidad())){
                        RegistrosAnios a=new RegistrosAnios(r.getAnio(),r.getCantidad());
                        d.addRegistroAnios(a);
                    }
                }
                listaFinal.add(d);
            }
                      
        
            Datos<DatosRegistros> datos = new Datos<>();
            datos.setDatos(listaFinal);
            XML= new XStream();
            XML.alias("registro",DatosRegistros.class);
            XML.alias("dac",RegistrosAnios.class);
            XML.alias("response",Datos.class);
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(datos);
            }
            
            
 
            
    /**
     *
     * @param request
     * @param response
     * @return XML
     * Este metodo se encarga de generar la lista de entidades
     */
    @RequestMapping(method=RequestMethod.GET,
                    produces="application/xml")     
            public String getXML(HttpServletRequest request,
                                         HttpServletResponse response) { 
             RegistrosDAO tabla=new RegistrosDAO();
            XStream XML;
            List<Registros> lista;
            
            try {
                lista=tabla.selectAll();     
                
               if(lista.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen elementos");
                    XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("dataBaseError",ex.getMessage());
                    XML= new XStream();
                    XML.alias("dataInfo", Error.class);
                    return XML.toXML(e);
            }
        
            Datos<Registros> datos=new Datos<Registros>();
            datos.setDatos(lista);
            XML= new XStream();
            XML.alias("MMMM",Entidades.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(lista);
            }
}
