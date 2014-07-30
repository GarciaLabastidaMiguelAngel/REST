/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miguel
 */
public class ClientesModel {
    
    /**
     *
     * @return
     */
    public static Map getClientes(){
         Map<String,Object> outMap = new HashMap<String,Object>();
         Map<String,Object> outMap2 = new HashMap<String,Object>();
          Map<String,Object> outMap3 = new HashMap<String,Object>();
            outMap.put("id",1);
            outMap.put("nombre","miguel angel");
            outMap.put("apellido","garcia labastida");
            outMap2.put("id",2);
            outMap2.put("nombre","miguel angel");
            outMap2.put("apellido","garcia labastida");
        outMap3.put("cliente-1", outMap);
        outMap3.put("cliente-2", outMap2);
        return outMap3;

    }
    
    /**
     *
     * @param id
     * @return
     */
    public static Map getClientes(int id){
        Map<String,Object> outMap = new HashMap<String,Object>();
        outMap.put("id", id);
        outMap.put("nombre","miguel angel");
        outMap.put("apellido","garcia labastida");
        return outMap;
      
    }
}
