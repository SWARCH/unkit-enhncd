package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.Employee;
import co.unkitsolutions.accessdata.entity.GroupTable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T06:22:04")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, GroupTable> groupTableList;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, Employee> employee;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Customer> customer;

}