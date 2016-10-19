/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A factory that returns the EntityManager object.
 * @author mauricio
 */
public class EntityManagerProvider {
    public static final String LOCAL_PERSISTENCE_UNIT  = "UNKITLPU";
    public static final String REMOTE_PERSISTENCE_UNIT = "UNKITRPU";
    
    public static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = 
                Persistence.createEntityManagerFactory(LOCAL_PERSISTENCE_UNIT);
        return entityManagerFactory.createEntityManager();
    }
}
