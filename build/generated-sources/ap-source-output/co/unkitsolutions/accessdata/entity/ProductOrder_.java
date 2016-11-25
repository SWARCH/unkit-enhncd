package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.Customer;
import co.unkitsolutions.accessdata.entity.OrderPart;
import co.unkitsolutions.accessdata.entity.OrderVehicle;
import co.unkitsolutions.accessdata.entity.ProductOrderPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T06:22:04")
@StaticMetamodel(ProductOrder.class)
public class ProductOrder_ { 

    public static volatile SingularAttribute<ProductOrder, Date> date;
    public static volatile ListAttribute<ProductOrder, OrderPart> orderPartList;
    public static volatile SingularAttribute<ProductOrder, ProductOrderPK> productOrderPK;
    public static volatile SingularAttribute<ProductOrder, Double> orderCost;
    public static volatile SingularAttribute<ProductOrder, Date> deliveryDate;
    public static volatile ListAttribute<ProductOrder, OrderVehicle> orderVehicleList;
    public static volatile SingularAttribute<ProductOrder, Customer> customer;

}