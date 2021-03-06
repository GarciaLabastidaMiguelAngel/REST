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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.IndicadoresDAO;
import model.persistencia.Indicadores;
import model.util.Datos;
import model.util.Error;
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
@RequestMapping("api/indicadores")
public class IndicadoresRestController {
       /**
     *
     * @param request
     * @param response
     * @return JSON
     */    
    @RequestMapping(method=RequestMethod.GET,
                    produces="application/json")    
            public String getJSON(HttpServletRequest request,
                                          HttpServletResponse response) {            
            IndicadoresDAO tabla=new IndicadoresDAO();
            Gson JSON;
            List<Indicadores> lista;
            try {
                lista=tabla.selectAll();
                if(lista.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen elementos");
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
        
            Datos<Indicadores> datos=new Datos<>();
            datos.setDatos(lista);
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(datos);
            }            
    /**
     *
     * @param request
     * @param response
     * @return XML
     */
    @RequestMapping(method=RequestMethod.GET,
                    produces="application/xml")     
            public String getXML(HttpServletRequest request,
                                         HttpServletResponse response) { 
             IndicadoresDAO tabla=new IndicadoresDAO();
            XStream XML;
            List<Indicadores> lista;
            
            try {
                lista=tabla.selectAll();     
                
               if(lista.isEmpty()){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                   Error e=new Error();
                    e.setTypeAndDescription("Warning","No existen elementos");
                    XML= new XStream();
                    XML.alias("message", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServerError",ex.getMessage());
                    XML= new XStream();
                    XML.alias("message", Error.class);
                    return XML.toXML(e);
            }
        
            Datos<Indicadores> datos=new Datos<>();
            datos.setDatos(lista);
            XML= new XStream();
            XML.alias("indicador",Indicadores.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(lista);
            }
            
            
            
            
     /**
     *
     * @param id
     * @param request
     * @param response
     * @return JSON
     */
    @RequestMapping(value="/{id}",
                     method=RequestMethod.GET,
                     produces="application/json")     
            public String getByIdJSON(@PathVariable("id") String id,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
                
            IndicadoresDAO tabla=new IndicadoresDAO();
            Gson JSON;
            Indicadores elemento;
            try {
                elemento=tabla.selectById(id);
                if(elemento==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existe el elemeto solicitado con id:"+id);
                    JSON=new Gson();
                    return JSON.toJson(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServerError",ex.getMessage());
                    JSON=new Gson();
                     return JSON.toJson(e);
            }
        
            JSON=new Gson();
            response.setStatus(HttpServletResponse.SC_OK);
            return JSON.toJson(elemento);           
            }
            
            
            
            /**
     *
     * @param id
     * @param request
     * @param response
     * @return XML
     */
    @RequestMapping(value="/{id}",
                     method=RequestMethod.GET,
                     produces="application/xml")     
            public String getByIdXML(@PathVariable("id") String id,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
                
            IndicadoresDAO tabla=new IndicadoresDAO();
            XStream XML;
            Indicadores elemento;
            try {
                elemento=tabla.selectById(id);
                if(elemento==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error e=new Error();
                    e.setTypeAndDescription("Warning","No existe el elemeto solicitado con id:"+id);
                    XML= new XStream();
                    XML.alias("message", Error.class);
                    return XML.toXML(e);
                }
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error e=new Error();
                    e.setTypeAndDescription("errorServerError",ex.getMessage());
                    XML= new XStream();
                    XML.alias("message", Error.class);
                    return XML.toXML(e);
            }
        
             XML= new XStream();
            XML.alias("indicador",Indicadores.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(elemento);          
            }
            
            
            //************************POST***********************************************         
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
              Indicadores m;
              Gson JSON=new Gson();
              try{
                m=JSON.fromJson(body, Indicadores.class);
              }
              catch(JsonSyntaxException ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax",ex.getMessage().split("java.io.EOFException:")[1]);
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              if(m.getDescripcion()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              try {
                IndicadoresDAO tabla=new IndicadoresDAO();
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
              Indicadores m;
              XStream XML;
              XML = new XStream(new DomDriver());
              try{
                 XML.setClassLoader(Indicadores.class.getClassLoader());
                 XML.alias("indicador",Indicadores.class);
                m=(Indicadores)XML.fromXML(body);
              }
              catch(Exception ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("XMLSyntax",ex.getMessage());
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              if(m.getDescripcion()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("XMLSyntax","Los parametros no son los correctos verificar");
                   XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              try {
                IndicadoresDAO tabla=new IndicadoresDAO();
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
            
   //***********************DELETE**********************************************         
            /**
     *
     * @param id
     * @param request
     * @param response
     * @return JSON
     */     
        @RequestMapping(value="/{id}",
                        method=RequestMethod.DELETE,
                        produces="application/json")
            public String updateJSON(@PathVariable("id") String id,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Indicadores elemento;
              IndicadoresDAO tabla=new IndicadoresDAO();
              Gson JSON;
              JSON = new Gson();
             
           try {
                elemento=tabla.selectById(id);
                if(elemento==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error er=new Error();
                    er.setTypeAndDescription("Warning","No existe el elemeto solicitado con id:"+id);
                    return JSON.toJson(er);
                }
                 else
                    tabla.delete(elemento);
            } catch (HibernateException ex) {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    Error er=new Error();
                    er.setTypeAndDescription("errorServerError",ex.getMessage());
                   return JSON.toJson(er);
            }            
             response.setStatus(HttpServletResponse.SC_OK);
             Error er=new Error();
             er.setTypeAndDescription("successful","exito en la operacion");
            return JSON.toJson(er);
            
        }  
            
       /**
     *
     * @param id
     * @param request
     * @param response
     * @return XML
     */     
        @RequestMapping(value="/{id}",
                        method=RequestMethod.DELETE,
                        produces="application/xml")
            public String updateXML(@PathVariable("id") String id,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Indicadores elemento;
              IndicadoresDAO tabla=new IndicadoresDAO();
              XStream XML;
              XML = new XStream();
             
           try {
                elemento=tabla.selectById(id);
                if(elemento==null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    Error er=new Error();
                    er.setTypeAndDescription("Warning","No existe el elemeto solicitado con id:"+id);
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
                }
                else
                    tabla.delete(elemento);
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
