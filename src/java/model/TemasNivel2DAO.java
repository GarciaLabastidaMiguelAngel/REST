/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.TemasNivel2;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class TemasNivel2DAO {
        private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{    
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param temasNivel2
     * @return
     */
    public int insert(TemasNivel2 temasNivel2)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(temasNivel2); 
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
     * @param temasNivel2
     * @throws HibernateException
     */
    public void update(TemasNivel2 temasNivel2) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(temasNivel2); 
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
    public void delete(TemasNivel2 id) throws HibernateException 
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
     * @param idtemasNivel2
     * @return
     * @throws HibernateException
     */
    public TemasNivel2 selectById(Integer idtemasNivel2) throws HibernateException
{ 
    TemasNivel2 temasNivel2 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        temasNivel2 = (TemasNivel2) sesion.get(TemasNivel2.class, idtemasNivel2); 
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
    return temasNivel2; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<TemasNivel2> selectAll() throws HibernateException
{ 
    List<TemasNivel2> listatemasNivel2 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listatemasNivel2 = sesion.createQuery("from TemasNivel2").list();
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
    return listatemasNivel2; 
}

}
