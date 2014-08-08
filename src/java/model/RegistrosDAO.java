/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import model.persistencia.Registros;
import model.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author miguel
 */
public class RegistrosDAO {
       private Session sesion;
    private Transaction tx;

private void iniciaOperacion() throws HibernateException
{
    sesion = HibernateUtil.getSessionFactory().openSession();
    tx = sesion.beginTransaction();
}
    
    
    
  public List<Registros> selectAllResgistrosByIdIndicadorAndMunicipio(String idIndicador,int municipio) throws HibernateException
{ 
    List<Registros> listaRegistros = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaRegistros = sesion.createQuery("from Registros  where idIndicador='"+idIndicador+"' and idMunicipio="+municipio).list();
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
    return listaRegistros; 
}
  
  
    public List<Registros> selectAllResgistrosByIdIndicador(String idIndicador) throws HibernateException
{ 
    List<Registros> listaRegistros = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listaRegistros = sesion.createQuery("from Registros  where idIndicador='"+idIndicador+"'").list();
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
    return listaRegistros; 
}
  
  
  
    public List<Registros> selectAll() throws HibernateException
{ 
    List<Registros> listamunicipio = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        listamunicipio = sesion.createQuery("from Registros").list();
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
    
      public int insert(Registros entidad)throws HibernateException
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
      
        public Registros selectById(Integer idRegistros) throws HibernateException
{ 
    Registros r = null;  
    HibernateException error=null;
    try 
    { 
        iniciaOperacion(); 
        r = (Registros) sesion.get(Registros.class, idRegistros); 
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
    return r; 
}
        
        
          public void delete(Registros id) throws HibernateException 
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


}
