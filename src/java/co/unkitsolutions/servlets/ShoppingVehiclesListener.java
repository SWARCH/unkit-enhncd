/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.servlets;

import co.unkitsolutions.accessdata.entity.Vehicle;
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
public class ShoppingVehiclesListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ArrayList<Vehicle> vehiclesToBuy = new ArrayList<>();
        session.setAttribute("vehiclesToBuy", vehiclesToBuy);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }
    
    
}
