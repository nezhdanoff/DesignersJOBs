/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 @author Nezhdanoff
 */
public class Object_NowWorkJob extends Object_NotFinishedJob {

    private Timestamp j_Start;

    public Object_NowWorkJob(int j_ID, int j_num, int j_index, String j_NumIdx, Timestamp j_Data, String j_Manager, String j_Customer, String j_TM, int j_NumOfKind, String j_Kinds, int j_StatusID, String j_Status, String j_Type, int j_DifficultyID, String j_Difficulty, int j_DesignerID, String j_Designer, int j_Min, int j_Max, int j_StageID, String j_StageName, long j_WorkingTime, Timestamp j_Start) {
        super(j_ID, j_num, j_index, j_NumIdx, j_Data, j_Manager, j_Customer, j_TM, j_NumOfKind, j_Kinds, j_StatusID, j_Status, j_Type, j_DifficultyID, j_Difficulty, j_DesignerID, j_Designer, j_Min, j_Max, j_StageID, j_StageName, j_WorkingTime);
        this.j_Start = j_Start;
    }

    public Object_NowWorkJob(ResultSet rs) {
        super(rs);

        try {
            this.j_Start  = rs.getTimestamp("j_Start");
        } catch (SQLException ex) {
            Logger.getLogger(Object_NowWorkJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Timestamp getJ_Start() {
        return j_Start;
    }

    public void setJ_Start(Timestamp j_Start) {
        this.j_Start = j_Start;
    }

    public String getJ_StartString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yy");

        return dateFormat.format(j_Start);
    }
}
