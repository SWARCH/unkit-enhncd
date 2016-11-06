/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.PartDAO;
import co.unkitsolutions.accessdata.entity.Part;

/**
 *
 * @author lorenags
 */
public class PartController {
    
    public int addPart(String name, String description, String cost, String units){
                
        Part part = new Part();
        
        part.setId(part.hashCode());
        part.setName(name);
        part.setDescription(description);
        part.setCost(Double.parseDouble(cost));
        part.setUnits(Integer.parseInt(units));
        
        PartDAO partDAO = new PartDAO();
        
        if (partDAO.create(part)== true){
            return part.getId();
        }else{
            return 0;
        }
    }
    
}
