/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import java.util.List;

/**
 *
 * @author mauricio
 * @param <T>
 */
public interface DAO<T> {
    
    public List<T> searchAll();
    public T searchById(String id);
    public boolean create(T newObject);
    public boolean update(String id, T editedObject);
    public boolean delete(String id);
    
}
