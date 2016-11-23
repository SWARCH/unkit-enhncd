package co.unkitsolutions.accessdata.entity;

import co.unkitsolutions.accessdata.entity.OrderPart;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-10T17:08:28")
@StaticMetamodel(Part.class)
public class Part_ { 

    public static volatile ListAttribute<Part, OrderPart> orderPartList;
    public static volatile SingularAttribute<Part, Double> cost;
    public static volatile SingularAttribute<Part, String> name;
    public static volatile SingularAttribute<Part, String> description;
    public static volatile SingularAttribute<Part, Integer> id;
    public static volatile SingularAttribute<Part, Integer> units;

}