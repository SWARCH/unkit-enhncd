package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.OrderVehiclePK;
import co.unkitsolutions.accessdata.entity.ProductOrder;
import co.unkitsolutions.accessdata.entity.Vehicle;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-23T06:22:04")
@StaticMetamodel(OrderVehicle.class)
public class OrderVehicle_ { 

    public static volatile SingularAttribute<OrderVehicle, Integer> quantity;
    public static volatile SingularAttribute<OrderVehicle, ProductOrder> productOrder;
    public static volatile SingularAttribute<OrderVehicle, OrderVehiclePK> orderVehiclePK;
    public static volatile SingularAttribute<OrderVehicle, Vehicle> vehicle;

}