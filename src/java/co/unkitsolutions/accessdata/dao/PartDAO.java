/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Part;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class PartDAO implements DAO<Part>, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public List<Part> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<Part> retrievedParts = null;
        try {
            retrievedParts = em.createNamedQuery("Part.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in PartDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedParts;
    }

    @Override
    public Part searchById(Object id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Part part = null;
        try {
            part = em.find(Part.class, (Integer)id);
        } catch (Exception e) {
            System.err.println("Problems in PartDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return part;
    }

    @Override
    public boolean create(Part newPart) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newPart);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in PartDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Object id, Part editedPart) {
        Part tmpPart;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpPart = em.merge(this.searchById(id));
            tmpPart.setName(editedPart.getName());
            tmpPart.setCost(editedPart.getCost());
            tmpPart.setDescription(editedPart.getDescription());
            tmpPart.setUnits(editedPart.getUnits());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in PartDAO.update(): " + e);
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
        Part delPart = this.searchById(id);
        em.getTransaction().begin();
        try {
            em.remove(delPart);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in PartDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
}
