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
public class UserDataObject {
    private String   login;
    private String   password;
    private int      emp_ID;
    private String   emp_Surname;
    private String   emp_Name;
    private String   emp_Mname;
    private int      dep_ID;
    private String   dep_Name;
    private int      pos_ID;
    private String   pos_Name;
    private int      priv_ID;



public UserDataObject(
         String   i_login,
         String   i_password,
         int      i_emp_ID,
         String   i_emp_Surname,
         String   i_emp_Name,
         String   i_emp_Mname,
         int      i_dep_ID,
         String   i_dep_Name,
         int      i_pos_ID,
         String   i_pos_Name,
         int      i_Priv_ID
    ){
    this.login          =i_login;
    this.password       =i_password;
    this.emp_ID         =i_emp_ID;
    this.emp_Surname    =i_emp_Surname;
    this.emp_Name       =i_emp_Name;
    this.emp_Mname      =i_emp_Mname;
    this.dep_ID         =i_dep_ID;
    this.dep_Name       =i_dep_Name;
    this.pos_ID         =i_pos_ID;
    this.pos_Name       =i_pos_Name;
    this.priv_ID        =i_Priv_ID;
}
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String str){
        this.login = str;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String str){
        this.password = str;
    }
    public int getEmp_ID(){
        return this.emp_ID;
    }
    public void setEmp_ID(int ID){
        this.emp_ID = ID;
    }
    public String getEmp_Surname(){
        return this.emp_Surname;
    }
    public void setEmp_Surname(String str){
        this.emp_Surname = str;
    }
    public String getEmp_Name(){
        return this.emp_Name;
    }
    public void setEmp_Name(String str){
        this.emp_Name = str;
    }
    public String getEmp_Mname(){
        return this.emp_Mname;
    }
    public void setEmp_Mname(String str){
        this.emp_Mname = str;
    }
    public int getDep_ID(){
        return this.dep_ID;
    }
    public void setDep_ID(int ID){
        this.dep_ID = ID;
    }
    public String getDep_Name(){
        return this.dep_Name;
    }
    public void setDep_Name(String str){
        this.dep_Name = str;
    }
    public int getPos_ID(){
        return this.pos_ID;
    }
    public void setPos_ID(int ID){
        this.pos_ID = ID;
    }
    public String getPos_Name(){
        return this.pos_Name;
    }
    public void setPos_Name(String str){
        this.pos_Name = str;
    }
    public int getPriv_ID(){
        return this.priv_ID;
    }
    public void setPriv_ID(int ID){
        this.priv_ID = ID;
    }

    @Override
    public String toString() {

        if (this.emp_Mname != null){
            return this.emp_Surname + ' ' + this.emp_Name + ' ' + this.emp_Mname;
        } else {
            return this.emp_Surname + ' ' + this.emp_Name;
        }
   }

}
