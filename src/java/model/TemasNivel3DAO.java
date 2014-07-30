/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.TemasNivel3;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class TemasNivel3DAO {
        private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{    
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param temasNivel3
     * @return
     */
    public int insert(TemasNivel3 temasNivel3)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(temasNivel3); 
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
     * @param temasNivel3
     * @throws HibernateException
     */
    public void update(TemasNivel3 temasNivel3) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(temasNivel3); 
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
    public void delete(TemasNivel3 id) throws HibernateException 
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
     * @param idtemasNivel3
     * @return
     * @throws HibernateException
     */
    public TemasNivel3 selectById(Integer idtemasNivel3) throws HibernateException
{ 
    TemasNivel3 temasNivel3 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        temasNivel3 = (TemasNivel3) sesion.get(TemasNivel3.class, idtemasNivel3); 
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
    return temasNivel3; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<TemasNivel3> selectAll() throws HibernateException
{ 
    List<TemasNivel3> listatemasNivel3 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listatemasNivel3 = sesion.createQuery("from TemasNivel3").list();
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
    return listatemasNivel3; 
}

}
