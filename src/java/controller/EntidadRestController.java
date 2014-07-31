/*
*Esta clase funciona como controlador de las peticiones Rest para las entidades 
 */

package controller;



import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.thoughtworks.xstream.XStream;
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
                    e.setTypeAndDescription("DataBase",ex.getMessage());
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
        
            Datos<Entidades> datos=new Datos<Entidades>();
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
                    e.setTypeAndDescription("DataBaseError",ex.getMessage());
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
                    e.setTypeAndDescription("DataBase",ex.getMessage());
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
        
            Datos<Municipios> datos=new Datos<>();
            datos.setDatos(lista);
            XML= new XStream();
            XML.alias("municipio",Municipios.class);       
            response.setStatus(HttpServletResponse.SC_OK);
            return XML.toXML(lista);
            }
            
            
    @RequestMapping(method=RequestMethod.POST,
                    produces="application/json")
            public String setClientes(@RequestBody String body,
                                     HttpServletRequest request,
                                     HttpServletResponse response) {
              Entidades e;
        e = new Entidades("oaxaca");
              EntidadesDAO bd=new EntidadesDAO();
              int i;
        i = bd.insert(e);
                /*
                JsonParser parser = new JsonParser();
                JsonElement datos = parser.parse(body);
                JsonObject JSON=datos.getAsJsonObject();
              String resultado="";
                String key;
            Enumeration headerNames = request.getParameterNames();
		while (headerNames.hasMoreElements()) {
                        key=(String) headerNames.nextElement();
			resultado += "key:"+key+"\n";
			resultado += "value:"+ request.getParameter(key)+"\n\n";
		}*/
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return String.valueOf(i);
        }         
     
}
