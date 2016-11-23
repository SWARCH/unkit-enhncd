/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.EmployeeDAO;
import co.unkitsolutions.accessdata.dao.UserDAO;
import co.unkitsolutions.accessdata.entity.Employee;
import co.unkitsolutions.accessdata.entity.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lorenags
 */
public class EmployeeController implements Serializable {

    private static final long serialVersionUID = 1L;
    public static int idUpdateEmployee;

    public String addEmployee(String userName, String name, String id, String gender, String role, String contracType, String salary, String password, String passwordC) {

        char gend[] = gender.toCharArray();
        User user = new User();
        Employee employee = new Employee();

        user.setId(Integer.parseInt(id));
        user.setPassword(password);
        user.setUsername(userName);

        employee.setUserId(Integer.parseInt(id));
        employee.setName(name);
        employee.setGender(gend[0]);
        employee.setRole(role);
        employee.setContractType(contracType);
        employee.setSalary(Double.parseDouble(salary));
        employee.setContractStatus("active");

        UserDAO userDAO = new UserDAO();

        if (userDAO.searchByUsername(userName) == null) {
            if (userDAO.searchById(id) == null) {
                if (password.equals(passwordC) == true) {
                    EmployeeDAO employeeDAO = new EmployeeDAO();
                    userDAO.create(user);
                    employeeDAO.create(employee);
                    return "La cuenta del empleado se creó exitosamente";
                } else {
                    return "Las contraseñas no coinciden";
                }
            } else {
                return "El número de identificación ya está registrado";
            }
        } else {
            return "El nombre de ususario ya existe";
        }
    }

    public int updateEmployee(String name, String salary) {

        Employee employee = new Employee();

        employee.setName(name);
        employee.setSalary(Double.parseDouble(salary));

        EmployeeDAO employeeDAO = new EmployeeDAO();
        List<Employee> employees;
        employees = employeeDAO.searchAll();
        int idEmployee = employees.get(idUpdateEmployee).getUserId();

        if (employeeDAO.update(idEmployee, employee) == true) {
            return idEmployee;
        } else {
            return 0;
        }
    }

    public boolean deleteEmployee(int idEmployee) {
        System.out.println("DELETE EMPLOYEE");
        boolean isSuccesfull = false;
        EmployeeDAO employeeDAO = new EmployeeDAO();
        UserDAO userDAO = new UserDAO();

        if (employeeDAO.delete(idEmployee) == true) {
            if (userDAO.delete(idEmployee) == true) {
                isSuccesfull = true;
                return isSuccesfull;
            }
        }

        return isSuccesfull;
    }

    public void setIdEmployee(int idEmployee) {
        idUpdateEmployee = idEmployee;
    }

    public int getIdEmployee() {
        return idUpdateEmployee;
    }

}
