/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.User;
import co.unkitsolutions.presentation.bean.UserBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author mauricio
 */
public class UserDAO {
    private final EntityManager entityManager = 
            EntityManagerProvider.createEntityManager();
    
    public boolean isValid(UserBean userBean) {
        User retrievedUser;
        String username = userBean.getUsername();
        String password = userBean.getPassword();
        String strQuery = "SELECT u FROM User u WHERE "
                + "u.username = :username AND u.password = :password";
        Query query = entityManager.createQuery(strQuery)
                .setParameter("username", username)
                .setParameter("password", password);
        retrievedUser = (User) query.getSingleResult();
        return retrievedUser == null;
    }
    
}
