/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.Indicadores;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class IndicadoresDAO {
    private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param indicador
     * @return
     */
    public int insert(Indicadores indicador)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(indicador); 
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
     * @param indicador
     * @throws HibernateException
     */
    public void update(Indicadores indicador) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(indicador); 
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
     * @param contacto
     * @throws HibernateException
     */
    public void delete(Indicadores id) throws HibernateException 
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
     * @param idindicador
     * @return
     * @throws HibernateException
     */
    public Indicadores selectById(String idindicador) throws HibernateException
{ 
    Indicadores indicador = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        indicador = (Indicadores) sesion.get(Indicadores.class, idindicador); 
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
    return indicador; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<Indicadores> selectAll() throws HibernateException
{ 
    List<Indicadores> listaindicador = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaindicador = sesion.createQuery("from Indicadores").list();
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
    return listaindicador; 
}

}
