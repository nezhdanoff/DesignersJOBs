/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 @author Nezhdanoff
 */
public class Object_NotFinishedJob {

    private int     j_ID;
    private int     j_num;
    private int     j_index;
    private String  j_NumIdx;
    private Timestamp j_Data;
    private String  j_Manager;
    private String  j_Customer;
    private String  j_TM;
    private int     j_NumOfKind;
    private String  j_Kinds;
    private int     j_StatusID;
    private String  j_Status;
    private String  j_Type;
    private int     j_DifficultyID;
    private String  j_Difficulty;
    private int     j_DesignerID;
    private String  j_Designer;
    private int     j_Min;
    private int     j_Max;
    private int     j_StageID;
    private String  j_StageName;
    private long    j_WorkingTime;

    public Object_NotFinishedJob(int j_ID,
                                 int j_num,
                                 int j_index,
                                 String j_NumIdx,
                                 Timestamp j_Data,
                                 String j_Manager,
                                 String j_Customer,
                                 String j_TM,
                                 int j_NumOfKind,
                                 String j_Kinds,
                                 int j_StatusID,
                                 String j_Status,
                                 String j_Type,
                                 int j_DifficultyID,
                                 String j_Difficulty,
                                 int j_DesignerID,
                                 String j_Designer,
                                 int j_Min,
                                 int j_Max,
                                 int j_StageID,
                                 String j_StageName,
                                 long j_WorkingTime) {
        this.j_ID = j_ID;
        this.j_num = j_num;
        this.j_index = j_index;
        this.j_NumIdx = j_NumIdx;
        this.j_Data = j_Data;
        this.j_Manager = j_Manager;
        this.j_Customer = j_Customer;
        this.j_TM = j_TM;
        this.j_NumOfKind = j_NumOfKind;
        this.j_Kinds = j_Kinds;
        this.j_StatusID = j_StatusID;
        this.j_Status = j_Status;
        this.j_Type = j_Type;
        this.j_DifficultyID = j_DifficultyID;
        this.j_Difficulty = j_Difficulty;
        this.j_DesignerID = j_DesignerID;
        this.j_Designer = j_Designer;
        this.j_Min = j_Min;
        this.j_Max = j_Max;
        this.j_StageID = j_StageID;
        this.j_StageName = j_StageName;
        this.j_WorkingTime = j_WorkingTime;
    }
public Object_NotFinishedJob(java.sql.ResultSet rs) {

        try {
            this.j_ID = rs.getInt("j_ID");
            this.j_num = rs.getInt("j_num");
            this.j_index = rs.getInt("j_index");
            this.j_NumIdx = rs.getString("j_NumIdx");
            this.j_Data = rs.getTimestamp("j_Data");
            this.j_Manager = rs.getString("j_Manager");
            this.j_Customer = rs.getString("j_Customer");
            this.j_TM = rs.getString("j_TM");
            this.j_NumOfKind = rs.getInt("j_NumOfKind");
            this.j_Kinds = rs.getString("j_Kinds");
            this.j_StatusID = rs.getInt("j_StatusID");
            this.j_Status = rs.getString("j_Status");
            this.j_Type = rs.getString("j_Type");
            this.j_DifficultyID = rs.getInt("j_DifficultyID");
            this.j_Difficulty = rs.getString("j_Difficulty");
            this.j_DesignerID = rs.getInt("j_DesignerID");
            this.j_Designer = rs.getString("j_Designer");
            this.j_Min = rs.getInt("j_Min");
            this.j_Max = rs.getInt("j_Max");
            this.j_StageID = rs.getInt("j_StageID");
            this.j_StageName = rs.getString("j_StageName");
            this.j_WorkingTime = rs.getLong("j_WorkingTime");
        } catch (SQLException ex) {
            Logger.getLogger(Object_NotFinishedJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getJ_ID() {
        return j_ID;
    }

    public void setJ_ID(int j_ID) {
        this.j_ID = j_ID;
    }

    public int getJ_num() {
        return j_num;
    }

    public void setJ_num(int j_num) {
        this.j_num = j_num;
    }

    public int getJ_index() {
        return j_index;
    }

    public void setJ_index(int j_index) {
        this.j_index = j_index;
    }

    public String getJ_NumIdx() {
        return j_NumIdx;
    }

    public void setJ_NumIdx(String j_NumIdx) {
        this.j_NumIdx = j_NumIdx;
    }

    public Timestamp getJ_Data() {
        return j_Data;
    }

    public void setJ_Data(Timestamp j_Data) {
        this.j_Data = j_Data;
    }

    public String getJ_Manager() {
        return j_Manager;
    }

    public void setJ_Manager(String j_Manager) {
        this.j_Manager = j_Manager;
    }

    public String getJ_Customer() {
        return j_Customer;
    }

    public void setJ_Customer(String j_Customer) {
        this.j_Customer = j_Customer;
    }

    public String getJ_TM() {
        return j_TM;
    }

    public void setJ_TM(String j_TM) {
        this.j_TM = j_TM;
    }

    public int getJ_NumOfKind() {
        return j_NumOfKind;
    }

    public void setJ_NumOfKind(int j_NumOfKind) {
        this.j_NumOfKind = j_NumOfKind;
    }

    public String getJ_Kinds() {
        return j_Kinds;
    }

    public void setJ_Kinds(String j_Kinds) {
        this.j_Kinds = j_Kinds;
    }

    public int getJ_StatusID() {
        return j_StatusID;
    }

    public void setJ_StatusID(int j_StatusID) {
        this.j_StatusID = j_StatusID;
    }

    public String getJ_Status() {
        return j_Status;
    }

    public void setJ_Status(String j_Status) {
        this.j_Status = j_Status;
    }

    public String getJ_Type() {
        return j_Type;
    }

    public void setJ_Type(String j_Type) {
        this.j_Type = j_Type;
    }

    public int getJ_DifficultyID() {
        return j_DifficultyID;
    }

    public void setJ_DifficultyID(int j_DifficultyID) {
        this.j_DifficultyID = j_DifficultyID;
    }

    public String getJ_Difficulty() {
        return j_Difficulty;
    }

    public void setJ_Difficulty(String j_Difficulty) {
        this.j_Difficulty = j_Difficulty;
    }

    public int getJ_DesignerID() {
        return j_DesignerID;
    }

    public void setJ_DesignerID(int j_DesignerID) {
        this.j_DesignerID = j_DesignerID;
    }

    public String getJ_Designer() {
        return j_Designer;
    }

    public void setJ_Designer(String j_Designer) {
        this.j_Designer = j_Designer;
    }

    public int getJ_Min() {
        return j_Min;
    }

    public void setJ_Min(int j_Min) {
        this.j_Min = j_Min;
    }

    public int getJ_Max() {
        return j_Max;
    }

    public void setJ_Max(int j_Max) {
        this.j_Max = j_Max;
    }

    public int getJ_Average() {
        return (j_Min + j_Max)/2;
    }

    public int getJ_StageID() {
        return j_StageID;
    }

    public void setJ_StageID(int j_StageID) {
        this.j_StageID = j_StageID;
    }

    public String getJ_StageName() {
        return j_StageName;
    }

    public void setJ_StageName(String j_StageName) {
        this.j_StageName = j_StageName;
    }

    public long getJ_WorkingTime() {
        return j_WorkingTime;
    }

    public void setJ_WorkingTime(long j_WorkingTime) {
        this.j_WorkingTime = j_WorkingTime;
    }


}
