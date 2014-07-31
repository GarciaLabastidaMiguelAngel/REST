/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.TemasNivel1;
import model.persistencia.TemasNivel2;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class TemasNivel1DAO {
        private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{    
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}



    /**
     *
     * @param temasNivel1
     * @return
     */
    public int insert(TemasNivel1 temasNivel1)throws HibernateException
{ 
    int id = 0;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        id = (int)sesion.save(temasNivel1); 
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
     * @param temasNivel1
     * @throws HibernateException
     */
    public void update(TemasNivel1 temasNivel1) throws HibernateException 
{ 
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        sesion.update(temasNivel1); 
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
    public void delete(TemasNivel1 id) throws HibernateException 
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
     * @param idtemasNivel1
     * @return
     * @throws HibernateException
     */
    public TemasNivel1 selectById(Integer idtemasNivel1) throws HibernateException
{ 
    TemasNivel1 temasNivel1 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        temasNivel1 = (TemasNivel1) sesion.get(TemasNivel1.class, idtemasNivel1); 
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
    return temasNivel1; 
}

    /**
     *
     * @return
     * @throws HibernateException
     */
    public List<TemasNivel1> selectAll() throws HibernateException
{ 
    List<TemasNivel1> listatemasNivel1 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listatemasNivel1 = sesion.createQuery("from TemasNivel1").list();
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
    return listatemasNivel1; 
}
    
      public List<TemasNivel2> selectAllTemasNivel2(int id) throws HibernateException
{ 
    List<TemasNivel2> listaTemasNivel2 = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaTemasNivel2 = sesion.createQuery("from TemasNivel2 where idTemasNivel1="+id).list();
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
    return listaTemasNivel2; 
}


}
