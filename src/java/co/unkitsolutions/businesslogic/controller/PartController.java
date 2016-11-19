/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.PartDAO;
import co.unkitsolutions.accessdata.entity.Part;
import java.util.List;

/**
 *
 * @author lorenags
 */
public class PartController {

    public static int idUpdatePart;

    public int addPart(String name, String description, String cost, String units) {

        Part part = new Part();

        part.setId(part.hashCode());
        System.out.println("ID NUEVO: " + part.hashCode());
        part.setName(name);
        part.setDescription(description);
        part.setCost(Double.parseDouble(cost));
        part.setUnits(Integer.parseInt(units));

        PartDAO partDAO = new PartDAO();

        if (partDAO.create(part) == true) {
            return part.getId();
        } else {
            return 0;
        }
    }

    public int updatePart(String name, String description, String cost, String units) {

        System.out.println("UPDATE PART");
        
        Part part = new Part();
        
        part.setId(idUpdatePart);
        part.setName(name);
        part.setDescription(description);
        part.setCost(Double.parseDouble(cost));
        part.setUnits(Integer.parseInt(units));

        PartDAO partDAO = new PartDAO();
        List<Part> parts;
        parts = partDAO.searchAll();
        int idPart = parts.get(idUpdatePart).getId();

        if (partDAO.update(idPart, part) == true) {
            return idPart;
        } else {
            return 0;
        }
    }
    
    public boolean deletePart(int idPart){
        
       System.out.println("DELETE PART");
       boolean isSuccesfull = false;
       PartDAO partDAO = new PartDAO();
        /*List<Part> parts;
        parts = partDAO.searchAll();
        int idPart = parts.get(idDeletePart).getId();*/

        if (partDAO.delete(idPart) == true) {
            isSuccesfull = true;
            return isSuccesfull;
        } 
        
        return isSuccesfull;
    }

    public void setIdPart(int idPart) {
        idUpdatePart = idPart;
    }

    public int getIdPart() {
        return idUpdatePart;
    }
}
