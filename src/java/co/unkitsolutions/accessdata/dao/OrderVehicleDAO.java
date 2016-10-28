/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.OrderVehicle;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class OrderVehicleDAO implements DAO<OrderVehicle>{
    
    @Override
    public List<OrderVehicle> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<OrderVehicle> retrievedOrderVehicles = null;
        try {
            retrievedOrderVehicles = em.createNamedQuery("OrderVehicle.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in OrderVehicleDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedOrderVehicles;
    }

    @Override
    public OrderVehicle searchById(String id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        OrderVehicle orderVehicle = null;
        try {
            orderVehicle = em.find(OrderVehicle.class, id);
        } catch (Exception e) {
            System.err.println("Problems in OrderVehicleDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return orderVehicle;
    }

    @Override
    public boolean create(OrderVehicle newOrderVehicle) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newOrderVehicle);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in OrderVehicleDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(String id, OrderVehicle editedOrderVehicle) {
        OrderVehicle tmpOrderVehicle;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpOrderVehicle = em.merge(this.searchById(id));
            tmpOrderVehicle.setOrderVehiclePK(editedOrderVehicle.getOrderVehiclePK());
            tmpOrderVehicle.setVehicle(editedOrderVehicle.getVehicle());
            tmpOrderVehicle.setProductOrder(editedOrderVehicle.getProductOrder());
            tmpOrderVehicle.setQuantity(editedOrderVehicle.getQuantity());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in OrderVehicleDAO.update(): " + e);
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
        OrderVehicle delOrderVehicle = this.searchById(id);
        em.getTransaction().begin();
        try {
            em.remove(delOrderVehicle);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in OrderVehicleDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
}
