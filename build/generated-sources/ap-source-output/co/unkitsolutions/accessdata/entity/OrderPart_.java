package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.OrderPartPK;
import co.unkitsolutions.accessdata.entity.Part;
import co.unkitsolutions.accessdata.entity.ProductOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-10T17:08:28")
@StaticMetamodel(OrderPart.class)
public class OrderPart_ { 

    public static volatile SingularAttribute<OrderPart, Integer> quantity;
    public static volatile SingularAttribute<OrderPart, Part> part;
    public static volatile SingularAttribute<OrderPart, ProductOrder> productOrder;
    public static volatile SingularAttribute<OrderPart, OrderPartPK> orderPartPK;

}