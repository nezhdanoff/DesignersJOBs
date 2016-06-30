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
public class NotCheckedJobList_DataObject {
    private int job_ID;
    private String job_Info;
    private String job_Status;

    NotCheckedJobList_DataObject(
            int ID,
            String Info,
            String Status
    ) {
        this.job_ID = ID;
        this.job_Info = Info;
        if (Status == null) this.job_Status ="Не проверено";
        else this.job_Status = Status;
    }

    public int job_ID() {
        return this.job_ID;
    }
    public String getjob_Info() {
        return this.job_Info;
    }

    public String getjob_Status() {
        return this.job_Status;
    }
    @Override
    public String toString(){
        return this.job_Status + " - " + this.job_Info;
    }
}
