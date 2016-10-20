/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Customer;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class CustomerDAO {
    public static final String WHOLESALER_TYPE = "wholesaler";
    public static final String ASSEMBLER_TYPE = "assembler";
    
    public Customer searchByUserId(String userId) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Customer customer = null;
        try {
            customer = em.find(Customer.class, userId);
        } catch (Exception e) {
            System.err.println("Problems in CustomerDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return customer;
    }
    
}
