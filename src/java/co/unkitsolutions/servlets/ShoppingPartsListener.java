/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.accessdata.entity.Part;
import java.util.ArrayList;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author mauricio
 */
@WebListener
public class ShoppingPartsListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ArrayList<Part> partsToBuy = new ArrayList<>();
        //partsToBuy.add(new Part("0", "null", 0.0));
        session.setAttribute("partsToBuy", partsToBuy);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }
    
}
