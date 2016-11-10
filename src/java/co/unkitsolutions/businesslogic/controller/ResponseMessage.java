/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unkitsolutions.businesslogic.controller;

import java.io.Serializable;

/**
 *
 * @author mauricio
 */
public class ResponseMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success;
    private String errorMessage;
    private Double data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }
    
    
    
}
