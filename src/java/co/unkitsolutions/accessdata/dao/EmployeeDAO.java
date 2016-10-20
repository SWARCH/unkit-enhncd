/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Employee;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class EmployeeDAO {
    public static final String MANAGER_ROLE = "manager";
    public static final String MANUFACTURER_ROLE = "manufacturer";
    public static final String ASSEMBLER_ROLE = "assembler";
    
    public Employee searchByUserId(String userId) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Employee employee = null;
        try {
            employee = em.find(Employee.class, userId);
        } catch (Exception e) {
            System.err.println("Problems in EmployeeDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return employee;
    }
    
}
