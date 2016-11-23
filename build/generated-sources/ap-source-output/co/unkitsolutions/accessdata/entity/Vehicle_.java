package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.OrderVehicle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-10T17:08:28")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, Double> cost;
    public static volatile SingularAttribute<Vehicle, String> color;
    public static volatile SingularAttribute<Vehicle, String> description;
    public static volatile SingularAttribute<Vehicle, String> trademark;
    public static volatile SingularAttribute<Vehicle, Integer> model;
    public static volatile SingularAttribute<Vehicle, Integer> id;
    public static volatile SingularAttribute<Vehicle, Integer> units;
    public static volatile ListAttribute<Vehicle, OrderVehicle> orderVehicleList;

}