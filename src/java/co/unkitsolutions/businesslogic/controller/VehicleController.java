/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import co.unkitsolutions.accessdata.dao.VehicleDAO;
import co.unkitsolutions.accessdata.entity.Vehicle;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lorenags
 */
public class VehicleController implements Serializable {

    private static final long serialVersionUID = 1L;
    public static int idUpdateVehicle;

    public int addVehicle(String tradeMark, String model, String description, String color, String cost, String units) {

        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicle.hashCode());
        vehicle.setTrademark(tradeMark);
        vehicle.setModel(Integer.parseInt(model));
        vehicle.setDescription(description);
        vehicle.setColor(color);
        vehicle.setCost(Double.parseDouble(cost));
        vehicle.setUnits(Integer.parseInt(units));

        VehicleDAO vehicleDAO = new VehicleDAO();

        if (vehicleDAO.create(vehicle) == true) {
            return vehicle.getId();
        } else {
            return 0;
        }
    }

    public int updateVehicle(String tradeMark, String model, String description, String color, String cost, String units) {
        System.out.println("UPDATE Vehicle");
        System.out.println("ESTE ES EL COLOR controlador: " + color);
        
        Vehicle vehicle = new Vehicle();

        vehicle.setId(idUpdateVehicle);
        vehicle.setTrademark(tradeMark);
        vehicle.setModel(Integer.parseInt(model));
        vehicle.setDescription(description);
        vehicle.setColor(color);
        vehicle.setCost(Double.parseDouble(cost));
        vehicle.setUnits(Integer.parseInt(units));

        VehicleDAO vehicleDAO = new VehicleDAO();
        List<Vehicle> vehicles;
        vehicles = vehicleDAO.searchAll();
        int idVehicle = vehicles.get(idUpdateVehicle).getId();

        if (vehicleDAO.update(idVehicle, vehicle) == true) {
            return idVehicle;
        } else {
            return 0;
        }
    }

    public void setIdVehicle(int idVehicle) {
        idUpdateVehicle = idVehicle;
    }

    public int getIdVehicle() {
        return idUpdateVehicle;
    }
}
