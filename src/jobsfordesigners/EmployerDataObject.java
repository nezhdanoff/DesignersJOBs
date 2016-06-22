/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

/**
 *
 * @author Nezhdanoff
 */
class EmployerDataObject {

    private int     emp_ID;
    private String  emp_SurName;
    private String  emp_Name;
    private String  emp_EMail;

    public EmployerDataObject(int emp_ID, String emp_SurName, String emp_Name, String emp_EMail) {
        this.emp_ID = emp_ID;
        this.emp_SurName = emp_SurName;
        this.emp_Name = emp_Name;
        this.emp_EMail = emp_EMail;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public void setEmp_SurName(String emp_SurName) {
        this.emp_SurName = emp_SurName;
    }

    public void setEmp_Name(String emp_Name) {
        this.emp_Name = emp_Name;
    }

    public void setEmp_EMail(String emp_EMail) {
        this.emp_EMail = emp_EMail;
    }

    public int getEmp_ID() {
        return emp_ID;
    }

    public String getEmp_SurName() {
        return emp_SurName;
    }

    public String getEmp_Name() {
        return emp_Name;
    }

    public String getEmp_EMail() {
        return emp_EMail;
    }

    @Override
    public String toString() {
        return emp_SurName + " " + emp_Name;
    }

}
