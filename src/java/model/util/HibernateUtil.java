/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author miguel
 * sessionFactory se declara como static para poder acceder a ella sin crear
 * un objeto de la clase HibernateUtil y se decalara final para que cuando se
 * asigne una referencia esta no cambie, tambien declaramos un bloque static 
 * para que cuando la clase se cargue a la JVM se inicalize la variable y asi 
 * tengamos una sola instancia de sessionFactory
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static
{
    try 
    { 
        sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (HibernateException he) 
    { 
        System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he); 
        throw new ExceptionInInitializerError(he); 
    } 
}
    
    public static SessionFactory getSessionFactory()
{ 
    return sessionFactory;
} 
}
