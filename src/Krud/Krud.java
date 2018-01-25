/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Krud;

import Entiteti.Pivo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafxapplication9.HibernateUtil;
import javax.print.DocFlavor;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.Object;


public class Krud
{

    private static Krud instanca = null;

    /**
     *
     * @param <T>
     * @param list
     *
     *
     *
     */

    private Krud()
    {
    }

    public static Krud getInstanca()
    {
        if (instanca == null)
        {

            instanca = new Krud();
            return instanca;

        } else
        {
            return instanca;
        }
    }

    public <T> List readall(String s)
    {
        Session sesion = null;
        Transaction transaction = null;

        List<T> linta = new ArrayList<>();
        try
        {
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            linta = sesion.createQuery(s).list();
        } catch (HibernateException e)
        {

            e.printStackTrace();
        } finally
        {
            sesion.close();
        }
        return linta;
    }

    public <T> void insert(T t)
    {
        Session sesion = null;
        Transaction transaction = null;
        try
        {
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            sesion.persist(t);
            transaction.commit();

        } catch (HibernateException e)
        {
            System.out.println("Hibernate exception");
            e.printStackTrace();
        } finally
        {
            sesion.close();
        }

    }

    public <T> void update(T t)
    {
        Session sesion = null;
        Transaction transaction = null;
        try
        {
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            sesion.saveOrUpdate(t);
            transaction.commit();
            System.out.println("Uspelo");

        } catch (HibernateException e)
        {
            System.out.println("Greska u update");
            e.printStackTrace();
        } finally
        {
            sesion.close();
        }

    }
    public static boolean proveri(String s,String naziv)
    {
        Session sesion = null;
        Transaction transaction = null;
        boolean provera = false;
       
        try {
             sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
             Query query = sesion.createQuery("count(*) from :entitet where naziv=:naziv");
             query.setString(":entitet", s);
             query.setString(":naziv", naziv);
             int broj = (int) query.uniqueResult();
             if (broj == 1) {
                 
                provera =  true;
                 System.out.println(broj);
            }
             else{
                 provera = false;
             }
            
        } catch (HibernateException e) {
            
            e.printStackTrace();
        }
        finally
        {
            sesion.close();
            
        }
        return provera;
        
        
        
    }
    
    public <T> void  delete(T t)
    {
         Session sesion = null;
        Transaction transaction = null;
        try
        {
            sesion = HibernateUtil.getSessionFactory().openSession();
            transaction = sesion.beginTransaction();
            sesion.delete(t);
            transaction.commit();
            System.out.println("Uspelo");

        } catch (HibernateException e)
        {
            System.out.println("Greska u update");
            e.printStackTrace();
        } finally
        {
            sesion.close();
        }
    
    
    
    }

}
