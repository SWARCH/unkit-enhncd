/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Vehicle;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class VehicleDAO implements DAO<Vehicle>, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public List<Vehicle> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<Vehicle> retrievedVehicles = null;
        try {
            retrievedVehicles = em.createNamedQuery("Vehicle.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in VehicleDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedVehicles;
    }

    @Override
    public Vehicle searchById(Object id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Vehicle vehicle = null;
        try {
            vehicle = em.find(Vehicle.class, (Integer)id);
        } catch (Exception e) {
            System.err.println("Problems in VehicleDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return vehicle;
    }

    @Override
    public boolean create(Vehicle newVehicle) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newVehicle);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in VehicleDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Object id, Vehicle editedVehicle) {
        Vehicle tmpVehicle;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpVehicle = em.merge(this.searchById((Integer)id));
            tmpVehicle.setTrademark(editedVehicle.getTrademark());
            tmpVehicle.setModel(editedVehicle.getModel());
            tmpVehicle.setDescription(editedVehicle.getDescription());
            tmpVehicle.setColor(editedVehicle.getColor());
            tmpVehicle.setCost(editedVehicle.getCost());
            
            tmpVehicle.setUnits(editedVehicle.getUnits());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in VehicleDAO.update(): " + e);
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
        Vehicle delVehicle;
        em.getTransaction().begin();
        try {
            delVehicle = em.merge(this.searchById(id));
            em.remove(delVehicle);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in VehicleDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
}
