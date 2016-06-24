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
public class JobDataObject_Full {

    private int job_ID;
    private int job_Number;
    private int job_NumberIndex;
    private EmployerDataObject job_Manager;
    private CustomerDataObject job_Customer;
    private String job_TM;
    private String job_KindString;
    private StatusCheckDataObject job_StatusCheck = null;
    private EmployerDataObject job_Designer = null;
    private ComboBoxDataObject job_TypeOfWork = null;
    private ComboBoxDataObject job_Difficulty = null;

    public JobDataObject_Full(int job_ID, int job_Number, int job_NumberIndex,
                              EmployerDataObject job_Manager, CustomerDataObject job_Customer,
                              String job_TM, String job_KindString) {
        this.job_ID = job_ID;
        this.job_Number = job_Number;
        this.job_NumberIndex = job_NumberIndex;
        this.job_Manager = job_Manager;
        this.job_Customer = job_Customer;
        this.job_TM = job_TM;
        this.job_KindString = job_KindString;
    }

    public int getJob_ID() {
        return job_ID;
    }

    public void setJob_ID(int job_ID) {
        this.job_ID = job_ID;
    }

    public int getJob_Number() {
        return job_Number;
    }

    public void setJob_Number(int job_Number) {
        this.job_Number = job_Number;
    }

    public int getJob_NumberIndex() {
        return job_NumberIndex;
    }

    public void setJob_NumberIndex(int job_NumberIndex) {
        this.job_NumberIndex = job_NumberIndex;
    }

    public EmployerDataObject getJob_Manager() {
        return job_Manager;
    }

    public void setJob_Manager(EmployerDataObject job_Manager) {
        this.job_Manager = job_Manager;
    }

    /**
     * Get the value of job_KindString
     *
     * @return the value of job_KindString
     */
    public String getJob_KindString() {
        return job_KindString;
    }

    /**
     * Set the value of job_KindString
     *
     * @param job_KindString new value of job_KindString
     */
    public void setJob_KindString(String job_KindString) {
        this.job_KindString = job_KindString;
    }

    /**
     * Get the value of job_Difficulty
     *
     * @return the value of job_Difficulty
     */
    public ComboBoxDataObject getJob_Difficulty() {
        return job_Difficulty;
    }

    /**
     * Set the value of job_Difficulty
     *
     * @param job_Difficulty new value of job_Difficulty
     */
    public void setJob_Difficulty(ComboBoxDataObject job_Difficulty) {
        this.job_Difficulty = job_Difficulty;
    }

    /**
     * Get the value of job_TypeOfWork
     *
     * @return the value of job_TypeOfWork
     */
    public ComboBoxDataObject getJob_TypeOfWork() {
        return job_TypeOfWork;
    }

    /**
     * Set the value of job_TypeOfWork
     *
     * @param job_TypeOfWork new value of job_TypeOfWork
     */
    public void setJob_TypeOfWork(ComboBoxDataObject job_TypeOfWork) {
        this.job_TypeOfWork = job_TypeOfWork;
    }

    /**
     * Get the value of job_Designer
     *
     * @return the value of job_Designer
     */
    public EmployerDataObject getJob_Designer() {
        return job_Designer;
    }

    /**
     * Set the value of job_Designer
     *
     * @param job_Designer new value of job_Designer
     */
    public void setJob_Designer(EmployerDataObject job_Designer) {
        this.job_Designer = job_Designer;
    }

    /**
     * Get the value of job_StatusCheck
     *
     * @return the value of job_StatusCheck
     */
    public StatusCheckDataObject getJob_StatusCheck() {
        return job_StatusCheck;
    }

    /**
     * Set the value of job_StatusCheck
     *
     * @param job_StatusCheck new value of job_StatusCheck
     */
    public void setJob_StatusCheck(StatusCheckDataObject job_StatusCheck) {
        this.job_StatusCheck = job_StatusCheck;
    }

    /**
     * Get the value of job_TM
     *
     * @return the value of job_TM
     */
    public String getJob_TM() {
        return job_TM;
    }

    /**
     * Set the value of job_TM
     *
     * @param job_TM new value of job_TM
     */
    public void setJob_TM(String job_TM) {
        this.job_TM = job_TM;
    }

    /**
     * Get the value of job_Customer
     *
     * @return the value of job_Customer
     */
    public CustomerDataObject getJob_Customer() {
        return job_Customer;
    }

    /**
     * Set the value of job_Customer
     *
     * @param job_Customer new value of job_Customer
     */
    public void setJob_Customer(CustomerDataObject job_Customer) {
        this.job_Customer = job_Customer;
    }

    @Override
    public String toString() {
        return "ТЗ№-" + job_Number + ((job_NumberIndex==0)  ? "" : ("/"+job_NumberIndex)) + "; " + job_Manager.getEmp_SurName() + "; " + job_Customer.getCust_Name()+ "; " + job_TM + "; " + job_KindString + '.';
    }

    public String toStringHTML() {
        return "<html>ТЗ№-" + job_Number + ((job_NumberIndex==0)  ? "" : ("/"+job_NumberIndex)) + "; " + job_Manager.getEmp_SurName() + "; <br>" + job_Customer.getCust_Name()+ "; " + job_TM + "; " + job_KindString + ".</html>";
    }
}
