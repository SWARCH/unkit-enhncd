/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.ProductOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class ProductOrderDAO implements DAO<ProductOrder>, Serializable {
    private static final long serialVersionUID = 1L;
    
    @Override
    public List<ProductOrder> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<ProductOrder> retrievedProductOrders = null;
        try {
            retrievedProductOrders = em.createNamedQuery("ProductOrder.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in ProductOrderDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedProductOrders;
    }

    @Override
    public ProductOrder searchById(Object id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        ProductOrder productOrder = null;
        try {
            productOrder = em.find(ProductOrder.class, (Integer)id);
        } catch (Exception e) {
            System.err.println("Problems in ProductOrderDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return productOrder;
    }

    @Override
    public boolean create(ProductOrder newProductOrder) {
        System.out.println("ProductOrderDAO.create(): It is working!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Data sended:" + newProductOrder);
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newProductOrder);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in ProductOrderDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Object id, ProductOrder editedProductOrder) {
        ProductOrder tmpProductOrder;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpProductOrder = em.merge(this.searchById(id));
            tmpProductOrder.setProductOrderPK(
                    editedProductOrder.getProductOrderPK());
            tmpProductOrder.setCustomer(
                    editedProductOrder.getCustomer());
            tmpProductOrder.setDate(
                    editedProductOrder.getDate());
            tmpProductOrder.setDeliveryDate(
                    editedProductOrder.getDeliveryDate());
            tmpProductOrder.setOrderCost(
                    editedProductOrder.getOrderCost());
            tmpProductOrder.setOrderPartList(
                    editedProductOrder.getOrderPartList());
            tmpProductOrder.setOrderVehicleList(
                    editedProductOrder.getOrderVehicleList());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in ProductOrderDAO.update(): " + e);
            em.getTransaction().rollback();
            isSuccessful = false;
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean delete(Object id) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        ProductOrder delProductOrder = this.searchById(id);
        em.getTransaction().begin();
        try {
            em.remove(delProductOrder);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in ProductOrderDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
    
    
}
