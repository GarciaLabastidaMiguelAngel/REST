/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegistrosDAO;
import model.persistencia.Registros;
import model.util.Datos;
import model.util.Error;
import model.util.schemas.DatosRegistrosIdMunicipio;
import model.util.schemas.DatosRegistrosMunicipios;
import org.hibernate.HibernateException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
            List<DatosRegistrosIdMunicipio> listaFinal;
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
                    e.setTypeAndDescription("errorServer",ex.getMessage());
                    JSON=new Gson();
                     return JSON.toJson(e);
            }
            listaFinal=new ArrayList<>();
            for(Registros r:listaRegistros){
                listaFinal.add(new DatosRegistrosIdMunicipio(r.getIdRegistros(),r.getAnio(),r.getCantidad()));
            }
                      
        
            Datos<DatosRegistrosIdMunicipio> datos = new Datos<>();
            datos.setDatos(listaFinal);
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(datos);
            }
            
            
        /*
     * @param idi
     * @param idm
     * @param request
     * @param response
     * @return XML
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(value="/{idi}/municipios/{idm}",method=RequestMethod.GET,
                    produces="application/xml")    
            public String getXML(@PathVariable("idi") String idi,
                                  @PathVariable("idm") int idm,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            

            XStream XML= new XStream();
            List<DatosRegistrosIdMunicipio> listaFinal;
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
                    XML.alias("message",Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServer",ex.getMessage());
                     XML.alias("message",Error.class);
                    return XML.toXML(e);
            }
            listaFinal=new ArrayList<>();
            for(Registros r:listaRegistros){
                listaFinal.add(new DatosRegistrosIdMunicipio(r.getIdRegistros(),r.getAnio(),r.getCantidad()));
            }
               
            response.setStatus(HttpServletResponse.SC_OK);
            XML.alias("registro",DatosRegistrosIdMunicipio.class);
            return XML.toXML(listaFinal);
            }
            
            
            
            
            
            
             /**
     *
     * @param idi
     * @param request
     * @param response
     * @return JSON
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(value="/{idi}/municipios",method=RequestMethod.GET,
                    produces="application/json")    
            public String getmJSON(@PathVariable("idi") String idi,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            

            Gson JSON;
            List<DatosRegistrosMunicipios> listaFinal;
            List<Registros> listaRegistros;
            RegistrosDAO tablaRegistros;
            tablaRegistros = new RegistrosDAO();
             /*
            *obtenemos la lista Registros
            */
            try {
                listaRegistros=tablaRegistros.selectAllResgistrosByIdIndicador(idi);
                if(listaRegistros.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros del indicador:"+idi);
                    JSON=new Gson();
                     return JSON.toJson(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServer",ex.getMessage());
                    JSON=new Gson();
                     return JSON.toJson(e);
            }
            listaFinal=new ArrayList<>();
            for(Registros r:listaRegistros){
                listaFinal.add(new DatosRegistrosMunicipios(r.getIdRegistros(),r.getAnio(),r.getCantidad(),r.getIdMunicipio()));
            }
                      
        
            Datos<DatosRegistrosMunicipios> datos = new Datos<>();
            datos.setDatos(listaFinal);
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(datos);
            }
            
            
        /*
     * @param idi
     * @param idm
     * @param request
     * @param response
     * @return XML
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(value="/{idi}/municipios",method=RequestMethod.GET,
                    produces="application/xml")    
            public String getmXML(@PathVariable("idi") String idi,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {            

            XStream XML= new XStream();
            List<DatosRegistrosMunicipios> listaFinal;
            List<Registros> listaRegistros;
            RegistrosDAO tablaRegistros;
            tablaRegistros = new RegistrosDAO();
             /*
            *obtenemos la lista Registros
            */
            try {
                listaRegistros=tablaRegistros.selectAllResgistrosByIdIndicador(idi);
                if(listaRegistros.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen registros del indicador:"+idi);
                    XML.alias("message",Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServer",ex.getMessage());
                     XML.alias("message",Error.class);
                    return XML.toXML(e);
            }
            listaFinal=new ArrayList<>();
            for(Registros r:listaRegistros){
                listaFinal.add(new DatosRegistrosMunicipios(r.getIdRegistros(),r.getAnio(),r.getCantidad(),r.getIdMunicipio()));
            }
               
            response.setStatus(HttpServletResponse.SC_OK);
            XML.alias("registro",DatosRegistrosMunicipios.class);
            return XML.toXML(listaFinal);
            }
            
//************************POST***************************************************            
    /**
     *
     * @param body
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method=RequestMethod.POST,
                    produces="application/json",consumes="application/json")
            public String setJSON(@RequestBody String body,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Registros m;
              Gson JSON=new Gson();
              try{
                m=JSON.fromJson(body, Registros.class);
              }
              catch(JsonSyntaxException ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax",ex.getMessage().split("java.io.EOFException:")[1]);
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              if(m.getCantidad()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              
              if(m.getAnio()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              
              if(m.getIdIndicador()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              
              if(m.getIdMunicipio()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              try {
                RegistrosDAO tabla=new RegistrosDAO();
                m.setIdhash(m.hashCode());
                tabla.insert(m);
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error er=new Error();
                    er.setTypeAndDescription("errorServerError",ex.getMessage());
                    JSON=new Gson();
                    return JSON.toJson(er);
            }
             response.setStatus(HttpServletResponse.SC_OK);
              Error er=new Error();
                    er.setTypeAndDescription("successful","exito en la operacion");
                    JSON=new Gson();
              return JSON.toJson(er);
            
        }         
            
    /**
     *
     * @param body
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method=RequestMethod.POST,
                    produces="application/xml",consumes="application/xml")
            public String setXML(@RequestBody String body,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Registros m;
              XStream XML;
              XML = new XStream(new DomDriver());
              try{
                 XML.setClassLoader(Registros.class.getClassLoader());
                 XML.alias("indicadormonto",Registros.class);
                m=(Registros)XML.fromXML(body);
              }
              catch(Exception ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("XMLSyntax",ex.getMessage());
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
                if(m.getCantidad()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              
              if(m.getAnio()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                   XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              
              if(m.getIdIndicador()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              
              if(m.getIdMunicipio()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              try {
                RegistrosDAO tabla=new RegistrosDAO();
                m.setIdhash(m.hashCode());
                tabla.insert(m);
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error er=new Error();
                    er.setTypeAndDescription("errorServerError",ex.getMessage());
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
            }
             response.setStatus(HttpServletResponse.SC_OK);
              Error er=new Error();
                    er.setTypeAndDescription("successful","exito en la operacion");
                   XML.alias("message", Error.class);
                    return XML.toXML(er);
            
        } 
                     
    
   
}
            
            
            
 
