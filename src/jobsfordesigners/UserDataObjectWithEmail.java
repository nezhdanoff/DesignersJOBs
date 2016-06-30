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
public class UserDataObjectWithEmail extends UserDataObject{

    private String emp_EMail;

    public UserDataObjectWithEmail(int i_emp_ID,
                                   String i_emp_Surname,
                                   String i_emp_Name,
                                   String i_emp_Mname,
                                   String emp_EMail,
                                   int i_dep_ID,
                                   String i_dep_Name,
                                   int i_pos_ID,
                                   String i_pos_Name) {
        super(null, null, i_emp_ID, i_emp_Surname, i_emp_Name, i_emp_Mname, i_dep_ID, i_dep_Name, i_pos_ID, i_pos_Name, 1);
        this.emp_EMail = emp_EMail;
    }

    public int getField1(){
        return this.getEmp_ID();
    }

    /**
     * Get the value of emp_EMail
     *
     * @return the value of emp_EMail
     */
    public String getEmp_EMail() {
        return emp_EMail;
    }

    /**
     * Set the value of emp_EMail
     *
     * @param emp_EMail new value of emp_EMail
     */
    public void setEmp_EMail(String emp_EMail) {
        this.emp_EMail = emp_EMail;
    }
}
