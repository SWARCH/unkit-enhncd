package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T06:22:04")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> role;
    public static volatile SingularAttribute<Employee, String> contractStatus;
    public static volatile SingularAttribute<Employee, Character> gender;
    public static volatile SingularAttribute<Employee, String> contractType;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, Double> salary;
    public static volatile SingularAttribute<Employee, Integer> userId;
    public static volatile SingularAttribute<Employee, User> user;

}