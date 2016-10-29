/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Employee;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author mauricio
 */
public class EmployeeDAO implements DAO<Employee>, Serializable {

    @Override
    public List<Employee> searchAll() {
        EntityManager em = EntityManagerProvider.createEntityManager();
        List<Employee> retrievedEmployees = null;
        try {
            retrievedEmployees = em.createNamedQuery("Employee.findAll")
                .getResultList();
        } catch(Exception e) {
            System.err.println("Problems in EmployeeDAO.searchAll(): " + e);
        } finally {
            em.close();
        }
        return retrievedEmployees;
    }

    @Override
    public Employee searchById(Object id) {
        EntityManager em = EntityManagerProvider.createEntityManager();
        Employee employee = null;
        try {
            employee = em.find(Employee.class, (Integer)id);
        } catch (Exception e) {
            System.err.println("Problems in EmployeeDAO.searchByUserId(): " + e);
        } finally {
            em.close();
        }
        return employee;
    }

    @Override
    public boolean create(Employee newEmployee) {
        boolean isSuccessful = false;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newEmployee);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in employeeDAO.create(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }

    @Override
    public boolean update(Object id, Employee editedEmployee) {
        Employee tmpEmployee;
        boolean isSuccessful = true;
        EntityManager em = EntityManagerProvider.createEntityManager();
        em.getTransaction().begin();
        try {
            tmpEmployee = em.merge(this.searchById(id));
            
            tmpEmployee.setName(editedEmployee.getName());
            tmpEmployee.setGender(editedEmployee.getGender());
            tmpEmployee.setRole(editedEmployee.getRole());
            tmpEmployee.setSalary(editedEmployee.getSalary());
            tmpEmployee.setContractStatus(editedEmployee.getContractStatus());
            tmpEmployee.setContractType(editedEmployee.getContractType());
            
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Problems in EmployeeDAO.update(): " + e);
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
        Employee delEmployee = this.searchById(id);
        UserDAO userDAO = new UserDAO();
        em.getTransaction().begin();
        try {
            em.remove(delEmployee);
            userDAO.delete(id);
            em.getTransaction().commit();
            isSuccessful = true;
        } catch (Exception e) {
            System.err.println("Problems in EmployeeDAO.delete(): " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return isSuccessful;
    }
    
}
