/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.Entidades;
import model.persistencia.Municipios;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class EntidadesDAO {
    private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param entidad
     * @return
     */
    public int insert(Entidades entidad)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(entidad); 
        tx.commit(); 
    }catch(HibernateException he) 
    { 
        error=he;
         tx.rollback();
    }finally 
    { 
        sesion.close(); 
    }  
    if(error!=null)
        throw error;
    return id; 
}

    /**
     *
     * @param entidad
     * @throws HibernateException
     */
    public void update(Entidades entidad) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(entidad); 
        tx.commit(); 
    }
    catch (HibernateException he) 
    { 
       error=he; 
        tx.rollback();
    }finally 
    { 
        sesion.close(); 
    } 
    if(error!=null)
        throw error;
}

    /**
     *
     * @param id
     * @throws HibernateException
     */
    public void delete(Entidades id) throws HibernateException 
{ 
    
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.delete(id); 
        tx.commit(); 
    } catch (HibernateException he)
    {
        error=he;     
         tx.rollback();
    }finally 
    { 
        sesion.close(); 
    } 
    if(error!=null)
        throw error;
}

    /**
     *
     * @param idEntidad
     * @return
     * @throws HibernateException
     */
    public Entidades selectById(Integer idEntidad) throws HibernateException
{ 
    Entidades entidad = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        entidad = (Entidades) sesion.get(Entidades.class, idEntidad); 
    } 
    catch(HibernateException e){
        error=e;
         tx.rollback();
    }
    finally 
    { 
        sesion.close(); 
    }  
    if(error!=null)
        throw error;
    return entidad; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<Entidades> selectAll() throws HibernateException
{ 
    List<Entidades> listaEntidad = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaEntidad = sesion.createQuery("from Entidades").list();
    } 
    
        catch(HibernateException e){
                error=e;
                 tx.rollback();
     }
   finally { 
        sesion.close(); 
    }  
    if(error!=null)
        throw error;
    return listaEntidad; 
}
    
    public List<Municipios> selectAllMunicipios(int id) throws HibernateException
{ 
    List<Municipios> listaMunicipios = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaMunicipios = sesion.createQuery("from Municipios where idEntidad="+id).list();
    } 
    
        catch(HibernateException e){
                error=e;
                 tx.rollback();
     }
   finally { 
        sesion.close(); 
    }  
    if(error!=null)
        throw error;
    return listaMunicipios; 
}

}



