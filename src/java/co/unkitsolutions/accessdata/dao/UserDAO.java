/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mauricio
 */
public class UserDAO implements DAO<User>, Serializable {
    private static final long serialVersionUID = 1L;
    
    public User searchValidUser(String username, String password) {
        System.out.println("Searching valid username: " + username + ", password: " + password);
        EntityManager entityManager = 
                EntityManagerProvider.createEntityManager();
        User retrievedUser = null;
        String strQuery = "SELECT u FROM User u WHERE "
                + "u.username = :username AND u.password = :password";
        try {
            Query query = entityManager.createQuery(strQuery)
                .setParameter("username", username)
                .setParameter("password", password);
            retrievedUser = (User) query.getSingleResult();
            System.out.println("Retrieved user:" + retrievedUser);
        } catch(Exception e) {
            System.out.println("Problema en UserDAO: " + e);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        System.out.println("Retrieved user:" + retrievedUser);
        return retrievedUser;
    }

    @Override
    public List<User> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<User> retrievedUsers = null;
        try {
            retrievedUsers = em.createNamedQuery("User.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in UserDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedUsers;
    }

    @Override
    public User searchById(Object id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        User user = null;
        try {
            user = em.find(User.class, (Integer)id);
        } catch (Exception e) {
            System.err.println("Problems in UserDAO.searchById(): " + e);
        } finally {
            em.close();
        }
        return user;
    }

    
    public User searchByUsername(String username){
        
        EntityManager em = EntityManagerProvider.createEntityManager();
        User user = null;
        Query q = em.createNamedQuery("User.findByUsername");
        q.setParameter("username", username);
        try{
            user = (User)q.getSingleResult();
        }catch(Exception e){
         e.printStackTrace();
         System.out.println(e);
        }finally{
            em.close();
        }
        return user;
    }
    
    @Override
    public boolean create(User newUser) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newUser);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in UserDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Object id, User editedUser) {
        User tmpUser;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpUser = em.merge(this.searchById(id));
            tmpUser.setPassword(editedUser.getPassword());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in UserDAO.update(): " + e);
            em.getTransaction().rollback();
            isSuccessful = false;
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
    public void editPassword(String id, String newPassword) {
        User retrievedUser = this.searchById(id);
        retrievedUser.setPassword(newPassword);
        this.update(id, retrievedUser);
    }

    @Override
    public boolean delete(Object id) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        User delUser = this.searchById(id);
        em.getTransaction().begin();
        try {
            em.remove(delUser);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in UserDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
}
