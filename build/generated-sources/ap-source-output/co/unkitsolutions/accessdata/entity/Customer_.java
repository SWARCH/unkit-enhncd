package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.ProductOrder;
import co.unkitsolutions.accessdata.entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-10T17:08:28")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> tradeName;
    public static volatile ListAttribute<Customer, ProductOrder> productOrderList;
    public static volatile SingularAttribute<Customer, String> type;
    public static volatile SingularAttribute<Customer, Integer> userId;
    public static volatile SingularAttribute<Customer, User> user;

}