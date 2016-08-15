/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itak.designers.job;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**

 @author Nezhdanoff
 */
public class TablePopUP  extends JPopupMenu {
      public TablePopUP(final JTable table) {
         JMenuItem itemDetails = new JMenuItem("Подробности");
         JMenuItem itemClose = new JMenuItem("Завершить этап");
         itemDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               System.out.println("Подробности");
               if (table.getSelectedRowCount() == 1) {
                        int selectedRow = table.getSelectedRow();
                        TableModel model = table.getModel();
                         String str = ((TableModel_NowWork)model).getHTMLString(selectedRow);
                        JOptionPane.showMessageDialog(null, str);
                    } else {
//                        JOptionPane.showMessageDialog(null, "Выделено больше одной строки");
                    }

            }
         });
         itemClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               System.out.println("Завершить этап");
               if (table.getSelectedRowCount() == 1) {
                        int selectedRow = table.getSelectedRow();
                        TableModel model = table.getModel();
                         int jobID = ((TableModel_NowWork)model).getJobIdAT(selectedRow);
                        if (JOptionPane.showConfirmDialog(null,
                                                          "Это действие завершит сеанс выбранного пользователя в сети.\n"
                                                          + "Время выполнения заказа будет остановлено.\n"
                                                          + "Вы действительно хотите ЗАВЕРШИТЬ это ТЗ ?",
                                                          "Подтверждение",
                                                          YES_NO_OPTION) == JOptionPane.YES_OPTION) closeActiveJob(jobID);
                    } else {
//                        JOptionPane.showMessageDialog(null, "Выделено больше одной строки");
                    }
            }
         });

         add(itemDetails);
         add(new JSeparator());
         add(itemClose);
      }

     void closeActiveJob(int jobID) {

        // Закрываем запись в журнале TimeLine с Идентификатором jobID
        int time_line_ID;

        ConnectDB conn = new ConnectDB(I_DB.SERVER, I_DB.USER, I_DB.PASSWORD, I_DB.BASE);
        conn.init();
        String Query = "SELECT "
                + "tlj.time_line_ID AS ID "
                + "FROM time_line_jornal tlj "
                + "WHERE tlj.is_finished = 0 "
                + "AND tlj.job_ID = "
                + jobID;
        ResultSet rs = conn.query(Query);
        try {
            if (rs.next()) {
                time_line_ID = rs.getInt("ID");
//                    JOptionPane.showMessageDialog(null, "Завершаем ТЗ!!!");
                    String Query1 = "UPDATE designer_time_line dtl "
                            + " SET dtl.stop = NOW(), "
                            + " dtl.trouble = 1 "
                            + " WHERE dtl.ID = "
                            + time_line_ID;
                    conn.updateQuery(Query1);
                }
        } catch (SQLException ex) {
            Logger.getLogger(jFrame_JOB_Jornal.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.close();
    }
}
