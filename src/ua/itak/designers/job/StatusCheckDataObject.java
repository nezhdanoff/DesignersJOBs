/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

/**
 *
 * @author Nezhdanoff
 */
class StatusCheckDataObject {

    private int status_ID;
    private String status_Name;

    public StatusCheckDataObject(int status_ID,
                                 String status_Name) {
        this.status_ID = status_ID;
        this.status_Name = status_Name;
    }


    /**
     * Get the value of status_ID
     *
     * @return the value of status_ID
     */
    public int getStatus_ID() {
        return status_ID;
    }

    /**
     * Set the value of status_ID
     *
     * @param status_ID new value of status_ID
     */
    public void setStatus_ID(int status_ID) {
        this.status_ID = status_ID;
    }

    /**
     * Get the value of status_Name
     *
     * @return the value of status_Name
     */
    public String getStatus_Name() {
        return status_Name;
    }

    /**
     * Set the value of status_Name
     *
     * @param status_Name new value of status_Name
     */
    public void setStatus_Name(String status_Name) {
        this.status_Name = status_Name;
    }

}
