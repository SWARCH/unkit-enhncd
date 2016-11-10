/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.presentation.bean;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

/**
 * A simple bean for the User entity
 * @author mauricio
 */
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    @Resource
    private SessionContext sessionContext;

    public UserBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
