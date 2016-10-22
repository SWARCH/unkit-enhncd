/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.accessdata.dao;

import co.unkitsolutions.accessdata.entity.Part;
import java.util.List;

/**
 *
 * @author mauricio
 */
public class PartDAO {
    
    public List<Part> searchAll() {
        List<Part> parts =
                EntityManagerProvider.createEntityManager()
                .createNamedQuery("Part.findAll")
                .getResultList();
        return parts;
    }
    
}
