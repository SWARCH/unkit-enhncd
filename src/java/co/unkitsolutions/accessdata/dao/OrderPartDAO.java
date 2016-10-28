/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.OrderPart;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class OrderPartDAO implements DAO<OrderPart>{

    @Override
    public List<OrderPart> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<OrderPart> retrievedOrderParts = null;
        try {
            retrievedOrderParts = em.createNamedQuery("OrderPart.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in OrderPartDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedOrderParts;
    }

    @Override
    public OrderPart searchById(String id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        OrderPart orderPart = null;
        try {
            orderPart = em.find(OrderPart.class, id);
        } catch (Exception e) {
            System.err.println("Problems in OrderPartDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return orderPart;
    }

    @Override
    public boolean create(OrderPart newOrderPart) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newOrderPart);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in OrderPartDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(String id, OrderPart editedOrderPart) {
        OrderPart tmpOrderPart;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpOrderPart = em.merge(this.searchById(id));
            tmpOrderPart.setOrderPartPK(editedOrderPart.getOrderPartPK());
            tmpOrderPart.setPart(editedOrderPart.getPart());
            tmpOrderPart.setProductOrder(editedOrderPart.getProductOrder());
            tmpOrderPart.setQuantity(editedOrderPart.getQuantity());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in OrderPartDAO.update(): " + e);
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
        OrderPart delOrderPart = this.searchById(id);
        em.getTransaction().begin();
        try {
            em.remove(delOrderPart);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in OrderPartDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
}
