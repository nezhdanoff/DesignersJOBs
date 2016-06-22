/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobsfordesigners;

/**
 *
 * @author Ed
 */
public class CustomerDataObject {

    private int     cust_ID;
    private String  cust_Alias;
    private String  cust_Name;

    CustomerDataObject(
            int ID,
            String Alias,
            String Name
    ) {
        this.cust_ID = ID;
        this.cust_Alias = Alias;
        this.cust_Name = Name;
    }

    public void setCust_ID(int ID) {
        this.cust_ID = ID;
    }

    public void setCust_Alias(String Alias) {
        this.cust_Alias = Alias;
    }

    public void setCust_Name(String Name) {
        this.cust_Name = Name;
    }
    public int getCust_ID() {
        return this.cust_ID;
    }
    public String getCust_Alias() {
        return this.cust_Alias;
    }

    public String getCust_Name() {
        return this.cust_Name;
    }
    @Override
    public String toString(){
        return this.cust_Alias + " (" + this.cust_Name + ")";
    }
}
