/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Customer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class CustomerDAO implements DAO<Customer>, Serializable {
    private static final long serialVersionUID = 1L;
    public static final String WHOLESALER_TYPE = "wholesaler";
    public static final String ASSEMBLER_TYPE = "assembler";

    @Override
    public List<Customer> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<Customer> retrievedCustomers = null;
        try {
            retrievedCustomers = em.createNamedQuery("Customer.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in CustomerDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedCustomers;
    }

    @Override
    public Customer searchById(String id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Customer customer = null;
        try {
            customer = em.find(Customer.class, id);
        } catch (Exception e) {
            System.err.println("Problems in CustomerDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return customer;
    }

    @Override
    public boolean create(Customer newUser) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newUser);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(String id, Customer editedCustomer) {
        Customer tmpCustomer;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpCustomer = em.merge(this.searchById(id));
            tmpCustomer.setTradeName(editedCustomer.getTradeName());
            tmpCustomer.setType(editedCustomer.getType());
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            isSuccessful = false;
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean delete(String id) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        Customer delCustomer = this.searchById(id);
        UserDAO userDAO = new UserDAO();
        em.getTransaction().begin();
        try {
            em.remove(delCustomer);
            userDAO.delete(id);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
    
    
}