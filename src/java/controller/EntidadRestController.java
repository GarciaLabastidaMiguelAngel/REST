/*
*Esta clase funciona como controlador de las peticiones Rest para las entidades 
 */

package controller;



import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EntidadesDAO;
import model.persistencia.Entidades;
import model.persistencia.Municipios;
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
/*
*con estas notaciones indicamos que la clase funcionara con controlador tipo 
*rest y que mapeara las solicitudes /api/entidades
*cada metodo esta documentado con el tipo de dato que que retorna especificado
con @return y los parametros que recibe con @param
*/
@RestController
@RequestMapping("api/entidades")
public class EntidadRestController {    
    
    /**
     *
     * @param request
     * @param response
     * @return JSON
     * Este metodo se encarga de generar la lista de entidades 
     */    
    
    @RequestMapping(method=RequestMethod.GET,
                    produces="application/json")    
            public String getJSON(HttpServletRequest request,
                                          HttpServletResponse response) {            
            EntidadesDAO tabla=new EntidadesDAO();
            Gson JSON;
            List<Entidades> lista;
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
        
            Datos<Entidades> datos = new Datos<>();
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
     * Este metodo se encarga de generar la lista de entidades
     */
    @RequestMapping(method=RequestMethod.GET,
                    produces="application/xml")     
            public String getXML(HttpServletRequest request,
                                         HttpServletResponse response) { 
             EntidadesDAO tabla=new EntidadesDAO();
            XStream XML;
            List<Entidades> lista;
            
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
        
            Datos<Entidades> datos=new Datos<>();
            datos.setDatos(lista);
            XML= new XStream();
            XML.alias("entidad",Entidades.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(lista);
            }
            
    /**
     *
     * @param id
     * @param request
     * @param response
     * @return JSON
     * este metodo gestiona las solicitudes de una entidad con un ID esfecificado
     */
    @RequestMapping(value="/{id}",
                     method=RequestMethod.GET,
                     produces="application/json")     
            public String getByIdJSON(@PathVariable("id") int id,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
                
            EntidadesDAO tabla=new EntidadesDAO();
            Gson JSON;
            Entidades elemento;
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
     * este metodo gestiona la solicitud de una entidad con ID especifico
     */
    @RequestMapping(value="/{id}",
                     method=RequestMethod.GET,
                     produces="application/xml")     
            public String getByIdXML(@PathVariable("id") int id,
                                          HttpServletRequest request,
                                          HttpServletResponse response) {
                
            EntidadesDAO tabla=new EntidadesDAO();
            XStream XML;
            Entidades elemento;
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
            XML.alias("entidad",Entidades.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(elemento);          
            }
            
            
            
            
            
            
             /**
     *
     * @param id
     * @param request
     * @param response
     * @return JSON
     * este metodo se encarga de generar la lista de municipios que pertecen 
     * a una entidad con ID especifico 
     */    
    
    @RequestMapping(value="/{id}/municipios",
                    method=RequestMethod.GET,
                    produces="application/json")    
            public String getMunicipiosJSON(@PathVariable("id") int id,
                                            HttpServletRequest request,
                                          HttpServletResponse response) {            
            EntidadesDAO tabla=new EntidadesDAO();
            Gson JSON;
            List<Municipios> lista;
            try {
                lista=tabla.selectAllMunicipios(id);
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
        
            Datos<Municipios> datos = new Datos<>();
            datos.setDatos(lista);
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
     * este metodo se encarga de generar la lista de municipios que pertecen 
     * a una entidad con ID especifico 
     */
    @RequestMapping(value="/{id}/municipios",
                    method=RequestMethod.GET,
                    produces="application/xml")     
            public String getMunicipiosXML(@PathVariable("id") int id,
                                            HttpServletRequest request,
                                            HttpServletResponse response) { 
             EntidadesDAO tabla=new EntidadesDAO();
            XStream XML;
            List<Municipios> lista;
            
            try {
                lista=tabla.selectAllMunicipios(id);     
                
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
        
            Datos<Municipios> datos=new Datos<>();
            datos.setDatos(lista);
            XML= new XStream();
            XML.alias("municipio",Municipios.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(lista);
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
              Entidades e;
              Gson JSON=new Gson();
              try{
                e=JSON.fromJson(body, Entidades.class);
              }
              catch(JsonSyntaxException ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax",ex.getMessage().split("java.io.EOFException:")[1]);
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              if(e.getDescEntidad()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("JSONSyntax","Los parametros no son los correctos verificar");
                    JSON=new Gson();
                     return JSON.toJson(er);
              }
              try {
                EntidadesDAO tabla=new EntidadesDAO();
                tabla.insert(e);
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
     * @return XML
     */
    @RequestMapping(method=RequestMethod.POST,
                    produces="application/xml",consumes="application/xml")
            public String setXML(@RequestBody String body,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Entidades e;
              XStream XML;
              XML = new XStream(new DomDriver());
              try{
                 XML.setClassLoader(Entidades.class.getClassLoader());
                 XML.alias("entidad",Entidades.class);
                e=(Entidades)XML.fromXML(body);
              }
              catch(Exception ex){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                   Error er=new Error();
                    er.setTypeAndDescription("XMLSyntax",ex.getMessage());
                    XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              if(e.getDescEntidad()==null){
                  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                  Error er=new Error();
                    er.setTypeAndDescription("XMLSyntax","Los parametros no son los correctos verificar");
                   XML.alias("message", Error.class);
                    return XML.toXML(er);
              }
              try {
                EntidadesDAO tabla=new EntidadesDAO();
                tabla.insert(e);
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
            
            
 //****************************DELETE***********************************************
            
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
            public String updateJSON(@PathVariable("id") int id,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Entidades elemento;
              EntidadesDAO tabla=new EntidadesDAO();
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
            public String updateXML(@PathVariable("id") int id,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Entidades elemento;
              EntidadesDAO tabla=new EntidadesDAO();
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
