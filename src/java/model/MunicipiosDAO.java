/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.Municipios;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class MunicipiosDAO {
    private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param municipio
     * @return
     */
    public int insert(Municipios municipio)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(municipio); 
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
     * @param municipio
     * @throws HibernateException
     */
    public void update(Municipios municipio) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(municipio); 
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
    public void delete(Municipios id) throws HibernateException 
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
     * @param idmunicipio
     * @return
     * @throws HibernateException
     */
    public Municipios selectById(Integer idmunicipio) throws HibernateException
{ 
    Municipios municipio = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        municipio = (Municipios) sesion.get(Municipios.class, idmunicipio); 
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
    return municipio; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<Municipios> selectAll() throws HibernateException
{ 
    List<Municipios> listamunicipio = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listamunicipio = sesion.createQuery("from Municipios").list();
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
    return listamunicipio; 
}

}
